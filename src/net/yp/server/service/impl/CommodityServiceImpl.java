package net.yp.server.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import net.yp.server.dao.CommodityMapper;
import net.yp.server.model.Commodity;
import net.yp.server.service.CommodityService;
import net.yp.server.util.EmsUtil;

public class CommodityServiceImpl implements CommodityService {

	@Autowired
	private CommodityMapper commodityMapper;
	private static  Logger logger=Logger.getLogger(CommodityServiceImpl.class);

	public String addCommodity(Commodity commodity) {
		String status = "SUCCESS";
		String result = "SUCCESS";
		try {
			commodityMapper.addCommodity(commodity);
		} catch (Exception e) {
			status = "FAILED";
			result = e.getMessage();
			logger.info(result);
			e.printStackTrace();
		}
		return EmsUtil.getJsonResult(status, result);
	}

	public String editCommodity(Commodity commodity) {
		String status = "SUCCESS";
		String result = "SUCCESS";
		try {
			commodityMapper.editCommodity(commodity);
		} catch (Exception e) {
			status = "FAILED";
			result = e.getMessage();
			logger.info(result);
			e.printStackTrace();
		}
		return EmsUtil.getJsonResult(status, result);
	}

	public String delCommodity(String id) {
		String status = "SUCCESS";
		String result = "SUCCESS";
		try {
			commodityMapper.delCommodity(id);
		} catch (Exception e) {
			status = "FAILED";
			result = e.getMessage();
			logger.info(result);
			e.printStackTrace();
		}
		return EmsUtil.getJsonResult(status, result);
	}

	public List<Commodity> queryCommodity(Map<String, Object> params) {
		return commodityMapper.queryCommodity(params);
	}

}
