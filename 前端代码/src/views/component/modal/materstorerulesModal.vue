<template>
		<el-dialog custom-class="jz-modal" :title="modaltype === 'add' ? '新增物料存放规则' : '编辑物料存放规则'" :visible="modalshow"  :before-close="beforeClose" :width="modalWidth" :close-on-click-modal="false">
		  	<el-form class="modal-form" :inline="true" :model="form" :rules="rules" ref="form" label-width="100px">
      <el-row>
          <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
			            <el-form-item label="物料名称"  prop='materName'>
			                	<el-select
								    v-model="form.materName"
								    filterable
								    remote
								    reserve-keyword
								    placeholder="请输入关键词"
								    @change = "materIdChange"
								    :remote-method="getMaterId"
								    :loading="loading">
								    <el-option
								      v-for="item in materId"
								      :key="item.value"
								      :label="item.label"
								      :value="item.value">
								    </el-option>
								  </el-select>
					    </el-form-item>
	              <!-- <el-form-item label="物料Id" required prop='materId'>
		    		<inputItem :value.sync="form.materId" :maxlength="17"></inputItem>
		      	</el-form-item> -->
				</el-col>
        <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
           <el-form-item label="物料id" required prop='materId' >
		   	 		<inputItem :value.sync="form.materId"  readonly="true"></inputItem>
		    	</el-form-item>
				</el-col>
			</el-row>
        <el-row>

       <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
	          <el-form-item label="物料编码" required prop='materCode'>
		    		<inputItem :value.sync="form.materCode" :maxlength="50" readonly="true"></inputItem>
		      	</el-form-item>
				</el-col>
       	<el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12" >
                <el-form-item label="存储期限[天]" required prop='deadline'>
		   	 		<inputItem :value.sync="form.deadline" :maxlength="10" type="number"></inputItem>
		    	</el-form-item>
				</el-col>
			</el-row>
      <el-row>

                <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
	              <el-form-item label="最低存库[件]" required  prop='minStock'>
		    		<inputItem :value.sync="form.minStock" :maxlength="21" type="number"></inputItem>
		      	</el-form-item>
				</el-col>
        				<el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                <el-form-item label="最高存库[件]" required prop='maxStock'>
		   	 		<inputItem :value.sync="form.maxStock" :maxlength="21" type="number"></inputItem> 
		    	</el-form-item>
				</el-col>
			</el-row>
      <el-row>

                <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
	              <el-form-item label="备注"  prop='remark'>
		    		<inputItem type="textarea" :value.sync="form.remark" :maxlength="100"></inputItem>
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
        materId: null,
        materCode: "",
        materName: "",
        minStock: "",
        maxStockL:"",
        remark:"",
        num8: 1
      },
      rules: {
          materId: [{required: true, message: '物料id不能为空' }, this._ruleLength(17)],
          materName: [{required: true, message: '物料名称不能为空' }, this._ruleLength(50)],
          materCode: [{required: true, message: '物料编号不能为空' }],
					deadline: [{required: true, message: '储存期限不能为空' }, this._ruleLength(10)],
					minStock: [{required: true, message: '最小库存不能为空' }, this._ruleLength(21)],
					maxStock: [{required: true, message: '最高库存不能为空' }, this._ruleLength(21)]
           },
      userinfo: local.get("userinfo"),
      materId:[],
      materCode:[],
      materName:[],
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
    modalshow: {
      default: false
    }
  },
  computed: {},
  mounted() {
    if (this.modaltype != "add") {
      Object.assign(this.form, this.tableRow);
    };
    this.getMaterId();
    // this.getMaterCode();
    // this.getMaterName();
  },
  methods: {
    
    cancel() {
      this.$emit("close");
    },
    save(formname) {
      this.$refs[formname].validate(valid => {
        if (valid) {
           if(this.form.maxStock<0){
                this.$message({
                    type: "warning",
                    message: "最高库存不能小于0"
                  });
                return;
            };
            if(this.form.minStock<0){
                this.$message({
                    type: "warning",
                    message: "最低库存不能小于0"
                  });
                return;
            }
            //校验是否填写正确，库存数
            if(this.form.maxStock<this.form.minStock){
                this.$message({
                    type: "warning",
                    message: "最高库存不能小于最低库存"
                  });
                return;
            }
          if (this.tableRow && this.tableRow.id > 0) {
            //编辑
            Object.assign(this.form, {
              updatedPersonId: this.userinfo.userId,
              updatedPerson: this.userinfo.nickName
            });

            this._ajax({
              url: this.rootAPI,
              name: "materstorerules/update",
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
              name: "materstorerules/create",
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
        param: {'materName':query,'extend':'true'}, 
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