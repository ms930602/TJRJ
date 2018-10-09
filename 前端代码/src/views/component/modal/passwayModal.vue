<template>
		<el-dialog custom-class="jz-modal" :title="modaltype === 'add' ? '新增通道' : '编辑通道'" :visible="modalshow"  :before-close="beforeClose" :width="modalWidth" :close-on-click-modal="false">
		  	<el-form class="modal-form" :inline="true" :model="form" :rules="rules" ref="form" label-width="100px">
                  	<el-row>
				<el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                <el-form-item label="通道编号"  prop='passNo'>
		   	 		<inputItem :value.sync="form.passNo" :maxlength="10"></inputItem>
		    	</el-form-item>
				</el-col>
                <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
	              <el-form-item label="通道名称"  prop='passName'>
		    		<inputItem :value.sync="form.passName" :maxlength="40"></inputItem>
		      	</el-form-item>
				</el-col>
			</el-row>
		    <el-row>
				<el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
		      	<el-form-item label="通道类型"  prop='passTypeNo'>
                    <selectInput :value.sync="form.passTypeNo" >
						<el-option
							v-for="item in passTypeNooptions"
							:key="item.key"
							:label="item.value"
							:value="item.key">
						</el-option>
					</selectInput>
		      	</el-form-item>
				</el-col>
                <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
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
      form: {
        id: null,
        passNo: "",
        passName: "",
        passTypeNo: ""
      },
      userinfo: local.get("userinfo"),
      rules: {
        passTypeNo: [this._ruleRequired("通道类型")],
        passNo: [
          this._ruleRequired("通道编号"),
          this._ruleReg(/^[0-9a-zA-Z]+$/, "请填写字母与数字的组合"),
          this._ruleExist(
            configs.rootAPI + "passway/checkpassNo",
            "通道编号",
            this.tableRow
          )
        ],
        passName: [
          this._ruleRequired("通道名称"),
          this._ruleExist(
            configs.rootAPI + "passway/checkpassName",
            "通道名称",
            this.tableRow
          )
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
    },
    passTypeNooptions: {
      default: []
    }
  },
  computed: {},
  mounted() {
    if (this.modaltype != "add") {

      console.log(this.passTypeNooptions);
      Object.assign(this.form, this.tableRow);
    }
  },
  methods: {
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
              name: "passway/update",
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
              name: "passway/create",
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