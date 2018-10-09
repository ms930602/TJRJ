<template>
	<div>
		<el-card class="box-card" style="margin-right: 5px; margin-left: 5px;" shadow="hover">
  <div slot="header" class="clearfix" >
    <span>盘点信息</span>
    <!-- <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button> -->
  </div>
	<div>
  <el-form class="modal-form" :inline="true" :model="form" :rules="rules" ref="form" label-width="120px">
      <el-row v-if="form.status == 0">
				<el-col :span="6">
	           <el-form-item label="盘点方式"  prop='inventMethod'>
		    			<selectInput :value.sync="form.inventMethod" placeHolder="请选择通道" style="width: 220px;">
						    <el-option 
						      v-for="item in methodStatus"
						      :key="item.key"
						      :label="item.value"
						      :value="item.key">
						    </el-option>
					  	</selectInput>
		      		</el-form-item>
				</el-col>
        <el-col :span="6">
              <el-form-item label="盘点区域"  prop='floorAreaCode'>
                  <selectInput :value.sync="form.floorAreaCode" placeHolder="请选择区域" style="width: 220px;">
                    <el-option 
                      v-for="item in floorinfoOption"
                      :key="item.key"
                      :label="item.value"
                      :value="item.key">
                    </el-option>
                  </selectInput>
              </el-form-item>
        </el-col>
        <el-col :span="6">
             <el-form-item label="是否复盘"  prop='reversion'>
              <selectInput :value.sync="form.reversion" placeHolder="请选择" style="width: 220px;">
                <el-option 
                  v-for="item in reversionStatus"
                  :key="item.key"
                  :label="item.value"
                  :value="item.key">
                </el-option>
              </selectInput>
              </el-form-item>
        </el-col>
			</el-row>
      <el-row v-if="(form.inventMethod == 1) && (form.status == 0)">
        <el-col :span="24">
            <el-form-item label="类型" prop="sex">
                <el-radio v-model="sex" label="1">手动选择</el-radio>
                <el-radio v-model="sex" label="0">自动选择</el-radio>
            </el-form-item>
        </el-col>
      </el-row>
      <el-row v-if="form.status != 0">
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
				<el-col :span="12">
	           <el-form-item label="备注"  prop='remark'>
		    		    <inputItem type="textarea" :rows="1" :maxlength="45" 
                :value.sync="form.remark" style="width: 220px;"
                :readonly="form.status != 0"
                ></inputItem>
		      	</el-form-item>
				</el-col>
        <el-col :span="12" v-if="sex == 0">
            <el-form-item label="盘点数量" prop="number">
                <el-input-number
                 v-model="form.number" style="width:220px" 
                 :min="1" :max="99999999" label="输入盘点数量"></el-input-number>
                </el-form-item>
        </el-col>
			</el-row>
	  </el-form>
		</div>
</el-card>
<el-card class="box-card" style="margin-right: 5px; margin-left: 5px; margin-top:10px; " shadow="hover">
  <div slot="header" class="clearfix">
    <span>盘点详情</span>
    <el-button type="primary" style="float:right;" @click="addMater" v-if="form.status == 0">添加调整物料</el-button>
  </div>
  <div>
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
			<el-table-column v-if="form.status != 0" prop="actualCountQuality" label="实盘点数量" width="250">
		    	<template slot-scope="scope">
            <toolTip :content="scope.row.actualCountQuality">
              <span>{{scope.row.actualCountQuality}}</span>
            </toolTip>
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
				  
	  		<div style="float: right;margin-top: 15px;line-height: 12px; margin-bottom:15px;">
  	  		<el-button @click="cancel('form')">取 消</el-button>
	  	    <el-button type="info" @click="save('form',0)" v-if="form.status == 0">保存为草稿</el-button>
	  	    <el-button type="primary" @click="save('form',1)" v-if="form.status == 0">确 定(生成盘点单)</el-button>
	  	</div>
	</div>

</el-card>      
	  <selectInventorytraylocalPageModel  v-if="modalShow"  @close="modalClose" :modalShowlocal='modalShow' @selectList="selectList" :srow="serow" :localCodeNow="form.floorAreaCode"></selectInventorytraylocalPageModel>
	  </div>
</template>

