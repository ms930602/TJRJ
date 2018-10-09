<template>
	<div>

		<el-row>

			<el-card class="box-card" style="margin-right: 5px; margin-left: 5px;" shadow="hover">
		  		<div>

			<el-form class="modal-form" :inline="true" :model="form" :rules="rules" ref="form" label-width="100px">
               

                
		                <el-form-item label="入库订单"  prop='orderNumber'  v-if="showid">
				   	 		<inputItem :value.sync="form.orderNumber" :maxlength="20"  style="width: 200px;"></inputItem>
				    	</el-form-item>
					    
				
		              	<el-form-item label="物流单号"  prop='shipmentNumber'>
			    			<inputItem :value.sync="form.shipmentNumber"   @change="editcaheckshipmentNumberchange(form.shipmentNumber)" :maxlength="40" style="width: 200px;"></inputItem>
			      		</el-form-item>
				
						
		              <el-form-item label="合同号"  prop='contractNumber'>
			    		<inputItem :value.sync="form.contractNumber"  @change="editcheckcontractNumberchange(form.contractNumber)"  :maxlength="40" style="width: 200px;"></inputItem>
			      	</el-form-item>
				
			
		              <el-form-item label="移出仓库"  prop='originWarehouseCode'>
		              	<el-select
						    style="width: 200px;"
						    v-model="form.originWarehouseCode"
						    filterable
						    remote
						    reserve-keyword
						    placeholder="请输入关键词"
						    @change = "outboundWareCodeChange"
						    :remote-method="getwarehouseinfo"
						    :loading="loading">
						    <el-option
						      v-for="item in warehouseOption"
						      :key="item.value"
						      :label="item.label+item.value"
						      :value="item.value">
						    </el-option>
						  </el-select>
			      	</el-form-item>

	                <el-form-item label="移入仓库"  prop='intoWarehouseCode'>
	                	<el-select
							style="width: 200px;"
						    v-model="form.intoWarehouseCode"
						    filterable
						    remote
						    reserve-keyword
						    placeholder="请输入关键词"
						    @change = "arrivalWareCodeChange"
						    :remote-method="getwarehouseinfo"
						    :loading="loading">
						    <el-option
						      v-for="item in warehouseOption"
						      :key="item.value"
						      :label="item.label+item.value"
						      :value="item.value">
						    </el-option>
						  </el-select>
			    	</el-form-item>
				
	                <el-form-item label="合同日期"  prop='contractDate'>
			   	 		<dateEditorDaterange :dateValue.sync="form.contractDate" type="date" style="width: 200px;"></dateEditorDaterange>
			    	</el-form-item>
      <!--
				<el-col :span="6">
	        <el-form-item label="总量（件）"  prop='totalQuality'>
			   	 		<inputItem :value.sync="form.totalQuality" :maxlength="10" style="width: 220px;"></inputItem>
			    	</el-form-item>
					</el-col>  -->



	        		<el-form-item label="车牌号"  prop='plateNumber'>
			   	 		<inputItem :value.sync="form.plateNumber" :maxlength="10" style="width: 200px;"></inputItem>
			    	</el-form-item>

	         		<el-form-item label="制单日期"  prop='shipmentDate'>			  
								<dateEditorDaterange :dateValue.sync="form.shipmentDate" type="date" style="width: 200px;"></dateEditorDaterange>
			    	</el-form-item>

				              <el-form-item label="承运单位"  prop='carrierUnitCode'>
				              	<el-select
								   style="width: 200px;"
								    v-model="form.carrierUnitCode"
								    filterable
								    remote
								    reserve-keyword
								    placeholder="请输入关键词"
								    @change = "carrierUnitChange"
								    :remote-method="getAllCarrierunitEntity"
								    :loading="loading">
								    <el-option
								      v-for="item in carrierUnitOption"
								      :key="item.value"
								      :label="item.label+item.value"
								      :value="item.value">
								    </el-option>
								  </el-select>
					      	</el-form-item>

	                <el-form-item label="发货日期"  prop='deliveryDate'>
			   	 		<dateEditorDaterange :dateValue.sync="form.deliveryDate" type="date" style="width: 200px;"></dateEditorDaterange>
			    	</el-form-item>

		              <el-form-item label="运输方式"  prop='transportCode' >
			    		<selectInput style="width: 200px;" :value.sync="form.transportCode" @selectChange="gettransportCode"  filterable placeHolder="请选择运输方式">
						    <el-option 
						      v-for="item in shippingtypeOption"
						      :key="item.value"
						      :label="item.label"
						      :value="item.value">
						    </el-option>
						</selectInput>
			      	</el-form-item>


	                <el-form-item label="承运人"  prop='carrier'>
			   	 		<inputItem :value.sync="form.carrier" :maxlength="10" style="width: 200px;"></inputItem>
			    	</el-form-item>

		            <el-form-item label="联系电话"  prop='phoneNumber'>
			    		<inputItem :value.sync="form.phoneNumber" :maxlength="40" style="width: 200px;"></inputItem>
			      	</el-form-item>


		            <el-form-item label="预约装车日期"  prop='reservationDate'>
			    	<dateEditorDaterange :dateValue.sync="form.reservationDate" type="date" style="width: 200px;"></dateEditorDaterange>
			      	</el-form-item>


        <!--
					<el-col :span="6">
	                <el-form-item label="入库完成时间"  prop='entryCompliteDate'>
							<dateEditorDaterange :dateValue.sync="form.entryCompliteDate" type="date" style="width: 220px;"></dateEditorDaterange>

			    	</el-form-item>
					</el-col>


					<el-col :span="6">
	                <el-form-item label="入库通道编号"  prop='entryChannelCode'>
			   	 		<inputItem :value.sync="form.entryChannelCode" :maxlength="10" style="width: 220px;"></inputItem>
			    	</el-form-item>
					</el-col>
        -->
		  		<el-row>
		          <el-form-item label="发货要求"  prop='deliveryRequire'>
			    		<inputItem :value.sync="form.deliveryRequire":maxlength="45" style="width: 200px;"></inputItem>
			      	</el-form-item>
	            <el-form-item label="物流单备注"  prop='shipmentRemark'>
			   	 		<inputItem :value.sync="form.shipmentRemark" :maxlength="45" style="width: 200px;"></inputItem>
			    	  </el-form-item>
		          <el-form-item label="备注"  prop='remark'>
			    		<inputItem :maxlength="45" :value.sync="form.remark" style="width: 200px;"></inputItem>
			      	</el-form-item>        
				</el-row>
		  </el-form>



		  		</div>
				</el-card>
				</el-row>
	

		<el-row>
			<el-col :span="14">
				<el-card class="box-card" style="margin-right: 5px; margin-top: 10px; margin-left: 5px;" shadow="hover">
				  <div slot="header" class="clearfix">
				    <span>明细信息</span>
				    <el-button-group style="float: right;">
								<iconBtn iconClass="el-icon-plus" content="添加明细" @click="adddetail('form')">添加明细</iconBtn>
					</el-button-group>
				  </div>


					<el-table :data="detailtableData" border style="width: 100%;padding:0"  @row-click="detailClick" :highlight-current-row="true">
						<el-table-column prop="id"  label="id"  v-if="showid"> </el-table-column>
				    <el-table-column prop="materCode"  label="物料编码" width="164px" > </el-table-column>
						<el-table-column prop="materCigbrand"  label="物料品牌"> </el-table-column>
				    <el-table-column prop="materName"  label="物料名称"> </el-table-column>
				    <el-table-column prop="materVersion"  label="物料版本" > </el-table-column>
						<el-table-column prop="subverName" label="子版本" width="120px">  </el-table-column>	
						<el-table-column prop="batchNo"  label="批次号" width="115px"> </el-table-column>
				    <el-table-column prop="quality" label="数量(件)" width="120px"> 
				    	<template slot-scope="scope">
			              	<!--<el-input-number v-model="scope.row.quality" @change="qualityBoxchange(scope.row)"  :min="0" :max="99999" label="数量"></el-input-number>-->
											<el-input-number v-model="scope.row.quality" @change="qualityBoxchange(scope.row)" style="width: 100px;" @keyup.native.enter="automatic(scope.row)" controls-position="right" :precision="0" :step="20" :min="0" :max="99999" label="数量"></el-input-number>
			            </template>
				    </el-table-column>
						<el-table-column prop="qualityBoxunit"  label="数量(万支)" width="95px"> </el-table-column>

				    <el-table-column label="操作" width="95px">
				      <template slot-scope="scope">
									<el-button-group>										    
										<iconBtn iconClass="el-icon-minus" content="删除" @click="deldetail(scope.$index,scope.row)"></iconBtn>
										<iconBtn iconClass="el-icon-edit" content="分配货位" @click="automatic(scope.row)"></iconBtn>
										<!--	<iconBtn iconClass="el-icon-search" content="查看出库货位" @click="detailClick(scope.row)" ></iconBtn> -->
									</el-button-group>	
				      </template>
				    </el-table-column>
				  </el-table>		
				</el-card>
				</el-col>
			<el-col :span="10">
				<el-card class="box-card" style="margin-right: 5px; margin-top: 10px; margin-left: 5px;" shadow="hover">
				  <div slot="header" class="clearfix">


					<el-form ref="searchForm" :model="searchForm">
						<!-- 查询条件 -->
						<searchInputItems>
							<searchInputItem name="货位编码">
								<inputItem :value.sync="searchForm.localCode" :maxlength="10"></inputItem>
							</searchInputItem>
							<el-button-group style="float: right;">
								<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
								<iconBtn iconClass="el-icon-refresh" content="重置" @click="reset">重置</iconBtn>
							</el-button-group>
						</searchInputItems>
					</el-form>


					<elemTable :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange">
					    

							<el-table-column prop="id" label="编号" v-if="showid">
					    	<template slot-scope="scope">
					    		<toolTip :content="scope.row.id">
					    			<span>{{scope.row.id}}</span>
					    		</toolTip>
					      	</template>
					    </el-table-column>


						
							<el-table-column prop="localId" label="货位id" v-if="showlocalid">
					    	<template slot-scope="scope">
					    		<toolTip :content="scope.row.localId">
					    			<span>{{scope.row.localId}}</span>
					    		</toolTip>
					      	</template>
					    </el-table-column>
						  


					 		<el-table-column prop="orderdetailId" label="入库单详情id" v-if="showorderdetailid">
					    	<template slot-scope="scope">
					    		<toolTip :content="scope.row.orderdetailId">
					    			<span>{{scope.row.orderdetailId}}</span>
					    		</toolTip>
					      	</template>
					    </el-table-column>



							<el-table-column prop="localCode" label="货位编码" v-if="showid">
					    	<template slot-scope="scope">
					    		<toolTip :content="scope.row.localCode">
					    			<span>{{scope.row.localCode}}</span>
					    		</toolTip>
					      	</template>
					    </el-table-column>


						<el-table-column prop="descript" label="货位描述">
					    	<template slot-scope="scope">
					    		<toolTip :content="scope.row.descript">
					    			<span>{{scope.row.descript}}</span>
					    		</toolTip>
					      	</template>
					    </el-table-column>


							<el-table-column prop="cigsmokeQuality" label="分配数量(件)">
					    	<template slot-scope="scope">
					    		<toolTip :content="scope.row.cigsmokeQuality">
					    			<span>{{scope.row.cigsmokeQuality}}</span>
					    		</toolTip>
					      	</template>
					    </el-table-column>


						<el-table-column prop="realinQuality" label="实入数量(件)">
					    	<template slot-scope="scope">
					    		<toolTip :content="scope.row.realinQuality">
					    			<span>{{scope.row.realinQuality}}</span>
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

								<el-table-column prop="soleCode" label="唯一码">
					    	<template slot-scope="scope">
					    		<toolTip :content="scope.row.soleCode">
					    			<span>{{scope.row.soleCode}}</span>
					    		</toolTip>
					      	</template>
					    </el-table-column>


					    <el-table-column label="操作">
					    	<template slot-scope="scope">
					    		<el-button-group>
					    			<iconBtn iconClass="el-icon-edit" content="调整入库货位" @click="adjustment(scope.row)" ></iconBtn> 
									<!--<iconBtn iconClass="el-icon-check" content="确定入库完成" @click="confirms(scope.row)" ></iconBtn>  -->  
					    		</el-button-group>		    		
					    	</template>
					    </el-table-column>
					</elemTable>
					

			</div>
			</el-card>
			</el-col>
	

		<div style="float: right;padding:20px;">

	  			<el-button @click="cancel('form')">取 消</el-button>
			    <el-button type="info" @click="roughstate('form')">保存为草稿</el-button>
					<el-button type="primary" @click="confirmentry('form')">确认生成入库单</el-button>

		</div>
		</el-row>




		<warehoumaterilModel  v-if="modalShow"  @close="modalClose" :modalshow='modalShow' @selectList="selectList" :srow="serow" :forms="form" :mainorderId="mainorderId"></warehoumaterilModel>

		<entlocalmapUpModel  v-if="modalShowUp" :modaltype="modalType" @close="modalCloseUp" :modalShowUp='modalShowUp' :tableRow='modalObj' @refSearchTable="refSearchTable"></entlocalmapUpModel>
		</div>
