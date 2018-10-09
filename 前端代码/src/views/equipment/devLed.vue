<template>
	<div>
		<el-form ref="searchForm" :model="searchForm"  >
			<!-- 查询条件 -->
	<searchInputItems>
				<searchInputItem name="品牌">
					<inputItem :value.sync="searchForm.brand" ></inputItem>
				</searchInputItem>

				<searchInputItem name="型号">
					<inputItem :value.sync="searchForm.spec" ></inputItem>
				</searchInputItem>

				<searchInputItem name="厂家">
					<inputItem :value.sync="searchForm.factory" ></inputItem>
				</searchInputItem>

        </searchInputItems>

		</el-form>	
        <optionItems>
			<template slot="left">
				<el-button-group>
					<iconBtn iconClass="el-icon-plus" content="新增" @click="add">新增</iconBtn>
					<iconBtn iconClass="el-icon-minus" content="删除" @click="batchdelete">删除</iconBtn>
					<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
					<iconBtn iconClass="el-icon-refresh" content="重置" @click="reset">重置</iconBtn>
				</el-button-group>				
			</template>
		</optionItems>

  <elemTable :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange" @selectionChange="selectionChange">
			<el-table-column type="selection" width="55"></el-table-column>
		    <el-table-column prop="id" label="编号">
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
		    			<iconBtn iconClass="el-icon-edit" content="编辑" @click="modalEdit(scope.row)"></iconBtn>    
					    <iconBtn iconClass="el-icon-minus" content="删除" @click="deleterow(scope.row)" ></iconBtn>
		    		</el-button-group>		    		
		    	</template>
		    </el-table-column>
		</elemTable>
        <devLedModel  v-if="modalShow" :modaltype="modalType" @close="modalClose" :modalshow='modalShow' @submit="modalSubmit" :tableRow='modalObj'></devLedModel>
	</div>
</template>

<script>
import mixin from "../../mixin/mixin.js";
import local from "../../local.js";
import devLedModel from "../component/modal/devLedModel.vue";
export default {
  mixins: [mixin],
  components: { devLedModel },
  data() {
    return {
      searchForm: {
					brand: '',
					spec: '',
					factory:''

      }
    };
  },
  mounted() {
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
	    name: 'devLed/list', 
        param: this.searchForm,
        loading: "dataLoading"
      }).then(this.renderTable);
    },
    reset() {
				Object.assign(this.searchForm, {
					brand:'',
					spec:'',
					factory:''
				})
				this.handleCurrentChange(1)
    },
    add() {
      this.modalType = "add";
      this.modalShow = true;
      this.modalObj = {};
    },
    modalEdit(row) {
      this.modalType = "edit";
      this.modalShow = true;
      this.modalObj = row;
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
            url: this.rootAPI + "devLed/delete",
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
    }
  }
};
</script>
       
