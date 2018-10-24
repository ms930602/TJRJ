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
          <el-form-item label="商户"  prop='merchantId'>
            <selectInput :value.sync="form.merchantId">
              <el-option
                  v-for="item in merchantOption"
                  :key="item.key"
                  :label="item.value"
                  :value="item.key">
                </el-option>
            </selectInput>
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
        <el-col :span="6">
            <el-form-item label="客户电话" prop="phone">
               <inputItem :value.sync="form.phone" maxlength="30"></inputItem>
            </el-form-item>
        </el-col>
			</el-row>
      <el-row >
          <el-col :span="6">
                  <el-form-item label="门户图片"  prop='inventStartDate'>
                    <el-upload
                      class="avatar-uploader"
                      :action="uploadURL"
                      :show-file-list="false"
                      :on-success="topSuccess"
                      :before-upload="topBeforeUpload">
                      <img v-if="imageUrl" :src="imageUrl" class="avatar">
                      <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                    </el-upload>
                  </el-form-item>
        </el-col>
          <el-col :span="6">
            <el-form-item label="背景音乐"  prop='mp3'>
              <uploadItem 
              @success="successMp3" @remove="removeMp3" uploadTip="只能上传mp3文件，且不超过10M"
              :fileList="mp3FileList" accept="audio/mp3"
              ></uploadItem>
              <span v-if="form.mp3Id != null">
                <audio v-bind:src="fileURL" controls preload="auto"/>
              </span>
            </el-form-item>
          </el-form-item>
        </el-col>
      </el-row>
      <h5>宣传图片 1~5张依次排序</h5>
      <hr/>
      <el-row>
				<el-col :span="6">
           <el-form-item label="宣传图片1"  prop='inventEndDate'>
                <el-upload
                  class="avatar-uploader"
                  :action="uploadURL"
                  :show-file-list="false"
                  accept="image/*"
                  :on-success="detailSuccessA"
                  :before-upload="topBeforeUpload">
                  <img v-if="imageUrlA" :src="imageUrlA" class="avatar">
                  <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                </el-upload>
	         </el-form-item>
				</el-col>
        <el-col :span="6">
           <el-form-item label="宣传图片2"  prop='inventEndDate'>
                <el-upload
                  class="avatar-uploader"
                  :action="uploadURL"
                  accept="image/*"
                  :show-file-list="false"
                  :on-success="detailSuccessB"
                  :before-upload="topBeforeUpload">
                  <img v-if="imageUrlB" :src="imageUrlB" class="avatar">
                  <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                </el-upload>
           </el-form-item>
        </el-col>
        <el-col :span="6">
           <el-form-item label="宣传图片3"  prop='inventEndDate'>
                <el-upload
                  class="avatar-uploader"
                  :action="uploadURL"
                  accept="image/*"
                  :show-file-list="false"
                  :on-success="detailSuccessC"
                  :before-upload="topBeforeUpload">
                  <img v-if="imageUrlC" :src="imageUrlC" class="avatar">
                  <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                </el-upload>
           </el-form-item>
        </el-col>
			</el-row>
      <el-row >
        <el-col :span="6">
           <el-form-item label="宣传图片4"  prop='inventEndDate'>
                <el-upload
                  class="avatar-uploader"
                  :action="uploadURL"
                  :show-file-list="false"
                  accept="image/*"
                  :on-success="detailSuccessD"
                  :before-upload="topBeforeUpload">
                  <img v-if="imageUrlD" :src="imageUrlD" class="avatar">
                  <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                </el-upload>
           </el-form-item>
        </el-col>
        <el-col :span="6">
           <el-form-item label="宣传图片5"  prop='inventEndDate'>
                <el-upload
                  class="avatar-uploader"
                  :action="uploadURL"
                  accept="image/*"
                  :show-file-list="false"
                  :on-success="detailSuccessE"
                  :before-upload="topBeforeUpload">
                  <img v-if="imageUrlE" :src="imageUrlE" class="avatar">
                  <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                </el-upload>
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
	  </div>
</template>

