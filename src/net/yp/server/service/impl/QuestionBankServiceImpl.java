package net.yp.server.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.yp.server.dao.QuestionBankMapper;
import net.yp.server.model.Answer;
import net.yp.server.model.Question;
import net.yp.server.model.QuestionAndAnswer;
import net.yp.server.service.QuestionBankService;
import net.yp.server.util.Constant;
import net.yp.server.util.EmsUtil;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class QuestionBankServiceImpl implements QuestionBankService {

	@Autowired
	private QuestionBankMapper questionBankMapper;
	private static Logger logger = Logger
			.getLogger(QuestionBankServiceImpl.class);

	public Integer addQuestion(Question question) {
		int result = 0;
		try {
			result = questionBankMapper.addQuestion(question);
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	public Integer editQuestion(Question question) {
		int result = 0;
		try {
			result = questionBankMapper.editQuestion(question);
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	public String delQuestion(String[] ids) {
		String status = Constant.RESULT_SUCCESS;
		String result = "SUCCESS";
		try {
			int count = ids.length;
			for (int i = 0; i < count; i++) {
				questionBankMapper.delQuestion(Integer.parseInt(ids[i]));
			}
		} catch (Exception e) {
			status = Constant.RESULT_FAILED;
			result = e.getMessage();
			logger.info(result);
			e.printStackTrace();
		}
		return EmsUtil.getJsonResult(status, result);
	}

	public Integer addAnswer(Answer answer) {
		int result = 0;
		try {
			result = questionBankMapper.addAnswer(answer);
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	public Integer editAnswer(Answer answer) {
		int result = 0;
		try {
			result = questionBankMapper.editAnswer(answer);
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	public String delAnswer(String[] ids) {
		String status = Constant.RESULT_SUCCESS;
		String result = "SUCCESS";
		try {
			int count = ids.length;
			Map<String, Object> params = new HashMap<String, Object>();
			for (int i = 0; i < count; i++) {
				params.put("id", Integer.parseInt(ids[i]));
				questionBankMapper.delAnswer(params);
			}
		} catch (Exception e) {
			status = Constant.RESULT_FAILED;
			result = e.getMessage();
			logger.info(result);
			e.printStackTrace();
		}
		return EmsUtil.getJsonResult(status, result);
	}

	public String delAnswer(int pid) {
		String status = Constant.RESULT_SUCCESS;
		String result = "SUCCESS";
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("pid", pid);
			questionBankMapper.delAnswer(params);
		} catch (Exception e) {
			status = Constant.RESULT_FAILED;
			result = e.getMessage();
			logger.info(result);
			e.printStackTrace();
		}
		return EmsUtil.getJsonResult(status, result);
	}

	public String addQuestionAndAnswer(QuestionAndAnswer questionAndAnswer) {
		String status = "SUCCESS";
		String result = "SUCCESS";
		try {
			Question question = questionAndAnswer.getQuestion();
			List<Answer> answers = questionAndAnswer.getAnswers();
			int count = answers.size();
			questionBankMapper.addQuestion(question);
			for (int i = 0; i < count; i++) {
				Answer answer = answers.get(i);
				questionBankMapper.addAnswer(answer);
			}
		} catch (Exception e) {
			status = "FAILED";
			result = e.getMessage();
			logger.info(result);
			e.printStackTrace();
		}
		return EmsUtil.getJsonResult(status, result);
	}

	public List<QuestionAndAnswer> queryQuestionAndAnswer(
			Map<String, Object> params) {
		List<QuestionAndAnswer> questionAndAnswers = new ArrayList<QuestionAndAnswer>();
		try {
			List<Question> questions = questionBankMapper.queryQuestion(params);
			for (Question question : questions) {
				QuestionAndAnswer questionAndAnswer = new QuestionAndAnswer();
				questionAndAnswer.setQuestion(question);
				List<Answer> answers = questionBankMapper.queryAnswer(question
						.getId());
				questionAndAnswer.setAnswers(answers);
				questionAndAnswers.add(questionAndAnswer);
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return questionAndAnswers;
	}

	public String editQuestionAndAnswer(QuestionAndAnswer questionAndAnswer) {
		String status = "SUCCESS";
		String result = "SUCCESS";
		try {
			Question question = questionAndAnswer.getQuestion();
			List<Answer> answers = questionAndAnswer.getAnswers();
			int count = answers.size();
			questionBankMapper.editQuestion(question);
			for (int i = 0; i < count; i++) {
				Answer answer = answers.get(i);
				questionBankMapper.editAnswer(answer);
			}
		} catch (Exception e) {
			status = "FAILED";
			result = e.getMessage();
			logger.info(result);
			e.printStackTrace();
		}
		return EmsUtil.getJsonResult(status, result);
	}

	public long queryQuestionCount() {
		return questionBankMapper.queryquestionCount();
	}

}
