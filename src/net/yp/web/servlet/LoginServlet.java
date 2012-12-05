package net.yp.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.yp.server.model.LoginUser;
import net.yp.server.service.LoginService;
import net.yp.server.util.Constant;
import net.yp.server.util.Context;

/**
 * @author Eric
 *
 */
public class LoginServlet extends HttpServlet {

	private LoginService loginService = (LoginService)Context.getApplicationContext().getBean("loginService");

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("user", user);
		params.put("pwd", pwd);
		LoginUser loginUser = loginService.queryLoginUser(params);
		if(loginUser==null)
		{
	        PrintWriter out = response.getWriter();
	        out.print("errorCount=-1");  
	        out.flush();  
	        out.close();  
		}
		else
		{
			Date loginTime = loginUser.getLoginTime();
			loginService.editLoginUserLoginTime(loginUser.getUuid());
			if(loginUser.getStatus()==Constant.LOGIN_USER_FREEZE_STATUS&&new Date().getTime()-loginTime.getTime() < 1000*60*10)
			{
		        PrintWriter out = response.getWriter();
		        out.print("errorCount=-2");  
		        out.flush();  
		        out.close();  
			}
			else
			{
				int errorCount = loginUser.getErrorCount();
				if(loginUser.getStatus()==Constant.LOGIN_USER_FREEZE_STATUS&&new Date().getTime()-loginTime.getTime() > 1000*60*10)
				{
					loginUser.setStatus(Constant.LOGIN_USER_NORMAL_STATUS);
					loginService.editLoginUserStatus(loginUser);
				}
				if(errorCount!=0&&new Date().getTime()-loginTime.getTime() > 1000*60*10)
				{
					loginUser.setErrorCount(0);
					loginService.editLoginUserErrorCount(loginUser);
				}
				if(pwd.equals(loginUser.getPwd()))
				{
					request.getSession().setAttribute("status", "success");
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				}
				else
				{
					errorCount++;
					if(errorCount >= Constant.LOGIN_USER_FREEZE_ERROR_COUNT)
					{
						loginUser.setErrorCount(0);
						loginUser.setStatus(Constant.LOGIN_USER_FREEZE_STATUS);
						loginService.editLoginUserErrorCount(loginUser);
						loginService.editLoginUserStatus(loginUser);
					}
					else
					{
						loginUser.setErrorCount(errorCount);
						loginService.editLoginUserErrorCount(loginUser);
					}
			        PrintWriter out = response.getWriter();
			        out.print("errorCount="+errorCount);  
			        out.flush();  
			        out.close();  
				}
			}
		}
		
	}
	
	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
