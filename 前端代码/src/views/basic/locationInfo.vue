<template>
	<div>
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
					<inputItem :value.sync="searchForm.localCode" :maxlength="20"></inputItem>
				</searchInputItem>
		  		<searchInputItem name="货位状态" >
						<selectInput :value.sync="searchForm.status" :clearable="true">
								<el-option
									v-for="item in statesoptions"
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
					<!-- <iconBtn iconClass="el-icon-plus" content="新增" @click="add">新增</iconBtn>
					<iconBtn iconClass="el-icon-minus" content="删除" @click="dele">删除</iconBtn> -->
					<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
					<iconBtn iconClass="el-icon-refresh" content="重置" @click="reset">重置</iconBtn>
				</el-button-group>				
			</template>
		</optionItems>
		<elemTable :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange" @selectionChange="selectionChange">
			<el-table-column type="selection" width="55"></el-table-column>
			<el-table-column prop="floorName" label="楼层" >
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.floorName">
		    			<span>{{scope.row.floorName}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="areaCode" label="区域" >
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.areaCode">
		    			<span>{{scope.row.areaCode+'区'}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
				<el-table-column prop="areaBlock" label="区域块" >
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.areaBlock">
		    			<span>{{scope.row.areaBlock+'块'}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="areaRow" label="区域排" >
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.areaRow">
		    			<span>{{scope.row.areaRow+'排'}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="areaNum" label="区域号" >
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.areaNum">
		    			<span>{{scope.row.areaNum+'号'}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="upDown" label="上下层" >
		    	<template slot-scope="scope">
					<toolTip :content="_dicValue(scope.row.upDown, upDownoptions)">
		    			<span>{{_dicValue(scope.row.upDown, upDownoptions)}}</span>
		    	     </toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="localCode" label="货位编码" width="160px">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.localCode">
		    			<span>{{scope.row.localCode}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="localRfid" label="RFID编码"  width="200px">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.localRfid">
		    			<span>{{scope.row.localRfid}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="status" label="货位状态" >
		    	<template slot-scope="scope">
		    		<toolTip :content="_dicValue(scope.row.status, statesoptions)">
							<tagItem type="success" v-if="scope.row.status==0" :text="_dicValue(scope.row.status, statesoptions)"></tagItem>
							<tagItem type="warning" v-else :text="_dicValue(scope.row.status, statesoptions)"></tagItem>
							<!-- <el-tag type="warning" type="success" v-if="scope.row.status==0">{{_dicValue(scope.row.status, statesoptions)}}</el-tag> -->
		    			<!-- <span>{{_dicValue(scope.row.status, statesoptions)}}</span> -->
							<!-- <el-tag type="warning" v-else>{{_dicValue(scope.row.status, statesoptions)}}</el-tag> -->
		    	     </toolTip>
		      	</template>
		    </el-table-column>
				<el-table-column prop="status" label="货位描述" width="210px">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.descript">
		    			<span>{{scope.row.descript}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <!-- <el-table-column label="操作">
		    	<template slot-scope="scope">
		    		<el-button-group>
		    			<iconBtn iconClass="el-icon-edit" content="编辑" @click="modalEdit(scope.row)" v-if="!scope.row.rowEditable && scope.row.userId != thisUser.userId"></iconBtn>    
					    <iconBtn iconClass="el-icon-minus" content="删除" @click="delRow(scope.row)" v-if="scope.row.userId != thisUser.userId"></iconBtn>
		    		</el-button-group>		    		
		    	</template>
		    </el-table-column> -->
		</elemTable>
		<locationInfoModel  v-if="modalShow" :modaltype="modalType"  @close="modalClose" :modalshow='modalShow' @submit="modalSubmit" :tableRow='modalObj'></locationInfoModel>
	</div>
</template>

<script>
	import mixin from '../../mixin/mixin.js'
	import local from '../../local.js'
	import locationInfoModel from "../component/modal/locationInfoModel.vue";
	export default {
		mixins: [mixin],
		components: {locationInfoModel},
		data() {
			return {
				upDownoptions:[],
				options:[],
				statesoptions:[],
				searchForm: {
					areaId: '',
					localCode: '',
					status:'',
				},
				thisUser: local.get('userinfo'),
			}
		},
		mounted() {
			this.queryarealist()
			this.getupdown()
		},
		methods: {
			/**
			 * 获取上下层
			 */
			getupdown(){
				return this._searchDic("UPDOWN").then(
			        function(d) {
			          this.upDownoptions = this._dicKey(d);
			          this.getstatus()
			        }.bind(this)
			      );
			},
			/**
			 * 获取货位状态
			 */
			getstatus(){
				return this._searchDic("LOCATION_STATUS").then(
			        function(d) {
			          this.statesoptions = this._dicKey(d);
			          this.searchTable()
			        }.bind(this)
			      );
				var vm=this;
				vm.statesoptions=[]
				vm._searchDic('LOCATION_STATUS')
				.then((function(d) {
					d.aaData.forEach(function(el) {
						vm.statesoptions.push({
							value: el.dicCode,
          					label: el.dicName
						})
					})
					vm.searchTable()
				}).bind(this))
			},
			queryarealist(){
				var vm = this
				vm.options = []
				return vm._ajax({
					url: vm.rootAPI, 
					name: 'areainfo/queryarealist', 
					param: {}, 
					}).then((d) => {
						console.log(d)
						if(d.state === 0){
							var aaData = d.aaData
							aaData.forEach(function(el) {
								vm.options.push({
									value: el.id,
          							label: el.floorAreaCode
								})
							})	
						}
	        		}, (d) => {
	                    this.$message.error('区域数据获取失败');
	                })
			},
			searchTable() {
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
			modalEdit(value){
				this.modalType = "edit";
	      		this.modalShow = true;
	      		value.upDown = value.upDown+''
	      		this.modalObj = value;
			},
			dele() {
		      if (this.delSelection.length === 0) {
		        this.$message({ type: "info", message: "请选择行" });
		      } else {
		        let selection = this.delSelection;
		        var arr = [],
		          o = {};
		        selection.forEach(function(el) {
		          arr.push(el.id);
		        });
		        o.id = arr;
		        this.delsubmit(o);
		      }
		    },
		    delRow(row) {
		      var o = {
		        id: [row.id]
		      };
		      this.delsubmit(o);
		    },
		    delsubmit(o) {
		      this.confirm(
		        "确定删除？",
		        function() {
		          this._ajax({
		            url: this.rootAPI + "locationinfo/delete",
		            param: o,
		            arr: true
		          }).then(
		            function(d) {
		              if (d.state == 0) {
		                this.$message({ type: "success", message: "删除成功" });
		              } else {
		                this.$message({ type: "warning", message: "删除失败" });
		              }
		              this.handleCurrentChange(1);
		            }.bind(this)
		          );
		        }.bind(this)
		      );
		    },
			reset(){
				var vm = this;
				vm.searchForm = {
					areaId: '',
					localCode: '',
					status:'',
				}
				this.handleCurrentChange(1);
			},
			add(){
				this.modalType = "add";
	      		this.modalShow = true;
	      		this.modalObj = {};
			},
		}
	}
</script>

<style>
</style>