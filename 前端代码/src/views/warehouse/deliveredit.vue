<template>
	<div class="deliveredit">
		<el-row>
			<el-card class="box-card" style="margin-right: 5px; margin-left: 5px;" shadow="hover">
				<div slot="header" class="clearfix">
				    <span>编辑出库单：{{this.form.orderNumber}}</span>
				</div>
		  		<div>
		  			<el-form class="modal-form" :inline="true" :model="form" :rules="rules" ref="form" label-width="100px">
				              	<el-form-item label="物流单号"  prop='shipmentNumber'>
					    			<inputItem style="width: 200px;" :value.sync="form.shipmentNumber" @change="editcaheckshipmentNumberchange(form.shipmentNumber)" :maxlength="40" ></inputItem>
					      		</el-form-item>
			                <el-form-item label="发货单位"  prop='forwardUnitCode'>
			                	<el-select  
			                		style="width: 200px;"
								    v-model="form.forwardUnitCode"
								    filterable
								    remote
								    reserve-keyword
								    placeholder="请输入关键词"
								    @change = "forwardUnitCodeChange"
								    :remote-method="getAllMerchantEntitytravellingtrader"
								    :loading="loading">
								    <el-option
								      v-for="item in forwardUnitOption"
								      :key="item.value"
								      :label="item.label+item.value"
								      :value="item.value">
								    </el-option>
								  </el-select>
					    	</el-form-item>
								<el-form-item label="购货单位"  prop='purchaseUnitCode'>
									<el-select
									style="width: 200px;"
								    v-model="form.purchaseUnitCode"
								    filterable
								    remote
								    reserve-keyword
								    placeholder="请输入关键词"
								    @change = "purchaseUnitCodeChange"
								    :remote-method="getAllMerchantEntitycustomer"
								    :loading="loading">
								    <el-option
								      v-for="item in merchantOption"
								      :key="item.value"
								      :label="item.label+item.value"
								      :value="item.value">
								    </el-option>
								  </el-select>
					    	</el-form-item>
				              <el-form-item label="合同号"  prop='contractNumber'>
					    		<inputItem style="width: 200px;" :value.sync="form.contractNumber" @change="editcheckcontractNumberchange(form.contractNumber)" :maxlength="40" ></inputItem>
					      	</el-form-item>
				              <el-form-item label="出库仓库"  prop='outboundWareCode'>
				              	<el-select 
				              		style="width: 200px;"
								    v-model="form.outboundWareCode"
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
				              <el-form-item label="发货日期"  prop='deliveryDate'>
					    		<dateEditorDaterange style="width: 200px;" :dateValue.sync="form.deliveryDate"  type="date" ></dateEditorDaterange>
					      	</el-form-item>
			                <el-form-item label="合同日期"  prop='contractDate'>
					   	 		<dateEditorDaterange style="width: 200px;" :dateValue.sync="form.contractDate" type="date" :disabledAfterDate="afterdate" ></dateEditorDaterange>
					    	</el-form-item>
				              	<el-form-item label="制单日期"  prop='shipmentDate'>
					    			<dateEditorDaterange style="width: 200px;" :dateValue.sync="form.shipmentDate" :disabledAfterDate="afterdate" type="date" ></dateEditorDaterange>
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
								<el-form-item label="车牌号"  prop='plateNumber'>
					   	 		<inputItem style="width: 200px;" :value.sync="form.plateNumber" :maxlength="10" ></inputItem>
					    	</el-form-item>
				              <el-form-item label="承 运 人"  prop='carrier'>
					    		<inputItem style="width: 200px;" :value.sync="form.carrier" :maxlength="40" ></inputItem>
					      	</el-form-item>
			                <el-form-item label="联系电话"  prop='phoneNumber'>
					   	 		<inputItem style="width: 200px;" :value.sync="form.phoneNumber" :maxlength="13" ></inputItem>
					    	</el-form-item>
			                <el-form-item label="到货仓库"  prop='arrivalWareCode'>
			                	<el-select 
			                		style="width: 200px;"
								    v-model="form.arrivalWareCode"
								    filterable
								    remote
								    reserve-keyword
								    placeholder="请输入关键词"
								    @change = "arrivalWareCodeChange"
								    :remote-method="getarrivalwarehouseinfo"
								    :loading="loading">
								    <el-option
								      v-for="item in arrivalwarehouseOption"
								      :key="item.value"
								      :label="item.label+item.value"
								      :value="item.value">
								    </el-option>
								  </el-select>
					    	</el-form-item>
				              <el-form-item label="到货日期"  prop='arrivalRequire'>
					    		<dateEditorDaterange style="width: 200px;"  :dateValue.sync="form.arrivalRequire" type="date" ></dateEditorDaterange>
					      	</el-form-item>
			                <el-form-item label="预约装车时间"  prop='reservationDate'>
			                	<el-date-picker style="width: 200px;" v-model="form.reservationDate" value-format="yyyy-MM-dd HH:mm:ss" type="datetime" ></el-date-picker>
					    	</el-form-item>
				              <el-form-item label="运输方式"  prop='transportCode'>
					    		<selectInput style="width: 200px;"  :value.sync="form.transportCode" @selectChange="gettransportCode" filterable placeHolder="请选择运输方式">
								    <el-option 
								      v-for="item in shippingtypeOption"
								      :key="item.value"
								      :label="item.label"
								      :value="item.value">
								    </el-option>
								</selectInput>
					      	</el-form-item>
			                <el-form-item label="是否紧急出库"  prop='isUrgent'>
					   	 		<selectInput style="width: 200px;"  :value.sync="form.isUrgent" filterable placeHolder="请选择">
								    <el-option 
								      v-for="item in isUrgentOption"
								      :key="item.key"
								      :label="item.value"
								      :value="item.key">
								    </el-option>
								</selectInput>
					    	</el-form-item>
				              <el-form-item label="出库优先级"  prop='priorityLevel'>
				              		<el-input-number style="width: 200px;" v-model="form.priorityLevel" controls-position="right" :min="1" :max="100"></el-input-number>
					      		</el-form-item>
					      	<el-row>
					      		 <el-form-item label="发货要求"  prop='deliveryRequire'>
						    		<inputItem :value.sync="form.deliveryRequire" type="textarea" :rows="2" :maxlength="45" ></inputItem>
						      	</el-form-item>
				                <el-form-item label="物流单备注"  prop='shipmentRemark'>
						   	 		<inputItem :value.sync="form.shipmentRemark" type="textarea" :rows="2" :maxlength="45" ></inputItem>
						    	</el-form-item>
					              <el-form-item label="备注"  prop='remark'>
						    		<inputItem type="textarea" :rows="2" :maxlength="45" :value.sync="form.remark" ></inputItem>
						      	</el-form-item>
					      	</el-row>
				  </el-form>
		  		</div>
			</el-card>
		</el-row>
		<el-row>
			<el-col :span="14">
				<el-card class="box-card" style="margin-right: 5px; margin-top: 10px; margin-left: 5px;" shadow="hover">
				  <div slot="header" class="clearfix" >
				    <span>明细信息</span>
				    <el-button-group style="float: right;">
								<iconBtn iconClass="el-icon-plus" content="添加明细" @click="adddetail('form')">添加明细</iconBtn>
					</el-button-group>
				  </div>
				  <div style="margin-left: 5px; margin-bottom: 5px;">
					<el-table :data="detailtableData" border style="width: 100%" @row-click="detailClick"  highlight-current-row>
					    <el-table-column prop="materName" label="卷烟名称" min-width="100">
					    	<template slot-scope="scope">
					    		<toolTip :content="scope.row.materName">
					    			<span>{{scope.row.materName}}</span>
					    		</toolTip>
					      	</template>
					    </el-table-column>
						<el-table-column prop="materCode"  label="卷烟编码" min-width="100">
							<template slot-scope="scope">
					    		<toolTip :content="scope.row.materCode">
					    			<span >{{scope.row.materCode}}</span>
					    		</toolTip>
					      	</template>
						</el-table-column>
						<el-table-column prop="materVersion" label="版本" min-width="60">
							<template slot-scope="scope">
					    		<toolTip :content="scope.row.materVersion">
					    			<span >{{scope.row.materVersion}}</span>
					    		</toolTip>
					      	</template>
						</el-table-column>
						<el-table-column v-if="this.form.orignMethod==2" prop="subverName"label="子版本" min-width="100">
							<!--<template slot-scope="scope">
				              	<selectInput style="width: 85px;"  :value.sync="scope.row.subverId" @selectChange="getsubverName(scope.row)" filterable placeHolder="请选择运输方式">
								    <el-option 
								      v-for="item in scope.row.subList"
								      :key="item.id"
								      :label="item.subverName"
								      :value="item.id">
								    </el-option>
								</selectInput>
							</template>-->
						</el-table-column>
						<el-table-column v-if="this.form.orignMethod==1" prop="subverName"label="子版本" min-width="100">
							<template slot-scope="scope">
				              	<selectInput style="width: 85px;"  :value.sync="scope.row.subverId" @selectChange="getsubverName(scope.row)" filterable placeHolder="请选择运输方式">
								    <el-option 
								      v-for="item in scope.row.subList"
								      :key="item.id"
								      :label="item.subverName"
								      :value="item.id">
								    </el-option>
								</selectInput>
				            </template>
						</el-table-column>
					    <el-table-column prop="usableQuality"  label="可操作(件)" min-width="80"> </el-table-column>
					    <el-table-column prop="qualityBox" v-if="this.form.orignMethod==1" label="数量(件)" min-width="70"> 
					    </el-table-column>
					    <el-table-column prop="qualityBox" v-if="this.form.orignMethod==2" label="数量(件)" min-width="120"> 
					    	<template slot-scope="scope">
				              	<el-input-number v-model="scope.row.qualityBox" @blur="qualityBoxchange(scope.$index,scope.row)" style="width: 100px;" @keyup.native.enter="automatic(scope.row)" controls-position="right" :precision="0" :step="20" :min="0" :max="99999" label="数量"></el-input-number>
				            </template>
					    </el-table-column>
					    <el-table-column prop="qualityBoxunit"  label="数量(万支)" min-width="80"> </el-table-column>
					    <el-table-column fixed="right" label="操作" min-width="90">
					    	<template slot-scope="scope">
					    		<el-button-group>
					    		    <iconBtn iconClass="el-icon-goods" style="padding-left: 10px;padding-right: 10px;padding-top: 5px;padding-bottom: 5px;" content="货位分配" @click="automatic(scope.row)" ></iconBtn>
								    <iconBtn iconClass="el-icon-minus" style="padding-left: 10px;padding-right: 10px;padding-top: 5px;padding-bottom: 5px;" content="删除" @click="deldetail(scope.$index,scope.row)" ></iconBtn>
								    <!--<iconBtn iconClass="el-icon-view"  style="padding-left: 10px;padding-right: 10px;padding-top: 5px;padding-bottom: 5px;" content="查看出库货位" @click="detailClick(scope.row)" ></iconBtn>-->
					    		</el-button-group>
					    	</template>
					    </el-table-column>
					</el-table>
				</div>
				</el-card>
			</el-col>
			<el-col :span="10">
				<el-card class="box-card" style="margin-right: 5px; margin-top: 10px; margin-left: 5px;" shadow="hover">
				  <div slot="header" class="clearfix">
				  	<!--<span>卷烟名称：<el-text style="color: green;">{{this.materNamelocal}}</el-text></span><br/>
				  	<span>编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：<el-text style="color: green;">{{this.materCodelocal}}</el-text></span>-->
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
				  </div>
				  <div style="margin-left: 5px; margin-bottom: 5px; margin-top: 13px;">
					<elemTable :dataList="dataList" highlight-current-row :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange">
					    <el-table-column prop="descript" label="货位" min-width="120">
					    	<template slot-scope="scope">
					    		<toolTip :content="scope.row.descript">
					    			<span >{{scope.row.descript}}</span>
					    		</toolTip>
					      	</template>
					    </el-table-column>
					    <el-table-column prop="batchNo" label="批次号" min-width="120">
					    	<template slot-scope="scope">
					    		<toolTip :content="scope.row.batchNo">
					    			<span >{{scope.row.batchNo}}</span>
					    		</toolTip>
					      	</template>
					    </el-table-column>
					    <el-table-column prop="cigsmokeQuality" label="存量(件)" min-width="65">
					    	<template slot-scope="scope">
					    		<toolTip :content="scope.row.cigsmokeQuality">
					    			<span>{{scope.row.cigsmokeQuality}}</span>
					    		</toolTip>
					      	</template>
					    </el-table-column>
					    <el-table-column prop="realoutQuality" label="出量(件)" min-width="65">
					    	<template slot-scope="scope">
					    		<toolTip :content="scope.row.realoutQuality">
					    			<span>{{scope.row.realoutQuality}}</span>
					    		</toolTip>
					      	</template>
					    </el-table-column>
					     <el-table-column prop="wareMethod" label="出库方式" min-width="70">
					    	<template slot-scope="scope">
							<toolTip :content="_dicValue(scope.row.wareMethod, delivermethodOptions)">
								<tagItem v-if="scope.row.wareMethod==0" type="warning" :text="_dicValue(scope.row.wareMethod, delivermethodOptions)"></tagItem>
		    					<tagItem v-if="scope.row.wareMethod==1" type="danger" :text="_dicValue(scope.row.wareMethod, delivermethodOptions)"></tagItem>
				    	     </toolTip>
				      	</template>
					    </el-table-column>
					    <el-table-column prop="status" label="状态" min-width="65">
					    	<template slot-scope="scope">
				    		 <toolTip :content="_dicValue(scope.row.status, deliverstatusOption)">
				    		 	<tagItem v-if="scope.row.status==0" :text="_dicValue(scope.row.status, deliverstatusOption)"></tagItem>
		    					<tagItem v-if="scope.row.status==1" type="success" :text="_dicValue(scope.row.status, deliverstatusOption)"></tagItem>
		    					<tagItem v-if="scope.row.status==2" type="warning" :text="_dicValue(scope.row.status, deliverstatusOption)"></tagItem>
				    	     </toolTip>
				      	</template>
					    </el-table-column>
					    
					    <el-table-column label="操作" fixed="right" min-width="60">
					    	<template slot-scope="scope">
					    		<span v-if="scope.row.localCode==null" style="color: green;">暂存区出库</span>
					    			<iconBtn v-if="scope.row.localCode!=null" iconClass="el-icon-edit" content="调整出库货位"  @click="adjustment(scope.row)" ></iconBtn>    	    		
					    	</template>
					    </el-table-column>
					</elemTable>
				</div>
				</el-card>
			</el-col>
			<div style="float: right;padding:20px ;">
	  			<el-button @click="cancel('form')">返 回</el-button>
			    <el-button type="info" @click="checkdetailsquickBox('form')">保存</el-button>
			    <!--<el-button type="primary" @click="save('form')">确 定(生成出库单)</el-button>-->
			</div>
		</el-row>
		<!--<el-row>
			<el-card class="box-card">
			  
			</el-card>
		</el-row>-->
		
		<selectmaterilModel  v-if="modalShow"  @close="modalClose" :modalshow='modalShow' @selectList="selectList" :outmainorderId="outmainorderId"></selectmaterilModel>
		
		<selectInventorytraylocalmapModel  v-if="modalShowlocal"  @close="modalClosess" :modalShowlocal='modalShowlocal' @selectreplace="selectreplace" :materCode="materCodelocal"></selectInventorytraylocalmapModel>	
	</div>
