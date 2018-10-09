<template>
	<div>

		<el-row>
			<el-card class="box-card" style="margin-right: 5px; margin-left: 5px;" shadow="hover">
				<div slot="header" class="clearfix">
				    <span>查看入库单：{{this.form.orderNumber}}</span>
				</div>

			<el-form class="modal-form" :inline="true" :model="form" :rules="rules" ref="form" label-width="120px">
                <el-row>

                	<!--<el-col :span="6">
		                <el-form-item label="入库订单编号"  prop='orderNumber'>
				   	 		<inputItem :value.sync="form.orderNumber" :maxlength="10"></inputItem>
				    	</el-form-item>
					</el-col>-->      
					<el-col :span="6">
		              	<el-form-item label="物流单号:"  prop='shipmentNumber'>
				              		<span>
				              			{{this.form.shipmentNumber}}
				              		</span>
			      		</el-form-item>
					</el-col>
				

					<el-col :span="6">
		              	<el-form-item label="入库单号:"  prop='orderNumber'>
			    		
									<span>
				              			{{this.form.orderNumber}}
				              		</span>

			      		</el-form-item>
					</el-col>


					<el-col :span="6">
		              <el-form-item label="移出仓库:"  prop='originWarehouseName'>

									<span>
				              			{{this.form.originWarehouseName}}
				              		</span>

			      	</el-form-item>
			      	</el-col>


							<el-col :span="6">
	                <el-form-item label="移入仓库:"  prop='intoWarehouseName'>

									<span>
				              			{{this.form.intoWarehouseName}}
				              		</span>

			    	</el-form-item>
					</el-col>

	     </el-row>
				<el-row>
					<el-col :span="6">
		              <el-form-item label="合同号:"  prop='contractNumber'>
			    					<span>
				              			{{this.form.contractNumber}}
				              		</span>
			      	</el-form-item>
					</el-col>
			

				
					<el-col :span="6">
	          <el-form-item label="合同日期:"  prop='contractDate'>
									<span>
				              			{{this.form.contractDate}}
				              		</span>
			      	</el-form-item>
			    	</el-form-item>
					</el-col>
      <!--
				<el-col :span="6">
	        <el-form-item label="总量（件）"  prop='totalQuality'>
			   	 		<inputItem :value.sync="form.totalQuality" :maxlength="10" style="width: 220px;"></inputItem>
			    	</el-form-item>
					</el-col>  -->
				<el-col :span="6">
	        <el-form-item label="车牌号:"  prop='plateNumber'>
						<span>
				            {{this.form.plateNumber}}
				         </span>	
			    	</el-form-item>
					</el-col>
				<el-col :span="6">
	        <el-form-item label="制单日期:"  prop='shipmentDate'>			  
						<span>
				            {{this.form.shipmentDate}}
				         </span>	
			    	</el-form-item>
					</el-col>
				</el-row>



				<el-row>
					<el-col :span="6">
	                <el-form-item label="发货日期:"  prop='deliveryDate'>
						<span>
				            {{this.form.deliveryDate}}
				         </span>
			    	</el-form-item>
					</el-col>
					<el-col :span="6">
		              <el-form-item label="运输方式:"  prop='transportType'>
						<span>
				            {{this.form.transportType}}
				         </span>

			      	</el-form-item>
					</el-col>
					<el-col :span="6">
	                <el-form-item label="承运人:"  prop='carrier'>
						<span>
				            {{this.form.carrier}}
				         </span>

			    	</el-form-item>
					</el-col>
					<el-col :span="6">
		              <el-form-item label="联系电话:"  prop='phoneNumber'>
						<span>
				            {{this.form.phoneNumber}}
				         </span>
			      	</el-form-item>
					</el-col>
				</el-row>

				<el-row>
					<el-col :span="6">
		              <el-form-item label="承运单位:"  prop='carrierUnit'>
					  	<span>
				            {{this.form.carrierUnit}}
				         </span>
			      	</el-form-item>
					</el-col>

					<el-col :span="6">
		              <el-form-item label="预约装车日期:"  prop='reservationDate'>
						<span>
				            {{this.form.reservationDate}}
				         </span>
			      	</el-form-item>
					</el-col>

				</el-row>

		  		<el-row>


		  			<el-col :span="6">
		              <el-form-item label="发货要求:"  prop='deliveryRequire'>
						<span>
				            {{this.form.deliveryRequire}}
				         </span>
			      	</el-form-item>
					</el-col>

					<el-col :span="6">
	                <el-form-item label="物流单备注:"  prop='shipmentRemark'>
						<span>
				            {{this.form.shipmentRemark}}
				         </span>	
			    	</el-form-item>
					</el-col>

					<el-col :span="6">
		              <el-form-item label="备注:"  prop='remark'>
						<span>
				            {{this.form.remark}}
				         </span>
			      	</el-form-item>
					</el-col>


				</el-row>
		  </el-form>

		</el-card>
		</el-row>





			<el-row>

			<el-col :span="12">
			
		<el-card class="box-card" style="margin-right: 5px; margin-top: 10px; margin-left: 5px;" shadow="hover">
				  <div slot="header" class="clearfix">
				    <span>明细信息</span>
				  </div>

					<el-table :data="detailtableData" border style="width: 100%;padding:0"  @row-click="automatic" :highlight-current-row="true">

					<el-table-column prop="id"  label="id" width="120" v-if="showid"> </el-table-column>
				    <el-table-column prop="materCode"  label="物料编码" width="164px" > </el-table-column>
						<el-table-column prop="materCigbrand"  label="物料品牌" > </el-table-column>
				    <el-table-column prop="materName"  label="物料名称"> </el-table-column>
				    <el-table-column prop="materVersion"  label="物料版本" > </el-table-column>
					
					<el-table-column prop="subverName" label="子版本" width="120px"> </el-table-column>	

					<el-table-column prop="batchNo"  label="批次号" width="115px"> </el-table-column>			
					 <el-table-column prop="quality"  label="数量(件)" width="90px"> </el-table-column>
					<el-table-column prop="qualityBoxunit"  label="数量(万支)" width="100px"> </el-table-column>

				  </el-table>


				</el-card>
			</el-col>

			<el-col :span="12">
				<el-card class="box-card" style="margin-right: 5px; margin-top: 10px; margin-left: 5px;" shadow="hover">
				<div style="margin-left: 5px; margin-bottom: 5px; margin-top: 13px;">
					<el-form ref="searchForm" :model="searchForm">
						<!-- 查询条件 -->
						<searchInputItems>
							<searchInputItem name="货位编号">
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
            <!--
							<el-table-column prop="localRfid" label="货位rfid编号">
					    	<template slot-scope="scope">
					    		<toolTip :content="scope.row.localRfid">
					    			<span>{{scope.row.localRfid}}</span>
					    		</toolTip>
					      	</template>
					    </el-table-column>  -->


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


						<el-table-column prop="status" label="状态">
					    	<template slot-scope="scope">
					    		  <tagItem :text="_dicValue(scope.row.status, statuss)"></tagItem>
					      	</template>
					    </el-table-column>
                        <!--
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

						-->

				    <el-table-column fixed="right" label="操作" width="80"  v-if="showconfirms">
				      <template slot-scope="scope">                           
									<el-button-group>										    
										<iconBtn iconClass="el-icon-check" content="确定入库" @click="confirms(scope.row)" ></iconBtn>			
									</el-button-group>	
				      </template>
				    </el-table-column>


					</elemTable>
					


				</div>
	
				</el-card>
			</el-col>

			<div style="float: right; padding:20px ;">
	  			<el-button @click="cancel('form')">返回</el-button>
			</div>


		</el-row>

	
		</div>
