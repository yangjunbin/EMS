package net.yp.server.dao;

import java.util.List;
import java.util.Map;

import net.yp.server.model.Commodity;

public interface CommodityMapper {
	
	/**
	 * 新增商品
	 * @param commodity
	 * @return
	 */
	Integer addCommodity(Commodity commodity);
	
	/**
	 * 修改商品
	 * @param commodity
	 * @return
	 */
	Integer editCommodity(Commodity commodity);
	
	/**
	 * 删除商品
	 * @param uuid
	 * @return
	 */
	Integer delCommodity(String uuid);
	
	/**
	 * 查询商品
	 * @param params
	 * @return
	 */
	List<Commodity> queryCommodity(Map<String,Object> params);
	
	/**
	 * 根据商品ID查询商品
	 * @param uuid
	 * @return
	 */
	Commodity queryCommodityByUUId(String uuid);
}
