<template>
	<div class="page-person">
    <!-- 查询条件 -->
		<searchInputItems>
			<searchInputItem name="微信号">
				<inputItem :value.sync="searchForm.nickname" @enter="searchTable"></inputItem>
			</searchInputItem>
			&nbsp;&nbsp;&nbsp;
			<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
		</searchInputItems>
		<!-- 表格 -->
		<elemTable :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange" @selectionChange="selectionChange">
		    <el-table-column prop="nickname" label="昵称">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.nickname">
		    			<span>{{scope.row.nickname}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
            <el-table-column prop="extNum" label="推广个数">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.extNum">
		    			<span>{{scope.row.extNum}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="createtime" label="创建时间">
		    	<template slot-scope="scope">
					<toolTip :content="scope.row.createtime">
		    			<span>{{scope.row.createtime}}</span>
		    		</toolTip>
			    </template>
		    </el-table-column>
		</elemTable>
    </div>
</template>

<script>
    import mixin from '../../mixin/mixin.js'
	import local from '../../local.js'
	export default {
		mixins: [mixin],
		data() {
			return {
				activitiStatusOption:[],
				searchForm: {
					nickname: ''
				},
				dataList: []
			}
		},
        mounted() {
			this.searchTable();
		},
		methods: {
			
			searchTable() {
				Object.assign(this.searchForm, {
					pageNum: this.pageNum,
					pageSize: this.pageSize
				})
				return this._ajax({url: this.rootAPI, name: 'vxPromoters/list', param: this.searchForm, loading: 'dataLoading'}).then(this.renderTable)
			},
			reset() {
				Object.assign(this.searchForm, {
					nickname: ''
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
				this._comfirm('确定停用该活动？')
        		.then((function() {        			
        			return this._ajax({url: this.rootAPI + 'vxPromoters/update', param: {
        				id:row.id,
        				status:status
        			}, arr:true})
        		}).bind(this))
        		.then((function(d) {
					if(d.state === 0)
					{
						this.$message({type: 'success', message: '已停用'});
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
        			return this._ajax({url: this.rootAPI + 'vxPromoters/delete', param: o, arr:true})
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