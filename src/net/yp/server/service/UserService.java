package net.yp.server.service;

import java.util.List;
import java.util.Map;

import net.yp.server.model.UserGroup;
import net.yp.server.model.UserGroupRel;
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
     
     /**
      * 查询未分组联系人信息
      * @param params
      * @return
      */
     List<UserMsg> queryUngroupedUserMsg(Map<String,Object> params);
     
     /**
      * 新增联系人
      * @param userMsgs
      * @return
      */
     String addUserMsgs(List<UserMsg> userMsgs);
     
     /**
      * 更新联系人信息
      * @param userMsg
      * @return
      */
     String editUserMsg(UserMsg userMsg);
     
     /**
      * 删除联系人信息
      * @param ids
      * @return
      */
     String delUserMsg(List<String> ids);
     
     /**
      * 新增联系人分组
      * @param userGroups
      * @return
      */
     String addUserGroup(List<UserGroup> userGroups);
     
     /**
      * 更新联系人分组
      * @param userGroup
      * @return
      */
     String editUserGroup(UserGroup userGroup);
     
     /**
      * 删除联系人分组
      * @param ids
      * @return
      */
     String delUserGroup(List<String> ids);
     
     /**
      * 新增联系人与分组关联
      * @param userGroupRels
      * @return
      */
     String addUserGroupRel(List<UserGroupRel> userGroupRels);
     
     /**
      * 删除联系人与分组关联
      * @param userGroupRels
      * @return
      */
     String delUserGroupRel(List<UserGroupRel> userGroupRels);
}
