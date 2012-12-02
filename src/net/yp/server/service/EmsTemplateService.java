package net.yp.server.service;

import java.util.List;
import java.util.Map;

import net.yp.server.model.EmsTemplate;
import net.yp.server.model.EmsTemplateDetal;
import net.yp.server.model.GeneralTemplate;
import net.yp.server.model.PublicityTemplate;
import net.yp.server.model.QaTemplate;

public interface EmsTemplateService {
	
	/**
	 * 新增模板
	 * @param emsTemplate
	 * @return
	 */
	Integer addEmsTemplate(EmsTemplate emsTemplate);
	
	/**
	 * 新增模板属性
	 * @param emsTemplateDetal
	 * @return
	 */
	Integer addEmsTemplateDetal(EmsTemplateDetal emsTemplateDetal);
	
	/**
	 * 查询模板
	 * @param params
	 * @return
	 */
	List<EmsTemplate> queryEmsTemplate(Map<String,Object> params);
	
	/**
	 * 查询模板属性
	 * @param params
	 * @return
	 */
	List<EmsTemplateDetal> queryEmsTemplateDetal(Map<String,Object> params);
	
	/**
	 * 根据ID查询模板
	 * @param params
	 * @return
	 */
	EmsTemplate queryEmsTemplateById(Map<String,Object> params);
	
	/**
	 * 删除模板
	 * @param emsTemplate
	 * @return
	 */
	Integer delEmsTemplate(EmsTemplate emsTemplate);
	
	/**
	 * 删除模板属性
	 * @param emsTemplateDetal
	 * @return
	 */
	Integer delEmsTemplateDetal(EmsTemplateDetal emsTemplateDetal); 
	
	/**
	 * 保存问答模板
	 * @param qaTemplate
	 * @return
	 */
	String addQaTemplate(QaTemplate qaTemplate);
	
	/**
	 * 保存宣传模板
	 * @param publicityTemplate
	 * @return
	 */
	String addPublicityTemplate(PublicityTemplate publicityTemplate);
	
	/**
	 * 保存空模板
	 * @param generalTemplate
	 * @return
	 */
	String addGeneralTemplate(GeneralTemplate generalTemplate);
}
