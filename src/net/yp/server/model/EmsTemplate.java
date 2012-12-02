package net.yp.server.model;

import java.util.Date;
import java.util.List;

public class EmsTemplate {
	private String id;
	private String name;
	private String type;
	private Date createTime;
	private String status;
	private String context;
	private List<EmsTemplateDetal> emsTemplateDetals;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public List<EmsTemplateDetal> getEmsTemplateDetals() {
		return emsTemplateDetals;
	}
	public void setEmsTemplateDetals(List<EmsTemplateDetal> emsTemplateDetals) {
		this.emsTemplateDetals = emsTemplateDetals;
	}
	
}
