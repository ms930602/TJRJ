<template>
	<div class="page-devicerun">
    <!-- 查询条件 -->
		<searchInputItems>
			<searchInputItem name="设备名称">
				<inputItem :value.sync="searchForm.dicName" @enter="searchTable"></inputItem>
			</searchInputItem>
			<searchInputItem name="设备编号">
				<inputItem :value.sync="searchForm.serialNum" @enter="searchTable"></inputItem>
			</searchInputItem>
			<searchInputItem name="损坏时间">
				<dateEditorDaterange :dateValue.sync="searchForm.failerTime"/>
			</searchInputItem>
		</searchInputItems>
<!-- 操作按钮 -->
		<optionItems>
			<template slot="left">
				<el-button-group>
					<iconBtn iconClass="el-icon-plus" content="新增" @click="modalAdd">新增</iconBtn>
					<iconBtn iconClass="el-icon-minus" content="删除" @click="dele">删除</iconBtn>
					<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
					<iconBtn iconClass="el-icon-refresh" content="重置" @click="reset">重置</iconBtn>
				</el-button-group>				
			</template>
		</optionItems>
		<!-- 表格 -->
		<elemTable :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange" @selectionChange="selectionChange">
			<el-table-column type="selection" width="55"></el-table-column>
		    <el-table-column prop="dicName" label="设备名称">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.dicName">
		    			<span>{{scope.row.dicName}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="serialNum" label="设备编号">
		    	<template slot-scope="scope">
					<toolTip :content="scope.row.serialNum">
		    			<span>{{scope.row.serialNum}}</span>
		    		</toolTip>
			    </template>
		    </el-table-column>
		    <el-table-column prop="failerTime" label="损坏时间">
		    	<template slot-scope="scope">
					<toolTip :content="scope.row.failerTime">
		    			<span>{{scope.row.failerTime}}</span>
		    		</toolTip>
			    </template>
		    </el-table-column>
		    <el-table-column prop="repairTime" label="修复时间">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.repairTime">
		    			<span>{{scope.row.repairTime}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
            <el-table-column prop="repairPerson" label="修复人">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.repairPerson">
		    			<span>{{scope.row.repairPerson}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column label="操作">
		    	<template slot-scope="scope">
		    		<el-button-group>
		    			<!-- <iconBtn iconClass="el-icon-edit" content="编辑" @click="rowEdit(scope.row)" v-if="!scope.row.rowEditable"></iconBtn>	 -->
		    			<iconBtn iconClass="el-icon-edit" content="编辑" @click="modalEdit(scope.row)"></iconBtn>    
					    <iconBtn iconClass="el-icon-check" type="success" content="保存" @click="submitEdit(scope.row)" v-if="scope.row.rowEditable"></iconBtn>
					    <iconBtn iconClass="el-icon-close" type="info" content="取消" @click="cancelEdit(scope.row)" v-if="scope.row.rowEditable"></iconBtn>
					    <iconBtn iconClass="el-icon-minus" content="删除" @click="delRow(scope.row)">
						</iconBtn>
		    		</el-button-group>		    		
		    	</template>
		    </el-table-column>
		</elemTable>
		<devicerunModel v-if="modalShow" :modal="modalShow" :devicerunModelType="modalType" @close="modalClose" :devicerun="modalObj" @submit="modalSubmit"></devicerunModel>
    </div>
</template>

<script>
    import mixin from '../../mixin/mixin.js'
	import devicerunModel from '.././component/modal/devicerunModel.vue'
	import local from '../../local.js'
	import {mapState} from 'vuex'
	export default {
		mixins: [mixin],
		components: {devicerunModel},
		data() {
			return {
				searchForm: {
					dicName: '',
					serialNum: '',
					failerTime: []
				},
				dataList: [],				
				rowOBJ: {}
			}
		},
		computed: {
            ...mapState([
                'today',
                'beforeDay_7',
                'beforeDay_30',
            ])
        },
        mounted() {
			// console.log(this.rootAPI);
			this.searchForm.failerTime =  [this.beforeDay_7, this.today]
            this.searchTable();
		},
		methods: {
			searchTable() {
				return this._ajax({url: this.rootAPI, name: 'devicerun/queryByRange', 
				param: {
					dicName: this.searchForm.dicName,
					serialNum: this.searchForm.serialNum,
					failerStartTime: this.searchForm.failerTime == null ? '' : this.searchForm.failerTime[0],
					failerEndTime: this.searchForm.failerTime == null ? '' : this.searchForm.failerTime[1],
					pageNum: this.pageNum, 
					pageSize: this.pageSize
				}, loading: 'dataLoading'}).then(this.renderTable)
			},
			reset() {
				Object.assign(this.searchForm, {
					dicName: '',
					serialNum: '',
					failerTime: null
				})
				this.handleCurrentChange(1)
			},			
			dele() {			
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
	        	}	
			},
			delRow(row) {
				var o = {
    				id: [row.id]
    			}
    			this.delSubmit(o)
			},
			delSubmit(o) {
				this._comfirm('确定删除？')
        		.then((function() {        			
        			return this._ajax({url: this.rootAPI + 'devicerun/delete', param: o, arr:true})
        		}).bind(this))
        		.then((function(d) {
					if(d.state === 0)
					{
						this.$message({type: 'success', message: '删除成功'});
					}
					else{
						this.$message({type: 'warning', message: '删除失败'+ d.msg});
					}
					this.handleCurrentChange(1);
				}).bind(this))
        		.catch(this._confirmCancle);
			},
			changeMobile(row) {
			},
		}
	}
</script>