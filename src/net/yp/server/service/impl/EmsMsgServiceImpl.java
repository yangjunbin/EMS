package net.yp.server.service.impl;

import java.util.List;
import java.util.Map;

import net.yp.server.dao.EmsMsgMapper;
import net.yp.server.model.EmsMsg;
import net.yp.server.service.EmsMsgService;
import net.yp.server.util.Constant;
import net.yp.server.util.EmsUtil;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class EmsMsgServiceImpl implements EmsMsgService {

	@Autowired
	private EmsMsgMapper emsMsgMapper;
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

	public String delEmsMsg(String id) {
		String status = Constant.RESULT_SUCCESS;
		String result = "SUCCESS";
		try {
			emsMsgMapper.delEmsMsg(id);
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

}
