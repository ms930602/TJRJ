<template>
<!--LED显示器管理-->
	<div>
		<el-form ref="searchForm" :model="searchForm" label-width="80px"  :inline="true" class="demo-form-inline" >
		  <el-form-item label="品牌:">
		    <el-input v-model="searchForm.brand" :maxlength="10" style="width:200px;"></el-input>
		  </el-form-item>
		  <el-form-item label="型号:">
		    <el-input v-model="searchForm.spec" :maxlength="10" style="width:200px;"></el-input>
		  </el-form-item>
		  <el-form-item label="厂家:">
		    <el-input v-model="searchForm.factory" :maxlength="10" style="width:200px;"></el-input>
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
		    <el-table-column prop="id" label="id" hidden="true" v-if="hidden">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.id">
		    			<span>{{scope.row.id}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="brand" label="品牌">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.brand">
		    			<span>{{scope.row.brand}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="spec" label="型号">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.spec">
		    			<span>{{scope.row.spec}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
			<el-table-column prop="size" label="尺寸">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.size">
		    			<span>{{scope.row.size}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
			<el-table-column prop="serialNum" label="编号\序列号">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.serialNum">
		    			<span>{{scope.row.serialNum}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
			<el-table-column prop="passwayId" label="通道ID">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.passwayId">
		    			<span>{{scope.row.passwayId}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>


			<el-table-column prop="passwayId" label="通道ID">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.passwayId">
		    			<span>{{scope.row.passwayId}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
			<el-table-column prop="passwayNo" label="通道编号">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.passwayNo">
		    			<span>{{scope.row.passwayNo}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
			<el-table-column prop="resolvRate" label="分辨率">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.resolvRate">
		    			<span>{{scope.row.resolvRate}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
			<el-table-column prop="factory" label="厂家">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.factory">
		    			<span>{{scope.row.factory}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
			<el-table-column prop="productDate" label="生产日期">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.productDate">
		    			<span>{{scope.row.productDate}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>

			<el-table-column prop="charge" label="责任人">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.charge">
		    			<span>{{scope.row.charge}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>

	<!--	    <el-table-column prop="createdPerson" label="创建人">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.createdPerson">
		    			<span>{{scope.row.createdPerson}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="createdDate" label="创建时间">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.createdDate">
		    			<span>{{scope.row.createdDate}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column> -->

<!--			<el-table-column prop="updatedPerson" label="更新人">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.updatedPerson">
		    			<span>{{scope.row.updatedPerson}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="updatedDate" label="更新时间">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.updatedDate">
		    			<span>{{scope.row.updatedDate}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column> -->
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
		      		<el-input v-model="form.id" type="number"  style='width: 220px;'></el-input>
		   	 	</el-form-item>
		    	<el-form-item label="品牌" label-width="120px">
		      		<el-input v-model="form.brand" r  :maxlength="45" type="text" style='width: 220px;'></el-input>
		   	 	</el-form-item>
				<el-form-item label="型号" label-width="120px">
		      		<el-input v-model="form.spec" :maxlength="45" type="text" style='width: 220px;'></el-input>
		   	 	</el-form-item>
				<el-form-item label="尺寸" label-width="120px">
		      		<el-input v-model="form.size"  :maxlength="45" type="text"  style='width: 220px;'></el-input>
		   	 	</el-form-item>

				<el-form-item label="编号\序列号" label-width="120px">
		      		<el-input v-model="form.serialNum" :maxlength="45" type="text" style='width: 220px;'></el-input>
		   	 	</el-form-item>

				<el-form-item label="通道ID" label-width="120px">
		      		<el-input v-model="form.passwayId" :maxlength="10" type="number" style='width: 220px;'></el-input>
		   	 	</el-form-item>

				<el-form-item label="通道编号" label-width="120px">
		      		<el-input v-model="form.passwayNo" :maxlength="45" type="text" style='width: 220px;'></el-input>
		   	 	</el-form-item>
				<el-form-item label="分辨率" label-width="120px">
		      		<el-input v-model="form.resolvRate" :maxlength="45" type="text" style='width: 220px;'></el-input>
		   	 	</el-form-item>


				<el-form-item label="厂家" label-width="120px">
		      		<el-input v-model="form.factory" :maxlength="45" type="text" style='width: 220px;'></el-input>
		   	 	</el-form-item>
				<el-form-item label="生产日期" label-width="120px">
		      		<!--<el-input v-model="form.productDate"  type="datetime" style='width: 220px;'></el-input> -->
					<el-date-picker v-model="form.productDate" type="datetime" format='yyyy-MM-dd' value-format="yyyy-MM-dd" style='width: 220px;' placeholder="选择日期时间"/>
		   	 	</el-form-item>
				<el-form-item label="责任人" label-width="120px">
		      		<el-input v-model="form.charge" :maxlength="45" type="text" style='width: 220px;'></el-input>
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
					brand: '',
					spec: '',
					factory:'',

				},
				options:[],
				pageSize:10,
				pageNum:0,
				tableData: [],
				datacount:0,
				thisUser: local.get('userinfo'),
				form:{
					id:null,
					brand:'',
					spec: '',
					size:'',
					factory:'',
					serialNum:'',
					passwayNo:'',
					resolvRate:'',
					productDate:'',
					charge:'',
					passwayId:'',
				},
				yanzareaCode:'',
				updatedPersonshow:false,
				rules: {
                    brand: [
                        {required: true, message:'品牌不能为空'}
                    ],
                    spec: [
                        {required: true, message: '型号不能为空'}
					],
					size: [
                        {required: true, message: '尺寸不能为空'}
					],
					factory: [
                        {required: true, message: '工厂不能为空'}
					],
					serialNum: [
                        {required: true, message: '编号/序列号不能为空'}
					],
					passwayId: [
                        {required: true, message: '通道id不能为空'}
					],
					passwayNo: [
                        {required: true, message: '通道编号不能为空'}
					],
					resolvRate: [
                        {required: true, message: '分辨率不能为空'}
					],
					productDate: [
                        {required: true, message: '生产日期不能为空'}
					],
					charge: [
                        {required: true, message: '责任人不能为空'}
                    ],
                },
			}
		},
		mounted() {
			this.searchTable()
		},
		methods: {

			//查询表格，初次加载数据
			searchTable() {
				var vm = this
				Object.assign(this.searchForm, {
					pageNum: vm.pageNum, 
					pageSize: vm.pageSize
				})
				return vm._ajax({
					url: vm.rootAPI, 
					name: 'devLed/list', 
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
				vm.dialogtitle='LED显示器'
				vm.form.id=value.id
				vm.form.brand=value.brand
				vm.form.spec= value.spec
				vm.form.size= value.size
				vm.form.serialNum= value.serialNum
				vm.form.passwayId=value.passwayId
				vm.form.passwayNo=value.passwayNo
				vm.form.resolvRate=value.resolvRate
				vm.form.productDate=value.productDate
				vm.form.factory=value.factory
				vm.form.charge=value.charge
				vm.yanzareaCode=value.brand
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
								name: 'devLed/delete', 
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
				Object.assign(this.searchForm, {
					brand:'',
					spec:'',
					factory:''
				})
				this.handleCurrentChange(1)
			},
			add(){
				var vm = this;
				console.log(vm.thisUser)
				console.log(vm.form)
				vm.form={};
				vm.dialogtitle='新增LED显示器'
				vm.form.createdPersonId = vm.thisUser.userId;
				vm.form.createdPerson = vm.thisUser.nickName;
				console.log(vm.form.createdPersonId)
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
        			return vm._ajax({url: vm.rootAPI + 'devLed/delete', param: o, arr:true})
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
					brand:'',
					spec: '',
					size:'',
					factory:'',
					serialNum:'',
					passwayNo:'',
					resolvRate:'',
					productDate:'',
					charge:'',
					passwayId:'',
				}
				vm.updatedPersonshow = false
				vm.dialogFormVisible=false
				 this.$refs[formName].resetFields();
			},
			save(formName){
				var vm = this
				vm.$refs[formName].validate((valid) => {
		          if (valid) {
		            	if(vm.form.id==null){
		            		//添加
		            		return vm._ajax({
										url: vm.rootAPI, 
										name: 'devLed/create', 
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
							console.log(vm.form.productDate)
		            		//修改
		            		return vm._ajax({
										url: vm.rootAPI, 
										name: 'devLed/update', 
										param: vm.form, 
										}).then((d) => {
											console.log(d)
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