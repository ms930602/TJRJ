
package com.ms.warehouse.inventory.bo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.inventory.entity.BaseUploadfilerecodeEntity;
import com.ms.warehouse.inventory.mapper.BaseUploadfilerecodeMapper;


/**
 * 上传文件 bo
 * @author wangwei
 * @Date 2018-08-03 09:55:30
 * @since 1.0
 */
@Component
public class BaseUploadfilerecodeBO extends AbstractBaseBO<BaseUploadfilerecodeEntity> {
	
	@Autowired
	private BaseUploadfilerecodeMapper baseUploadfilerecodeMapper;
	
	@Override
    protected IBaseMapper<BaseUploadfilerecodeEntity> getMapper() {
	    return baseUploadfilerecodeMapper;
    }

	public List<BaseUploadfilerecodeEntity> queryByIds(String detailImg) {
		Long[] ids = null;
		try {
			if(detailImg.indexOf(",") > 0){
				String [] split = detailImg.split(",");
				ids = new Long[split.length];
				for (int i = 0; i < split.length; i++) {
					ids[i] = Long.parseLong(split[i]);
				}
			}else{
				ids = new Long[1];
				ids[0] =  Long.parseLong(detailImg);
			}
		} catch (NumberFormatException e) {
			return null;
		}
		return baseUploadfilerecodeMapper.queryByIds(ids);
	}
}
