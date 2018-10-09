<template>
	<div class="page-terminalConfig">
    <!-- 查询条件 -->
		<searchInputItems>
			<searchInputItem name="终端类型">
				<selectInput :value.sync="searchForm.terminalType" @selectChange="searchTable" :clearable="true">
					<el-option
					v-for="item in claList"
					:key="item.id"
					:label="item.dicName"
					:value="item.dicCode">
				    </el-option>
				</selectInput>
			</searchInputItem>
		</searchInputItems>
<!-- 操作按钮 -->
		<optionItems>
			<template slot="left">
				<el-button-group>
					<iconBtn iconClass="el-icon-plus" content="新增" @click="modalAdd">新增</iconBtn>
					<!--<iconBtn iconClass="el-icon-minus" content="删除" @click="dele">删除</iconBtn>-->
					<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
					<iconBtn iconClass="el-icon-refresh" content="重置" @click="reset">重置</iconBtn>
				</el-button-group>				
			</template>
		</optionItems>
		<!-- 表格 -->
		<elemTable :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange" @selectionChange="selectionChange">
			<el-table-column type="selection" width="55"></el-table-column>
		    <el-table-column prop="terminalType" label="终端类型">
				<template slot-scope="scope">
					<toolTip :content="_dicValue(scope.row.terminalType, terminalTypeOption)">
		    			<span>{{_dicValue(scope.row.terminalType, terminalTypeOption)}}</span>
		    	     </toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="key" label="属性名">
		    	<template slot-scope="scope">
					<toolTip :content="scope.row.key">
		    			<span>{{scope.row.key}}</span>
		    		</toolTip>
			    </template>
		    </el-table-column>
			<el-table-column prop="value" label="属性值">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.value">
		    			<span>{{scope.row.value}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
			<el-table-column prop="isRelease" label="是否已发布">
		    	<template slot-scope="scope">
		    		<tagItem :text="_dicValue(scope.row.isRelease, dicIsRelease)"></tagItem>
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
		    			<!-- <iconBtn iconClass="el-icon-edit" content="编辑" @click="rowEdit(scope.row)" v-if="!scope.row.rowEditable"></iconBtn>	 -->
		    			<iconBtn iconClass="el-icon-edit" content="编辑" @click="modalEdit(scope.row)" v-if="scope.row.isRelease ===0"></iconBtn>    
					    <iconBtn iconClass="el-icon-check" type="success" content="保存" @click="submitEdit(scope.row)" v-if="scope.row.rowEditable"></iconBtn>
					    <iconBtn iconClass="el-icon-close" type="info" content="取消" @click="cancelEdit(scope.row)" v-if="scope.row.rowEditable"></iconBtn>
					    <iconBtn iconClass="el-icon-minus" content="删除" @click="delRow(scope.row)" v-if="scope.row.isRelease ===0"></iconBtn>
						<!--</iconBtn>-->
		    		</el-button-group>		    		
		    	</template>
		    </el-table-column>
		</elemTable>
		<terminalConfigModel v-if="modalShow" :modal="modalShow" :terminalConfigModelType="modalType" @close="modalClose" :terminalConfig="modalObj" @submit="modalSubmit"></terminalConfigModel>
    </div>
</template>

<script>
    import mixin from '../../mixin/mixin.js'
	import terminalConfigModel from '.././component/modal/terminalConfigModel.vue'
	import local from '../../local.js'
	export default {
		mixins: [mixin],
		components: {terminalConfigModel},
		data() {
			return {
				terminalTypeOption:[],
				isReleaseOption:[],
				claList:[],
				searchForm: {
					claCode: ''
				},
				dataList: [],				
				rowOBJ: {}
			}
		},
		mounted() {
			this.getTerminaltype();
			
			this._searchDic('IS_PUBLISHED')
			.then((function(d) {
				this.dicIsRelease = this._dicKey(d)
			}).bind(this));

			this._searchDic('TERMINAL_TYPE')
			.then((function(d) {
				this.claList = this._dicKey(d)
			}).bind(this))
		},
		methods: {
			searchTable() {
				Object.assign(this.searchForm, {
					pageNum: this.pageNum, 
					pageSize: this.pageSize
				})
				return this._ajax({url: this.userAPI, name: 'baseConfig/list', param: this.searchForm, loading: 'dataLoading'}).then(this.renderTable)
			},
			/*设备类型*/
			getTerminaltype(){
				this._searchDic('TERMINAL_TYPE')
				.then((function(d) {
					this.terminalTypeOption=this._dicKey(d)
					//this.dicTerminalType = this._dicKey(d)
					this.searchTable();
				}).bind(this));
			},
			getisReleaseOption(){
				this._searchDic('IS_PUBLISHED')
				.then((function(d) {
					this.terminalTypeOption=this._dicKey(d)
					this.searchTable();
				}).bind(this));
			},
			searchTable() {
				Object.assign(this.searchForm, {
					pageNum: this.pageNum, 
					pageSize: this.pageSize
				})
				return this._ajax({url: this.rootAPI, name: 'baseConfig/list', param: this.searchForm, loading: 'dataLoading'}).then(this.renderTable)
			},
			reset() {
				Object.assign(this.searchForm, {
					terminalType: ''
				})
				this.handleCurrentChange(1)
			},	
			modalEdit(o) {
				o.isRelease=o.isRelease+'';
				o.terminalType=o.terminalType+'',
				this.modalObj = o
				this.modalType = 'edit'
				this.modalShow = true
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
				console.log(o);
				this._comfirm('确定删除？')
        		.then((function() {        			
        			return this._ajax({url: this.rootAPI + 'baseConfig/delete', param: o, arr:true})
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
				// if(!this.regFloat.test(row.mobile)) {
				// 	console.log(this.regFloat.test(row.mobile))
				// 	row.mobile = 0
				// }
			},
			// exportExcel() {
			// 	var fields = ['key'],
			// 		filedsName = ['用户名称'],
			// 		fileName = '用户';
			// 	this.searchAll({url: this.rootAPI, name: 'classificate/list', param: this.searchForm})
			// 	.then((function(d) {
			// 		if(d.aaData.length > 0) {
			// 			this._csvExport(d.aaData, fields, filedsName, fileName)
			// 		}else {
			// 			this.$message({ type: 'info', message: '无导出数据' });
			// 		}
			// 	}).bind(this))		
			// },
			// exportExcelBySelect() {
			// 	var fields = ['key'],
			// 		filedsName = ['用户名称'],
			// 		fileName = '用户';
			// 	this.$exportExcelBySelect(fields, filedsName, fileName)
			// },
		}
	}
</script>