package net.yp.server.service;

import java.util.List;
import java.util.Map;

import net.yp.server.model.Answer;
import net.yp.server.model.Question;
import net.yp.server.model.QuestionAndAnswer;

public interface QuestionBankService {
	
	/**
	 * 新增问题
	 * @param question
	 * @return
	 */
	Integer addQuestion(Question question);
	
	/**
	 * 新增题目和答案
	 * @param questionAndAnswer
	 * @return
	 */
	String addQuestionAndAnswer(QuestionAndAnswer questionAndAnswer);
	
	/**
	 * 修改题目和答案
	 * @param questionAndAnswer
	 * @return
	 */
	String editQuestionAndAnswer(QuestionAndAnswer questionAndAnswer);
	
	/**
	 * 查询题目和答案
	 * @param params
	 * @return
	 */
	List<QuestionAndAnswer> queryQuestionAndAnswer(Map<String,Object> params);
	/**
	 * 修改问题
	 * @param question
	 * @return
	 */
	Integer editQuestion(Question question);
	
	/**
	 * 删除问题
	 * @param ids
	 * @return
	 */
	Integer delQuestion(List<String> ids);
	
	/**
	 * 新增答案
	 * @param answer
	 * @return
	 */
	Integer addAnswer(Answer answer);
	
	/**
	 * 修改答案
	 * @param answer
	 * @return
	 */
	Integer editAnswer(Answer answer);
	
	/**
	 * 删除答案
	 * @param ids
	 * @return
	 */
	String delAnswer(String[] ids);
	
	/**
	 * 根据题目删除答案
	 * @param pid
	 * @return
	 */
	String delAnswer(String pid);
	
}
