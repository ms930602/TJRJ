<template>
	<div class="page-person">
    <!-- 查询条件 -->
		<searchInputItems>
			<searchInputItem name="游戏名称">
				<inputItem :value.sync="searchForm.name" @enter="searchTable"></inputItem>
			</searchInputItem>
			<searchInputItem name="类型">
				<selectInput :value.sync="searchForm.type" @selectChange="searchTable" :clearable="true">
					<el-option
				      v-for="item in types"
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
		    <el-table-column prop="name" label="游戏名称">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.name">
		    			<span>{{scope.row.name}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="type" label="类型">
		    	<template slot-scope="scope">
					{{_dicValue(scope.row.type, types)}}
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
		<gameModel v-if="modalShow" :modal="modalShow" :modalTypeTitle="modalType" @close="modalClose" :objItem="modalObj" @submit="modalSubmit"></gameModel>
    </div>
</template>

<script>
    import mixin from '../../mixin/mixin.js'
	import gameModel from '.././component/modal/gameModel.vue'
	import local from '../../local.js'
	export default {
		mixins: [mixin],
		components: {gameModel},
		data() {
			return {
				searchForm: {
					name: '',
					type: ''
				},
				dataList: [],				
				rowOBJ: {}
			}
		},
        mounted() {
            this._searchDic('GAME_TYPE')
			.then((function(d) {
				this.types = this._dicKey(d)
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
				return this._ajax({url: this.rootAPI, name: 'gameMs/list', param: this.searchForm, loading: 'dataLoading'}).then(this.renderTable)
			},
			reset() {
				Object.assign(this.searchForm, {
					name: '',
					type: ''
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
        			return this._ajax({url: this.rootAPI + 'gameMs/delete', param: o, arr:true})
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