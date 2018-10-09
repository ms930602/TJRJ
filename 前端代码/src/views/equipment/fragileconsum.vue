<template>
	<div class="page-fragileconsum">
    <!-- 查询条件 -->
		<searchInputItems>
			<searchInputItem name="物件名称">
				<inputItem :value.sync="searchForm.name" @enter="searchTable"></inputItem>
			</searchInputItem>
			<searchInputItem name="物件编号">
				<inputItem :value.sync="searchForm.serialNum" @enter="searchTable"></inputItem>
			</searchInputItem>
			<searchInputItem name="损坏时间">
				<dateEditorDaterange :dateValue.sync="searchForm.damageTime"/>
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
		    <el-table-column prop="name" label="物件名称">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.name">
		    			<span>{{scope.row.name}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="serialNum" label="物件编号">
		    	<template slot-scope="scope">
					<toolTip :content="scope.row.serialNum">
		    			<span>{{scope.row.serialNum}}</span>
		    		</toolTip>
			    </template>
		    </el-table-column>
			<el-table-column prop="purpose" label="物件用途">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.purpose">
		    			<span>{{scope.row.purpose}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="damageTime" label="损坏时间">
		    	<template slot-scope="scope">
					<toolTip :content="scope.row.damageTime">
		    			<span>{{scope.row.damageTime}}</span>
		    		</toolTip>
			    </template>
		    </el-table-column>
		    <el-table-column prop="repairTime" label="修复时间">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.repairTime">
		    			<span>{{scope.row.repairTime}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
            <el-table-column prop="repairPerson" label="修复人">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.repairPerson">
		    			<span>{{scope.row.repairPerson}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column label="操作">
		    	<template slot-scope="scope">
		    		<el-button-group>
		    			<!-- <iconBtn iconClass="el-icon-edit" content="编辑" @click="rowEdit(scope.row)" v-if="!scope.row.rowEditable"></iconBtn>	 -->
		    			<iconBtn iconClass="el-icon-edit" content="编辑" @click="modalEdit(scope.row)"></iconBtn>    
					    <iconBtn iconClass="el-icon-check" type="success" content="保存" @click="submitEdit(scope.row)" v-if="scope.row.rowEditable"></iconBtn>
					    <iconBtn iconClass="el-icon-close" type="info" content="取消" @click="cancelEdit(scope.row)" v-if="scope.row.rowEditable"></iconBtn>
					    <iconBtn iconClass="el-icon-minus" content="删除" @click="delRow(scope.row)">
						</iconBtn>
		    		</el-button-group>		    		
		    	</template>
		    </el-table-column>
		</elemTable>
		<fragileconsumModel v-if="modalShow" :modal="modalShow" :fragileconsumModelType="modalType" @close="modalClose" :fragileconsum="modalObj" @submit="modalSubmit"></fragileconsumModel>
    </div>
</template>

<script>
    import mixin from '../../mixin/mixin.js'
	import fragileconsumModel from '.././component/modal/fragileconsumModel.vue'
	import local from '../../local.js'
	import {mapState} from 'vuex'
	export default {
		mixins: [mixin],
		components: {fragileconsumModel},
		data() {
			return {
				pickerOptions2: {
				shortcuts: [{
					text: '最近一周',
					onClick(picker) {
					const end = new Date();
					const start = new Date();
					start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
					picker.$emit('pick', [start, end]);
					}
				}, {
					text: '最近一个月',
					onClick(picker) {
					const end = new Date();
					const start = new Date();
					start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
					picker.$emit('pick', [start, end]);
					}
				}, {
					text: '最近三个月',
					onClick(picker) {
					const end = new Date();
					const start = new Date();
					start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
					picker.$emit('pick', [start, end]);
					}
				}]
				},
				searchForm: {
					name: '',
					serialNum: '',
					damageTime: '',
					damageStartTime: '',
					damageEndTime: ''
				},
				dataList: [],				
				rowOBJ: {}
			}
		},
		computed: {
            ...mapState([
                'today',
                'beforeDay_7',
                'beforeDay_30',
            ])
        },
        mounted() {
			// console.log(this.rootAPI);
			this.searchForm.damageTime =  [this.beforeDay_7, this.today]
            this.searchTable();
		},
		methods: {
			searchTable() {
				return this._ajax({url: this.rootAPI, name: 'fragileconsum/queryByRange', param: {
					name: this.searchForm.name,
					serialNum: this.searchForm.serialNum,
					damageStartTime: this.searchForm.damageTime == null ? '' : this.searchForm.damageTime[0],
					damageEndTime: this.searchForm.damageTime == null ? '' : this.searchForm.damageTime[1],
					pageNum: this.pageNum, 
					pageSize: this.pageSize
				}, loading: 'dataLoading'}).then(this.renderTable)
			},
			reset() {
				Object.assign(this.searchForm, {
					name: '',
					serialNum: '',
					damageTime: null
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
        			return this._ajax({url: this.rootAPI + 'fragileconsum/delete', param: o, arr:true})
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