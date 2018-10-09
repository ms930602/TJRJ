<template>
	<!--仓库信息-->
	<div class="page-measureunit">
		<!-- 查询条件 -->
		<searchInputItems>
			<searchInputItem name="仓库名称">
				<inputItem :value.sync="searchForm.warName" @enter="searchTable"></inputItem>
			</searchInputItem>
			<searchInputItem name="仓库代码">
				<inputItem :value.sync="searchForm.warCode" @enter="searchTable"></inputItem>
			</searchInputItem>
			<searchInputItem name="状态">
				<selectInput :value.sync="searchForm.status" @selectChange="searchTable" :clearable="true">
					<el-option
				      v-for="item in optionStatus"
				      :key="item.key"
				      :label="item.label"
				      :value="item.value">
				    </el-option>
				</selectInput>
			</searchInputItem>
		</searchInputItems>
		<!-- 操作按钮 -->
		<optionItems>
			<template slot="left">
				<el-button-group>
					<iconBtn iconClass="el-icon-plus" content="新增" @click="add">新增</iconBtn>
					<!-- <iconBtn iconClass="el-icon-minus" content="删除" @click="batchdelete">删除</iconBtn> -->
					<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
					<iconBtn iconClass="el-icon-refresh" content="重置" @click="reset">重置</iconBtn>
				</el-button-group>				
			</template>
		</optionItems>
		<!-- 表格 -->
		<elemTable :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange" >
		    <el-table-column prop="warCode" label="仓库代码" width="200px">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.warCode">
		    			<span>{{scope.row.warCode}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="warName" label="仓库名称" width="300px">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.warName">
		    			<span>{{scope.row.warName}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="warTypeId" label="仓库类别">
				<template slot-scope="scope">
		    		<toolTip :content="_dicValue(scope.row.warTypeId, dicWarTypeId)">
		    			<span>{{_dicValue(scope.row.warTypeId, dicWarTypeId)}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <!-- <el-table-column prop="stockOrgId" label="库存组织">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.stockOrgId">
		    			<span>{{scope.row.stockOrgId}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column> -->
		    <el-table-column prop="warProp" label="仓库属性">
				<template slot-scope="scope">
		    		<toolTip :content="_dicValue(scope.row.warProp, dicWarProp)">
		    			<span>{{_dicValue(scope.row.warProp, dicWarProp)}}</span>
		    		</toolTip>
		      	</template>		    	
		    </el-table-column>
		    <el-table-column prop="warAddress" label="库存地址">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.warAddress">
		    			<span>{{scope.row.warAddress}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <!--<el-table-column prop="leaderNane" label="负责人">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.leaderNane">
		    			<span>{{scope.row.leaderNane}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		     <el-table-column prop="zipCode" label="邮编">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.zipCode">
		    			<span>{{scope.row.zipCode}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="companyId" label="公司">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.companyId">
		    			<span>{{scope.row.companyId}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column> -->
		    <el-table-column prop="isSupStore" label="是否供应商寄存">

		    	<template slot-scope="scope">
					<toolTip :content="_dicValue(scope.row.isSupStore, dicIsSupStore)">
						<span>{{_dicValue(scope.row.isSupStore, dicIsSupStore)}}</span>
					</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="productPoint" label="生产点">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.productPoint">
		    			<span>{{scope.row.productPoint}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="status" label="状态">
		    	<template slot-scope="scope">
		    		<tagItem type="success" v-if="scope.row.status==2" :text="_dicValue(scope.row.status, dicStatus)"></tagItem>
					<tagItem type="warning" v-else :text="_dicValue(scope.row.status, dicStatus)"></tagItem>
		      	</template>
		    </el-table-column>
		    <!-- <el-table-column prop="createdDate" label="创建时间">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.createdDate">
		    			<span>{{scope.row.createdDate}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="createdPerson" label="创建人">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.createdPerson">
		    			<span>{{scope.row.createdPerson}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="updatedDate" label="更新时间">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.updatedDate">
		    			<span>{{scope.row.updatedDate}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="updatedPerson" label="更新人">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.updatedPerson">
		    			<span>{{scope.row.updatedPerson}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column> -->
			 <el-table-column label="操作">
		    	<template slot-scope="scope">
		    		<el-button-group>
						<iconBtn iconClass="el-icon-edit" content="编辑" @click="modalEdit(scope.row)"></iconBtn>    
					    <iconBtn iconClass="el-icon-minus" content="删除" @click="deleterow(scope.row)" ></iconBtn>
		    		</el-button-group>		    		
		    	</template>
		    </el-table-column>
		</elemTable>
		 <warehouseInfoModel  v-if="modalShow" :modaltype="modalType"  @close="modalClose" :modalshow='modalShow' @submit="modalSubmit" :tableRow='modalObj'></warehouseInfoModel>
	</div>
</template>
<script>
	import mixin from '../../mixin/mixin.js'
	import local from '../../local.js'
	import warehouseInfoModel from "../component/modal/warehouseInfoModel.vue";
	export default {
		mixins: [mixin],
		components: { warehouseInfoModel },
		data() {
			return {
				searchForm: {
					warName: '',
					warCode: '',
				},
				dataList: [],				
				optionStatus: [{
					       value: '2',
					       label: '发布'
					      },{
					       value: '3',
					       label: '停用'
					      }]
			};
		},
		mounted() {
			/*仓库类别*/
			this._searchDic('WAR_TYPE_ID')
			.then((function(d) {
				this.dicWarTypeId = this._dicKey(d)
			}).bind(this))
			/*是否基本单位*/
			this._searchDic('WAR_PROP')
			.then((function(d) {
				this.dicWarProp = this._dicKey(d)
			}).bind(this))
			/*是否供应商寄存*/
			this._searchDic('IS_SUP_STORE')
			.then((function(d) {
				this.dicIsSupStore = this._dicKey(d)
			}).bind(this))
			/*状态*/
			this._searchDic('WAR_STATUS')
			.then((function(d) {
				this.dicStatus = this._dicKey(d)
			}).bind(this))
			.then(this.searchTable)
		},
		methods: {
			searchTable() {
				Object.assign(this.searchForm, {
					pageNum: this.pageNum, 
					pageSize: this.pageSize
				})
				return this._ajax({url: this.rootAPI, name: 'warehouseinfo/list', param: this.searchForm, loading: 'dataLoading'}).then(this.renderTable)
			},
			reset() {
				Object.assign(this.searchForm, {
					warName: '',
					warCode: '',
				})
				this.handleCurrentChange(1)
			},
			add() {
				debugger;
				this.modalType = "add";
				this.modalShow = true;
				this.modalObj = {};

			},
			modalEdit(row){
				this.modalType = "edit";
				this.modalShow = true;
				this.modalObj = row;
			},
			deleterow(row) {
				var o = {
					id: [row.id]
				};
				this.delSubmit(o);
			},
			delSubmit(o) {
				this.confirm("确定删除？",
					function() {
						this._ajax({
							url: this.rootAPI + "warehouseinfo/delete",
							param: o,
							arr: true
						}).then(
							function(d) {
							if (d.state == 0) {
								this.$message({ type: "success", message: "删除成功" });
							} else {
								this.$message({ type: "warning", message: "删除失败"+d.msg });
							}
							this.handleCurrentChange(1);
							}.bind(this)
						);
						}.bind(this)
							);
						},
			cancel() {
				var vm = this;
				vm.$refs["form"].resetFields();
				this.dialog.show = false;
				this.diaTitle = '',
				this.searchTable();
			},
		}
	};
</script>

<style>
</style>