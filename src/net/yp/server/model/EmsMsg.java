package net.yp.server.model;

import java.util.Date;

public class EmsMsg {
	private String uuid;
	private int id;
	private String tuuid;//模板
	private String tname;
	private String uuuid;//创建人
	private String uname;
	private String msg;
	private String status;
	private Date createTime;
	private QaTemplate qaTempLate;
	private GeneralTemplate generalTemplate;
	private PublicityTemplate publicityTemplate;
	
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
	public String getTuuid() {
		return tuuid;
	}
	public void setTuuid(String tuuid) {
		this.tuuid = tuuid;
	}
	public String getUuuid() {
		return uuuid;
	}
	public void setUuuid(String uuuid) {
		this.uuuid = uuuid;
	}
	public QaTemplate getQaTempLate() {
		return qaTempLate;
	}
	public void setQaTempLate(QaTemplate qaTempLate) {
		this.qaTempLate = qaTempLate;
	}
	public GeneralTemplate getGeneralTemplate() {
		return generalTemplate;
	}
	public void setGeneralTemplate(GeneralTemplate generalTemplate) {
		this.generalTemplate = generalTemplate;
	}
	public PublicityTemplate getPublicityTemplate() {
		return publicityTemplate;
	}
	public void setPublicityTemplate(PublicityTemplate publicityTemplate) {
		this.publicityTemplate = publicityTemplate;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
