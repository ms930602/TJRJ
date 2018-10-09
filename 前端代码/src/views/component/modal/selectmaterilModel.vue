<template>
	<el-dialog custom-class="jz-modal" title="卷烟选择" :visible="modalshow"  :before-close="beforeClose" :width="modalWidth" :close-on-click-modal="false">
		<el-form ref="searchForm" :model="searchForm" label-width="80px"  :inline="true" class="demo-form-inline" >
		  <!-- 查询条件 -->
			<searchInputItems>
				<searchInputItem name="卷烟类型" >
						<selectInput :value.sync="searchForm.cigtype">
								<el-option 
								      v-for="item in cigtypeOptions"
								      :key="item.key"
								      :label="item.value"
								      :value="item.key">
								    </el-option>
						</selectInput>
				</searchInputItem>
				<searchInputItem name="卷烟名称" >
					<inputItem :value.sync="searchForm.materName" :maxlength="40"></inputItem>
						<!--<selectInput :value.sync="searchForm.materCode" filterable :clearable="true">
								<el-option
									v-for="item in materCodeOptions"
									:key="item.key"
									:label="item.label+item.value"
									:value="item.value">
								</el-option>
						</selectInput>-->
				</searchInputItem>
				<!--<searchInputItem name="物料版本">
					<inputItem :value.sync="searchForm.materVersion" :maxlength="10"></inputItem>
				</searchInputItem>
				<searchInputItem name="物料品牌">
					<inputItem :value.sync="searchForm.materCigbrand" :maxlength="40"></inputItem>
				</searchInputItem>-->
				<el-button-group style="margin-left: 20px;">
					<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
					<iconBtn iconClass="el-icon-refresh" content="重置" @click="reset">重置</iconBtn>
				</el-button-group>
			</searchInputItems>
			
		</el-form>	
		<elemTable :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange" @selectionChange="selectionChange">
			<el-table-column type="selection" width="55"></el-table-column>
		    <el-table-column prop="materCode" label="卷烟编号" fixed min-width="90">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.materCode">
		    			<span>{{scope.row.materCode}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="materName" label="卷烟名称" fixed min-width="90">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.materName">
		    			<span>{{scope.row.materName}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="materCigbrand" label="卷烟品牌" fixed min-width="90">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.materCigbrand">
		    			<span>{{scope.row.materCigbrand}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="materVersion" label="卷烟版本" fixed min-width="90">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.materVersion">
		    			<span>{{scope.row.materVersion}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="subverName" label="子版本" fixed min-width="90">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.subverName">
		    			<span>{{scope.row.subverName}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="usableQuality" label="可使用库存(件)" fixed min-width="80">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.usableQuality ">
		    			<!--<span style="color: green;">{{scope.row.usableQuality}}</span>-->
		    			<tagItem  type="success" :text="scope.row.usableQuality"></tagItem>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="totalCount" label="库存(件)" min-width="40">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.totalCount">
		    			<!--<span>{{scope.row.totalCount}}</span>-->
		    			<tagItem  type="primary" :text="scope.row.totalCount"></tagItem>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="lockStock" label="锁定库存(件)" min-width="80">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.lockStock">
		    			<tagItem  type="warning" :text="scope.row.lockStock"></tagItem>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="regularQuality" label="正常区(件)" min-width="80">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.regularQuality">
		    			<span>{{scope.row.regularQuality}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="trayusableQuality" label="暂存区(件)" min-width="80">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.trayusableQuality">
		    			<span>{{scope.row.trayusableQuality}}</span>
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
				cigtype:'0',
				materName:'',
//				materVersion:'',
//				materCigbrand:'',
				outmainorderId:null,
			},
			cigtypeOptions:[],
			materCodeOptions:[],
			modalWidth:'80%',
		}
	},
	props: {
		modalshow: {
			default: false
		},
		outmainorderId: {
			default: null
		},
	},
	mounted(){
		this.getType();
//		this.getmaterinfo()
		this.searchTable();	
	},
	methods:{
		cigtypechange(val){
			this.getmaterinfo();
		},
		getType(){
			return this._searchDic("MATERIAL_TYPE").then(
		        function(d) {
		          this.cigtypeOptions = this._dicKey(d);
		        }.bind(this)
		      );
		},
		getmaterinfo(){
			var vm = this
					vm.materCodeOptions = []
					return vm._ajax({
						url: vm.rootAPI, 
						name: 'materialinfo/queryAlllist', 
						param: {cigtype:this.searchForm.cigtype}, 
						}).then((d) => {
							console.log(d)
							if(d.state === 0){
								var aaData = d.aaData
								if(this.searchForm.cigtype==0){
									aaData.forEach(function(el) {
										vm.materCodeOptions.push({
											value: el.materCode,
			      							label: el.materName
										})
									})	
								}else{
									aaData.forEach(function(el) {
										vm.materCodeOptions.push({
											value: el.code,
			      							label: el.name
										})
									})	
								}
							}
		        		}, (d) => {
		                    this.$message.error('物料获取失败');
		                })
		},
		searchTable(){
			this.searchForm.outmainorderId = this.outmainorderId;
			Object.assign(this.searchForm, {
					pageNum: this.pageNum, 
					pageSize: this.pageSize
				})
				return this._ajax({
			        url: this.rootAPI,
			        name: "inventorymain/querymaindetail",
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
				cigtype:'0',
				materName:'',
//				materVersion:'',
//				materCigbrand:'',
				outmainorderId:this.outmainorderId,
			},
			this.getmaterinfo()
			this.handleCurrentChange(1);
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