<template>
	<div class="page-person">
    <!-- 查询条件 -->
		<searchInputItems>
			<searchInputItem name="名称">
				<inputItem :value.sync="searchForm.name" @enter="searchTable"></inputItem>
			</searchInputItem>
		</searchInputItems>
<!-- 操作按钮 -->
		<optionItems>
			<template slot="left">
				<el-button-group>
					<iconBtn iconClass="el-icon-plus" content="新增" @click="add">新增</iconBtn>
					<iconBtn iconClass="el-icon-minus" content="删除" @click="dele">删除</iconBtn>
					<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
					<iconBtn iconClass="el-icon-refresh" content="重置" @click="reset">重置</iconBtn>
				</el-button-group>				
			</template>
		</optionItems>
		<!-- 表格 -->
		<elemTable :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange" @selectionChange="selectionChange">
			<el-table-column type="selection" width="55"></el-table-column>
		    <el-table-column prop="title" label="" width="100">
		    	<template slot-scope="scope">
		    		<img :src="fileURL + scope.row.imgStr" alt="" width="50px">
		    	</template>
		    </el-table-column>
			<el-table-column prop="carTitle" label="名称">
		    	<template slot-scope="scope">
						<span>{{scope.row.name}}</span>
		      	</template>
		    </el-table-column>
		    <el-table-column label="操作" >
		    	<template slot-scope="scope">
		    		<el-button-group>
		    			<iconBtn iconClass="el-icon-edit" type="primary" content="编辑" @click="modalEdit(scope.row)"></iconBtn>
						<iconBtn iconClass="el-icon-minus" content="删除" @click="delRow(scope.row)"></iconBtn>
		    		</el-button-group>		    		
		    	</template>
		    </el-table-column>
		</elemTable>
		<carBrandModal v-if="modalShow" :modal="modalShow" :personInfoModalType="modalType" @close="modalClose" :personinfo="modalObj" @submit="modalSubmit"></carBrandModal>
    </div>
</template>

<script>
    import mixin from '../../mixin/mixin.js'
    import carBrandModal from '.././component/modal/carBrandModal.vue'
	import local from '../../local.js'
	export default {
		mixins: [mixin],
		components: {carBrandModal},
		data() {
			return {
				statusOption:[],
				searchForm: {
					title: ''
				},
				fileURL:'',
				dataList: [],
			}
		},
        mounted() {
			this.fileURL = FILE_PATH;
			this.searchTable();
		},
		methods: {
			add(){
				this.modalType = 'add'
                this.modalShow = true
			},
            modalEdit(o) {
                this.modalObj = o
                this.modalType = 'edit'
                this.modalShow = true
		    },
			searchTable() {
				Object.assign(this.searchForm, {
					pageNum: this.pageNum,
					pageSize: this.pageSize
				})
				return this._ajax({url: this.rootAPI, name: 'carBrand/list', param: this.searchForm, loading: 'dataLoading'}).then(this.renderTable)
			},
			reset() {
				Object.assign(this.searchForm, {
					name: ''
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
        			return this._ajax({url: this.rootAPI + 'carBrand/delete', param: o, arr:true})
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