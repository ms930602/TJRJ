<template>
		<el-dialog custom-class="jz-modal" :title="modaltype === 'add' ? '新增楼层' : '编辑楼层'" :visible="modalshow"  :before-close="beforeClose" :width="modalWidth" :close-on-click-modal="false">
		  	<el-form class="modal-form" :inline="true" :model="form" :rules="rules" ref="form" label-width="100px">
                <el-row>
	                <el-form-item label="楼层编号"  prop='floorCode'>
                    <el-input-number v-model="form.floorCode"  controls-position="right" :min="1" :max="100" @change="changefloorname"></el-input-number>
			   	 		<!-- <inputItem :value.sync="form.floorCode" :maxlength="10"></inputItem> -->
			    	</el-form-item>
					</el-col>
		              <el-form-item label="楼层名称"  prop='floorName'>
			    		<inputItem :value.sync="form.floorName" :maxlength="40"></inputItem>
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
      form: {
        id: null,
        floorCode: "",
        floorName: "1楼"
      },
      modalWidth: "30%",
      userinfo: local.get("userinfo"),
      rules: {
        floorName: [
          this._ruleRequired("楼层名称"),
          this._ruleExist(
            configs.rootAPI + "floorinfo/checkfloorName",
            "楼层名称",
            this.tableRow
          )
        ],
        floorCode: [
          this._ruleRequired("楼层编号"),
         // this._ruleReg(/^[0-9a-zA-Z]+$/, "请填写字母与数字的组合"),
          this._ruleExist(
            configs.rootAPI + "floorinfo/checkfloorCode",
            "楼层编号",
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
    }
  },
  computed: {},
  mounted() {
    if (this.modaltype != "add") {
      Object.assign(this.form, this.tableRow);
    }
  },
  methods: {
    cancel() {
      this.$emit("close");
    },
    changefloorname(dd) {
      if (this.modaltype === "add")
       this.form.floorName = dd + "楼";
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
              name: "floorinfo/update",
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
              name: "floorinfo/create",
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