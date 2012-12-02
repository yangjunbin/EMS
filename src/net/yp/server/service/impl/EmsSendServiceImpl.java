package net.yp.server.service.impl;

import java.util.List;
import java.util.Map;

import net.yp.server.dao.EmsSendMapper;
import net.yp.server.model.EmsSend;
import net.yp.server.service.EmsSendService;
import net.yp.server.util.Constant;
import net.yp.server.util.EmsUtil;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class EmsSendServiceImpl implements EmsSendService {

	@Autowired
	private EmsSendMapper emsSendMapper;
	private static  Logger logger=Logger.getLogger(EmsSendServiceImpl.class);

	public String addEmsSend(List<EmsSend> emsSends) {
		String status = Constant.RESULT_SUCCESS;
		String result = "SUCCESS";
		try {
			for(EmsSend emsSend : emsSends)
			{
				emsSendMapper.addEmsSend(emsSend);
			}
		} catch (Exception e) {
			status = Constant.RESULT_FAILED;
			result = e.getMessage();
			logger.info(result);
			e.printStackTrace();
		}
		return EmsUtil.getJsonResult(status, result);
	}

	public List<EmsSend> queryEmsSend(Map<String, Object> params) {
		List<EmsSend> emsSends = null;
		try {
			emsSends = emsSendMapper.queryEmsSend(params);
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return emsSends;
	}

	public long queryEmsSendCount(Map<String, Object> params) {
		Long count = 0L;
		try {
			count = emsSendMapper.queryEmsSendCount(params);
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return count;
	}

}
