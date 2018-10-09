<template>
	<!--计量单位-->
	<div class="page-measureunit">
		<!-- 查询条件 -->
		<searchInputItems>
			<searchInputItem name="单位名称">
				<inputItem :value.sync="searchForm.unitName" @enter="searchTable"></inputItem>
			</searchInputItem>
			<searchInputItem name="单位编码">
				<inputItem :value.sync="searchForm.unitCode" @enter="searchTable"></inputItem>
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
					<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
					<iconBtn iconClass="el-icon-refresh" content="重置" @click="reset">重置</iconBtn>
				</el-button-group>				
			</template>
		</optionItems>
		<!-- 表格 -->
		<elemTable :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange" >
		    <el-table-column prop="unitName" label="单位名称">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.unitName">
		    			<span>{{scope.row.unitName}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="unitCode" label="单位编码">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.unitCode">
		    			<span>{{scope.row.unitCode}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="beloneMain" label="所属量纲">
		    	<template slot-scope="scope">
		    		<tagItem :text="_dicValue(scope.row.beloneMain, dicBeloneMain)"></tagItem>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="isBase" label="是否基本单位">
		    	<template slot-scope="scope">
		    		<tagItem :text="_dicValue(scope.row.isBase, dicIsBase)"></tagItem>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="transRate" label="转换系数">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.transRate">
		    			<span>{{scope.row.transRate}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="status" label="状态">
		    	<template slot-scope="scope">
		    		<tagItem :text="_dicValue(scope.row.status, dicStatus)"></tagItem>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="createdDate" label="创建时间">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.createdDate">
		    			<span>{{scope.row.createdDate}}</span>
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
		    <el-table-column prop="updatedDate" label="更新时间">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.updatedDate">
		    			<span>{{scope.row.updatedDate}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="updatedPerson" label="更新人">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.updatedPerson">
		    			<span>{{scope.row.updatedPerson}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    
		</elemTable>
	</div>
</template>

<script>
	import mixin from '../../mixin/mixin.js'
	import local from '../../local.js'
	export default {
		mixins: [mixin],
		data() {
			return {
				searchForm: {
					unitName: '',
					unitCode: '',
				},
				dataList: [],				
				rowOBJ: {},
				oldForm:[],
				dicBeloneMain:[],
				form:{
					unitName: '',
					unitCode: '',
					beloneMain:'',
					isBase:'',
					transRate:'',
					status:'',
					createdDate:'',
					createdPerson:'',
					updatedDate:'',
					updatedPerson:'',
				},
				dialog: {
					show: false
				},
				modalType:'add',
				optionBeloneMain: [{
					       value: '0',
					       label: '件数'
					      },{
					       value: '1',
					       label: '重量'
					      },{
					       value: '2',
					       label: '长度'
					      },{
					       value: '9',
					       label: '其他'
					      }],
				optionIsBase: [{
					       value: '0',
					       label: '是'
					      },{
					       value: '1',
					       label: '否'
					      }],
				optionStatus: [{
					       value: '2',
					       label: '发布'
					      },{
					       value: '3',
					       label: '停用'
					      }]
					      
			}
			
		},
		mounted() {
			/*所属量纲*/
			this._searchDic('BELONE_MAIN')
			.then((function(d) {
				this.dicBeloneMain = this._dicKey(d)
			}).bind(this))
			/*是否基本单位*/
			this._searchDic('IS_BASE')
			.then((function(d) {
				this.dicIsBase = this._dicKey(d)
			}).bind(this))
			/*状态*/
			this._searchDic('STATUS')
			.then((function(d) {
				this.dicStatus = this._dicKey(d)
			}).bind(this))
			.then(this.searchTable)
//			this.searchTable();
		},
		methods: {
			searchTable() {
				Object.assign(this.searchForm, {
					pageNum: this.pageNum, 
					pageSize: this.pageSize
				})
				return this._ajax({url: this.rootAPI, name: 'measureunit/list', param: this.searchForm, loading: 'dataLoading'}).then(this.renderTable)
			},
			reset() {
				Object.assign(this.searchForm, {
					unitName: '',
					unitCode: '',
				})
				this.handleCurrentChange(1)
			},
			add(){
			},
			modalEdit(row){
			},
			dele() {			
			},
			delRow(row) {
			},
			delSubmit(o) {
			},
			cancel() {
				var vm = this;
				vm.$refs["form"].resetFields(); // 去掉验证提示
				this.dialog.show = false;
				this.diaTitle = '',
				this.searchTable();
			},
			submit() {
			},
		}
	}
</script>

<style>
</style>