package net.yp.server.model;

public class GeneralTemplate {
	/**
	 * 头图地址
	 */
	private String pictureUrl;
	/**
	 * 介绍
	 */
	private String conText;
	
	/**
	 * 模板内容
	 */
	private String text;

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getConText() {
		return conText;
	}

	public void setConText(String conText) {
		this.conText = conText;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
