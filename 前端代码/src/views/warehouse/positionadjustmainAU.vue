<template>
	<div>
  <el-card class="box-card" style="margin-right: 5px; margin-left: 5px;" shadow="hover">

		<h6>&nbsp;&nbsp;调整单信息</h6>
		<hr/>
		<el-form class="modal-form" :inline="true" :model="form" :rules="rules" ref="form" label-width="120px">
            <el-row v-if="form.status == 0">
				<el-col :span="24">
	              	<el-form-item label="楼层"  prop='floorCode'>
		    			<selectInput :value.sync="form.floorCode" filterable placeHolder="请选择通道" style="width: 220px;">
						    <el-option 
						      v-for="item in floorinfoOption"
						      :key="item.value"
						      :label="item.label"
						      :value="item.value">
						    </el-option>
					  	</selectInput>
		      		</el-form-item>
				</el-col>
			</el-row>
            <el-row v-if="form.status != 0">
				<el-col :span="6">
	              	<el-form-item label="楼层编号"  prop='floorCode'>
	              	{{form.floorCode}}
		      		</el-form-item>
				</el-col>
				<el-col :span="6">
                  <el-form-item label="楼层名称"  prop='floorName'>
		    		{{form.floorName}}
		      	  </el-form-item>
				</el-col>
				<el-col :span="6">
					<el-form-item label="状态"  prop='status'>
		    		{{_dicValue(form.status, mainEnable)}}
		      	  </el-form-item>
				</el-col>
				<el-col :span="6">
					<el-form-item label="完成时间"  prop='complitDate'>
		    		{{form.complitDate}}
		      	  </el-form-item>
				</el-col>
			</el-row>
	  		<el-row v-if="form.status == 0">
				<el-col :span="24">
	              <el-form-item label="备注"  prop='remark'>
		    		<inputItem type="textarea" :rows="1" :maxlength="45" :value.sync="form.remark" style="width: 220px;"></inputItem>
		      	</el-form-item>
				</el-col>
			</el-row>
	  </el-form>
  </el-card>
  <el-card class="box-card" style="margin-right: 5px; margin-left: 5px; margin-top:10px; " shadow="hover">
    <div slot="header" class="clearfix">
      <h6>&nbsp;&nbsp;货位调整</h6>
      <el-button type="primary" style="float:right;margin-top:-11px" @click="addMater" v-if="form.status == 0">添加 调整物料</el-button>
    </div>
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
            <toolTip :content="scope.row.cigtype">
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
          <el-table-column prop="materCigbrand" label="物料品牌">
            <template slot-scope="scope">
              <toolTip :content="scope.row.materCigbrand">
                <span>{{scope.row.materCigbrand}}</span>
              </toolTip>
            </template>
          </el-table-column>
          <el-table-column prop="origLocalDescript" label="原货位描述" width="200">
            <template slot-scope="scope">
              <toolTip :content="scope.row.origLocalDescript">
                <span>{{scope.row.origLocalDescript}}</span>
              </toolTip>
              </template>
          </el-table-column>
        <el-table-column prop="destLocalCode" label="目的货位" width="250">
            <template slot-scope="scope">
              <el-input v-model="scope.row.destLocalCode" placeholder="选择内容信息" style="width:150px"
              readonly></el-input>
              <span><el-button @click="selectLocalCode(scope.row)" v-if="form.status == 0">...</el-button></span>
              </template>
          </el-table-column>
          <el-table-column prop="complitDate" label="状态">
            <template slot-scope="scope">
              <tagItem :type="scope.row.status == 1 ? 'success' : 'danger'" 
              :text="_dicValue(scope.row.status, dicPersonEnable)"></tagItem>
              </template>
          </el-table-column>
          <el-table-column label="操作" v-if="form.status == 0">
            <template slot-scope="scope">
              <el-button-group>
                <iconBtn iconClass="el-icon-minus" content="删除" @click="delRow(scope.$index)">
              </iconBtn>
              </el-button-group>            
            </template>
          </el-table-column>
      </elemTable> 
  </el-card>
  <el-container>
  	<el-footer>
  		<div style="float: right;">
  	  		<el-button @click="cancel('form')">取 消</el-button>
	  	    <el-button type="info" @click="save('form',0)" v-if="form.status == 0">保存为草稿</el-button>
	  	    <el-button type="primary" @click="save('form',1)" v-if="form.status == 0">确 定(生成调整单)</el-button>
	  	</div>
  	</el-footer>
  </el-container>
  <selectInventorytraylocalPageModel  v-if="modalShow"  @close="modalClose" :modalShowlocal='modalShow' @selectList="selectList" :srow="serow" :floorCode="form.floorCode"></selectInventorytraylocalPageModel>
  <selectLocationInfoModel  v-if="modalLocationInfoShow"  @close="modalCloseB" :modalShowlocal='modalLocationInfoShow' @selectreplace="selectreplace" :srow="serow" :floorCode="form.floorCode"></selectLocationInfoModel>
  </div> 
</template>

