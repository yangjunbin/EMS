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
	 * @param id
	 * @return
	 */
	Integer delCommodity(int id);
	
	/**
	 * 查询商品
	 * @param params
	 * @return
	 */
	List<Commodity> queryCommodity(Map<String,Object> params);
	
	/**
	 * 根据商品ID查询商品
	 * @param id
	 * @return
	 */
	Commodity queryCommodityById(int id);
	
	/**
	 * 查询序列
	 * @return
	 */
	Integer queryCommoditySeqId();
}
