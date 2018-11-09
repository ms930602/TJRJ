<template>
	<div class="page-person">
    <!-- 查询条件 -->
		<searchInputItems>
			<searchInputItem name="手机号">
				<inputItem :value.sync="searchForm.personName" @enter="searchTable"></inputItem>
			</searchInputItem>
		</searchInputItems>
<!-- 操作按钮 -->
		<optionItems>
			<template slot="left">
				<el-button-group>
					<iconBtn iconClass="el-icon-minus" content="删除" @click="dele">删除</iconBtn>
					<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
					<iconBtn iconClass="el-icon-refresh" content="重置" @click="reset">重置</iconBtn>
				</el-button-group>				
			</template>
		</optionItems>
		<!-- 表格 -->
		<elemTable :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange" @selectionChange="selectionChange">
			<el-table-column type="selection" width="55"></el-table-column>
		    <el-table-column prop="phone" label="手机号">
		    	<template slot-scope="scope">
		    			<span>{{scope.row.phone}}</span>
		      	</template>
		    </el-table-column>
			<el-table-column prop="carTitle" label="咨询汽车">
		    	<template slot-scope="scope">
						<iconBtn iconClass="el-icon-search" v-if="scope.row.carId"
						content="查看" @click="searchToCar(scope.row.carId)"></iconBtn>
						<span>{{scope.row.carTitle}}</span>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="context" label="咨询内容">
		    	<template slot-scope="scope">
		    			<span>{{scope.row.context}}</span>
			    </template>
		    </el-table-column>
		    <el-table-column prop="createtime" label="创建时间">
		    	<template slot-scope="scope">
		    			<span>{{scope.row.createtime}}</span>
		      	</template>
		    </el-table-column>
			<el-table-column prop="remark" label="备注">
		    	<template slot-scope="scope">
		    			<span>{{scope.row.remark}}</span>
			    </template>
		    </el-table-column>
		    <el-table-column prop="status" label="状态">
		    	<template slot-scope="scope">
<tagItem :type="scope.row.status == 2 ? 'success' : 'danger'" :text="_dicValue(scope.row.status, statusOption)"></tagItem>
			    </template>
		    </el-table-column>
		    <el-table-column label="操作">
		    	<template slot-scope="scope">
		    		<el-button-group>
		    			<iconBtn iconClass="el-icon-edit" type="primary" content="编辑" @click="modalEdit(scope.row)"></iconBtn>
		    <iconBtn iconClass="el-icon-warning" 
		    type="danger" 
		    content="锁定" @click="statusAction(scope.row,1)"></iconBtn>
		    <iconBtn iconClass="el-icon-warning" 
		    type="success" 
		    content="已处理" @click="statusAction(scope.row,2)"></iconBtn>
		    		</el-button-group>		    		
		    	</template>
		    </el-table-column>
		</elemTable>
		<carConsultationModal v-if="modalShow" :modal="modalShow" :personInfoModalType="modalType" @close="modalClose" :personinfo="modalObj" @submit="modalSubmit"></carConsultationModal>
    </div>
</template>

<script>
    import mixin from '../../mixin/mixin.js'
    import carConsultationModal from '.././component/modal/carConsultationModal.vue'
	import local from '../../local.js'
	export default {
		mixins: [mixin],
		components: {carConsultationModal},
		data() {
			return {
				statusOption:[],
				searchForm: {
					title: ''
				},
				dataList: [],
			}
		},
        mounted() {
			var toPage = this.$route.query.pageNum;
			if(toPage && toPage > 0){
				this.pageNum =parseInt( this.$route.query.pageNum)
			}
				
            this._searchDic('CAR_CSN_STATUS')
			.then((function(d) {
				this.statusOption = this._dicKey(d)
				this.searchTable();
			}).bind(this))
		},
		methods: {
			searchToCar(carId){
				if(carId){
					this.$router.push({path:"/carInfo/u",query:{id:carId,pageNum:this.pageNum}});
				}
			},
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
				return this._ajax({url: this.rootAPI, name: 'consultation/list', param: this.searchForm, loading: 'dataLoading'})
				.then(this.renderTable)
			},
			reset() {
				Object.assign(this.searchForm, {
					title: ''
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
			statusAction(row,status){
				this._comfirm('标记已处理该咨询？')
        		.then((function() {        			
        			return this._ajax({url: this.rootAPI + 'consultation/update', param: {
        				id:row.id,
        				status:status
        			}, arr:true})
        		}).bind(this))
        		.then((function(d) {
					if(d.state === 0)
					{
						this.$message({type: 'success', message: '已修改'});
						row.status = status;
					}
					else{
						this.$message({type: 'warning', message: '失败'+ d.msg});
					}
				}).bind(this))
        		.catch(this._confirmCancle);
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
        			return this._ajax({url: this.rootAPI + 'consultation/delete', param: o, arr:true})
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