<template>
	<div>
		<el-form ref="searchForm" :model="searchForm">
			<!-- 查询条件 -->
			<searchInputItems>
				<el-row>
					<searchInputItem name="出库单号">
						<inputItem :value.sync="searchForm.orderNumber" :maxlength="10"></inputItem>
					</searchInputItem>
					<searchInputItem name="车牌号">
						<inputItem :value.sync="searchForm.plateNumber" :maxlength="40"></inputItem>
					</searchInputItem>
					
					<el-button icon='el-icon-arrow-down' @click='clickdown' v-show = 'downbuttonshow' style='margin-left: 200px;'>展开搜索条件</el-button>
					<el-button icon='el-icon-arrow-up' @click='clickup' v-show = 'upbuttonshow'style='margin-left: 200px;'>收起搜索条件</el-button>
				</el-row>
				<searchInputItem name="状态" v-show='fahuotimeshow'>
						<selectInput :value.sync="searchForm.status">
							<el-option
								v-for="item in orderstatusOption"
								:key="item.key"
								:label="item.value"
								:value="item.key">
							</el-option>
						</selectInput>
					</searchInputItem>
					<searchInputItem name="单据来源" v-show='fahuotimeshow'>
						<selectInput :value.sync="searchForm.orignMethod">
							<el-option
								v-for="item in orignMethodoptions"
								:key="item.key"
								:label="item.value"
								:value="item.key">
							</el-option>
						</selectInput>
					</searchInputItem>
			</searchInputItems>
		</el-form>	
        <optionItems>
			<template slot="left">
				<el-button-group>
					<iconBtn iconClass="el-icon-plus" content="新增" @click="add">新增</iconBtn>
					<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
					<iconBtn iconClass="el-icon-refresh" content="重置" @click="reset">重置</iconBtn>
				</el-button-group>				
			</template>
		</optionItems>
		
		<elemTable :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange">
			<!--<el-table-column type="selection" width="55"></el-table-column>-->
		    <el-table-column prop="orderNumber" label="出库单号" fixed width="120px">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.orderNumber">
		    			<span>{{scope.row.orderNumber}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="shipmentNumber" label="物流单号"  width="135px">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.shipmentNumber">
		    			<span>{{scope.row.shipmentNumber}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="contractNumber" label="合同号" width="90px">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.contractNumber">
		    			<span>{{scope.row.contractNumber}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="plateNumber" label="车牌" width="90px">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.plateNumber">
		    			<span>{{scope.row.plateNumber}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <!--<el-table-column prop="outchanCode" label="通道">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.outchanCode">
		    			<span>{{scope.row.outchanCode}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>-->
		    <!--<el-table-column prop="forwardUnit" label="发货单位">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.forwardUnit">
		    			<span>{{scope.row.forwardUnit}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>-->
		    <el-table-column prop="purchaseUnit" label="购货单位" min-width="140">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.purchaseUnit">
		    			<span>{{scope.row.purchaseUnit}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="outboundWare" label="出库仓库" min-width="140">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.outboundWare">
		    			<span>{{scope.row.outboundWare}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		     <el-table-column prop="arrivalWare" label="到货仓库" min-width="200">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.arrivalWare">
		    			<span>{{scope.row.arrivalWare}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="carrierUnit" label="承运单位" min-width="180">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.carrierUnit">
		    			<span>{{scope.row.carrierUnit}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <!--<el-table-column prop="deliveryDate" label="发货日期">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.deliveryDate">
		    			<span>{{ _dateFormat({date:scope.row.deliveryDate,type:"YYYY-MM-DD"})}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>-->
		    <el-table-column prop="status" label="状态" width="80px">
		    	<template slot-scope="scope">
		    		<toolTip :content="_dicValue(scope.row.status, orderstatusOption)">
		    			<tagItem v-if="scope.row.status==0" type="info" :text="_dicValue(scope.row.status, orderstatusOption)"></tagItem>
		    			<tagItem v-if="scope.row.status==1" :text="_dicValue(scope.row.status, orderstatusOption)"></tagItem>
		    			<tagItem v-if="scope.row.status==2" type="warning" :text="_dicValue(scope.row.status, orderstatusOption)"></tagItem>
		    			<tagItem v-if="scope.row.status==3" type="success" :text="_dicValue(scope.row.status, orderstatusOption)"></tagItem>
		    	     </toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="orignMethod" label="单据来源"width="90px">
		    	<template slot-scope="scope">
		    		<toolTip :content="_dicValue(scope.row.orignMethod, orignMethodoptions)">
		    			<tagItem v-if="scope.row.orignMethod==1" :text="_dicValue(scope.row.orignMethod, orignMethodoptions)"></tagItem>
		    			<tagItem v-if="scope.row.orignMethod==2" type="success" :text="_dicValue(scope.row.orignMethod, orignMethodoptions)"></tagItem>
		    	     </toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column label="操作" width="160" fixed="right">
		    	<template slot-scope="scope">
		    		<el-button-group>
		    			<iconBtn iconClass="el-icon-check" style="padding:5px 10px" content="生成出库单" v-if="scope.row.status==0" @click="updateoutorderstatus(scope.row)" ></iconBtn> 
		    			<iconBtn iconClass="el-icon-edit" style="padding:5px 10px" content="编辑" v-if="scope.row.status==0" @click="modalEdit(scope.row)" ></iconBtn>    
					    <iconBtn iconClass="el-icon-minus" style="padding:5px 10px" content="删除" v-if="scope.row.status==0" @click="delRow(scope.row)" ></iconBtn>
					    <iconBtn iconClass="el-icon-view" style="padding:5px 10px" content="查看" @click="searchoutmainorder(scope.row)" ></iconBtn> 
		    		</el-button-group>		    		
		    	</template>
		    </el-table-column>
		</elemTable>
	</div>
</template>

<script>
	import mixin from '../../mixin/mixin.js'
	import local from '../../local.js'
	export default {
		mixins: [mixin],
		data() {
			return {
				orignMethodoptions:[],
				orderstatusOption:[],
				searchForm: {
					orignMethod:'',
					orderNumber:'',
					plateNumber:'',
					status:'',
					deliveryDate:'',
					reservationDate:'',
					isDelete:0,
				},
				fahuotimeshow:false,
				upbuttonshow:false,
				downbuttonshow:true,
				thisUser: local.get('userinfo'),
			}
		},
		mounted() {
			this.getorderstatus()
		},
		methods: {
			getorignMethod(){
				return this._searchDic("ORIGNMETHOD").then(
			        function(d) {
			          this.orignMethodoptions = this._dicKey(d);
					  this.searchTable()
			        }.bind(this)
			      );
			},
			searchoutmainorder(row){
				this.$router.push({path:"/deliversearch",query: {id: row.id}});
			},
			/**
			 * 生成出库单
			 * 		修改出库单状态  （草稿->已确认)
			 */
			updateoutorderstatus(row){
				this.confirm(
		        "确认生成出库单？",
		        function() {
		          this._ajax({
		            url: this.rootAPI + "outmainorder/updatemainorder",
		            param: row,
		            arr: true
		          }).then(
		            function(d) {
		              if (d.state == 0) {
		                	this.$message({ type: "success", message: "已确认" });
		              } else {
		              	if (d.state == 2){
		                	this.$message({ type: "warning", message: d.msg });
		                }else{
		                	this.$message({ type: "warning", message: "生成失败" });
		                }
		              }
		              this.handleCurrentChange(1);
		            }.bind(this)
		          );
		        }.bind(this)
		      );
			},
			getorderstatus(){
				return this._searchDic("OUTMAINORDER_STATUS").then(
			        function(d) {
			          this.orderstatusOption = this._dicKey(d);
					  this.getorignMethod()
			        }.bind(this)
			      );
			},
			clickdown(){
				this.downbuttonshow = false
				this.upbuttonshow = true
				this.fahuotimeshow=true
			},
			clickup(){
				this.downbuttonshow = true
				this.upbuttonshow = false
				this.fahuotimeshow=false
			},
			searchTable() {
				Object.assign(this.searchForm, {
					pageNum: this.pageNum, 
					pageSize: this.pageSize
				})
				return this._ajax({
			        url: this.rootAPI,
			        name: "outmainorder/list",
			        param: this.searchForm,
			        loading: "dataLoading"
			    }).then(this.renderTable);
			},
			modalEdit(row){
				this.$router.push({path:"/deliveredit",query: {id: row.id}});
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
		    	if(row.orignMethod==1){
		  			this.$message({
		                type: "warning",
		                message: "物流系统数据 不能删除该出库单" 
		              });
			        return;
		  		}
		      	var o = {
		        	id: [row.id]
		      	};
		     	this.confirm(
		        	"确定删除？",
		        	function() {
		          		this._ajax({
				            url: this.rootAPI + "outmainorder/deleteoutmainorder",
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
//		    delsubmit(o) {
//		      
//		    },
			reset(){
				var vm = this;
				vm.searchForm = {
					orignMethod:'',
					orderNumber:'',
					plateNumber:'',
					status:'',
					deliveryDate:'',
					reservationDate:'',
					isDelete:0,
				}
				this.handleCurrentChange(1);
			},
			add(){
				this.$router.push({path:"/deliveradd"});
			},
		}
	}
</script>

<style>
</style>