<template>
	<div>
		<el-form ref="searchForm" :model="searchForm" label-width="120px"  :inline="true" class="demo-form-inline" >
		 <searchInputItems>
				<searchInputItem name="品牌">
					<inputItem :value.sync="searchForm.brand" :maxlength="40"></inputItem>
				</searchInputItem>
				<searchInputItem name="型号">
					<inputItem :value.sync="searchForm.spec" :maxlength="40"></inputItem>
				</searchInputItem>
				<searchInputItem name="编号\序列号">
					<inputItem :value.sync="searchForm.serialNum" :maxlength="40"></inputItem>
				</searchInputItem>
			</searchInputItems>
		</el-form>	
        <optionItems>
			<template slot="left">
				<el-button-group>
					<iconBtn iconClass="el-icon-plus" content="新增" @click="add">新增</iconBtn>
					<iconBtn iconClass="el-icon-minus" content="删除" @click="dele">删除</iconBtn>
					<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
					<iconBtn iconClass="el-icon-refresh" content="重置" @click="reset">重置</iconBtn>
				</el-button-group>				
			</template>
		</optionItems>
		<elemTable :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange" @selectionChange="selectionChange">
			<el-table-column type="selection" width="55"></el-table-column>
			<el-table-column type="expand">
		      <template slot-scope="props">
		        <el-form label-position="right" inline class="demo-table-expand">
		        	<el-row>
		        		<el-col :span="8">
		        			<el-form-item label="厂家:">
					            <span>{{ props.row.factory }}</span>
					        </el-form-item>
		        		</el-col>
		        		<el-col :span="8">
		        			<el-form-item label="品牌:">
					            <span>{{ props.row.brand }}</span>
					        </el-form-item>
		        		</el-col>
		        		<el-col :span="8">
		        			<el-form-item label="型号:">
					            <span>{{ props.row.spec }}</span>
					        </el-form-item>
		        		</el-col>
		        	</el-row>
		        	<el-row>
		        		<el-col :span="8">
		        			<el-form-item label="编号\序列号">
				            	<span>{{ props.row.serialNum }}</span>
				          	</el-form-item>
		        		</el-col>
		        		<el-col :span="8">
		        			<el-form-item label="生产日期:">
					            <span>{{ props.row.productDate.split(" ")[0] }}</span>
					        </el-form-item>
		        		</el-col>
		        		<el-col :span="8">
		        			<el-form-item label="责任人:">
				            	<span>{{ props.row.charge }}</span>
				          	</el-form-item>
		        		</el-col>
		        	</el-row>
		        	
		        	<el-row>
		        		<el-col :span="8">
		        			<el-form-item label="净升行程:">
					            <span>{{ props.row.netLift }}</span>
					        </el-form-item>
		        		</el-col>
		        		<el-col :span="8">
		        			<el-form-item label="最低高度:">
				            	<span>{{ props.row.minHeight }}</span>
				          	</el-form-item>
		        		</el-col>
		        		<el-col :span="8">
		        			<el-form-item label="平台尺寸:">
					            <span>{{ props.row.platformSize }}</span>
					        </el-form-item>
		        		</el-col>
		        	</el-row>
		        	<el-row>
		        		<el-col :span="8">
		        			<el-form-item label="电机功率:">
				            	<span>{{ props.row.motorPower }}</span>
				          	</el-form-item>
		        		</el-col>
		        		<el-col :span="8">
		        			<el-form-item label="额定载荷:">
					            <span>{{ props.row.ratedLoad }}</span>
					        </el-form-item>
		        		</el-col>
		        	</el-row>
		        </el-form>
		      </template>
		    </el-table-column>
			<el-table-column prop="factory" label="厂家">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.factory">
		    			<span>{{scope.row.factory}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="brand" label="品牌">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.brand">
		    			<span>{{scope.row.brand}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="spec" label="型号">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.spec">
		    			<span>{{scope.row.spec}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="serialNum" label="编号\序列号">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.serialNum">
		    			<span>{{scope.row.serialNum}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="productDate" label="生产日期">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.productDate">
		    			<span>{{scope.row.productDate.split(" ")[0]}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="charge" label="责任人">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.charge">
		    			<span>{{scope.row.charge}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column label="操作">
		    	<template slot-scope="scope">
		    		<el-button-group>
		    			<iconBtn iconClass="el-icon-edit" content="编辑" @click="modalEdit(scope.row)" v-if="!scope.row.rowEditable && scope.row.userId != thisUser.userId"></iconBtn>    
					    <iconBtn iconClass="el-icon-minus" content="删除" @click="delRow(scope.row)" v-if="scope.row.userId != thisUser.userId"></iconBtn>
		    		</el-button-group>		    		
		    	</template>
		    </el-table-column>
		</elemTable>
		<hoistModel  v-if="modalShow" :modaltype="modalType"  @close="modalClose" :modalshow='modalShow' @submit="modalSubmit" :tableRow='modalObj'></hoistModel>
	</div>
</template>

<script>
	import mixin from '../../mixin/mixin.js'
	import local from '../../local.js'
	import hoistModel from "../component/modal/hoistModel.vue"
	export default {
		mixins: [mixin],
		components: {hoistModel},
		data() {
			return {
				searchForm: {
					brand: '',
					spec: '',
					serialNum:'',
				},
				thisUser: local.get('userinfo'),
			}
		},
		mounted() {
			this.searchTable()
		},
		methods: {
			searchTable() {
				var vm = this
				Object.assign(this.searchForm, {
					pageNum: this.pageNum, 
					pageSize: this.pageSize
				})
				return this._ajax({
			        url: this.rootAPI,
			        name: "Hoist/list",
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
		            url: this.rootAPI + "Hoist/delete",
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
					brand: '',
					spec: '',
					serialNum:'',
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
	  /*.demo-table-expand {
	    font-size: 0;
	  }*/
	  .demo-table-expand label {
	    width: 90px;
	    color: #99a9bf;
	  }
	  .demo-table-expand .el-form-item {
	    margin-right: 0;
	    margin-bottom: 0;
	    width: 50%;
	  }
</style>