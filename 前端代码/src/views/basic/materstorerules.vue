<template>
<!--物料存放规则-->
	<div>
		<searchInputItems>
			<searchInputItem name="物料编号">
				<inputItem :value.sync="searchForm.materCode"></inputItem>
			</searchInputItem>
			<searchInputItem name="物料名称">
				<inputItem :value.sync="searchForm.materName"></inputItem>
			</searchInputItem>
		</searchInputItems>
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
		    <el-table-column prop="id" label="规则Id">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.id">
		    			<span>{{scope.row.id}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="materId" label="物料Id">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.materId">
		    			<span>{{scope.row.materId}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="materCode" label="物料编号">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.materCode">
		    			<span>{{scope.row.materCode}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="materName" label="物料名称">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.materName">
		    			<span>{{scope.row.materName}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
			<el-table-column prop="deadline" label="物料存储期限[天]">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.deadline">
		    			<span>{{scope.row.deadline}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
			<el-table-column prop="minStock" label="最低存库[件]">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.minStock">
		    			<span>{{scope.row.minStock}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
			<el-table-column prop="maxStock" label="最高存库[件]">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.maxStock">
		    			<span>{{scope.row.maxStock}}</span>
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
        <el-table-column prop="isDefault" label="是否默认规则">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.isDefault">
		    			<span>{{scope.row.isDefault=='0'?'否':'是'}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column label="操作">
		    	<template slot-scope="scope">
		    		<el-button-group>
						<iconBtn iconClass="el-icon-edit" content="编辑" @click="modalEdit(scope.row)"></iconBtn>    
					    <iconBtn iconClass="el-icon-minus" content="删除" @click="deleterow(scope.row)" ></iconBtn>
		    		</el-button-group>		    		
		    	</template>
		    </el-table-column>
		</elemTable>
		 <materstorerulesModal  v-if="modalShow" :modaltype="modalType"  @close="modalClose" :modalshow='modalShow' @submit="modalSubmit" :tableRow='modalObj'></materstorerulesModal>
	</div>
</template>
<script>
import mixin from "../../mixin/mixin.js";
import local from "../../local.js";
import materstorerulesModal from "../component/modal/materstorerulesModal.vue";
export default {
  mixins: [mixin],
  components: { materstorerulesModal },
  data() {
    return {
      searchForm: {
        floorId: "",
        areaCode: ""
      },
    };
  },
  mounted() {
    this.searchTable();
  },
  methods: {
    //校验参数
    checkparam() {
      var vm = this;
      var deadline = vm.form.deadline;
      if (Number(deadline) < 0) {
        this.$message.error("物料存储期限不能小于0");
        vm.form.deadline = null;
        return;
      }
      //校验物料id是否是int类型值
      var dataId = vm.form.materId;
      if (dataId == "" || dataId == null) {
        this.$message.error("物料id只能为数字类型");
        vm.form.materId = null;
        return;
      }
      if (isNaN(dataId)) {
        this.$message.error("物料id只能为数字类型");
        vm.form.materId = null;
        return;
      }
	},
	reset() {
      Object.assign(this.searchForm, {
      	materCode: "",
        materName: ""
	  });
	 this.handleCurrentChange(1)
    },
    add() {
      this.modalType = "add";
      this.modalShow = true;
      this.modalObj = {};
    },
    //检查物料编码是否存在
    checkmaterCode() {
      var vm = this;
      return vm
        ._ajax({
          url: vm.rootAPI,
          name: "materstorerules/checkMaterCode",
          param: { materCode: vm.form.materCode }
        })
        .then(d => {
          if (d.aaData.length != 0) {
            if ((vm.dialogtitle = "新增物料存放规则")) {
              if (vm.yanzareaCode != vm.form.materCode) {
                vm.$message({ type: "info", message: "编码重复请重新输入" });
                vm.form.materCode = null;
                return;
              }
            } else {
              vm.$message({ type: "info", message: "编码重复请重新输入" });
              vm.form.floorCode = null;
              return;
            }
          }
        });
    },
    //查询表格，初次加载数据
    searchTable() {
      Object.assign(this.searchForm, {
        pageNum: this.pageNum,
        pageSize: this.pageSize
      });
      return this._ajax({
        url: this.rootAPI,
        name: "materstorerules/list",
        param: this.searchForm,
        loading: "dataLoading"
      }).then(this.renderTable);
    },
    handleSizeChange(val) {
      this.pageSize = val;
      this.searchTable();
    },
    handleCurrentChange(val) {
      this.pageNum = val;
      this.searchTable();
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
            url: this.rootAPI + "materstorerules/delete",
            param: o,
            arr: true
          }).then(
            function(d) {
              if (d.state == 0) {
                this.$message({ type: "success", message: "删除成功" });
              } else {
                this.$message({ type: "warning", message: "删除失败"+d.msg });
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

<style>
</style>