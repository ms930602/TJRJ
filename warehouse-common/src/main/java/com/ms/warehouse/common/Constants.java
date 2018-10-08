package com.ms.warehouse.common;

public class Constants {

	/* 登录用户信息 */
	public static String SESSION_LOGIN_USER = "SESSION_LOGIN_USER";

	/* 请求客户端的IP */
	public static String REQUEST_CLIENT_IP = "REQUEST_CLEINT_IP";

	/* 请求METHOD(GET、POST) */
	public static String REQUEST_METHOD = "REQUEST_METHOD";

	/* 入库单号 */
	public static final String SER_INSTOCKNO = "RK";

	/* 出库单号 */
	public static final String SER_OUTSTOCKNO = "CK";

	/* 盘点单 */
	public static final String SER_INVENTORYNO = "PD";

	/* 调整单 */
	public static final String SER_ADJUSTMENTNO = "TZ";

	/* 批次号 */
	public static final String SER_BATCHNO = "PC";

	/* 库存唯一号 */
	public static final String SER_UNIQUENO = "WY";
	
	/* RFID编号 */
	public static final String SER_RFID = "RFID";

	/* 一整托盘件烟数量 */
	public static final Integer CIG_QUALITY = 20;
	
	/* 每种物料货位分配基数 */
	public static final Integer LOCAL_BASIC = 40;

	// 附件主体对象类型=========================================================
	/**
	 * 附件主体对象类型-设备版本附件-001
	 */
	public static String FILE_SOURCE_TYPE_DEVICE = "001";
	/**
	 * 附件主体对象类型-其他附件-002
	 */
	public static String FILE_SOURCE_TYPE_OTHER = "002";
	// 附件对应实体表名称===========================================================
	/**
	 * 附件对应实体表名称-设备版本表表名-t_base_deviceversion
	 */
	public static String TABLE_NAME_DEVICE_VERSION = "t_base_deviceversion";

}