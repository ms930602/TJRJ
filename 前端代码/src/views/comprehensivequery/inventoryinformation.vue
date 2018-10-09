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
				<searchInputItem name="物料版本">
					<inputItem :value.sync="searchForm.materVersion"></inputItem>
				</searchInputItem>
				<searchInputItem name="物料品牌">
					<inputItem :value.sync="searchForm.materCigbrand"></inputItem>
				</searchInputItem>
			</searchInputItems>

		</el-form>
		<optionItems>
			<template slot="left">
				<el-button-group>
					<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
					<iconBtn iconClass="el-icon-refresh" content="重置" @click="reset">重置</iconBtn>
					<iconBtn iconClass="el-icon-download" content="导出选中库存" @click="exportSomeEx">导出选中库存</iconBtn>
					<iconBtn iconClass="el-icon-download" content="导出全部库存" @click="exportEx">导出全部库存</iconBtn>
				</el-button-group>
			</template>
		</optionItems>

		<elemTable :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange" @selectionChange="selectionChange">
			<el-table-column type="selection" width="55"></el-table-column>
			<el-table-column prop="materCode" label="物料编号" width="150px">
				<template slot-scope="scope">
					<toolTip :content="scope.row.materCode">
						<span>{{scope.row.materCode}}</span>
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
			<el-table-column prop="materCigbrand" label="物料品牌">
				<template slot-scope="scope">
					<toolTip :content="scope.row.materCigbrand">
						<span>{{scope.row.materCigbrand}}</span>
					</toolTip>
				</template>
			</el-table-column>
			<el-table-column prop="totalCount" label="总库存数量(件)" width="150px">
				<template slot-scope="scope">
					<toolTip :content="scope.row.totalCount">
						<span>{{scope.row.totalCount}}</span>
					</toolTip>
				</template>
			</el-table-column>
			<el-table-column prop="lockStock" label="锁定库存(件)" width="150px">
				<template slot-scope="scope">
					<toolTip :content="scope.row.lockStock">
						<span>{{scope.row.lockStock}}</span>
					</toolTip>
				</template>
			</el-table-column>
			<el-table-column prop="availableStocks" label="可用库存(件)" width="150px">
				<template slot-scope="scope">
					<toolTip :content="scope.row.availableStocks">
						<span>{{scope.row.availableStocks}}</span>
					</toolTip>
				</template>
			</el-table-column>
			<el-table-column prop="cigtype" label="卷烟类型" width="120px">
				<template slot-scope="scope">
					<toolTip :content="_dicValue(scope.row.cigtype, InMapcPtions)">
						<tagItem type="success" :text="_dicValue(scope.row.cigtype, InMapcPtions)"></tagItem>
						<!-- <span>{{_dicValue(scope.row.cigtype, InMapcPtions)}}</span> -->
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
			<el-table-column label="操作" width="120px">
				<template slot-scope="scope">
					<el-button-group>
						<iconBtn iconClass="el-icon-view" content="查询库存详情" @click="queryInventory(scope.row)"></iconBtn>
					</el-button-group>
				</template>
			</el-table-column>
		</elemTable>
		<inventoryinformationModal v-if="modalShow" :modaltype="modalType" @close="modalClose" :modalshow='modalShow' @submit="modalSubmit" :tableRow='modalObj'></inventoryinformationModal>
		<div id="exclTable" style="display: none;">
			<el-table :data="gridData" ref='ces' border style="width: 100%" height="250" :span-method="objectSpanMethod" border :row-class-name="tableRowClassName">
				<el-table-column prop="materCode" class='ces' label="物料编号" width="180">
				</el-table-column>
				<el-table-column prop="materName" label="物料名称" width="180"></el-table-column>
				<el-table-column prop="materVersion" label="物料版本" width="180"></el-table-column>
				<el-table-column prop="materCigbrand" label="物料品牌" width="180"></el-table-column>
				<el-table-column prop="totalCount" label="总库存数量（件）" width="180"></el-table-column>
				<el-table-column prop="lockStock" label="锁定库存（件）" width="180"></el-table-column>
				<el-table-column prop="availableStocks" label="可用库存（件）" width="180"></el-table-column>
				<el-table-column prop="subverName" label="子版本名称" width="180"></el-table-column>
				<el-table-column prop="outUnit" label="卷烟类型" width="180">
					<template slot-scope="scope">
						<toolTip :content="_dicValue(scope.row.cigtype, InMapcPtions)">
							<span>{{_dicValue(scope.row.cigtype, InMapcPtions)}}</span>
						</toolTip>
					</template>
				</el-table-column>
				<el-table-column prop="batchNo" label="批次号" width="180"></el-table-column>
				<el-table-column prop="inventQuality" label="入库总量（件）" width="180"></el-table-column>
				<el-table-column prop="outQuality" label="出库总量（件）" width="180"></el-table-column>
				<el-table-column prop="surplusQuality" label="剩余总量（件）" width="180"></el-table-column>
				<el-table-column prop="outoquality" label="开出数量（件）" width="180"></el-table-column>
                <el-table-column prop="descript" label="货位描述" width="180"></el-table-column>
				<!--<el-table-column prop="trayCode" label="托盘编号" width="180"></el-table-column>-->
				<el-table-column prop="quality" label="数量" width="180"></el-table-column>
				<el-table-column prop="status" label="状态" width="60">
					<template slot-scope="scope">
						<toolTip :content="_dicValue(scope.row.status, InMapPtions)">
							<span>{{_dicValue(scope.row.status, InMapPtions)}}</span>
						</toolTip>
					</template>
				</el-table-column>
				<el-table-column prop="outDate" label="出库时间" width="180"></el-table-column>
			</el-table>
		</div>
	</div>
