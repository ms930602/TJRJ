<template>
	<el-dialog custom-class="jz-modal" :title="modalTypeTitle === 'add' ? '新增物品信息' : '编辑物品信息'" :visible="modal" :before-close="beforeClose" :close-on-click-modal="false" :width="modalWidth">
            <el-form class="modal-form" v-if="modal" :model="form" ref="form" :inline="true" :rules="rules" label-width="80px">
                <el-row>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="所属游戏" prop="gameId">
                            <selectInput :value.sync="form.gameId" filterable :clearable="true">
                                <el-option
                                  v-for="item in gameOption"
                                  :key="item.id"
                                  :label="item.name"
                                  :value="item.id">
                                </el-option>
                            </selectInput>
                        </el-form-item>
                    </el-col>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="物品名称" prop="name">
                            <inputItem :value.sync="form.name"></inputItem>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="是否期限" prop="type">
                            <el-radio v-model="form.type" label="0">永久</el-radio>
                            <el-radio v-model="form.type" label="1">期限</el-radio>
                        </el-form-item>
                    </el-col>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="备注" prop="remark">
                            <inputItem type="textarea" :value.sync="form.remark"></inputItem>
                        </el-form-item>
                    </el-col>
                </el-row>
            </el-form>              
            <div slot="footer" class="dialog-footer flex-x-end">
                <elBtn @click="cancel" text="取消">取消</elBtn>
                <elBtn @click="submit" type="primary" text="提交">提交</elBtn>
            </div>
        </el-dialog>
</template>
<script>
import mixin from '../../../mixin/mixin.js'
import local from '../../../local.js'
import configs from "../../../configs.js";
	export default {
        mixins: [mixin],
		data() {
            var vm = this
            return {
				form: {
                    gameId: 1,
                    name: '',
                    type: '0',
                    remark: ''
                },
                gameOption: [],
                rules: {
                    gameId: [{required: true, message: '所属游戏不能为空' }],

                    name: [
                {required: true, message: '物品名称不能为空' }, 
                this._ruleExistByParam(configs.rootAPI + "itemMs/checkItemName",{gameId:1}, "该物品",this.objItem),
                this._ruleLength(100)
                        ]
                },
                thisUser: local.get('userinfo')
			}
		},
		props: {
			modal: {
				default: false
			},
            modalTypeTitle: {
                default: 'add'
            },
            objItem: {
                default: function() {
                    return {}
                }
            }
		},
        computed: {
           
        },
		mounted() {
            Object.assign(this.form, this.objItem)    
            let method = 'gameMs/list';
            this._ajax({url: this.rootAPI + method })
            .then((function(d) {
                this.gameOption = d.aaData;
                if(d.aaData && d.aaData.length > 0){
                    this.form.gameId = d.aaData[0].id;
                }
            }).bind(this))
		},
		methods: {
            claSelectChange(ob){
               
            },
			cancel() {
				this.$emit('close')
			},
			submit() {
                this.$refs['form'].validate((valid) => {
                    if (valid) {
                        let o = {}, method = 'itemMs/update';
                        if(this.modalTypeTitle === 'add') {  
                            method = 'itemMs/create' 
                            o = {
                                name: this.form.name,
                                gameId: this.form.gameId,
                                type: this.form.type,
                                remark:this.form.remark
                            }
                        }else {
                            o = {
                                name: this.form.name,
                                gameId: this.form.gameId,
                                type: this.form.type,
                                id: this.form.id,
                                remark:this.form.remark
                            }
                        }
                        this._ajax({url: this.rootAPI + method, param: o})
                        .then((function(d) {
                            if(d.state === 0) {
                                this.$message({ type: 'success', message: '操作成功' }); 
                                this.$emit('submit')
                            }
                            else{
                                this.$message({ type: 'warning', message: '操作失败:'+d.msg });
                            }
                        }).bind(this))
                    }
                })
			},
            beforeClose(done) {
                this.cancel()
                done()
            },
		}
	}
</script>