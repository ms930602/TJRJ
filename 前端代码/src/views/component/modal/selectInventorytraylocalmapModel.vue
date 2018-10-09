<template>
	<el-dialog custom-class="jz-modal" title="调整出库货位" :visible="modalShowlocal"  :before-close="beforeClose" :width="modalWidth" :close-on-click-modal="false">
		<el-form ref="searchForm" :model="searchForm" label-width="80px"  :inline="true" class="demo-form-inline" >
		  <!-- 查询条件 -->
			<searchInputItems>
				<searchInputItem name="货位">
					<inputItem :value.sync="searchForm.localCode" :maxlength="40"></inputItem>
				</searchInputItem>
				<el-button-group style="float: right;">
					<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
					<iconBtn iconClass="el-icon-refresh" content="重置" @click="reset">重置</iconBtn>
				</el-button-group>
			</searchInputItems>
			
		</el-form>	
		<elemTable :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange">
		    <el-table-column prop="localCode" label="货位">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.localCode">
		    			<span>{{scope.row.localCode}}</span>
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
		    <el-table-column prop="batchNo" label="批次号">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.batchNo">
		    			<span>{{scope.row.batchNo}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="produceDate" label="生产日期">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.produceDate">
		    			<span>{{scope.row.produceDate}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="quality" label="数量">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.quality">
		    			<span>{{scope.row.quality}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <!--<el-table-column prop="status" label="状态">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.status">
		    			<span>{{scope.row.status}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>-->
		    <el-table-column prop="totalCount" label="选择">
		    	<template slot-scope="scope">
		    		<el-button-group>
					    <iconBtn iconClass="el-icon-edit-outline" content="选择替换" @click="selectreplace(scope.row)" ></iconBtn>  
		    		</el-button-group>		    		
		    	</template>
		    </el-table-column>
		</elemTable>
		<div slot="footer" class="dialog-footer">
		    <el-button @click="cancel">取 消</el-button>
		    <!--<el-button type="primary" @click="save">确 定</el-button>-->
		</div>
	</el-dialog>
</template>

<script>
import mixin from '../../../mixin/mixin.js'
import local from '../../../local.js'
import configs from "../../../configs.js";
export default {
	mixins: [mixin],
	data(){
		return{
			searchForm:{
				materCode:this.materCode,
				materVersion:'',
				materCigbrand:'',
				status:0,
				localCode:'',
			},
			materCodeOptions:[],
			modalWidth:'60%',
		}
	},
	props: {
		modalShowlocal: {
			default: false
		},
		materCode: {
			default: null
		},
	},
	mounted(){
		this.searchTable();	
	},
	methods:{
		searchTable(){
			Object.assign(this.searchForm, {
					pageNum: this.pageNum, 
					pageSize: this.pageSize
				})
				return this._ajax({
			        url: this.rootAPI,
			        name: "inventorytraylocalmap/list",
			        param: this.searchForm,
			        loading: "dataLoading"
			    }).then(this.renderTable);
		},
		cancel(){
			this.$emit('close')
		},
		beforeClose(done) {
			this.cancel()
			done()
		},
		reset(){
			this.searchForm={
				materCode:this.materCode,
				materVersion:'',
				materCigbrand:'',
				status:0,
				localCode:'',
			},
			this.searchTable()
		},
		selectreplace(row){
			this.$emit('selectreplace',row)
			this.cancel()
		}
	},
}
</script>