</template>

<script>
	import mixin from '../../mixin/mixin.js'
	import local from '../../local.js'
	import configs from "../../configs.js";
	import selectmaterilModel from "../component/modal/selectmaterilModel.vue";
	import selectInventorytraylocalmapModel from "../component/modal/selectInventorytraylocalmapModel.vue";
export default {
  mixins: [mixin],
  components: {
  	selectmaterilModel,
  	selectInventorytraylocalmapModel,
  },
  data() {
    return {
    	afterdate:'',
    	outmainorderId:null,//出库单id
    	shipmentNumber:'',
    	contractNumber:'',
    	checkshipmentNumber:'',
    	checkcontractNumber:'',
    	updateboj:{},
    	oldsoleCode:'',
    	searchForm:{
    		localCode:'',
    		materCode:'',
    		orderdetailId:'',
    		subverId:'',
    	},
    	materCodelocal:'',
    	materNamelocal:'',
    	modalShowlocal:false,
    	delivermethodOptions:[],
    	deliverstatusOption:[],
    	localdataCache:{},
    	dataCache:[],
    	detailtableData:[],
    	detailtableDatatemp:[],
    	detailtableData2:[],
      	form: {
	        id:null,
			orderNumber: '',
			shipmentNumber: '',
			shipmentDate: '',
			plateNumber: '',
			totalQuality: '',
			deliveryDate: '',
			transportType: '',
			transportCode:'',
			carrier: '',
			phoneNumber: '',
			carrierUnit: '',
			carrierUnitCode: '',
			reservationDate: '',
			shipmentRemark: '',
			contractNumber: '',
			contractDate: '',
			outboundWareCode: '',
			outboundWare: '',
			arrivalWareCode: '',
			arrivalWare: '',
			arrivalRequire: '',
			deliveryRequire:'',
			remark:'',
			forwardUnitCode:'',
			forwardUnit:'',
			purchaseUnitCode:'',
			purchaseUnit:'',
			ncWareCode:'',
			ncWare:'',
			outchanCode:'',
			isUrgent:0+'',
			priorityLevel:'1',
//			details:[]
	      },
      	serow:[],
      	mainorderId:'',
      	isUrgentOption:[],
      	serowtableArr:[],
      	passwayOption:[],
      	warehouseOption:[],
      	arrivalwarehouseOption:[],
      	shippingtypeOption:[],
      	driversOption:[],
      	vehicleinfoOption:[],
      	merchantOption:[],
      	forwardUnitOption:[],
      	carrierUnitOption:[],
      	userinfo: local.get("userinfo"),
      	rules: {
	        shipmentNumber: [
	          	this._ruleRequired("物流单号"),
	          	this._ruleExist(configs.rootAPI + "outmainorder/checkshipmentNumber", "物流单",this)
	        ],
	        forwardUnitCode: [
	          	this._ruleRequired("发货单位"),
	        ],
	        purchaseUnitCode:[
	          	this._ruleRequired("购货单位"),
	        ],
	         contractNumber:[
	          	this._ruleRequired("合同号"),
	          	this._ruleExist(configs.rootAPI + "outmainorder/checkcontractNumber", "物流单",this)
	        ],
	        outboundWareCode:[
	          	this._ruleRequired("出库仓库"),
	        ],
//	        arrivalWareCode:[
//	          	this._ruleRequired("到货仓库"),
//	        ],
//	        contractDate:[
//	        	this._ruleRequired("合同日期"),
//	        ],
//	        shipmentDate:[
//	        	this._ruleRequired("制单日期"),
//	        ],
	        carrierUnitCode:[
	        	this._ruleRequired("承运单位"),
	        ],
//	        plateNumber:[
//	        	this._ruleRequired("车牌号"),
//	        	this._ruleLicensePlate(),
//	        ],
//	        carrier:[
//	        	this._ruleRequired("承运人"),
//	        ],
	        phoneNumber:[
	        	this._ruleMobile(),
	        ],
//	        deliveryDate:[
//	        	this._ruleRequired("发货日期"),
//	        ],
//	        totalQuality:[
//	        	this._ruleRequired("出库总量"),
//	        ]
      	}
    };
  },
  mounted() {
  	this.mainorderId = this.$route.query.id
  	this.outmainorderId = this.$route.query.id
  	this.afterdate = this.getToday;
  	this.getisUrgent();
  	this.getdelivermethod();
  	this.getdeliverstatus();
//	this.getwarehouseinfo();
	this.getarrivalwarehouseinfo();
//	this.getAllMerchantEntitycustomer();
//	this.getAllMerchantEntitytravellingtrader();
//	this.getAllCarrierunitEntity();
	this.getAllShippingtypeEntity();
  	this.getoutmainorderedit();
  	this.getdetail()
  },
  methods: {
  	qualityBoxchange(index,row){
  		if(row.qualityBox==null||row.qualityBox==''||row.qualityBox==undefined){
  			row.qualityBox = 0
  			row.qualityBoxunit = 0.00.toFixed(2)
  		}else{
  			row.qualityBoxunit = (row.qualityBox*row.converCoef).toFixed(2)
  		}
  	},
  	/**
  	 * 根据id获取出库单信息
  	 */
  	getoutmainorderedit(){
  		return this._ajax({
			url: this.rootAPI, 
			name: 'outmainorder/queryById', 
			param: {id:this.mainorderId}, 
			}).then((d) => {
				if(d.state === 0){
					this.form = d.aaData
					this.form.isUrgent = this.form.isUrgent+''
					/**
					 * 加载 对应单位信息
					 */
					this.getwarehouseinfo(this.form.outboundWareCode);
					this.getAllMerchantEntitycustomer(this.form.purchaseUnitCode);
					this.getAllMerchantEntitytravellingtrader(this.form.forwardUnitCode);
					this.getAllCarrierunitEntity(this.form.carrierUnitCode);
					/**
                   * 验证物料单号   验证合同号重复性使用
                   */
                  this.shipmentNumber=this.form.shipmentNumber
    			  this.contractNumber=this.form.contractNumber
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
			name: 'outorderdetail/queryBymainId', 
			param: {mainorderId:this.mainorderId}, 
			}).then((d) => {
				if(d.state === 0){
					this.detailtableData = d.aaData
					for (var i=0;i<this.detailtableData.length;i++) {
						this.detailtableData[i].qualityBoxunit = (this.detailtableData[i].qualityBox*this.detailtableData[i].converCoef).toFixed(2)
					}
					// 自版本赋值
			  		this.searchForm.subverId = this.detailtableData[0].subverId
					this.searchForm.materCode = this.detailtableData[0].materCode
			  		this.searchForm.orderdetailId=this.detailtableData[0].id
			  		/**
			  		 * 获取 表格对应数据
			  		 */
			  		this.materCodelocal = this.detailtableData[0].materCode
			  		this.materNamelocal = this.detailtableData[0].materName
			  		this.searchTable()
				}
    		}, (d) => {
                this.$message.error('数据获取失败');
        })
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
  	
  	/**
  	 * 是否紧急出库
  	 */
    getisUrgent() {
      return this._searchDic("ISURGENT").then(
        function(d) {
          this.isUrgentOption = this._dicKey(d);
        }.bind(this)
      );
    },
  	modalClosess(){
  		this.modalShowlocal=false;
  	},
	/**
	 * 替换 货位并保存
	 */
	selectreplace(row){
		if(this.localdataCache.realoutQuality>row.quality){
			this.$message({
	            type: "warning",
	            message: "整托盘现存数量 小于 当前出库货位绑定托盘真实出库数量  请重新选择	" // + d.msg
	        });
			return;
		};
		
		this.updateboj.soleCode = row.soleCode
		this.updateboj.subverId = row.subverId
		this._ajax({
              url: this.rootAPI,
              name: "outtraylocalmap/updatelocal",
              param: this.updateboj
            }).then(
              (d => {
                if (d.state == 0) {
                    this.$message({ type: "success", message: "修改成功" });
                    this.searchForm.subverId = row.subverId
				    this.searchForm.materCode = row.materCode
			  		this.searchForm.orderdetailId=this.updateboj.orderdetailId
			  		/**
			  		 * 获取 表格对应数据
			  		 */
			  		this.searchTable()
                } else {
                  this.$message({
                    type: "warning",
                    message: "修改失败" // + d.msg
                  });
                }
              }).bind(this)
            );
	},
  	reset(){
  		this.searchForm.localCode=''
  		this.searchTable()
  	},
  	adjustment(row){
  		this.localdataCache = row;
  		this.updateboj = {
  			id:row.id,
  			orderdetailId:row.orderdetailId,
  			receivorId:row.receivorId,
  			receivorName:row.receivorName,
  			receiveDate:row.receiveDate,
  			cigsmokeQuality:row.cigsmokeQuality,
  			trayRfid:row.trayRfid,
  			localCode:row.localCode,
  			localRfid:row.localRfid,
  			status:row.status,
  			batchNo:row.batchNo,
  			createdDate:row.createdDate,
  			createdPersonId:row.createdPersonId,
  			createdPerson:row.createdPerson,
  			updatedDate:row.updatedDate,
  			updatedPersonId:row.updatedPersonId,
  			updatedPerson:row.updatedPerson,
  			soleCode:row.soleCode,
  			trayCode:row.trayCode,
  			wareMethod:row.wareMethod,
  			localId:row.localId,
  			materCode:row.materCode,
  			realoutQuality:row.realoutQuality,
  			oldsoleCode:row.soleCode,	
  		}
  		this.modalShowlocal = true;
  	},
  	/**
  	 * 获取客户信息
  	 */
  	getAllMerchantEntitycustomer(query){
  		var vm = this
  		if(query==null){
  			query=''
  		}
		vm.merchantOption = []
		return vm._ajax({
			url: vm.rootAPI, 
			name: 'merchant/getAllMerchantEntitycustomer', 
			param: {keyword:query}, 
			}).then((d) => {
				if(d.state === 0){
					var aaData = d.aaData
					aaData.forEach(function(el) {
						vm.merchantOption.push({
							value: el.code,
  							label: el.name
						})
					})	
				}
    		}, (d) => {
                this.$message.error('数据获取失败');
            })
  	},
  	/**
  	 * 获取客商信息
  	 */
  	getAllMerchantEntitytravellingtrader(query){
  		if(query==null){
  			query='';
  		}
  		var vm = this
		vm.forwardUnitOption = []
		return vm._ajax({
			url: vm.rootAPI, 
			name: 'merchant/getAllMerchantEntitytravellingtrader', 
			param: {keyword:query}, 
			}).then((d) => {
				if(d.state === 0){
					var aaData = d.aaData
					aaData.forEach(function(el) {
						vm.forwardUnitOption.push({
							value: el.code,
  							label: el.name
						})
					})	
				}
    		}, (d) => {
                this.$message.error('数据获取失败');
            })
  	},
  	/**
  	 * 获取车辆信息 （暂时没有数据）
  	 */
  	getAllVehicleinfoEntity(){
  		var vm = this
		vm.vehicleinfoOption = []
		return vm._ajax({
			url: vm.rootAPI, 
			name: 'vehicleinfo/getAllVehicleinfoEntity', 
			param: {}, 
			}).then((d) => {
				if(d.state === 0){
					var aaData = d.aaData
					aaData.forEach(function(el) {
						vm.vehicleinfoOption.push({
							value: el.mobile,
  							label: el.name
						})
					})	
				}
    		}, (d) => {
                this.$message.error('通道取失败');
            })
  	},
  	/**
  	 * 获取驾驶员信息
  	 */
  	getAllDriversEntity(){
  		var vm = this
		vm.driversOption = []
		return vm._ajax({
			url: vm.rootAPI, 
			name: 'drivers/getAllDriversEntity', 
			param: {}, 
			}).then((d) => {
				if(d.state === 0){
					var aaData = d.aaData
					aaData.forEach(function(el) {
						vm.driversOption.push({
							value: el.mobile,
  							label: el.name
						})
					})	
				}
    		}, (d) => {
                this.$message.error('通道取失败');
            })
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
  	},
  	/**
	 * 获取出库方式
	 */
	getdelivermethod(){
		return this._searchDic("DELIVER_METHOD").then(
	        function(d) {
	          this.delivermethodOptions = this._dicKey(d);
	        }.bind(this)
	      );
	},
	/**
	 * 获取出库状态
	 */
	getdeliverstatus(){
		return this._searchDic("DELIVER_STATUS").then(
	        function(d) {
	          this.deliverstatusOption = this._dicKey(d);
	        }.bind(this)
	      );
	},
	/**
	 * 开始分配货位
	 */
	assigned(row){
		return this._ajax({
			url: this.rootAPI, 
			name: 'inventorytraylocalmap/getInventorytraylocalmapEntityBymaterCode', 
			param: {
				materCode:row.materCode,
				qualityBox:row.qualityBox,
				orderdetailId:row.id,
				subverId:row.subverId,
			},
			}).then((d) => {
				if(d.state === 0){
					/**
			  		 * 点击行     对物料编码筛选条件赋值
			  		 */
			  		this.searchForm.subverId = row.subverId
			  		this.searchForm.materCode = row.materCode
					this.searchForm.orderdetailId=row.id
			  		/**
			  		 * 获取 表格对应数据
			  		 */
			  		this.searchTable()
				}
				this.detailClick(row)
    		}, (d) => {
                this.$message.error('分配失败');
            })
	},
  	automatic(row){
  		if(row.subverId==null){
  			this.$message({ type: "warning", message: "子版本不能为空    "+row.materName+"      的子版本" });
  			return;
  		}
  		if(row.qualityBox===0){
  			 this.$message({ type: "warning", message: "出库数量不能为0" });
  			return;
  		}else{
  			if(row.qualityBox>row.usableQuality){
  				 this.$message({ type: "warning", message: "出库数量不能超出可操作量" });
  				 return;
  			}
  			/**
  			 *  1 判断出库数量是否被修改
  			 * 		传入参数明细id 和 当前出库数量
  			 * 	2 如果被修改 重新生成货位分配  
  			 *  3 如果没有被修改 只展示数据 不重新分配货位
  			 */
  			
  			return this._ajax({
					url: this.rootAPI, 
					name: 'outorderdetail/checkdetailquickBoxbyId', 
					param: {
						id:row.id,
						newquickBox:row.qualityBox,
					},
					}).then((d) => {
						if(d.state === 0){
							//判断是否修改过出库量   0-》未修改   不为0--》已修改
							if(d.aaData==0){
								//未修改过出库量     不做任何操作     显示对应数据
								this.detailClick(row)
							}else{
								//出库数量已被修改 
								this.assigned(row)
							}
						}
		    		}, (d) => {
		                this.$message.error('分配失败');
		            })
  		}
  	},
  	/**
  	 * 获取临时表数据
  	 */
  	searchTable(){
  		Object.assign(this.searchForm, {
					pageNum: this.pageNum, 
					pageSize: this.pageSize
				})
				return this._ajax({
			        url: this.rootAPI,
			        name: "outtraylocalmap/list",
			        param: this.searchForm,
			        loading: "dataLoading"
			    }).then(this.renderTable);
  	},
  	deldetail(index,row){
  		if(this.form.orignMethod==1){
  			this.$message({
                type: "warning",
                message: "物流系统数据 不能删除该明细" 
              });
	        return;
  		}
  		if(this.detailtableData.length==1){
			this.$message({
                type: "warning",
                message: "该明细为最后一条数据  不能删除" 
              });
	        return;
		}
  		//删除明细数据    缓存明细数据
  		this.dataCache = this.detailtableData
  		if(row.qualityBox==0){
  			/**
	  		 * 删除明细数据
	  		 */
  			this.confirm(
		        "确定删除？",
		        function() {
		          this._ajax({
		            url: this.rootAPI + "outorderdetail/delete",
		            param: {id:row.id}
		          }).then(
		            function(d) {
		              if (d.state == 0) {
		                this.$message({ type: "success", message: "删除成功" });
		                this.dataCache.splice(index,1)
		                this.getoutdetail(this.form.id)
		              } else {
		                this.$message({ type: "warning", message: "删除失败" });
		              }
		              this.handleCurrentChange(1);
		            }.bind(this)
		          );
		        }.bind(this)
		    );
  		}else{
  			/**
	  		 * 删除出库货位数据  
	  		 * 		根据出库明细id删除
	  		 * 		还原库存货位状态
	  		 */
  			this.confirm(
		        "确定删除？",
		        function() {
		          this._ajax({
		            url: this.rootAPI + "outtraylocalmap/deleteorderdetail",
		            param: {id:row.id}
		          }).then(
		            function(d) {
		              if (d.state == 0) {
		                this.$message({ type: "success", message: "删除成功" });
		                 this.dataCache.splice(index,1)
		                this.getoutdetail(this.form.id)
		              } else {
		                this.$message({ type: "warning", message: "删除失败" });
		              }
		              this.handleCurrentChange(1);
		            }.bind(this)
		          );
		        }.bind(this)
		    );
  		}
  		
  		
  	},
  	/**
  	 * 根据id 获取出库单信息
  	 */
  	getoutmainorder(val){
  		return this._ajax({
			url: this.rootAPI, 
			name: 'outmainorder/queryById', 
			param: {id:val}, 
			}).then((d) => {
				if(d.state === 0){
					this.form = d.aaData
					this.form.isUrgent = this.form.isUrgent+''
				}
    		}, (d) => {
                this.$message.error('数据获取失败');
        })
  	},
  	/**
  	 * 根据id 获取出库单明细信息
  	 */
  	getoutdetail(val){
  		return this._ajax({
			url: this.rootAPI, 
			name: 'outorderdetail/queryBymainId', 
			param: {mainorderId:val}, 
			}).then((d) => {
				if(d.state === 0){
					this.detailtableData = d.aaData
					//判断是否为物流系统数据
					if(this.form.orignMethod==2){
						//如果是手动录入数据   判断 缓存的明细数据是否为null
						if(this.dataCache.length==0){
							for (var i=0;i<this.detailtableData.length;i++) {
								this.detailtableData[i].qualityBoxunit = (this.detailtableData[i].qualityBox*this.detailtableData[i].converCoef).toFixed(2)
							}
						}else{
							for (var i=0;i<this.detailtableData.length;i++) {
								this.detailtableData[i].qualityBox = this.dataCache[i].qualityBox
								this.detailtableData[i].qualityBoxunit = (this.detailtableData[i].qualityBox*this.detailtableData[i].converCoef).toFixed(2)
							}
						}
					}else{
						for (var i=0;i<this.detailtableData.length;i++) {
								this.detailtableData[i].qualityBoxunit = (this.detailtableData[i].qualityBox*this.detailtableData[i].converCoef).toFixed(2)
							}
					}
				}
    		}, (d) => {
                this.$message.error('数据获取失败');
        })
  	},
  	selectList(tableArr){
  		/**
  		 * 保存 出库单信息  保存明细明细
  		 * 	判断出库单id是否为null
  		 * 		如果出库单id为null 新增出库单信息 新增明细信息
  		 * 		如果出库单id不为null  添加明细信息
  		 */
  		if(this.form.id==null){
  			/**
  			 * 将选择的数据放入 detailtableData数组中
  			 */
  			for(var i= 0 ;i<tableArr.length;i++){
  			//根据materCode 分配出库货位
	  			this.detailtableDatatemp.push({
	  				id:'',
	  				mainorderId:'',
	  				materCode:tableArr[i].materCode,
	  				materName:tableArr[i].materName,
	  				qualityBox:0,
	  				priceNotax:0,
	  				amountNotax:0,
	  				taxRate:0,
	  				taxAmount:0,
	  				amount:0,
	  				materVersion:tableArr[i].materVersion,
	  				materCigbrand:tableArr[i].materCigbrand,
	  				cigtype:tableArr[i].cigtype,
	  			})
	  		}
  			/**
  			 * 将出库单 明细 数据 新增到数据库中
  			 */
  			var outmainorder = JSON.stringify(this.form)
    		var details = JSON.stringify(this.detailtableDatatemp)
    		//新增
            Object.assign(this.form, {
              createdPersonId: this.userinfo.userId,
              createdPerson: this.userinfo.nickName
            });
            this._ajax({
              url: this.rootAPI,
              name: "outmainorder/create",
              param: {outmainorder:outmainorder,details:details}
            }).then(
              (d => {
                if (d.state == 0) {
                  this.getoutmainorder(d.aaData)
                  this.getoutdetail(d.aaData)
                  this.outmainorderId = d.aaData
                 
                } else {
                  this.$message({
                    type: "warning",
                    message: "保存失败" // + d.msg
                  });
                }
              }).bind(this)
            );
  		}else{
  			//第二次选择添加数据  将明显数据缓存
  			this.dataCache = this.detailtableData
  			
  			this.detailtableDatatemp=[]
  			for(var i= 0 ;i<tableArr.length;i++){
  			//根据materCode 分配出库货位
	  			this.detailtableDatatemp.push({
	  				id:null,
	  				mainorderId:this.form.id,
	  				materCode:tableArr[i].materCode,
	  				materName:tableArr[i].materName,
	  				qualityBox:0,
	  				priceNotax:0,
	  				amountNotax:0,
	  				taxRate:0,
	  				taxAmount:0,
	  				amount:0,
	  				materVersion:tableArr[i].materVersion,
	  				materCigbrand:tableArr[i].materCigbrand,
	  				cigtype:tableArr[i].cigtype,
	  				subverId:tableArr[i].subverId,
	  				subverName:tableArr[i].subverName,
	  				isDelete:0,
	  			})
	  			
	  			this.dataCache.push({
	  				id:null,
	  				mainorderId:this.form.id,
	  				materCode:tableArr[i].materCode,
	  				materName:tableArr[i].materName,
	  				qualityBox:0,
	  				priceNotax:0,
	  				amountNotax:0,
	  				taxRate:0,
	  				taxAmount:0,
	  				amount:0,
	  				materVersion:tableArr[i].materVersion,
	  				materCigbrand:tableArr[i].materCigbrand,
	  				cigtype:tableArr[i].cigtype,
	  				subverId:tableArr[i].subverId,
	  				subverName:tableArr[i].subverName,
	  				isDelete:0,
	  			})
	  		}
  			//添加明细
  			var details = JSON.stringify(this.detailtableDatatemp)
            Object.assign(this.form, {
              createdPersonId: this.userinfo.userId,
              createdPerson: this.userinfo.nickName
            });
            this._ajax({
              url: this.rootAPI,
              name: "outorderdetail/createdetails",
              param: {details:details}
            }).then(
              (d => {
                if (d.state == 0) {
                  this.getoutdetail(this.form.id)
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
  	 * 任务分配
  	 *  根据
  	 */
  	taskallocation(val){
  		
  	},
  	handleChangequalityBox(val){
  		console.log(val)
  	},
  	handleChangecigsmokeQuality(val){
  		console.log(val)
  	},
  	/**
  	 *  点击明细行    更新出库货位表数据
  	 * 	货位表数据 根据 批次号和物料编码确定表中数据
  	 */
  	detailClick(row){
  		/**
  		 * 点击行     对物料编码筛选条件赋值
  		 */
  		this.searchForm.subverId = row.subverId
  		this.searchForm.materCode = row.materCode
  		this.searchForm.orderdetailId=row.id
  		this.materCodelocal = row.materCode
  		this.materNamelocal = row.materName
  		/**
  		 * 查询数据 放入对应表格
  		 */
  		this.searchTable()
  	},
  	adddetail(formname){
  		if(this.form.orignMethod==1){
  			this.$message({
                type: "warning",
                message: "物流系统数据 不能新增明细" 
              });
	        return;
  		}
  		if(this.form.outboundWareCode==this.form.arrivalWareCode){
			this.$message({
	                    type: "warning",
	                    message: "出库仓库与到货仓库不能为同一仓库" 
	                  });
	        return;
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
  	getsubverName(row){
  		let obj = {};
  		 obj = row.subList.find((item)=>{
                return item.id === row.subverId;
            });
            row.subverName = obj.subverName;
        this.updatedetailByindexrow(row)
  	},
  	updatedetailByindexrow(row){
  		this._ajax({
              url: this.rootAPI,
              name: "outorderdetail/update",
              param: row
            }).then(
              (d => {
                if (d.state == 0) {
                  this.$message({ type: "success", message: "保存成功" });
                  this.getoutdetail(this.form.id)
                } else {
                  this.$message({
                    type: "warning",
                    message: "保存失败" // + d.msg
                  });
                }
              }).bind(this)
            );
  	},
  	purchaseUnitCodeChange(val){
  		let obj = {};
            obj = this.merchantOption.find((item)=>{
                return item.value === val;
            });
            this.form.purchaseUnit = obj.label;
  	},
  	forwardUnitCodeChange(val){
  		let obj = {};
            obj = this.forwardUnitOption.find((item)=>{
                return item.value === val;
            });
            this.form.forwardUnit = obj.label;
  	},
  	carrierUnitChange(val){
  		let obj = {};
            obj = this.carrierUnitOption.find((item)=>{
                return item.value === val;
            });
            this.form.carrierUnit= obj.label;
  	},
  	gettransportCode(val){
  		let obj = {};
            obj = this.shippingtypeOption.find((item)=>{
                return item.value === val;
            });
            this.form.transportType = obj.label;
  	},
  	arrivalWareCodeChange(val){
  		let obj = {};
            obj = this.arrivalwarehouseOption.find((item)=>{
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
  	 * 获取仓库信息
  	 */
  	getarrivalwarehouseinfo(query){
  		var vm = this
  		if(query==null){
  			query='';
  		}
		vm.arrivalwarehouseOption = []
		return vm._ajax({
			url: vm.rootAPI, 
			name: 'warehouseinfo/queryendproduct', 
			param: {keyword:query}, 
			}).then((d) => {
				if(d.state === 0){
					var aaData = d.aaData
					aaData.forEach(function(el) {
						vm.arrivalwarehouseOption.push({
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
    	this.$router.push({path:"/deliver"});
    },
    /**
	 * 发送请求 验证出库明细数据 与 目前数据是否一致
	 */
    checkdetailsquickBox(formname){
    	 this.$refs[formname].validate(valid => {
	        if (valid) {
	        	/**
				 * 验证出库厂库入入库厂库
				 */
				if(this.form.outboundWareCode==this.form.arrivalWareCode){
					this.$message({
			                    type: "warning",
			                    message: "出库仓库与到货仓库不能为同一仓库" 
			                  });
			        return;
				}
				if(this.detailtableData.length==0){
					this.$message({
		                type: "warning",
		                message: "该明细为最后一条数据  不能删除" 
		              });
			        return;
				}
				/**
				 * 验证明细数据是否被修改
				 */
				var details = JSON.stringify(this.detailtableData)
				return this._ajax({
					url: this.rootAPI, 
					name: 'outorderdetail/checkdetailsquickBox', 
					param: {details:details}, 
					}).then((d) => {
						if(d.state === 0){
							this.roughstate()
						}
		    		}, (d) => {
		    			this.$message({
			                type: "warning",
			                message: "明细数据被修改 请分配货位后保存" 
			              });
		                return;
		            })
	        } else {
	          return false;
	        }
	      });
    	
    	
    },
    roughstate(){	
		/**
		 * 保存数据
		 * 	将对象转为字符串
		 */
    	var outmainorder = JSON.stringify(this.form)
    	var details = JSON.stringify(this.detailtableData)
    	
    	//新增
        Object.assign(this.form, {
          updatedPersonId: this.userinfo.userId,
          updatedPerson: this.userinfo.nickName
        });
        this._ajax({
              url: this.rootAPI,
              name: "outmainorder/update",
              param: this.form
            }).then(
          (d => {
            if (d.state == 0) {
              this.$message({ type: "success", message: "保存成功" });
              //开出数量修改
              this.$router.push({path:"/deliver"});
            } else {
              this.$message({
                type: "warning",
                message: "保存失败" // + d.msg
              });
            }
          }).bind(this)
        );
	        
    },
    save(formname) {
      this.$refs[formname].validate(valid => {
        if (valid) {
          if (this.tableRow && this.tableRow.id > 0) {
            //编辑
            Object.assign(this.form, {
              updatedPersonId: this.userinfo.userId,
              updatedPerson: this.userinfo.nickName
            });
            this._ajax({
              url: this.rootAPI,
              name: " outmainorder/update",
              param: this.form
            }).then(
              (d => {
                if (d.state == 0) {
                  this.$message({ type: "success", message: "保存成功" });
                  this.$emit("submit");
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
              name: "floorinfo/create",
              param: this.form
            }).then(
              (d => {
                if (d.state == 0) {
                  this.$message({ type: "success", message: "保存成功" });
                  this.$emit("submit");
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
  }
};
</script>

<style lang="sass">
	.deliveredit{
		.el-form-item--mini.el-form-item, .el-form-item--small.el-form-item{
		    margin-bottom: 15px;
		}
	}
</style>