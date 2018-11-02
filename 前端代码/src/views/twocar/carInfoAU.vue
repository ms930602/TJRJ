<template>
	<div>
		<el-card class="box-card" style="margin-right: 5px; margin-left: 5px;" shadow="hover">
  <div slot="header" class="clearfix" >
    <span>上架信息</span>
  </div>
	<div>
  <el-form class="modal-form" :inline="true" :model="form" :rules="rules" ref="form" label-width="120px">
      <el-row>
        <el-col :span="24">
             <el-form-item label="车辆标题"  prop='title'>
               <inputItem :value.sync="form.title" style="width:607px"></inputItem>
              </el-form-item>
        </el-col>
      </el-row>
      <el-row >
        <el-col :span="6">
              <el-form-item label="最低价(万)"  prop='price'>
                  <inputItem :value.sync="form.price" type="number" maxlength="9"></inputItem>
              </el-form-item>
        </el-col>
        <el-col :span="6">
              <el-form-item label="显示价(万)"  prop='showPrice'>
                  <inputItem :value.sync="form.showPrice" type="number" maxlength="9"></inputItem>
              </el-form-item>
        </el-col>
        <el-col :span="6">
              <el-form-item label="新车价(万)"  prop='newPrice'>
                  <inputItem :value.sync="form.newPrice" type="number" maxlength="9"></inputItem>
              </el-form-item>
        </el-col>
        <el-col :span="6">
              <el-form-item label="参考价(区间)"  prop='consultPrice'>
                   <inputItem :value.sync="form.consultPrice"></inputItem>
              </el-form-item>
        </el-col>
      </el-row>

      <el-row >
        <el-col :span="6">
              <el-form-item label="关注数"  prop='showflag'>
                   <inputItem :value.sync="form.showflag" type="number" maxlength="9"></inputItem>
              </el-form-item>
        </el-col>
        <el-col :span="6">
              <el-form-item label="截止日期"  prop='endTime'>
                   <dateEditorDaterange :dateValue.sync="form.endTime" 
                   :showPickerOptions="false" type="date" style="width: 200px;"></dateEditorDaterange>
              </el-form-item>
        </el-col>
        <el-col :span="6">
              <el-form-item label="地点城市"  prop='address'>
                   <inputItem :value.sync="form.address"></inputItem>
              </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="6">
              <el-form-item label="是否特价"  prop='offerStatue'>
                   <selectInput :value.sync="form.offerStatue">
                      <el-option
                          v-for="item in offerStatueOption"
                          :key="item.key"
                          :label="item.value"
                          :value="item.key">
                        </el-option>
                    </selectInput>
              </el-form-item>
        </el-col>
        <el-col :span="6">
              <el-form-item label="是否上架"  prop='transactionStatu'>
                   <selectInput :value.sync="form.transactionStatu">
                      <el-option
                          v-for="item in transactionStatuOption"
                          :key="item.key"
                          :label="item.value"
                          :value="item.key">
                        </el-option>
                    </selectInput>
              </el-form-item>
        </el-col>
        <el-col :span="6">
              <el-form-item label="状态"  prop='status'>
                   <selectInput :value.sync="form.status">
                      <el-option
                          v-for="item in statusOption"
                          :key="item.key"
                          :label="item.value"
                          :value="item.key">
                        </el-option>
                    </selectInput>
              </el-form-item>
        </el-col>
      </el-row>
      <br/>
      <p>车辆信息</p>
      <hr/>
      <el-row >
          <el-col :span="6">
                  <el-form-item label="首图片"  prop='topImg'>
                    <el-upload
                      class="avatar-uploader"
                      :action="uploadURL"
                      :show-file-list="false"
                      :on-success="topSuccess"
                      accept="image/*"
                      :before-upload="topBeforeUpload">
                      <img v-if="imageUrl" :src="imageUrl" class="avatar">
                      <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                    </el-upload>
                  </el-form-item>
        </el-col>
      </el-row>
      <el-row >
        <el-col :span="6">
              <el-form-item label="过户次数"  prop='transferNum'>
                   <inputItem :value.sync="form.transferNum" type="number" maxlength="9"></inputItem>
              </el-form-item>
        </el-col>
        <el-col :span="6">
           <el-form-item label="过户费"  prop='transferPriceState'>
                <selectInput :value.sync="form.transferPriceState">
                  <el-option
                      v-for="item in transferPriceStateOption"
                      :key="item.key"
                      :label="item.value"
                      :value="item.key">
                    </el-option>
                </selectInput>
            </el-form-item>
        </el-col>
        <el-col :span="6">
              <el-form-item label="地点城市"  prop='address'>
                   <inputItem :value.sync="form.address"></inputItem>
              </el-form-item>
        </el-col>
        <el-col :span="6">
              <el-form-item label="表显里程(万里)"  prop='mileage'>
                   <inputItem :value.sync="form.mileage" type="number" maxlength="9"></inputItem>
              </el-form-item>
        </el-col>
      </el-row>
      <el-row >
        <el-col :span="6">
              <el-form-item label="上牌日期"  prop='upbkTime'>
                   <dateEditorDaterange :dateValue.sync="form.upbkTime" 
                   :showPickerOptions="false" type="date" style="width: 200px;"></dateEditorDaterange>
              </el-form-item>
        </el-col>
        <el-col :span="6">
              <el-form-item label="档位"  prop='dw'>
                   <selectInput :value.sync="form.dw">
                      <el-option
                          v-for="item in dwOption"
                          :key="item.key"
                          :label="item.value"
                          :value="item.key">
                        </el-option>
                    </selectInput>
              </el-form-item>
        </el-col>
        <el-col :span="6">
              <el-form-item label="排量"  prop='pl'>
                   <inputItem :value.sync="form.pl"></inputItem>
              </el-form-item>
        </el-col>
        <el-col :span="6">
              <el-form-item label="拍照归属"  prop='bkCitiy'>
                   <inputItem :value.sync="form.bkCitiy"></inputItem>
              </el-form-item>
        </el-col>
      </el-row>
      <el-row >
        <el-col :span="6">
              <el-form-item label="品牌"  prop='brand'>
                    <inputItem :value.sync="form.brand"></inputItem>
              </el-form-item>
        </el-col>
        <el-col :span="6">
              <el-form-item label="车型"  prop='type'>
                   <inputItem :value.sync="form.type"></inputItem>
              </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="24">
          <el-form-item label="备注" >
                <el-input type="textarea" v-model="form.remark"  style="width:800px"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <h5>详情图片</h5>
      <hr/>
      <el-row>
				<el-col :span="24">
           <el-form-item label="宣传图片"  prop='inventEndDate'>
                <el-upload
                  :action="uploadURL"
                  list-type="picture-card"
                  accept="image/*"
                  :multiple="false"
                  :limit="1"
                  :on-success="detailSuccessA"
                  :fileList="fileListA"
                  :before-upload="topBeforeUpload1"
                  :on-remove="handleRemove1">
                  <i class="el-icon-plus"></i>
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
      transferPriceStateOption:[
        {key:'0',value:'不含'},
        {key:'1',value:'包含'},
      ],
      dwOption:[
        {key:'自动挡',value:'自动挡'},
        {key:'手动挡',value:'手动挡'},
      ],
      offerStatueOption:[
        {key:'0',value:'否'},
        {key:'1',value:'是'},
      ],
      transactionStatuOption:[
        {key:'0',value:'下架'},
        {key:'1',value:'上架'},
      ],
      statusOption:[
        {key:'0',value:'正常'},
        {key:'1',value:'锁定'},
      ],
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
      dialogVisibleA: false,
      dialogVisibleB: false,
      dialogVisibleC: false,
      dialogVisibleD: false,
      dialogVisibleE: false,
      fileListA:[],
      fileListB:[],
      fileListC:[],
      fileListD:[],
      fileListE:[],
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
        khName:'',
        topImg: null,
        mp3Id: null,
        detailImg: '',
        status:0,
        redpackTitle:'',
        redpackContent:'',
        vxText:''
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
        khName: [this._ruleRequired("客户名称")],
        vxText: [this._ruleRequired("微信页脚信息")],
        redpackTitle: [this._ruleRequired("红包标题")],
        redpackContent: [this._ruleRequired("红包描述")],
        
      }
    };
  },
  mounted() {
    //this.loadMerchant();
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
        this.fileURL = ROOT_API+'servlet/getfile?path=' + data.aaData.path
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
        this.imageUrl = ROOT_API+'servlet/getfile?path=' + res.aaData.path;
      }else{
        this.$message({ type: "error", message: "上传失败!" });
      }
    },
    detailSuccessA(res, file) {
      if(res.state == 0){
        this.detailImgA = res.aaData.loadId;
        this.imageUrlA = ROOT_API+'servlet/getfile?path=' + res.aaData.path;
      }else{
        this.$message({ type: "error", message: "上传失败!" });
      }
    },
    detailSuccessB(res, file) {
      if(res.state == 0){
        this.detailImgB = res.aaData.loadId;
        this.imageUrlB = ROOT_API+'servlet/getfile?path=' + res.aaData.path;
      }else{
        this.$message({ type: "error", message: "上传失败!" });
      }
    },
    detailSuccessC(res, file) {
      if(res.state == 0){
        this.detailImgC = res.aaData.loadId;
        this.imageUrlC = ROOT_API+'servlet/getfile?path=' + res.aaData.path;
      }else{
        this.$message({ type: "error", message: "上传失败!" });
      }
    },
    detailSuccessD(res, file) {
      if(res.state == 0){
        this.detailImgD = res.aaData.loadId;
        this.imageUrlD = ROOT_API+'servlet/getfile?path=' + res.aaData.path;
      }else{
        this.$message({ type: "error", message: "上传失败!" });
      }
    },
    detailSuccessE(res, file) {
      if(res.state == 0){
        this.detailImgE = res.aaData.loadId;
        this.imageUrlE = ROOT_API+'servlet/getfile?path=' + res.aaData.path;
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
    topBeforeUpload1(file) {
      return new Promise((resolve, reject) => {
          this.$nextTick(() => {
                  var fileType = file.type
                  //图片限制4M，其他附件限制50M
                  let limitType = 10
                  this.uploadURL = configs.uploadFileURL + '/file/imgUpload?sort=1&savePath=vx&token=' + local.get('token')
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
    handleRemove1(file, fileList){
      this.detailImgA = null;
    },
    handleRemove2(file, fileList){
      this.detailImgB = null;
    },
    handleRemove3(file, fileList){
      this.detailImgC = null;
    },
    handleRemove4(file, fileList){
      this.detailImgD = null;
    },
    handleRemove5(file, fileList){
      this.detailImgE = null;
    },
    topBeforeUpload2(file) {
      return new Promise((resolve, reject) => {
          this.$nextTick(() => {
                  var fileType = file.type
                  //图片限制4M，其他附件限制50M
                  let limitType = 10
                  this.uploadURL = configs.uploadFileURL + '/file/imgUpload?sort=2&savePath=vx&token=' + local.get('token')
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
    topBeforeUpload3(file) {
      return new Promise((resolve, reject) => {
          this.$nextTick(() => {
                  var fileType = file.type
                  //图片限制4M，其他附件限制50M
                  let limitType = 10
                  this.uploadURL = configs.uploadFileURL + '/file/imgUpload?sort=3&savePath=vx&token=' + local.get('token')
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
    topBeforeUpload4(file) {
      return new Promise((resolve, reject) => {
          this.$nextTick(() => {
                  var fileType = file.type
                  //图片限制4M，其他附件限制50M
                  let limitType = 10
                  this.uploadURL = configs.uploadFileURL + '/file/imgUpload?sort=4&savePath=vx&token=' + local.get('token')
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
    topBeforeUpload5(file) {
      return new Promise((resolve, reject) => {
          this.$nextTick(() => {
                  var fileType = file.type
                  //图片限制4M，其他附件限制50M
                  let limitType = 10
                  this.uploadURL = configs.uploadFileURL + '/file/imgUpload?sort=5&savePath=vx&token=' + local.get('token')
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
        this.fileURL = ROOT_API+'servlet/getfile?path=' + data.musicObj.filePath
      }

      if(data.topImgObj){
        this.imageUrl = ROOT_API+'servlet/getfile?path=' + data.topImgObj.filePath;
      }

      if(data.detailImgObj){
        var temp = data.detailImgObj;
        var size = temp.length;
        if(size >= 1){
          this.detailImgA = temp[0].id;
          this.fileListA = [{
            url:ROOT_API+'servlet/getfile?path=' + temp[0].filePath
          }];
        }

        if(size >= 2){
          this.detailImgB = temp[1].id;
          this.fileListB = [{
            url:ROOT_API+'servlet/getfile?path=' + temp[1].filePath
          }];
        }
        if(size >= 3){
          this.detailImgC = temp[2].id;
          this.fileListC = [{
            url:ROOT_API+'servlet/getfile?path=' + temp[2].filePath
          }];
        }

        if(size >= 4){
          this.detailImgD = temp[3].id;
          this.fileListD = [{
            url:ROOT_API+'servlet/getfile?path=' + temp[3].filePath
          }];
        }

        if(size >= 5){
          this.detailImgD = temp[4].id;
          this.fileListE = [{
            url:ROOT_API+'servlet/getfile?path=' + temp[4].filePath
          }];
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

      if(this.detailImgB && this.detailImgB!= ''){
        if(detailImageIds && detailImageIds != ''){
          detailImageIds = detailImageIds + "," + this.detailImgB;
        }else{
          detailImageIds = this.detailImgB;
        }
      }

      if(this.detailImgC && this.detailImgC!= ''){
        if(detailImageIds && detailImageIds != ''){
          detailImageIds = detailImageIds + "," + this.detailImgC;
        }else{
          detailImageIds = this.detailImgC;
        }
      }

      if(this.detailImgD && this.detailImgD!= ''){
        if(detailImageIds && detailImageIds != ''){
          detailImageIds = detailImageIds + "," + this.detailImgD;
        }else{
          detailImageIds = this.detailImgD;
        }
      }

      if(this.detailImgE && this.detailImgE!= ''){
        if(detailImageIds && detailImageIds != ''){
          detailImageIds = detailImageIds + "," + this.detailImgE;
        }else{
          detailImageIds = this.detailImgE;
        }
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
                      vxText:this.form.vxText,
                      redpackTitle:this.form.redpackTitle,
                      redpackContent:this.form.redpackContent,
                      phone:this.form.phone,
                      khName:this.form.khName
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
                      vxText:this.form.vxText,
                      redpackTitle:this.form.redpackTitle,
                      redpackContent:this.form.redpackContent,
                      phone:this.form.phone,
                      khName:this.form.khName
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