<template>
		<el-dialog custom-class="jz-modal" :title="modaltype === 'add' ? '新增提升机' : '编辑提升机'" :visible="modalshow"  :before-close="beforeClose" :width="modalWidth" :close-on-click-modal="false">
		  	<el-form class="modal-form" :inline="true" :model="form" :rules="rules" ref="form" label-width="100px">
                  	<span style="color:green">基础信息</span>
		  		<hr />
            <el-row>
				<el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                <el-form-item label="厂家"  prop='factory'>
		   	 		<inputItem :value.sync="form.factory" :maxlength="40"></inputItem>
		    	</el-form-item>
				</el-col>
                <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
	              <el-form-item label="品牌"  prop='brand'>
		    		<inputItem :value.sync="form.brand" :maxlength="40"></inputItem>
		      	</el-form-item>
				</el-col>
			</el-row>
			  	<el-row>
				<el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                <el-form-item label="型号"  prop='spec'>
		   	 		<inputItem :value.sync="form.spec" :maxlength="40"></inputItem>
		    	</el-form-item>
				</el-col>
                <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
	              <el-form-item label="编号\序列号"  prop='serialNum'>
		    		<inputItem :value.sync="form.serialNum" :maxlength="40" @blur="checkSerialNum"></inputItem>
		      	</el-form-item>
				</el-col>
			</el-row>
			</el-row>
			  	<el-row>
				<el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                <el-form-item label="生产日期"  prop='productDate'>
		   	 		<dateEditorDaterange :dateValue.sync="form.productDate"  @change type="date" ></dateEditorDaterange>
		    	</el-form-item>
				</el-col>
                <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
	              <el-form-item label="责任人"  prop='charge'>
		    		<inputItem :value.sync="form.charge" :maxlength="40"></inputItem>
		      	</el-form-item>
				</el-col>
			</el-row>
			<br/>
	  		<br/>
	  		<span style="color:green">详细信息</span>
	  		<el-row>
				<el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                <el-form-item label="净升行程"  prop='netLift'>
		   	 		<inputItem :value.sync="form.netLift" :maxlength="40"></inputItem>
		    	</el-form-item>
				</el-col>
                <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
	              <el-form-item label="最低高度"  prop='minHeight'>
		    		<inputItem :value.sync="form.minHeight" :maxlength="40"></inputItem>
		      	</el-form-item>
				</el-col>
			</el-row>
			<el-row>
				<el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                <el-form-item label="平台尺寸"  prop='platformSize'>
		   	 		<inputItem :value.sync="form.platformSize" :maxlength="40"></inputItem>
		    	</el-form-item>
				</el-col>
                <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
	              <el-form-item label="电机功率"  prop='motorPower'>
		    		<inputItem :value.sync="form.motorPower" :maxlength="40"></inputItem>
		      	</el-form-item>
				</el-col>
			</el-row>
			<el-row>
				<el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                <el-form-item label="额定载荷"  prop='ratedLoad'>
		   	 		<inputItem :value.sync="form.ratedLoad" :maxlength="40"></inputItem>
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
        id:null,
		factory: '',
		brand: '',
		spec:'',
		serialNum:'',
		productDate:moment(Date.parse(new Date())).format("YYYY-MM-DD"),
		ratedLoad:'',
		netLift:'',
		minHeight:'',
		platformSize:'',
		motorPower:'',
		charge:'',
      },
      userinfo: local.get("userinfo"),
      rules: {
        factory: [this._ruleRequired("厂家")],
        brand: [this._ruleRequired("品牌"),],
        spec: [this._ruleRequired("型号"),],
        serialNum: [this._ruleRequired("编号\序列号"),],
        productDate: [this._ruleRequired("生产日期"),],
        charge: [this._ruleRequired("责任人"),],
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
              name: "Hoist/update",
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
              name: "Hoist/create",
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
    },
    //检查是否存在重复序列号
    checkSerialNum(){
      var vm = this;
      var serialNum=vm.form.serialNum;//序列号
              this._ajax({
              url: this.rootAPI,
              name: "Hoist/list",
              param: { 'serialNum':serialNum}, 
            }).then(
              (d => {
                if(d.dataCount !=0){
                    this.$message({
                    type: "warning",
                    message: "序列号重复" // + d.msg
                  });
                  vm.form.serialNum='';
                }
              })
            );
    }
  }
};
</script>