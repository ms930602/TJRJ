<template>
	<div>
	<div>
		<el-form ref="searchForm" :model="searchForm"  >
			<!-- 查询条件 -->
			<searchInputItems>
				<searchInputItem name="规格名">
					<inputItem :value.sync="searchForm.specificationname" ></inputItem>
					</searchInputItem>
				<searchInputItem name="统计时间">
							<!--<dateEditorDaterange :dateValue.sync="searchForm.shipmentNumber" type="date" style="width: 200px;"></dateEditorDaterange>
							-->
							<dateEditorDaterange :dateValue.sync="searchForm.statisticaltime" style="width: 300px;"/>
				</searchInputItem>


      </searchInputItems>
		</el-form>

    <optionItems>
			<template slot="left">
				<el-button-group>
					<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
					<iconBtn iconClass="el-icon-refresh" content="重置Excel" @click="reset">导出Excel</iconBtn>
				</el-button-group>				
			</template>
		</optionItems>
	</div>
   
		<div>
			<el-card class="box-card">
      <div slot="header" class="clearfix">
        <div style="float:left">
          <span>库存统计</span>
          <p class="ct-title-text">统计7天内库存</p>
        </div>
        <!-- <selectInput :value.sync="statusB" @selectChange="searchTableB" style="float:right;width:100px" >
          <el-option
              v-for="item in dayOption"
              :key="item.key"
              :label="item.value"
              :value="item.key">
            </el-option>
        </selectInput> -->
      </div>
      <div id="CWarnDiv" style="height:300px;"></div>
    </el-card>
			
		</div>

	</div>
  
</template>

<script>
import mixin from "../../mixin/mixin.js";
import local from "../../local.js";
import configs from "../../configs.js";
export default {
  mixins: [mixin],
  data() {
    return {
      searchForm: {
        specificationname: "",
        statisticaltime: "",
			},
			CWarnChars:null,
    };
  },
  mounted() {
		//this.searchTable();
		this.initWarning();
		//this.searchWarning(7);
  },
  methods: {

		searchTable(){

					console.log(this.searchForm.shipmentNumber)
					 
					var params = {'specificationname': JSON.stringify(this.searchForm.specificationname),
											'startTime' : JSON.stringify(this.searchForm.statisticaltime == null ? '' : this.searchForm.statisticaltime[0]),
											'endTime': JSON.stringify(this.searchForm.statisticaltime == null ? '' : this.searchForm.statisticaltime[1])}

				  this._ajax({
              url: this.rootAPI,
              name: "cigaretteEntry/saveEntryDetailOrder",
              param: params
            }).then(
              (d => {
                if (d.state == 0) {
                  //this.getentrymainorder(d.aaData)
                  
                } else {
                  this.$message({
                    type: "warning",
                    message: "保存失败" // + d.msg
                  });
                }
              }).bind(this)
            );
		},

    searchWarning(day){
      this._ajax({url: this.rootAPI + 'cigaretteEntry/aa?day='+day})
        .then((function(d) {
            if(d.state === 0) {
              var xRow = [];
              var one = [],two = [],three = [];
              d.aaData.forEach(temp=>{
                xRow.push(temp.ss.replace(" 00:00:00",""))
                one.push(temp.counts)
							})
							
						/*	
              d.aaData.two.forEach(temp=>{
                two.push(temp.counts)
              })
              d.aaData.three.forEach(temp=>{
                three.push(temp.counts)
              })*/
              var option = {
                xAxis: {
                    data: xRow
                },
                series: [
                    {
                        data:one
										}
										/*
										,
										
                    {
                        data:two
                    },
                    {
                        data:three
                    } */
                ]
              }
              this.CWarnChars.setOption(option);
            }else
            {
              this.$message({ type: "error", message: "服务器错误!" });
            }
        }).bind(this))
    },

		initWarning(){
      this.CWarnChars = echarts.init(document.getElementById("CWarnDiv"));
      var option = {
          tooltip: {
              trigger: 'axis'
          },
          legend: {
              data:['1','2','3']
          },
          grid: {
              left: '3%',
              right: '4%',
              bottom: '3%',
              containLabel: true
          },
          toolbox: {
              feature: {
                  saveAsImage: {}
              }
          },
          xAxis: {
              type: 'category',
              boundaryGap: false,
              data: ['前6天','前5天','前4天','前3天','前2天','前1天','今天']
          },
          yAxis: {
              type: 'value',
              minInterval: 1
          },
          series: [
              {
                  name:'1',
                  type:'line',
                  stack: '总量1',
                  data:[1,2,3]
              },
              {
                  name:'2',
                  type:'line',
                  stack: '总量2',
                  data:[1,1,1]
              },
              {
                  name:'3',
                  type:'line',
                  stack: '总量3',
                  data:[1,2,2]
              }
          ]
      };

      this.CWarnChars.setOption(option);
		},
		
		reset() {
		},
  }
};
</script>
