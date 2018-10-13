package com.ms.warehouse.common.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.UploadReqVo;
import com.ms.warehouse.common.vo.ValueRespVO;
import com.ms.warehouse.common.utils.DateUtilSafe;
import com.ms.warehouse.common.utils.FileUtils;
import com.ms.warehouse.common.utils.PathProperties;
import com.ms.warehouse.common.utils.StringUtils;

/**
 * 文件上传实现类
 * 
 * @author lansongtao
 * @Date 2017-10-23 16:29:06
 * @since 1.0
 */
@Service
public class FileUploadService extends BaseService {

	/**
	 * 文件上传
	 * 
	 * @param vo
	 * @return
	 */
	public BaseRespVO upload(UploadReqVo vo) {
		if (vo.getFile() == null || vo.getFile().length == 0) {
			return BaseRespVO.error("上传文件为空，文件参数名为：file");
		}

		if (StringUtils.isEmpty(vo.getSavePath())) {
			return BaseRespVO.error("缺少 savePath（文件保存目录） 参数");
		}
		String fileName = vo.getFile_FILENAME();
		String filePath = DateUtilSafe.getCurrentDate() + "/" + vo.getSavePath() + "/";

		fileName = Base64Utils.encodeToString((System.currentTimeMillis() + "").getBytes());
		long fileSize = FileUtils.saveFileByBytes(vo.getFile(), PathProperties.FILE_UPLOAD_PATH + filePath, fileName);

		Map<String, String> resutMap = new HashMap<String, String>();
		resutMap.put("path", PathProperties.FILE_ACCESS_PATH + filePath + fileName);
		resutMap.put("size", fileSize + "");

		ValueRespVO resp = new ValueRespVO();
		resp.setAaData(resutMap);

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
		if (!FileUtils.isImage(vo.getFile_FILENAME(), vo.getFile())) {
			return new BaseRespVO(99, "图片文件格式不合法！");
		}
		return upload(vo);
	}

}