<script>
	import mixin from '../../mixin/mixin.js'
	import local from '../../local.js'
	import configs from "../../configs.js";
	import selectInventorytraylocalPageModel from "../component/modal/selectInventorytraylocalPageModel.vue";
	import selectLocationInfoModel from "../component/modal/selectLocationInfoModel.vue";
export default {
  mixins: [mixin],
  components: {selectInventorytraylocalPageModel,selectLocationInfoModel},
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
      dicPersonEnable:[],
      types:[],
      mainEnable:[],
      floorinfoOption:[],
      localCodeNow:'125',
      serow:[],
      modalShow:false,
      modalLocationInfoShow:false,
      form: {
        id:null,
        floorCode:'',
		floorName:'',
		status:'',
		complitDate:'',
		remark:'',
		detail:[],
		deleteObj:[],
      },
      userinfo: local.get("userinfo"),
      rules: {
        floorCode: [
          	this._ruleRequired("楼层编号") ]
      }
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
  	this._searchDic('IS_POS_DETAIL')
			.then((function(d) {
				this.dicPersonEnable = this._dicKey(d)
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
  	setFloorName(){
  		var code = this.form.floorCode;
  		var name = '';
  		this.floorinfoOption.forEach(e=>{
  			if(e.value == code)
  			{
  				name = e.label;
  			}
  		});
  		this.form.floorName = name;
  	},
  	searchObject(){
  		var queryId = this.form.id;
  		var _this = this;
  		this._ajax({url: this.rootAPI + 'positionadjustmain/queryFormById', param: {id:queryId}})
        .then((function(d) {
            if(d.state === 0) {
              Object.assign(this.form,d.aaData)
              this.form.detail.forEach(temp=>{
              	_this.regLocalCode.add(temp.origLocalCode);
              });
            }else
            {
              this.$message({ type: "error", message: "服务器错误!" });
            }
        }).bind(this))
  	},
  	delRow(index){
  		var id = this.form.detail[index].id;
  		var origLocalCode = this.form.detail[index].origLocalCode;
  		this.regLocalCode.remove(origLocalCode);
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
			name: 'floorinfo/list', 
			param: {orderField:'f_floor_code'}, 
			}).then((d) => {
				if(d.state === 0){
					var aaData = d.aaData
					aaData.forEach(function(el) {
						vm.floorinfoOption.push({
							value: el.floorCode,
								label: el.floorName
						})
					})
					if(aaData.length > 0){
						vm.form.floorCode = aaData[0].floorCode;
						vm.form.floorName = aaData[0].floorName;
					}
				}
			}, (d) => {
	            this.$message.error('通道取失败');
	        })
  	},
  	selectreplace(row){
      if(this.openLocalToTemp.origLocalCode == row.localCode){
        this.$message.error('与原货位相同，无需调整!');
        return;
      }
  		this.openLocalToTemp.destLocalCode = row.localCode;
      this.openLocalToTemp.destLocalDescript = row.descript;
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
		  				origTrayRfid:tableArr[i].trayRfid,
		  				origLocalCode:tableArr[i].localCode,
		  				operator:this.userinfo.nickName,
		  				operatorId:this.userinfo.userId,
              origLocalDescript:tableArr[i].descript,
              subverName:tableArr[i].subverName,
              subverId:tableArr[i].subverId,
		  				materCode:tableArr[i].materCode,
		  				materName:tableArr[i].materName,
		  				materVersion:tableArr[i].materVersion,
		  				materCigbrand:tableArr[i].materCigbrand,
		  				soleCode:tableArr[i].soleCode,
		  				trayCode:tableArr[i].trayCode,
              cigtype:tableArr[i].cigtype,
		  				destLocalCode:'',
		  				status:'0'
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
    	this.$router.push({path:"/positionadjustmain"});
    },
    save(formname,pstatus) {
    	var _this = this;
    	var regLocalCodes = "";
    	var tempCode;
      if(!this.form.detail || this.form.detail.length == 0)
      {
      	this.$message({ type: "error", message: "无货位调整" });
      	return;
      }

      this.form.detail.forEach(temp=>{
          if(!temp.destLocalCode || temp.destLocalCode == null){
          	_this.$message({ type: "error", message: "目的货位不能为空!" });
      		return;
          }
          if(regLocalCodes.indexOf(temp.destLocalCode) > -1)
          {
          	_this.$message({ type: "error", message: "目的货位重复!" });
      		return;
          }
          regLocalCodes = regLocalCodes + "|"+ temp.destLocalCode +"|";
      });
      this.$refs[formname].validate(valid => {
        if (valid) {
          this.setFloorName();
          //新增
          console.log(this.form.id)
          if(this.form.id){
            Object.assign(this.form, {
              status: pstatus,
              updatedPersonId: this.userinfo.userId,
              updatedPerson: this.userinfo.nickName
            });
          }else{
            Object.assign(this.form, {
              status: pstatus,
              createdPersonId: this.userinfo.userId,
              createdPerson: this.userinfo.nickName
            });
          }
            
            var params = {"formData":JSON.stringify(this.form)};
            this._ajax({
              url: this.rootAPI,
              name: "positionadjustmain/formAction",
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