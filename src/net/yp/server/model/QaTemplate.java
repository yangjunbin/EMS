package net.yp.server.model;

import java.util.List;

/**
 * 问答模板
 * @author Eric
 *
 */
public class QaTemplate {
	/**
	 * 头图地址
	 */
	private String pictureUrl;
	/**
	 * 介绍
	 */
	private String conText;
	/**
	 * 问题列表
	 */
	private List<QuestionAndAnswer> questions;
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
	public List<QuestionAndAnswer> getQuestions() {
		return questions;
	}
	public void setQuestions(List<QuestionAndAnswer> questions) {
		this.questions = questions;
	}
	
}
