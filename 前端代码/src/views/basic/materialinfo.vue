<template>
	<!--仓库信息-->
	<div class="page-measureunit">
		<!-- 查询条件 -->
		<searchInputItems>
			<searchInputItem name="名称">
				<inputItem :value.sync="searchForm.materName" @enter="searchTable"></inputItem>
			</searchInputItem>
			<searchInputItem name="编码">
				<inputItem :value.sync="searchForm.materCode" @enter="searchTable"></inputItem>
			</searchInputItem>
			<searchInputItem name="状态">
				<selectInput :value.sync="searchForm.status" @selectChange="searchTable" :clearable="true">
					<el-option
				      v-for="item in optionStatus"
				      :key="item.key"
				      :label="item.label"
				      :value="item.value">
				    </el-option>
				</selectInput>
			</searchInputItem>
			<searchInputItem name="类型">
				<selectInput :value.sync="searchForm.type" @selectChange="searchTable" :clearable="false">
					<el-option
				      v-for="item in optionTypes"
				      :key="item.key"
				      :label="item.value"
				      :value="item.key">
				    </el-option>
				</selectInput>
			</searchInputItem>
		</searchInputItems>
		<!-- 操作按钮 -->
		<optionItems>
			<template slot="left">
				<el-button-group>
					<iconBtn iconClass="el-icon-search" content="查询" @click="searchTable">查询</iconBtn>
					<iconBtn iconClass="el-icon-refresh" content="重置" @click="reset">重置</iconBtn>
				</el-button-group>				
			</template>
		</optionItems>
		<!-- 表格 -->
		<elemTable :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange" v-if="searchForm.type == '0'"
			@expandChange="openLineRow">
		    <el-table-column type="expand" fixed>
		      <template slot-scope="props">
		        <selectInput :value.sync="props.row.subId" filterable :clearable="false">
					<el-option
				      v-for="item in optionSubver"
				      :key="item.key"
				      :label="item.value"
				      :value="item.key">
				    </el-option>
				</selectInput>&nbsp;&nbsp;&nbsp;
				<el-button type="primary" :loading="isCreateSubLink" 
				@click="addVer(props.row.materCode,props.row.subId,props.row)"
				>添加</el-button>
	        	<el-table
			      :data="props.row.subVersionList"
			      :row-class-name="tableRowClassName"
			      style="width: 280px">
			      <el-table-column
			         type="index"
			        label="编号"
			        width="50">
			      </el-table-column>
			      <el-table-column
			        prop="subverName"
			        label="小版本名称">
			      </el-table-column>
			      <el-table-column label="操作">
		            <template slot-scope="scope">
		              <el-button-group>
		                <iconBtn iconClass="el-icon-minus" content="删除" @click="delVer(scope.row.materLinkId,props.row)">
		              </iconBtn>
		              </el-button-group>            
		            </template>
		          </el-table-column>
			    </el-table>
		      </template>
		    </el-table-column>
		    <el-table-column prop="materCode" label="编码" fixed width="160">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.materCode">
		    			<span>{{scope.row.materCode}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="materName" label="名称" fixed width="160">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.materName">
		    			<span>{{scope.row.materName}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="verName" label="版本" fixed>
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.verName">
		    			<span>{{scope.row.verName}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="braName" label="卷烟品牌" fixed>
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.braName">
		    			<span>{{scope.row.braName}}</span>
		    		</toolTip> 
		      	</template>
		    </el-table-column>
		    <el-table-column prop="abroadflag" label="进口国产标识" width="100">
		    	<template slot-scope="scope">
		    		<tagItem v-if="scope.row.abroadflag" :text="_dicValue(scope.row.abroadflag, dicAbroadflag)"></tagItem>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="pacsName" label="包装规格" width="250">
		    	<template slot-scope="scope">
		    		<selectInput 
		    		:value.sync="scope.row.packagestandards" 
		    		@selectChange="savePackageEx($event,scope.row.id)" :clearable="false">
						<el-option
					      v-for="item in optionPackspec"
					      :key="item.key"
					      :label="item.value"
					      :value="item.key">
					    </el-option>
					</selectInput>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="casebarcode" label="卷烟盒条码" width="140">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.casebarcode">
		    			<span>{{scope.row.casebarcode}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="barbarcode" label="卷烟条条码" width="140">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.barbarcode">
		    			<span>{{scope.row.barbarcode}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="boxbarcode" label="卷烟箱条码" width="140">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.boxbarcode">
		    			<span>{{scope.row.boxbarcode}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="barName" label="条码状态">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.barName">
		    			<span>{{scope.row.barName}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="ismajorbar" label="是否主条码卷烟" width="120">
		    	<template slot-scope="scope">
		    		<tagItem v-if="scope.row.ismajorbar" :text="_dicValue(scope.row.ismajorbar, dicIsmajorbar)"></tagItem>
		      	</template>
		    </el-table-column>
		    <!--____以上1-10____-->
		    <el-table-column prop="productent" label="生产企业">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.productent">
		    			<span>{{scope.row.productent}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="productpoint" label="生产点">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.productpoint">
		    			<span>{{scope.row.productpoint}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="trademarkowner" label="商标所有者">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.trademarkowner">
		    			<span>{{scope.row.trademarkowner}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="subcomp" label="子公司标志">
		    	<template slot-scope="scope">
		    		<tagItem v-if="scope.row.subcomp" :text="_dicValue(scope.row.subcomp, dicSubcomp)"></tagItem>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="cigName" label="卷烟类型">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.cigName">
		    			<span>{{scope.row.cigName}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <!--__以上11-20__-->
		    <el-table-column prop="filterName" label="滤嘴类型">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.filterName">
		    			<span>{{scope.row.filterName}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="prodName" label="生产类型">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.prodName">
		    			<span>{{scope.row.prodName}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="cigmaincolor" label="包装主颜色">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.cigmaincolor">
		    			<span>{{scope.row.cigmaincolor}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="cigasscolor" label="包装辅颜色">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.cigasscolor">
		    			<span>{{scope.row.cigasscolor}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="cigenname" label="卷烟名称(外文)">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.cigenname">
		    			<span>{{scope.row.cigenname}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="cigbrandenname" label="卷烟牌号名称(外文)">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.cigbrandenname">
		    			<span>{{scope.row.cigbrandenname}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="pacName" label="包装形式">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.pacName">
		    			<span>{{scope.row.pacName}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="notsaleflag" label="是否非卖品">
		    	<template slot-scope="scope">
		    		<tagItem v-if="scope.row.notsaleflag" :text="_dicValue(scope.row.notsaleflag, dicNotsaleflag)"></tagItem>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="cigislow" label="是否低档烟">
		    	<template slot-scope="scope">
		    		<tagItem v-if="scope.row.cigislow" :text="_dicValue(scope.row.cigislow, dicCigislow)"></tagItem>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="cigisgreat" label="是否名优烟">
		    	<template slot-scope="scope">
		    		<tagItem v-if="scope.row.cigisgreat" :text="_dicValue(scope.row.cigisgreat, dicCigisgreat)"></tagItem>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="jointunit" label="联营烟单位">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.jointunit">
		    			<span>{{scope.row.jointunit}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>-->
		    <el-table-column prop="isusing" label="是否在用">
		    	<template slot-scope="scope">
		    		<tagItem v-if="scope.row.isusing" :text="_dicValue(scope.row.isusing, dicIsusing)"></tagItem>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="cigapprvdate" label="准生成日期">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.cigapprvdate">
		    			<span>{{scope.row.cigapprvdate}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="cigltstupdate" label="产品停产日期" width="160">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.cigltstupdate">
		    			<span>{{scope.row.cigltstupdate}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="cigtax" label="税则号">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.cigtax">
		    			<span>{{scope.row.cigtax}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="remcode" label="助记符">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.remcode">
		    			<span>{{scope.row.remcode}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="cigmemo" label="备注">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.cigmemo">
		    			<span>{{scope.row.cigmemo}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="formulacode" label="配方识别码">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.formulacode">
		    			<span>{{scope.row.formulacode}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="paciName" label="包装识别码">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.paciName">
		    			<span>{{scope.row.paciName}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="status" label="状态">
		    	<template slot-scope="scope">
		    		<tagItem :text="_dicValue(scope.row.status, dicStatus)"></tagItem>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="createdDate" label="创建时间" width="160">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.createdDate">
		    			<span>{{scope.row.createdDate}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="createdPerson" label="创建人">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.createdPerson">
		    			<span>{{scope.row.createdPerson}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="updatedDate" label="更新时间" width="160">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.updatedDate">
		    			<span>{{scope.row.updatedDate}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="updatedPerson" label="更新人">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.updatedPerson">
		    			<span>{{scope.row.updatedPerson}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		</elemTable>

		<!--  福式卷烟 !!!!!!!!  -->

		<elemTable :dataList="dataList" :currentPage='pageNum' :pageSize="pageSize" :pageTotal="pageTotal" :loading="dataLoading" @sizeChange="handleSizeChange" @currentChange="handleCurrentChange" v-if="searchForm.type == '1'"
		@expandChange="openLineRow">
		    <el-table-column type="expand" fixed>
		      <template slot-scope="props">
		        <selectInput :value.sync="props.row.subId" filterable :clearable="false">
					<el-option
				      v-for="item in optionSubver"
				      :key="item.key"
				      :label="item.value"
				      :value="item.key">
				    </el-option>
				</selectInput>&nbsp;&nbsp;&nbsp;
				<el-button type="primary" :loading="isCreateSubLink" 
				@click="addVer(props.row.code,props.row.subId,props.row)"
				>添加</el-button>
	        	<el-table
			      :data="props.row.subVersionList"
			      :row-class-name="tableRowClassName"
			      style="width: 280px">
			      <el-table-column
			         type="index"
			        label="编号"
			        width="50">
			      </el-table-column>
			      <el-table-column
			        prop="subverName"
			        label="小版本名称">
			      </el-table-column>
			      <el-table-column label="操作">
		            <template slot-scope="scope">
		              <el-button-group>
		                <iconBtn iconClass="el-icon-minus" content="删除" @click="delVer(scope.row.materLinkId,props.row)">
		              </iconBtn>
		              </el-button-group>            
		            </template>
		          </el-table-column>
			    </el-table>
		      </template>
		    </el-table-column>
		    <el-table-column prop="name" label="名称" fixed width="160">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.name">
		    			<span>{{scope.row.name}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="verName" label="版本" fixed width="260">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.verName">
		    			<span>{{scope.row.verName}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="braName" label="卷烟品牌" fixed>
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.braName">
		    			<span>{{scope.row.braName}}</span>
		    		</toolTip> 
		      	</template>
		    </el-table-column>
		    <el-table-column prop="pacsName" label="包装规格" width="250">
		    	<template slot-scope="scope">
		    		<selectInput 
		    		:value.sync="scope.row.packagestandards" 
		    		@selectChange="savePackageEx($event,scope.row.id)" :clearable="false">
						<el-option
					      v-for="item in optionPackspec"
					      :key="item.key"
					      :label="item.value"
					      :value="item.key">
					    </el-option>
					</selectInput>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="barbarcode" label="卷烟条条码" width="140">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.barbarcode">
		    			<span>{{scope.row.barbarcode}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="cigName" label="卷烟类型">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.cigName">
		    			<span>{{scope.row.cigName}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <!--__以上11-20__-->
		    <el-table-column prop="pacName" label="包装形式">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.pacName">
		    			<span>{{scope.row.pacName}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="standardscode" label="卷烟规格码">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.standardscode">
		    			<span>{{scope.row.standardscode}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="formulacode" label="配方识别码">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.formulacode">
		    			<span>{{scope.row.formulacode}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="paciName" label="包装识别码">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.paciName">
		    			<span>{{scope.row.paciName}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="status" label="状态">
		    	<template slot-scope="scope">
		    		<tagItem :text="_dicValue(scope.row.status, dicStatus)"></tagItem>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="createdDate" label="创建时间" width="160">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.createdDate">
		    			<span>{{scope.row.createdDate}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="createdPerson" label="创建人">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.createdPerson">
		    			<span>{{scope.row.createdPerson}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="updatedDate" label="更新时间" width="160">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.updatedDate">
		    			<span>{{scope.row.updatedDate}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		    <el-table-column prop="updatedPerson" label="更新人">
		    	<template slot-scope="scope">
		    		<toolTip :content="scope.row.updatedPerson">
		    			<span>{{scope.row.updatedPerson}}</span>
		    		</toolTip>
		      	</template>
		    </el-table-column>
		</elemTable>
		<verModel v-if="modalShow" :modal="modalShow" :personInfoModalType="modalType" @close="modalClose" :personinfo="modalObj" @submit="modalSubmit"></verModel>
	</div>
</template>

<script>
	import mixin from '../../mixin/mixin.js'
	import local from '../../local.js'
	import verModel from '.././component/modal/verModel.vue'
	export default {
		mixins: [mixin],
		components: {verModel},
		data() {
			return {
				ssfsd:1,
				searchForm: {
					materName: '',
					materCode: '',
					type:'0',
					status:''
				},
				dataList: [],				
				form:{
					materName: '',//名称
					materCode: '',//编码
					versioncode:'',//版本ID
					cigbrand:'',//卷烟品牌ID
					abroadflag:'',//进口国产标识
					casebarcode:'',//卷烟盒条码
					barbarcode:'',//卷烟条条码
					boxbarcode:'',//卷烟箱条码
					barstatus:'',//条码状态
					ismajorbar:'',//是否主条码卷烟
					
					productent:'',//生产企业
					productpoint:'',//生产点
					trademarkowner:'',//商标所有者
					subcomp:'',//子公司标志
					allotprice0:'',//调拨价(不含税)
					allotprice1:'',//调拨价(含税)
					bulkprice:'',//批发价
					saleprice:'',//市场零售价
					pricetype:'',//卷烟价类
					cigtype:'',	//卷烟类型
					
					filtertype:'',//滤嘴类型
					producttype:'',//生产类型
					cigmaincolor:'',//包装主颜色
					cigasscolor:'',//包装辅颜色
					cigenname:'',//卷烟名称(外文)
					cigbrandenname:'',//卷烟牌号名称(外文)
					packageform:'',//包装形式
					packagestandards:'',//包装规格
					cigtotallen:'',//烟支总长度(mm)
					ciglength:'',//烟支长度(mm)
					
					filterlength:'',//烟嘴长度(mm)
					ciggirth:'',//烟支周长(mm)
					cigtarcontent:'',//焦油量(mg)
					cignicotinic:'',//烟气烟碱量(mg)
					cigco:'',//烟气一氧化碳(mg)
					notsaleflag:'',//是否非卖品
					cigislow:'',//是否低档烟
					cigisgreat:'',//是否名优烟
					cigistrial:'',//是否福祥促试烟
					jointunit:'',//联营烟单位
					
					innerbalance:'',//内部结算价
					salescope:'',//销售范围
					isusing:'',	//是否在用
					cigapprvdate:'',//准生成日期
					cigltstupdate:'',//产品停产日期
					cigtax:'',//税则号
					remcode:'',//助记符
					cigmemo:'',//备注
					inventoreId:'',//卷烟系列 共取6位编码前两位为01的存货分类ID
					cigarettetype:'',//卷烟类别符
					
					standardscode:'',//卷烟规格码
					formulacode:'',//配方识别码
					packingcode:'',//包装识别码
					allotprice2:'',//调拨价(不含税)[元/支]
					allotprice3:'',//调拨价(不含税)[元/万支]
					allotprice4:'',//调拨价(含税)[元/支]
					allotprice5:'',//调拨价(含税)[元/万支]
					linkTobaccoCut:'',//关联半成品
					
					status:'',
					createdDate:'',
					createdPerson:'',
					updatedDate:'',
					updatedPerson:'',
					/*——-----连表内容——分割线————————*/
					barName:'',//条码状态
					braName:'',//卷烟品牌
					lenName:'',//卷烟长度
					prodName:'',//生产类型
					cigName:'',//卷烟类型
					verName:'',//版本
					filterName:'',//滤嘴类型
					pacName:'',//包装形式
					paciName:'',//包装识别码
					pacsName:'',//包装规格
					priName:'',//卷烟价类
					proName:'',//生产点
					tarName:'',//焦油量
					tranName:'',//国内国外销售
				},
				optionStatus: [{
					       value: '2',
					       label: '发布'
					      },{
					       value: '3',
					       label: '停用'
					      }],
				optionTypes: [],
				optionPackspec:[],//包装规格
				dicAbroadflag:[
					{key:0,value:'国产'},
					{key:1,value:'进口'}
				],
				dicIsmajorbar:[
					{key:0,value:'否'},
					{key:1,value:'是'}
				],
				dicNotsaleflag:[
					{key:0,value:'可卖'},
					{key:1,value:'非卖'}
				],
				dicCigislow:[
					{key:0,value:'非低档'},
					{key:1,value:'低档'}
				],
				dicCigisgreat:[
					{key:0,value:'非名优烟'},
					{key:1,value:'是名优烟'}
				],
				dicIsusing:[
					{key:0,value:'停用'},
					{key:1,value:'在用'}
				],
				optionSubver:[],
				isCreateSubLink:false
			}
		},
		mounted() {
			/*进口国产标识*/
			this._searchDic('MATERIAL_TYPE')
			.then((function(d) {
				this.optionTypes = this._dicKey(d)
			}).bind(this))
			/*进口国产标识*/
			/*是否主条码卷烟*/
			/*子公司标志*/
			this._searchDic('SUB_COMP')
			.then((function(d) {
				this.dicSubcomp = this._dicKey(d)
			}).bind(this))
			/*是否非卖品*/
			/*是否低档烟*/
			/*是否名优烟*/
			/*是否福祥促试烟*/
			/*是否在用*/
			/*状态*/
			this._searchDic('STATUS')
			.then((function(d) {
				this.dicStatus = this._dicKey(d)
			}).bind(this))
			.then(this.searchTable)
			this.initPackspec();
			this.loadSubOption();
		},
		methods: {
			loadSubOption(){
				this._ajax({
		            url: this.rootAPI + "subversion/list",
		            param: {status:2}
		          }).then(
		            function(d) {
		              if (d.state == 0) {
		              	d.aaData.forEach(data=>{
		              		this.optionSubver.push({
		              			key:data.id,
		              			value:data.subverName
		              		})
		              	});
		              } else {
		                this.$message({ type: "error", message: "小版本获取失败" });
		              }
		            }.bind(this)
		          );
			},
			openLineRow(row, expandedRows){
				var paramObj = {}
				if(this.searchForm.type == '0')
				{
					paramObj.materCode = row.materCode
				}else
				{
					paramObj.materCode = row.code
				}
				this._ajax({
		            url: this.rootAPI + "subversion/queryMaterSub",
		            param: paramObj
		          }).then(
		            function(d) {
		              if (d.state == 0) {
		              	row.subVersionList = d.aaData;
		              } else {
		                this.$message({ type: "error", message: "版本获取失败" });
		              }
		            }.bind(this)
		          );
			},
			delVer(id,row){
				var arr = [];
				arr.push(id)
				this._comfirm('确定删除该版本？')
        		.then((function() {        			
        			return this._ajax({url: this.rootAPI + 'matersubvermap/delete', param: {id:arr}, arr:true})
        		}).bind(this))
        		.then((function(d) {
					if(d.state === 0)
					{
						this.openLineRow(row)
						this.$message({type: 'success', message: '删除成功'});
					}
					else{
						this.$message({type: 'warning', message: '删除失败'+ d.msg});
					}
				}).bind(this))
			},
			addVer(materCode,subID,row){
				if(!materCode){
					this.$message({ type: "warning", message: "物料代码为空！" });
					return;
				}
				if(!subID){
					this.$message({ type: "warning", message: "请选择正确的版本!" });
					return;
				}
				if(row.subVersionList && row.subVersionList.length > 0){
					var isOk = false;
					row.subVersionList.some(temp=>{
						if(temp.id == subID){
							this.$message({ type: "warning", message: "此版本已存在！" });
							isOk = true;
							return true
						}
					})
					if(isOk)return;
				}
				var paramObj = {
					materCode:materCode,
					subverId:subID,
					createdDate:new Date()
				}
				this.isCreateSubLink = true;
				this._ajax({
		            url: this.rootAPI + "matersubvermap/create",
		            param: paramObj
		          }).then(
		            function(d) {
		              if (d.state == 0) {
		              	this.$message({ type: "success", message: "添加成功！" });
		              } else {
		                this.$message({ type: "error", message: "添加失败" });
		              }
		              this.openLineRow(row)
		              this.isCreateSubLink = false;
		            }.bind(this)
		          );
			},
			searchTable() {
				Object.assign(this.searchForm, {
					pageNum: this.pageNum, 
					pageSize: this.pageSize
				})
				var urlPath;
				var searchFormEx = {
					pageNum: this.pageNum, 
					pageSize: this.pageSize,
					materName: this.searchForm.materName,
					materCode: this.searchForm.materCode,
					status:this.searchForm.status,
					name: this.searchForm.materName,
					code: this.searchForm.materCode,
					type:this.searchForm.type
				};
				if(this.searchForm.type == '0')
				{
					urlPath = "materialinfo/list";
				}else
				{
					urlPath = "testcigarette/list";
				}
				return this._ajax({url: this.rootAPI, name: urlPath, param: searchFormEx, loading: 'dataLoading'}).then(this.renderTable)
			},
			initPackspec(){
				var where = {pageNum:1,pageSize: 1000};
				this._ajax({
		            url: this.rootAPI + "packspec/list",
		            param: where
		          }).then(
		            function(d) {
		              if (d.state == 0) {
		              	d.aaData.forEach(data=>{
		              		this.optionPackspec.push({
		              			key:data.dataId,
		              			value:data.pacsName + ' ('+ (data.converCoef || '无') + ')'
		              		})
		              	});
		              } else {
		                this.$message({ type: "error", message: "包装规格获取失败" });
		              }
		            }.bind(this)
		          );
			},
			savePackageEx($event,id){
				var urlPath = "";
				if(this.searchForm.type == '0')
				{
					urlPath = this.rootAPI + "materialinfo/update";
				}else
				{
					urlPath = this.rootAPI + "testcigarette/update";
				}
				var where = {
					id:id,
					packagestandards:$event,
				}
				this._ajax({
		            url: urlPath,
		            param: where
		          }).then(
		            function(d) {
		              if (d.state == 0) {
		              	this.$message({ type: "success", message: "已修改!" });
		              } else {
		                this.$message({ type: "error", message: "服务器错误！" });
		              }
		            }.bind(this)
		          );
			},
			reset() {
				Object.assign(this.searchForm, {
					materName: '',
					materCode: '',
					type:'0',
					status:''
				})
				this.handleCurrentChange(1)
			},
			add(){
			},
			tableRowClassName({row, rowIndex}) {
		          return 'warning-row';
		      },
			modalEdit(row){
			},
			dele() {			
			},
			delRow(row) {
			},
			delSubmit(o) {
			},
			cancel() {
				var vm = this;
				vm.$refs["form"].resetFields();
				this.dialog.show = false;
				this.diaTitle = '',
				this.searchTable();
			},
		}
	}
</script>

<style>
.el-table .warning-row {
    background: oldlace;
  }
</style>