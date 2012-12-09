package net.yp.server.service;

import java.util.List;
import java.util.Map;

import net.yp.server.model.EmsMsg;

public interface EmsMsgService {
	
	/**
	 * 新增网信信息
	 * @param emsMsg
	 * @return
	 */
	String addEmsMsg(EmsMsg emsMsg);
	
	/**
	 * 修改网信信息
	 * @param emsMsg
	 * @return
	 */
	String editEmsMsg(EmsMsg emsMsg);
	
	/**
	 * 修改网信信息状态
	 * @param emsMsg
	 * @return
	 */
	String editEmsMsgStatus(EmsMsg emsMsg);
	
	/**
	 * 删除网信信息
	 * @param uuid
	 * @return
	 */
	String delEmsMsg(String uuid);
 
	/**
	 * 查询网信信息
	 * @param params
	 * @return
	 */
	List<EmsMsg> queryEmsMsg(Map<String,Object> params);
	
	/**
	 * 查询网信详细信息
	 * @param emsMsg
	 * @return
	 */
	EmsMsg queryEmsMsgDetal(EmsMsg emsMsg);
	
	/**
	 * 查询网信信息记录数
	 * @param params
	 * @return
	 */
	Long queryEmsMsgCount(Map<String,Object> params);
}
