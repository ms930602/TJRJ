<template>
<el-dialog custom-class="jz-modal" :title="modalType === 'add' ? '新增信息' : '编辑信息'" :visible="modalshow" :before-close="beforeClose" :width="modalWidth" @close="cancel">
            <el-form class="modal-form"  :model="form" ref="form" :inline="true" :rules="rules" label-width="80px">
                <el-row>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="厂家" prop="factory" label-width="120px">
                            <inputItem :value.sync="form.factory"></inputItem>
                        </el-form-item>
                    </el-col>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="品牌" prop="brand" label-width="120px">
                            <inputItem :value.sync="form.brand"></inputItem>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="型号" prop="spec" label-width="120px">
                            <inputItem :value.sync="form.spec" ></inputItem>
                        </el-form-item>
                    </el-col>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="序列号" prop="serialNum" label-width="120px">
                            <inputItem :value.sync="form.serialNum"></inputItem>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="责任人" prop="charge" label-width="120px">
                            <inputItem :value.sync="form.charge"></inputItem>
                        </el-form-item>
                    </el-col>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="通道" prop="passwayId" label-width="120px">
                            <el-select  v-model="form.passwayId" placeholder="请选择" style="width:220px">
									<el-option auto-complete="off" v-for="item in passwayList"  :key="item.id" :label="item.passName" :value="item.id" >
									</el-option>
							</el-select>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="工作温度(℃))" prop="workTemp" label-width="120px">
                            <inputItem :value.sync="form.workTemp">
                            </inputItem>
                        </el-form-item>
                    </el-col>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="工作湿度" prop="workHumidity" label-width="120px">
                            <inputItem :value.sync="form.workHumidity"></inputItem>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="生产日期" prop="productDate" label-width="120px" >
                            <el-date-picker v-model="form.productDate" type="datetime" :picker-options="pickerOptions" placeholder="选择日期时间" :clearable = "false" >
                            </el-date-picker>
                        </el-form-item>
                    </el-col>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="识别所需时间(S)" prop="recogniteTime" label-width="130px">
                            <inputItem :value.sync="form.recogniteTime"></inputItem>
                        </el-form-item>
                    </el-col>
                </el-row>
            </el-form>              
            <div slot="footer" class="dialog-footer flex-x-end">
                <elBtn @click="cancel('form')" text="取消">取消</elBtn>
                <elBtn @click="save('form')" type="primary" text="提交">提交</elBtn>
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
        form:{
            id:'',
            factory:'',//厂家
            brand: '',//品牌
            spec: '',//型号
            passwayId:'',//通道id
            passwayNo:'',//通道编号
            serialNum:'',//序列号
            productDate:moment(Date.parse(new Date())).format("YYYY-MM-DD"),//生产日期
            recogniteTime:'',//识别所需时间
            workTemp:'',//工作温度
            workHumidity:'',//工作湿度
            charge:'',//责任人
            createdDate:'',//创建时间
            createdPersonId:'',//创建人id
            createdPerson:'',
            updatedDate:'',
            updatedPersonId:'',//更新人id
            updatedPerson:'',
            passwayName:'',
        },
        
        userinfo: local.get("userinfo"),
        rules: {
            factory:[{required: true, message: '厂家不能为空' }, this._ruleLength(45)],//厂家
            brand: [{required: true, message: '品牌不能为空' }, this._ruleLength(45)],//品牌
            spec: [{required: true, message: '型号不能为空' }, this._ruleLength(45)],//型号
            passwayId:[{required: true, message: '通道id不能为空' }, this._ruleLength(45)],//通道id
            passwayNo:[{required: true, message: '通道编号不能为空' }, this._ruleLength(45)],//通道编号
            serialNum:[{required: true, message: '序列号不能为空' }, this._ruleLength(45)],//序列号
            productDate:[{required: true, message: '生产日期不能为空' }],//生产日期
            recogniteTime:[{required: true, message: '识别所需时间不能为空' }, this._ruleLength(45)],//识别所需时间
            workTemp:[{required: true, message: '工作温度不能为空' }, this._ruleLength(45)],//工作温度
            workHumidity:[{required: true, message: '工作湿度不能为空' }, this._ruleLength(45)],//工作湿度
            charge:[this._ruleLength(45)]
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
    passwayList: {
      default: []
    }
  },
  computed: {},
  mounted() {
    if (this.modaltype != "add") {
      Object.assign(this.form, this.tableRow);
    };
    //通道id
    this._ajax({
      url: this.rootAPI,
      name: "passway/list"
    }).then(
      (d => {
        this.passwayList = d.aaData;
      })
    );

  },
  methods: {
    cancel() {
      this.$emit("close");
    },
    save(formname) {
      this.$refs[formname].validate(valid => {
        if (valid) {
            console.log(this.form.productDate)
        var nowTime = moment(Date.parse(new Date())).format("YYYY-MM-DD HH:mm:ss");
        var productTime = moment(this.form.productDate).format("YYYY-MM-DD HH:mm:ss");
          if (this.tableRow && this.tableRow.id > 0) {
            //编辑
            Object.assign(this.form, {
              updatedPersonId: this.userinfo.userId,
              updatedPerson: this.userinfo.nickName,
              updatedDate:nowTime,
              productDate:productTime
            });
            this._ajax({
              url: this.rootAPI,
              name: "lpr/update",
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
            console.log(4566,this.form.passwayId)
            console.log(4566,this.form.passwayId.split(",")[0],)
            Object.assign(this.form, {
              createdPersonId: this.userinfo.userId,
              createdPerson: this.userinfo.nickName,
              createdDate:nowTime,
              productDate:productTime,
              passwayId:this.form.passwayId.split(",")[0],
              passwayNo:this.form.passwayId.split(",")[1],
            });
            this._ajax({
              url: this.rootAPI,
              name: "lpr/create",
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
   
  }
};
</script>