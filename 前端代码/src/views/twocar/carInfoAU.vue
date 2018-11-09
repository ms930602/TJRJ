<template>
	<div>
		<el-card class="box-card" style="margin-right: 5px; margin-left: 5px;" shadow="hover">
  <div slot="header" class="clearfix" >
    <span>上架信息</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<span style="color: red;font-size: 8px;">
			提示：特价商品差价为【显示价】 减去 【最低价】 以【最低价】出售，非特价用户只看得到【显示价】
			特价商品会使用截止日期
		</span>
  </div>
	<div>
  <el-form class="modal-form" :inline="true" :model="form" :rules="rules" ref="form" label-width="120px">
			<el-row>
				<el-col :span="6">
							<el-form-item label="品牌"  prop='intA' >
										<selectInput :value.sync="form.intA" @selectChange="selectChange">
											<el-option
													v-for="item in brandOption"
													:key="item.key"
													:label="item.value"
													:value="item.key">
												</el-option>
										</selectInput>
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
					<el-form-item label="首付价格(万)"  prop='firstPrice'>
							<inputItem :value.sync="form.firstPrice" type="number" maxlength="9"></inputItem>
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
              <el-form-item label="关注数"  prop='showflag'>
                   <inputItem :value.sync="form.showflag" type="number" maxlength="9"></inputItem>
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
							<el-form-item label="限迁标准"  prop='xqbz'>
									<inputItem :value.sync="form.xqbz"></inputItem>
							</el-form-item>
				</el-col>
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
							<el-form-item label="截止日期"  prop='endTime'>
									<dateEditorDaterange :dateValue.sync="form.endTime" 
									:showPickerOptions="false" type="date" style="width: 200px;"></dateEditorDaterange>
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
							<el-form-item label="表显里程(万里)"  prop='mileage'>
									 <inputItem :value.sync="form.mileage" type="number" maxlength="9"></inputItem>
							</el-form-item>
				</el-col>
				<el-col :span="6">
							<el-form-item label="咨询电话"  prop='strA'>
									<inputItem :value.sync="form.strA" maxlength="20"></inputItem>
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
                   <inputItem :value.sync="form.pl" :maxlength="10"></inputItem>
              </el-form-item>
        </el-col>
        <el-col :span="6">
              <el-form-item label="拍照归属"  prop='bkCitiy'>
                   <inputItem :value.sync="form.bkCitiy"></inputItem>
              </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="24">
          <el-form-item label="备注" >
                <el-input type="textarea" v-model="form.remark"  style="width:800px;" :autosize="{ minRows: 10}"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <h5>详情图片</h5>
      <hr/>
      <el-row>
				<el-col :span="24">
          <el-upload
            accept="image/*"
            :action="uploadDetailURL"
            list-type="picture-card"
            :file-list="detailImg"
            :on-success="detailSuccess"
            :before-upload="beforeDetailUpload"
            :on-remove="onRemoveDetail">
            <i class="el-icon-plus"></i>
          </el-upload>
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
			toPage:null,
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
			brandOption:[],
      uploadURL:'',
      uploadDetailURL:'',
      imageUrl:'',
      fileURL:'',
      topFileList:[],
      detailImg:[],
      form: {
        id: null,
        title: "",
        price: null,
        offerStatue:'0',
        status:'0',
        transactionStatu:'1',
        showPrice:null,
				xqbz:'国V',
				strA:'',
				intA:1,
				firstPrice:3.86,
        newPrice:null,
        consultPrice:null,
        showflag:null,
        endTime:null,
        address:null,
        transferNum:0,
        remark:'',
        transferPriceState:'0',
        type:'宝马1系',
        mileage:null,
        upbkTime:null,
        dw:"自动挡",
        pl:'2L',
        bkCitiy:null,
        brand:'宝马',
        topImg: null,
        imgs:''
      },
      userinfo: local.get("userinfo"),
      rules: {
        title: [this._ruleRequired("标题")],
        price: [this._ruleRequired("价格"),this._ruleLength(9)],
        showPrice: [this._ruleRequired("显示价"),this._ruleLength(9)],
        newPrice: [this._ruleRequired("新车价"),this._ruleLength(9)],
        consultPrice: [this._ruleRequired("参考价")],
        showflag: [this._ruleRequired("关注数")],
        endTime: [this._ruleRequired("截止日期")],
        address: [this._ruleRequired("城市地点")],
        offerStatue: [this._ruleRequired("是否特价")],
        transactionStatu: [this._ruleRequired("是否上架")],
        status: [this._ruleRequired("状态")],
        transferNum: [this._ruleRequired("过户次数")],
        transferPriceState: [this._ruleRequired("过户费")],
        type: [this._ruleRequired("车型")],
        mileage: [this._ruleRequired("里程")],
        upbkTime: [this._ruleRequired("日期")],
        dw: [this._ruleRequired("档位")],
        pl: [this._ruleRequired("排量")],
        bkCitiy: [this._ruleRequired("拍照归属")],
        brand: [this._ruleRequired("品牌")],
				strA: [this._ruleRequired("咨询电话")],
				xqbz: [this._ruleRequired("限迁标准")],
				
        
      }
    };
  },
  mounted() {
    var id = this.$route.query.id;
		this.toPage = this.$route.query.pageNum
		this.loadBrand();
    if (id) {
      this.form.id = id;
      this.searchObject();
    } else {
      this.form.id = null;
    }
  },
  methods: {
		selectChange(vId){
			let obj = {};
      obj = this.brandOption.find((item)=>{//这里的userList就是上面遍历的数据源
          return item.key === vId;//筛选出匹配数据
      });
			this.form.brand = obj.value;
		},
		loadBrand(){
			var _this = this;
			let method = 'carBrand/list';
			this._ajax({url: this.rootAPI + method }).then((function(d) {
				if(d.aaData && d.aaData.length > 0){
						d.aaData.forEach(temp=>{
							_this.brandOption.push({key:temp.id,value:temp.name})
						});
				}
			}).bind(this))
		},
    detailSuccess(res, file){
      var imgYU = ROOT_API+'servlet/getfile?path=' + res.aaData.path;
      this.detailImg.push({loadId: res.aaData.loadId,url: imgYU})
    },
    onRemoveDetail(file, fileList){
      this.detailImg = fileList;
    },
    beforeDetailUpload(file) {
      return new Promise((resolve, reject) => {
          this.$nextTick(() => {
                  var fileType = file.type
                  //图片限制4M，其他附件限制50M
                  let limitType = 10
                  this.uploadDetailURL = configs.uploadFileURL + '/file/imgUpload?savePath=car&token=' + local.get('token')
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
    topSuccess(res, file) {
      if(res.state == 0){
        this.form.topImg = res.aaData.loadId;
        this.imageUrl = ROOT_API+'servlet/getfile?path=' + res.aaData.path;
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
                  this.uploadURL = configs.uploadFileURL + '/file/imgUpload?savePath=car&token=' + local.get('token')
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
        url: this.rootAPI + "carInfo/queryById",
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
      var _this = this;
      if(data.topImgObj){
        this.imageUrl = ROOT_API+'servlet/getfile?path=' + data.topImgObj.filePath;
      }

      if(data.detailImgObj){
        var imgYU = ROOT_API+'servlet/getfile?path=';
        data.detailImgObj.forEach(temp=>{
          _this.detailImg.push({loadId: temp.id,url: imgYU + temp.filePath})
        })
      }
    },
    cancel() {
			if(this.toPage){
				this.$router.push({ path: "/consultationMain",query:{pageNum:this.toPage} });
			}else{
				this.$router.push({ path: "/carInfoMain" });
			}
    },
    save() {
      var detailImageIds = '';
      if(this.detailImg){
        this.detailImg.forEach(temp=>{
            if(detailImageIds != ''){
              detailImageIds+=',';
            }
            detailImageIds += temp.loadId;
        })
      }


      this.$refs['form'].validate((valid) => {
          if (valid) {
              let o = {}, method = 'carInfo/update';
              o = {
                id: null,
                title:this.form.title,
                price:this.form.price,
                offerStatue:this.form.offerStatue,
                status:this.form.status,
                transactionStatu:this.form.transactionStatu,
                showPrice:this.form.showPrice,
                newPrice:this.form.newPrice,
                consultPrice:this.form.consultPrice,
                showflag:this.form.showflag,
                endTime:this.form.endTime,
                address:this.form.address,
                transferNum:this.form.transferNum,
                transferPriceState:this.form.transferPriceState,
                type:this.form.type,
                mileage:this.form.mileage,
                upbkTime:this.form.upbkTime,
                dw:this.form.dw,
                remark:this.form.remark,
                pl:this.form.pl,
                bkCitiy:this.form.bkCitiy,
                brand:this.form.brand,
								intA:this.form.intA,
                topImg:this.form.topImg,
								xqbz:this.form.xqbz,
								firstPrice:this.form.firstPrice,
								strA:this.form.strA,
                imgs:detailImageIds
              }
              if(this.form.id && this.form.id > 0) {
                  o.id = this.form.id;
              }else {
                  method = 'carInfo/create'
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