<script>
import mixin from "../../mixin/mixin.js";
import local from "../../local.js";
import configs from "../../configs.js";
export default {
  mixins: [mixin],
  data() {
    return {
      modalShow: false,
      uploadURL:'',
      uploadURLA:'',
      uploadURLB:'',
      uploadURLC:'',
      uploadURLD:'',
      uploadURLE:'',
      detailImgA:null,
      detailImgB:null,
      detailImgC:null,
      detailImgD:null,
      detailImgE:null,
      imageUrl:'',
      imageUrlA:'',
      imageUrlB:'',
      imageUrlC:'',
      imageUrlD:'',
      imageUrlE:'',
      form: {
        id: null,
        merchantId: 1,
        title: "",
        price: 100,
        startTime: null,
        peopleNum: 100,
        payNum: 0,
        selectNum: 0,
        phone:'',
        topImg: null,
        mp3Id: null,
        detailImg: '',
        status:0
      },
      userinfo: local.get("userinfo"),
      fileURL:'',
      mp3FileList:[],
      topFileList:[],
      merchantOption:[],
      rules: {
        merchantId:[this._ruleRequired("商户")],
        title: [this._ruleRequired("标题")],
        price: [this._ruleRequired("价格"),this._ruleLength(9)],
        startTime: [this._ruleRequired("开始时间")],
        peopleNum: [this._ruleRequired("限额人数"),this._ruleLength(9)],
        phone: [this._ruleRequired("客户电话")],
        
      }
    };
  },
  mounted() {
    this.loadMerchant();
    var id = this.$route.query.id;
    if (id) {
      this.form.id = id;
      this.searchObject();
    } else {
      this.form.id = null;
    }
  },
  methods: {
    loadMerchant(){
      var _this = this;
      let method = 'vxMerchant/list';
      this._ajax({url: this.rootAPI + method }).then((function(d) {
        if(d.aaData && d.aaData.length > 0){
            d.aaData.forEach(temp=>{
              _this.merchantOption.push({key:temp.id,value:temp.name})
            });
            _this.form.merchantId = d.aaData[0].id;
        }
      }).bind(this))
    },
    successMp3(response, file, fileList){
      var data = file.response;
      if(file.response.state == 0){
        this.form.mp3Id = data.aaData.loadId;
        this.fileURL = 'http://localhost:8080/warehouse-pre-interface/servlet/getfile?path=' + data.aaData.path
      }else{
        this.$message({ type: "error", message: "上传失败!" });
      }
    },
    removeMp3(file, fileList){
      this.form.mp3Id = null;
    },
    topSuccess(res, file) {
      if(res.state == 0){
        this.form.topImg = res.aaData.loadId;
        this.imageUrl = 'http://localhost:8080/warehouse-pre-interface/servlet/getfile?path=' + res.aaData.path;
      }else{
        this.$message({ type: "error", message: "上传失败!" });
      }
    },
    detailSuccessA(res, file) {
      if(res.state == 0){
        this.detailImgA = res.aaData.loadId;
        this.imageUrlA = 'http://localhost:8080/warehouse-pre-interface/servlet/getfile?path=' + res.aaData.path;
      }else{
        this.$message({ type: "error", message: "上传失败!" });
      }
    },
    detailSuccessB(res, file) {
      if(res.state == 0){
        this.detailImgB = res.aaData.loadId;
        this.imageUrlB = 'http://localhost:8080/warehouse-pre-interface/servlet/getfile?path=' + res.aaData.path;
      }else{
        this.$message({ type: "error", message: "上传失败!" });
      }
    },
    detailSuccessC(res, file) {
      if(res.state == 0){
        this.detailImgC = res.aaData.loadId;
        this.imageUrlC = 'http://localhost:8080/warehouse-pre-interface/servlet/getfile?path=' + res.aaData.path;
      }else{
        this.$message({ type: "error", message: "上传失败!" });
      }
    },
    detailSuccessD(res, file) {
      if(res.state == 0){
        this.detailImgD = res.aaData.loadId;
        this.imageUrlD = 'http://localhost:8080/warehouse-pre-interface/servlet/getfile?path=' + res.aaData.path;
      }else{
        this.$message({ type: "error", message: "上传失败!" });
      }
    },
    detailSuccessE(res, file) {
      if(res.state == 0){
        this.detailImgE = res.aaData.loadId;
        this.imageUrlE = 'http://localhost:8080/warehouse-pre-interface/servlet/getfile?path=' + res.aaData.path;
      }else{
        this.$message({ type: "error", message: "上传失败!" });
      }
    },
    topBeforeUpload(file) {
      return new Promise((resolve, reject) => {
          this.$nextTick(() => {
                  var fileType = file.type
                  //图片限制4M，其他附件限制50M
                  let limitType = 10
                  this.uploadURL = configs.uploadFileURL + '/file/imgUpload?savePath=vx&token=' + local.get('token')
                  const isLt = file.size / 1024 / 1024 < limitType;
                  if (!isLt) {
                    this.$message.error('上传文件大小不能超过 '+limitType+'MB!');
                    reject()
                  }else {
                    resolve()
                  }
            })
        })  
    },
    searchObject() {
      var queryId = this.form.id;
      var _this = this;
      this._ajax({
        url: this.rootAPI + "vxActivities/queryById",
        param: { id: queryId }
      }).then(
        function(d) {
          if (d.state === 0) {
            Object.assign(this.form, d.aaData);
            this.doFileSet(d.aaData);
          } else {
            this.$message({ type: "error", message: "服务器错误!" });
          }
        }.bind(this)
      );
    },
    doFileSet(data){
      if(data.musicObj){
        this.mp3FileList = [{
          name:data.musicObj.fileName
        }];
        this.fileURL = 'http://localhost:8080/warehouse-pre-interface/servlet/getfile?path=' + data.musicObj.filePath
      }

      if(data.topImgObj){
        this.imageUrl = 'http://localhost:8080/warehouse-pre-interface/servlet/getfile?path=' + data.topImgObj.filePath;
      }

      if(data.detailImgObj){
        var temp = data.detailImgObj;
        var size = temp.length;
        if(size >= 1){
          this.detailImgA = temp[0].id;
          this.imageUrlA = 'http://localhost:8080/warehouse-pre-interface/servlet/getfile?path=' + temp[0].filePath;
        }

        if(size >= 2){
          this.detailImgB = temp[1].id;
          this.imageUrlB = 'http://localhost:8080/warehouse-pre-interface/servlet/getfile?path=' + temp[1].filePath;
        }
        if(size >= 3){
          this.detailImgC = temp[2].id;
          this.imageUrlC = 'http://localhost:8080/warehouse-pre-interface/servlet/getfile?path=' + temp[2].filePath;
        }

        if(size >= 4){
          this.detailImgD = temp[3].id;
          this.imageUrlD = 'http://localhost:8080/warehouse-pre-interface/servlet/getfile?path=' + temp[3].filePath;
        }

        if(size >= 5){
          this.detailImgD = temp[4].id;
          this.imageUrlD = 'http://localhost:8080/warehouse-pre-interface/servlet/getfile?path=' + temp[4].filePath;
        }
      }
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
      var detailImageIds = '';
      if(this.detailImgA){
        detailImageIds = this.detailImgA;
      }

      if(this.detailImgB){
        detailImageIds = detailImageIds + "," + this.detailImgB;
      }

      if(this.detailImgC){
        detailImageIds = detailImageIds + "," + this.detailImgC;
      }

      if(this.detailImgD){
        detailImageIds = detailImageIds + "," + this.detailImgD;
      }

      if(this.detailImgE){
        detailImageIds = detailImageIds + "," + this.detailImgE;
      }


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
                      mp3Id:this.form.mp3Id,
                      peopleNum:this.form.peopleNum,
                      payNum:this.form.payNum,
                      selectNum:this.form.selectNum,
                      detailImg:detailImageIds,
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
                      mp3Id:this.form.mp3Id,
                      peopleNum:this.form.peopleNum,
                      payNum:this.form.payNum,
                      selectNum:this.form.selectNum,
                      detailImg:detailImageIds,
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
  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
</style>