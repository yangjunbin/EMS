package net.yp.server.service.impl;

import java.util.List;
import java.util.Map;

import net.yp.server.dao.UserMsgMapper;
import net.yp.server.model.UserGroup;
import net.yp.server.model.UserMsg;
import net.yp.server.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserMsgMapper userMsgMapper;
	
	public List<UserGroup> queryUserGroup(Map<String, Object> params) {
		List<UserGroup> userGroups = null;
		try {
			userGroups = userMsgMapper.queryUserGroup(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userGroups;
	}

	public List<UserMsg> queryUserMsgByGroup(Map<String, Object> params) {
		List<UserMsg> userMsgs = null;
		try {
			userMsgs = userMsgMapper.queryUserMsgByGroup(params);
		} catch (Exception e) {
			e.printStackTrace();
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
		}
		return "成功:"+success+",失败:"+failed+",重复:"+repeat+"（已过滤）";
	}

}
