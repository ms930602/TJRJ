<template>
	<div>
	<div>
		<el-form ref="searchForm" :model="searchForm"  >
			<!-- 查询条件 -->
			<searchInputItems>

				<searchInputItem name="统计时间">
              	<dateEditorDaterange :dateValue.sync="searchForm.statisticaltime" type="date" style="width: 200px;"></dateEditorDaterange>
				</searchInputItem>
      </searchInputItems>
		</el-form>

    <optionItems>
			<template slot="left">
				<el-button-group>
					<iconBtn iconClass="el-icon-search" content="查询" @click="searchecharts">查询</iconBtn>
					<!--<iconBtn iconClass="el-icon-refresh" content="重置" @click="reset">重置</iconBtn>-->
          <iconBtn iconClass="el-icon-download" content="导出全部库存" @click="exportEx">导出excel</iconBtn>
				</el-button-group>				
			</template>
		</optionItems>
	</div>
   
		<div>
			<el-card class="box-card">
      <div slot="header" class="clearfix">
        <div style="float:left">
          <span>入库统计</span>
          <p class="ct-title-text">统计一天内每种规格的烟入库数量</p>
        </div>
      </div>
      <div id="CWarnDiv" style="height:300px;"></div>
    </el-card>
			
		</div>


<!--
		<div>
			<el-card class="box-card">
      <div slot="header" class="clearfix">
        <div style="float:left">
          <span>入库统计</span>
          <p class="ct-title-text">统计一天内每种规格的烟入库数量1111</p>
        </div>
      </div>
      <div id="CWarnDiv1" style="height:300px;"></div>
    </el-card>			
		</div> -->
   <div>
      <el-card class="box-card">
      <div slot="header" class="clearfix">
					<elemTable :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange">
					  						
							<el-table-column prop="materCode" label="物料编码">
					    	<template slot-scope="scope">
					    		<toolTip :content="scope.row.materCode">
					    			<span>{{scope.row.materCode}}</span>
					    		</toolTip>
					      	</template>
					    </el-table-column>
						  


					 		<el-table-column prop="materCigbrand" label="物料品牌">
					    	<template slot-scope="scope">
					    		<toolTip :content="scope.row.materCigbrand">
					    			<span>{{scope.row.materCigbrand}}</span>
					    		</toolTip>
					      	</template>
					    </el-table-column>



							<el-table-column prop="materName" label="物料名称">
					    	<template slot-scope="scope">
					    		<toolTip :content="scope.row.materName">
					    			<span>{{scope.row.materName}}</span>
					    		</toolTip>
					      	</template>
					    </el-table-column>


						<el-table-column prop="materVersion" label="物料版本">
					    	<template slot-scope="scope">
					    		<toolTip :content="scope.row.materVersion">
					    			<span>{{scope.row.materVersion}}</span>
					    		</toolTip>
					      	</template>
					    </el-table-column>


							<el-table-column prop="subverName" label="子版本">
					    	<template slot-scope="scope">
					    		<toolTip :content="scope.row.subverName">
					    			<span>{{scope.row.subverName}}</span>
					    		</toolTip>
					      	</template>
					    </el-table-column>

							<el-table-column prop="value" label="当天入库数量">
					    	<template slot-scope="scope">
					    		<toolTip :content="scope.row.value">
					    			<span>{{scope.row.value}}</span>
					    		</toolTip>
					      	</template>
					    </el-table-column>
					</elemTable>

            <div id="exclTable" style="display: none;">
              <el-table :data="gridData" ref='ces' border style="width: 100%" height="250" :span-method="objectSpanMethod" border :row-class-name="tableRowClassName">
                <el-table-column prop="materCode" class='ces' label="物料编码" width="180"></el-table-column>
                <el-table-column prop="materCigbrand" label="物料品牌" width="180"></el-table-column>
                <el-table-column prop="materName" label="物料名称" width="180"></el-table-column>
                <el-table-column prop="materVersion" label="物料版本" width="180"></el-table-column>
                <el-table-column prop="subverName" label="子版本" width="180"></el-table-column>
                <el-table-column prop="value" label="当天入库数量" width="180"></el-table-column>
              </el-table>
            </div>

        </div>
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
        statisticaltime: moment(Date.parse(new Date())).format("YYYY-MM-DD"),
			},
      CWarnChars:null,
      CWarnChars1:null,
      	InMapPtions: [],
				spanArr: [],
				pos: 0,
				spanArrD: [],
				posD: 0,
				colorArr: [],
				gridData: [],
				gridForm: {},
				multipleSelection: [],
    };
  },
  mounted() {
	
		this.initWarning();
    //this.searchWarning(7);
      this.searchecharts();
      //this.initWarning1();
  },
  methods: {

		searchecharts(){

				  //console.log(this.searchForm.shipmentNumber)                   
          debugger;          
          var params = {'statisticaltime' : this.searchForm.statisticaltime}

				  this._ajax({
              url: this.rootAPI,
              name: "entrysStatistics/queryEntryCounts",
              param: params
            }).then(
              (d => {
              if (d.state == 0) {
              var legenddata = [];
              var  sedata = d.aaData;
              //dataList  = d.aaData;
              d.aaData.forEach(temp=>{
                legenddata.push(temp.name)
							})							
              var option = {
                legend: {
                    data: legenddata
                },
                series: [
                    {
                        data:sedata
										}
                ]
              }
              this.CWarnChars.setOption(option);                  
              } else {
                  this.$message({ type: "error", message: "服务器错误!" });
              }

              this.searchTable();

              }).bind(this)
            );
    },
    

			searchTable() {
        console.log(this.searchForm.statisticaltime) 
        debugger;  
				Object.assign(this.searchForm, {
					pageNum: this.pageNum,
					pageSize: this.pageSize
				});
				return this._ajax({
					url: this.rootAPI,
					name: "entrysStatistics/list",
					param: this.searchForm,
					loading: "dataLoading"
				}).then(this.renderTable);
			},



		initWarning(){
      this.CWarnChars = echarts.init(document.getElementById("CWarnDiv"));
      var option = {
          title : {
              text: '每种规格的烟当天入库的数量',
              //subtext: '纯属虚构',
              x:'center'
          },
          tooltip : {
              trigger: 'item',
              formatter: "{a} <br/>{b} : {c} ({d}%)"
          },
          legend: {
              orient : 'vertical',
              x : 'left',
              data:['','','','','']
          },
          toolbox: {
              show : true,
              feature : {
                  mark : {show: true},
                  dataView : {show: true, readOnly: false},
                  magicType : {
                      show: true, 
                      type: ['pie', 'funnel'],
                      option: {
                          funnel: {
                              x: '25%',
                              width: '50%',
                              funnelAlign: 'left',
                              max: 1548
                          }
                      }
                  },
                  restore : {show: true},
                  saveAsImage : {show: true}
              }
          },
          calculable : true,
          series : [
              {
                  name:'访问来源',
                  type:'pie',
                  radius : '55%',
                  center: ['50%', '60%'],
                  data:[
                      {value:'', name:''},
                      {value:'', name:''},
                      {value:'', name:''},
                      {value:'', name:''},
                      {value:'', name:''}
                  ]
              }
                  ]
      };

      this.CWarnChars.setOption(option);
    },
    
    		initWarning1(){
      this.CWarnChars1 = echarts.init(document.getElementById("CWarnDiv1"));
       


       var  option = {
        tooltip : {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow',
                label: {
                    show: true
                }
            }
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        legend: {
            data:['Growth', 'Budget 2011', 'Budget 2012'],
            itemGap: 5
        },
        grid: {
            top: '12%',
            left: '1%',
            right: '10%',
            containLabel: true
        },
        xAxis: [
            {
                type : 'category',
                data : ''
            }
        ],
        yAxis: [
            {
                type : 'value',
                name : 'Budget (million USD)',
                axisLabel: {
                    formatter: function (a) {
                        a = +a;
                        return isFinite(a)
                            ? echarts.format.addCommas(+a / 1000)
                            : '';
                    }
                }
            }
        ],
        dataZoom: [
            {
                show: true,
                start: 94,
                end: 100
            },
            {
                type: 'inside',
                start: 94,
                end: 100
            },
            {
                show: true,
                yAxisIndex: 0,
                filterMode: 'empty',
                width: 30,
                height: '80%',
                showDataShadow: false,
                left: '93%'
            }
        ],
        series : [
            {
                name: 'Budget 2011',
                type: 'bar',
                data: ''
            },
            {
                name: 'Budget 2012',
                type: 'bar',
                data: ''
            }
        ]
    };

  
      this.CWarnChars1.setOption(option);
		},
		
		reset() {
    },
    
    	exportEx() {
        ///Object.assign(this.searchForm.statisticaltime, {})
         //var params = {'statisticaltime' : this.searchForm.statisticaltime}
         Object.assign(this.gridForm, {statisticaltime :this.searchForm.statisticaltime})
				return this._ajax({
					url: this.rootAPI,
					name: "entrysStatistics/queryEntryCounts",
					param: this.gridForm,
					loading: "dataLoading"
				}).then(function(d) {
					this.gridData = d.aaData;
					this.spanArr = [];
					this.spanArrD = [];
					this.colorArr = [];
					this.getSpanArr(d.aaData);
					this.$nextTick(() => {
						for(let a = 0; a < this.$refs.ces.$el.children[2].children[0].children[1].children.length; a++) {
							var mso = this.$refs.ces.$el.children[2].children[0].children[1].children[a].children;
							for(var i = 0; i < mso.length; i++) {
								mso[i].setAttribute("style", "mso-number-format:'\@';")
							}
						}
					})
					this.$nextTick(() => {
						this.exportExOK();
					})
				}.bind(this));
      },


      	exportExOK() {
				var filename = "入库统计"
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
			},
  }
};
</script>
