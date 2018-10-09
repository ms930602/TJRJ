<template>
	<div>
	<div>
		<el-form ref="searchForm" :model="searchForm"  >
			<!-- 查询条件 -->
			<searchInputItems>
				<searchInputItem name="统计时间">
							<el-date-picker
                v-model="statisticaltime"
                type="daterange"
                range-separator="至"
                value-format="yyyy-MM-dd"
                start-placeholder="开始日期"
                end-placeholder="结束日期">
              </el-date-picker>
				</searchInputItem>


      </searchInputItems>
		</el-form>

    <optionItems>
			<template slot="left">
				<el-button-group>
					<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
					<iconBtn iconClass="el-icon-refresh" content="Excel" @click="exportEx">导出Excel</iconBtn>
          <iconBtn iconClass="el-icon-refresh" content="重置" @click="reset">重置</iconBtn>
				</el-button-group>				
			</template>
		</optionItems>
	</div>
   
		<div>
			<el-card class="box-card">
      <div id="CWarnDiv" style="height:300px;"></div>
    </el-card>
			
		</div>
    <div id="exclTable">
    <el-table
      :data="dataList"
      style="width: 100%">
      <el-table-column prop="materName" label="物料名称" width="150px">
        <template slot-scope="scope">
          <toolTip :content="scope.row.materName">
            <span>{{scope.row.materName}}</span>
          </toolTip>
        </template>
      </el-table-column>
      <el-table-column prop="materCode" label="物料编码">
        <template slot-scope="scope">
          <toolTip :content="scope.row.materCode">
            <span>{{scope.row.materCode}}</span>
          </toolTip>
        </template>
      </el-table-column>
      <el-table-column prop="subverName" label="小版本名称">
        <template slot-scope="scope">
          <toolTip :content="scope.row.subverName">
            <span>{{scope.row.subverName}}</span>
          </toolTip>
        </template>
      </el-table-column>
      <el-table-column prop="sumActualCountQuality" label="调整数量">
        <template slot-scope="scope">
          <toolTip :content="scope.row.sumActualCountQuality">
            <span>{{scope.row.sumActualCountQuality}}</span>
          </toolTip>
        </template>
      </el-table-column>
    </el-table>
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
      statisticaltime:[],
      searchForm: {
        startTime:'',
        endTime:''
			},
			CWarnChars:null,
    };
  },
  mounted() {
    this.statisticaltime.push(this._dateFormat({date:new Date(),type:"YYYY-MM-DD"}))
    this.statisticaltime.push(this._dateFormat({date:new Date(),type:"YYYY-MM-DD"}))
		this.searchTable();
		this.initWarning();
		//this.searchWarning(7);
  },
  methods: {
    searchTable() {

      var param = {
        startTime:this.statisticaltime[0],
        endTime:this.statisticaltime[1]
      }
        return this._ajax({
          url: this.rootAPI,
          name: "home/queryStockcheckCountBy",
          param: param,
          loading: "dataLoading"
        }).then(this.renderTable).then(this.searchWarning);
    },
    searchWarning(){
       var xRow = [];
       var one = [];
       this.dataList.forEach(temp=>{
          xRow.push(temp.materName+"|"+temp.subverName)
          one.push({value:temp.sumActualCountQuality, name:temp.materName+"|"+temp.subverName})
       })
        var option = {
          legend: {
              data: xRow
          },
          series: [
              {
                  data:one
              }
          ]
        }
        this.CWarnChars.setOption(option);
    },

		initWarning(){
      this.CWarnChars = echarts.init(document.getElementById("CWarnDiv"));
      var option = {
          tooltip : {
              trigger: 'item',
              formatter: "{a} <br/>{b} : {c} ({d}%)"
          },
          legend: {
              x : 'center',
              y : 'bottom',
              data:[]
          },
          toolbox: {
              show : true,
              feature : {
                  mark : {show: true},
                  dataView : {show: true, readOnly: false},
                  magicType : {
                      show: true,
                      type: ['pie', 'funnel']
                  },
                  restore : {show: true},
                  saveAsImage : {show: true}
              }
          },
          calculable : true,
          series : [
              {
                  name:'面积模式',
                  type:'pie',
                  radius : [30, 110],
                  roseType : 'area',
                  data:[]
              }
          ]
      };

      this.CWarnChars.setOption(option);
		},
		
		reset() {
      this.statisticaltime = []
		},
    exportEx() {
        this.spanArr = [];
        this.spanArrD = [];
        this.colorArr = [];
        this.getSpanArr(this.dataList);
        this.$nextTick(() => {
          this.exportExOK();
        })
      },
      getSpanArr(data) {　
        for(var i = 0; i < data.length; i++) {
          if(i === 0) {
            this.spanArr.push(1);
            this.pos = 0
          } else {
            // 判断当前元素与上一个元素是否相同
            if(data[i].id === data[i - 1].id) {
              this.spanArr[this.pos] += 1;
              this.spanArr.push(0);
            } else {
              this.spanArr.push(1);
              this.pos = i;
            }
          }
        }　
        for(var i = 0; i < data.length; i++) {
          if(i === 0) {
            this.spanArrD.push(1);
            this.posD = 0
          } else {
            // 判断当前元素与上一个元素是否相同
            if(data[i].detailId === data[i - 1].detailId) {
              this.spanArrD[this.posD] += 1;
              this.spanArrD.push(0);
            } else {
              this.spanArrD.push(1);
              this.posD = i;
            }
          }
        }　
        for(var i = 0; i < data.length; i++) {
          if(i === 0) {
            this.colorArr.push(0);
          } else {
            // 判断当前元素与上一个元素是否相同
            if(data[i].id === data[i - 1].id) {
              this.colorArr.push(this.colorArr[i - 1]);
            } else {
              if(this.colorArr[i - 1] === 1) {
                this.colorArr.push(0);
              } else {
                this.colorArr.push(1);
              }
            }
          }
        }
      },exportExOK() {
        var filename = "盘点统计"
        var html = "<html><head><meta charset='utf-8' /><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name></x:Name><x:WorksheetOptions><x:Selected/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body>" + document.getElementById("exclTable").outerHTML + "</body></html>";
        var blob = new Blob([html], {
          type: "application/vnd.ms-excel"
        });
        var aurl = URL.createObjectURL(blob);
        var link = document.createElement('a')
        link.setAttribute('href', aurl)
        link.setAttribute('download', filename)
        document.body.appendChild(link)
        link.click()
        document.body.removeChild(link)
      },
  }
};
</script>
