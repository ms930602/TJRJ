<template>
	<div>
		<el-form ref="searchForm" :model="searchForm">
			<!-- 查询条件 -->
			<searchInputItems>
				<searchInputItem name="货位编码">
					<inputItem :value.sync="searchForm.localCode" :maxlength="10"></inputItem>
					</searchInputItem>
				<searchInputItem name="时间">
					<dateEditorDaterange :dateValue.sync="searchForm.createdate"  type="datetimerange" ></dateEditorDaterange>
				</searchInputItem>
			</searchInputItems>
		</el-form>	
        <optionItems>
			<template slot="left">
				<el-button-group>
					<!--<iconBtn iconClass="el-icon-plus" content="新增" @click="add">新增</iconBtn>-->
					<!--<iconBtn iconClass="el-icon-minus" content="删除" @click="dele">删除</iconBtn>--> 
					<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
					<iconBtn iconClass="el-icon-refresh" content="重置" @click="reset">重置</iconBtn>
				</el-button-group>				
			</template>
		</optionItems>
		<elemTable :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange" @selectionChange="selectionChange">
			<!--<el-table-column type="selection" width="55"></el-table-column>-->
		    <el-table-column prop="localCode" label="货位编码">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.localCode">
		    			<span>{{scope.row.localCode}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="localdescript" label="货位描述">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.localdescript">
		    			<span>{{scope.row.localdescript}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="localOrginrfid" label="原始RFID编号">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.localOrginrfid">
		    			<span>{{scope.row.localOrginrfid}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="localNewrfid" label="新的RFID编号">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.localNewrfid">
		    			<span>{{scope.row.localNewrfid}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="descript" label="异常描述">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.descript">
		    			<span>{{scope.row.descript}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="status" label="处理状态">
		    	<template slot-scope="scope">
		    		<toolTip :content="_dicValue(scope.row.status, statusOpyions)">
		    			<tagItem :text="_dicValue(scope.row.status, statusOpyions)"></tagItem>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		  	<el-table-column label="操作">
		    	<template slot-scope="scope">
		    		<el-button-group>
		    			<iconBtn iconClass="el-icon-setting" v-if="scope.row.status==0" content="处理" @click="handling(scope.row)" ></iconBtn>   
		    		</el-button-group>		    		
		    	</template>
		    </el-table-column> 
		</elemTable>
		<el-dialog title="处理" :visible.sync="dialogTableVisible" width="30%">
			 	<el-form class="modal-form" :inline="true" :model="form" :rules="rules" ref="form" label-width="100px">
			 			<el-row >
			           			<el-form-item label="货位编码:">
				                   <span>{{this.form.localCode}}</span>
							    </el-form-item>
			           	</el-row>
			           	<el-row >
			           			<el-form-item label="货位描述:">
					    			<span>{{this.form.localdescript}}</span>
					    		</el-form-item>
			           	</el-row>
			           	<el-row >
			           			<el-form-item label="原货位RFID:">
							    	<span>{{this.form.localOrginrfid}}</span>
							    </el-form-item>
			           	</el-row>
			           	<el-row >
			           			<el-form-item label="新货位RFID:"  prop='localNewrfid'>
				                   <el-input  v-model="form.localNewrfid"   maxlength="24" style="width: 300px;"></el-input>
							    </el-form-item>
			           	</el-row>
			  </el-form>
			   <div slot="footer" class="dialog-footer">
			    <el-button @click="cacle('form')">取 消</el-button>
			    <el-button type="primary" @click="save('form')">保 存</el-button>
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
				dialogTableVisible:false,
				searchForm: {
					localCode: '',
					createdate: '',
					starttime:'',
					endtime:'',
				},
				statusOpyions:[],
				thisUser: local.get('userinfo'),
				form:{
					id:null,
					localId:null,
					localCode:null,
					localdescript:null,
					localOrginrfid:null,
					localNewrfid:null,
				},
				rules: {
			        localNewrfid: [
			          this._ruleRequired("新货位RFID"),
			          this._reglocalRFID()
			        ],
		      	},
			}
		},
		mounted() {
			this.getstatus();
		},
		methods: {
			dddd(val){
				console.log(val)
				this.$nextTick(function () {
		        	
		        	//document.querySelector(element)
		              new Cleave('.localNewrfidclass', {
		                  delimiter: '-',
		                  blocks: [2, 2, 2, 2, 2, 2],
		                  uppercase: false
		              });
		        });
			},
			onblur(fielname){
//	            this.$refs[formname].validate(fielname);
	        },
			getstatus(){
				return this._searchDic("LOCALLABELEXCEPTION_STATUS").then(
			        function(d) {
			          this.statusOpyions = this._dicKey(d);
			          this.searchTable()
			        }.bind(this)
			      );
			},
			handling(row){
		        
				this.form.id=row.id;
				this.form.localId=row.localId;
				this.form.localCode=row.localCode;
				this.form.localdescript=row.localdescript;
				this.form.localOrginrfid=row.localOrginrfid;
				this.form.localNewrfid=row.localNewrfid;	
				this.dialogTableVisible = true
			},
			cacle(formname){
				this.form={
					id:null,
					localId:null,
					localCode:null,
					localdescript:null,
					localOrginrfid:null,
					localNewrfid:null,	
				}
				this.$refs[formname].resetFields();
				this.dialogTableVisible=false;
			},
			save(formname){
				
				this.$refs[formname].validate(valid => {
		        if (valid) {
		            //编辑
		            Object.assign(this.form, {
		              updatedPersonId: this.thisUser.userId,
		              updatedPerson: this.thisUser.nickName
		            });
		            console.log(this.form)
		            return
		            this._ajax({
		              url: this.rootAPI,
		              name: "locallabelexception/update",
		              param: this.form
		            }).then(
		              (d => {
		                if (d.state == 0) {
		                  	this.$message({ type: "success", message: "处理成功" });
		                  	this.form={
								id:null,
								localId:null,
								localCode:null,
								localdescript:null,
								localOrginrfid:null,
								localNewrfid:null,	
							}
							this.$refs[formname].resetFields();
							this.dialogTableVisible=false;
		                } else {
		                  this.$message({
		                    type: "warning",
		                    message: "处理失败" // + d.msg
		                  });
		                }
		              }).bind(this)
		            );
		        } else {
		          return false;
		        }
		      });
			},
			searchTable() {
				Object.assign(this.searchForm, {
					pageNum: this.pageNum, 
					pageSize: this.pageSize
				})
				return this._ajax({
			        url: this.rootAPI,
			        name: "locallabelexception/list",
			        param: this.searchForm,
			        loading: "dataLoading"
			    }).then(this.renderTable);
			},
			reset(){
				var vm = this;
				vm.searchForm = {
					localCode: '',
					createdate: '',
					starttime:'',
					endtime:'',
				}
				this.handleCurrentChange(1);
			},
		}
	}
</script>

<style>
</style>