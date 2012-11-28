package net.yp.server.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import net.yp.server.dao.LoginUserMapper;
import net.yp.server.model.LoginUser;
import net.yp.server.service.LoginService;

public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginUserMapper loginMapper;
	private static  Logger logger=Logger.getLogger(LoginServiceImpl.class);
			
	public List<LoginUser> queryLoginUsers(Map<String, Object> params) {
		List<LoginUser> loginUsers = null;
		try {
			loginUsers =  loginMapper.queryLoginUsers(params);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			e.printStackTrace();
		}
		return loginUsers;
	}

	public LoginUser queryLoginUser(Map<String,Object> params) {
		LoginUser result = null;
		try {
			result = loginMapper.queryLoginUser(params);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	public Long queryLoginUserCount(Map<String, Object> params) {
		Long count = 0L;
		try {
			count = loginMapper.queryLoginUserCount(params);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			e.printStackTrace();
		}
		return count;
	}

	public Integer addLoginUser(LoginUser loginUser) {
		Integer result = 0;
		try {
			result = loginMapper.addLoginUser(loginUser);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	public Integer editLoginUser(LoginUser loginUser) {
		Integer result = 0;
		try {
			result = loginMapper.editLoginUser(loginUser);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	public Integer editLoginUserStatus(LoginUser loginUser) {
		Integer result = 0;
		try {
			result = loginMapper.editLoginUserStatus(loginUser);
			loginMapper.editLoginUserLoginTime(loginUser.getId());
		} catch (Exception e) {
			logger.debug(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	public Integer editLoginUserLoginTime(String id) {
		Integer result = 0;
		try {
			result = loginMapper.editLoginUserLoginTime(id);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}


	public Integer editLoginUserErrorCount(LoginUser loginUser) {
		Integer result = 0;
		try {
			result = loginMapper.editLoginUserErrorCount(loginUser);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	
	public Integer delLoginUser(String id) {
		Integer result = 0;
		try {
			result = loginMapper.delLoginUser(id);
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		return result;
	}

}
