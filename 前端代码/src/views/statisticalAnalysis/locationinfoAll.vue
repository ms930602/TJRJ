<template>
	<div>
	<div>

    <optionItems>
			<template slot="left">
				<el-button-group>
					<iconBtn iconClass="el-icon-search" content="查询" @click="searchWarning">刷新</iconBtn>
					<iconBtn iconClass="el-icon-refresh" content="重置Excel" @click="exportEx">导出Excel</iconBtn>
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
      :data="dataListAll"
      :row-class-name="tableRowClassName"
      style="width: 100%">
      <el-table-column prop="floorAreaCode" label="楼层区域编号" width="150px">
        <template slot-scope="scope">
          <toolTip :content="scope.row.floorAreaCode">
            <span>{{scope.row.floorAreaCode}}</span>
          </toolTip>
        </template>
      </el-table-column>
      <el-table-column prop="countQuality" label="数量" width="150px">
        <template slot-scope="scope">
          <toolTip :content="scope.row.countQuality">
            <span>{{scope.row.countQuality}}</span>
          </toolTip>
        </template>
      </el-table-column>
      <el-table-column prop="status" label="类型" width="150px">
        <template slot-scope="scope">
          <toolTip :content="scope.row.status">
            <span>{{scope.row.status == 0?'空闲':'占用'}}</span>
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
      searchForm: {
        specificationname: "",
        statisticaltime: "",
			},
      dataListAll:[],
			CWarnChars:null,
    };
  },
  mounted() {
		//this.searchTable();
		this.initWarning();
		this.searchWarning();
  },
  methods: {
    searchWarning(){
      this._ajax({url: this.rootAPI + 'home/queryLocationinfoAll'})
        .then((function(d) {
            if(d.state === 0) {
              var xRow = d.aaData.xTitle;
              this.dataListAll = d.aaData.dataList
              var one = d.aaData.kongXian,two = d.aaData.zhanYong;
              var option = {
                xAxis: {
                    data: xRow
                },
                series: [
                    {
                        data:one
										},
                    {
                        data:two
                    }
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
          color: ['#4cabce', '#e5323e'],
          tooltip: {
              trigger: 'axis',
              axisPointer: {
                  type: 'shadow'
              }
          },
          legend: {
              data: ['空闲', '占用']
          },
          toolbox: {
              show: false
          },
          calculable: true,
          xAxis: [
              {
                  type: 'category',
                  axisTick: {show: false},
                  data: []
              }
          ],
          yAxis: [
              {
                  type: 'value'
              }
          ],
          series: [
              {
                  name: '空闲',
                  type: 'bar',
                  barGap: 0,
                  data: []
              },
              {
                  name: '占用',
                  type: 'bar',
                  data: []
              }
          ]
      };

      this.CWarnChars.setOption(option);
		},
		
		reset() {
		},
    tableRowClassName({row, rowIndex}) {
        if (rowIndex % 2) {
          return 'warning-row';
        } else{
          return '';
        }
      },

    exportEx() {
        this.spanArr = [];
        this.spanArrD = [];
        this.colorArr = [];
        this.getSpanArr(this.dataListAll);
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
        var filename = "货位信息统计"
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
<style type="text/css">
  .el-table .warning-row {
    background: oldlace;
  }

  .el-table .success-row {
    background: #f0f9eb;
  }
</style>