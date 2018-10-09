<template>
	<!--仓库信息-->
	<div class="page-measureunit">
		<!-- 查询条件 -->
		<searchInputItems>
			<searchInputItem name="名称">
				<inputItem :value.sync="searchForm.name" @enter="searchTable"></inputItem>
			</searchInputItem>
			<searchInputItem name="代码">
				<inputItem :value.sync="searchForm.code" @enter="searchTable"></inputItem>
			</searchInputItem>
			<searchInputItem name="状态">
				<selectInput :value.sync="searchForm.status" @selectChange="searchTable" :clearable="true">
					<el-option
				      v-for="item in optionStatus"
				      :key="item.key"
				      :label="item.label"
				      :value="item.value">
				    </el-option>
				</selectInput>
			</searchInputItem>
		</searchInputItems>
		<!-- 操作按钮 -->
		<optionItems>
			<template slot="left">
				<el-button-group>
					<iconBtn iconClass="el-icon-plus" content="新增" @click="add">新增</iconBtn>
					<!-- <iconBtn iconClass="el-icon-minus" content="删除" @click="batchdelete">删除</iconBtn> -->
					<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
					<iconBtn iconClass="el-icon-refresh" content="重置" @click="reset">重置</iconBtn>
				</el-button-group>				
			</template>
		</optionItems>
		<!-- 表格 -->
		<elemTable :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange" >
		    <el-table-column prop="code" label="代码">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.code">
		    			<span>{{scope.row.code}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		     <el-table-column prop="name" label="名称">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.name">
		    			<span>{{scope.row.name}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
	    <el-table-column prop="isIndustry" label="行业内外标识">
				<template slot-scope="scope">
		    		<toolTip :content="_dicValue(scope.row.isIndustry, dicisIndustry)">
		    			<span>{{_dicValue(scope.row.isIndustry, dicisIndustry)}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
			   <el-table-column prop="tegRegNum" label="纳税人登记号">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.tegRegNum">
		    			<span>{{scope.row.tegRegNum}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column> 
		     <el-table-column prop="comProviderProp" label="客商属性">
				<template slot-scope="scope">
		    		<toolTip :content="_dicValue(scope.row.comProviderProp, ProviderProp)">
		    			<span>{{_dicValue(scope.row.comProviderProp, ProviderProp)}}</span>
		    		</toolTip>
		      	</template>		    	
		    </el-table-column> 
		    <el-table-column prop="comProviderType" label="客商类型">
				<template slot-scope="scope">
		    		<toolTip :content="_dicValue(scope.row.comProviderType, ProviderType)">
		    			<span>{{_dicValue(scope.row.comProviderType, ProviderType)}}</span>
		    		</toolTip>
		      	</template>		    	
		    </el-table-column>
		    <el-table-column prop="legalbody" label="法人代表">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.legalbody">
		    			<span>{{scope.row.legalbody}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		     <el-table-column prop="linkman" label="联系人">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.linkman">
		    			<span>{{scope.row.linkman}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		     <el-table-column prop="bankName" label="银行名称">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.bankName">
		    			<span>{{scope.row.bankName}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
			<el-table-column prop="bankAccount" label="银行账号">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.bankAccount">
		    			<span>{{scope.row.bankAccount}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
			<el-table-column prop="useCompany" label="使用公司">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.useCompany">
		    			<span>{{scope.row.useCompany}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
			<el-table-column prop="status" label="状态">
		    	<template slot-scope="scope">
		    		<tagItem type="success" v-if="scope.row.status==2" :text="_dicValue(scope.row.status, dicStatus)"></tagItem>
					<tagItem type="warning" v-else :text="_dicValue(scope.row.status, dicStatus)"></tagItem>
		      	</template>
		    </el-table-column> 
			 <el-table-column label="操作">
		    	<template slot-scope="scope">
		    		<el-button-group>
						<iconBtn iconClass="el-icon-edit" content="编辑" @click="modalEdit(scope.row)"></iconBtn>    
					    <iconBtn iconClass="el-icon-minus" content="删除" @click="deleterow(scope.row)" v-if="scope.row.status!='2'"></iconBtn>
		    		</el-button-group>		    		
		    	</template>
		    </el-table-column>
		</elemTable>
		 <merchantModel  v-if="modalShow" :modaltype="modalType"  @close="modalClose" :modalshow='modalShow' @submit="modalSubmit" :tableRow='modalObj'></merchantModel>
	</div>
</template>
<script>
	import mixin from '../../mixin/mixin.js'
	import local from '../../local.js'
	import merchantModel from "../component/modal/merchantModel.vue";
	export default {
		mixins: [mixin],
		components: { merchantModel },
		data() {
			return {
				searchForm: {
					warName: '',
					warCode: '',
					status:'',
				},
				dataList: [],
				ProviderType:[],
				dicisIndustry:[],
				ProviderProp:[],
				dicStatus:[],
				optionStatus: [{
					value: '2',
					label: '发布'
					},{
					value: '3',
					label: '停用'
					}]
			};
		},
		mounted() {
			this.searchTable();
			/*是否基本单位*/
			this._searchDic('MERCHANT_DUSTRY')
			.then((function(d) {
				this.dicisIndustry = this._dicKey(d)
			}).bind(this));
			/*客商属性*/
			this._searchDic('MACHANT_PRO')
			.then((function(d) {
				this.ProviderProp = this._dicKey(d)
			}).bind(this));
			/*客商类型*/
			this._searchDic('MERCHANT_TYPE')
			.then((function(d) {
				this.ProviderType = this._dicKey(d)
			}).bind(this));
			/*客商状态*/
			this._searchDic('MERCHANT_STATUS')
			.then((function(d) {
				this.dicStatus = this._dicKey(d)
			}).bind(this));
		},
		methods: {
			searchTable() {
				Object.assign(this.searchForm, {
					pageNum: this.pageNum, 
					pageSize: this.pageSize
				})
				return this._ajax({url: this.rootAPI, name: 'merchant/list', param: this.searchForm, loading: 'dataLoading'}).then(this.renderTable)
			},
			reset() {
				Object.assign(this.searchForm, {
					name: '',
					code: '',
					status:'',
				})
				this.handleCurrentChange(1)
			},
			add() {
				debugger;
				this.modalType = "add";
				this.modalShow = true;
				this.modalObj = {};

			},
			modalEdit(row){
				this.modalType = "edit";
				this.modalShow = true;
				this.modalObj = row;
			},
			deleterow(row) {
				var o = {
					id: [row.id]
				};
				this.delSubmit(o);
			},
			delSubmit(o) {
				this.confirm("确定删除？",
					function() {
						this._ajax({
							url: this.rootAPI + "merchant/delete",
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
						},
			cancel() {
				var vm = this;
				vm.$refs["form"].resetFields();
				this.dialog.show = false;
				this.diaTitle = '',
				this.searchTable();
			},
		}
	};
</script>

<style>
</style>