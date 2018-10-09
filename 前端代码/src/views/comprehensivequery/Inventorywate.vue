<template>
	<div>
		<el-form ref="searchForm" :model="searchForm">
			<!-- 查询条件 -->
			<searchInputItems>
				<searchInputItem name="物料编号">
					<inputItem :value.sync="searchForm.materCode"></inputItem>
				</searchInputItem>
				<searchInputItem name="物料名称">
					<inputItem :value.sync="searchForm.materName"></inputItem>
				</searchInputItem>
				<searchInputItem name="批次号">
					<inputItem :value.sync="searchForm.batchNo"></inputItem>
				</searchInputItem>
				<searchInputItem name="类型">
				<selectInput :value.sync="searchForm.type" @selectChange="searchTable" :clearable="true">
					<el-option
				      v-for="item in optionStatus"
				      :key="item.key"
				      :label="item.label"
				      :value="item.value">
				    </el-option>
				</selectInput>
			</searchInputItem>
			</searchInputItems>
		</el-form>
		<optionItems>
			<template slot="left">
				<el-button-group>
					<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
					<iconBtn iconClass="el-icon-refresh" content="重置" @click="reset">重置</iconBtn>
					<iconBtn iconClass="el-icon-download" content="导出选中流水" @click="exportSomeEx">导出选中流水</iconBtn>
					<iconBtn iconClass="el-icon-download" content="导出全部流水" @click="exportEx">导出全部流水</iconBtn>
				</el-button-group>
			</template>
		</optionItems>
		<elemTable :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange" @selectionChange="selectionChange">
			<el-table-column type="selection" width="55"></el-table-column>
			<el-table-column prop="materCode" label="物料编码" fixed="left" width="150px">
				<template slot-scope="scope">
					<toolTip :content="scope.row.materCode">
						<span>{{scope.row.materCode}}</span>
					</toolTip>
				</template>
			</el-table-column>
			<el-table-column prop="materName" label="物料名称" fixed="left"  width="200px">
				<template slot-scope="scope">
					<toolTip :content="scope.row.materName">
						<span>{{scope.row.materName}}</span>
					</toolTip>
				</template>
			</el-table-column>
			<el-table-column prop="materCigbrand" label="物料品牌" fixed="left" width="150px">
				<template slot-scope="scope">
					<toolTip :content="scope.row.materCigbrand">
						<span>{{scope.row.materCigbrand}}</span>
					</toolTip>
				</template>
			</el-table-column>
			<el-table-column prop="materVersion" label="物料版本"  width="200px">
				<template slot-scope="scope">
					<toolTip :content="scope.row.materVersion">
						<span>{{scope.row.materVersion}}</span>
					</toolTip>
				</template>
			</el-table-column>
			
				<el-table-column prop="cigtype" label="卷烟类型">
				<template slot-scope="scope">
					<toolTip :content="_dicValue(scope.row.cigtype, InMapPtions)">
						<tagItem type="success" :text="_dicValue(scope.row.cigtype, InMapPtions)"></tagItem>
		    			<!-- <span>{{_dicValue(scope.row.cigtype, InMapPtions)}}</span> -->
		    	   </toolTip>
				</template>
			</el-table-column>
			<el-table-column prop="batchNo" label="批次号" width="120px">
				<template slot-scope="scope">
					<toolTip :content="scope.row.batchNo">
						<span>{{scope.row.batchNo}}</span>
					</toolTip>
				</template>
			</el-table-column>
			
			<el-table-column prop="type" label="流水类型" width="90px">
				<template slot-scope="scope">
					 <toolTip :content="_dicValue(scope.row.type, InFlowptions)">
						 <tagItem type="warning" :text="_dicValue(scope.row.type, InFlowptions)"></tagItem>
		    	     </toolTip>
				</template>
			</el-table-column>
			<el-table-column prop="quality" label="数量(件)" width="90px">
				<template slot-scope="scope">
					<toolTip :content="scope.row.quality">
						<span>{{scope.row.quality}}</span>
					</toolTip>
				</template>
			</el-table-column>
			<!-- <el-table-column prop="trayCode" label="托盘编号">
				<template slot-scope="scope">
					<toolTip :content="scope.row.trayCode">
						<span>{{scope.row.trayCode}}</span>
					</toolTip>
				</template>
			</el-table-column> -->
			<el-table-column prop="entryOrder" label="入库单号" width="110px">
				<template slot-scope="scope">
					<toolTip :content="scope.row.entryOrder">
						<span>{{scope.row.entryOrder}}</span>
					</toolTip>
				</template>
			</el-table-column>
			<el-table-column prop="entryUnit" label="入库单位" width="200px">
				<template slot-scope="scope">
					<toolTip :content="scope.row.entryUnit">
						<span>{{scope.row.entryUnit}}</span>
					</toolTip>
				</template>
			</el-table-column>
			<el-table-column prop="outOrder" label="出库单号" width="110px">
				<template slot-scope="scope">
					<toolTip :content="scope.row.outOrder">
						<span>{{scope.row.outOrder}}</span>
					</toolTip>
				</template>
			</el-table-column>
			<el-table-column prop="outUnit" label="出库单位"  width="200px">
				<template slot-scope="scope">
					<toolTip :content="scope.row.outUnit">
						<span>{{scope.row.outUnit}}</span>
					</toolTip>
				</template>
			</el-table-column>
		    <el-table-column prop="subverName" label="子版本名称" width="150px">
				<template slot-scope="scope">
					<toolTip :content="scope.row.subverName">
						<span>{{scope.row.subverName}}</span>
					</toolTip>
				</template>
			</el-table-column>
			<el-table-column prop="createdDate" label="创建时间" width="150px">
				<template slot-scope="scope">
					<toolTip :content="scope.row.createdDate">
						<span>{{scope.row.createdDate}}</span>
					</toolTip>
				</template>
			</el-table-column>
		</elemTable>
		<passmodal v-if="modalShow" :modaltype="modalType" :passTypeNooptions="passTypeNooptions" @close="modalClose" :modalshow='modalShow' @submit="modalSubmit" :tableRow='modalObj'></passmodal>
		    <div id="exclTable" style="display: none;">
				<el-table :data="gridData" ref='ces'  border style="width: 100%" height="250" :span-method="objectSpanMethod" border :row-class-name="tableRowClassName">
					<el-table-column prop="materCode" class='ces' label="物料编号" width="180">
					</el-table-column>
					<el-table-column prop="materName" label="物料名称" width="180"></el-table-column>
					<el-table-column prop="materVersion" label="物料版本" width="180"></el-table-column>
					<el-table-column prop="materCigbrand" label="物料品牌" width="180"></el-table-column>
					<el-table-column prop="batchNo" label="批次号" width="180"></el-table-column>
					<el-table-column prop="type" label="类型" width="180">
						<template slot-scope="scope">
							<toolTip :content="_dicValue(scope.row.type, InFlowptions)">
				    			<span>{{_dicValue(scope.row.type, InFlowptions)}}</span>
				    	    </toolTip>
						</template>
					</el-table-column>
					<el-table-column prop="quality" label="数量(件)" width="180"></el-table-column>
					<el-table-column prop="trayCode" label="托盘编号" width="180"></el-table-column>
					<el-table-column prop="entryOrder" label="入库单" width="180"></el-table-column>
					<el-table-column prop="entryUnit" label="入库单位" width="180"></el-table-column>
					<el-table-column prop="outOrder" label="出库单" width="180"></el-table-column>
					<el-table-column prop="outUnit" label="出库单位" width="180"></el-table-column>
					<el-table-column prop="outUnit" label="卷烟类型" width="180">
						<template slot-scope="scope">
							<toolTip :content="_dicValue(scope.row.cigtype, InMapPtions)">
				    			<span>{{_dicValue(scope.row.cigtype, InMapPtions)}}</span>
				    	   </toolTip>
						</template>
					</el-table-column>
					<el-table-column prop="subverName" label="子版本名称" width="180"></el-table-column>
					<el-table-column prop="createdDate" label="创建时间" width="180"></el-table-column>
				</el-table>
			</div>
    </div>
