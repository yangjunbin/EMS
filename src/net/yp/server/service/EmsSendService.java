package net.yp.server.service;

import java.util.List;
import java.util.Map;

import net.yp.server.model.EmsSend;

public interface EmsSendService {
	/**
	 * 新增发送信息
	 * @param emsSends
	 * @return
	 */
	String addEmsSend(List<EmsSend> emsSends);
	
	/**
	 * 查询发送信息
	 * @param params
	 * @return
	 */
	List<EmsSend> queryEmsSend(Map<String,Object> params);
	
	/**
	 * 查询发送信息记录数
	 * @param params
	 * @return
	 */
	long queryEmsSendCount(Map<String,Object> params);
}
