package net.yp.server.service;

import java.util.List;
import java.util.Map;

import net.yp.server.model.UserGroup;
import net.yp.server.model.UserMsg;

public interface UserService {
	
	/**
	 * 获取联系人分组信息
	 * @param params
	 * @return
	 */
     List<UserGroup> queryUserGroup(Map<String,Object> params);
     
     /**
      * 根据组获取联系人信息
      * @param params
      * @return
      */
     List<UserMsg> queryUserMsgByGroup(Map<String,Object> params);
     
}
