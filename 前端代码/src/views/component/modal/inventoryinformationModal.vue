<template>
	<el-dialog custom-class="jz-modal" :title="modaltype === 'search' ? '库存明细查询' : ''" :visible="modalshow" :before-close="beforeClose" :width="modalWidth" :close-on-click-modal="false">
		<el-table :data="tableData1"  style="width: 100%" :row-class-name="setClassName">
			<el-table-column type="expand">
				<template slot-scope="props">
					<el-table :data="props.row.itlmEntities" style="width: 100%" >
			<!--			<el-table-column prop="localCode" label="货位编号" width="180">-->
						<el-table-column prop="descript" label="货位描述">
						</el-table-column>
						<el-table-column prop="quality" label="数量">
						</el-table-column>
						<el-table-column prop="status" label="状态">
							<template slot-scope="scope">
								<toolTip :content="_dicValue(scope.row.status, InMapPtions)">
									<tagItem type="warning" :text="_dicValue(scope.row.status, InMapPtions)"></tagItem>
					<!--    			<span>{{_dicValue(scope.row.status, InMapPtions)}}</span>-->
					    	    </toolTip>
							</template>
						</el-table-column>
						<el-table-column prop="outDate" label="出库时间">
						</el-table-column>
					</el-table>
				</template>
			</el-table-column>
			<el-table-column label="库存类型" prop="nameType">
				<template slot-scope="scope">
					<span v-if="scope.row.nameType=='0'">库存明细</span>
					<span v-if="scope.row.nameType=='1'">库存尾盘</span>
				</template>
			</el-table-column>
			<el-table-column label="批次号" prop="batchNo">
			</el-table-column>
			<el-table-column label="入库总量（件）" prop="inventQuality">
			</el-table-column>
			<el-table-column label="出库总量（件）" prop="outQuality">
			</el-table-column>
			<el-table-column label="剩余总量（件）" prop="surplusQuality">
			</el-table-column>
			<el-table-column label="开出数量（件）" prop="outoquality">
			</el-table-column>
		</el-table>
		<div slot="footer" class="dialog-footer">
			<el-button @click="cancel()">返 回</el-button>
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
				InMapPtions: [],
				searchForm: {
					id: 0
				},
				tableData1: [],
				spanArr: [],
				pos: 0,
				colorArr: [],

			};
		},
		props: {
			modaltype: {
				default: "search"
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
			this.getMapStatusNo().then(
				(d => {
					this.search();
				}).bind(this)
			);
		},
		methods: {
			/**
			 * 获取字典类型
			 */
			getMapStatusNo() {
				return this._searchDic("IN_MAP_STATUS").then(
					function(d) {
						this.InMapPtions = this._dicKey(d);
					}.bind(this)
				);
			},
			cancel() {
				this.$emit("close");
			},
			search() {
				this.searchForm.id = this.tableRow.id;
				Object.assign(this.searchForm, {})
				return this._ajax({
					url: this.rootAPI,
					name: "inventorymain/queryInAllbyId",
					param: this.searchForm,
					loading: "dataLoading"
				}).then(function(d) {
					for(let i=0;i<d.aaData.length;i++){
						if(d.aaData[i].nameType==1){
							d.aaData[i].expand=true;
						}else{
							d.aaData[i].expand=false;
						}
					}
					this.tableData1 = d.aaData;
				}.bind(this));
			},
			beforeClose(done) {
				this.cancel();
				done();
			},
			setClassName({row, index}){
		        return row.expand ? 'expand' : '';
		    }
		}
	};
</script>
<style>
	.expand .el-table__expand-column .cell {
	    display: none;
	}
</style>