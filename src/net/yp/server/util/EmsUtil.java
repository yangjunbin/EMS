package net.yp.server.util;

import java.io.IOException;
import java.util.Properties;

public class EmsUtil {
	
	
	/**
	 * 构造JSON返回串
	 * @param status 状态值
	 * @param context 备注
	 * @return
	 */
	public static String getJsonResult(String status,String context)
	{
		return "{status:\""+status+"\",context:\""+context+"\"}";
	}
	
	public static String getPropertiesForName(String name)
	{
        Properties prop = new Properties ();
        try
        {
            prop.load (Thread.currentThread ().getContextClassLoader ().getResourceAsStream ("resource/properties"));
        }
        catch (IOException e)
        {
            e.printStackTrace ();
        }
        return prop.getProperty (name);
	}
}
