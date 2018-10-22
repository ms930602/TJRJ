<template>
	<div>
		<el-card class="box-card" style="margin-right: 5px; margin-left: 5px;" shadow="hover">
  <div slot="header" class="clearfix" >
    <span>活动信息</span>
  </div>
	<div>
  <el-form class="modal-form" :inline="true" :model="form" :rules="rules" ref="form" label-width="120px">
      <el-row >
        <el-col :span="24">
          <el-form-item label="商户"  prop='merchantName'>
            {{form.merchantName}}
              </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="24">
             <el-form-item label="活动标题"  prop='title'>
               <inputItem :value.sync="form.title" style="width:607px"></inputItem>
              </el-form-item>
        </el-col>
      </el-row>
      <el-row >
        <el-col :span="6">
              <el-form-item label="活动限额"  prop='peopleNum'>
                  <inputItem :value.sync="form.peopleNum" type="number" maxlength="9"></inputItem>
              </el-form-item>
        </el-col>
        <el-col :span="6">
             <el-form-item label="活动时间"  prop='startTime'>
              <dateEditorDaterange :dateValue.sync="form.startTime" :showPickerOptions="false" type="date" style="width: 200px;"></dateEditorDaterange>
              </el-form-item>
        </el-col>
        <el-col :span="6">
            <el-form-item label="价格" prop="price">
               <inputItem :value.sync="form.price" type="number" maxlength="9"></inputItem>
            </el-form-item>
        </el-col>
			</el-row>
      <el-row >
          <el-col :span="24">
            <el-form-item label="背景音乐"  prop='mp3'>
              <el-upload
                class="upload-demo"
                action="http://localhost:8080/warehouse-pre-interface//api/user/fileUpload/upload"
                :on-preview="handlePreview"
                :on-remove="handleRemove"
                :before-remove="beforeRemove"
                :on-exceed="handleExceed"
                :data="uploadParam"
                :file-list="fileList">
                <el-button size="small" type="primary">点击上传</el-button>
                <div slot="tip" class="el-upload__tip">只能上传mp3文件，且不超过500kb</div>
              </el-upload>
            </el-form-item>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row >
				<el-col :span="24">
	              	<el-form-item label="门户图片"  prop='inventStartDate'>
		      		</el-form-item>
				</el-col>
      </el-row>
      <el-row>
				<el-col :span="6">
                  <el-form-item label="宣传图片"  prop='inventEndDate'>
		      	  </el-form-item>
				</el-col>
			</el-row>
	  </el-form>
		</div>
</el-card>
<el-container>
    <el-footer>
      <div style="float: right;">
          <el-button @click="cancel('form')">取 消</el-button>
          <el-button type="primary" @click="save()">保  存</el-button>
      </div>
    </el-footer>
  </el-container>
	  <selectMerchantModel  v-if="modalShow"  @close="modalClose" :modalShowlocal='modalShow' @selectList="selectList"></selectMerchantModel>
	  </div>
</template>

<script>
import mixin from "../../mixin/mixin.js";
import local from "../../local.js";
import configs from "../../configs.js";
import selectMerchantModel from "./selectMerchantModel.vue";
export default {
  mixins: [mixin],
  components: { selectMerchantModel },
  data() {
    return {
      modalShow: false,
      form: {
        id: null,
        merchantId: null,
        title: "",
        price: 100,
        topImg: '',
        startTime: null,
        mp3: '',
        peopleNum: 100,
        payNum: 0,
        selectNum: 0,
        detailImg: '',
        phone:''
      },
      uploadParam:{
        token:local.get("token")
      },
      userinfo: local.get("userinfo"),
      rules: {
        title: [this._ruleRequired("标题")],
        price: [this._ruleRequired("价格")],
        startTime: [this._ruleRequired("开始时间")],
        peopleNum: [this._ruleRequired("限额人数")],
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
  },
  methods: {
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePreview(file) {
      console.log(file);
    },
    handleExceed(files, fileList) {
      this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
    },
    beforeRemove(file, fileList) {
      return this.$confirm(`确定移除 ${ file.name }？`);
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
    modalClose() {
      this.modalShow = false;
    },
    selectList(tableArr) {//选择商户
      
    },
    cancel() {
      this.$router.push({ path: "/activitiesMain" });
    },
    save() {
      this.$refs['form'].validate((valid) => {
          if (valid) {
              let o = {}, method = 'vxActivities/update';
              if(this.form.id && this.form.id > 0) {  
                o = {
                      id:this.form.id,
                      merchantId:this.form.merchantId,
                      title:this.form.title,
                      price:this.form.price,
                      topImg:this.form.topImg,
                      startTime:this.form.startTime,
                      mp3:this.form.mp3,
                      peopleNum:this.form.peopleNum,
                      payNum:this.form.payNum,
                      selectNum:this.form.selectNum,
                      detailImg:this.form.detailImg,
                      phone:this.form.phone
                  }
              }else {
                  method = 'vxActivities/create' 
                  o = {
                      merchantId:this.form.merchantId,
                      title:this.form.title,
                      price:this.form.price,
                      topImg:this.form.topImg,
                      startTime:this.form.startTime,
                      mp3:this.form.mp3,
                      peopleNum:this.form.peopleNum,
                      payNum:this.form.payNum,
                      selectNum:this.form.selectNum,
                      detailImg:this.form.detailImg,
                      phone:this.form.phone
                  }
              }
              this._ajax({url: this.rootAPI + method, param: o})
              .then((function(d) {
                  if(d.state === 0) {
                      this.$message({ type: 'success', message: '操作成功' }); 
                      this.cancel();
                  }
                  else{
                      this.$message({ type: 'warning', message: '操作失败:'+d.msg });
                  }
              }).bind(this))
          }
      })
    }
  }
};
</script>

<style>


</style>