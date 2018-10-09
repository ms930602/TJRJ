<template>
	<div class="page-user">
		<!-- 查询条件 -->
		<searchInputItems>
			<searchInputItem name="设备类型">
				<selectInput :value.sync="searchForm.deviceType" @selectChange="searchTable" :clearable="searchClearable">
					<el-option
				      v-for="item in dataDic.deviceType"
				      :key="item.dicName"
				      :label="item.dicName"
				      :value="item.dicCode">
				    </el-option>
				</selectInput>
			</searchInputItem>
			<searchInputItem name="生产厂家">
				<inputItem :value.sync="searchForm.manufacturer" @enter="searchTable"></inputItem>
			</searchInputItem>
			<searchInputItem name="型号">
				<inputItem :value.sync="searchForm.deviceModel" @enter="searchTable"></inputItem>
			</searchInputItem>
			<searchInputItem name="是否发布">
				<selectInput :value.sync="searchForm.versionStatus" @selectChange="searchTable" :clearable="searchClearable">
					<el-option
				      v-for="item in dataDic.versionStatus"
				      :key="item.dicName"
				      :label="item.dicName"
				      :value="item.dicCode">
				    </el-option>
				</selectInput>
			</searchInputItem><searchInputItem name="是否必须更新">
				<selectInput :value.sync="searchForm.isNeedUpdate" @selectChange="searchTable" :clearable="searchClearable">
					<el-option
				      v-for="item in dataDic.whether"
				      :key="item.dicName"
				      :label="item.dicName"
				      :value="item.dicCode">
				    </el-option>
				</selectInput>
			</searchInputItem>
		</searchInputItems>
		<!-- 操作按钮 -->
		<optionItems>
			<template slot="left">
				<el-button-group>
					<iconBtn iconClass="el-icon-plus" content="新增" @click="modalAdd">新增</iconBtn>
					<iconBtn iconClass="el-icon-minus" content="删除" @click="dele">删除</iconBtn>
					<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
					<iconBtn iconClass="el-icon-refresh" content="重置" @click="reset">重置</iconBtn>
				</el-button-group>
			</template>
		</optionItems>
		<!-- 表格 -->
		<elemTable :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange" @selectionChange="selectionChange">
			<el-table-column type="selection" width="55"></el-table-column>
		    <el-table-column prop="version" label="版本号">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.version" v-if="!scope.row.rowEditable">
		    			<span>{{scope.row.version}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="deviceType" label="设备类型">
		    	<template slot-scope="scope">
		    		<toolTip :content="_dicValue(scope.row.deviceType, dicIsDeviceType)" v-if="!scope.row.rowEditable">
	    				<span v-if="!scope.row.rowEditable">{{_dicValue(scope.row.deviceType, dicIsDeviceType)}}</span>
	    			</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="manufacturer" label="生产厂家">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.manufacturer" v-if="!scope.row.rowEditable">
		    			<span>{{scope.row.manufacturer}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="deviceModel" label="设备型号">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.deviceModel" v-if="!scope.row.rowEditable">
		    			<span>{{scope.row.deviceModel}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="isNeedUpdate" label="是否必须更新">
		    	<template slot-scope="scope">
		    		<toolTip :content="_dicValue(scope.row.isNeedUpdate, dicIsWhether)" v-if="!scope.row.rowEditable">
	    				<span v-if="!scope.row.rowEditable">{{_dicValue(scope.row.isNeedUpdate, dicIsWhether)}}</span>
	    			</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="versionStatus" label="是否发布">
		    	<template slot-scope="scope">
		    		<toolTip :content="_dicValue(scope.row.versionStatus, dicIsVersionStatus)" v-if="!scope.row.rowEditable">
	    				<span v-if="!scope.row.rowEditable">{{_dicValue(scope.row.versionStatus, dicIsVersionStatus)}}</span>
	    			</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column label="操作">
		    	<template slot-scope="scope">
		    		<el-button-group>
					    <iconBtn iconClass="el-icon-edit" content="编辑" @click="modalEdit(scope.row)" v-if="scope.row.versionStatus != 1">编辑</iconBtn>
					    <iconBtn content="发布" type="success" @click="publish(scope.row)" v-if="scope.row.versionStatus == null || scope.row.versionStatus == '2'">发布</iconBtn>
					    <iconBtn  iconClass="el-icon-minus" content="删除"  @click="delRow(scope.row)" v-if="scope.row.versionStatus != 1">删除</iconBtn>
		    		</el-button-group>		    		
		    	</template>
		    </el-table-column>
		</elemTable>
		<deviceversionModal v-if="modalShow" :modal="modalShow" :deviceversionModalType="modalType" @close="modalClose" :deviceVersion="modalObj" :dataDic="dataDic"  @submit="modalSubmit"></deviceversionModal>
	</div>
</template>
<script>
	import mixin from '../../mixin/mixin.js'
	import deviceversionModal from '../component/modal/deviceversionModal.vue'
	export default {
		mixins: [mixin],
		components: {deviceversionModal},
		data() {
			return {
				searchForm: { 
					deviceType: '',
					versionStatus: '',
					manufacturer: '',
					deviceModel:'',
					versionStatus:'',
					isNeedUpdate:''
				},
				dataDic:{versionStatus:[], deviceType:[], whether:[]},
				dataList: [],
				rowOBJ: {},
				dicIsWhether:[],
				dicIsDeviceType:[],
				dicIsVersionStatus:[],
				searchClearable:true
			}
		},
		mounted() {
			this.getInitData();
			this._searchDic('VERSION_STATUS')
			.then((function(d) {
				this.dicIsVersionStatus = this._dicKey(d)
			}).bind(this));

			this._searchDic('WHETHER')
			.then((function(d) {
				this.dicIsWhether = this._dicKey(d)
			}).bind(this));
			this._searchDic('DEVICE_TYPE')
			.then((function(d) {
				this.dicIsDeviceType = this._dicKey(d)
			}).bind(this));
			this.searchTable();
		},
		methods: {
			getInitData() {
				//查询数据字典，版本状态
				this._searchDic('VERSION_STATUS')
				.then((function(d) {
					Object.assign(this.dataDic,{
						versionStatus : d.aaData
					})
				}).bind(this))
				//查询数据字典，是否判断
				this._searchDic('WHETHER')
				.then((function(d) {
					let data = d.aaData;
					Object.assign(this.dataDic,{
						whether : data
					})
				}).bind(this))
				//查询数据字典设备类型
				this._searchDic('DEVICE_TYPE')
				.then((function(d) {
					Object.assign(this.dataDic,{
						deviceType : d.aaData
					})
				}).bind(this))
			},
			renderCommon(dataList, code) {
				let dataShow = '';
				$.each(dataList, function(i, obj) {
					if(obj.code == code) {
						dataShow = obj.name;
					}
				});
				return dataShow;
			},
			searchTable() {
				Object.assign(this.searchForm, {
					pageNum: this.pageNum, 
					pageSize: this.pageSize
				})
				return this._ajax({url: this.rootAPI, name: 'baseDeviceversion/list', param: this.searchForm, loading: 'dataLoading'}).then(this.renderTable)
			},
			reset() {
				Object.assign(this.searchForm, {
					deviceType: '',
					versionStatus: '',
					manufacturer: '',
					deviceModel:'',
					versionStatus:'',
					isNeedUpdate:''
				})
				this.handleCurrentChange(1)
			},			
			dele() {			
	        	if(this.delSelection.length === 0) {
	        		this.$message({type: 'info', message: '请选择行'});
	        	}else {
	        		let selection = this.delSelection
	        		this.confirm('确定删除？', (function() {     
	        			var arr = [], o = {}
						selection.forEach(function(el) {
							arr.push(el.id)
						})
						o.id = arr
						this._ajax({url: this.rootAPI + 'baseDeviceversion/delete', param: o, arr:true})
						.then((function(d) {
							this.$message({type: 'success', message: '删除成功'});
							this.handleCurrentChange(1)
						}).bind(this))
	        		}).bind(this))		                        		
	        	}	
			},
			delRow(row) {
				this.confirm('确定删除？', (function() {     
        			var o = {
        				id: [row.id]
        			}
					this._ajax({url: this.rootAPI + 'baseDeviceversion/delete', param: o, arr:true})
					.then((function(d) {
						this.$message({type: 'success', message: '删除成功'});
						this.handleCurrentChange(1)
					}).bind(this))
        		}).bind(this))
			},
			publish(row) {
				this.confirm('确定发布该版本？', (function() {
        			var o = {
        				id: [row.id],
        				versionStatus:"1"
        			}
					this._ajax({url: this.rootAPI + 'baseDeviceversion/update', param: o, arr:true})
					.then((function(d) {
						this.$message({type: 'success', message: '发布成功'});
						this.handleCurrentChange(1)
					}).bind(this))
        		}).bind(this))
			},
			modalEdit(o) {
				o.isNeedUpdate=o.isNeedUpdate+'';
				o.deviceType=o.deviceType+'';
				o.versionStatus=o.versionStatus+'',
				this.modalObj = o
				this.modalType = 'edit'
				this.modalShow = true
			},	
			cancelEdit(o) {
				Object.assign(o, this.rowOBJ[o.id])
			},
			submitEdit(o) {
				if(!o.deviceModel || !o.manufacturer) {
					this.$message({ type: 'error', message: '型号或生产厂家不能为空' });
					o.rowError = true
				} else {
					this._ajax({url: this.rootAPI + 'baseDeviceversion/update', param: o, loading: 'dataLoading'})
                        .then((function(d) { 
                        	this.$message({ type: 'success', message: '操作成功' }); 
                    		o.rowEditable = false
                        }).bind(this))
				}
			}
		}
	}
</script>