</template>

<script>
	import mixin from '../../mixin/mixin.js'
	import local from '../../local.js'
	import configs from "../../configs.js";
	import warehoumaterilModel from "../component/modal/warehoumaterilModel.vue";
	import entlocalmapUpModel from "../component/modal/entlocalmapUpModel.vue";
export default {
  mixins: [mixin],
  components: {warehoumaterilModel,entlocalmapUpModel},
  data() {
    return {
   		shipmentNumber:'',
    	contractNumber:'',
		mainorderId:null,
    	checkshipmentNumber:'',
    	checkcontractNumber:'',
			searchForm:{
    		localCode:'',
    		materCode:'',
    		//uuid:'',
    	},
    	detailtableData:[],
    	detailtableData2:[{}],

      form: {
        		id: null,
						orderNumber: "",
						shipmentNumber: "",
						shipmentDate: moment(Date.parse(new Date())).format("YYYY-MM-DD"),
						plateNumber: "",
						totalQuality: "",
						deliveryDate: moment(Date.parse(new Date())).format("YYYY-MM-DD"),
						transportType: "",
						transportCode:"3",
						carrier: "",
						phoneNumber: "",
						carrierUnit: "",
						carrierUnitCode: "",
						reservationDate: moment(Date.parse(new Date())).format("YYYY-MM-DD"),
						shipmentRemark: "",
						contractNumber: "",
						contractDate: moment(Date.parse(new Date())).format("YYYY-MM-DD"),
						originWarehouseCode: "",
						originWarehouseName: "",
						intoWarehouseCode: "",
						intoWarehouseName: "",
						deliveryRequire: "",
						remark: "",
						entryCompliteDate: "",
						status: "",
						entryChannelCode: "",
    },

		  modalShowUp:false,
 

      passwayOption:[],
      warehouseOption:[],
		 shippingtypeOption:[],  
				//
		//defaultTransport: '3',
      carrierUnitOption:[],
      userinfo: local.get("userinfo"),
      	rules: {
	        shipmentNumber: [          
	          	this._ruleRequired("物流单号"),
	          	this._ruleExist(configs.rootAPI + "cigaretteEntry/checkshipmentNumber", "物流单",this)
	        ],

			/*
	        orderNumber: [
	          	this._ruleRequired("入库订单编号"),
	        ],  

			*/             
	        originWarehouseCode:[
	          	this._ruleRequired("移出仓库"),
	        ],
	         intoWarehouseCode:[
	          	this._ruleRequired("移入仓库"),
	          	//this._ruleExist(configs.rootAPI + "outmainorder/checkcontractNumber", "物流单",{})
	        ],
	        contractNumber:[
	          	this._ruleRequired("合同号"),
				this._ruleExist(configs.rootAPI + "cigaretteEntry/checkcontractNumber", "合同号",this)
	        ],
	        contractDate:[
	          	this._ruleRequired("合同日期"),
	        ],
	        plateNumber:[
	        	//this._ruleRequired("车牌号"),
						this._ruleLicensePlate(),
	        ],
				   phoneNumber:[
	        	this._ruleMobile(),
	        ],

      	},
			      	serow:[],

							showid:false,

							showlocalid : false,

							showorderdetailid : false,

							cachequality:[],

    };
  },
  mounted() {

  	console.log(this.$route.query.id==null)
  	this.getpassway();


  	this.getwarehouseinfo();
	this.getAllShippingtypeEntity();
	this.getAllCarrierunitEntity();

	//console.log(this.carrierUnitOption);
  },
  methods: {
		qualityBoxchange(row){
  		//row.qualityBoxunit = row.quality*row.converCoef
			if(row.quality==null||row.quality==''||row.quality==undefined){
  			row.quality = 0
  			row.qualityBoxunit = 0.00.toFixed(2)
  		}else{
  			row.qualityBoxunit = (row.quality*row.converCoef).toFixed(2)
  		}
  	},

	editcaheckshipmentNumberchange(value){
  		if(this.form.id==null){
  			this.checkshipmentNumber= value
  		}
  	},
  	editcheckcontractNumberchange(value){
  		if(this.form.id==null){
  			this.checkcontractNumber = value
  		}
  	},

  	deldetail(index,row){
  		//this.detailtableData.splice(index, 1);
  			this.confirm(
		        "确定删除？",
		        function() {
		          this._ajax({
		            url: this.rootAPI + "cigaretteEntry/deleteOrderDetail",
		            param: {id:row.id}
		          }).then(
		            function(d) {
		              if (d.state == 0) {
		                this.$message({ type: "success", message: "删除成功" });
										this.cachequality.splice(index,1) ;   
		                this.getentryorderdetail();
		              } else {
		                this.$message({ type: "warning", message: "删除失败" });
		              }
		              //this.handleCurrentChange(1);
									this.refSearchTable();
		            }.bind(this)
		          );
		        }.bind(this)
		    );		
  	},

		
  	selectList(tableArr){


 					//debugger;


				if(this.form.id==null){

  		console.log(tableArr);
			this.detailtableData = [];
  		for(var i= 0 ;i<tableArr.length;i++){
  			this.detailtableData.push({
  				id:'',
  				mainorderId:'',
  				materCode:tableArr[i].materCode,
  				materName:tableArr[i].materName,
  			  materCigbrand:tableArr[i].cigBrandName,
  				//batchNo:tableArr[i].batchNO,
  				materVersion:tableArr[i].versioncode,
					subverName:tableArr[i].subverName,
					subverId:tableArr[i].subId,  
					cigtype:tableArr[i].cigtype,
					isDelete:0,
					uuid:this._uuid()
  			})
  		}  
    		//新增
            Object.assign(this.form, {
              createdPersonId: this.userinfo.userId,
              createdPerson: this.userinfo.nickName,
		          createdDate : moment(Date.parse(new Date())).format("YYYY-MM-DD HH:mm:ss"),
            });
						var params = {'form' :JSON.stringify(this.form),  'detailtableData' :JSON.stringify(this.detailtableData) };
            this._ajax({
              url: this.rootAPI,
              name: "cigaretteEntry/saveEntryMainAndDet",
              param: params
            }).then(
              (d => {
                if (d.state == 0) {
                  //this.getentrymainorder(d.aaData.id)

				  this.form = d.aaData
          this.getentryorderdetail()

 				  this.mainorderId = d.aaData.id

				    /**
                   * 验证物料单号   验证合同号重复性使用
                   */
                  this.shipmentNumber=this.checkshipmentNumber
    			  this.contractNumber=this.checkcontractNumber
                } else {
                  this.$message({
                    type: "warning",
                    message: "保存失败" // + d.msg
                  });
                }
              }).bind(this)
            );


   			return;
			} else {
							//console.log("修改")
			}
     
  		this.serow = tableArr
  		if(this.form.id != null){
  			/**
  			 * 保存主表信息
  			 */
  			this.detailtableData = [];

  			for(var i= 0 ;i<tableArr.length;i++){
  			//根据materCode 分配出库货位
	  			this.detailtableData.push({
					id:'',
  				mainorderId:this.form.id,
  				materCode:tableArr[i].materCode,
  				materName:tableArr[i].materName,
  			  materCigbrand:tableArr[i].cigBrandName,
  				//batchNo:tableArr[i].batchNO,
  				materVersion:tableArr[i].versioncode,
					subverName:tableArr[i].subverName,
					subverId:tableArr[i].subId,
					cigtype:tableArr[i].cigtype,
					isDelete:0,
					uuid:this._uuid()
	  			})
	  		}



				  var params = {'detailtableData' :JSON.stringify(this.detailtableData) };

				  this._ajax({
              url: this.rootAPI,
              name: "cigaretteEntry/saveEntryDetailOrder",
              param: params
            }).then(
              (d => {
                if (d.state == 0) {
                  //this.getentrymainorder(d.aaData)
                  this.getentryorderdetail()
                } else {
                  this.$message({
                    type: "warning",
                    message: "保存失败" // + d.msg
                  });
                }
              }).bind(this)
            );
  		}



  	},

		  	
  	/**
  	 * 根据id 获取入库单信息
  	 */
  	getentrymainorder(val){
  		return this._ajax({
			url: this.rootAPI, 
			name: 'entrymainorder/queryById', 
			param: {id:val}, 
			}).then((d) => {
				if(d.state === 0){
					this.form = d.aaData
				}
    		}, (d) => {
                this.$message.error('数据获取失败');
        })
  	},

  	/**
  	 * 根据id 获取入库单明细信息
  	 */
  	getentryorderdetail(){
  		this.detailtableData=[]
  		return this._ajax({
			url: this.rootAPI, 
			name: 'cigaretteEntry/queryBymainId', 
			param: {mainorderId:this.form.id}, 
			}).then((d) => {
				if(d.state === 0){
					this.detailtableData = d.aaData

					for (var i=0;i<this.detailtableData.length;i++) {
						if(this.cachequality[i] == null)						
						{
						  this.detailtableData[i].qualityBoxunit = this.detailtableData[i].quality*this.detailtableData[i].converCoef
						} else{
						   this.detailtableData[i].quality = this.cachequality[i]	 				
						   this.detailtableData[i].qualityBoxunit = this.detailtableData[i].quality*this.detailtableData[i].converCoef
						} 
					}
				}
    		}, (d) => {
                this.$message.error('数据获取失败');
        })
  	},

  	handleChangequalityBox(val){
  		console.log(val)
  	},
  	handleChangepriceNotax(val){
  		console.log(val)
  	},
  	handleChangetaxRate(val){
  		console.log(val)
  	},


  	//detailClick(row){
  	//	this.detailtableData2.push({row})
  	//},
  	adddetail(formname){

      if(this.form.originWarehouseCode==this.form.intoWarehouseCode){
			this.$message({
	                    type: "warning",
	                    message: "移出仓库和移入仓库不能为同一仓库" 
	                  });
	        return;
			}

			for (var i=0;i<this.detailtableData.length;i++) {
						this.cachequality[i] = this.detailtableData[i].quality	 				
		  }
     
  		if(this.form.id==null){
  			this.$refs[formname].validate(valid => {
		        if (valid) {
		        	this.modalShow = true;
		        } else {
		          return false;
		        }
		    });
  		}else{
  			this.modalShow = true;
  		}

  	},
  	carrierUnitChange(val){
  		let obj = {};
            obj = this.carrierUnitOption.find((item)=>{
                return item.value === val;
            });
            this.form.carrierUnit = obj.label;
  	},
  	arrivalWareCodeChange(val){
  		let obj = {};
            obj = this.warehouseOption.find((item)=>{
                return item.value === val;
            });
            this.form.intoWarehouseName = obj.label;
  	},
  	outboundWareCodeChange(val){
			let obj = {};
            obj = this.warehouseOption.find((item)=>{
                return item.value === val;
            });
            this.form.originWarehouseName = obj.label;
  	},

	 gettransportCode(val){
  		let obj = {};
            obj = this.shippingtypeOption.find((item)=>{
                return item.value === val;
            });
            this.form.transportType = obj.label;
  	},

  	getwarehouseinfo(query){
  		var vm = this
  		if(query==null){
  			query='';
  		}
		vm.warehouseOption = []
		return vm._ajax({
			url: vm.rootAPI, 
			name: 'warehouseinfo/queryendproduct', 
			param: {keyword:query}, 
			}).then((d) => {
				if(d.state === 0){
					var aaData = d.aaData
					aaData.forEach(function(el) {
						vm.warehouseOption.push({
							value: el.warCode,
  							label: el.warName
						})
					})	
				}
    		}, (d) => {
                this.$message.error('数据取失败');
            })
  	},




  	/**
  	 * 获取出库通道
  	 */
  	getpassway(){
		var vm = this
		vm.passwayOption = []
		return vm._ajax({
			url: vm.rootAPI, 
			name: 'passway/queryoutPassway', 
			param: {}, 
			}).then((d) => {
				if(d.state === 0){
					var aaData = d.aaData
					aaData.forEach(function(el) {
						vm.passwayOption.push({
							value: el.passNo,
  							label: el.passName
						})
					})	
				}
    		}, (d) => {
                this.$message.error('通道取失败');
            })
	},
    cancel(formname) {
     					this.$router.push({path:"/cigaretteentry"});			
    },
    


automatic(row){
			/**
  			 *  1 判断入库数量是否被修改
  			 * 		传入参数明细id 和 当前入库数量
  			 * 	2 如果被修改 重新生成货位分配  
  			 *  3 如果没有被修改 只展示数据 不重新分配货位
  			 */
  			
  			return this._ajax({
					url: this.rootAPI, 
					name: 'cigaretteEntry/checkdetailquickBoxbyId', 
					param: {
						id:row.id,
						newquickBox:row.quality,
					},
					}).then((d) => {
						if(d.state === 0){
							//判断是否修改过入库量   0-》未修改   不为0--》已修改
							if(d.aaData==0){
								//未修改过入库量     不做任何操作     显示对应数据
								this.searchForm.orderdetailId=row.id
								this.searchTable()

							}else{
								//入库数量已被修改  
								this.assigned(row)
							}
						}
		    		}, (d) => {
		                this.$message.error('分配失败');
		            })	
  	},

	/**
	 * 开始分配货位
	 */
	assigned(row){
		return this._ajax({


			url: this.rootAPI, 
			name: 'cigaretteEntry/allotPlace', 
			param: {
				batchNo:row.batchNo,
				qualityBox:row.quality,
				orderdetailId:row.id,
			},
			}).then((d) => {
				if(d.state === 0){
					this.searchForm.orderdetailId=row.id
			  		/**
			  		 * 获取 表格对应数据
			  		 */
			  		this.searchTable()
				}
    		}, (d) => {
                this.$message.error('分配失败');
            })
	},




		/**
  	 * 获取表数据
  	 */
  	searchTable(){
  		Object.assign(this.searchForm, {
					pageNum: this.pageNum, 
					pageSize: this.pageSize
				})
				return this._ajax({
			        url: this.rootAPI,
			        name: "cigaretteEntry/localBindList",
			        param: this.searchForm,   
			        loading: "dataLoading"
			    }).then(this.renderTable);
  	},
  	reset(){
  		this.searchForm.localCode='';
			this.searchTable()
  	},






    //修改货位
		adjustment(row){
  		console.log(row)

			this.modalType = "edit";
      this.modalShowUp = true;
      this.modalObj = row;
  	},
    modalCloseUp() {
			//this.modalObj = {}
			this.modalShowUp = false
			//this.modalType = 'add'
		},

		refSearchTable(){
	     this.searchTable()
		},

		setshowid(){
			this.showid = false
		},

		roughstate(){
				if(this.detailtableData.length == 0){
					this.$message({
	                    type: "warning",
	                    message: "保存失败,请填写入库单详情信息！" 
	                  });
						return false;
				}
			   
				/**
				 * 验证明细数据是否被修改
				 */
				var details = JSON.stringify(this.detailtableData)
				return this._ajax({
					url: this.rootAPI, 
					name: 'cigaretteEntry/checkdetailsquickBox', 
					param: {details:details}, 
					}).then((d) => {
						if(d.state === 0){
							console.log("明细数据没有被修改")
							this.save('form');
						}
		    		}, (d) => {
		                this.$message.error('明细数据被修改');
		                return;
		            })		

    },
    save(formname) {
			var params = {'form' :JSON.stringify(this.form),  'detailtableData' :JSON.stringify(this.detailtableData) };
    		this.$refs[formname].validate(valid => {
	        if (valid) {
	        	//新增
	            Object.assign(this.form, {
	              createdPersonId: this.userinfo.userId,
	              createdPerson: this.userinfo.nickName
	            });
	            this._ajax({
	              url: this.rootAPI,
	              name: "cigaretteEntry/update",
	              param: params
	            }).then(
	              (d => {
	                if (d.state == 0) {
	                  this.$message({ type: "success", message: "保存成功" });
	                  this.$router.push({path:"/cigaretteentry"});
	                } else {
	                  this.$message({
	                    type: "warning",
	                    message: "保存失败" // + d.msg
	                  });
	                }
	              }).bind(this)
	            );
	        } else {
	          return false;
	        }
	      });
  
		},
		

		


		 	/**
  	 * 获取运输方式
  	 */
  	getAllShippingtypeEntity(){
  		var vm = this
		vm.shippingtypeOption = []
		return vm._ajax({
			url: vm.rootAPI, 
			name: 'shippingtype/getAllShippingtypeEntity', 
			param: {}, 
			}).then((d) => {
				if(d.state === 0){
					var aaData = d.aaData
					aaData.forEach(function(el) {
						vm.shippingtypeOption.push({
							value: el.code,
  							label: el.name
						})
					})	
				}
    		}, (d) => {
                this.$message.error('通道取失败');
            })
  	},

	/**
  	 * 获取承运单位
  	 */
  	getAllCarrierunitEntity(query){
  		if(query==null){
  			query='';
  		}
  		var vm = this
		vm.carrierUnitOption = []
		return vm._ajax({
			url: vm.rootAPI, 
			name: 'carrierunit/getAllCarrierunitEntitys', 
			param: {keyword:query}, 
			}).then((d) => {
				if(d.state === 0){
					var aaData = d.aaData
					aaData.forEach(function(el) {
						vm.carrierUnitOption.push({
							value: el.code,
  							label: el.name
						})
					})	
				}
    		}, (d) => {
                this.$message.error('承运单位获取失败');
            })


			
  	},

   /*
		getAllCarrierunitEntity(query){
  		if(query==null){
  			query='';
  		}
  		var vm = this
		vm.carrierUnitOption = []
		return vm._ajax({
			url: vm.rootAPI, 
			name: 'carrierunit/getAllCarrierunitEntity', 
			param: {keyword:query}, 
			}).then((d) => {
				if(d.state === 0){
					var aaData = d.aaData
					aaData.forEach(function(el) {
						vm.carrierUnitOption.push({
							value: el.code,
  							label: el.name
						})
					})	
				}
    		}, (d) => {
                this.$message.error('通道取失败');
            })
  	},  */

	setlocalid(){
			this.showlocalid = false
	},
	setorderdetailid(){
			this.showorderdetailid = false
	},
  confirms(row){
		var param =  {id : row.id};
            this._ajax({
              url: this.rootAPI,
              name: "entryTerminal/updateEntryInfo",
              param: param
            }).then(
              (d => {
                if (d.state == 0) {
                  this.$message({ type: "success", message: "保存成功" });
                  this.$emit("submit");
								//	this.searchTable();
                } else {
                  this.$message({
                    type: "warning",
                    message: "保存失败" // + d.msg
                  });
                }
              }).bind(this)
            );

					},

					detailClick(row){
					/**
					 * 点击行     对物料编码筛选条件赋值
					 */
					console.log(row)
					this.searchForm.materCode = row.materCode
					this.searchForm.orderdetailId=row.id
					/**
					 * 查询数据 放入对应表格
					 */
					this.searchTable()
				},
		
			confirmentry(){
				if(this.detailtableData.length == 0){
					this.$message({
	                    type: "warning",
	                    message: "保存失败,请填写入库单详情信息！" 
	                  });
						return false;
				}				 				 				 
				/**
				 * 验证明细数据是否被修改
				 */
				var details = JSON.stringify(this.detailtableData)
				return this._ajax({
					url: this.rootAPI, 
					name: 'cigaretteEntry/checkdetailsquickBox', 
					param: {details:details}, 
					}).then((d) => {
						if(d.state === 0){
							console.log("明细数据没有被修改")		
							this.queryDetailedBind()
							
							//this.save('form');
						}
		    		}, (d) => {
		                this.$message.error('明细数据被修改');
		                return;
		            })		

		},
		
		  queryDetailedBind() {

      var param = { id: this.form.id, status: 1 ,plateNumber:this.form.plateNumber};

      this._ajax({
        url: this.rootAPI,
        name: "cigaretteEntry/queryDetailedBind",
        param: param
      }).then(
        (d => {
          if (d.state == 0) {
            //this.$message({ type: "success", message: "保存成功" });
						///this.searchTable();
						this.saveconfirmentry('form');
          } else {
            this.$message({
              type: "warning",
              message: d.msg 
            });
          }
        }).bind(this)
      );  
		},
		

		saveconfirmentry(formname) {
    

			var params = {'form' :JSON.stringify(this.form),  'detailtableData' :JSON.stringify(this.detailtableData) };
    		this.$refs[formname].validate(valid => {
	        if (valid) {
	        	//新增
	            Object.assign(this.form, {
	              createdPersonId: this.userinfo.userId,
	              createdPerson: this.userinfo.nickName
	            });
	            this._ajax({
	              url: this.rootAPI,
	              name: "cigaretteEntry/updates",
	              param: params
	            }).then(
	              (d => {
	                if (d.state == 0) {
	                  this.$message({ type: "success", message: "保存成功" });
	                  this.$router.push({path:"/cigaretteentry"});
	                } else {
	                  this.$message({
	                    type: "warning",
	                    message: "保存失败" // + d.msg
	                  });
	                }
	              }).bind(this)
	            );
	        } else {
	          return false;
	        }
	      });
  
    },
  }
};
</script>

<style>
</style>