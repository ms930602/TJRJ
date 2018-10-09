<template>
	<div>
		<el-form ref="searchForm" :model="searchForm">
			<!-- 查询条件 -->
			<searchInputItems>
				<searchInputItem name="卷烟类型" >
						<selectInput :value.sync="searchForm.cigtype" @selectChange = "cigtypechange">
								<el-option 
								      v-for="item in cigtypeOptions"
								      :key="item.key"
								      :label="item.value"
								      :value="item.key">
								    </el-option>
						</selectInput>
				</searchInputItem>
				<searchInputItem name="卷烟名称" >
					<inputItem :value.sync="searchForm.materName" :maxlength="40"></inputItem>
						<!--<selectInput :value.sync="searchForm.materCode" filterable :clearable="true">
								<el-option
									v-for="item in materCodeOptions"
									:key="item.key"
									:label="item.label+item.value"
									:value="item.value">
								</el-option>
						</selectInput>-->
				</searchInputItem>
			</searchInputItems>
		</el-form>	
        <optionItems>
			<template slot="left">
				<el-button-group>
					<iconBtn iconClass="el-icon-plus" content="新增" @click="add">新增</iconBtn>
					<!--<iconBtn iconClass="el-icon-minus" content="删除" @click="dele">删除</iconBtn>-->
					<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
					<iconBtn iconClass="el-icon-refresh" content="重置" @click="reset">重置</iconBtn>
				</el-button-group>				
			</template>
		</optionItems>
		<elemTable :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange" @selectionChange="selectionChange">
			<!--<el-table-column type="selection" :selectable='checkboxrow' width="55"></el-table-column>-->
			<el-table-column type="expand">
		      <template slot-scope="props">
		        <el-form label-position="right" inline class="demo-table-expand">
		        	<el-row>
		        		<el-col :span="6">
		        			<el-form-item label="卷烟名称:">
					            <span>{{ props.row.materName }}</span>
					        </el-form-item>
		        		</el-col>
		        		<el-col :span="6">
		        			<el-form-item label="卷烟编码:">
					            <span>{{ props.row.materCode }}</span>
					        </el-form-item>
		        		</el-col>
		        		<el-col :span="6">
		        			<el-form-item label="卷烟品牌:">
					            <span>{{ props.row.materCigbrand }}</span>
					        </el-form-item>
		        		</el-col>
		        		<el-col :span="6">
		        			<el-form-item label="卷烟版本:">
					            <span>{{ props.row.materVersion }}</span>
					        </el-form-item>
		        		</el-col>
		        		
		        	</el-row>
		        	<el-row>
		        		<el-col :span="6">
		        			<el-form-item label="卷烟类型:">
					            <span v-if="props.row.cigtype==0">正式卷烟</span>
				    			<span v-if="props.row.cigtype==1">福样促试</span>
					        </el-form-item>
		        		</el-col>
		        		<el-col :span="6">
		        			<el-form-item label="卷烟子版本:">
					            <span>{{ props.row.subverName }}</span>
					        </el-form-item>
		        		</el-col>
		        		<el-col :span="6">
		        			<el-form-item label="卷烟版本:">
					            <span v-if="props.row.status==0">未处理</span>
				    			<span v-if="props.row.status==1">已处理</span>
					        </el-form-item>
		        		</el-col>
		        		<el-col :span="6">
		        			<el-form-item label="入库单号:">
					            <span>{{ props.row.entryOrder }}</span>
					        </el-form-item>
		        		</el-col>
		        	</el-row>
		        	<el-row>
		        		<el-col :span="6">
		        			<el-form-item label="批次号:">
				            	<span>{{ props.row.batchNo }}</span>
				          	</el-form-item>
		        		</el-col>
		        		<el-col :span="6">
		        			<el-form-item label="货位编号:">
					            <span>{{ props.row.localCode }}</span>
					        </el-form-item>
		        		</el-col>
		        		<el-col :span="6">
		        			<el-form-item label="不合格数量:">
				            	<span>{{ props.row.unqualifiedQuality }}</span>
				          	</el-form-item>
		        		</el-col>
		        		<el-col :span="6">
		        			<el-form-item label="不合格原因:">
		        				<span v-if="props.row.type==0">过期</span>
				    			<span v-if="props.row.type==1">变形</span>
				    			<span v-if="props.row.type==2">质量缺陷</span>
				          	</el-form-item>
		        		</el-col>
		        	</el-row>
		        </el-form>
		      </template>
		    </el-table-column>
		    <el-table-column prop="materCode" label="卷烟编码">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.materCode">
		    			<span>{{scope.row.materCode}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="materName" label="卷烟名称">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.materName">
		    			<span>{{scope.row.materName}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="batchNo" label="批次号">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.batchNo">
		    			<span>{{scope.row.batchNo}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="materVersion" label="卷烟版本名称">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.materVersion">
		    			<span>{{scope.row.materVersion}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="materCigbrand" label="品牌">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.materCigbrand">
		    			<span>{{scope.row.materCigbrand}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="unqualifiedQuality" label="数量(件)">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.unqualifiedQuality">
		    			<span>{{scope.row.unqualifiedQuality}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="trayRfid" label="托盘RFID编号">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.trayRfid">
		    			<span>{{scope.row.trayRfid}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="type" label="原因">
		    	<template slot-scope="scope">
		    		<tagItem :text="_dicValue(scope.row.type, unqualifiedtypeOptions)"></tagItem>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="cigtype" label="卷烟类型">
		    	<template slot-scope="scope">
		    		<tagItem :text="_dicValue(scope.row.cigtype, cigtypeOptions)"></tagItem>
		      	</template>
		    </el-table-column>
			<el-table-column prop="status" label="状态">
		    	<template slot-scope="scope">
		    		<toolTip :content="_dicValue(scope.row.status, unqualifiedstatusOptions)">
		    			<tagItem :text="_dicValue(scope.row.status, unqualifiedstatusOptions)"></tagItem>
		    		</toolTip>
		      	</template>
		    </el-table-column>
			<el-table-column label="操作" width="160">
		    	<template slot-scope="scope">
		    		<el-button-group>
		    			<iconBtn iconClass="el-icon-setting" content="已处理" @click="updatestatus(scope.row)" v-if="scope.row.status==0"></iconBtn>    
		    			<iconBtn iconClass="el-icon-edit" content="编辑" @click="modalEdit(scope.row)" v-if="scope.row.status==0"></iconBtn>    
					    <iconBtn iconClass="el-icon-minus" content="删除" @click="delRow(scope.row)" v-if="scope.row.status==0"></iconBtn>
		    		</el-button-group>		    		
		    	</template>
		    </el-table-column>
		</elemTable>
		 <el-dialog title="新增" :visible.sync="dialogTableVisible">
			 	<el-form class="modal-form" :inline="true" :model="form" :rules="rules" ref="form" label-width="100px">
			           <el-row>
				           	<el-form-item label="不合格商品"  prop='materName'>
			                   <el-input placeholder="请输入内容" v-model="this.form.materName" style="width: 220px;">
								    <el-button slot="append" icon="el-icon-search" @click="showproduct"></el-button>
								</el-input>
						    </el-form-item>
			           </el-row>
			           <el-row v-if="this.form.materName!=null">
			           		<el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
			           			<el-form-item label="商品品牌" >
		                   			<span>{{this.form.materCigbrand}}</span>
					    		</el-form-item>
			           		</el-col>
			           		<el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
			           			<el-form-item label="商品版本">
		                   			<span>{{this.form.materVersion}}</span>
					    		</el-form-item>
			           		</el-col>
			           </el-row>
			           <el-row v-if="this.form.materName!=null">
			           		<el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
			           			<el-form-item label="商品子版本">
		                   			<span>{{this.form.subverName}}</span>
					    		</el-form-item>
			           		</el-col>
			           		<el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
			           			<el-form-item label="商品类型">
					    			<span v-if="this.form.cigtype==0">正式卷烟</span>
					    			<span v-if="this.form.cigtype==1">福样促试</span>
					    		</el-form-item>
			           		</el-col>
			           </el-row>
			            <el-row v-if="this.form.materName!=null">
			           		<el-form-item label="货位"  prop='localCode'>
			                   <el-input placeholder="请输入内容" v-model="this.form.localCode" style="width: 220px;">
								    <el-button slot="append" icon="el-icon-search" @click="showproductlocalCode"></el-button>
								</el-input>
							</el-form-item>
			           </el-row>
			            <el-row v-if="this.form.localCode!=null">
			           		<el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
			           			<el-form-item label="批次号" >
		                   			<span>{{this.form.batchNo}}</span>
					    		</el-form-item>
			           		</el-col>
			           		
			           		<el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
			           			<el-form-item label="唯一码">
		                   			<span>{{this.form.soleCode}}</span>
					    		</el-form-item>
			           		</el-col>
			           </el-row>
			           <el-row v-if="this.form.localCode!=null">
			           		<el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
			           			<el-form-item label="托盘RFID">
		                   			<span>{{this.form.trayRfid}}</span>
					    		</el-form-item>
			           		</el-col>
			           		<el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
			           			<el-form-item label="托盘编号">
					    			<span>{{this.form.trayCode}}</span>
					    		</el-form-item>
			           		</el-col>
			           </el-row>
					    <hr/>
                		<el-form-item label="不合格数量"  prop='unqualifiedQuality'>
				    		<el-input-number style="width: 220px;" v-model="form.unqualifiedQuality" controls-position="right" :min="1" :max="20"></el-input-number>
				      	</el-form-item>
						<el-form-item label="不合格类型"  prop='type'>
				    		<selectInput style="width: 220px;"  :value.sync="form.type" filterable placeHolder="请选择">
							    <el-option 
							      v-for="item in unqualifiedtypeOptions"
							      :key="item.key"
							      :label="item.value"
							      :value="item.key">
							    </el-option>
							</selectInput>
				      	</el-form-item>
						<el-form-item label="备注"  prop='remark'>
				    		<inputItem :value.sync="form.remark" :maxlength="40" style="width: 220px;"></inputItem>
				      	</el-form-item>
			  </el-form>
			   <div slot="footer" class="dialog-footer">
			    <el-button @click="cacle('form')">取 消</el-button>
			    <el-button type="primary" @click="saveUnqualifiedproduct('form')">保 存</el-button>
			  </div>
		</el-dialog>
		<unqualifiedproductModel  v-if="modalShow" @close="modalClose" :modalshow='modalShow' @selectList="selectList"></unqualifiedproductModel>
		<unqualifiedproductlocalModel v-if = "modalShowLocal" @close="modalCloseLocal" :modalShowLocal='modalShowLocal' @selectlocal="selectlocal" :materCode ="materCodelocal" :subverId="subverIdlocal" ></unqualifiedproductlocalModel>
	</div>
</template>

<script>
	import mixin from '../../mixin/mixin.js'
	import local from '../../local.js'
	import unqualifiedproductModel from "../component/modal/unqualifiedproductModel.vue";
	import unqualifiedproductlocalModel from "../component/modal/unqualifiedproductlocalModel.vue";
	export default {
		mixins: [mixin],
		components: {unqualifiedproductModel,unqualifiedproductlocalModel},
		data() {
			return {
				materCodelocal:null,
				subverIdlocal:null,
				modalShowLocal:false,
				dialogTableVisible:false,
				searchForm:{
					cigtype:'0',
					materName:'',
				},
				form:{
					id:null,
			        batchNo:null,
			        entryOrder:null,
			        trayRfid:null,
			        materCode:null,
			        materName:null,
			        materVersion:null,
			        materCigbrand:null,
			        soleCode:null,
			        localCode:null,
			        unqualifiedQuality:null,
			        status:0,
			        trayCode:null,
			        type:null,
			        remark:null,
			        enclosure:null,
			        cigtype:null,
			        subverId:null,
			        subverName:null
				},
				userinfo: local.get("userinfo"),
		      	rules: {
			        materName: [
			          this._ruleRequired("不合格商品"),
			        ],
			        localCode: [
			          this._ruleRequired("货位"),
			        ],
			        unqualifiedQuality:[
			        	this._ruleRequired("不合格数量"),
			        ],
			        type:[
			        	this._ruleRequired("不合格类型"),
			        ]
		      	},
				cigtypeOptions:[],
				materCodeOptions:[],
				unqualifiedstatusOptions:[],
				unqualifiedtypeOptions:[],
				thisUser: local.get('userinfo'),
			}
		},
		mounted() {
			this.getType();
//			this.getmaterinfo();
			this.getUNQUALIFIED_STATUS()
		},
		methods: {
			selectlocal(val){
				if(val.batchNo!=null){
					/**
			         * 查询入库信息
			         */
			        this._ajax({
		              url: this.rootAPI,
		              name: "entrymainorder/selectEntrymainor",
		              param: {batchNo:val.batchNo}
		            }).then(
		              (d => {
		                if (d.state == 0) {
		                	if(d.aaData.length!=0){
		                		this.form.entryOrder = d.aaData[0].orderNumber
		                	}else{
		                		this.$message({
				                    type: "warning",
				                    message: "数据异常" // + d.msg
				                  });
		                	}
		                	
		                } else {
		                  this.$message({
		                    type: "warning",
		                    message: "获取数据失败" // + d.msg
		                  });
		                }
		              }).bind(this)
		            );
				}
		        this.form.batchNo=val.batchNo
		        this.form.trayRfid=val.trayRfid
		        this.form.soleCode=val.soleCode
		        this.form.localCode=val.localCode
		        this.form.trayCode=val.trayCode
		       
			},
			showproductlocalCode(){
				this.modalShowLocal = true;
			},
			modalCloseLocal(){
				this.modalShowLocal = false;
			},
			checkboxrow(index,row){
				if(row.status==1){
					return 1;//可勾选
				}else{
					return 0;//不可勾选
				}
			},
			updatestatus(row){
				this.confirm(
		        "确认已处理？",
		        function() {
		        	row.status = 1
		          this._ajax({
		            url: this.rootAPI + "unqualifiedproduct/update",
		            param: row,
		            arr: true
		          }).then(
		            function(d) {
		              if (d.state == 0) {
		                	this.$message({ type: "success", message: "已处理" });
		              } else {
		                	this.$message({ type: "warning", message: "处理失败" });
		              }
		              this.handleCurrentChange(1);
		            }.bind(this)
		          );
		        }.bind(this)
		      );
				
			},
			selectList(val){
				this.form.materCode = val.materCode
			    this.form.materName=val.materName
		        this.form.materVersion=val.materVersion
		        this.form.materCigbrand=val.materCigbrand
		        this.form.cigtype=val.cigtype
		        this.form.subverId=val.subverId
		        this.form.subverName=val.subverName
		        this.materCodelocal=val.materCode
				this.subverIdlocal=val.subverId
				
				
				
				this.form.batchNo=null
		        this.form.trayRfid=null
		        this.form.soleCode=null
		        this.form.localCode=null
		        this.form.trayCode=null
			},
			showproduct(){
				this.modalShow = true;
			},
			cacle(formname){
				this.form={
					id:null,
			        batchNo:null,
			        entryOrder:null,
			        trayRfid:null,
			        materCode:null,
			        materName:null,
			        materVersion:null,
			        materCigbrand:null,
			        soleCode:null,
			        localCode:null,
			        unqualifiedQuality:null,
			        status:0,
			        trayCode:null,
			        type:null,
			        remark:null,
			        enclosure:null,
			        cigtype:null,
			        subverId:null,
			        subverName:null
				}
				this.$refs[formname].resetFields();
				this.dialogTableVisible=false;
			},
			saveUnqualifiedproduct(formname){
				
			      this.$refs[formname].validate(valid => {
			        if (valid) {
			          if (this.form.id!=null) {
			            //编辑
			            Object.assign(this.form, {
			              updatedPersonId: this.userinfo.userId,
			              updatedPerson: this.userinfo.nickName
			            });
			            this._ajax({
			              url: this.rootAPI,
			              name: "unqualifiedproduct/update",
			              param: this.form
			            }).then(
			              (d => {
			                if (d.state == 0) {
			                  this.$message({ type: "success", message: "保存成功" });
			                  this.form={
									id:null,
							        batchNo:null,
							        entryOrder:null,
							        trayRfid:null,
							        materCode:null,
							        materName:null,
							        materVersion:null,
							        materCigbrand:null,
							        soleCode:null,
							        localCode:null,
							        unqualifiedQuality:null,
							        status:0,
							        trayCode:null,
							        type:null,
							        remark:null,
							        enclosure:null,
							        cigtype:null,
							        subverId:null,
							        subverName:null
								}
								this.dialogTableVisible=false;
								this.searchTable()
			                } else {
			                  this.$message({
			                    type: "warning",
			                    message: "保存失败" // + d.msg
			                  });
			                }
			              }).bind(this)
			            );
			          } else {
			            //新增
			            Object.assign(this.form, {
			              createdPersonId: this.userinfo.userId,
			              createdPerson: this.userinfo.nickName
			            });
			            this._ajax({
			              url: this.rootAPI,
			              name: "unqualifiedproduct/create",
			              param: this.form
			            }).then(
			              (d => {
			                if (d.state == 0) {
			                  this.$message({ type: "success", message: "保存成功" });
			                  this.form={
									id:null,
							        batchNo:null,
							        entryOrder:null,
							        trayRfid:null,
							        materCode:null,
							        materName:null,
							        materVersion:null,
							        materCigbrand:null,
							        soleCode:null,
							        localCode:null,
							        unqualifiedQuality:null,
							        status:0,
							        trayCode:null,
							        type:null,
							        remark:null,
							        enclosure:null,
							        cigtype:null,
							        subverId:null,
							        subverName:null
								}
								this.dialogTableVisible=false;
								this.searchTable()
			                } else {
			                  this.$message({
			                    type: "warning",
			                    message: "保存失败" // + d.msg
			                  });
			                }
			              }).bind(this)
			            );
			          }
			        } else {
			          return false;
			        }
			      });
    
				
			},
			getUNQUALIFIEDPRODUC_TTYPE(){
				return this._searchDic("UNQUALIFIEDPRODUC_TTYPE").then(
			        function(d) {
			          this.unqualifiedproducttypeoptions = this._dicKey(d);
			        }.bind(this)
			      );
			},
			getUNQUALIFIED_STATUS(){
				return this._searchDic("UNQUALIFIED_STATUS").then(
			        function(d) {
			          this.unqualifiedstatusOptions = this._dicKey(d);
			          this.getUNQUALIFIED_TYPE()
			        }.bind(this)
			      );
			},
			getUNQUALIFIED_TYPE(){
				return this._searchDic("UNQUALIFIED_TYPE").then(
			        function(d) {
			          this.unqualifiedtypeOptions = this._dicKey(d);
			          this.searchTable()
			        }.bind(this)
			      );
			},
			cigtypechange(val){
				this.getmaterinfo();
			},
			getType(){
				return this._searchDic("MATERIAL_TYPE").then(
			        function(d) {
			          this.cigtypeOptions = this._dicKey(d);
			        }.bind(this)
			      );
			},
			getmaterinfo(){
				var vm = this
						vm.materCodeOptions = []
						return vm._ajax({
							url: vm.rootAPI, 
							name: 'materialinfo/queryAlllist', 
							param: {cigtype:this.searchForm.cigtype}, 
							}).then((d) => {
								console.log(d)
								if(d.state === 0){
									var aaData = d.aaData
									if(this.searchForm.cigtype==0){
										aaData.forEach(function(el) {
											vm.materCodeOptions.push({
												value: el.materCode,
				      							label: el.materName
											})
										})	
									}else{
										aaData.forEach(function(el) {
											vm.materCodeOptions.push({
												value: el.code,
				      							label: el.name
											})
										})	
									}
								}
			        		}, (d) => {
			                    this.$message.error('物料获取失败');
			                })
				},
			searchTable() {
				Object.assign(this.searchForm, {
					pageNum: this.pageNum, 
					pageSize: this.pageSize
				})
				return this._ajax({
			        url: this.rootAPI,
			        name: "unqualifiedproduct/list",
			        param: this.searchForm,
			        loading: "dataLoading"
			    }).then(this.renderTable);
			},
			modalEdit(row){
				/**
				 * 查询
				 */
				this._ajax({
		              url: this.rootAPI,
		              name: "unqualifiedproduct/queryById",
		              param: {id:row.id}
		            }).then(
		              (d => {
		                if (d.state == 0) {
								this.form.id=d.aaData.id,
						        this.form.batchNo=d.aaData.batchNo
						        this.form.entryOrder=d.aaData.entryOrder
						        this.form.trayRfid=d.aaData.trayRfid
						        this.form.materCode=d.aaData.materCode
						        this.form.materName=d.aaData.materName
						        this.form.materVersion=d.aaData.materVersion
						        this.form.materCigbrand=d.aaData.materCigbrand
						        this.form.soleCode=d.aaData.soleCode
						        this.form.localCode=d.aaData.localCode
						        this.form.unqualifiedQuality=d.aaData.unqualifiedQuality
						        this.form.status=d.aaData.status
						        this.form.trayCode=d.aaData.trayCode
						        this.form.type=d.aaData.type
						        this.form.remark=d.aaData.remark
						        this.form.enclosure=d.aaData.enclosure
						        this.form.cigtype=d.aaData.cigtype
						        this.form.subverId=d.aaData.subverId
						        this.form.subverName=d.aaData.subverName
						        
						        this.materCodelocal=d.aaData.materCode
								this.subverIdlocal=d.aaData.subverId
		                } else {
		                  this.$message({
		                    type: "warning",
		                    message: "获取数据失败" // + d.msg
		                  });
		                }
		              }).bind(this)
		            );
				this.dialogTableVisible=true;
			},
			dele() {
		      if (this.delSelection.length === 0) {
		        this.$message({ type: "info", message: "请选择行" });
		      } else {
		        let selection = this.delSelection;
		        var arr = [],
		          o = {};
		        selection.forEach(function(el) {
		          arr.push(el.id);
		        });
		        o.id = arr;
		        this.delsubmit(o);
		      }
		    },
		    delRow(row) {
		      var o = {
		        id: [row.id]
		      };
		      this.delsubmit(o);
		    },
		    delsubmit(o) {
		      this.confirm(
		        "确定删除？",
		        function() {
		          this._ajax({
		            url: this.rootAPI + "unqualifiedproduct/delete",
		            param: o,
		            arr: true
		          }).then(
		            function(d) {
		              if (d.state == 0) {
		                this.$message({ type: "success", message: "删除成功" });
		              } else {
		                this.$message({ type: "warning", message: "删除失败" });
		              }
		              this.handleCurrentChange(1);
		            }.bind(this)
		          );
		        }.bind(this)
		      );
		    },
			reset(){
				var vm = this;
				vm.searchForm = {
					cigtype:'0',
					materName:'',
				}
//				this.getmaterinfo()
				this.handleCurrentChange(1);
			},
			add(){
//				this.modalType = "add";
//	      		this.modalShow = true;
//	      		this.modalObj = {};
//				this.getUNQUALIFIEDPRODUC_TTYPE();
				this.dialogTableVisible=true;
			},
		}
	}
</script>

<style>
</style>