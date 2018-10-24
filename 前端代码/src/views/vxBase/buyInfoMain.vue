<template>
	<div class="page-person">
    <!-- 查询条件 -->
		<searchInputItems>
			<searchInputItem name="微信号">
				<inputItem :value.sync="searchForm.vxNum" @enter="searchTable"></inputItem>
			</searchInputItem>
			&nbsp;&nbsp;&nbsp;
			<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
		</searchInputItems>
		<!-- 表格 -->
		<elemTable :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange" @selectionChange="selectionChange">
		    <el-table-column prop="vxNum" label="微信号">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.vxNum">
		    			<span>{{scope.row.vxNum}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
			<el-table-column prop="phone" label="手机号码">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.phone">
		    			<span>{{scope.row.phone}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="name" label="姓名">
		    	<template slot-scope="scope">
					<toolTip :content="scope.row.name">
		    			<span>{{scope.row.name}}</span>
		    		</toolTip>
			    </template>
		    </el-table-column>
		    <el-table-column prop="money" label="支付金额">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.money">
		    			<span>{{scope.row.money}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
            <el-table-column prop="buyTime" label="支付日期">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.buyTime">
		    			<span>{{scope.row.buyTime}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
			<el-table-column prop="promotersVxNum" label="推广员微信">
		    	<template slot-scope="scope">
					<toolTip :content="scope.row.promotersVxNum">
		    			<span>{{scope.row.promotersVxNum}}</span>
		    		</toolTip>
			    </template>
		    </el-table-column>
		    <el-table-column prop="reMoney" label="推广返金额">
		    	<template slot-scope="scope">
					<toolTip :content="scope.row.reMoney">
		    			<span>{{scope.row.reMoney}}</span>
		    		</toolTip>
			    </template>
		    </el-table-column>
			<el-table-column prop="shareStatus" label="是否分享">
		    	<template slot-scope="scope">
					<toolTip :content="scope.row.shareStatus">
		    			<span>{{scope.row.shareStatus}}</span>
		    		</toolTip>
			    </template>
		    </el-table-column>
		    <el-table-column prop="shareMoney" label="分享返金额">
		    	<template slot-scope="scope">
					<toolTip :content="scope.row.shareMoney">
		    			<span>{{scope.row.shareMoney}}</span>
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
					title: ''
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
				return this._ajax({url: this.rootAPI, name: 'vxBuyInfo/list', param: this.searchForm, loading: 'dataLoading'}).then(this.renderTable)
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
				this._comfirm('确定停用该活动？')
        		.then((function() {        			
        			return this._ajax({url: this.rootAPI + 'vxBuyInfo/update', param: {
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
        			return this._ajax({url: this.rootAPI + 'vxBuyInfo/delete', param: o, arr:true})
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