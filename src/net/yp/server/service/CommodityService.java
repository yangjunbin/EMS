package net.yp.server.service;

import java.util.List;
import java.util.Map;

import net.yp.server.model.Commodity;

public interface CommodityService {
	
	/**
	 * 新增商品
	 * @param commodity
	 * @return
	 */
	String addCommodity(Commodity commodity);
	
	/**
	 * 修改商品
	 * @param commodity
	 * @return
	 */
	String editCommodity(Commodity commodity);
	
	/**
	 * 删除商品
	 * @param commodity
	 * @return
	 */
	String delCommodity(String id);
	
	/**
	 * 查询商品
	 * @param params
	 * @return
	 */
	List<Commodity> queryCommodity(Map<String,Object> params);
}
