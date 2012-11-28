package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.yp.server.model.LoginUser;
import net.yp.server.service.LoginService;
import net.yp.server.service.impl.LoginServiceImpl;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class ServiceTest
{

    LoginService service = null;
	private static  Logger logger=Logger.getLogger(ServiceTest.class);


    @Before
    public void init ()
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext (new String[]
        {"classpath:resource/service.spring.xml","classpath:resource/db.spring.xml"
        });
        service = (LoginService) context.getBean ("loginService");
    }

    @Test
    public void testQueryLoginUsers ()
    {
    	try {
        	Map<String,Object> params = new HashMap<String,Object>();
        	List<LoginUser> loginUsers = service.queryLoginUsers(params);
        	for(LoginUser loginUser : loginUsers)
        	{
        		System.out.println("name:"+loginUser.getName());
        		System.out.println("pwd:"+loginUser.getPwd());
        	}
		} catch (Exception e) {
			e.printStackTrace();
		}

    }
    
    @Test
    public void testQueryLoginUserCount()
    {
    	try {
    		Map<String,Object> params = new HashMap<String,Object>();
    		params.put("user", "test");
    		//params.put("pwd", "test");
    		Long count = service.queryLoginUserCount(params);
    		System.out.println("count:"+count);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static void main (String[] args)
    {
		System.out.println(UUID.randomUUID().toString());
    }
}
