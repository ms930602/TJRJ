<template>
	<div>
		<el-form ref="searchForm" :model="searchForm" label-width="80px"  :inline="true" class="demo-form-inline" >
		  <!-- 查询条件 -->
			<searchInputItems>
				<searchInputItem name="楼层" >
						<selectInput :value.sync="searchForm.floorId" :clearable="true">
								<el-option
									v-for="item in floorOptions"
									:key="item.key"
									:label="item.label"
									:value="item.value">
								</el-option>
						</selectInput>
				</searchInputItem>
				<searchInputItem name="区域编码">
					<inputItem :value.sync="searchForm.areaCode" :maxlength="10"></inputItem>
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
		    <el-table-column prop="areaCode" label="区域编码">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.areaCode">
		    			<span>{{scope.row.areaCode}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="floorName" label="楼层名称">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.floorName">
		    			<span>{{scope.row.floorName}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="floorAreaCode" label="楼层区域组合编码">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.floorAreaCode">
		    			<span>{{scope.row.floorAreaCode}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="remark" label="备注">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.remark">
		    			<span>{{scope.row.remark}}</span>
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
		<areainfoModel  v-if="modalShow" :modaltype="modalType"  @close="modalClose" :modalshow='modalShow' @submit="modalSubmit" :tableRow='modalObj'></areainfoModel>
	</div>
</template>
<script>
	import mixin from '../../mixin/mixin.js'
	import local from '../../local.js'
	import areainfoModel from "../component/modal/areainfoModel.vue";
	export default {
		mixins: [mixin],
		components: {areainfoModel},
		data() {
			var validaareaCodeCode = (rule, value, callback) => {
				let areaCodetest = /^[0-9a-zA-Z]+$/;
				if(!areaCodetest.test(value)) {
					return callback(new Error('请填写字母与数字的组合'));
				} else {
					callback();
				}
			};
			return {
				searchForm: {
					floorId: '',
					areaCode: '',
				},
				floorOptions:[],
				thisUser: local.get('userinfo'),}
		},
		mounted() {
			this.queryAllFloor()
			this.searchTable()
		},
		methods: {
			queryAllFloor(){
		  		var vm = this
					vm.floorOptions = []
					return vm._ajax({
						url: vm.rootAPI, 
						name: 'floorinfo/queryfloorlist', 
						param: {}, 
						}).then((d) => {
							console.log(d)
							if(d.state === 0){
								var aaData = d.aaData
								aaData.forEach(function(el) {
									vm.floorOptions.push({
										value: el.id,
		      							label: el.floorName
									})
								})	
							}
		        		}, (d) => {
		                    this.$message.error('楼层数据获取失败');
		                })
		  	},
			searchTable() {
				Object.assign(this.searchForm, {
					pageNum: this.pageNum, 
					pageSize: this.pageSize
				})
				return this._ajax({
			        url: this.rootAPI,
			        name: "areainfo/list",
			        param: this.searchForm,
			        loading: "dataLoading"
			    }).then(this.renderTable);
			},
			modalEdit(value){
				this.modalType = "edit";
	      		this.modalShow = true;
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
		            url: this.rootAPI + "areainfo/delete",
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
					floorId: '',
					areaCode: '',
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