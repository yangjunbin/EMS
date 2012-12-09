package net.yp.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.yp.server.model.EmsMsg;
import net.yp.server.model.LoginUser;
import net.yp.server.service.LoginService;
import net.yp.server.util.Constant;
import net.yp.server.util.Context;
import net.yp.server.util.EmsUtil;

public class LoginUserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LoginService loginService = (LoginService)Context.getApplicationContext().getBean("loginService");

	/**
	 * Constructor of the object.
	 */
	public LoginUserServlet() {
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
		String type = request.getParameter("type");
		String pwd = request.getParameter("pwd");
		String user = request.getParameter("user");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String uuid = request.getParameter("uuid");
		String id = request.getParameter("id");
		
		String page = request.getParameter("page");
		String pageSize = request.getParameter("pageSize");
		
		LoginUser loginUser = new LoginUser();
		loginUser.setUuid(uuid);
		loginUser.setName(name);
		loginUser.setPwd(pwd);
		loginUser.setSex(sex);
		loginUser.setUser(user);
		if(id!=null)
		{
			loginUser.setId(Integer.parseInt(id));
		}
		
		if("query".equals(type))
		{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("page", page==null?0:Integer.parseInt(page)*Integer.parseInt(pageSize));
			params.put("pageSize", pageSize==null?5:Integer.parseInt(pageSize));
			List<LoginUser> loginUsers = loginService.queryLoginUsers(params);
			long size = loginService.queryLoginUserCount(params);
			request.setAttribute("size", size);
			request.setAttribute("loginUsers", loginUsers);
			request.getRequestDispatcher("/loginUser.jsp").forward(request, response);
		}
		else if("add".equals(type))
		{
			String msg = "";
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("user", user);		
			long count =  loginService.queryLoginUserCount(params);
			if(count>0)
			{
				msg = "用户已存在";
			}
			else
			{
				loginUser.setUuid(Constant.getUUID());
				loginService.addLoginUser(loginUser);
			}
			request.setAttribute("msg", msg);
	        queryUser(request, response, page, pageSize);

		}
		else if("edit".equals(type))
		{
			loginService.editLoginUser(loginUser);
	        queryUser(request, response, page, pageSize);
		}
		else if("del".equals(type))
		{
			loginService.delLoginUser(id);
	        queryUser(request, response, page, pageSize);
		}
		else
		{
	        queryUser(request, response, page, pageSize);
		}
	}

	private void queryUser(HttpServletRequest request,HttpServletResponse response,String page,String pageSize) throws ServletException, IOException
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("page", page==null?0:Integer.parseInt(page)*Integer.parseInt(pageSize));
		params.put("pageSize", pageSize==null?5:Integer.parseInt(pageSize));
		List<LoginUser> loginUsers = loginService.queryLoginUsers(params);
		long size = loginService.queryLoginUserCount(params);
		request.setAttribute("size", size);
		request.setAttribute("loginUsers", loginUsers);
		request.getRequestDispatcher("/loginUser.jsp").forward(request, response);
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
