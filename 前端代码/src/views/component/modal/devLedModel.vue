<template>
		<el-dialog custom-class="jz-modal" :title="modaltype === 'add' ? '新增LED显示器' : '编辑LED显示器'" :visible="modalshow"  :before-close="beforeClose" :width="modalWidth" :close-on-click-modal="false">
		  	<el-form class="modal-form" :inline="true" :model="form" :rules="rules" ref="form" label-width="100px">
        
        <el-row>
				  <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
              <el-form-item label="厂家" required prop='factory'>
                      <inputItem :value.sync="form.factory" :maxlength="10"></inputItem>
              </el-form-item>
				  </el-col>

          <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
	              <el-form-item label="品牌" required  prop='brand'>
		    		          <inputItem :value.sync="form.brand" :maxlength="40"></inputItem>
		      	    </el-form-item>
				  </el-col>
			 </el-row>


        <el-row>
				  <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
              <el-form-item label="型号" required prop='spec'>
                      <inputItem :value.sync="form.spec" :maxlength="10"></inputItem>
              </el-form-item>
				  </el-col>

          <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
	              <el-form-item label="序列号" required  prop='serialNum'>
		    		          <inputItem :value.sync="form.serialNum" :maxlength="40" @blur="checkSerialNum"></inputItem>
		      	    </el-form-item>
				  </el-col>
			 </el-row>
       
          <el-row>
             <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
	       <el-form-item label="生产日期"  required prop='productDate'>
			   	 		<dateEditorDaterange :dateValue.sync="form.productDate" type="date" style="width: 220px;"></dateEditorDaterange>
			  </el-form-item>

         </el-col> 


          <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
	              <el-form-item label="通道ID" required  prop='passwayId'>
		    		          <inputItem :value.sync="form.passwayId" :maxlength="10"></inputItem>
		      	    </el-form-item>
				  </el-col>   



			 </el-row>



          <el-row>
				  <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
              <el-form-item label="尺寸" required  prop='size'>
                      <inputItem :value.sync="form.size" :maxlength="10"></inputItem>
              </el-form-item>
				  </el-col>

          <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
	              <el-form-item label="通道编号" required  prop='passwayNo'>
		    		          <inputItem :value.sync="form.passwayNo" :maxlength="40"></inputItem>
		      	    </el-form-item>
				  </el-col>
			 </el-row>


        

             <el-row>
				  <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
              <el-form-item label="分辨率" required  prop='resolvRate'>
                      <inputItem :value.sync="form.resolvRate" :maxlength="10"></inputItem>
              </el-form-item>
				  </el-col>

          <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
	              <el-form-item label="负责人"  required  prop='charge'>
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
       	  id:null,
					brand:'',
					spec: '',
					size:'',
					factory:'',
					serialNum:'',
					passwayNo:'',
					resolvRate:'',
					productDate:moment(Date.parse(new Date())).format("YYYY-MM-DD"),
					charge:'',
					passwayId:''
      },
      userinfo: local.get("userinfo"),
     rules: {
          factory: [{required: true, message: '厂家不能为空' }, this._ruleLength(10)],
          brand: [{required: true, message: '品牌不能为空' }, this._ruleLength(40)],
          spec: [{required: true, message: '型号不能为空' }, this._ruleLength(10)],
          serialNum: [{required: true, message: '序列号不能为空' }, this._ruleLength(40)],
					productDate: [{required: true, message: '生产日期不能为空' }],
					passwayId: [{required: true, message: '通道id不能为空' }, this._ruleLength(10)],
					size: [{required: true, message: '尺寸不能为空' }, this._ruleLength(10)],
          passwayNo: [{required: true, message: '通道编号不能为空' }, this._ruleLength(40)],
          
          resolvRate: [{required: true, message: '分辨率不能为空' }, this._ruleLength(10)],
          charge: [{required: true, message: '负责人不能为空' }, this._ruleLength(40)]
           },
       
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
       debugger;
      console.log("11111111");

      this.$refs[formname].validate(valid => {
        if (valid) {
          if (this.tableRow && this.tableRow.id > 0) {
          var params = {};
          var nowTime = moment(Date.parse(new Date())).format("YYYY-MM-DD HH:mm:ss");
          var productT = moment(this.form.productDate).format("YYYY-MM-DD HH:mm:ss");

          params = {          
              id:this.form.id,   
              brand:this.form.brand,   
              spec: this.form.spec,   
              size:this.form.size,   
              factory:this.form.factory,   
              serialNum:this.form.serialNum,   
              passwayNo:this.form.passwayNo,   
              resolvRate:this.form.resolvRate,   
              productDate:productT,   
              charge:this.form.charge,   
              passwayId:this.form.passwayId,   
              updatedDate: nowTime,
              updatedPersonId: this.userinfo.userId,
              updatedPerson: this.userinfo.nickName

            }

            this._ajax({
              url: this.rootAPI,
              name: "devLed/update",
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
              id:this.form.id,   
              brand:this.form.brand,   
              spec: this.form.spec,   
              size:this.form.size,   
              factory:this.form.factory,   
              serialNum:this.form.serialNum,   
              passwayNo:this.form.passwayNo,   
              resolvRate:this.form.resolvRate,   
              productDate:productT,   
              charge:this.form.charge,   
              passwayId:this.form.passwayId,   
              createdDate: nowTime,
              createdPersonId: this.userinfo.userId,
              createdPerson: this.userinfo.nickName,

            }

            this._ajax({
              url: this.rootAPI,
              name: "devLed/create",
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
    },
        //检查是否存在重复序列号
    checkSerialNum(){
      var vm = this;
      var serialNum=vm.form.serialNum;//序列号
              this._ajax({
              url: this.rootAPI,
              name: "Led/list",
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