<template>
	<el-dialog custom-class="jz-modal" :title="devicerunModelType === 'add' ? '新增设备运行信息' : '设备运行信息编辑'" :visible="modal" :before-close="beforeClose" :close-on-click-modal="false" :width="modalWidth">
            <el-form class="modal-form" v-if="modal" :model="form" ref="form" :inline="true" :rules="rules" label-width="80px">
                <el-row>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="设备名称" prop="dicCode" v-if="devicerunModelType === 'add'">
                            <selectInput :value.sync="form.dicCode" filterable @selectChange="divSelectChange" :clearable="true">
                                <el-option
                                v-for="item in dicDeviceType"
                                :key="item.id"
                                :label="item.dicName"
                                :value="item.dicCode"
                                >
                                </el-option>
                            </selectInput>
                        </el-form-item>
                        <el-form-item label="设备名称" v-else>
                            <span>{{form.dicName}}</span>
                        </el-form-item>
                    </el-col>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="设备编号" prop="serialNum" v-if="devicerunModelType === 'add'">
                            <inputItem :value.sync="form.serialNum"></inputItem>
                        </el-form-item>
                        <el-form-item label="设备编号" v-else>
                            <span>{{form.serialNum}}</span>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="损坏时间" prop="failerTime">
                            <el-date-picker
                                v-model="form.failerTime"
                                type="date"
                                placeholder="选择日期时间"
                                align="right"
                                :picker-options="pickerOptions1">
                            </el-date-picker>
                        </el-form-item>
                    </el-col>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="修复时间" prop="repairTime">
                            <el-date-picker
                                v-model="form.repairTime"
                                type="date"
                                placeholder="选择日期时间"
                                align="right"
                                :picker-options="pickerOptions1">
                            </el-date-picker>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="修复人" prop="repairPerson">
                            <inputItem :value.sync="form.repairPerson"></inputItem>
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
	export default {
        mixins: [mixin],
		data() {
            var vm = this
            return {
                value4: [new Date(2000, 10, 10, 10, 10), new Date(2000, 10, 11, 10, 10)],
                pickerOptions1: {
                    shortcuts: [{
                        text: '今天',
                        onClick(picker) {
                        picker.$emit('pick', new Date());
                        }
                    }, {
                        text: '昨天',
                        onClick(picker) {
                        const date = new Date();
                        date.setTime(date.getTime() - 3600 * 1000 * 24);
                        picker.$emit('pick', date);
                        }
                    }, {
                        text: '一周前',
                        onClick(picker) {
                        const date = new Date();
                        date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
                        picker.$emit('pick', date);
                        }
                    }]
                    },
				form: {
                    dicCode: '',
                    dicName: '',
                    serialNum: '',
                    failerTime: moment(Date.parse(new Date())).format("YYYY-MM-DD"),
                    repairTime: '',
                    repairPerson: '',
                },
                dictionaryList: [],
                rules: {
                    dicCode: [{required: true, message: '设备名称不能为空' }, this._ruleLength(45)],
                    serialNum: [{required: true, message: '设备编号不能为空' }, this._ruleLength(45)],
                    repairPerson: [{required: true, message: '修复人不能为空' }, this._ruleLength(45)],
                    failerTime: [{required: true, message: '损坏时间不能为空' }],
                    repairTime: [{required: true, message: '修复时间不能为空' }]
                },
                dicDeviceType: [],
                thisUser: local.get('userinfo')
			}
		},
		props: {
			modal: {
				default: false
			},
            devicerunModelType: {
                default: 'add'
            },
            devicerun: {
                default: function() {
                    return {}
                }
            }
		},
        computed: {
           
        },
		mounted() {
            Object.assign(this.form, this.devicerun);
            this._searchDic('DEVICE_TYPE')
			.then((function(d) {
				this.dicDeviceType = d.aaData;
                debugger;
			}).bind(this))
			this.searchTable()
		},
		methods: {
            divSelectChange(ob){
                var obj = this.dicDeviceType.find((item)=>{//这里的userList就是上面遍历的数据源
                    return item.dicCode === ob;//筛选出匹配数据
                });
                // console.log(obj);
                this.form.dicCode = obj.dicCode;
                this.form.dicName = obj.dicName;
            },
			cancel() {
				this.$emit('close')
			},
			submit() {
                this.$refs['form'].validate((valid) => {
                    if (valid) {
                        let o = {}, method = 'devicerun/update';
                        var start_time=this._dateFormat({date:this.form.failerTime,type:'YYYY-MM-DD HH:mm:ss'});
                        var end_time=this._dateFormat({date:this.form.repairTime,type:'YYYY-MM-DD HH:mm:ss'});
                        //把字符串格式转换为日期类
                        var startTime = new Date(Date.parse(start_time));
                        var endTime = new Date(Date.parse(end_time));
                        if(startTime>endTime){
                            this.$message({ type: 'warning', message: '损坏时间不能大于修复时间' }); 
                            return ;
                        }
                        if(this.devicerunModelType === 'add') {  
                            method = 'devicerun/create' 
                            o = {
                                dicCode: this.form.dicCode,
                                dicName: this.form.dicName,
                                serialNum: this.form.serialNum,
                                failerTime: this._dateFormat({date:this.form.failerTime,type:'YYYY-MM-DD HH:mm:ss'}),
                                repairTime: this._dateFormat({date:this.form.repairTime,type:'YYYY-MM-DD HH:mm:ss'}),
                                repairPerson: this.form.repairPerson,
                                createdPersonId: this.thisUser.userId,
                                createdPerson: this.thisUser.nickName
                            }
                        }else {
                            o = {
                                dicCode: this.form.dicCode,
                                dicName: this.form.dicName,
                                serialNum: this.form.serialNum,
                                failerTime: this._dateFormat({date:this.form.failerTime,type:'YYYY-MM-DD HH:mm:ss'}),
                                repairTime: this._dateFormat({date:this.form.repairTime,type:'YYYY-MM-DD HH:mm:ss'}),
                                repairPerson: this.form.repairPerson,
                                id: this.form.id,
                                updatedPersonId: this.thisUser.userId,
                                updatedPerson: this.thisUser.nickName
                            }
                        }

                        this._ajax({url: this.rootAPI + method, param: o})
                        .then((function(d) {
                            if(d.state === 0) {
                                this.$message({ type: 'success', message: '操作成功' }); 
                                this.$emit('submit')
                            }else if(d.state === 2){
                                this.$message({ type: 'warning', message: '没有要修改的记录！' });
                            }
                            else{
                                this.$message({ type: 'warning', message: '操作失败' });
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