package com.ms.warehouse.manage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.manage.bo.MerchantBO;
import com.ms.warehouse.manage.entity.MerchantEntity;

/**
 * 客商信息 业务处理
 * @author dwf
 * @Date 2018-07-26 18:37:47
 * @since 1.0
 */@Service
public class MerchantService extends BaseService {

	@Autowired
	private MerchantBO merchantBo;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<MerchantEntity> reqVO) throws CenterException {
		return merchantBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return merchantBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object create(MerchantEntity merchant) throws CenterException {
		//自动生成仓库编码   ：C+9位补齐数字
		Map<String, Object> params=new HashMap<>();//查询条件map
		params.put("code", "K0000001");//初始化查询条件
		MerchantEntity entity=merchantBo.queyByMapsParams(params);
		if (entity==null) {
			//若不存在，表示第一次手动添加
			merchant.setCode("K0000001");//设置初始化编码
		}else {
			//自动生成编码,查询已生成最大编码
			String maxWarCode=merchantBo.queryMaxWarCode();
			//对最大code进行自增1
			int number=(Integer.parseInt(maxWarCode.substring(1)))+1;
			String newCode="K"+String.format("%07d", number);//新code
			merchant.setCode(newCode);
		}
		merchantBo.createForValidate(merchant);
		return merchant;
	}

	/**
	 * 修改
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO update(MerchantEntity merchant) throws CenterException {
		int updateCount = merchantBo.updateForValidate(merchant);
		if(updateCount > 0){
			return new BaseRespVO();
		}else{
			return new BaseRespVO(2,"没有要修改的记录！");
		}
		
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public BaseRespVO delete(@Param("id") Long[] id) throws CenterException {
		int deleteCount = merchantBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}

	/**
	 * 获取客户
	 * @param keyword
     * @return
     */
	public List<MerchantEntity> getAllMerchantEntitycustomer(@Param("keyword") String keyword){
		return merchantBo.getAllMerchantEntitycustomer(keyword);
	}

	/**
	 * 获取客商
	 * @param keyword
     * @return
     */
	public List<MerchantEntity> getAllMerchantEntitytravellingtrader(@Param("keyword") String keyword){
		return merchantBo.getAllMerchantEntitytravellingtrader(keyword);
	}
}
