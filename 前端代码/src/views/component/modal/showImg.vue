<template>
	<el-dialog custom-class="jz-modal" :title="查看图片" :visible="modal" :before-close="beforeClose" :close-on-click-modal="false" :width="modalWidth">
			<img :src="filePath" alt="" style="width: 100%;">           
            <div slot="footer" class="dialog-footer flex-x-end">
                <elBtn @click="cancel" text="取消">取消</elBtn>
            </div>
        </el-dialog>
</template>
<script>
import mixin from '../../../mixin/mixin.js'
import local from '../../../local.js'
	export default {
        mixins: [mixin],
		data() {
			return {
				filePath:''
			}
		},
		props: {
			modal: {
				default: false
			},
            path: ''
		},
        computed: {
           
        },
		mounted() {
			this.filePath = FILE_PATH + this.path;
		},
		methods: {
            claSelectChange(ob){
               
            },
			cancel() {
				this.$emit('close')
			},
            beforeClose(done) {
                this.cancel()
                done()
            },
		}
	}
</script>