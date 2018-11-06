<template>
	<div class="page-person">
    <!-- 查询条件 -->
		<searchInputItems>
			<searchInputItem name="标题">
				<inputItem :value.sync="searchForm.personName" @enter="searchTable"></inputItem>
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
		    <el-table-column prop="title" label="标题" width="400">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.title">
		    			<span>{{scope.row.title}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
			<el-table-column prop="price" label="低价">
		    	<template slot-scope="scope">
		    			<span>{{scope.row.price}}万</span>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="consultPrice" label="参考价区间">
		    	<template slot-scope="scope">
		    			<span>{{scope.row.consultPrice}}</span>
			    </template>
		    </el-table-column>
		    <el-table-column prop="newPrice" label="新车价位">
		    	<template slot-scope="scope">
		    			<span>{{scope.row.newPrice}}万</span>
		      	</template>
		    </el-table-column>
            <el-table-column prop="showPrice" label="显示价格">
		    	<template slot-scope="scope">
		    			<span>{{scope.row.showPrice}}万</span>
		      	</template>
		    </el-table-column>
			<el-table-column prop="endTime" label="截止日期">
		    	<template slot-scope="scope">
		    			<span>{{scope.row.endTime}}</span>
			    </template>
		    </el-table-column>
		    <el-table-column prop="transactionStatu" label="是否上架">
		    	<template slot-scope="scope">
<tagItem :type="scope.row.transactionStatu == 1 ? 'success' : 'danger'" :text="_dicValue(scope.row.transactionStatu, transactionStatuOption)"></tagItem>
			    </template>
		    </el-table-column>
		    <el-table-column prop="status" label="状态">
		    	<template slot-scope="scope">
<tagItem :type="scope.row.status == 0 ? 'success' : 'danger'" :text="_dicValue(scope.row.status, activitiStatusOption)"></tagItem>
			    </template>
		    </el-table-column>
		    <el-table-column label="操作">
		    	<template slot-scope="scope">
		    		<el-button-group>
		    			<iconBtn iconClass="el-icon-edit" type="primary" content="编辑" @click="modalEdit(scope.row)"></iconBtn>
		    <iconBtn iconClass="el-icon-warning" 
		    type="danger"  v-if="scope.row.transactionStatu == 1"
		    content="下架" @click="statusAction(scope.row,0)"></iconBtn>
		    <iconBtn iconClass="el-icon-success" 
		    type="success"  v-else
		    content="上架" @click="statusAction(scope.row,1)"></iconBtn>
					    <iconBtn iconClass="el-icon-minus" content="删除" @click="delRow(scope.row)"></iconBtn>
		    		</el-button-group>		    		
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
				transactionStatuOption:[
			      {key:'0',value:'下架'},
			      {key:'1',value:'上架'},
			    ],
				dataList: []
			}
		},
        mounted() {
            this._searchDic('VX_ACTI_STATUS')
			.then((function(d) {
				this.activitiStatusOption = this._dicKey(d)
				this.searchTable();
			}).bind(this))
		},
		methods: {
			add(){
				this.$router.push({path:"/carInfo/a"});
			},
            modalEdit(o) {
                this.$router.push({path:"/carInfo/u",query:{id:o.id}});
		    },
			searchTable() {
				Object.assign(this.searchForm, {
					pageNum: this.pageNum,
					pageSize: this.pageSize
				})
				return this._ajax({url: this.rootAPI, name: 'carInfo/list', param: this.searchForm, loading: 'dataLoading'}).then(this.renderTable)
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
				var titleMsg = '下架';
				if(status == 1){
					titleMsg = '上架';
				}
				this._comfirm('确定'+titleMsg+'该车辆？')
        		.then((function() {        			
        			return this._ajax({url: this.rootAPI + 'carInfo/update', param: {
        				id:row.id,
        				transactionStatu:status
        			}, arr:true})
        		}).bind(this))
        		.then((function(d) {
					if(d.state === 0)
					{
						this.$message({type: 'success', message: titleMsg+'操作完成'});
						row.transactionStatu = status;
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
        			return this._ajax({url: this.rootAPI + 'carInfo/delete', param: o, arr:true})
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