</template>

<script>
	import mixin from '../../mixin/mixin.js'
	import local from '../../local.js'
	import configs from "../../configs.js";

export default {
  mixins: [mixin],
  data() {
    return {

			searchForm:{
    		localCode:'',
    		materCode:'',
    		//uuid:'',
    	},
		statuss: [],
    	detailtableData:[],
    	detailtableData2:[{}],

      form: {
        		id: null,
						orderNumber: "",
						shipmentNumber: "",
						shipmentDate: "",
						plateNumber: "",
						totalQuality: "",
						deliveryDate: "",
						transportType: "",
						carrier: "",
						phoneNumber: "",
						carrierUnit: "",
						carrierUnitCode: "",
						reservationDate: "",
						shipmentRemark: "",
						contractNumber: "",
						contractDate: "",
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
      carrierUnitOption:[
      	{
          value: '00001',
          label: '承运单位1'
        }, {
          value: '00002',
          label: '承运单位1'
        }
      ],
      userinfo: local.get("userinfo"),
      	rules: {
	        shipmentNumber: [          
	          	this._ruleRequired("物流单号"),
	          	//this._ruleExist(configs.rootAPI + "outmainorder/checkshipmentNumber", "物流单",{})
	        ],
	        orderNumber: [
	          	this._ruleRequired("入库订单编号"),
	        ],               
	        originWarehouseName:[
	          	this._ruleRequired("移出仓库名称"),
	        ],
	         intoWarehouseName:[
	          	this._ruleRequired("移入仓库名称"),
	          	//this._ruleExist(configs.rootAPI + "outmainorder/checkcontractNumber", "物流单",{})
	        ],
	        contractNumber:[
	          	this._ruleRequired("合同号"),
	        ],
	        contractDate:[
	          	this._ruleRequired("合同日期"),
	        ],
	        plateNumber:[
	        	this._ruleRequired("车牌号"),
	        ],
				   phoneNumber:[
	        	this._ruleMobile(),
	        ],
//	        totalQuality:[
//	        	this._ruleRequired("出库总量"),
//	        ]
      	},
			      	serow:[],

							showid:false,

							showlocalid : false,

							showorderdetailid : false,
							showconfirms: false,
    };
  },
  mounted() {
	//this.getfrominfo();
	 /*入库状态*/
    this._searchDic("TRAYSTATUS").then(
      function(d) {
        this.statuss = this._dicKey(d);
      }.bind(this)
    );
  	this.getpassway();
  	this.getwarehouseinfo();
	this.gettransportCode();
	this.getmainorder();
    this.getdetail();
	
  },
  methods: {

	  showconfir(){
			if(this.form.status == 1 || this.form.status == 2 ) {
					this.showconfirms = true;
			}
	  },

	qualityBoxchange(row){
  		row.qualityBoxunit = row.quality*row.converCoef
  	},


  	deldetail(index,row){
  		this.detailtableData.splice(index, 1);
  	},

		
  	selectList(tableArr){

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
					uuid:this._uuid()
  			})
  		} 

      

    		//新增
            Object.assign(this.form, {
              createdPersonId: this.userinfo.userId,
              createdPerson: this.userinfo.nickName
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
  	detailClick(row){
  		this.detailtableData2.push({row})
  	},
  	adddetail(formname){
      
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
            this.form.arrivalWare = obj.label;
  	},
  	outboundWareCodeChange(val){
			let obj = {};
            obj = this.warehouseOption.find((item)=>{
                return item.value === val;
            });
            this.form.outboundWare = obj.label;
  	},
  	/**
  	 * 获取仓库信息
  	 */
  	/*getwarehouseinfo(){
  		var vm = this
		vm.warehouseOption = []
		return vm._ajax({
			url: vm.rootAPI, 
			name: 'warehouseinfo/queryendproduct', 
			param: {}, 
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
                this.$message.error('通道取失败');
            })
  	}, */

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
    cancel() {
      console.log("返回")
    },
    
automatic(row){
    this.searchForm.orderdetailId=row.id
			if(this.form.status == 1 || this.form.status == 2 ) {
					this.showconfirms = true;
			}
		this.searchTable()
  	},

	/**
  	 * 获取entrytraylocalmap表数据
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
		refSearchTable(){
				this.searchTable()
		},

		setshowid(){
			this.showid = false
		},

		roughstate(){
  			this.save('form');
				//this.savewarehoumateril();
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
  	gettransportCode(){
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




		//getfrominfo(){
		//			this.from = this.$route.params.editobj;
		//}
  	/**
  	 * 根据id获取出库单信息
  	 */
  	getmainorder(){
  		return this._ajax({
			url: this.rootAPI, 
			name: 'entrymainorder/queryById', 
			param: {id:this.$route.query.id}, 
			}).then((d) => {
				if(d.state === 0){
					this.form = d.aaData
					this.showconfir();
				}
    		}, (d) => {
                this.$message.error('数据获取失败');
        })
  	},

		  	/**
  	 * 根据id 获取出库单明细信息
  	 */
  	getdetail(){
  		return this._ajax({
			url: this.rootAPI, 
			name: 'cigaretteEntry/queryBymainId', 
			param: {mainorderId:this.$route.query.id}, 
			}).then((d) => {
				if(d.state === 0){
					this.detailtableData = d.aaData

					for (var i=0;i<this.detailtableData.length;i++) {
						this.detailtableData[i].qualityBoxunit = this.detailtableData[i].quality*this.detailtableData[i].converCoef
					}

					this.searchForm.orderdetailId=d.aaData[0].id

					if(this.form.status == 1 || this.form.status == 2 ) {
							this.showconfirms = true;
					}

			  		/**
			  		 * 获取 表格对应数据
			  		 */
			  		this.searchTable()


				}
    		}, (d) => {
                this.$message.error('数据获取失败');
        })
  	},


	setlocalid(){
			this.showlocalid = false
	},

	

	setorderdetailid(){
			this.showorderdetailid = false
	},
    cancel(formname) {
    	this.$router.push({path:"/cigaretteentry"});
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
                  this.$message({ type: "success", message: "该托盘入库成功！" });
                  this.$emit("submit");
				  this.searchTable();
                } else {
                  this.$message({					
                    type: "warning",
                    message: "该托盘入库失败！" // + d.msg
                  });
                }
              }).bind(this)
            );

	},

  }

	
};
</script>

<style>
.el-card__body{padding:5px}
</style>