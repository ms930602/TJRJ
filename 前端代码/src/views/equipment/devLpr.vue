<template>
	<!--车牌识别管理-->
	<div class="page-devLpr">
		<!-- 查询条件 -->
		<searchInputItems>
			<searchInputItem name="厂家">
				<inputItem :value.sync="searchForm.factory" @enter="searchTable"></inputItem>
			</searchInputItem>
			<searchInputItem name="序列号">
				<inputItem :value.sync="searchForm.serialNum" @enter="searchTable"></inputItem>
			</searchInputItem>
		</searchInputItems>
		<!-- 操作按钮 -->
		<optionItems>
			<template slot="left">
				<el-button-group>
					<iconBtn iconClass="el-icon-plus" content="新增" @click="add">新增</iconBtn>
					<iconBtn iconClass="el-icon-minus" content="删除" @click="batchdelete">删除</iconBtn>
					<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
					<iconBtn iconClass="el-icon-refresh" content="重置" @click="reset">重置</iconBtn>
				</el-button-group>				
			</template>
		</optionItems>
		<!-- 表格 -->
		<elemTable :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange" @selectionChange="selectionChange">
			<el-table-column type="selection" width="55"></el-table-column>
		    <el-table-column prop="factory" label="厂家">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.factory">
		    			<span>{{scope.row.factory}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="brand" label="品牌">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.brand">
		    			<span>{{scope.row.brand}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="spec" label="型号">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.spec">
		    			<span>{{scope.row.spec}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="passwayName" label="通道">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.passwayName">
		    			<span>{{scope.row.passwayName}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="passwayNo" label="通道编号">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.passwayNo">
		    			<span>{{scope.row.passwayNo}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="serialNum" label="序列号">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.serialNum">
		    			<span>{{scope.row.serialNum}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="productDate" label="生产日期">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.productDate">
		    			<span>{{scope.row.productDate}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="recogniteTime" label="识别所需时间">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.recogniteTime">
		    			<span>{{scope.row.recogniteTime}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="workTemp" label="工作温度(℃)">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.workTemp">
		    			<span>{{scope.row.workTemp}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="workHumidity" label="工作湿度(RH%)">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.workHumidity">
		    			<span>{{scope.row.workHumidity}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="charge" label="责任人">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.charge">
		    			<span>{{scope.row.charge}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <!-- <el-table-column prop="createdDate" label="创建时间">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.createdDate">
		    			<span>{{scope.row.createdDate}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column> -->
		    <!-- <el-table-column prop="createdPerson" label="创建人">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.createdPerson">
		    			<span>{{scope.row.createdPerson}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column> -->
		    <!-- <el-table-column prop="updatedDate" label="更新时间">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.updatedDate">
		    			<span>{{scope.row.updatedDate}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column> -->
		    <!-- <el-table-column prop="updatedPerson" label="更新人">
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
					    <iconBtn iconClass="el-icon-minus" content="删除" @click="deleterow(scope.row)"></iconBtn>
		    		</el-button-group>		    		
		    	</template>
		    </el-table-column>
		</elemTable>
		<lprModal  v-if="modalShow" :modaltype="modalType" :passwayList="passwayList" @close="modalClose" :modalshow='modalShow' @submit="modalSubmit" :tableRow='modalObj'></lprModal>
	</div>
</template>

<script>
	import mixin from '../../mixin/mixin.js'
	import local from '../../local.js'
	import lprModal from "../component/modal/devLprModel.vue";
	export default {
		mixins: [mixin],
		components:{lprModal,},
		data() {
			return {
				searchForm: {
					factory: '',
					serialNum: '',
				},
				thisUser: local.get('userinfo'),
				dataList: [],	
				passwayList:[],//通道列表			
			}
		},
		mounted() {
			var vm = this;
			this.searchTable();
			this.passwayListInit();
		},
		methods: {
			searchTable() {
			Object.assign(this.searchForm, {
				pageNum: this.pageNum,
				pageSize: this.pageSize
			});
			return this._ajax({
				url: this.rootAPI,
				name: "lpr/list",
				param: this.searchForm,
				loading: "dataLoading"
			}).then(this.renderTable);
			},
			reset() {
				Object.assign(this.searchForm, {
					factory: '',
					serialNum: '',
				})
				this.handleCurrentChange(1)
			},
			add() {
			this.modalType = "add";
			this.modalShow = true;
			this.modalObj = {};
			},
			modalEdit(row) {
			this.modalType = "edit";
			this.modalShow = true;
			this.modalObj = row;
			},
			batchdelete() {			
	        	if(this.delSelection.length === 0) {
	        		this.$message({type: 'info', message: '请选择行'});
	        	}else {
	        		var selection = this.delSelection
	        		var arr = [], o = {}
					selection.forEach(function(el) {
						arr.push(el.id)
					})	
					o.id = arr
	        		this.delSubmit(o)
	        		console.log(722,o)
	        	}	
			},
			deleterow(row) {
				var o = {
    				id: [row.id]
    			}
    			this.delSubmit(o)
			},
			delSubmit(o) {
				this._comfirm('确定删除？')
        		.then(function(d) {
					this._ajax({url: this.rootAPI , name:'lpr/delete', param: o, arr:true})
					.then(
           			function(d) {
						   console.log(56,d)
						   if (d.state == 0) {
								this.$message({ type: "success", message: "删除成功" });
							} else {
								this.$message({ type: "warning", message: "删除失败" });
							}
							this.handleCurrentChange(1);
						}.bind(this)
					
					);
				 }.bind(this)
				);
			},
			
			//初始通道列表
			passwayListInit() {
				var vm = this;
				Object.assign({
					pageNum: this.pageNum, 
					pageSize: this.pageSize
				})
				return this._ajax({url: this.rootAPI, name: 'passway/list', loading: 'dataLoading'})
				.then((function(d){
					if(d.msg == 'success') {
					vm.passwayList = [];
					console.log(66,d.aaData)
							for(var index = 0; index < d.aaData.length; index++) {
								vm.passwayList.push({
									value: d.aaData[index].id+','+d.aaData[index].passNo,
									label: d.aaData[index].passName,
								})
							}
							console.log("vm.passwayList",vm.passwayList)
					}
				}).bind(this))
				
			},
		}
	}
</script>

<style>
</style>