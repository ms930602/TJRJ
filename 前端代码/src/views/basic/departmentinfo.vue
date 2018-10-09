<template>
	<div class="page-department">
    <!-- 查询条件 -->
		<searchInputItems>
			<searchInputItem name="部门名称">
				<inputItem :value.sync="searchForm.depName" @enter="searchTable"></inputItem>
			</searchInputItem>
			<searchInputItem name="状态">
				<selectInput :value.sync="searchForm.enabled" @selectChange="searchTable" :clearable="true">
					<el-option
				      v-for="item in dicPersonEnable"
				      :key="item.key"
				      :label="item.value"
				      :value="item.key">
				    </el-option>
				</selectInput>
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
		    <el-table-column prop="depName" label="部门名称">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.depName">
		    			<span>{{scope.row.depName}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="depPrincipal" label="部门负责人">
		    	<template slot-scope="scope">
					<toolTip :content="scope.row.depPrincipal">
		    			<span>{{scope.row.depPrincipal}}</span>
		    		</toolTip>
			    </template>
		    </el-table-column>
			<el-table-column prop="parentName" label="父级部门">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.parentName==''?'顶级分类':scope.row.parentName">
		    			<span>{{scope.row.parentName==''?'顶级分类':scope.row.parentName}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="descript" label="部门职责简述">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.descript">
		    			<span>{{scope.row.descript}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
			<el-table-column prop="enabled" label="是否可用">
		    	<template slot-scope="scope">
					<tagItem :type="scope.row.enabled ? 'success' : 'danger'" :text="_dicValue(scope.row.enabled, dicPersonEnable)"></tagItem>
			    </template>
		    </el-table-column>
		    <el-table-column label="操作">
		    	<template slot-scope="scope">
		    		<el-button-group>
		    			<iconBtn iconClass="el-icon-edit" content="编辑" @click="modalEdit(scope.row)"></iconBtn>    
					    <iconBtn iconClass="el-icon-check" type="success" content="保存" @click="submitEdit(scope.row)" v-if="scope.row.rowEditable"></iconBtn>
					    <iconBtn iconClass="el-icon-close" type="info" content="取消" @click="cancelEdit(scope.row)" v-if="scope.row.rowEditable"></iconBtn>
					    <iconBtn iconClass="el-icon-minus" content="删除" @click="delRow(scope.row)">
						</iconBtn>
		    		</el-button-group>		    		
		    	</template>
		    </el-table-column>
		</elemTable>
		<departmentModel v-if="modalShow" :modal="modalShow" :departmentModalType="modalType" @close="modalClose" :departmentinfo="modalObj" @submit="modalSubmit"></departmentModel>
    </div>
</template>

<script>
    import mixin from '../../mixin/mixin.js'
	import departmentModel from '.././component/modal/departmentModel.vue'
	import local from '../../local.js'
	export default {
		mixins: [mixin],
		components: {departmentModel},
		data() {
			return {
				searchForm: {
					depName: '',
					enabled: ''
				},
				dataList: [],				
				rowOBJ: {}
			}
		},
        mounted() {
			// console.log(this.rootAPI);
            this._searchDic('PERSON_ENABLE')
			.then((function(d) {
				this.dicPersonEnable = this._dicKey(d)
              	this.searchTable();
			}).bind(this))

			
		},
		methods: {
			searchTable() {
				Object.assign(this.searchForm, {
					pageNum: this.pageNum, 
					pageSize: this.pageSize
				})
				return this._ajax({url: this.rootAPI, name: 'department/findFullList', param: this.searchForm, loading: 'dataLoading'}).then(this.renderTable)
			},
			reset() {
				Object.assign(this.searchForm, {
					depName: '',
					enabled: ''
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
        			return this._ajax({url: this.rootAPI + 'department/delete', param: o, arr:true})
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