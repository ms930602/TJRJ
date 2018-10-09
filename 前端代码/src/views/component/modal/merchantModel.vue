<template>
		<el-dialog custom-class="jz-modal" :title="modaltype === 'add' ? '新增客商信息' : '编辑客商信息'" :visible="modalshow"  :before-close="beforeClose" :width="modalWidth" :close-on-click-modal="false">
		  	<el-form class="modal-form" :inline="true" :model="form" :rules="rules" ref="form" label-width="100px">
      <el-row>
          <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
           <!-- <el-form-item label="仓库代码"  prop='warCode' v-if="modaltype ==='add'"> -->
		   	 		  <!-- <inputItem :value.sync="form.warCode"  readonly="true">自动生成</inputItem> -->
                <!-- <span>自动生成</span>
		    	</el-form-item> -->
          <el-form-item label="代码" required prop='code' v-if="modaltype ==='edit'">
		   	 	<inputItem :value.sync="form.code"  readonly="true"></inputItem>
		    	</el-form-item> 
				</el-col>
        <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
           <el-form-item label="名称" required prop='name'>
		   	 		<inputItem :value.sync="form.name"></inputItem>
		    	</el-form-item>
				</el-col>
			</el-row>
        <el-row>

       <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
          <el-form-item label="行业内外标识" prop="isIndustry" v-if="modaltype">
            <selectInput :value.sync="form.isIndustry" filterable @selectChange="claSelectChange" :clearable="true">
                <!-- <el-option v-for="item in claList" :key="item.id" :label="item.dicName" :value="item.dicCode">
                </el-option> -->
                <el-option 
						      v-for="item in claList"
                :key="item.id"
                :label="item.dicName"
                :value="item.dicCode">
						    </el-option>
            </selectInput>
        </el-form-item>
				</el-col>
       	<el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12" >
          <el-form-item label="客商属性" prop="comProviderProp">
            <selectInput :value.sync="form.comProviderProp" filterable @selectChange="PropelectChange" :clearable="true">
                <!-- <el-option v-for="item in PropList" :key="item.id" :label="item.dicName" :value="item.dicCode">
                </el-option> -->
                <el-option 
						      v-for="item in PropList"
	                :key="item.id"
                :label="item.dicName"
                :value="item.dicCode">
						    </el-option>
            </selectInput>
        </el-form-item>

				</el-col>
			</el-row>
      <el-row>
        <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
	        <el-form-item label="纳税人登记号"   prop='tegRegNum'>
		    		<inputItem :value.sync="form.tegRegNum" ></inputItem>
		    	</el-form-item>
				</el-col>
        <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
        <el-form-item label="客商类型" prop="comProviderType">
            <selectInput :value.sync="form.comProviderType" :clearable="true">
                <el-option
                v-for="item in isSupStoreList"
                :key="item.id"
                :label="item.dicName"
                :value="item.dicCode"
                >
                </el-option>
            </selectInput>
        </el-form-item>
				</el-col>
			</el-row>

      <el-row>
        <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
	        <el-form-item label="法人代表"   prop='legalbody'>
		    		<inputItem :value.sync="form.legalbody" ></inputItem>
		    	</el-form-item>
				</el-col>
        <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
          <el-form-item label="联系人"  prop='linkman'>
		   	 		<inputItem :value.sync="form.linkman" ></inputItem> 
		    	</el-form-item>
				</el-col>
			</el-row>

      <el-row>
        <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
	        <el-form-item label="银行名称"   prop='bankName'>
		    		<inputItem :value.sync="form.bankName"></inputItem>
		    	</el-form-item>
				</el-col>
        <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
          <el-form-item label="银行账号"  prop='bankAccount'>
		   	 		<inputItem :value.sync="form.bankAccount"></inputItem> 
		    	</el-form-item>
				</el-col>
			</el-row>

      <el-row>
        <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
	        <el-form-item label="使用公司"  prop='useCompany'>
		    		<inputItem :value.sync="form.useCompany" :maxlength="21"></inputItem>
		    	</el-form-item>
				</el-col>
        <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">

        <el-form-item label="状态" prop="status"> 
            <el-select v-model="form.status" placeholder="请选择状态">
            <el-option label="发布" value="2"></el-option>
            <el-option label="停用" value="3"></el-option>
            </el-select>
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
          code:'',
          name: '',
          tegRegNum: '',
          legalbody: '',
					linkman: '',
					bankName: '',
          bankAccount: '',
          useCompany: '',
          status: '',
          isIndustry:'1',
          comProviderProp:'1',
          comProviderType:'0',

      },
      rules: {
          name: [{required: true, message: '名称不能为空' }, this._ruleLength(100)],
					tegRegNum: [ this._ruleLength(50)],
          legalbody: [ 	this._ruleMobile(100),],
          linkman: [ this._ruleLength(50)],
          bankName: [this._ruleLength(50)],
          bankAccount: [ this._ruleLength(30)],
          useCompany: [ this._ruleLength(255)],
          status: [{required: true, message: '状态不能为空' }],
           },
      userinfo: local.get("userinfo"),
      claList:[],
      PropList:[],
      isSupStoreList:[],
      materIds:'',
    };
  },
  props: {
    modaltype: {
      default: "add"
    },
    tableRow: {
      default: {}
    },
    warehouseInfo:{
      default:{}
    },
    modalshow: {
      default: false
    }
  },
  computed: {},
  mounted() {
    if (this.modaltype != "add") {
      Object.assign(this.form, this.tableRow);
    };
    Object.assign(this.form, this.warehouseInfo)   
        let method = 'dictionary/list';
        //行业内标识符
        this._ajax({url: this.rootAPI + method, param: {
            'claCode':'MERCHANT_DUSTRY'
        }})
        .then((function(d) {
    this.claList = d.aaData;
            // console.log(d.aaData)
        }).bind(this));
    //客商属性
    this._ajax({url: this.rootAPI + method, param: {
            'claCode':'MACHANT_PRO'
        }})
        .then((function(d) {
    this.PropList = d.aaData;
            // console.log(d.aaData)
        }).bind(this));
   //客商类型
    this._ajax({url: this.rootAPI + method, param: {
            'claCode':'MERCHANT_TYPE'
        }})
        .then((function(d) {
    this.isSupStoreList = d.aaData; 
            // console.log(d.aaData)
        }).bind(this));
  },
  methods: {
    
    cancel() {
      this.$emit("close");
    },
    claSelectChange(ob){
    },
    PropelectChange(ob){

    },
    SupStoreSelectChange(ob){

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
              name: "merchant/update",
              param: this.form
            }).then(
              (d => {
                if (d.state == 0) {
                  this.$message({ type: "success", message: "保存成功" });
                  this.$emit("submit");
                } else {
                  this.$message({ type: "warning", message: "保存失败:"  + d.msg
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
              name: "merchant/create",
              param: this.form
            }).then(
              (d => {
                if (d.state == 0) {
                  this.$message({ type: "success", message: "保存成功" });
                  this.$emit("submit");
                } else {
                  this.$message({
                    type: "warning",
                    message: "保存失败"  + d.msg
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
      	/**
  	 * 获取物料id
  	 */
  	getMaterId(query){
  		if(query==null){
  			query='';
  		}
      var vm = this
      var form=this.form;
      vm.materId = []
      return vm._ajax({
        url: vm.rootAPI, 
        name: 'materialinfo/list', 
        param: {'materName':query}, 
        }).then((d) => {
          if(d.state === 0){
            var aaData = d.aaData
            aaData.forEach(function(el) {
              vm.materId.push({
                value: el.materCode,
                  label: el.materName+'['+el.versioncode+']'
              })
            })	
          }
          }, (d) => {
                  this.$message.error('数据获取失败');
              })
    },
    /**
     * 获取选择id
     */
  materIdChange(val){
    // //拆分参数
    // console.log(val);

    // return;
      var vm = this
      // form=.form;
      return vm._ajax({
        url: vm.rootAPI, 
        name: 'materialinfo/queryByMaterCode', 
        param: { 'materCode':val}, 
        }).then((d) => {
            var aaData = d.aaData;
            vm.form.materId=aaData.id;
            vm.form.materCode=aaData.materCode;
            vm.form.materName=aaData.materName;
          
          }, (d) => {
                  this.$message.error('数据获取失败');
              })
  	},
  }
};
</script>