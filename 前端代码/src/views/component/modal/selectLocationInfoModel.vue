<template>
	<el-dialog custom-class="jz-modal" title="空闲货位" :visible="modalShowlocal"  :before-close="beforeClose" :width="modalWidth" :close-on-click-modal="false">
	<el-form ref="searchForm" :model="searchForm" label-width="80px"  :inline="true" class="demo-form-inline" >
		  <searchInputItems>
				<searchInputItem name="楼层区域编码" >
						<selectInput :value.sync="searchForm.areaId" :clearable="true">
								<el-option
									v-for="item in options"
									:key="item.key"
									:label="item.label"
									:value="item.value">
								</el-option>
						</selectInput>
				</searchInputItem>
		  		<searchInputItem name="货位编码">
					<inputItem :value.sync="searchForm.localCode" :maxlength="12"></inputItem>
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
		<elemTable :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange">
			<el-table-column prop="floorName" label="楼层">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.floorName">
		    			<span>{{scope.row.floorName}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="areaCode" label="区域">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.areaCode">
		    			<span>{{scope.row.areaCode+'区'}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
				<el-table-column prop="areaBlock" label="区域块">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.areaBlock">
		    			<span>{{scope.row.areaBlock+'块'}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="areaRow" label="区域排">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.areaRow">
		    			<span>{{scope.row.areaRow+'排'}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="areaNum" label="区域号">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.areaNum">
		    			<span>{{scope.row.areaNum+'号'}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="upDown" label="上下层">
		    	<template slot-scope="scope">
					<toolTip :content="_dicValue(scope.row.upDown, upDownoptions)">
		    			<span>{{_dicValue(scope.row.upDown, upDownoptions)}}</span>
		    	     </toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="localCode" label="货位编码">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.localCode">
		    			<span>{{scope.row.localCode}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="status" label="货位状态">
		    	<template slot-scope="scope">
		    		<toolTip :content="_dicValue(scope.row.status, statesoptions)">
		    			<span>{{_dicValue(scope.row.status, statesoptions)}}</span>
		    	     </toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="totalCount" label="选择">
		    	<template slot-scope="scope">
		    		<el-button-group>
					    <iconBtn iconClass="el-icon-edit-outline" content="确认选择" @click="selectreplace(scope.row)" ></iconBtn>  
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
			upDownoptions:[],
			statesoptions:[],
			options:[],
			searchForm: {
				areaId: '',
				localCode: '',
				status:'0',
				floorCode:'1'
			},
			materCodeOptions:[],
			modalWidth:'80%',
		}
	},
	props: {
		floorCode: {
			default: '1'
		},
		modalShowlocal: {
			default: false
		},
		materCode: {
			default: null
		},
	},
	mounted(){
		this.searchForm.floorCode = this.floorCode;

		this.searchTable();	
		this.queryarealist();
		this._searchDic("UPDOWN").then(
			        function(d) {
			          this.upDownoptions = this._dicKey(d);
			        }.bind(this)
			      );
		this._searchDic("LOCATION_STATUS").then(
			        function(d) {
			          this.statesoptions = this._dicKey(d);
			        }.bind(this)
			      );
	},
	methods:{
		queryarealist(){
				var vm = this
				vm.options = []
				return vm._ajax({
					url: vm.rootAPI, 
					name: 'areainfo/queryarealist', 
					param: {}, 
					}).then((d) => {
						if(d.state === 0){
							var aaData = d.aaData
							var index 
							aaData.forEach(function(el) {
								index = el.floorAreaCode.indexOf(vm.floorCode)
								if(index == 0){
									vm.options.push({
										value: el.id,
	          							label: el.floorAreaCode
									})
								}
							})	
						}
	        		}, (d) => {
	                    this.$message.error('区域数据获取失败');
	                })
			},
		searchTable(){
			Object.assign(this.searchForm, {
					pageNum: this.pageNum, 
					pageSize: this.pageSize
				})
				return this._ajax({
			        url: this.rootAPI,
			        name: "locationinfo/list",
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
				areaId: '',
				//localCode: '',
				status:'0',
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