</template>

<script>
	import mixin from "../../mixin/mixin.js";
	import local from "../../local.js";
	import passmodal from "../component/modal/passwayModal.vue";
	export default {
		mixins: [mixin],
		components: {
			passmodal
		},
		data() {
			return {
				multipleSelection: [],
				gridData: [],
				gridForm: {},
				InFlowptions: [],
				searchForm: {
					materName: "",
					materCode: "",
					batchNo: "",
					typel:""
				},
				optionStatus: [{
						value: '0',
						label: '入库'
						},{
						value: '1',
						label: '出库'
						}]
			};
		},
		mounted() {
			this.getflowTypeNo().then(
			  (d => {
			    this.searchTable();
			  }).bind(this)
			);
			this.getMapTrialNo().then(
			  (d => {
			  }).bind(this)
			);
		},
		methods: {

		    /**
		     * 获取字典类型
		     */
		    getflowTypeNo() {
		      return this._searchDic("IN_FLOW_TYPE").then(
		        function(d) {
		          this.InFlowptions = this._dicKey(d);
		        }.bind(this)
		      );
		    },
		    getMapTrialNo() {
		      return this._searchDic("MATERIAL_TYPE").then(
		        function(d) {
		          this.InMapPtions = this._dicKey(d);
		        }.bind(this)
		      );
		    },
			searchTable() {
				Object.assign(this.searchForm, {
					pageNum: this.pageNum,
					pageSize: this.pageSize
				});
				return this._ajax({
					url: this.rootAPI,
					name: "inventoryflow/list",
					param: this.searchForm,
					loading: "dataLoading"
				}).then(this.renderTable);
			},
			reset() {
				Object.assign(this.searchForm, {
					materCode: "",
					materName: "",
					batchNo: ""
				});
				this.searchTable();
			},
            selectionChange(val){
            	this.multipleSelection = val;
            },
            exportSomeEx(){
            	this.gridData = [];
            	this.gridData = this.multipleSelection;
            	if(this.gridData.length==0){
            		this.$message.error('请先选中要导出的数据');
            		return;
            	}
				this.$nextTick(() => {
					for(let a = 0; a < this.$refs.ces.$el.children[2].children[0].children[1].children.length; a++) {
						var mso=this.$refs.ces.$el.children[2].children[0].children[1].children[a].children;
						for (var i=0;i<mso.length;i++) {
						   mso[i].setAttribute("style", "mso-number-format:'\@';")
						}
					}
				})
			    this.$nextTick(() => {
				    this.exportExOK();
			    })
            },
			exportEx() {
				Object.assign(this.gridForm, {})
				return this._ajax({
					url: this.rootAPI,
					name: "inventoryflow/list",
					param: this.gridForm,
					loading: "dataLoading"
				}).then(function(d) {
					this.gridData = [];
					this.gridData = d.aaData;
					this.$nextTick(() => {
						for(let a = 0; a < this.$refs.ces.$el.children[2].children[0].children[1].children.length; a++) {
							var mso=this.$refs.ces.$el.children[2].children[0].children[1].children[a].children;
							for (var i=0;i<mso.length;i++) {
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
				var filename = "库存流水"
				var html = "<html><head><meta charset='utf-8' /></head><body>" + document.getElementById("exclTable").outerHTML + "</body></html>";
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
			}
		}
	};
</script>