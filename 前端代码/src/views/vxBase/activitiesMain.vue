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
		<span style="color:red">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;提示：活动的宣传地址请点击行头的 ">" 符号查看</span>
		<!-- 表格 -->
		<elemTable :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange" @selectionChange="selectionChange">
			<el-table-column type="selection" width="55"></el-table-column>
			 <el-table-column type="expand">
		      <template slot-scope="props">
		        <el-form label-position="left" inline class="demo-table-expand">
		          <el-form-item label="宣传地址:">
		            <span>{{props.row.url}}</span>
		          </el-form-item>
		        </el-form>
		      </template>
		    </el-table-column>
		    <el-table-column prop="title" label="标题" width="400">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.title">
		    			<span>{{scope.row.title}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
			<el-table-column prop="startTime" label="活动时间">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.startTime">
		    			<span>{{scope.row.startTime}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="price" label="价格">
		    	<template slot-scope="scope">
					<toolTip :content="scope.row.price">
		    			<span>{{scope.row.price}}</span>
		    		</toolTip>
			    </template>
		    </el-table-column>
		    <el-table-column prop="phone" label="客户电话">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.phone">
		    			<span>{{scope.row.phone}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
            <el-table-column prop="payNum" label="购买人数">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.payNum">
		    			<span>{{scope.row.payNum}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
			<el-table-column prop="selectNum" label="浏览数">
		    	<template slot-scope="scope">
					<toolTip :content="scope.row.selectNum">
		    			<span>{{scope.row.selectNum}}</span>
		    		</toolTip>
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
		    type="danger"  v-if="scope.row.status == 0"
		    content="停用" @click="statusAction(scope.row,1)"></iconBtn>
		    <iconBtn iconClass="el-icon-success" 
		    type="success"  v-else
		    content="启用" @click="statusAction(scope.row,0)"></iconBtn>
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
				this.$router.push({path:"/activities/a"});
			},
            modalEdit(o) {
                this.$router.push({path:"/activities/u",query:{id:o.id}});
		    },
			searchTable() {
				Object.assign(this.searchForm, {
					pageNum: this.pageNum,
					pageSize: this.pageSize
				})
				return this._ajax({url: this.rootAPI, name: 'vxActivities/list', param: this.searchForm, loading: 'dataLoading'}).then(this.renderTable)
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
        			return this._ajax({url: this.rootAPI + 'vxActivities/update', param: {
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
        			return this._ajax({url: this.rootAPI + 'vxActivities/delete', param: o, arr:true})
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