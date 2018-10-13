<template>
	<div class="page-person">
    <!-- 查询条件 -->
		<searchInputItems>
			<searchInputItem name="游戏名称">
				<inputItem :value.sync="searchForm.personName" @enter="searchTable"></inputItem>
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
		    <el-table-column prop="loginName" label="登录用户">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.loginName">
		    			<span>{{scope.row.loginName}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="personName" label="姓名">
		    	<template slot-scope="scope">
					<toolTip :content="scope.row.personName">
		    			<span>{{scope.row.personName}}</span>
		    		</toolTip>
			    </template>
		    </el-table-column>
			<el-table-column prop="department" label="部门">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.department">
		    			<span>{{scope.row.department}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="sex" label="性别">
		    	<template slot-scope="scope">
					<tagItem :type="scope.row.sex ? 'success' : 'danger'" :text="_dicValue(scope.row.sex, dicPersonSex)"></tagItem>
			    </template>
		    </el-table-column>
		    <el-table-column prop="jobno" label="工号">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.jobno">
		    			<span>{{scope.row.jobno}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
            <el-table-column prop="email" label="邮箱">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.email">
		    			<span>{{scope.row.email}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
			<el-table-column prop="enabled" label="是否可用">
		    	<template slot-scope="scope">
					<tagItem :type="scope.row.enabled ? 'success' : 'danger'" :text="_dicValue(scope.row.enabled, dicPersonEnable)"></tagItem>
			    </template>
		    </el-table-column>
            <el-table-column prop="remark" label="备注">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.remark">
		    			<span>{{scope.row.remark}}</span>
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
		<personModel v-if="modalShow" :modal="modalShow" :personInfoModalType="modalType" @close="modalClose" :personinfo="modalObj" @submit="modalSubmit"></personModel>
    </div>
</template>

<script>
    import mixin from '../../mixin/mixin.js'
	import personModel from '.././component/modal/personModel.vue'
	import local from '../../local.js'
	export default {
		mixins: [mixin],
		components: {personModel},
		data() {
			return {
				searchForm: {
					personName: '',
					jobno: '',
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
			}).bind(this))
			.then((function(d){
                this._searchDic('PERSON_SEX')
			.then((function(d) {
				this.dicPersonSex = this._dicKey(d)
                this.searchTable();
			  }).bind(this))
			}).bind(this))
		},
		methods: {
            modalEdit(o) {
                o.sex = o.sex === 1?'1':'0';
                this.modalObj = o
                this.modalType = 'edit'
                this.modalShow = true
		    },
			searchTable() {
				Object.assign(this.searchForm, {
					pageNum: this.pageNum, 
					pageSize: this.pageSize
				})
				return this._ajax({url: this.rootAPI, name: 'personinfo/list', param: this.searchForm, loading: 'dataLoading'}).then(this.renderTable)
			},
			reset() {
				Object.assign(this.searchForm, {
					personName: '',
					jobno: '',
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
        			return this._ajax({url: this.rootAPI + 'personinfo/delete', param: o, arr:true})
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