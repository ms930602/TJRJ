<template>
<!--单号编码规则-->
	<div>
		<searchInputItems>
			<searchInputItem name="单号日期">
				<inputItem :value.sync="searchForm.date"></inputItem>
			</searchInputItem>
			<searchInputItem name="单号类型">
				<inputItem :value.sync="searchForm.type"></inputItem>
			</searchInputItem>
		</searchInputItems>	
        <optionItems>
			<template slot="left">
				<el-button-group>
					<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
					<iconBtn iconClass="el-icon-refresh" content="重置" @click="reset">重置</iconBtn>
				</el-button-group>				
			</template>
		</optionItems>
		<elemTable :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange" @selectionChange="selectionChange">
			<el-table-column type="selection" width="55"></el-table-column>>
		    <el-table-column prop="id" label="单号规则Id">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.id">
		    			<span>{{scope.row.id}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="type" label="单号类型">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.type">
		    			<span>{{scope.row.type}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="prefix" label="单号前缀">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.prefix">
		    			<span>{{scope.row.prefix}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
			<el-table-column prop="separator" label="单号分隔符">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.separator">
		    			<span>{{scope.row.separator}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
			<el-table-column prop="date" label="单号日期规则">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.date">
		    			<span>{{scope.row.date}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
			<el-table-column prop="serialDigits" label="序列号位数">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.serialDigits">
		    			<span>{{scope.row.serialDigits}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
			<el-table-column prop="serial" label="序列号">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.serial">
		    			<span>{{scope.row.serial}}</span>
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
  components: {},
  data() {
    return {
      searchForm: {
        date: "",
        type: ""
      }
    };
  },
  mounted() {
    this.searchTable();
  },
  methods: {
    reset() {
      Object.assign(this.searchForm, {
        date: "",
        type: ""
	  });
	  this.handleCurrentChange(1)
    },
    //查询表格，初次加载数据
    searchTable() {
      Object.assign(this.searchForm, {
        pageNum: this.pageNum,
        pageSize: this.pageSize
      });
      return this._ajax({
        url: this.rootAPI,
        name: "numcoderules/list",
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
    }
  }
};
</script>