</template>
<script>
	import mixin from "../../mixin/mixin.js";
	import local from "../../local.js";
	import inventoryinformationModal from "../component/modal/inventoryinformationModal.vue";
	export default {
		mixins: [mixin],
		components: {
			inventoryinformationModal
		},
		data() {
			return {
				InMapPtions: [],
				spanArr: [],
				pos: 0,
				spanArrD: [],
				posD: 0,
				colorArr: [],
				gridData: [],
				gridForm: {},
				multipleSelection: [],
				searchForm: {
					materName: "",
					materCode: "",
					materVersion:"",
					materCigbrand:""
				}
			};
		},
		mounted() {
			this.getMapStatusNo().then(
				(d => {
					this.searchTable();
				}).bind(this)
			);

			this.getMapTrialNo().then(
				(d => {}).bind(this)
			);
		},
		methods: {
			/**
			 * 获取字典类型
			 */
			getMapStatusNo() {
				return this._searchDic("IN_MAP_STATUS").then(
					function(d) {
						this.InMapPtions = this._dicKey(d);
					}.bind(this)
				);
			},
			getMapTrialNo() {
				return this._searchDic("MATERIAL_TYPE").then(
					function(d) {
						this.InMapcPtions = this._dicKey(d);
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
					name: "inventorymain/listIL",
					param: this.searchForm,
					loading: "dataLoading"
				}).then(this.renderTable);
			},
			reset() {
				Object.assign(this.searchForm, {
					materName: "",
					materCode: "",
					materVersion:"",
					materCigbrand:""
				});
				this.searchTable();
			},
			selectionChange(val) {
				this.multipleSelection = val;
			},
			exportSomeEx() {
				Object.assign(this.gridForm, {})
				return this._ajax({
					url: this.rootAPI,
					name: "inventorymain/queryInAll",
					param: this.gridForm,
					loading: "dataLoading"
				}).then(function(d) {
					var newSelection = [];
					for(var i = 0; i < d.aaData.length; i++) {
						for(var j = 0; j < this.multipleSelection.length; j++) {
							if(d.aaData[i].id === this.multipleSelection[j].id) {
								newSelection.push(d.aaData[i])
							}
						}
					}
					this.gridData = newSelection;
					if(this.gridData.length==0){
		        		this.$message.error('请先选中要导出的数据');
		        		return;
		        	}
					this.spanArr = [];
					this.spanArrD = [];
					this.colorArr = [];
					this.getSpanArr(this.gridData);
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
			tableRowClassName({
				row,
				rowIndex
			}) {
				const _row = this.colorArr[rowIndex];
				if(_row === 0) {
					return 'warning-row';
				} else {
					return 'success-row';
				}
				return '';
			},
			objectSpanMethod({
				row,
				column,
				rowIndex,
				columnIndex
			}) {
				if(columnIndex === 0 || columnIndex === 1 || columnIndex === 2 || columnIndex === 3 || columnIndex === 4) {
					const _row = this.spanArr[rowIndex];
					const _col = _row > 0 ? 1 : 0;
					return {
						rowspan: _row,
						colspan: _col
					}
				}
				if(columnIndex === 5 || columnIndex === 6 || columnIndex === 7 || columnIndex === 8 || columnIndex === 9) {
					const _row = this.spanArrD[rowIndex];
					const _col = _row > 0 ? 1 : 0;
					return {
						rowspan: _row,
						colspan: _col
					}
				}
			},
			exportEx() {
				Object.assign(this.gridForm, {})
				return this._ajax({
					url: this.rootAPI,
					name: "inventorymain/queryInAll",
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
				var filename = "库存明细"
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
			queryInventory(row) {
				this.modalType = "search";
				this.modalShow = true;
				this.modalObj = row;
			}
		}
	};
</script>
<style>

</style>