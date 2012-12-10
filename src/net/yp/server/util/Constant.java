package net.yp.server.util;

import java.util.UUID;

/**
 * 资源对象
 * @author mac
 *
 */
public class Constant {
	/**
	 * 登陆冻结上限次数
	 */
	public final static int LOGIN_USER_FREEZE_ERROR_COUNT = 5;
	
	/**
	 * 登陆用户冻结状态
	 */
	public final static int LOGIN_USER_FREEZE_STATUS = 2;
	
	/**
	 * 登陆用户正常状态
	 */
	public final static int LOGIN_USER_NORMAL_STATUS = 1;
	
	/**
	 * 未分组ID
	 */
	public final static int UNGROUPED_ID = 0;

	/**
	 * 返回成功状态
	 */
	public final static String RESULT_SUCCESS = "SUCCESS";
	
	/**
	 * 返回失败状态
	 */
	public final static String RESULT_FAILED = "FAILED";
	
	/**
	 * 问题类型
	 */
	public final static String QUESTION_STATUS = "1";
	
	/**
	 * 照片类型
	 */
	public final static String PICTURE_STATUS = "2";
	
	/**
	 * 商品类型
	 */
	public final static String COMMODITY_STATUS = "3";
	
	/**
	 * 一般类型
	 */
	public final static String GENERAL_STATUS = "4";

	/**
	 * 获得UUID
	 * @return
	 */
	public static String getUUID()
	{
		return UUID.randomUUID().toString();
	}
}
