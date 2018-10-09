<template>
	<div>
		<h6>&nbsp;&nbsp;盘点信息</h6>
		<hr/>
		<el-form class="modal-form" :inline="true" :model="form" :rules="rules" ref="form" label-width="120px">
      <el-row >
        <el-col :span="6">
          <el-form-item label="盘点单号"  prop='orderNumber'>
            {{form.orderNumber}}
              </el-form-item>
        </el-col>
				<el-col :span="6">
	              	<el-form-item label="开始时间"  prop='inventStartDate'>
	              	{{form.inventStartDate}}
		      		</el-form-item>
				</el-col>
				<el-col :span="6">
                  <el-form-item label="结束时间"  prop='inventEndDate'>
		    		{{form.inventEndDate}}
		      	  </el-form-item>
				</el-col>
				<el-col :span="6">
					<el-form-item label="状态"  prop='status'>
		    		{{_dicValue(form.status, mainEnable)}}
		      	  </el-form-item>
				</el-col>
			</el-row>
	  		<el-row >
				<el-col :span="6">
	           <el-form-item label="备注"  prop='remark'>
		    		    <inputItem type="textarea" :rows="1" :maxlength="45" 
                :value.sync="form.remark" style="width: 220px;"
                readonly
                ></inputItem>
		      	</el-form-item>
				</el-col>
			</el-row>
	  </el-form>
	  <h6>&nbsp;&nbsp;盘点详细</h6>
	  <el-button type="primary" style="float:right;margin-top:-11px" @click="addMater" v-if="form.status == 0">添加 调整物料</el-button>
      <hr/>
       <elemTable ref="asdas" :dataList="form.detail" :isShowPage="false">
		    <el-table-column prop="materCode" label="物料编码">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.materCode">
		    			<span>{{scope.row.materCode}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="materName" label="物料名称">
		    	<template slot-scope="scope">
					<toolTip :content="scope.row.materName">
		    			<span>{{scope.row.materName}}</span>
		    		</toolTip>
			    </template>
		    </el-table-column>
        <el-table-column prop="cigtype" label="物料类型">
          <template slot-scope="scope">
          <toolTip :content="_dicValue(scope.row.cigtype,types)">
              <span>{{_dicValue(scope.row.cigtype,types)}}</span>
            </toolTip>
          </template>
        </el-table-column>
		     <el-table-column prop="materVersion" label="物料版本">
		    	<template slot-scope="scope">
					<toolTip :content="scope.row.materVersion">
		    			<span>{{scope.row.materVersion}}</span>
		    		</toolTip>
			    </template>
		    </el-table-column>
        <el-table-column prop="subverName" label="小版本">
          <template slot-scope="scope">
          <toolTip :content="scope.row.subverName">
              <span>{{scope.row.subverName}}</span>
            </toolTip>
          </template>
        </el-table-column>
		    <el-table-column prop="localDescript" label="货位描述">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.localDescript">
		    			<span>{{scope.row.localDescript}}</span>
		    		</toolTip>
			    </template>
		    </el-table-column>
		    <el-table-column prop="batchNo" label="批次号" width="220">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.batchNo">
		    			<span>{{scope.row.batchNo}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="inventQuality" label="库存数量" width="220">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.inventQuality">
		    			<span>{{scope.row.inventQuality}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
			<el-table-column prop="actualCountQuality" label="实盘点数量" width="250">
		    	<template slot-scope="scope">
            <el-input-number
             v-model="scope.row.actualCountQuality" style="width:150px" 
             :min="1" :max="99999999" label="实际数量"></el-input-number>
		      </template>
		    </el-table-column>
		    <el-table-column prop="complitDate" label="状态">
		    	<template slot-scope="scope">
		    		<tagItem :type="scope.row.status == 1 ? 'success' : 'danger'" 
		    		:text="_dicValue(scope.row.status, dicDetailStatus)"></tagItem>
		      	</template>
		    </el-table-column>
		</elemTable> 
	  <el-container>
	  	<el-footer>
	  		<div style="float: right;">
  	  		<el-button @click="cancel('form')">取 消</el-button>
	  	    <el-button type="primary" @click="save('form')">提 交(结束盘点单)</el-button>
	  	</div>
	  	</el-footer>
	  </el-container>
	  <selectInventorytraylocalPageModel  v-if="modalShow"  @close="modalClose" :modalShowlocal='modalShow' @selectList="selectList" :srow="serow" :localCodeNow="form.floorAreaCode"></selectInventorytraylocalPageModel>
	  </div>
</template>

<script>
	import mixin from '../../mixin/mixin.js'
	import local from '../../local.js'
	import configs from "../../configs.js";
	import selectInventorytraylocalPageModel from "../component/modal/selectInventorytraylocalPageModel.vue";
export default {
  mixins: [mixin],
  components: {selectInventorytraylocalPageModel},
  data() {
    return {
      regLocalCode:{
      	baseText:'',
      	_regEx(s){
      		return "|" + s + "|";
      	},
      	add(s){
  		    this.baseText += this._regEx(s);
      	},
      	remove(s){
      		var re = this._regEx(s);
  		    this.baseText = this.baseText.replace(re,"")
      	},
      	test(s){//存在为真 不存在为假
			var re = this._regEx(s);
	  		if(this.baseText.indexOf(re) == -1){
	  			return false;
	  		}
	  		return true;
      	}
  	  },
      regTestDestLocalCode:'',
      openLocalToTemp:null,
      dicDetailStatus:[],
      methodStatus:[],//盘点方式
      mainEnable:[],
      types:[],
      floorinfoOption:[],
      localCodeNow:'125',
      serow:[],
      modalShow:false,
      modalLocationInfoShow:false,
      form: {
        id:null,
        inventMethod:"1",
        sex:"1",
        floorAreaCode:'',

    		status:'',
    		remark:'',
    		detail:[],
    		deleteObj:[],
      },
      userinfo: local.get("userinfo"),
      rules: {}
    };
  },
  mounted() {
  	var id = this.$route.query.id;
  	if(id){
  		this.form.id = id;
  		this.searchObject();
  	}else
  	{
  		this.form.id = null;
  	}
  	this.searchFloorinfoOption();
  	this._searchDic('METHOD_STATUS')
			.then((function(d) {
				this.methodStatus = this._dicKey(d)
			}).bind(this))
    this._searchDic('S_CHECK_STATUS')
      .then((function(d) {
        this.dicDetailStatus = this._dicKey(d)
        console.log(this.dicDetailStatus)
      }).bind(this))
      
	this._searchDic('IS_POS_STATUS')
			.then((function(d) {
				this.mainEnable = this._dicKey(d)
			}).bind(this))
      this._searchDic('MATERIAL_TYPE')
      .then((function(d) {
        this.types = this._dicKey(d)
      }).bind(this))
  },
  methods: {
  	searchObject(){
  		var queryId = this.form.id;
  		var _this = this;
  		this._ajax({url: this.rootAPI + 'stockcheckmain/queryFormById', param: {id:queryId}})
        .then((function(d) {
            if(d.state === 0) {
              Object.assign(this.form,d.aaData)
              this.form.inventMethod = this.form.inventMethod + "";
              this.form.detail.forEach(temp=>{
              	_this.regLocalCode.add(temp.localCode);
              });
            }else
            {
              this.$message({ type: "error", message: "服务器错误!" });
            }
        }).bind(this))
  	},
  	delRow(index){
  		var id = this.form.detail[index].id;
  		var localCode = this.form.detail[index].localCode;
  		this.regLocalCode.remove(localCode);
  		this.form.detail.splice(index, 1);
  		if(id && id > 0){
  			if(!this.form.deleteObj)this.form.deleteObj = [];
  			this.form.deleteObj.push(id);
  		}
  	},
  	modalClose(){
  		this.modalShow = false;
  	},
  	modalCloseB(){
  		this.modalLocationInfoShow = false;
  	},
  	selectLocalCode(row){
  		this.openLocalToTemp = row;
  		this.modalLocationInfoShow = true;
  	},
  	searchFloorinfoOption(){
  		var vm = this
		vm.floorinfoOption = []
		return vm._ajax({
			url: vm.rootAPI, 
			name: 'areainfo/queryarealist', 
			}).then((d) => {
				if(d.state === 0){
					var aaData = d.aaData
					aaData.forEach(function(el) {
						vm.floorinfoOption.push({
							value: el.floorAreaCode,
								key: el.floorAreaCode
						})
					})
					if(aaData.length > 0){
						vm.form.floorAreaCode = aaData[0].floorAreaCode;
					}
				}
			}, (d) => {
	            this.$message.error('通道取失败');
	        })
  	},
  	selectreplace(row){
  		this.openLocalToTemp.destLocalCode = row.localCode;
  	},
  	selectList(tableArr){
  		this.serow = tableArr;
  		if(tableArr && tableArr.length > 0)
  		{
  			for (var i = 0; i < tableArr.length; i++) {
  				if(!this.regLocalCode.test(tableArr[i].localCode)){
  					this.regLocalCode.add(tableArr[i].localCode);
	  				this.form.detail.push({
	  					id:null,
              actualCountQuality:null,
		  				status:'0',
              soleCode:tableArr[i].soleCode,
              materCode:tableArr[i].materCode,
              materName:tableArr[i].materName,
              materVersion:tableArr[i].materVersion,
              localCode:tableArr[i].localCode,
              localDescript:tableArr[i].descript,
              batchNo:tableArr[i].batchNo,//1
              inventQuality:tableArr[i].quality,//2
              floorAreaCode:tableArr[i].floorAreaCode,
              trayCode:tableArr[i].trayCode
		  			});
  				}else{
  					this.$message({ type: "danger", message: "重复信息已清除!" });
  				}
  			}
  		}
  		
  	},
  	addMater(){
  		this.modalShow = true;
  	},
    cancel() {
    	this.$router.push({path:"/stockinventory"});
    },
    save(formname) {
      if(!this.form.detail || this.form.detail.length == 0)
      {
      	this.$message({ type: "error", message: "无盘点详细信息" });
      	return;
      }
      this.$refs[formname].validate(valid => {
        if (valid) {
          Object.assign(this.form, {
            status: 3,
            inventor: this.userinfo.nickName
          });
          this.form.detail.forEach(e=>{
            e.inventory = this.userinfo.nickName;
            e.inventoryId = this.userinfo.userId;
          })
            var params = {"formData":JSON.stringify(this.form)};
            this._ajax({
              url: this.rootAPI,
              name: "stockcheckmain/formAction",
              param: params
            }).then(
              (d => {
                if (d.state == 0) {
                  this.$message({ type: "success", message: "保存成功" });
                  this.cancel();
                } else {
                  this.$message({
                    type: "warning",
                    message: "保存失败" // + d.msg
                  });
                }
              }).bind(this)
            );
        } else {
          return false;
        }
      });
    },
  }
};
</script>

<style>
</style>