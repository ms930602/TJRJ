<template>
	<el-dialog custom-class="jz-modal" title="物料选择" :visible="modalshow"  :before-close="beforeClose" :width="modalWidth" :close-on-click-modal="false">
		<el-form ref="searchForm" :model="searchForm" label-width="80px"  :inline="true" class="demo-form-inline" >
		  <!-- 查询条件 -->
			<searchInputItems>



			<!--
				<searchInputItem name="物料名称" >
						<selectInput :value.sync="searchForm.materCode" filterable :clearable="true">
								<el-option
									v-for="item in materCodeOptions"
									:key="item.key"
									:label="item.label"
									:value="item.value">
								</el-option>
						</selectInput>
				</searchInputItem>
				<searchInputItem name="物料版本">
					<inputItem :value.sync="searchForm.versioncode" :maxlength="10"></inputItem>
				</searchInputItem>

		 -->
				<searchInputItem name="物料编码/名称">
					<inputItem :value.sync="searchForm.materCode" :maxlength="25"></inputItem>
				</searchInputItem>

			<searchInputItem name="卷烟类型">
				<selectInput :value.sync="searchForm.cigtype" :maxlength="10">
					<el-option
				      v-for="item in cigtypes"
				      :key="item.key"
				      :label="item.value"
				      :value="item.key">
				    </el-option>
				</selectInput>
			</searchInputItem>


				<el-button-group style="margin-left: 20px;">
					<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
					<iconBtn iconClass="el-icon-refresh" content="重置" @click="reset">重置</iconBtn>
				</el-button-group>
			</searchInputItems>
			
		</el-form>	
		<elemTable ref="multipleTable" :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange" @selectionChange="selectionChange">
			<el-table-column type="selection" width="55"></el-table-column>
		    <el-table-column prop="materCode" label="物料编码">
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
		    <el-table-column prop="versioncode" label="物料版本">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.versioncode">
		    			<span>{{scope.row.versioncode}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="cigBrandName" label="卷烟品牌">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.cigBrandName">
		    			<span>{{scope.row.cigBrandName}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>

		    <el-table-column prop="subverName" label="子版本">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.subverName">
		    			<span>{{scope.row.subverName}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>


			<el-table-column prop="subId" label="子版本id" v-if="showid">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.subId">
		    			<span>{{scope.row.subId}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>



		    <el-table-column prop="cigtype" label="卷烟类型">
	
				<template slot-scope="scope">
		    		<tagItem :text="_dicValue(scope.row.cigtype, cigtypes)"></tagItem>
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
				materCode:'',
				cigtype:'0',
				mainorderId:null,
			},
			materCodeOptions:[],
			modalWidth:'80%',

			cigtypes :[],
			showid:false,
		}
	},
	props: {
		modalshow: {
			default: false
		},
		srow: {
			default: []
		},
		mainorderId: {
			default: null
		},
	},
	mounted(){

		/*卷烟类型*/
		 	this._searchDic('MATERIAL_TYPE')
			.then((function(d) {
				this.cigtypes = this._dicKey(d)
			}).bind(this))
		this.getmaterinfo()
		this.searchTable();	
		this.toggleSelection(this.srow)
	},
	methods:{
		toggleSelection(rows) {
			console.log(rows);
	        if (rows) {
	          rows.forEach(row => {
		          	this.$nextTick((row) =>{
							this.$refs.multipleTable.$refs.multipleTable.toggleRowSelection(row);
						})
	          });
	        } else {
	        	this.$nextTick(() =>{
							this.$refs.multipleTable.$refs.multipleTable.clearSelection();
				})
	        }
	     },
		getmaterinfo(){
			var vm = this
					vm.materCodeOptions = []
					return vm._ajax({
						url: vm.rootAPI, 
						name: 'materialinfo/queryAlllist', 
						param: {}, 
						}).then((d) => {
							console.log(d)
							if(d.state === 0){
								var aaData = d.aaData
								aaData.forEach(function(el) {
									vm.materCodeOptions.push({
										value: el.materCode,
		      							label: el.materName
									})
								})	
							}
		        		}, (d) => {
		                    this.$message.error('物料获取失败');
		                })
		},
		searchTable(){
  
					debugger;

			this.searchForm.mainorderId = this.mainorderId;
			Object.assign(this.searchForm, {
					pageNum: this.pageNum, 
					pageSize: this.pageSize
				})
				return this._ajax({
			        url: this.rootAPI,
			        name: "cigaretteEntry/materielList",
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
				materCode:'',
				versioncode:'',
			},
			this.searchTable()
		},
		save(){
			if (this.delSelection.length === 0) {
		        this.$message({ type: "info", message: "请选择行" });
		    }
			let tableArr = this.delSelection
			this.$emit('selectList',tableArr)
			this.cancel()
		}
	},
}
</script>