package net.yp.server.model;

/**
 * 联系人与分组关系
 * @author Eric
 *
 */
public class UserGroupRel {
	private int msgId;
	private int groupId;
	public int getMsgId() {
		return msgId;
	}
	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	
}