<script>
import mixin from "../../mixin/mixin.js";
import local from "../../local.js";
import configs from "../../configs.js";
import selectInventorytraylocalPageModel from "../component/modal/selectInventorytraylocalPageModel.vue";
export default {
  mixins: [mixin],
  components: { selectInventorytraylocalPageModel },
  data() {
    return {
      regLocalCode: {
        baseText: "",
        _regEx(s) {
          return "|" + s + "|";
        },
        add(s) {
          this.baseText += this._regEx(s);
        },
        remove(s) {
          var re = this._regEx(s);
          this.baseText = this.baseText.replace(re, "");
        },
        test(s) {
          //存在为真 不存在为假
          var re = this._regEx(s);
          if (this.baseText.indexOf(re) == -1) {
            return false;
          }
          return true;
        }
      },
      regTestDestLocalCode: "",
      openLocalToTemp: null,
      dicDetailStatus: [],
      methodStatus: [], //盘点方式
      mainEnable: [],
      types: [],
      reversionStatus: [{ key: 0, value: "否" }, { key: 1, value: "是" }],
      floorinfoOption: [],
      localCodeNow: "125",
      serow: [],
      modalShow: false,
      modalLocationInfoShow: false,
      sex: "1",
      number: 1,
      form: {
        id: null,
        inventMethod: "1",
        floorAreaCode: "",
        reversion: 1,
        status: "",
        remark: "",
        detail: [],
        deleteObj: [],
        number: 1
      },
      userinfo: local.get("userinfo"),
      rules: {
        number: [this._ruleRequired("盘点数量")]
      }
    };
  },
  mounted() {
    var id = this.$route.query.id;
    if (id) {
      this.form.id = id;
      this.searchObject();
    } else {
      this.form.id = null;
    }
    this.searchFloorinfoOption();
    this._searchDic("METHOD_STATUS").then(
      function(d) {
        this.methodStatus = this._dicKey(d);
      }.bind(this)
    );
    this._searchDic("S_CHECK_STATUS").then(
      function(d) {
        this.dicDetailStatus = this._dicKey(d);
      }.bind(this)
    );

    this._searchDic("S_CHECK_MAIN").then(
      function(d) {
        this.mainEnable = this._dicKey(d);
      }.bind(this)
    );
    this._searchDic("MATERIAL_TYPE").then(
      function(d) {
        this.types = this._dicKey(d);
      }.bind(this)
    );
  },
  methods: {
    autoObject(size) {
      var _this = this;
      var searchForm = {
        floorAreaCode: _this.form.floorAreaCode,
        pageNum: 1,
        pageSize: size
      };
      this._ajax({
        url: this.rootAPI + "positionadjustmain/queryInventorytraylocalPage",
        param: searchForm
      }).then(
        function(d) {
          if (d.state === 0) {
            this.selectList(d.aaData);
          } else {
            this.$message({ type: "error", message: "服务器错误!" });
          }
        }.bind(this)
      );
    },
    searchObject() {
      var queryId = this.form.id;
      var _this = this;
      this._ajax({
        url: this.rootAPI + "stockcheckmain/queryFormById",
        param: { id: queryId }
      }).then(
        function(d) {
          if (d.state === 0) {
            Object.assign(this.form, d.aaData);
            this.form.inventMethod = this.form.inventMethod + "";
            this.form.detail.forEach(temp => {
              _this.regLocalCode.add(temp.localCode);
            });
          } else {
            this.$message({ type: "error", message: "服务器错误!" });
          }
        }.bind(this)
      );
    },
    delRow(index) {
      var id = this.form.detail[index].id;
      var localCode = this.form.detail[index].localCode;
      this.regLocalCode.remove(localCode);
      this.form.detail.splice(index, 1);
      if (id && id > 0) {
        if (!this.form.deleteObj) this.form.deleteObj = [];
        this.form.deleteObj.push(id);
      }
    },
    modalClose() {
      this.modalShow = false;
    },
    modalCloseB() {
      this.modalLocationInfoShow = false;
    },
    selectLocalCode(row) {
      this.openLocalToTemp = row;
      this.modalLocationInfoShow = true;
    },
    searchFloorinfoOption() {
      var vm = this;
      vm.floorinfoOption = [];
      return vm
        ._ajax({
          url: vm.rootAPI,
          name: "areainfo/queryarealist"
        })
        .then(
          d => {
            if (d.state === 0) {
              var aaData = d.aaData;
              aaData.forEach(function(el) {
                vm.floorinfoOption.push({
                  value: el.floorAreaCode,
                  key: el.floorAreaCode
                });
              });
              if (aaData.length > 0) {
                vm.form.floorAreaCode = aaData[0].floorAreaCode;
              }
            }
          },
          d => {
            this.$message.error("通道取失败");
          }
        );
    },
    selectreplace(row) {
      this.openLocalToTemp.destLocalCode = row.localCode;
    },
    selectList(tableArr) {
      this.serow = tableArr;
      if (tableArr && tableArr.length > 0) {
        for (var i = 0; i < tableArr.length; i++) {
          if (!this.regLocalCode.test(tableArr[i].localCode)) {
            this.regLocalCode.add(tableArr[i].localCode);
            this.form.detail.push({
              id: null,
              actualCountQuality: null,
              status: "0",
              soleCode: tableArr[i].soleCode,
              materCode: tableArr[i].materCode,
              subverName:tableArr[i].subverName,
              subverId:tableArr[i].subverId,
              materName: tableArr[i].materName,
              materVersion: tableArr[i].materVersion,
              localDescript:tableArr[i].descript,
              localCode: tableArr[i].localCode,
              batchNo: tableArr[i].batchNo, //1
              inventQuality: tableArr[i].quality, //2
              floorAreaCode: tableArr[i].floorAreaCode,
              trayCode: tableArr[i].trayCode,
              cigtype: tableArr[i].cigtype
            });
          } else {
            this.$message({ type: "danger", message: "重复信息已清除!" });
          }
        }
      }
    },
    addMater() {
      var type = this.form.inventMethod;
      var sex = this.sex;
      if (type == 0) {
        //全面盘点
        this.form.detail.length = 0;
        this.regLocalCode.baseText = "";
        this.autoObject(10000);
      } else {
        //抽样盘点
        if (sex == 0) {
          //抽样-》自动选择
          this.form.detail.length = 0;
          this.regLocalCode.baseText = "";
          this.autoObject(this.form.number);
        } else {
          this.modalShow = true;
        }
      }
    },
    cancel() {
      this.$router.push({ path: "/stockinventory" });
    },
    save(formname, pstatus) {
      if (!this.form.detail || this.form.detail.length == 0) {
        this.$message({ type: "error", message: "无盘点详细信息" });
        return;
      }
      this.$refs[formname].validate(valid => {
        if (valid) {
          if (this.form.id) {
            Object.assign(this.form, {
              status: pstatus
            });
          } else {
            Object.assign(this.form, {
              status: pstatus,
              createdPersonId: this.userinfo.userId,
              createdPerson: this.userinfo.nickName
            });
          }

          var params = { formData: JSON.stringify(this.form) };
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
    }
  }
};
</script>

<style>


</style>