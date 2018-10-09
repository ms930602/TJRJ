<template>
	<div>
		<el-form ref="searchForm" :model="searchForm"  >
			<!-- 查询条件 -->
			<searchInputItems>
				<searchInputItem name="批次号">
					<inputItem :value.sync="searchForm.batchNo" ></inputItem>
				</searchInputItem>
      </searchInputItems>

		</el-form>	
        <optionItems>
			<template slot="left">
				<el-button-group>
					<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
					<iconBtn iconClass="el-icon-refresh" content="重置" @click="reset">重置</iconBtn>
				</el-button-group>				
			</template>
		</optionItems>

  <elemTable :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange" @selectionChange="selectionChange">
			<el-table-column type="selection" width="55"></el-table-column>
		    <el-table-column prop="materCode" label="编号">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.materCode">
		    			<span>{{scope.row.materCode}}</span>
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
		    <el-table-column prop="isShortage" label="是否短缺">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.isShortage">
		    			<span v-if="scope.row.isShortage =='是'" style="color: red">{{scope.row.isShortage}}</span>
							 <span v-else style="color: blue">{{scope.row.isShortage}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="isOverstock" label="是否超储">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.isOverstock">
		    			<span v-if="scope.row.isOverstock =='是'" style="color: red">{{scope.row.isOverstock}}</span>
							<span v-else style="color: blue">{{scope.row.isOverstock}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
						    <el-table-column prop="isBeyond" label="是否呆滞">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.isBeyond">
		    			<span v-if="scope.row.isBeyond =='是'" style="color: red">{{scope.row.isBeyond}}</span>
							<span v-else style="color: blue">{{scope.row.isBeyond}}</span>
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
		    <el-table-column prop="entryDate" label="入库时间">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.entryDate">
		    			<span>{{scope.row.entryDate}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>

		    <el-table-column prop="inventQuality" label="库存数量">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.inventQuality">
		    			<span>{{scope.row.inventQuality}}</span>
		    		</toolTip>
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
			warningTypeCollen:[],
      searchForm: {
        brand: "",
				serialNum: ""
      }
    };
  },
  mounted() {
				this.searchTable();
				this.getupdown();
  },
  methods: {
			/**
			 * 预警状态
			 */
			getupdown(){
				return this._searchDic("WARNINGTYPE").then(
			        function(d) {
			          this.warningTypeCollen = this._dicKey(d);
			        }.bind(this)
			      );
			},
    searchTable() {
      Object.assign(this.searchForm, {
        pageNum: this.pageNum,
        pageSize: this.pageSize
      });
      return this._ajax({
        url: this.rootAPI,
        name: "wareStockwarning/list",
        param: this.searchForm,
        loading: "dataLoading"
      }).then(this.renderTable);
    },
    reset() {
      Object.assign(this.searchForm, {
        materId: "",
				batchNo: ""
			});
    this.handleCurrentChange(1);
    }
  }
};
</script>
