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
			<el-table-column prop="officialMaterCode" label="正式物料编号" width="150px">
				<template slot-scope="scope">
					<toolTip :content="scope.row.officialMaterCode">
						<span>{{scope.row.officialMaterCode}}</span>
					</toolTip>
				</template>
			</el-table-column>
			<el-table-column prop="officialMaterName" label="正式物料名称">
				<template slot-scope="scope">
					<toolTip :content="scope.row.officialMaterName">
						<span>{{scope.row.officialMaterName}}</span>
					</toolTip>
				</template>
			</el-table-column>
			<el-table-column prop="testMaterCode" label="测试物料编号">
				<template slot-scope="scope">
					<toolTip :content="scope.row.testMaterCode">
						<span>{{scope.row.testMaterCode}}</span>
					</toolTip>
				</template>
			</el-table-column>
			<el-table-column prop="testMaterName" label="测试物料名称">
				<template slot-scope="scope">
					<toolTip :content="scope.row.testMaterName">
						<span>{{scope.row.testMaterName}}</span>
					</toolTip>
				</template>
			</el-table-column>
			<el-table-column prop="brandName" label="品牌" width="150px">
				<template slot-scope="scope">
					<toolTip :content="scope.row.brandName">
						<span>{{scope.row.brandName}}</span>
					</toolTip>
				</template>
			</el-table-column>
			<el-table-column prop="storageTime" label="存放时间" width="150px">
				<template slot-scope="scope">
					<toolTip :content="scope.row.storageTime">
						<span>{{scope.row.storageTime}}</span>
					</toolTip>
				</template>
			</el-table-column>
			<el-table-column prop="surplusQuality" label="库存数量" width="150px">
				<template slot-scope="scope">
					<toolTip :content="scope.row.surplusQuality">
						<span>{{scope.row.surplusQuality}}</span>
					</toolTip>
				</template>
			</el-table-column>
			<el-table-column prop="pacsName" label="规格名称" width="150px">
				<template slot-scope="scope">
					<toolTip :content="scope.row.pacsName">
						<span>{{scope.row.pacsName}}</span>
					</toolTip>
				</template>
			</el-table-column>
			<!-- <el-table-column label="操作" width="120px">
				<template slot-scope="scope">
					<el-button-group>
						<iconBtn iconClass="el-icon-search" content="查询库存详情" @click="queryInventory(scope.row)"></iconBtn>
					</el-button-group>
				</template>
			</el-table-column> -->
		</elemTable>
		<inventoryinformationModal v-if="modalShow" :modaltype="modalType" @close="modalClose" :modalshow='modalShow' @submit="modalSubmit" :tableRow='modalObj'></inventoryinformationModal>
		<div id="exclTable" style="display: none;">
			<el-table :data="gridData" ref='ces' border style="width: 100%" height="250" :span-method="objectSpanMethod" border :row-class-name="tableRowClassName">
				<el-table-column prop="officialMaterCode" class='ces' label="正式物料编号" width="180">
				</el-table-column>
				<el-table-column prop="officialMaterName" label="正式物料名称" width="180"></el-table-column>
				<el-table-column prop="testMaterCode" label="福样促试编码" width="180"></el-table-column>
				<el-table-column prop="testMaterName" label="福样促试名称" width="180"></el-table-column>
				<el-table-column prop="brandName" label="品牌名称" width="180"></el-table-column>
				<el-table-column prop="storageTime" label="存放时间" width="180"></el-table-column>
				<el-table-column prop="pacsName" label="规格名称" width="180"></el-table-column>
				<el-table-column prop="surplusQuality" label="存放数量(件)" width="180"></el-table-column>
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
					materCode: ""
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
					name: "inventoryControlStatistics/list",
					param: this.searchForm,
					loading: "dataLoading"
				}).then(this.renderTable);
			},
			reset() {
				Object.assign(this.searchForm, {
					materName: "",
					materCode: ""
				});
				this.searchTable();
			},
			selectionChange(val) {
				this.multipleSelection = val;
			},
			exportSomeEx() {
				debugger;
				Object.assign(this.gridForm, {})
				return this._ajax({
					url: this.rootAPI,
					name: "inventoryControlStatistics/queryInAll",
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
					name: "inventoryControlStatistics/queryInAll",
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
				var filename = "存量控制统计"
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