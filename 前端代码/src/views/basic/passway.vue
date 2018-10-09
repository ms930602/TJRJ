<template>
	<div>
		<el-form ref="searchForm" :model="searchForm"  >
			<!-- 查询条件 -->
			<searchInputItems>
				<searchInputItem name="通道编号">
					<inputItem :value.sync="searchForm.passNo" ></inputItem>
					</searchInputItem>
				<searchInputItem name="通道名">
					<inputItem :value.sync="searchForm.passName" ></inputItem>
				</searchInputItem>
				<searchInputItem name="通道类型" >
						<selectInput :value.sync="searchForm.passTypeNo" :clearable="true">
								<el-option
									v-for="item in passTypeNooptions"
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
					<iconBtn iconClass="el-icon-minus" content="删除" @click="batchdelete">删除</iconBtn>
					<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
					<iconBtn iconClass="el-icon-refresh" content="重置" @click="reset">重置</iconBtn>
				</el-button-group>				
			</template>
		</optionItems>
		<elemTable :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange" @selectionChange="selectionChange">
			<el-table-column type="selection" width="55"></el-table-column>
		    <el-table-column prop="passNo" label="通道编号">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.passNo">
		    			<span>{{scope.row.passNo}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="passName" label="通道名称">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.passName">
		    			<span>{{scope.row.passName}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="passTypeNo" label="通道类型">
		    	<template slot-scope="scope">
					 <toolTip :content="_dicValue(scope.row.passTypeNo, passTypeNooptions)">
		    			<span>{{_dicValue(scope.row.passTypeNo, passTypeNooptions)}}</span>
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
		    <el-table-column prop="createdDate" label="创建时间">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.createdDate">
		    			<span>{{scope.row.createdDate}}</span>
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
        <passmodal  v-if="modalShow" :modaltype="modalType" :passTypeNooptions="passTypeNooptions" @close="modalClose" :modalshow='modalShow' @submit="modalSubmit" :tableRow='modalObj'></passmodal>
	</div>
</template>

<script>
import mixin from "../../mixin/mixin.js";
import local from "../../local.js";
import passmodal from "../component/modal/passwayModal.vue";
export default {
  mixins: [mixin],
  components: { passmodal },
  data() {
    return {
      passTypeNooptions: [],
      searchForm: {
        passNo: "",
        passName: "",
        passTypeNo: ""
      }
    };
  },
  mounted() {
    this.getpassTypeNo().then(
      (d => {
        this.searchTable();
      }).bind(this)
    );
  },
  methods: {
    /**
     * 获取通道类型
     */
    getpassTypeNo() {
      return this._searchDic("PSSWAY_TYPE").then(
        function(d) {
          this.passTypeNooptions = this._dicKey(d);
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
        name: "passway/list",
        param: this.searchForm,
        loading: "dataLoading"
      }).then(this.renderTable);
    },
    reset() {
      Object.assign(this.searchForm, {
        passNo: "",
        passName: "",
        passTypeNo: ""
      });
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
            url: this.rootAPI + "passway/delete",
            param: o,
            arr: true
          }).then(
            function(d) {
              if (d.state == 0) {
                this.$message({ type: "success", message: "删除成功" });
              } else {
                this.$message({ type: "warning", message: "删除失败："+d.msg });
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
