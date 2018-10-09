<template>
		<el-dialog custom-class="jz-modal" :title="modaltype === 'add' ? '新增区域' : '编辑区域'" :visible="modalshow"  :before-close="beforeClose" :width="modalWidth" :close-on-click-modal="false">
			<el-form class="modal-form" :inline="true" :model="form" :rules="rules" ref="form" label-width="100px">
	            <el-form-item label="区域编码" label-width="120px"  prop='areaCode'>
		      		<inputItem :value.sync="form.areaCode" :maxlength="10" @change="inputChange"></inputItem>
		    	</el-form-item>
		   	 	<el-form-item label="楼层" label-width="120px"  prop='floorId'>
		      		<selectInput :value.sync="form.floorId" filterable placeHolder="请选择" @selectChange='selectChange'>
					    <el-option 
					      v-for="item in floormodelOptions"
					      :key="item.value"
					      :label="item.label"
					      :value="item.value">
					    </el-option>
				  	</selectInput>
		    	</el-form-item>
		    	<el-form-item label="楼层区域编码" label-width="120px" prop='floorAreaCode'>
			      		<inputItem :value.sync="form.floorAreaCode" readonly></inputItem>
			   	 	</el-form-item>
		   	 	<el-form-item label="备注" label-width="120px" prop='remark'>
		      		<inputItem type="textarea" :rows="2" :maxlength="45" :value.sync="form.remark" ></inputItem>
		   	 	</el-form-item>
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
      form: {
        id: null,
        areaCode: "",
        floorId: "",
        floorAreaCode: "",
        remark: ""
      },
      modalWidth: "30%",
      floormodelOptions: [],
      userinfo: local.get("userinfo"),
      rules: {
        floorId: [this._ruleRequired("区域名称")],
        areaCode: [
          this._ruleRequired("区域编号"),
          this._ruleReg(/^[0-9a-zA-Z]+$/, "请填写字母与数字的组合"),
          this._ruleExist(
            configs.rootAPI + "areainfo/checkareaCode",
            "区域编号",
            this.tableRow
          )
        ]
        //      floorAreaCode: [
        //        	this._ruleExist(configs.rootAPI + "areainfo/queryfloorcodebyareaid", "组合编号",this.tableRow)
        //      ]
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
    this.queryAllFloor();
    if (this.modaltype != "add") {
      Object.assign(this.form, this.tableRow);
    }
  },
  methods: {
    queryAllFloor() {
      var vm = this;
      vm.floormodelOptions = [];
      return vm
        ._ajax({
          url: vm.rootAPI,
          name: "floorinfo/queryfloorlist",
          param: {}
        })
        .then(
          d => {
            console.log(d);
            if (d.state === 0) {
              var aaData = d.aaData;
              aaData.forEach(function(el) {
                vm.floormodelOptions.push({
                  value: el.id,
                  label: el.floorName
                });
              });
            }
          },
          d => {
            this.$message.error("楼层数据获取失败");
          }
        );
    },
    selectChange(value) {
      if (value != "") {
        return this._ajax({
          url: this.rootAPI,
          name: "floorinfo/queryById",
          param: { id: value }
        }).then(
          d => {
            if (d.state === 0) {
              this.form.floorAreaCode =
                d.aaData.floorCode + "-" + this.form.areaCode;
            }
          },
          d => {
            this.$message.error("楼层数据获取失败");
          }
        );
      }
    },
    inputChange(value) {
      this.selectChange(this.form.floorId);
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
              name: "areainfo/update",
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
              createdPersonId: this.userinfo.userId,
              createdPerson: this.userinfo.nickName
            });
            this._ajax({
              url: this.rootAPI,
              name: "areainfo/create",
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