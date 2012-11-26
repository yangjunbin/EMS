package net.yp.server.dao;

import java.util.List;
import java.util.Map;

import net.yp.server.model.LoginUser;



public interface LoginUserMapper
{
	
	/**
	 * 获取所有的登陆用户信息
	 * @param params
	 * @return
	 */
    List<LoginUser> queryLoginUsers(Map<String,Object> params);
    
    /**
     * 根据条件获取一个登陆用户信息
     * @param loginUser
     * @return
     */
    LoginUser queryLoginUser(Map<String,Object> params);
    
    /**
     * 获取登陆用户信息记录数
     * @param params
     * @return
     */
    Long queryLoginUserCount(Map<String,Object> params);
    
    /**
     * 新增登陆用户
     * @param loginUser
     * @return
     */
    Integer addLoginUser(LoginUser loginUser);
    
    /**
     * 修改登陆用户
     * @param loginUser
     * @return
     */
    Integer editLoginUser(LoginUser loginUser);
    
    /**
     * 修改登陆用户状态
     * @param loginUser
     * @return
     */
    Integer editLoginUserStatus(LoginUser loginUser);
    
    /**
     * 更新登陆用户登陆时间
     * @param id
     * @return
     */
    Integer editLoginUserLoginTime(String id);
    
    /**
     * 修改错误登陆次数
     * @param loginUser
     * @return
     */
    Integer editLoginUserErrorCount(LoginUser loginUser);
    
    /**
     * 删除登陆用户
     * @param id
     * @return
     */
    Integer delLoginUser(String id);
    
    /**
     * 公司版权信息.
     */
    public static final String copyright = "Copyright 2012, Carefx Corporation";
    /**
     * 提交路径.
     */
    public static final String SCC_BRANCH = "$URL$";
    /**
     * 提交日期.
     */
    public static final String SCC_LAST_MODIFICATION_DATE = "$Date$";
    /**
     * 最终修改人员.
     */
    public static final String SCC_LAST_MODIFIER_NAME = "$Author$";
    /**
     * 最终版本号.
     */
    public static final String SCC_REVISION = "$Revision$";
}
