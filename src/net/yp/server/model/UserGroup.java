package net.yp.server.model;

/**
 * 联系人分组
 * @author Eric
 *
 */
public class UserGroup {
	private String uuid;
	private int id;
	private String name;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
