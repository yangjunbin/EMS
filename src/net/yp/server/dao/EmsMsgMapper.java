package net.yp.server.dao;

import java.util.List;
import java.util.Map;

import net.yp.server.model.EmsMsg;

public interface EmsMsgMapper {
	
	/**
	 * 新增网信信息
	 * @param emsMsg
	 * @return
	 */
	Integer addEmsMsg(EmsMsg emsMsg);
	
	/**
	 * 修改网信信息
	 * @param emsMsg
	 * @return
	 */
	Integer editEmsMsg(EmsMsg emsMsg);
	
	/**
	 * 修改网信信息状态
	 * @param emsMsg
	 * @return
	 */
	Integer editEmsMsgStatus(EmsMsg emsMsg);
	
	/**
	 * 根据ID修改模板ID
	 * @param emsMsg
	 * @return
	 */
	Integer editEmsMsgTempId(EmsMsg emsMsg);
	
	/**
	 * 删除网信信息
	 * @param id
	 * @return
	 */
	Integer delEmsMsg(int id);
 
	/**
	 * 查询网信信息
	 * @param params
	 * @return
	 */
	List<EmsMsg> queryEmsMsg(Map<String,Object> params);
	
	/**
	 * 查询网信信息记录数
	 * @param params
	 * @return
	 */
	Long queryEmsMsgCount(Map<String,Object> params);
	
	/**
	 * 查询序列
	 * @return
	 */
	Integer queryEmsMsglastSeqId();
}
