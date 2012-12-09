package net.yp.server.model;

/**
 * 联系人与分组关系
 * @author Eric
 *
 */
public class UserGroupRel {
	private String msguuId;
	private String groupuuId;
	public String getMsguuId() {
		return msguuId;
	}
	public void setMsguuId(String msguuId) {
		this.msguuId = msguuId;
	}
	public String getGroupuuId() {
		return groupuuId;
	}
	public void setGroupuuId(String groupuuId) {
		this.groupuuId = groupuuId;
	}
	
}
