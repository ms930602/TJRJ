package com.ms.hardware;

import java.util.List;
import java.util.Map;

import com.ms.warehouse.common.vo.Param;

/**
 * 往复式提升机接口
 * @author 王 维
 * create time：2018年8月2日
 */
public interface hoistManagement {
	String getEntryOrOutterDetailInfo(String  trayNumber,Integer operationDirection);
}
