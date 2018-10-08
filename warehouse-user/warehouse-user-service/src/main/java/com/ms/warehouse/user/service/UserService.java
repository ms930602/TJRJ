package com.ms.warehouse.user.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.warehouse.common.entity.SessionUser;
import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.service.ThreadContext;
import com.ms.warehouse.common.utils.StringUtils;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.manage.bo.PersoninfoBO;
import com.ms.warehouse.manage.entity.PersoninfoEntity;
import com.ms.warehouse.pre.api.ISessionHandler;
import com.ms.warehouse.user.bo.UserBO;
import com.ms.warehouse.user.entity.UserEntity;
import com.ms.warehouse.user.utils.UserPwdUtil;

/**
 * 业务处理.
 * <p>
 * 
 * @author lansongtao
 * @Date 2017-04-12 14:08:41
 * @since 1.0
 */
@Service
public class UserService extends BaseService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserBO userBo;
	@Autowired(required = false)
	private ISessionHandler sessionHandler;
	/**
	 * 人员信息BO
	 */
	@Autowired
	private PersoninfoBO personinfoBo;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<UserEntity> reqVO) {
		ListRespVO resVO=userBo.queryPageAutomatic(reqVO);
		if (reqVO ==null || resVO.getAaData()==null) {
			return null;
		}
		List<UserEntity> userList=resVO.getAaData();
		List<UserEntity> persionUserList=new ArrayList<>();//人员用户列表集合
		//校验是否是人员选择 获取用户列表
		if (!org.apache.commons.lang.StringUtils.isBlank(reqVO.getExtend()) && reqVO.getExtend().equals("true")) {
			//是添加人员信息  获取用户列表  过滤已经被占用的用户信息
			for (UserEntity userEntity : userList) {
				Map<String, Object> params=new HashMap<>();//查询集合
				params.put("loginName", userEntity.getLoginName());//登录名
				PersoninfoEntity personinfoEntity=personinfoBo.queryByMapParams(params);//返回值结果对象
				//校验对象是否存在
				if (personinfoEntity ==null) {
					persionUserList.add(userEntity);
				}
			}
			resVO.setAaData(null);//清空原始结果集
			resVO.setAaData(persionUserList);//返回新数据集合
			resVO.setDataCount(persionUserList.size());//结果集大小
			return resVO;
		}
		return userBo.queryPageAutomatic(reqVO);
	}

	/**
	 * 校验登录名是否重复
	 * 
	 * @param loginName
	 * @param sessionUser
	 * @return
	 */
	public BaseRespVO checkLoginName(@Param("loginName") String loginName) {
		SessionUser sessionUser = ThreadContext.getSessionloginUser();

		UserEntity entity = new UserEntity();
		entity.setLoginName(loginName);
		entity.setSysId(sessionUser.getSysId());

		entity = userBo.queryByEntity(entity);
		if (entity != null) {
			return new BaseRespVO(2, "登录名已存在：" + loginName);
		}

		return new BaseRespVO();
	}

	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 * @throws CenterException
	 */
	public Object create(UserEntity user) throws CenterException {
		SessionUser sessionUser = ThreadContext.getSessionloginUser();

		if (StringUtils.isEmpty(user.getLoginName())) {
			return new BaseRespVO(9, "登录名称不合法");
		}

		if (StringUtils.isEmpty(user.getPassword())) {
			// 默认密码
			user.setPassword("123456");
		}
		// 密码MD5加密
		try {
			user.setPassword(UserPwdUtil.encoderPwd(user.getPassword()));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			logger.error("密码MD5加密是出错", e);
			return new BaseRespVO(99, "密码MD5加密是出错");
		}
		// 状态默认是激活
		if (user.getStatus() == null) {
			user.setStatus(1);
		}

		UserEntity entity = new UserEntity();
		entity.setLoginName(user.getLoginName());
		entity.setSysId(sessionUser.getSysId());
		if (userBo.queryByEntity(entity) != null) {
			return new BaseRespVO(2, "登录名重复");
		}

		userBo.createForValidate(user);
		return user;
	}

	/**
	 * 修改详细信息
	 * 
	 * @param reqVO
	 * @return
	 * @throws CenterException
	 */
	public BaseRespVO update(UserEntity user) throws CenterException {
		if (user.getPassword() != null) {
			if (user.getPassword().equals("")) {
				user.setPassword(null);
			}
		}
		if (user.getStatus() != null) {
			if (user.getStatus() == 99 || user.getStatus() == 0) {
				// TODO xuwei
				if (user.getStatus() == 99)
					user.setStatus(null);
				List<Long> userIdList = new ArrayList<Long>();
				if (user.getUserId() != null) {
					userIdList.add(user.getUserId());
				}
				if (userIdList.size() > 0)
					sessionHandler.deleteSession(userIdList);
			}
		}
		if (user.getPassword() != null) {
			try {
				user.setPassword(UserPwdUtil.encoderPwd(user.getPassword()));
			} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
				logger.error("密码MD5加密是出错", e);
				return new BaseRespVO(99, "密码MD5加密是出错");
			}
		}
		userBo.updateForValidate(user);
		return new BaseRespVO();
	}

	/**
	 * 状态修改
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO updateStatus(@Param("userId") long userId, @Param("status") int status) {
		UserEntity entity = new UserEntity();
		entity.setUserId(userId);
		entity.setStatus(status);

		int count = userBo.update(entity);

		// 状态修改为注销的时候，调用网关，删除用户登录会话
		if (status != 0 && count > 0) {
			List<Long> userIdList = new ArrayList<Long>();
			userIdList.add(userId);
			sessionHandler.deleteSession(userIdList);
		}

		return new BaseRespVO();
	}

	/**
	 * 修改详细信息
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO updateMyDetail(UserEntity user) {
		SessionUser sessionUser = ThreadContext.getSessionloginUser();

		if (sessionUser == null) {
			return new BaseRespVO(99, "无法获取登录用户信息");
		}
		// 只能修改自己
		user.setUserId(sessionUser.getUserId());
		// 不能修改密码
		user.setPassword(null);
		userBo.update(user);
		return new BaseRespVO();
	}

	/**
	 * 修改密码
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO updateMyPassword(@Param("oldPassword") String oldPassword, @Param("newPassword") String newPassword) {
		SessionUser sessionUser = ThreadContext.getSessionloginUser();

		if (sessionUser == null) {
			return new BaseRespVO(99, "无法获取登录用户信息");
		}

		if (oldPassword.equals(newPassword)) {
			return BaseRespVO.error("原密码与新密码一致，无需修改");
		}

		// 校验密码格式
		BaseRespVO resp = UserPwdUtil.checkPwd(newPassword);
		if (resp != null) {
			return resp;
		}

		Map<String, Object> map = new HashMap<String, Object>(3);
		map.put("userId", sessionUser.getUserId());
		try {
			map.put("oldPassword", UserPwdUtil.encoderPwd(oldPassword));
			map.put("newPassword", UserPwdUtil.encoderPwd(newPassword));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			logger.error("密码MD5加密是出错", e);
			return new BaseRespVO(99, "密码MD5加密是出错");
		}

		int count = userBo.updatePassword(map);

		if (count < 1) {
			return new BaseRespVO(99, "密码错误！");
		}

		return new BaseRespVO();
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public BaseRespVO delete(@Param("userId") Long[] userId) {
		for (Long long1 : userId) {
			UserEntity entity=userBo.queryById(long1);
			if (entity !=null) {
				//查询用户信息是否被人员信息占用
				Map<String, Object> params=new HashMap<>();
				params.put("loginName", entity.getLoginName());//查询条件--登陆用户
				PersoninfoEntity personinfoEntity=personinfoBo.queryByMapParams(params);//返回值
				if (personinfoEntity !=null) {
					return BaseRespVO.error("用户信息被其它模块占用不能删除");
				}
			}
		}
		int deleteCount = userBo.batchDeleteById(userId);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}

	}

}
