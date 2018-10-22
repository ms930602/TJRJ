<template>
	<div class="page-person">
    <!-- 查询条件 -->
		<searchInputItems>
			<searchInputItem name="物品名称">
				<inputItem :value.sync="searchForm.name" @enter="searchTable"></inputItem>
			</searchInputItem>
			<searchInputItem name="所属游戏">
				<selectInput :value.sync="searchForm.gameId" @selectChange="searchTable" :clearable="true">
					<el-option
				      v-for="item in gameOption"
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
		    <el-table-column prop="name" label="物品名称">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.name">
		    			<span>{{scope.row.name}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="type" label="所属游戏">
		    	<template slot-scope="scope">
					{{_dicValue(scope.row.gameId, gameOption)}}
			    </template>
		    </el-table-column>
		    <el-table-column prop="type" label="类型">
		    	<template slot-scope="scope">
					<span v-if="scope.row.type == 0">永久</span>
					<span v-if="scope.row.type == 1">期限</span>
			    </template>
		    </el-table-column>
		    <el-table-column prop="remark" label="备注">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.remark">
		    			<span>{{scope.row.remark}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
			<el-table-column prop="updatetime" label="修改时间">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.updatetime">
		    			<span>{{scope.row.updatetime}}</span>
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
		    <el-table-column label="操作">
		    	<template slot-scope="scope">
		    		<el-button-group>
		    			<iconBtn iconClass="el-icon-edit" content="编辑" @click="modalEdit(scope.row)"></iconBtn>
					    <iconBtn iconClass="el-icon-minus" content="删除" @click="delRow(scope.row)">
						</iconBtn>
		    		</el-button-group>		    		
		    	</template>
		    </el-table-column>
		</elemTable>
		<itemModel v-if="modalShow" :modal="modalShow" :modalTypeTitle="modalType" @close="modalClose" :objItem="modalObj" @submit="modalSubmit"></itemModel>
    </div>
</template>

<script>
    import mixin from '../../mixin/mixin.js'
	import itemModel from '.././component/modal/itemModel.vue'
	import local from '../../local.js'
	export default {
		mixins: [mixin],
		components: {itemModel},
		data() {
			return {
				searchForm: {
					name: '',
					gameId: null
				},
				dataList: [],	
				gameOption:[],			
				rowOBJ: {}
			}
		},
        mounted() {
        	var _this = this;
			let method = 'gameMs/list';
            this._ajax({url: this.rootAPI + method })
            .then((function(d) {
            	if(d.aaData && d.aaData.length > 0){
					d.aaData.forEach(temp=>{
						_this.gameOption.push({key:temp.id,value:temp.name})
					});
            	}
				this.searchTable();
			}).bind(this))
		},
		methods: {
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
				return this._ajax({url: this.rootAPI, name: 'itemMs/list', param: this.searchForm, loading: 'dataLoading'}).then(this.renderTable)
			},
			reset() {
				Object.assign(this.searchForm, {
					name: '',
					gameId: null
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
        			return this._ajax({url: this.rootAPI + 'itemMs/delete', param: o, arr:true})
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