
package com.ms.warehouse.manage.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.TestcigaretteEntity;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 试验卷烟 Mapper
 * @author Ms
 * @Date 2018-07-30 16:17:10
 * @since 1.0
 */
@Repository
public interface TestcigaretteMapper extends IBaseMapper<TestcigaretteEntity>{
    /**
     * 获取所有信息
     * @return
     */
	List<TestcigaretteEntity> queryAlllist();
    /**
     * 根据编码获取对象
     * @return
     */
    TestcigaretteEntity queryByCode(String code);
}
