<template>
		<el-dialog custom-class="jz-modal" :title="modaltype === 'add' ? '新增通道' : '编辑通道'" :visible="modalshow"  :before-close="beforeClose" :width="modalWidth" :close-on-click-modal="false">
		  	<el-form class="modal-form" :inline="true" :model="form" :rules="rules" ref="form" label-width="100px">
          <el-row>
            <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
            <el-form-item label="楼层区域"  prop='areaId'>
		   	 		<selectInput :value.sync="form.areaId" @selectChange='areaIdchange'>
						<el-option
							v-for="item in areaoptions"
							:key="item.key"
							:label="item.label"
							:value="item.value">
						</el-option>
					</selectInput>
		    	</el-form-item>
            </el-col>
            <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
             <el-form-item label="区域块"  prop='areaBlock'>
               <el-input-number v-model="form.areaBlock" controls-position="right" :min="1" :max="100" label="区域块" @change="checklocalCode"></el-input-number>
		    		<!-- <inputItem :value.sync="form.areaBlock" :maxlength="10" ></inputItem> -->
		      	</el-form-item>
            </el-col>
          </el-row>
           <el-row>
            <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
            <el-form-item label="区域排"  prop='areaRow'>
              <el-input-number v-model="form.areaRow"  controls-position="right" :min="1" :max="100" label="区域排" @change="checklocalCode"></el-input-number>
		    		<!-- <inputItem :value.sync="form.areaRow" :maxlength="10" @change="checklocalCode"></inputItem> -->
		      	</el-form-item>
            </el-col>
            <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
            <el-form-item label="区域号"  prop='areaNum'>
              <el-input-number v-model="form.areaNum" controls-position="right" :min="1" :max="100" label="区域号" @change="checklocalCode"></el-input-number>
		    		<!-- <inputItem :value.sync="form.areaNum" :maxlength="10" @change="checklocalCode"></inputItem> -->
		      	</el-form-item>
            </el-col>
          </el-row>
           <el-row>
            <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
	         <el-form-item label="上下层"  prop='upDown'>
	                <selectInput :value.sync="form.upDown" @selectChange='checklocalCode'>
						<el-option
							v-for="item in upDownoptions"
							:key="item.key"
							:label="item.value"
							:value="item.key">
						</el-option>
					</selectInput>
		      	</el-form-item>
            </el-col>
            <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
            <el-form-item label="RFID编号"  prop='localRfid'>
		    		<inputItem :value.sync="form.localRfid" :maxlength="10"></inputItem>
		      	</el-form-item>
            </el-col>
          </el-row>
           <el-row>
            <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
	          <el-form-item label="货位编码"  prop='localCode'>
		    		<inputItem :value.sync="form.localCode" readonly ></inputItem>
		      	</el-form-item>
            </el-col>
            <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
            <el-form-item label="货位描述"  prop='descript'>
	    			<inputItem type='textarea'  :rows="2" :value.sync="form.descript" :maxlength="100"></inputItem>
	      		</el-form-item>
            </el-col>
          </el-row>
		  	</el-form>
		  <div slot="footer" class="dialog-footer">
		    <el-button @click="cancel('form')">取 消</el-button>
		    <el-button type="primary" @click="save('form')">确 定</el-button>
		  </div>
		</el-dialog>
