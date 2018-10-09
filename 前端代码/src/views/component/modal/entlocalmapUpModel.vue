<template>
	<el-dialog custom-class="jz-modal" title="修改货位" :visible="modalShowUp"  :before-close="beforeClose" :width="modalWidth" :close-on-click-modal="false">
	
          
					<el-form ref="searchForm" :model="searchForm">
						<!-- 查询条件 -->
						<searchInputItems>
							<searchInputItem name="货位编号">
								<inputItem :value.sync="searchForm.localCode" :maxlength="25"></inputItem>
							</searchInputItem>

						<searchInputItem name="楼层">
							<selectInput :value.sync="searchForm.floorCode" :maxlength="10"  filterable placeHolder="请选择楼层">
								<el-option
										v-for="item in floors"
										:key="item.key"
										:label="item.value"
										:value="item.key">
									</el-option>
							</selectInput>
						</searchInputItem>

							<el-button-group style="margin-left: 20px;" >
								<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
								<iconBtn iconClass="el-icon-refresh" content="重置" @click="reset">重置</iconBtn>
							</el-button-group>
						</searchInputItems>
					</el-form>



		<elemTable ref="multipleTable" :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange" @selectionChange="selectionChange">
		       
							<el-table-column prop="localId" label="货位id">
					    	<template slot-scope="scope">
					    		<toolTip :content="scope.row.localId">
					    			<span>{{scope.row.localId}}</span>
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


						<!--
							<el-table-column prop="localRfid" label="货位rfid编号">
					    	<template slot-scope="scope">
					    		<toolTip :content="scope.row.localRfid">
					    			<span>{{scope.row.localRfid}}</span>
					    		</toolTip>
					      	</template>
					    </el-table-column>
							-->
						<el-table-column prop="descript" label="货位描述">
					    	<template slot-scope="scope">
					    		<toolTip :content="scope.row.descript">
					    			<span>{{scope.row.descript}}</span>
					    		</toolTip>
					      	</template>
					    </el-table-column>



					    <el-table-column label="操作">
					    	<template slot-scope="scope">
					    		<el-button-group>
					    			<iconBtn iconClass="el-icon-edit" content="调整入库货位" @click="edit(scope.row)" ></iconBtn>    
					    		</el-button-group>		    		
					    	</template>
					    </el-table-column>




		</elemTable>
		<div slot="footer" class="dialog-footer">
		    <el-button @click="cancel">取 消</el-button>
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
			modalWidth:'80%',
      userinfo: local.get("userinfo"),


			searchForm:{
    		localCode:'',
				floorCode:'',
    	},

			floors : [],
		}
	},
	props: {
		modalShowUp: {
			default: false
		},
    tableRow: {
      default: {}
    }

	},
	mounted(){
		this.searchTable();	
		this.getAllFloors();
	},
	methods:{



		searchTable(){

     Object.assign(this.searchForm, {
        pageNum: this.pageNum,
        pageSize: this.pageSize
      });

				return this._ajax({
			        url: this.rootAPI,
			        name: "cigaretteEntry/localList",
			        param: this.searchForm,
			        loading: "dataLoading"
			    }).then(this.renderTable);
		},

  	reset(){
  		this.searchForm.localCode='';
			this.searchForm.floorCode='',
			this.searchTable()
  	},


		cancel(){
			this.$emit('close')
		},
		beforeClose(done) {
			this.cancel()
			done()
		},

		edit(row){
	    if (this.tableRow && this.tableRow.id > 0) {
		      var params = {};

						  debugger;

          var nowTime = moment(Date.parse(new Date())).format("YYYY-MM-DD HH:mm:ss");

          var entrytraylocalmap = {
            id:this.tableRow.id,   
            localId: row.localId,
            localCode: row.localCode,
            localRfid: row.localRfid,

            updatedDate: nowTime,
            updatedPersonId: this.userinfo.userId,
            updatedPerson: this.userinfo.nickName
            };

            
						var params = {'entrytraylocalmap' :JSON.stringify(entrytraylocalmap),  'originallocal' :JSON.stringify(this.tableRow.localId) };

            this._ajax({
              url: this.rootAPI,
              name: "cigaretteEntry/updateLocal",
              param: params
            }).then(
              (d => {
                if (d.state == 0) {
                  this.$message({ type: "success", message: "修改成功" });
                  this.$emit('refSearchTable');
                  this.cancel();                  
                } else {
                  this.$message({
                    type: "warning",
                    message: "修改失败" // + d.msg
                  });
                }
              }).bind(this)
            );
		}
	},

			 	/**
  	 * 获取楼层
  	 */
  	getAllFloors(){

			debugger;
  		var vm = this
		vm.floors = []
		return vm._ajax({
			url: vm.rootAPI, 
			name: 'floorinfo/queryfloorlist', 
			param: {}, 
			}).then((d) => {
				if(d.state === 0){
					var aaData = d.aaData
					aaData.forEach(function(el) {
						vm.floors.push({
							value: el.floorName,
  							key: el.floorCode
						})
					})	
				}
    		}, (d) => {
                this.$message.error('通道取失败');
            })
  	},
}
}
</script>