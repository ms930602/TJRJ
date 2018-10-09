<template>
	<div class="page-person">
    <!-- 查询条件 -->
		<searchInputItems>
			<searchInputItem name="单号">
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
		    <el-table-column prop="orderNumber" label="单号">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.orderNumber">
		    			<span>{{scope.row.orderNumber}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="inventor" label="盘点人">
		    	<template slot-scope="scope">
					<toolTip :content="scope.row.inventor">
		    			<span>{{scope.row.inventor}}</span>
		    		</toolTip>
			    </template>
		    </el-table-column>
		    <el-table-column prop="inventStartDate" label="开始时间">
		    	<template slot-scope="scope">
					<toolTip :content="scope.row.inventStartDate">
		    			<span>{{scope.row.inventStartDate}}</span>
		    		</toolTip>
			    </template>
		    </el-table-column>
		    <el-table-column prop="inventEndDate" label="结束时间">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.inventEndDate">
		    			<span>{{scope.row.inventEndDate}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="reversion" label="是否复盘">
		    	<template slot-scope="scope">
		    		<toolTip :content="_dicValue(scope.row.reversion, reversionStatus)">
		    			<span>{{_dicValue(scope.row.reversion, reversionStatus)}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="status" label="状态">
		    	<template slot-scope="scope">
		    		<tagItem :type="scope.row.status == 3 ? 'success' : 'danger'" 
		    		:text="_dicValue(scope.row.status, dicPersonEnable)"></tagItem>
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
		    <el-table-column label="操作">
		    	<template slot-scope="scope">
		    		<el-button-group>
		    			<iconBtn iconClass="el-icon-view" v-show="scope.row.status != 0" content="查看" @click="modalSearch(scope.row)"></iconBtn>
		    			<iconBtn iconClass="el-icon-edit" v-show="scope.row.status == 0" content="编辑" @click="modalEdit(scope.row)"></iconBtn>
		    			<iconBtn iconClass="el-icon-circle-check" v-show="scope.row.status == 0" content="确认" @click="updateOk(scope.row)"></iconBtn>
		    			<iconBtn iconClass="el-icon-setting" 
		    			v-show="(scope.row.status == 1) || ((scope.row.reversion == 1) && (scope.row.status > 0))" 
		    			content="盘点" @click="pandian(scope.row)"></iconBtn>
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
				reversionStatus:[
			        {key:0 , value: '否'},
			        {key:1 , value: '是'},
			      ],
				dataList: [],				
				rowOBJ: {}
			}
		},
        mounted() {
			// console.log(this.rootAPI);
            this._searchDic('S_CHECK_MAIN')
			.then((function(d) {
				this.dicPersonEnable = this._dicKey(d)
				this.searchTable();
			}).bind(this))
		},
		methods: {
			pandian(row){
				this.$router.push({path:"/stockcheckmain/trim",query:{id:row.id}});
			},
			updateOk(row){
				var o = {id:row.id,status:1}
				this._comfirm('是否确认盘点单？')
        		.then((function() {
        			return this._ajax({url: this.rootAPI + 'stockcheckmain/update', param: o, arr:true})
        		}).bind(this))
        		.then((function(d) {
					if(d.state === 0)
					{
						this.$message({type: 'success', message: '操作成功'});
						row.status = 1;
					}
					else{
						this.$message({type: 'warning', message: '操作失败'+ d.msg});
					}
				}).bind(this))
        		.catch(this._confirmCancle);
			},
			add(){
				this.$router.push({path:"/stockcheckmain/a"});
			},
			modalSearch(o){
				this.$router.push({path:"/stockcheckmain/r",query:{id:o.id}});
			},
            modalEdit(o) {
                this.$router.push({path:"/stockcheckmain/u",query:{id:o.id}});
		    },
			searchTable() {
				Object.assign(this.searchForm, {
					pageNum: this.pageNum, 
					pageSize: this.pageSize
				})
				return this._ajax({url: this.rootAPI, name: 'Stockcheckmain/list', param: this.searchForm, loading: 'dataLoading'}).then(this.renderTable)
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
        			return this._ajax({url: this.rootAPI + 'Stockcheckmain/delete', param: o, arr:true})
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