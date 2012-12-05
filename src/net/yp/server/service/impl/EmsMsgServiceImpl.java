package net.yp.server.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.yp.server.dao.CommodityMapper;
import net.yp.server.dao.EmsMsgMapper;
import net.yp.server.dao.EmsTemplateMapper;
import net.yp.server.dao.QuestionBankMapper;
import net.yp.server.model.Answer;
import net.yp.server.model.Commodity;
import net.yp.server.model.EmsMsg;
import net.yp.server.model.EmsTemplate;
import net.yp.server.model.EmsTemplateDetal;
import net.yp.server.model.GeneralTemplate;
import net.yp.server.model.PublicityTemplate;
import net.yp.server.model.QaTemplate;
import net.yp.server.model.Question;
import net.yp.server.model.QuestionAndAnswer;
import net.yp.server.service.EmsMsgService;
import net.yp.server.util.Constant;
import net.yp.server.util.EmsUtil;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class EmsMsgServiceImpl implements EmsMsgService {

	@Autowired
	private EmsMsgMapper emsMsgMapper;
	@Autowired
	private EmsTemplateMapper emsTemplateMapper;
	@Autowired
	private CommodityMapper commodityMapper;
	@Autowired
	private QuestionBankMapper questionBankMapper;
	private static  Logger logger=Logger.getLogger(EmsMsgServiceImpl.class);

	public String addEmsMsg(EmsMsg emsMsg) {
		String status = Constant.RESULT_SUCCESS;
		String result = "SUCCESS";
		try {
			emsMsgMapper.addEmsMsg(emsMsg);
		} catch (Exception e) {
			status = Constant.RESULT_FAILED;
			result = e.getMessage();
			logger.info(result);
			e.printStackTrace();
		}
		return EmsUtil.getJsonResult(status, result);
	}

	public String editEmsMsg(EmsMsg emsMsg) {
		String status = Constant.RESULT_SUCCESS;
		String result = "SUCCESS";
		try {
			emsMsgMapper.editEmsMsg(emsMsg);
		} catch (Exception e) {
			status = Constant.RESULT_FAILED;
			result = e.getMessage();
			logger.info(result);
			e.printStackTrace();
		}
		return EmsUtil.getJsonResult(status, result);
	}

	public String editEmsMsgStatus(EmsMsg emsMsg) {
		String status = Constant.RESULT_SUCCESS;
		String result = "SUCCESS";
		try {
			emsMsgMapper.editEmsMsgStatus(emsMsg);
		} catch (Exception e) {
			status = Constant.RESULT_FAILED;
			result = e.getMessage();
			logger.info(result);
			e.printStackTrace();
		}
		return EmsUtil.getJsonResult(status, result);
	}

	public String delEmsMsg(String uuid) {
		String status = Constant.RESULT_SUCCESS;
		String result = "SUCCESS";
		try {
			emsMsgMapper.delEmsMsg(uuid);
		} catch (Exception e) {
			status = Constant.RESULT_FAILED;
			result = e.getMessage();
			logger.info(result);
			e.printStackTrace();
		}
		return EmsUtil.getJsonResult(status, result);
	}

	public List<EmsMsg> queryEmsMsg(Map<String, Object> params) {
		List<EmsMsg> emsMsgs = null;
		try {
			emsMsgs = emsMsgMapper.queryEmsMsg(params);
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return emsMsgs;
	}

	public Long queryEmsMsgCount(Map<String, Object> params) {
		Long count = 0L;
		try {
			count = emsMsgMapper.queryEmsMsgCount(params);
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return count;
	}

	public EmsMsg queryEmsMsgDetal(EmsMsg emsMsg) {
		String tempId = emsMsg.getTuuid();
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("uuid", tempId);
		EmsTemplate emsTemplate = emsTemplateMapper.queryEmsTemplateById(params);
		params.put("puuid", tempId);
		List<EmsTemplateDetal> emsTemplateDetals = emsTemplateMapper.queryEmsTemplateDetal(params);
		String tempType = emsTemplate.getType();
		if(tempType.equals(Constant.QUESTION_STATUS))
		{
			QaTemplate qaTempLate = new QaTemplate();
			qaTempLate.setConText(emsTemplate.getContext());
			List<QuestionAndAnswer> questionAndAnswers = new ArrayList<QuestionAndAnswer>();
			for(EmsTemplateDetal emsTemplateDetal : emsTemplateDetals)
			{
				if(Constant.PICTURE_STATUS.equals(emsTemplateDetal.getType()))
				{
					qaTempLate.setPictureUrl(emsTemplateDetal.getValue());
				}
				else if(Constant.QUESTION_STATUS.equals(emsTemplateDetal.getType()))
				{
					QuestionAndAnswer questionAndAnswer = new QuestionAndAnswer();
					String questionId = emsTemplateDetal.getValue();
					Question question = questionBankMapper.queryQuestionById(questionId);
					questionAndAnswer.setQuestion(question);
					List<Answer> answers = questionBankMapper.queryAnswer(question
							.getUuid());
					questionAndAnswer.setAnswers(answers);
					questionAndAnswers.add(questionAndAnswer);
				}
			}
			qaTempLate.setQuestions(questionAndAnswers);
			emsMsg.setQaTempLate(qaTempLate);
		}
		else if((tempType.equals(Constant.GENERAL_STATUS)))
		{
			GeneralTemplate generalTemplate = new GeneralTemplate();
			generalTemplate.setConText(emsTemplate.getContext());
			for(EmsTemplateDetal emsTemplateDetal : emsTemplateDetals)
			{
				if(Constant.PICTURE_STATUS.equals(emsTemplateDetal.getType()))
				{
					generalTemplate.setPictureUrl(emsTemplateDetal.getValue());
				}
				else  if(Constant.GENERAL_STATUS.equals(emsTemplateDetal.getType()))
				{
					generalTemplate.setText(emsTemplateDetal.getValue());
				}
			}
			emsMsg.setGeneralTemplate(generalTemplate);
		}
		else if((tempType.equals(Constant.COMMODITY_STATUS)))
		{
			PublicityTemplate publicityTemplate = new PublicityTemplate();
			publicityTemplate.setConText(emsTemplate.getContext());
			List<Commodity> commoditys = new ArrayList<Commodity>();
			for(EmsTemplateDetal emsTemplateDetal : emsTemplateDetals)
			{
				if(Constant.PICTURE_STATUS.equals(emsTemplateDetal.getType()))
				{
					publicityTemplate.setPictureUrl(emsTemplateDetal.getValue());
				}
				else if(Constant.COMMODITY_STATUS.equals(emsTemplateDetal.getType()))
				{
					String commondityId = emsTemplateDetal.getValue();
					Commodity commodity = commodityMapper.queryCommodityByUUId(commondityId);
					commoditys.add(commodity);
				}
			}
			publicityTemplate.setCommoditys(commoditys);
			emsMsg.setPublicityTemplate(publicityTemplate);
		}	
		return emsMsg;
	}

}
