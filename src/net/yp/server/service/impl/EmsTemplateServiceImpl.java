package net.yp.server.service.impl;

import java.util.List;
import java.util.Map;

import net.yp.server.dao.EmsTemplateMapper;
import net.yp.server.model.Commodity;
import net.yp.server.model.EmsTemplate;
import net.yp.server.model.EmsTemplateDetal;
import net.yp.server.model.GeneralTemplate;
import net.yp.server.model.PublicityTemplate;
import net.yp.server.model.QaTemplate;
import net.yp.server.model.QuestionAndAnswer;
import net.yp.server.service.EmsTemplateService;
import net.yp.server.util.Constant;
import net.yp.server.util.EmsUtil;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class EmsTemplateServiceImpl implements EmsTemplateService {

	@Autowired
	private EmsTemplateMapper emsTemplateMapper;
	private static  Logger logger=Logger.getLogger(EmsTemplateServiceImpl.class);

	public Integer addEmsTemplate(EmsTemplate emsTemplate) {
		int result = 0;
		try {
			result = emsTemplateMapper.addEmsTemplate(emsTemplate);
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	public Integer addEmsTemplateDetal(EmsTemplateDetal emsTemplateDetal) {
		int result = 0;
		try {
			result = emsTemplateMapper.addEmsTemplateDetal(emsTemplateDetal);
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	public List<EmsTemplate> queryEmsTemplate(Map<String, Object> params) {
		List<EmsTemplate> result = null;
		try {
			result = emsTemplateMapper.queryEmsTemplate(params);
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	public List<EmsTemplateDetal> queryEmsTemplateDetal(
			Map<String, Object> params) {
		List<EmsTemplateDetal> result = null;
		try {
			result = emsTemplateMapper.queryEmsTemplateDetal(params);
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	public EmsTemplate queryEmsTemplateById(Map<String, Object> params) {
		EmsTemplate result = null;
		try {
			result = emsTemplateMapper.queryEmsTemplateById(params);
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	public Integer delEmsTemplate(EmsTemplate emsTemplate) {
		int result = 0;
		try {
			result = emsTemplateMapper.delEmsTemplate(emsTemplate);
			EmsTemplateDetal emsTemplateDetal = new EmsTemplateDetal();
			emsTemplateDetal.setPid(emsTemplate.getId());
			result = emsTemplateMapper.delEmsTemplateDetal(emsTemplateDetal);
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	public Integer delEmsTemplateDetal(EmsTemplateDetal emsTemplateDetal) {
		int result = 0;
		try {
			result = emsTemplateMapper.delEmsTemplateDetal(emsTemplateDetal);
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	public String addQaTemplate(QaTemplate qaTemplate) {
		try {
			EmsTemplate emsTemplate = new EmsTemplate();
			emsTemplate.setContext(qaTemplate.getConText());
			String pid = Constant.getUUID();
			emsTemplate.setId(pid);
			emsTemplate.setType(Constant.QUESTION_STATUS);
			emsTemplateMapper.addEmsTemplate(emsTemplate);//保存模板
			
			EmsTemplateDetal _emsTemplateDetal = new EmsTemplateDetal();
			_emsTemplateDetal.setId(Constant.getUUID());
			_emsTemplateDetal.setType(Constant.PICTURE_STATUS);
			_emsTemplateDetal.setPid(pid);
			_emsTemplateDetal.setName("picture");
			_emsTemplateDetal.setValue(qaTemplate.getPictureUrl());
			emsTemplateMapper.addEmsTemplateDetal(_emsTemplateDetal);//保存扩展属性（图片）
			
			List<QuestionAndAnswer> questionAndAnswers = qaTemplate.getQuestions();
			for(QuestionAndAnswer questionAndAnswer : questionAndAnswers)
			{
				EmsTemplateDetal emsTemplateDetal = new EmsTemplateDetal();
				emsTemplateDetal.setId(Constant.getUUID());
				emsTemplateDetal.setType(Constant.QUESTION_STATUS);
				emsTemplateDetal.setPid(pid);
				emsTemplateDetal.setName("question");
				emsTemplateDetal.setValue(questionAndAnswer.getQuestion().getId());
				emsTemplateMapper.addEmsTemplateDetal(emsTemplateDetal);//保存扩展属性（问题）
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return EmsUtil.getJsonResult(Constant.RESULT_SUCCESS, "SUCCESS");
	}

	public String addPublicityTemplate(PublicityTemplate publicityTemplate) {
		try {
			EmsTemplate emsTemplate = new EmsTemplate();
			emsTemplate.setContext(publicityTemplate.getConText());
			String pid = Constant.getUUID();
			emsTemplate.setId(pid);
			emsTemplate.setType(Constant.COMMODITY_STATUS);
			emsTemplateMapper.addEmsTemplate(emsTemplate);//保存模板

			EmsTemplateDetal _emsTemplateDetal = new EmsTemplateDetal();
			_emsTemplateDetal.setId(Constant.getUUID());
			_emsTemplateDetal.setType(Constant.PICTURE_STATUS);
			_emsTemplateDetal.setPid(pid);
			_emsTemplateDetal.setName("picture");
			_emsTemplateDetal.setValue(publicityTemplate.getPictureUrl());
			emsTemplateMapper.addEmsTemplateDetal(_emsTemplateDetal);//保存扩展属性（图片）
			
			List<Commodity> commoditys = publicityTemplate.getCommoditys();
			for(Commodity commodity : commoditys)
			{				
				EmsTemplateDetal emsTemplateDetal = new EmsTemplateDetal();
				emsTemplateDetal.setId(Constant.getUUID());
				emsTemplateDetal.setType(Constant.COMMODITY_STATUS);
				emsTemplateDetal.setPid(pid);
				emsTemplateDetal.setName("commodity");
				emsTemplateDetal.setValue(commodity.getId());
				emsTemplateMapper.addEmsTemplateDetal(emsTemplateDetal);//保存扩展属性（商品）
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return EmsUtil.getJsonResult(Constant.RESULT_SUCCESS, "SUCCESS");
	}

	public String addGeneralTemplate(GeneralTemplate generalTemplate) {
		try {
			EmsTemplate emsTemplate = new EmsTemplate();
			emsTemplate.setContext(generalTemplate.getConText());
			String pid = Constant.getUUID();
			emsTemplate.setId(pid);
			emsTemplate.setType(Constant.GENERAL_STATUS);
			emsTemplateMapper.addEmsTemplate(emsTemplate);//保存模板

			EmsTemplateDetal _emsTemplateDetal = new EmsTemplateDetal();
			_emsTemplateDetal.setId(Constant.getUUID());
			_emsTemplateDetal.setType(Constant.PICTURE_STATUS);
			_emsTemplateDetal.setPid(pid);
			_emsTemplateDetal.setName("picture");
			_emsTemplateDetal.setValue(generalTemplate.getPictureUrl());
			emsTemplateMapper.addEmsTemplateDetal(_emsTemplateDetal);//保存扩展属性（图片）
						
			EmsTemplateDetal emsTemplateDetal = new EmsTemplateDetal();
			emsTemplateDetal.setId(Constant.getUUID());
			emsTemplateDetal.setType(Constant.COMMODITY_STATUS);
			emsTemplateDetal.setPid(pid);
			emsTemplateDetal.setName("general");
			emsTemplateDetal.setValue(generalTemplate.getText());//保存扩展属性（内容）
			
			emsTemplateMapper.addEmsTemplateDetal(emsTemplateDetal);
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return "SUCCESS";
	}

}
