<template>
	<el-dialog custom-class="jz-modal" title="物料信息" :visible="modalShowlocal"  :before-close="beforeClose" :width="modalWidth" :close-on-click-modal="false">
	<el-form ref="searchForm" :model="searchForm"  >
		<!-- 查询条件 -->
		<searchInputItems>
			<searchInputItem name="物料名称">
				<inputItem :value.sync="searchForm.materName" ></inputItem>
			</searchInputItem>
			<searchInputItem name="卷烟类型">
				<selectInput :value.sync="searchForm.cigtype" @selectChange="searchTable" :clearable="true">
					<el-option
				      v-for="item in types"
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
				<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
				<iconBtn iconClass="el-icon-refresh" content="重置" @click="reset">重置</iconBtn>
			</el-button-group>				
		</template>
	</optionItems>
		<elemTable :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange" @selectionChange="selectionChange">
		<el-table-column type="selection" width="55"></el-table-column>
		    <el-table-column prop="localCode" label="货位">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.localCode">
		    			<span>{{scope.row.localCode}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="descript" label="货位描述">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.descript">
		    			<span>{{scope.row.descript}}</span>
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
		    <el-table-column prop="materVersion" label="物料版本">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.materVersion">
		    			<span>{{scope.row.materVersion}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="materCigbrand" label="物料品牌">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.materCigbrand">
		    			<span>{{scope.row.materCigbrand}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="trayCode" label="托盘编码">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.trayCode">
		    			<span>{{scope.row.trayCode}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="cigtype" label="卷烟类型">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.cigtype">
		    			<span>{{_dicValue(scope.row.cigtype,types)}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		</elemTable>
		<div slot="footer" class="dialog-footer">
		    <el-button @click="cancel">取 消</el-button>
		    <el-button type="primary" @click="save">确 定</el-button>
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
				materName:'',
				cigtype:''
			},
			types:[],
			materCodeOptions:[],
			modalWidth:'80%',
		}
	},
	props: {
		floorCode:{
			default: null
		},
		localCodeNow: {
			default: null
		},
		modalShowlocal: {
			default: false
		},
		materCode: {
			default: null
		},
		srow: {
			default: []
		},
	},
	mounted(){
		if(this.localCodeNow){
			this.searchForm.floorAreaCode = this.localCodeNow;
		}else
		if(this.floorCode){
			this.searchForm.localCode = this.floorCode;
		}
		this.searchTable();	
		this._searchDic('MATERIAL_TYPE')
			.then((function(d) {
				this.types = this._dicKey(d)
			}).bind(this))
		//this.toggleSelection(this.srow);
	},
	methods:{
		searchTable(){
			Object.assign(this.searchForm, {
					pageNum: this.pageNum, 
					pageSize: this.pageSize
				})
				return this._ajax({
			        url: this.rootAPI,
			        name: "positionadjustmain/queryInventorytraylocalPage",
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
			Object.assign(this.searchForm, {
					materName: '',
					cigtype:''
				})
			this.searchTable()
		},
		save(){
			if (this.delSelection.length === 0) {
		        this.$message({ type: "info", message: "请选择行" });
		        return;
		    }
			let tableArr = this.delSelection
			this.$emit('selectList',tableArr)
			this.cancel()
		}
	},
}
</script>