<template>
		<el-dialog custom-class="jz-modal" :title="modaltype === 'add' ? '新增手持终端' : '编辑手持终端'" :visible="modalshow"  :before-close="beforeClose" :width="modalWidth" :close-on-click-modal="false">
		  	<el-form class="modal-form" :inline="true" :model="form" :rules="rules" ref="form" label-width="100px">
        
        <el-row>
				  <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
              <el-form-item label="厂家"  prop='factory'>
                      <inputItem :value.sync="form.factory" :maxlength="10"></inputItem>
              </el-form-item>
				  </el-col>

          <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
	              <el-form-item label="品牌"  required  prop='brand'>
		    		          <inputItem :value.sync="form.brand" :maxlength="40"></inputItem>
		      	    </el-form-item>
				  </el-col>
			 </el-row>
 

        <el-row>
				  <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
              <el-form-item label="型号" required  prop='spec'>
                      <inputItem :value.sync="form.spec" :maxlength="10"></inputItem>
              </el-form-item>
				  </el-col>

          <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
	              <el-form-item label="序列号"  required prop='serialNum'>
		    		          <inputItem :value.sync="form.serialNum" :maxlength="40"></inputItem>
		      	    </el-form-item>
				  </el-col>
			 </el-row>

    
          <el-row>

                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                      <el-form-item label="生产日期"  prop='productDate'>
                        <dateEditorDaterange :dateValue.sync="form.productDate" type="date"></dateEditorDaterange>
                      </el-form-item>
                    </el-col>

          <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
	              <el-form-item label="重量"  prop='weight'>
		    		          <inputItem :value.sync="form.weight" :maxlength="40"></inputItem>
		      	    </el-form-item>
				  </el-col>
			 </el-row>



               <el-row>
				  <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
              <el-form-item label="尺寸"  prop='size'>
                      <inputItem :value.sync="form.size" :maxlength="10"></inputItem>
              </el-form-item>
				  </el-col>

          <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
	              <el-form-item label="操作系统"  prop='operSystem'>
		    		          <inputItem :value.sync="form.operSystem" :maxlength="40"></inputItem>
		      	    </el-form-item>
				  </el-col>
			 </el-row>


               <el-row>
				  <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
              <el-form-item label="内存"  prop='ram'>
                      <inputItem :value.sync="form.ram" :maxlength="10"></inputItem>
              </el-form-item>
				  </el-col>

          <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
	              <el-form-item label="处理器"  prop='processor'>
		    		          <inputItem :value.sync="form.processor" :maxlength="40"></inputItem>
		      	    </el-form-item>
				  </el-col>
			 </el-row>


             <el-row>
				  <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
              <el-form-item label="通信方式"  prop='communicatMethod'>
                      <inputItem :value.sync="form.communicatMethod" :maxlength="10"></inputItem>
              </el-form-item>
				  </el-col>

          <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
	              <el-form-item label="负责人"  prop='charge'>
		    		          <inputItem :value.sync="form.charge" :maxlength="40"></inputItem>
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
        factory: "",
        brand: "",
        spec: "",
        serialNum: "",
        productDate:moment(Date.parse(new Date())).format("YYYY-MM-DD"),
        weight: "",
        size: "",
        operSystem: "",
        ram: "",
        processor: "",
        communicatMethod: "",
        charge: ""
      },
     rules: {
        brand: [{required: true, message: '品牌不能为空' }, this._ruleLength(40)],
        spec: [ {required: true, message: '型号不能为空' },this._ruleLength(10)],
        serialNum: [{required: true, message: '序列号不能为空' }, this._ruleLength(40)]
      },
      userinfo: local.get("userinfo"),
     
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
      debugger;
      //console.log(this.passTypeNooptions);
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

            
          var params = {};

          var nowTime = moment(Date.parse(new Date())).format("YYYY-MM-DD HH:mm:ss");
          var productT = moment(this.form.productDate).format("YYYY-MM-DD HH:mm:ss")

          params = {
            id:this.form.id,   
            factory: this.form.factory,
            brand: this.form.brand,
            spec: this.form.spec,
            serialNum: this.form.serialNum,
            productDate: productT,

            weight: this.form.weight,
            size: this.form.size,
            operSystem: this.form.operSystem,
            ram: this.form.ram,
            processor: this.form.processor,
            communicatMethod: this.form.communicatMethod,
            charge: this.form.charge,
            updatedDate: nowTime,
            updatedPersonId: this.userinfo.userId,
            updatedPerson: this.userinfo.nickName,
            }

            this._ajax({
              url: this.rootAPI,
              name: "pos/update",
              param: params
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
          
          var params = {};

          var nowTime = moment(Date.parse(new Date())).format("YYYY-MM-DD HH:mm:ss");
          var productT = moment(this.form.productDate).format("YYYY-MM-DD HH:mm:ss")

          params = {   
            factory: this.form.factory,
            brand: this.form.brand,
            spec: this.form.spec,
            serialNum: this.form.serialNum,
            productDate: productT,

            weight: this.form.weight,
            size: this.form.size,
            operSystem: this.form.operSystem,
            ram: this.form.ram,
            processor: this.form.processor,
            communicatMethod: this.form.communicatMethod,
            charge: this.form.charge,
            createdDate: nowTime,
            createdPersonId: this.userinfo.userId,
            createdPerson: this.userinfo.nickName,
            }

            this._ajax({
              url: this.rootAPI,
              name: "pos/create",
              param: params
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