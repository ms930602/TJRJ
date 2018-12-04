package com.ms.warehouse.inventory.service;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.utils.DateUtilSafe;
import com.ms.warehouse.common.utils.FileUtils;
import com.ms.warehouse.common.utils.StringUtils;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.UploadReqVo;
import com.ms.warehouse.common.vo.ValueRespVO;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.inventory.bo.BaseUploadfilerecodeBO;
import com.ms.warehouse.inventory.entity.BaseUploadfilerecodeEntity;

import cn.hutool.setting.dialect.Props;
import net.coobird.thumbnailator.Thumbnails;

/**
 * 上传文件 业务处理
 * @author wangwei
 * @Date 2018-08-03 09:55:30
 * @since 1.0
 */@Service
public class BaseUploadfilerecodeService extends BaseService {
	 
	private final static Logger logger=Logger.getLogger(BaseUploadfilerecodeService.class);
	
	private String seap=File.separator;
	
	private UploadReqVo voo = null;
	
	@Autowired
	private BaseUploadfilerecodeBO baseUploadfilerecodeBo;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<BaseUploadfilerecodeEntity> reqVO) throws CenterException {
		return baseUploadfilerecodeBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return baseUploadfilerecodeBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object create(BaseUploadfilerecodeEntity baseUploadfilerecode) throws CenterException {
		baseUploadfilerecodeBo.createForValidate(baseUploadfilerecode);
		return baseUploadfilerecode;
	}

	/**
	 * 修改
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO update(BaseUploadfilerecodeEntity baseUploadfilerecode) throws CenterException {
		int updateCount = baseUploadfilerecodeBo.updateForValidate(baseUploadfilerecode);
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
		int deleteCount = baseUploadfilerecodeBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}
	/**
	 * 根据附件id查询附件信息
	 * @param id
	 * @return
	 * @throws CenterException
	 */
	public BaseUploadfilerecodeEntity getById(@Param("id") Long id) throws CenterException {
		return baseUploadfilerecodeBo.queryById(id);
	}
	
	/**
	 * 下载文件接口
	 * @param req
	 * @param resp
	 */
	public BaseRespVO  getFile(HttpServletResponse res,@Param("path") String path) {
		String fileName = "1.mp3";
        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
          os = res.getOutputStream();
          bis = new BufferedInputStream(new FileInputStream(new File("F:\\data\\"+path)));
          int i = bis.read(buff);
          while (i != -1) {
            os.write(buff, 0, buff.length);
            os.flush();
            i = bis.read(buff);
          }
        } catch (IOException e) {
          e.printStackTrace();
        } finally {
          if (bis != null) {
            try {
              bis.close();
            } catch (IOException e) {
              e.printStackTrace();
            }
          }
        }
        System.out.println("success");
        return new BaseRespVO(0, "success");
	}
	
	/**
	 * 文件上传
	 * 
	 * @param vo
	 * @return
	 * @throws IOException 
	 */
	public BaseRespVO uploadBase64(
			@Param("fileSize")Long fileSize,
			@Param("fileName")String name,
			@Param("data")String dataParam,
			@Param("savePath")String savePath) throws IOException {
		Props PathProps = new Props("pathConf.properties");
		String FILE_UPLOAD_PATH =PathProps.getProperty("file.manager.upload.path");
		String FILE_ACCESS_PATH = PathProps.getProperty("file.manager.access.path");
		if (dataParam == null || "".equals(dataParam.trim())) {
			return BaseRespVO.error("上传文件为空");
		}
		if (StringUtils.isEmpty(savePath)) {
			return BaseRespVO.error("缺少 savePath（文件保存目录） 参数");
		}
		String data = dataParam.substring(dataParam.indexOf(",")+1).replaceAll(" ", "+");
		String filePath = DateUtilSafe.getCurrentDate() + "/" + savePath + "/";

		String fileName = Base64Utils.encodeToString((System.currentTimeMillis() + "").getBytes());
		FileUtils.saveFileByBase64(data, FILE_UPLOAD_PATH + filePath, fileName);
		
		Map<String, String> resutMap = new HashMap<String, String>();
		resutMap.put("path", FILE_ACCESS_PATH + filePath + fileName);
		resutMap.put("size", fileSize + "");

		ValueRespVO resp = new ValueRespVO();
		resp.setAaData(resutMap);
		BaseUploadfilerecodeEntity baseUploadfilerecode = new BaseUploadfilerecodeEntity();
		baseUploadfilerecode.setFileName(name);
		baseUploadfilerecode.setFilePath(resutMap.get("path"));
		baseUploadfilerecode.setFileSize(fileSize);
		baseUploadfilerecode.setSourceObjectId(1L);
		try {
			this.create(baseUploadfilerecode);
			resutMap.put("loadId", baseUploadfilerecode.getId().toString());
		} catch (CenterException e) {
			e.printStackTrace();
		}
		return resp;
	}
	
	/**
	 * 文件上传
	 * 
	 * @param vo
	 * @return
	 */
	public BaseRespVO upload(UploadReqVo vo) {
		this.voo=vo;
		Props PathProps = new Props("pathConf.properties");
		String FILE_UPLOAD_PATH =PathProps.getProperty("file.manager.upload.path");
		String FILE_ACCESS_PATH = PathProps.getProperty("file.manager.access.path");
		if (vo.getFile() == null || vo.getFile().length == 0) {
			return BaseRespVO.error("上传文件为空，文件参数名为：file");
		}
		if (StringUtils.isEmpty(vo.getSavePath())) {
			return BaseRespVO.error("缺少 savePath（文件保存目录） 参数");
		}
		String filePath = DateUtilSafe.getCurrentDate() + "/" + vo.getSavePath() + "/";

		String fileName = Base64Utils.encodeToString((System.currentTimeMillis() + "").getBytes());
		long fileSize = FileUtils.saveFileByBytes(vo.getFile(), FILE_UPLOAD_PATH + filePath, fileName);
		
		Map<String, String> resutMap = new HashMap<String, String>();
		resutMap.put("path", FILE_ACCESS_PATH + filePath + fileName);
		resutMap.put("size", fileSize + "");

		ValueRespVO resp = new ValueRespVO();
		resp.setAaData(resutMap);
		BaseUploadfilerecodeEntity baseUploadfilerecode = new BaseUploadfilerecodeEntity();
		baseUploadfilerecode.setFileName(vo.getFile_FILENAME());
		baseUploadfilerecode.setFilePath(resutMap.get("path"));
		baseUploadfilerecode.setFileSize(fileSize);
		baseUploadfilerecode.setSourceObjectId(vo.getSort());
		try {
			this.create(baseUploadfilerecode);
			resutMap.put("loadId", baseUploadfilerecode.getId().toString());
		} catch (CenterException e) {
			e.printStackTrace();
		}
		return resp;
	}
	public BaseRespVO imgUploadFirst(UploadReqVo vo) throws IOException {
		this.voo=vo;
		Props PathProps = new Props("pathConf.properties");
		String FILE_UPLOAD_PATH =PathProps.getProperty("file.manager.upload.path");
		String FILE_ACCESS_PATH = PathProps.getProperty("file.manager.access.path");
		if (vo.getFile() == null || vo.getFile().length == 0) {
			return BaseRespVO.error("上传文件为空，文件参数名为：file");
		}
		if (StringUtils.isEmpty(vo.getSavePath())) {
			return BaseRespVO.error("缺少 savePath（文件保存目录） 参数");
		}
		String filePath = DateUtilSafe.getCurrentDate() + "/" + vo.getSavePath() + "/";

		String fileName = Base64Utils.encodeToString((System.currentTimeMillis() + "").getBytes())+".jpg";
		InputStream input = new ByteArrayInputStream(vo.getFile());
		File file = new File(FILE_UPLOAD_PATH + filePath);
		if(!file.exists()){
			file.mkdirs();
		}
		Thumbnails.of(input).size(180,150).toFile(FILE_UPLOAD_PATH + filePath + fileName);
		long fileSize = vo.getFile().length;
		//long fileSize = FileUtils.saveFileByBytes(vo.getFile(), FILE_UPLOAD_PATH + filePath, fileName);

		Map<String, String> resutMap = new HashMap<String, String>();
		resutMap.put("path", FILE_ACCESS_PATH + filePath + fileName);
		resutMap.put("size", fileSize + "");

		ValueRespVO resp = new ValueRespVO();
		resp.setAaData(resutMap);
		BaseUploadfilerecodeEntity baseUploadfilerecode = new BaseUploadfilerecodeEntity();
		baseUploadfilerecode.setFileName(vo.getFile_FILENAME());
		baseUploadfilerecode.setFilePath(resutMap.get("path"));
		baseUploadfilerecode.setFileSize(fileSize);
		baseUploadfilerecode.setSourceObjectId(vo.getSort());
		try {
			this.create(baseUploadfilerecode);
			resutMap.put("loadId", baseUploadfilerecode.getId().toString());
		} catch (CenterException e) {
			e.printStackTrace();
		}
		return resp;
	}
	/**
	 * 图片上传
	 * 
	 * @param vo
	 * @return
	 */
	public BaseRespVO imgUpload(UploadReqVo vo) {
		// 校验是否为图片
//		if (!FileUtils.isImage(vo.getFile_FILENAME(), vo.getFile())) {
//			return new BaseRespVO(99, "图片文件格式不合法！");
//		}
		return upload(vo);
	}
}
