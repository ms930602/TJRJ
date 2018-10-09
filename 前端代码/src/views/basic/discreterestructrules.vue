<template>
<!--散盘重组规则-->
	<div>
		<el-form ref="searchForm" :model="searchForm" label-width="80px"  :inline="true" class="demo-form-inline" >
		  <el-form-item label="规则名称:">
		    <el-input v-model="searchForm.name" :maxlength="10" style="width:200px;"></el-input>
		  </el-form-item>
		</el-form>	
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
		<elemTable :dataList="tableData" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="datacount" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange" @selectionChange="selectionChange">
			<el-table-column type="selection" width="55"></el-table-column>
		    <el-table-column prop="id" label="规则Id">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.id">
		    			<span>{{scope.row.id}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="name" label="规则名称">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.name">
		    			<span>{{scope.row.name}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="threshold" label="阀值">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.threshold">
		    			<span>{{scope.row.threshold}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
			<el-table-column prop="remark" label="备注">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.remark">
		    			<span>{{scope.row.remark}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column label="操作">
		    	<template slot-scope="scope">
		    		<el-button-group>
		    			<!-- <iconBtn iconClass="el-icon-edit" content="编辑" @click="rowEdit(scope.row)" v-if="!scope.row.rowEditable"></iconBtn>	 -->
		    			<iconBtn iconClass="el-icon-edit" content="编辑" @click="modalEdit(scope.row)" v-if="!scope.row.rowEditable && scope.row.userId != thisUser.userId"></iconBtn>    
					    <!--<iconBtn iconClass="el-icon-check" type="success" content="保存" @click="submitEdit(scope.row)" v-if="scope.row.rowEditable"></iconBtn>-->
					    <!--<iconBtn iconClass="el-icon-close" type="info" content="取消" @click="cancelEdit(scope.row)" v-if="scope.row.rowEditable"></iconBtn>-->
					    <iconBtn iconClass="el-icon-minus" content="删除" @click="delRow(scope.row)" v-if="scope.row.userId != thisUser.userId"></iconBtn>
		    		</el-button-group>		    		
		    	</template>
		    </el-table-column>
		</elemTable>
		<el-dialog :title="dialogtitle" :visible.sync="dialogFormVisible" width="30%">
		  	<el-form :model="form" :rules="rules" ref="form">
				<el-form-item label="id" label-width="120px"  prop='id' hidden="true">
		      		<el-input v-model="form.id"   style='width: 220px;' :maxlength="10"></el-input>
		   	 	</el-form-item>
		    	<el-form-item label="规则名称" label-width="120px"  prop='name'>
		      		<el-input v-model="form.name" style='width: 220px;' :maxlength="45"></el-input>
		   	 	</el-form-item>
		    	<el-form-item label="阀值" label-width="120px">
		      		<el-input v-model="form.threshold" type="number" @change="checkparam" :maxlength="21" style='width: 220px;'></el-input>
		   	 	</el-form-item>
		   	 	<el-form-item label="备注" label-width="120px">
		      		<el-input type="textarea" :rows="2" v-model="form.remark" :maxlength="100"  style='width: 220px;'></el-input>
		   	 	</el-form-item>
		  </el-form>
		  <div slot="footer" class="dialog-footer">
		    <el-button @click="quxiao('form')">取 消</el-button>
		    <el-button type="primary" @click="save('form')">确 定</el-button>
		  </div>
		</el-dialog>
	</div>
</template>
<script>
import mixin from '../../mixin/mixin.js'
	import local from '../../local.js'
	export default {
		mixins: [mixin],
		components: {},
		data() {
			return {
				dialogFormVisible:false,
				searchForm: {
					name: '',
				},
				options:[],
				pageSize:10,
				pageNum:0,
				tableData: [],
				datacount:0,
				thisUser: local.get('userinfo'),
				form:{
					id:null,
					name:'',
					threshold: '',
					remark:'',
				},
				yanzareaCode:'',
				updatedPersonshow:false,
				rules: {
                    name: [
                        {required: true, message: '规则名称不能为空'}
                    ],
					threshold: [
                        {required: true, message: '阀值不能为空'}
					],
                },
			}
		},
		mounted() {
			this.searchTable()
		},
		methods: {
			//校验参数
			checkparam(){
				var vm=this;
				var num=vm.form.threshold;
				if(Number(num)<0){
					 this.$message.error("阀值不能小于0");
					 vm.form.threshold=null;
					 return;
				}
			},
			//查询表格，初次加载数据
			searchTable() {
				var vm = this
				Object.assign(this.searchForm, {
					pageNum: vm.pageNum, 
					pageSize: vm.pageSize
				})
				return vm._ajax({
					url: vm.rootAPI, 
					name: 'discreterestructrules/list', 
					param: vm.searchForm, 
					loading: 'dataLoading'
					}).then((d) => {
						if(d.state === 0){
							vm.tableData = d.aaData
	        				vm.datacount = d.dataCount
						}
	        		}, (d) => {
	                    this.$message.error('列表获取失败');
	                })
			},
			handleSizeChange(val) {
                this.pageSize = val;
                this.searchTable();
            },
            handleCurrentChange(val) {
                this.pageNum = val;
                this.searchTable();
            },
			modalEdit(value){
				var vm = this;
				console.log(value.id)
				vm.dialogtitle='散盘重组规则'
				vm.form.id=value.id
				vm.form.name=value.name
				vm.form.threshold= value.threshold
				vm.form.remark=value.remark
				vm.yanzareaCode=value.threshold
				vm.updatedPersonshow = true
				vm.dialogFormVisible = true
			},
			delRow(value){
				var vm = this;

                vm.$confirm('删除操作不可逆, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    let param = {
                        id: value.id
                    }
                    return vm._ajax({
								url: vm.rootAPI, 
								name: 'discreterestructrules/delete', 
								param:param, 
								})
                        .then((data) => {
                            if (data.state === 0) {
                                vm.searchTable();
                                vm.$message({
                                    type: 'success',
                                    message: '删除成功!'
                                });
                            }
                        }, (data) => {
                            vm.$message.error("删除失败！", data);
                        })
                })
			},
			reset(){
				var vm = this;
				vm.searchForm = {
					name: '',
				}
				vm.pageSize = 10
				vm.pageNum = 0
				vm.searchTable();
			},
			add(){
				var vm = this;
				console.log(vm.form.id)
				vm.form={};
				vm.dialogtitle='新增散盘重组规则'
				vm.form.createdPersonId = vm.thisUser.userId;
				vm.form.createdPerson = vm.thisUser.nickName;
				vm.dialogFormVisible = true
			},
			dele(){
				var vm = this
				console.log(this.delSelection.length)
				if(vm.delSelection.length === 0) {
	        		vm.$message({type: 'info', message: '请选择行'});
	        		return;
	        	}else {
	        		var selection = vm.delSelection
	        		var arr = [], o = {}
					selection.forEach(function(el) {
						arr.push(el.id)
					})	
					o.id = arr
					vm._comfirm('确定删除？')
        		.then((function() {        			
        			return vm._ajax({url: vm.rootAPI + 'discreterestructrules/delete', param: o, arr:true})
        		}).bind(this))
        		.then((function(d) {
        			vm._ajax({url: vm.api + '/permission/tsysRoleUser/binDing', param: o, arr: true})
					vm.$message({type: 'success', message: '删除成功'});
					vm.searchTable()
        		}).bind(vm))	
        			.catch(vm._confirmCancle);
	        	}
	        	
	        	
			},
			quxiao(formName){
				var vm = this
				vm.form={
					id:null,
					name: '',
					threshold: '',
					floorAreaCode:'',
					remark:'',
				}
				vm.updatedPersonshow = false
				vm.dialogFormVisible=false
				 this.$refs[formName].resetFields();
			},
			save(formName){
				var vm = this
				console.log("这里是调试信息"+vm.form.id)
				vm.$refs[formName].validate((valid) => {
		          if (valid) {
		            	if(vm.form.id==null){
		            		//添加
		            		return vm._ajax({
										url: vm.rootAPI, 
										name: 'discreterestructrules/create', 
										param: vm.form, 
										}).then((d) => {
											if(d.state==0){
												vm.quxiao(formName)
												vm.searchTable();
												vm.$message({
				                                    type: 'success',
				                                    message: '新增成功!'
				                                });
											}else{
												 vm.$message.error(d.msg);
											}
											
						        		}, (d) => {
					                    vm.$message.error('添加失败');
					                })
		            	}else{
		            		//修改
		            		return vm._ajax({
										url: vm.rootAPI, 
										name: 'discreterestructrules/update', 
										param: vm.form, 
										}).then((d) => {
											if(d.state==0){
											vm.quxiao(formName)
						        			vm.searchTable();
						        			vm.$message({
				                                    type: 'success',
				                                    message: '修改成功!'
				                                });
											}else{
												 vm.$message.error(d.msg);
											}

						        		}, (d) => {
					                    vm.$message.error('修改失败');
					                })
		            	}
		          } else {
		            
		            return false;
		          }
        		});
			},
			
			
		}
	}
</script>

<style>
</style>