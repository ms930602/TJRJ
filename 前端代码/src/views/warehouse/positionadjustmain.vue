<template>
	<div class="page-person">
    <!-- 查询条件 -->
		<searchInputItems>
			<searchInputItem name="调整单号">
				<inputItem :value.sync="searchForm.orderNumber" @enter="searchTable"></inputItem>
			</searchInputItem>
			<searchInputItem name="状态">
				<selectInput :value.sync="searchForm.status" @selectChange="searchTable" :clearable="true">
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
					<iconBtn iconClass="el-icon-plus" content="新增" @click="add">新增</iconBtn>
					<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
					<iconBtn iconClass="el-icon-refresh" content="重置" @click="reset">重置</iconBtn>
				</el-button-group>				
			</template>
		</optionItems>
		<!-- 表格 -->
		<elemTable :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange" @selectionChange="selectionChange">
		    <el-table-column prop="orderNumber" label="调整单号">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.orderNumber">
		    			<span>{{scope.row.orderNumber}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="floorCode" label="楼层编号">
		    	<template slot-scope="scope">
					<toolTip :content="scope.row.floorCode">
		    			<span>{{scope.row.floorCode}}</span>
		    		</toolTip>
			    </template>
		    </el-table-column>
		    <el-table-column prop="floorName" label="楼层名称">
		    	<template slot-scope="scope">
					<toolTip :content="scope.row.floorName">
		    			<span>{{scope.row.floorName}}</span>
		    		</toolTip>
			    </template>
		    </el-table-column>
		    <el-table-column prop="status" label="状态">
		    	<template slot-scope="scope">
		    		<tagItem :type="scope.row.status == 2 ? 'success' : 'danger'" 
		    		:text="_dicValue(scope.row.status, dicPersonEnable)"></tagItem>
			    </template>
		    </el-table-column>
			<el-table-column prop="remark" label="备注" width="220">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.remark">
		    			<span>{{scope.row.remark}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="complitDate" label="完成时间">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.complitDate">
		    			<span>{{scope.row.complitDate}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="createdDate" label="创建时间">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.createdDate">
		    			<span>{{scope.row.createdDate}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="createdPerson" label="创建人">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.createdPerson">
		    			<span>{{scope.row.createdPerson}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="updatedDate" label="更新时间">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.updatedDate">
		    			<span>{{scope.row.updatedDate}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="updatedPerson" label="更新人">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.updatedPerson">
		    			<span>{{scope.row.updatedPerson}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column label="操作">
		    	<template slot-scope="scope">
		    		<el-button-group>
		    			<iconBtn iconClass="el-icon-view" v-show="scope.row.status == 1" content="查看" @click="modalSearch(scope.row)"></iconBtn>
		    			<iconBtn iconClass="el-icon-edit" v-show="scope.row.status == 0" content="编辑" @click="modalEdit(scope.row)"></iconBtn>
					    <iconBtn iconClass="el-icon-minus" v-show="scope.row.status == 0" content="删除" @click="delRow(scope.row)">
						</iconBtn>
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
				searchForm: {
					orderNumber: '',
					dataId: '',
					status: ''
				},
				dataList: [],				
				rowOBJ: {}
			}
		},
        mounted() {
			// console.log(this.rootAPI);
            this._searchDic('IS_POS_STATUS')
			.then((function(d) {
				this.dicPersonEnable = this._dicKey(d)
				this.searchTable();
			}).bind(this))
		},
		methods: {
			add(){
				this.$router.push({path:"/positionadjustmain/a"});
			},
			modalSearch(o){
				this.$router.push({path:"/positionadjustmain/r",query:{id:o.id}});
			},
            modalEdit(o) {
                this.$router.push({path:"/positionadjustmain/u",query:{id:o.id}});
		    },
			searchTable() {
				Object.assign(this.searchForm, {
					pageNum: this.pageNum, 
					pageSize: this.pageSize
				})
				return this._ajax({url: this.rootAPI, name: 'positionadjustmain/list', param: this.searchForm, loading: 'dataLoading'}).then(this.renderTable)
			},
			reset() {
				Object.assign(this.searchForm, {
					orderNumber: '',
					dataId: '',
					status: ''
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
        			return this._ajax({url: this.rootAPI + 'positionadjustmain/delete', param: o, arr:true})
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