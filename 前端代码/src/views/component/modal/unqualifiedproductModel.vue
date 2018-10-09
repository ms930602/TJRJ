<template>
	<el-dialog custom-class="jz-modal" title="不合格卷烟选择" :visible="modalshow"  :before-close="beforeClose" :width="modalWidth" :close-on-click-modal="false">
		<el-form ref="searchForm" :model="searchForm" label-width="80px"  :inline="true" class="demo-form-inline" >
		  <!-- 查询条件 -->
			<searchInputItems>
				<searchInputItem name="货位编号" >
						<selectInput :value.sync="searchForm.cigtype" @selectChange = "cigtypechange">
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
				<!--<searchInputItem name="卷烟版本">
					<inputItem :value.sync="searchForm.materVersion" :maxlength="10"></inputItem>
				</searchInputItem>
				<searchInputItem name="卷烟品牌">
					<inputItem :value.sync="searchForm.materCigbrand" :maxlength="40"></inputItem>
				</searchInputItem>-->
				<el-button-group style="margin-left: 20px;">
					<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
					<iconBtn iconClass="el-icon-refresh" content="重置" @click="reset">重置</iconBtn>
				</el-button-group>
			</searchInputItems>
			
		</el-form>	
		<elemTable :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange" @selectionChange="selectionChange">
			<!--<el-table-column type="selection" width="55"></el-table-column>-->
		    <el-table-column prop="materCode" label="卷烟编号">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.materCode">
		    			<span>{{scope.row.materCode}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="materName" label="卷烟名称">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.materName">
		    			<span>{{scope.row.materName}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		     <el-table-column prop="materCigbrand" label="卷烟品牌">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.materCigbrand">
		    			<span>{{scope.row.materCigbrand}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="materVersion" label="卷烟版本">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.materVersion">
		    			<span>{{scope.row.materVersion}}</span>
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
		    <el-table-column  label="操作">
		    	<template slot-scope="scope">
		    		<el-button-group>
		    			<iconBtn iconClass="el-icon-check" content="选择"  @click="save(scope.row)" ></iconBtn> 
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
				cigtype:'0',
				materName:'',
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
		this.getmaterinfo()
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
		                    this.$message.error('卷烟获取失败');
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
			        name: "inventorymain/queryAlldetails",
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
			},
			this.getmaterinfo()
			this.handleCurrentChange(1);
		},
		save(row){
			this.$emit('selectList',row)
			this.cancel()
		}
	},
}
</script>