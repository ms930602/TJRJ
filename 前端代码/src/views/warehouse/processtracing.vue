<template>
	<div>
		<el-form ref="searchForm" :model="searchForm">
			<!-- 查询条件 -->
			<searchInputItems>
				<searchInputItem name="批次号">
					<inputItem :value.sync="searchForm.batchNo" :maxlength="40"></inputItem>
				</searchInputItem>
			</searchInputItems>
		</el-form>
		<optionItems>
			<template slot="left">
				<el-button-group>
					<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
					<iconBtn iconClass="el-icon-refresh" content="重置" @click="reset">重置</iconBtn>
				</el-button-group>
			</template>
		</optionItems>
		<elemTable :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange" @selectionChange="selectionChange">
			<el-table-column type="selection" width="55"></el-table-column>
			<el-table-column prop="batchNo" label="批次号">
				<template slot-scope="scope">
					<toolTip :content="scope.row.batchNo">
						<span>{{scope.row.batchNo}}</span>
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
			<el-table-column prop="materName" label="物料名称">
				<template slot-scope="scope">
					<toolTip :content="scope.row.materName">
						<span>{{scope.row.materName}}</span>
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
			<el-table-column prop="materVersion" label="物料版本">
				<template slot-scope="scope">
					<toolTip :content="scope.row.materVersion">
						<span>{{scope.row.materVersion}}</span>
					</toolTip>
				</template>
			</el-table-column>
			<el-table-column prop="produceDate" label="入库时间">
				<template slot-scope="scope">
					<toolTip :content="scope.row.produceDate">
						<span>{{scope.row.produceDate}}</span>
					</toolTip>
				</template>
			</el-table-column>
			<el-table-column label="操作">
				<template slot-scope="scope">
					<el-button-group>
						<iconBtn iconClass="el-icon-view" content="查询过程信息" @click="queryprocessinfo(scope.row)"></iconBtn>
					</el-button-group>
				</template>
			</el-table-column>
		</elemTable>
	</div>
</template>

<script>
	import mixin from "../../mixin/mixin.js";
	import local from "../../local.js";
	export default {
		mixins: [mixin],
		data() {
			return {
				searchForm: {
					batchNo: ""
				}
			};
		},
		mounted() {
			this.searchTable();
		},
		methods: {
			searchTable() {
				Object.assign(this.searchForm, {
					pageNum: this.pageNum,
					pageSize: this.pageSize
				});
				return this._ajax({
					url: this.rootAPI,
					name: "entryorderdetail/proTracklist",
					param: this.searchForm,
					loading: "dataLoading"
				}).then(this.renderTable);
			},
			queryprocessinfo(row) {
				this.$router.push({
					path: "/queryprocessinfo",
					query: {
						batchNo: row.batchNo
					}
				});
			},
            selectionChange(val){
            	this.multipleSelection = val;
            },
			reset() {
				Object.assign(this.searchForm, {
					batchNo: ""
				});
				this.searchTable();
			}
		}
	};
</script>