</template>
<script>
import mixin from "../../../mixin/mixin.js";
import local from "../../../local.js";
import configs from "../../../configs.js";
export default {
  mixins: [mixin],
  data() {
    return {
      areaoptions: [],
      upDownoptions: [],
      form: {
        id: null,
        floorAreaCode: "",
        areaId: "",
        areaBlock:"",
        areaRow: "",
        areaNum: "",
        upDown: "1",
        localCode: "",
        localRfid: "",
        descript: ""
      },
      userinfo: local.get("userinfo"),
      rules: {
        areaId: [this._ruleRequired("区域编号")],
        areaBlock: [this._ruleRequired("区域块")],
        areaRow: [this._ruleRequired("区域排")],
        areaNum: [this._ruleRequired("区域号")],
        upDown: [this._ruleRequired("上下层")],
        localCode: [
          this._ruleExist(
            configs.rootAPI + "locationinfo/checklocationcode",
            "货位编码",
            this.tableRow
          )
        ],
        localRfid: [
          {
            validator: function(rule, value, callback) {
              let obj = { localRfid: value };
              if (this.tableRow.localRfid === value) {
                callback();
              } else {
                this._ajax({
                  url: this.rootAPI + "locationinfo/checkRFID",
                  param: obj
                }).then(function(d) {
                  if (d.state === 0 && d.aaData === 2) {
                    callback(
                      new Error(
                        name + "RFID编码已存在2个重复编码 请修改该RFID编码"
                      )
                    );
                  } else {
                    callback();
                  }
                });
              }
            }.bind(this),
            trigger: "blur"
          }
        ]
      }
    };
  },
  props: {
    modaltype: {
      default: "add"
    },
    tableRow: {
      default: {}
    },
    modalshow: {
      default: false
    }
  },
  computed: {},
  mounted() {
    console.log(this.tableRow);
    this.getareainfo();
    this.getupdown();
    if (this.modaltype != "add") {
      Object.assign(this.form, this.tableRow);
    }
  },
  methods: {
    areaIdchange() {
      /**
       * 根据获取的areaId  获取楼层编码
       */
      var vm = this;
      console.log(vm.form.areaId);
      return vm
        ._ajax({
          url: vm.rootAPI,
          name: "areainfo/queryfloorcodebyareaid",
          param: { id: vm.form.areaId }
        })
        .then(
          d => {
            if (d.state == 0) {
              vm.form.floorAreaCode = d.aaData.floorAreaCode;
              vm.checklocalCode();
            }
          },
          d => {
            this.$message.error("区域数据获取失败");
          }
        );
    },
    checklocalCode() {
      var vm = this;
      vm.form.localCode =
        vm.form.floorAreaCode +
        "-" +
        this._fill(vm.form.areaBlock,2)+
        this._fill(vm.form.areaRow,2)+
        this._fill(vm.form.areaNum,2)+
        this._fill(vm.form.upDown,2);
    },
    /**
     * 获取区域
     */
    getareainfo() {
      var vm = this;
      vm.areaoptions = [];
      return vm
        ._ajax({
          url: vm.rootAPI,
          name: "areainfo/queryarealist",
          param: {}
        })
        .then(
          d => {
            console.log(d);
            if (d.state === 0) {
              var aaData = d.aaData;
              aaData.forEach(function(el) {
                vm.areaoptions.push({
                  value: el.id,
                  label: el.floorAreaCode
                });
              });
            }
          },
          d => {
            this.$message.error("区域数据获取失败");
          }
        );
    },
    /**
     * 获取状态
     */
    getupdown() {
      return this._searchDic("UPDOWN").then(
        function(d) {
          this.upDownoptions = this._dicKey(d);
        }.bind(this)
      );
    },
    cancel() {
      this.$emit("close");
    },
    save(formname) {
      this.$refs[formname].validate(valid => {
        if (valid) {
          if (this.tableRow && this.tableRow.id > 0) {
            //编辑
            Object.assign(this.form, {
              updatedPersonId: this.userinfo.userId,
              updatedPerson: this.userinfo.nickName
            });
            this._ajax({
              url: this.rootAPI,
              name: "locationinfo/update",
              param: this.form
            }).then(
              (d => {
                if (d.state == 0) {
                  this.$message({ type: "success", message: "保存成功" });
                  this.$emit("submit");
                } else {
                  this.$message({
                    type: "warning",
                    message: "保存失败" // + d.msg
                  });
                }
              }).bind(this)
            );
          } else {
            //新增
            Object.assign(this.form, {
              status: 0,
              createdPersonId: this.userinfo.userId,
              createdPerson: this.userinfo.nickName
            });
            this._ajax({
              url: this.rootAPI,
              name: "locationinfo/create",
              param: this.form
            }).then(
              (d => {
                if (d.state == 0) {
                  this.$message({ type: "success", message: "保存成功" });
                  this.$emit("submit");
                } else {
                  this.$message({
                    type: "warning",
                    message: "保存失败" // + d.msg
                  });
                }
              }).bind(this)
            );
          }
        } else {
          return false;
        }
      });
    },
    beforeClose(done) {
      this.cancel();
      done();
    }
  }
};
</script>