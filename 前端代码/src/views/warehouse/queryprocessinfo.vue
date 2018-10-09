<template>
    <div>
    	<el-card class="box-card">
		  <div slot="header" class="clearfix">
		    <span>过程主信息</span>
		  </div>
		  <div class="text item">
		    <el-form class="modal-form" :inline="true" labelWidth="120px">
		    	<div style="margin-left: -3%;">
				    <el-row>
			            <el-col :span="5">
						  <el-form-item label="物料编码:">
						  	{{form.materCode}}
						  </el-form-item>
			            </el-col>
			            <el-col :span="5">
						  <el-form-item label="物料品牌:">
						  	{{form.materCigbrand}}
						  </el-form-item>
			            </el-col>
			            <el-col :span="5">
						  <el-form-item label="物料名称:">
						  	{{form.materName}}
						  </el-form-item>
			            </el-col>
			            <el-col :span="5">
						  <el-form-item label="物料版本:">
						    {{form.materVersion}}
						  </el-form-item>
			            </el-col>
			        </el-row>
				    <el-row>
			            <el-col :span="5">
						  <el-form-item label="批次号码:">
						  	{{form.batchNo}}
						  </el-form-item>
			            </el-col>
			            <el-col :span="5">
						  <el-form-item label="可用库存:">
						    {{form.availableStocks}}
						  </el-form-item>
			            </el-col>
			            <el-col :span="5">
				          <el-form-item label="总库存量:">
						  	{{form.totalCount}}
						  </el-form-item>
			            </el-col>
			            <el-col :span="5">
						  <el-form-item label="子版本名:">
						    {{form.subverName}}
						  </el-form-item>
			            </el-col>
			        </el-row>
		    	</div>
	    	</el-form>
		  </div>
		</el-card>
		<el-card class="box-card second">
		  <div class="text item">
			<el-steps :active="active" finish-status="success" align-center>
			  <el-step title="入库"></el-step>
			  <el-step title="库存"></el-step>
			  <el-step title="盘点"></el-step>
			  <el-step title="货位调整"></el-step>
			  <el-step title="不合格处理"></el-step>
			  <el-step title="出库"></el-step>
			</el-steps>
		  </div>
		  <div>
			<!--库存-->
			<div id="inventory">
				<div style="margin-top: 20px;">
					<div style="margin-bottom: 20px;">库存信息</div>
					<el-table :data="tableDataM" stripe style="width: 100%">
						<el-table-column prop="lockStock" label="锁定库存（件）" width="180"></el-table-column>
						<el-table-column prop="availableStocks" label="可用库存（件）" width="180"></el-table-column>
						<el-table-column prop="inventQuality" label="入库总量（件）" width="180"></el-table-column>
						<el-table-column prop="outQuality" label="出库总量（件）" width="180"></el-table-column>
						<el-table-column prop="surplusQuality" label="剩余总量（件）" width="180"></el-table-column>
						<el-table-column prop="outoquality" label="开出数量（件）" width="180"></el-table-column>
				<!--		<el-table-column prop="produceDate" label="生产时间"></el-table-column>-->
						<el-table-column prop="cigtype" label="卷烟类型" width="180">
							<template slot-scope="scope">
								<toolTip :content="_dicValue(scope.row.cigtype, InMapPtions)">
									<tagItem type="success" :text="_dicValue(scope.row.cigtype, InMapPtions)"></tagItem>
					    			<!--<span>{{_dicValue(scope.row.cigtype, InMapPtions)}}</span>-->
					    	   </toolTip>
							</template>
						</el-table-column>
						<el-table-column prop="createdDate" label="时间"></el-table-column>
					</el-table>
				</div>
				<div style="margin-top: 20px;">
					<div style="margin-bottom: 20px;">货位托盘详情</div>
					<el-table :data="tableDataMDlL" stripe style="width: 100%">
						<el-table-column prop="quality" label="数量" ></el-table-column>
						<!--<el-table-column prop="localCode" label="货位编号" ></el-table-column>-->
						<el-table-column prop="descript" label="货位描述" ></el-table-column>
				<!--		<el-table-column prop="trayCode" label="托盘编号" ></el-table-column>-->
						<el-table-column prop="status" label="状态" >
							<template slot-scope="scope">
								<toolTip :content="_dicValue(scope.row.status, inMapMethod)">
									<tagItem type="warning" :text="_dicValue(scope.row.status, inMapMethod)"></tagItem>
				<!--	    			<span>{{_dicValue(scope.row.status, inMapMethod)}}</span>-->
					    	   </toolTip>
							</template>
						</el-table-column>
						<el-table-column prop="outDate" label="出库时间" ></el-table-column>
						<el-table-column prop="produceDate" label="生产时间"></el-table-column>
					</el-table>
				</div>
			</div>
			<!--入库阶段-->
			<div id="entry">
				<div style="margin-top: 20px;">
					<div style="margin-bottom: 20px;">入库信息</div>
					<el-table :data="tableDataE"  stripe style="width: 100%">
						<el-table-column prop="plateNumber" label="车牌号" width="100"></el-table-column>
						<el-table-column prop="totalQuality" label="总量（件）" width="100"></el-table-column>
						<el-table-column prop="carrierUnit" label="承运单位" width="150"></el-table-column>
						<el-table-column prop="intoWarehouseName" label="移入仓库名称" width="150"></el-table-column>
						<el-table-column prop="originWarehouseName" label="移出仓库名称" width="150"></el-table-column>
						<el-table-column prop="quality" label="数量（件）"></el-table-column>
						<el-table-column prop="actualQuality" label="实际入库量（件）"></el-table-column>
						<el-table-column prop="produceDate" label="生产时间"></el-table-column>
						<el-table-column prop="status" label="入库状态">
							<template slot-scope="scope">
								<toolTip :content="_dicValue(scope.row.status, warehousingStatus)">
									<tagItem type="warning" :text="_dicValue(scope.row.status, warehousingStatus)"></tagItem>
					    		<!--	<span>{{_dicValue(scope.row.status, warehousingStatus)}}</span>-->
					    	    </toolTip>
							</template>
						</el-table-column>
						<el-table-column prop="entryCompliteDate" label="入库时间"></el-table-column>
						<!--<el-table-column prop="remark" label="备注"></el-table-column>-->
					</el-table>
				</div>
				<div style="margin-top: 20px;">
					<div style="margin-bottom: 20px;">货位托盘详情</div>
					<el-table :data="tableDataEDlL" stripe   style="width: 100%">
						<el-table-column prop="descript" label="货位描述" width="230"></el-table-column>
						<el-table-column prop="cigsmokeQuality" label="托盘件烟数量（件）" width="230"></el-table-column>
				<!--		<el-table-column prop="trayCode" label="托盘编号" width="180"></el-table-column>-->
						<el-table-column prop="wareMethod" label="入库方式" width="230">
							<template slot-scope="scope">
								<toolTip :content="_dicValue(scope.row.wareMethod, enterMapMethod)">
									<tagItem type="success" :text="_dicValue(scope.row.wareMethod, enterMapMethod)"></tagItem>
					    <!--			<span>{{_dicValue(scope.row.wareMethod, enterMapMethod)}}</span>-->
					    	    </toolTip>
							</template>
						</el-table-column>
						<el-table-column prop="status" label="状态" width="230">
							<template slot-scope="scope">
								<toolTip :content="_dicValue(scope.row.status, enterMap)">
									<tagItem type="warning" :text="_dicValue(scope.row.status, enterMap)"></tagItem>
					    <!--			<span>{{_dicValue(scope.row.status, enterMap)}}</span>-->
					    	    </toolTip>
							</template>
						</el-table-column>
						<el-table-column prop="soleCode" label="唯一码" width="230"></el-table-column>
						<el-table-column prop="createdDate" label="时间" ></el-table-column>
					</el-table>
				</div>
			</div>
			<!--出库阶段-->
			<div id="out">
				<div style="margin-top: 20px;">
					<div style="margin-bottom: 20px;">出库信息</div>
					<el-table :data="tableDataO"   style="width: 100%">
						<el-table-column prop="plateNumber" label="车牌号"></el-table-column>
						<el-table-column prop="totalQuality" label="总量（件）"></el-table-column>
						<el-table-column prop="transportType" label="运输方式"></el-table-column>
						<el-table-column prop="carrier" label="承运人"></el-table-column>
						<el-table-column prop="carrierUnit" label="承运单位"></el-table-column>
						<el-table-column prop="outboundWare" label="出库仓库名称"></el-table-column>
						<el-table-column prop="arrivalWare" label="到货仓库名称"></el-table-column>
						<el-table-column prop="purchaseUnit" label="购货单位"></el-table-column>
					<!--	<el-table-column prop="remark" label="备注"></el-table-column>-->
						<el-table-column prop="status" label="出库状态">
							<template slot-scope="scope">
								<toolTip :content="_dicValue(scope.row.status, outMainOrder)">
									<tagItem type="warning" :text="_dicValue(scope.row.status, outMainOrder)"></tagItem>
					    		<!--	<span>{{_dicValue(scope.row.status, outMainOrder)}}</span>-->
					    	    </toolTip>
							</template>
						</el-table-column>
						<el-table-column prop="outCompliteDate" label="出库时间" width="180"></el-table-column>
					</el-table>
				</div>
				<div style="margin-top: 20px;">
					<div style="margin-bottom: 20px;">出库详情</div>
					<el-table :data="tableDataOD"   style="width: 100%">
						<el-table-column prop="orderNumber" label="订单编号" width="180"></el-table-column>
						<el-table-column prop="qualityBox" label="数量（件）"></el-table-column>
						<el-table-column prop="priceNotax" label="单价"></el-table-column>
						<el-table-column prop="amountNotax" label="金额"></el-table-column>
						<el-table-column prop="taxRate" label="税率"></el-table-column>
						<el-table-column prop="taxAmount" label="税额"></el-table-column>
						<el-table-column prop="amount" label="总金额"></el-table-column>
					</el-table>
				</div>
				<div style="margin-top: 20px;">
					<div style="margin-bottom: 20px;">货位托盘详情</div>
					<el-table :data="tableDataODlL"   style="width: 100%">
						<el-table-column prop="receivorName" label="领取人账号"></el-table-column>
						<el-table-column prop="cigsmokeQuality" label="托盘件烟数量" ></el-table-column>
						<el-table-column prop="descript" label="货位描述" ></el-table-column>
	<!--					<el-table-column prop="localCode" label="货位编码" ></el-table-column>-->
						<el-table-column prop="status" label="状态">
							<template slot-scope="scope">
								<toolTip :content="_dicValue(scope.row.status, outTrayLocal)">
									<tagItem type="warning" :text="_dicValue(scope.row.status, outTrayLocal)"></tagItem>
					    			<span>{{_dicValue(scope.row.status, outTrayLocal)}}</span>
					    	    </toolTip>
							</template>
						</el-table-column>
						<el-table-column prop="wareMethod" label="出库方式">
							<template slot-scope="scope">
								<toolTip :content="_dicValue(scope.row.wareMethod, outTrayType)">
					    			<span>{{_dicValue(scope.row.wareMethod, outTrayType)}}</span>
					    	    </toolTip>
							</template>
						</el-table-column>
						<el-table-column prop="soleCode" label="唯一码"></el-table-column>
						<el-table-column prop="createdDate" label="时间"></el-table-column>
					</el-table>
				</div>
			</div>
			<!--盘点阶段-->
			<div id="stockcheck">
				<div style="margin-top: 20px;">
					<div style="margin-bottom: 20px;">盘点信息</div>
					<el-table :data="tableDataS"   style="width: 100%">
						<el-table-column prop="orderNumber" label="盘点单号" width="180"></el-table-column>
						<el-table-column prop="inventor" label="盘点人"></el-table-column>
		<!--				<el-table-column prop="remark" label="备注"></el-table-column>-->
						<el-table-column prop="inventMethod" label="盘点方式">
							<template slot-scope="scope">
								<toolTip :content="_dicValue(scope.row.inventMethod, checkMain)">
									<tagItem type="success" :text="_dicValue(scope.row.inventMethod, checkMain)"></tagItem>
					    			<!--<span>{{_dicValue(scope.row.inventMethod, checkMain)}}</span>-->
					    	   </toolTip>
							</template>
						</el-table-column>
						<el-table-column prop="status" label="状态">
							<template slot-scope="scope">
								<toolTip :content="_dicValue(scope.row.status, methodStatus)">
									<tagItem type="warning" :text="_dicValue(scope.row.status, methodStatus)"></tagItem>
					    		<!--	<span>{{_dicValue(scope.row.status, methodStatus)}}</span>-->
					    	   </toolTip>
							</template>
						</el-table-column>
						<el-table-column prop="reversion" label="是否复盘" >
							<template slot-scope="scope">
								<toolTip :content="_dicValue(scope.row.reversion, chenckAnalyes)">
										<tagItem type="success" :text="_dicValue(scope.row.reversion, chenckAnalyes)"></tagItem>
					    			<!--<span>{{_dicValue(scope.row.reversion, chenckAnalyes)}}</span>-->
					    	   </toolTip>
							</template>
						</el-table-column>
						<el-table-column prop="inventEndDate" label="盘点结束时间"></el-table-column>
					</el-table>
				</div>
				<div style="margin-top: 20px;">
					<div style="margin-bottom: 20px;">盘点详情</div>
					<el-table :data="tableDataSD"   style="width: 100%">
						<el-table-column prop="localDescript" label="货位描述" ></el-table-column>
				<!--		<el-table-column prop="localCode" label="货位编码"></el-table-column>-->
						<el-table-column prop="inventQuality" label="托盘上物料库存数量"></el-table-column>
						<el-table-column prop="actualCountQuality" label="实际盘点数量"></el-table-column>
						<el-table-column prop="floorAreaCode" label="楼层区域编码组合"></el-table-column>
						<el-table-column prop="soleCode" label="唯一码"></el-table-column>
					</el-table>
				</div>
			</div>
			<!--货位调整阶段-->
			<div  id="posit">
				<div style="margin-top: 20px;">
					<div style="margin-bottom: 20px;">货位调整</div>
					<el-table :data="tableDataP"   style="width: 100%">
						<el-table-column prop="orderNumber" label="调整单号" width="260"></el-table-column>
						<el-table-column prop="status" label="状态" width="260">
							<template slot-scope="scope">
								<toolTip :content="_dicValue(scope.row.status, posStatus)">
									<tagItem type="warning" :text="_dicValue(scope.row.status, posStatus)"></tagItem>
					    			<!--<span>{{_dicValue(scope.row.status, posStatus)}}</span>-->
					    	   </toolTip>
							</template>
						</el-table-column>
						<el-table-column prop="floorCode" label="楼层编号" width="260"></el-table-column>
						<el-table-column prop="floorName" label="楼层名称" width="260"></el-table-column>
				<!--		<el-table-column prop="remark" label="备注"></el-table-column>-->
						<el-table-column prop="complitDate" label="完成时间"></el-table-column>
					</el-table>
				</div>
				<div style="margin-top: 20px;">
					<div style="margin-bottom: 20px;">货位调整详情</div>
					<el-table :data="tableDataPD"   style="width: 100%">
						<el-table-column prop="operator" label="操作人"></el-table-column>
						<el-table-column prop="origLocalDescript" label="原货位"></el-table-column>
						<el-table-column prop="destLocalDescript" label="目的货位"></el-table-column>
						<el-table-column prop="status" label="状态">
							<template slot-scope="scope">
								<toolTip :content="_dicValue(scope.row.status, posDetail)">
									<tagItem type="warning" :text="_dicValue(scope.row.status, posDetail)"></tagItem>
					    			<!--<span>{{_dicValue(scope.row.status, posDetail)}}</span>-->
					    	   </toolTip>
							</template>
						</el-table-column>
						<!--      <el-table-column prop="origTrayRfid" label="原托盘rfid编号"></el-table-column>-->
						<el-table-column prop="soleCode" label="唯一码"></el-table-column>
					</el-table>
				</div>
			</div>
			<!--不合格处理阶段-->
			<div id="unqualified">
				<div style="margin-top: 20px;">
					<div style="margin-bottom: 20px;">不合格处理信息</div>
					<el-table :data="tableDataU"   style="width: 100%">
						<el-table-column prop="iName" label=""></el-table-column>
						<el-table-column prop="entryOrder" label="入库单号" ></el-table-column>
						<el-table-column prop="descript" label="货位描述" ></el-table-column>
						<el-table-column prop="unqualifiedQuality" label="不合格品数量" ></el-table-column>
						<el-table-column prop="type" label="不合格类型" >
							<template slot-scope="scope">
								<toolTip :content="_dicValue(scope.row.type, unfitType)">
									<tagItem type="success" :text="_dicValue(scope.row.type, unfitType)"></tagItem>
					    			<!--<span>{{_dicValue(scope.row.type, unfitType)}}</span>-->
					    	   </toolTip>
							</template>
						</el-table-column>
						<el-table-column prop="status" label="状态" >
							<template slot-scope="scope">
								<toolTip :content="_dicValue(scope.row.status, unfitStatus)">
									<tagItem type="warning" :text="_dicValue(scope.row.status, unfitStatus)"></tagItem>
					    		<!--	<span>{{_dicValue(scope.row.status, unfitStatus)}}</span>-->
					    	   </toolTip>
							</template>
						</el-table-column>
						<!--<el-table-column prop="remark" label="备注"></el-table-column>-->
						<el-table-column prop="enclosure" label="附件"></el-table-column>
						<el-table-column prop="createdDate" label="时间" ></el-table-column>
					</el-table>
				</div>
			</div>
	    </div>
	    
		</el-card>
		<div style="float: right;margin-top: 20px;">
	        <el-button type="primary" @click="next">下一步</el-button>
			<el-button type="primary" @click='returnprocesstracing'>返 回</el-button>
	    </div>
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
				form: {
		          materCode: '',
		          materCigbrand: '',
		          materName: '',
		          batchNo: '',
		          totalCount: '',
		          materVersion: '',
		          availableStocks:'',
		          subverName:''
		        },
				active: 0,
				searchForm: {
					batchNo: this.$route.query.batchNo
				},
				tableDataM: [],
				tableDataMDlL: [],
				tableDataE: [],
				tableDataEDlL: [],
				tableDataS: [],
				tableDataSD: [],
				tableDataP: [],
				tableDataPD: [],
				tableDataU: [],
				batchNo: this.$route.query.batchNo,
			}

		},
		mounted: function() {
			this.getMapTrialNo();
			this.getMapEnterNo();
			this.getMapEnterMapNo();
			this.getEnterMapMethodNo();
			this.getInMapMethodNo();
			this.getCheckMain();
			this.getMethodStatus();
			this.getChenckAnalyes();
			this.getPosStatus();
			this.getPosDetail();
			this.getUnfitStatus();
			this.getUnfitType();
			this.getOutMainOrder();
			this.getOutTrayLocal();
			this.getOutTrayType();
			
			this.searchEnTable();
			this.searchEnmapTable();
			this.searchInTable();
			this.searchInmapTable();
			this.searchOnTable();
			this.searOhEnmapTable();
			this.searchSnTable();
			this.searShEnmapTable();
			this.searchPnTable();
			this.searPhEnmapTable();
			this.searchUnTable();
			document.getElementById("entry").style.display = "block";
			document.getElementById("inventory").style.display = "none";
			document.getElementById("out").style.display = "none";
			document.getElementById("stockcheck").style.display = "none";
			document.getElementById("posit").style.display = "none";
			document.getElementById("unqualified").style.display = "none";
		},
		methods: {
			next() {
		        if (this.active++ > 4) this.active = 0;
		        if (this.active==0) {
		        	document.getElementById("inventory").style.display = "none";
					document.getElementById("entry").style.display = "block";
					document.getElementById("out").style.display = "none";
					document.getElementById("stockcheck").style.display = "none";
					document.getElementById("posit").style.display = "none";
					document.getElementById("unqualified").style.display = "none";
		        }else if(this.active==1){
		        	document.getElementById("inventory").style.display = "block";
					document.getElementById("entry").style.display = "none";
					document.getElementById("out").style.display = "none";
					document.getElementById("stockcheck").style.display = "none";
					document.getElementById("posit").style.display = "none";
					document.getElementById("unqualified").style.display = "none";
		        }else if(this.active==2){
		        	document.getElementById("inventory").style.display = "none";
					document.getElementById("entry").style.display = "none";
					document.getElementById("out").style.display = "none";
					document.getElementById("stockcheck").style.display = "block";
					document.getElementById("posit").style.display = "none";
					document.getElementById("unqualified").style.display = "none";
		        }else if(this.active==3){
		        	document.getElementById("inventory").style.display = "none";
					document.getElementById("entry").style.display = "none";
					document.getElementById("out").style.display = "none";
					document.getElementById("stockcheck").style.display = "none";
					document.getElementById("posit").style.display = "block";
					document.getElementById("unqualified").style.display = "none";
		        }else if(this.active==4){
		        	document.getElementById("inventory").style.display = "none";
					document.getElementById("entry").style.display = "none";
					document.getElementById("out").style.display = "none";
					document.getElementById("stockcheck").style.display = "none";
					document.getElementById("posit").style.display = "none";
					document.getElementById("unqualified").style.display = "block";
		        }else if(this.active==5){
		        	document.getElementById("inventory").style.display = "none";
					document.getElementById("entry").style.display = "none";
					document.getElementById("out").style.display = "block";
					document.getElementById("stockcheck").style.display = "none";
					document.getElementById("posit").style.display = "none";
					document.getElementById("unqualified").style.display = "none";
		        }
		    },
			/*获取字典类型*/
		    getMapTrialNo() {
		      return this._searchDic("CIG_IS_TRIAL").then(
		        function(d) {
		          this.InMapPtions = this._dicKey(d);
		        }.bind(this)
		      );
		    },
		    /*入库状态*/
		    getMapEnterNo() {
		      return  this._searchDic("WAREHOUSING_STATUS").then(
			      function(d) {
			        this.warehousingStatus = this._dicKey(d);
			      }.bind(this)
			    );
		    },
		    /*入库托盘货位绑定信息状态*/
		    getMapEnterMapNo() {
		      return  this._searchDic("EN_MAP_STATUS").then(
			      function(d) {
			        this.enterMap = this._dicKey(d);
			      }.bind(this)
			    );
		    },
		    getEnterMapMethodNo() {
		      return  this._searchDic("EN_MAP_METHOD").then(
			      function(d) {
			        this.enterMapMethod = this._dicKey(d);
			      }.bind(this)
			    );
		    },
		    /*库存托盘货位绑定信息状态*/
		    getInMapMethodNo() {
		      return  this._searchDic("IN_MAP_STATUS").then(
			      function(d) {
			        this.inMapMethod = this._dicKey(d);
			      }.bind(this)
			    );
		    },
		    /*盘点状态*/
		    getCheckMain() {
		      return  this._searchDic("METHOD_STATUS").then(
			      function(d) {
			        this.checkMain = this._dicKey(d);
			      }.bind(this)
			    );
		    },
		    /*盘点方式*/
		    getMethodStatus() {
		      return  this._searchDic("S_CHECK_MAIN").then(
			      function(d) {
			        this.methodStatus = this._dicKey(d);
			      }.bind(this)
			    );
		    },
		    /*盘点是否复盘*/
		    getChenckAnalyes() {
		      return  this._searchDic("S_CHECK_ANALYSE").then(
			      function(d) {
			        this.chenckAnalyes = this._dicKey(d);
			      }.bind(this)
			    );
		    },
		    /*货位调整状态*/
		    getPosStatus() {
		      return  this._searchDic("IS_POS_STATUS").then(
			      function(d) {
			        this.posStatus = this._dicKey(d);
			      }.bind(this)
			    );
		    },
		    /*货位详情状态*/
		    getPosDetail() {
		      return  this._searchDic("IS_POS_DETAIL").then(
			      function(d) {
			        this.posDetail = this._dicKey(d);
			      }.bind(this)
			    );
		    },
		    /*不合格状态*/
		    getUnfitStatus() {
		      return  this._searchDic("UNFIT_STATUS").then(
			      function(d) {
			        this.unfitStatus = this._dicKey(d);
			      }.bind(this)
			    );
		    },
		    /*不合格类型*/
		    getUnfitType() {
		      return  this._searchDic("UNFIT_TYPE").then(
			      function(d) {
			        this.unfitType = this._dicKey(d);
			      }.bind(this)
			    );
		    },
		    /*出库状态*/
		    getOutMainOrder() {
		      return  this._searchDic("OUT_MAINORDER").then(
			      function(d) {
			        this.outMainOrder = this._dicKey(d);
			      }.bind(this)
			    );
		    },
		    /*出库货位托盘状态*/
		    getOutTrayLocal() {
		      return  this._searchDic("OUT_TRAYLOCAL").then(
			      function(d) {
			        this.outTrayLocal = this._dicKey(d);
			      }.bind(this)
			    );
		    },
		    /*出库方式*/
		    getOutTrayType() {
		      return  this._searchDic("OUT_TRAY_TYPE").then(
			      function(d) {
			        this.outTrayType = this._dicKey(d);
			      }.bind(this)
			    );
		    },
			searchInTable() {
				Object.assign(this.searchForm, {})
				return this._ajax({
					url: this.rootAPI,
					name: "inventorymain/selectInventory",
					param: this.searchForm,
					loading: "dataLoading"
				}).then(function(d) {
					this.tableDataM = d.aaData;
					if(this.tableDataM.length!=0){
						this.form.availableStocks=d.aaData[0].availableStocks;
						this.form.totalCount=d.aaData[0].totalCount;
					}
				}.bind(this));
			},
			searchInmapTable() {
				Object.assign(this.searchForm, {})
				return this._ajax({
					url: this.rootAPI,
					name: "inventorytraylocalmap/queryByBatchNo",
					param: this.searchForm,
					loading: "dataLoading"
				}).then(function(d) {
					this.tableDataMDlL = d.aaData;
				}.bind(this));
			},

			searchEnTable() {
				Object.assign(this.searchForm, {})
				return this._ajax({
					url: this.rootAPI,
					name: "entrymainorder/selectEntrymainor",
					param: this.searchForm,
					loading: "dataLoading"
				}).then(function(d) {
					this.tableDataE = d.aaData;
					this.form.subverName=d.aaData[0].subverName;
					this.form.materVersion=d.aaData[0].materVersion;
					this.form.batchNo=d.aaData[0].batchNo;
					this.form.materName=d.aaData[0].materName;
					this.form.materCigbrand=d.aaData[0].materCigbrand;
					this.form.materCode=d.aaData[0].materCode;
				}.bind(this));
			},
			searchEnmapTable() {
				Object.assign(this.searchForm, {})
				return this._ajax({
					url: this.rootAPI,
					name: "entrytraylocalmap/queryByBatchNo",
					param: this.searchForm,
					loading: "dataLoading"
				}).then(function(d) {
					this.tableDataEDlL = d.aaData;
				}.bind(this));
			},

			searchOnTable() {
				Object.assign(this.searchForm, {})
				return this._ajax({
					url: this.rootAPI,
					name: "outmainorder/selectOutmainor",
					param: this.searchForm,
					loading: "dataLoading"
				}).then(function(d) {
					this.tableDataO = d.aaData;
					this.tableDataOD = d.aaData;
				}.bind(this));
			},
			searOhEnmapTable() {
				Object.assign(this.searchForm, {})
				return this._ajax({
					url: this.rootAPI,
					name: "outtraylocalmap/queryByBatchNo",
					param: this.searchForm,
					loading: "dataLoading"
				}).then(function(d) {
					this.tableDataODlL = d.aaData;
				}.bind(this));
			},

			searchSnTable() {
				Object.assign(this.searchForm, {})
				return this._ajax({
					url: this.rootAPI,
					name: "stockcheckmain/queryByBatchNo",
					param: this.searchForm,
					loading: "dataLoading"
				}).then(function(d) {
					this.tableDataS = d.aaData;
				}.bind(this));
			},
			searShEnmapTable() {
				Object.assign(this.searchForm, {})
				return this._ajax({
					url: this.rootAPI,
					name: "stockcheckdetail/queryByBatchNo",
					param: this.searchForm,
					loading: "dataLoading"
				}).then(function(d) {
					this.tableDataSD = d.aaData;
				}.bind(this));
			},

			searchPnTable() {
				Object.assign(this.searchForm, {})
				return this._ajax({
					url: this.rootAPI,
					name: "positionadjustmain/queryByBatchNo",
					param: this.searchForm,
					loading: "dataLoading"
				}).then(function(d) {
					this.tableDataP = d.aaData;
				}.bind(this));
			},
			searPhEnmapTable() {
				Object.assign(this.searchForm, {})
				return this._ajax({
					url: this.rootAPI,
					name: "positionadjustdetail/queryByBatchNo",
					param: this.searchForm,
					loading: "dataLoading"
				}).then(function(d) {
					this.tableDataPD = d.aaData;
				}.bind(this));
			},

			searchUnTable() {
				Object.assign(this.searchForm, {})
				return this._ajax({
					url: this.rootAPI,
					name: "unqualifiedproduct/queryByBatchNo",
					param: this.searchForm,
					loading: "dataLoading"
				}).then(function(d) {
					this.tableDataU = d.aaData;
				}.bind(this));
			},
			returnprocesstracing() {
				this.$router.push({
					path: "/processtracing"
				});
			},

		}
	}
</script>

<style>
	.box-card{
		margin-top: -2%;
	}
	.second{
		margin-top: 1%;
	}
</style>