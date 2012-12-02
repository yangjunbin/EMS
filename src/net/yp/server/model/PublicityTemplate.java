package net.yp.server.model;

import java.util.List;

/**
 * 宣传模板
 * @author mac
 *
 */
public class PublicityTemplate {
	/**
	 * 头图地址
	 */
	private String pictureUrl;
	private String pictureSource;
	private String pictureName;
	private String pictureType;
	/**
	 * 介绍
	 */
	private String conText;
	
	/**
	 * 商品列表
	 */
	private List<Commodity> commoditys;

	
	public String getPictureSource() {
		return pictureSource;
	}

	public void setPictureSource(String pictureSource) {
		this.pictureSource = pictureSource;
	}

	public String getPictureName() {
		return pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	public String getPictureType() {
		return pictureType;
	}

	public void setPictureType(String pictureType) {
		this.pictureType = pictureType;
	}

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

	public List<Commodity> getCommoditys() {
		return commoditys;
	}

	public void setCommoditys(List<Commodity> commoditys) {
		this.commoditys = commoditys;
	}
	
	
}
