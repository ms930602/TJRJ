<template>
	<div>
		<el-form ref="searchForm" :model="searchForm"  >
			<!-- 查询条件 -->
			<searchInputItems>
				<searchInputItem name="入库单号">
					<inputItem :value.sync="searchForm.orderNumber" ></inputItem>
					</searchInputItem>
				<searchInputItem name="物流单号">
					<inputItem :value.sync="searchForm.shipmentNumber" ></inputItem>
				</searchInputItem>
      </searchInputItems>
		</el-form>


		

        <optionItems>
			<template slot="left">
				<el-button-group>
					<iconBtn iconClass="el-icon-plus" content="新增"  @click="add">新增</iconBtn>
		<!--
					<iconBtn iconClass="el-icon-minus" content="删除" @click="batchdelete">删除</iconBtn>

		-->
					<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
					<iconBtn iconClass="el-icon-refresh" content="重置" @click="reset">重置</iconBtn>
				</el-button-group>				
			</template>
		</optionItems>

  <elemTable :dataList="dataList"   :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange" @selectionChange="selectionChange">
			<!--<el-table-column type="selection" width="55"></el-table-column>-->
		    <el-table-column prop="id" label="编号"  v-if="showid">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.id">
		    			<span>{{scope.row.id}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>

		    <el-table-column prop="orderNumber" fixed="left" label="入库单号" width="110px">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.orderNumber">
		    			<span>{{scope.row.orderNumber}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>


		    <el-table-column prop="shipmentNumber" label="物流单号" width="130px">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.shipmentNumber">
		    			<span>{{scope.row.shipmentNumber}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>



      <!--
			<el-table-column prop="shipmentDate" label="制单日期">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.shipmentDate">
		    			<span>{{scope.row.shipmentDate}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
			-->

			<el-table-column prop="contractNumber"  label="合同号" width="130px">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.contractNumber">
		    			<span>{{scope.row.contractNumber}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>

			<!--
						<el-table-column prop="contractDate" label="合同日期">
								<template slot-scope="scope">
									<toolTip :content="scope.row.contractDate">
										<span>{{scope.row.contractDate}}</span>
									</toolTip>
									</template>
							</el-table-column>
			-->


			<el-table-column prop="carrierUnit" label="承运单位" min-width="190px">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.carrierUnit">
		    			<span>{{scope.row.carrierUnit}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
<!--
		    <el-table-column prop="deliveryDate" label="发货日期">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.deliveryDate">
		    			<span>{{scope.row.deliveryDate}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
-->

<!--

		    <el-table-column prop="transportType" label="运输方式">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.transportType">
		    			<span>{{scope.row.transportType}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>

-->

			<el-table-column prop="carrier" label="承运人" width="80px">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.carrier">
		    			<span>{{scope.row.carrier}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>

			<el-table-column prop="phoneNumber" label="联系电话" width="100px">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.phoneNumber">
		    			<span>{{scope.row.phoneNumber}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>

		    <el-table-column prop="plateNumber" label="车牌号" width="90px">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.plateNumber">
		    			<span>{{scope.row.plateNumber}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>

<!--

			<el-table-column prop="carrierUnitCode" label="承运单位编码">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.carrierUnitCode">
		    			<span>{{scope.row.carrierUnitCode}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
-->
       <!--
			<el-table-column prop="reservationDate" label="预约装车日期">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.reservationDate">
		    			<span>{{scope.row.reservationDate}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
      -->


               
                      

<!--

			<el-table-column prop="originWarehouseCode" label="移出仓库编码">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.originWarehouseCode">
		    			<span>{{scope.row.originWarehouseCode}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
				-->


			<el-table-column prop="originWarehouseName" min-width="190px" label="移出仓库名称">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.originWarehouseName">
		    			<span>{{scope.row.originWarehouseName}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>



<!--

			<el-table-column prop="intoWarehouseCode" label="移入仓库编码">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.intoWarehouseCode">
		    			<span>{{scope.row.intoWarehouseCode}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
-->

			
			<el-table-column prop="intoWarehouseName" min-width="190px" label="移入仓库名称">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.intoWarehouseName">
		    			<span>{{scope.row.intoWarehouseName}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>




		    <el-table-column prop="orignMethod" label="单据来源" width="90px">
		    	<template slot-scope="scope">
		    		<tagItem :text="_dicValue(scope.row.orignMethod, orignMethods)"></tagItem>
		      	</template>
		    </el-table-column>



<!--
				<el-table-column prop="totalQuality" label="总量（件）">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.totalQuality">
		    			<span>{{scope.row.totalQuality}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
-->
		    <el-table-column prop="status" label="状态" width="90px">
		    	<template slot-scope="scope">
		    		<tagItem :text="_dicValue(scope.row.status, warehousingStatus)"></tagItem>
		      	</template>
		    </el-table-column>


<!--

			<el-table-column prop="shipmentRemark" label="物流单备注">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.shipmentRemark">
		    			<span>{{scope.row.shipmentRemark}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>


			<el-table-column prop="entryCompliteDate" label="入库完成时间">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.entryCompliteDate">
		    			<span>{{scope.row.entryCompliteDate}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>



				<el-table-column prop="entryChannelCode" label="入库通道编号">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.entryChannelCode">
		    			<span>{{scope.row.entryChannelCode}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>





			<el-table-column prop="deliveryRequire" label="发货要求">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.deliveryRequire">
		    			<span>{{scope.row.deliveryRequire}}</span>
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


			<el-table-column prop="createdDate" label="创建时间">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.createdDate">
		    			<span>{{scope.row.createdDate}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>



			<el-table-column prop="createdPersonId" label="创建人id">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.createdPersonId">
		    			<span>{{scope.row.createdPersonId}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>



			<el-table-column prop="createdPersonId" label="创建人">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.createdPersonId">
		    			<span>{{scope.row.createdPersonId}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>

						<el-table-column prop="updatedDate" label="更新时间">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.updatedDate">
		    			<span>{{scope.row.updatedDate}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>


						<el-table-column prop="updatedPersonId" label="更新人id">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.updatedPersonId">
		    			<span>{{scope.row.updatedPersonId}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>


			
						<el-table-column prop="updatedPerson" label="修改人">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.updatedPerson">
		    			<span>{{scope.row.updatedPerson}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>

			-->




		    <el-table-column fixed="right" label="操作" width = "155px">
		    	<template slot-scope="scope">
		    		<el-button-group>
					    <iconBtn iconClass="el-icon-check" style="padding:5px 10px" content="确认"  v-if="scope.row.status==0" @click="confirms(scope.row)" ></iconBtn>
							<iconBtn iconClass="el-icon-view"  style="padding:5px 10px" content="查看详情"  @click="details(scope.row)" ></iconBtn>
		    			<iconBtn iconClass="el-icon-edit"  style="padding:5px 10px" content="编辑"  v-if="scope.row.status==0" @click="modalEdit(scope.row)"></iconBtn>    
					    <iconBtn iconClass="el-icon-minus" style="padding:5px 10px" content="删除" v-if="scope.row.status==0" @click="deleterow(scope.row)" ></iconBtn>
		    		</el-button-group>		    		
		    	</template>
		    </el-table-column>
		</elemTable>
	</div>
</template>

<script>
import mixin from "../../mixin/mixin.js";
import local from "../../local.js";

export default {
  mixins: [mixin],
  data() {
    return {
      // passTypeNooptions: [],
      searchForm: {
        orderNumber: "",
        shipmentNumber: "",
        isDelete: 0
      },

      warehousingStatus: [],
      orignMethods: [],

      showid: false
    };
  },
  mounted() {
    /*入库状态*/
    this._searchDic("WAREHOUSING_STATUS").then(
      function(d) {
        this.warehousingStatus = this._dicKey(d);
      }.bind(this)
    );

    /*订单来源*/
    this._searchDic("ORIGNMETHOD").then(
      function(d) {
        this.orignMethods = this._dicKey(d);
      }.bind(this)
    );

    this.searchTable();
  },
  methods: {
    searchTable() {
      Object.assign(this.searchForm, {
        pageNum: this.pageNum,
        pageSize: this.pageSize
      });
      return this._ajax({
        url: this.rootAPI,
        name: "entrymainorder/list",
        param: this.searchForm,
        loading: "dataLoading"
      }).then(this.renderTable);
    },
    reset() {
      Object.assign(this.searchForm, {
        orderNumber: "",
        shipmentNumber: ""
      });
      this.searchTable();
    },

    modalEdit(row) {
      //this.$router.push({path:"/updateinventory", params: { 'editobj': row }});
      this.$router.push({ path: "/updateinventory", query: { id: row.id } });
    },
    batchdelete() {
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
    deleterow(row) {
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
            url: this.rootAPI + "cigaretteEntry/deleteentrymainorder",
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
    confirms(row) {

      var param = { id: row.id, status: 1 ,plateNumber:row.plateNumber};

      this._ajax({
        url: this.rootAPI,
        name: "cigaretteEntry/queryDetailedBind",
        param: param
      }).then(
        (d => {
          if (d.state == 0) {
            this.$message({ type: "success", message: "保存成功" });
            this.searchTable();
          } else {
            this.$message({
              type: "warning",
              message: d.msg 
            });
          }
        }).bind(this)
      );  
    },

    details(row) {
      this.$router.push({ path: "/entrydetails", query: { id: row.id } });
    },
		add(){
				this.$router.push({path:"/addinventory"});  		
		},
  }
};
</script>
