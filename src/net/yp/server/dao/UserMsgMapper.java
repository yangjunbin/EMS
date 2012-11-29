package net.yp.server.dao;

import java.util.List;
import java.util.Map;

import net.yp.server.model.UserGroup;
import net.yp.server.model.UserMsg;




public interface UserMsgMapper
{
	/**
	 * 获取联系人分组信息
	 * @param params
	 * @return
	 */
     List<UserGroup> queryUserGroup(Map<String,Object> params);
    
     /**
      * 获取联系人分组记录数
      * @param params
      * @return
      */
     Long queryUserGroupCount(Map<String,Object> params);
     
     /**
      * 根据组获取联系人信息
      * @param params
      * @return
      */
     List<UserMsg> queryUserMsgByGroup(Map<String,Object> params);
     
     /**
      * 根据组获取联系人信息记录数
      * @param params
      * @return
      */
     Long queryUserMsgByGroupCount(Map<String,Object> params);
     
     /**
      * 根据联系人姓名和电话号码判断是否已存在
      * @param userMsg
      * @return
      */
     Long queryUserMsgCountByNameAndPhoneNumber(UserMsg userMsg);
     /**
      * 新增联系人信息
      * @param userMsgs
      * @return
      */
     Integer addUserMsg(UserMsg userMsg);
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
