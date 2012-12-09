package net.yp.server.model;

/**
 * 联系人与分组关系
 * @author Eric
 *
 */
public class UserGroupRel {
	private String msgId;
	private String groupId;
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
}
