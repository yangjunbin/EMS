package net.yp.server.service.impl;

import java.util.List;
import java.util.Map;

import net.yp.server.dao.UserMsgMapper;
import net.yp.server.model.UserGroup;
import net.yp.server.model.UserGroupRel;
import net.yp.server.model.UserMsg;
import net.yp.server.service.UserService;
import net.yp.server.util.Constant;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserMsgMapper userMsgMapper;
	private Logger logger = Logger.getLogger(UserServiceImpl.class.getClass());
	public List<UserGroup> queryUserGroup(Map<String, Object> params) {
		List<UserGroup> userGroups = null;
		try {
			userGroups = userMsgMapper.queryUserGroup(params);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		return userGroups;
	}

	public List<UserMsg> queryUserMsgByGroup(Map<String, Object> params) {
		List<UserMsg> userMsgs = null;
		try {
			userMsgs = userMsgMapper.queryUserMsgByGroup(params);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());

		}
		return userMsgs;
	}

	public String addUserMsgs(List<UserMsg> userMsgs) {
		int success = 0;
		int failed = 0;
		int repeat = 0;
		try {
			int count = userMsgs.size();
			for(int i=0;i<count;i++)
			{
				UserMsg userMsg = userMsgs.get(i);
				Long userMsgRepeat = userMsgMapper.queryUserMsgCountByNameAndPhoneNumber(userMsg);
				if(userMsgRepeat==0)
				{
					int result = userMsgMapper.addUserMsg(userMsg);
					if(result==0)
					{
						failed++;
					}
					else
					{
						//默认分组
						UserGroupRel userGroupRel = new UserGroupRel();
						userGroupRel.setGroupId(Constant.UNGROUPED_ID);
						userGroupRel.setMsgId(userMsg.getId());
						userMsgMapper.addUserGroupRel(userGroupRel);
						success++;
					}
				}
				else
				{
					repeat++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		return "成功:"+success+",失败:"+failed+",重复:"+repeat+"（已过滤）";
	}

	public List<UserMsg> queryUngroupedUserMsg(Map<String, Object> params) {
		List<UserMsg> userMsgs = null;
		try {
			userMsgs = userMsgMapper.queryUngroupedUserMsg(params);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		return userMsgs;
	}

	public String editUserMsg(UserMsg userMsg) {
		String msg = "成功";
		try {
			int result = userMsgMapper.editUserMsg(userMsg);
			if(result==0)
			{
				msg = "失败";
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		return msg;
	}

	public String delUserMsg(List<Integer> ids) {
		int success = 0;
		int failed = 0;
		try {
			int count = ids.size();
			for(int i=0;i<count;i++)
			{
				int id = ids.get(i);
				int result = userMsgMapper.delUserMsg(id);
				if(result>0)
				{
					success++;
				}
				else
				{
					failed++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		return "成功:"+success+",失败:"+failed;
	}

	public String addUserGroup(List<UserGroup> userGroups) {
		int success = 0;
		int failed = 0;
		try {
			int count = userGroups.size();
			for(int i=0;i<count;i++)
			{
				UserGroup userGroup = userGroups.get(i);
				int result = userMsgMapper.addUserGroup(userGroup);
				if(result>0)
				{
					success++;
				}
				else
				{
					failed++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		return "成功："+success+",失败:"+failed;
	}

	public String editUserGroup(UserGroup userGroup) {
		
		String msg = "成功";
		try {
			int result = userMsgMapper.editUserGroup(userGroup);
			if(result==0)
			{
				msg = "失败";
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		return msg;
	}

	public String delUserGroup(List<Integer> ids) {
		int success = 0;
		int failed = 0;
		try {
			int count = ids.size();
			for(int i=0;i<count;i++)
			{
				int id = ids.get(i);
				int result = userMsgMapper.delUserGroup(id);
				if(result>0)
				{
					UserGroupRel userGroupRel = new UserGroupRel();
					userGroupRel.setGroupId(id);
					userMsgMapper.delUserGroupRel(userGroupRel);
					success++;
				}
				else
				{
					failed++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		return "成功："+success+",失败:"+failed;
	}

	public String addUserGroupRel(List<UserGroupRel> userGroupRels) {
		int success = 0;
		int failed = 0;
		try {
			int count = userGroupRels.size();
			for(int i=0;i<count;i++)
			{
				UserGroupRel userGroupRel = userGroupRels.get(i);
				int result = userMsgMapper.addUserGroupRel(userGroupRel);
				if(result>0)
				{
					success++;
				}
				else
				{
					failed++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		return "成功："+success+",失败:"+failed;
	}

	public String delUserGroupRel(List<UserGroupRel> userGroupRels) {
		int success = 0;
		int failed = 0;
		try {
			int count = userGroupRels.size();
			for(int i=0;i<count;i++)
			{
				UserGroupRel userGroupRel = userGroupRels.get(i);
				int result = userMsgMapper.delUserGroupRel(userGroupRel);
				if(result>0)
				{
					success++;
				}
				else
				{
					failed++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		return "成功："+success+",失败:"+failed;
	}

	public Long queryUserGroupCount(Map<String, Object> params) {
		long size = 0l;
		try {
			size = userMsgMapper.queryUserGroupCount(params);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		return size;
	}

	public Long queryUserMsgByGroupCount(Map<String, Object> params) {
		long size = 0l;
		try {
			size = userMsgMapper.queryUserMsgByGroupCount(params);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		return size;
	}

}
