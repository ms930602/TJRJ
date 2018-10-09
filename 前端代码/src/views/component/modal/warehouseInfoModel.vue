<template>
		<el-dialog custom-class="jz-modal" :title="modaltype === 'add' ? '新增仓库信息' : '编辑仓库信息'" :visible="modalshow"  :before-close="beforeClose" :width="modalWidth" :close-on-click-modal="false">
		  	<el-form class="modal-form" :inline="true" :model="form" :rules="rules" ref="form" label-width="100px">
      <el-row>
          <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
           <!-- <el-form-item label="仓库代码"  prop='warCode' v-if="modaltype ==='add'"> -->
		   	 		  <!-- <inputItem :value.sync="form.warCode"  readonly="true">自动生成</inputItem> -->
                <!-- <span>自动生成</span>
		    	</el-form-item> -->
          <el-form-item label="仓库代码" required prop='warCode' v-if="modaltype ==='edit'">
		   	 	<inputItem :value.sync="form.warCode"  readonly="true"></inputItem>
		    	</el-form-item>
				</el-col>
        <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
           <el-form-item label="仓库名称" required prop='warName'>
		   	 		<inputItem :value.sync="form.warName"></inputItem>
		    	</el-form-item>
				</el-col>
			</el-row>
        <el-row>

       <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
          <el-form-item label="仓库类别" prop="warTypeId" v-if="modaltype === 'add'">
            <selectInput :value.sync="form.warTypeId" filterable @selectChange="claSelectChange" :clearable="true">
                <el-option v-for="item in claList" :key="item.id" :label="item.dicName" :value="item.dicCode">
                </el-option>
            </selectInput>
        </el-form-item>
        <el-form-item label="仓库类别" prop="warTypeId" v-if="modaltype != 'add'">
            <selectInput :value.sync="form.warTypeId"  :clearable="true">
                <el-option
                v-for="item in claList"
                :key="item.id"
                :label="item.dicName"
                :value="item.dicCode"
                >
                </el-option>
            </selectInput>
        </el-form-item>
				</el-col>
       	<el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12" >
          <el-form-item label="仓库属性" prop="warProp">
            <selectInput :value.sync="form.warProp" filterable @selectChange="PropelectChange" :clearable="true">
                <el-option v-for="item in PropList" :key="item.id" :label="item.dicName" :value="item.dicCode">
                </el-option>
            </selectInput>
        </el-form-item>

				</el-col>
			</el-row>
      <el-row>
        <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
	        <el-form-item label="仓库地址"   prop='warAddress'>
		    		<inputItem :value.sync="form.warAddress" :maxlength="21"></inputItem>
		    	</el-form-item>
				</el-col>
        <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
        <el-form-item label="是否供应商寄存" prop="isSupStore" label-width="120px">
            <selectInput :value.sync="form.isSupStore" :clearable="true">
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
	        <el-form-item label="负责人"   prop='leaderNane'>
		    		<inputItem :value.sync="form.leaderNane" :maxlength="21"></inputItem>
		    	</el-form-item>
				</el-col>
        <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
          <el-form-item label="电话"  prop='phoneNum'>
		   	 		<inputItem :value.sync="form.phoneNum" :maxlength="21"></inputItem> 
		    	</el-form-item>
				</el-col>
			</el-row>

      <el-row>
        <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
	        <el-form-item label="邮编"   prop='zipCode'>
		    		<inputItem :value.sync="form.zipCode" :maxlength="21"></inputItem>
		    	</el-form-item>
				</el-col>
        <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
          <el-form-item label="公司"  prop='companyId'>
		   	 		<inputItem :value.sync="form.companyId" :maxlength="21"></inputItem> 
		    	</el-form-item>
				</el-col>
			</el-row>

      <el-row>
        <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
	        <el-form-item label="生产点"  prop='productPoint'>
		    		<inputItem :value.sync="form.productPoint" :maxlength="21"></inputItem>
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
          warCode: '',
          warName: '',
          warTypeId: '01',
					warProp: '01',
					warAddress: '',
          leaderNane: '',
          phoneNum: '',
          zipCode: '',
          companyId: '',
          isSupStore:'N',
          productPoint: '',
          status: '',
      },
      rules: {
          warName: [{required: true, message: '仓库名称不能为空' }, this._ruleLength(50)],
					warAddress: [ this._ruleLength(200)],
          leaderNane: [ this._ruleLength(50)],
          phoneNum: [ 	this._ruleMobile(),],
          zipCode: [ this._ruleLength(10)],
          companyId: [this._ruleLength(8)],
          productPoint: [ this._ruleLength(8)],
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
        //仓库类别
        this._ajax({url: this.rootAPI + method, param: {
            'claCode':'WAR_TYPE_ID'
        }})
        .then((function(d) {
    this.claList = d.aaData;
            // console.log(d.aaData)
        }).bind(this));
    //仓库属性
    this._ajax({url: this.rootAPI + method, param: {
            'claCode':'WAR_PROP'
        }})
        .then((function(d) {
    this.PropList = d.aaData;
            // console.log(d.aaData)
        }).bind(this));
   //是否供应商寄存
    this._ajax({url: this.rootAPI + method, param: {
            'claCode':'IS_SUP_STORE'
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
      console.log(ob);
        		// let obj = {};
            // obj = this.claList.find((item)=>{
            //     return item.value === ob;
            // });
            // this.form.warTypeId = obj.label;
        // var obj = this.claList.find((item)=>{//这里的userList就是上面遍历的数据源
        //     return item.terminalType === ob;//筛选出匹配数据
        // });
        // // console.log(obj);
        // this.form.terminalType = obj.terminalType;
        // this.form.claName = obj.claName;
        // console.log(this.form.terminalType);
    },
    PropelectChange(ob){
        // var obj = this.PropList.find((item)=>{//这里的userList就是上面遍历的数据源
        //     return item.terminalType === ob;//筛选出匹配数据
        // });
        // // console.log(obj);
        // this.form.terminalType = obj.terminalType;
        // this.form.claName = obj.claName;
        // // console.log(this.form.terminalType);
    },
    SupStoreSelectChange(ob){
    // var obj = this.isSupStoreList.find((item)=>{//这里的userList就是上面遍历的数据源
    //     return item.terminalType === ob;//筛选出匹配数据
    // });
    // // console.log(obj);
    // this.form.terminalType = obj.terminalType;
    // this.form.claName = obj.claName;
    // // console.log(this.form.terminalType);
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
              name: "warehouseinfo/update",
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
              name: "warehouseinfo/create",
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