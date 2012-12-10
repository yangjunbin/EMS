package net.yp.server.dao;

import java.util.List;
import java.util.Map;

import net.yp.server.model.Answer;
import net.yp.server.model.Question;

public interface QuestionBankMapper {
	
	/**
	 * 新增问题
	 * @param question
	 * @return
	 */
	Integer addQuestion(Question question);
	
	/**
	 * 修改问题
	 * @param question
	 * @return
	 */
	Integer editQuestion(Question question);
	
	/**
	 * 删除问题
	 * @param id
	 * @return
	 */
	Integer delQuestion(int id);
	
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
	 * @param params
	 * @return
	 */
	Integer delAnswer(Map<String,Object> params);
	
	/**
	 * 查询问题
	 * @param params
	 * @return
	 */
	List<Question> queryQuestion(Map<String,Object> params);
	
	/**
	 * 根据问题ID查询问题信息
	 * @param id
	 * @return
	 */
	Question queryQuestionById(int id);
	/**
	 * 查询问题记录数
	 * @return
	 */
	Long queryquestionCount();
	
	/**
	 * 查询答案
	 * @param qid
	 * @return
	 */
	List<Answer> queryAnswer(int qid);
}
