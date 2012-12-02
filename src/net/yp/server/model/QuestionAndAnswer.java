package net.yp.server.model;

import java.util.List;

public class QuestionAndAnswer {
	private Question question;
	private List<Answer> answers;
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
}
