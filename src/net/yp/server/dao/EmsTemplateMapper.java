package net.yp.server.dao;

import java.util.List;
import java.util.Map;

import net.yp.server.model.EmsTemplate;
import net.yp.server.model.EmsTemplateDetal;

public interface EmsTemplateMapper {
	
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
	 * 查询序列
	 * @return
	 */
	Integer queryEmsTemplastSeqId();
	
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
}
