package net.yp.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.yp.server.model.UserMsg;
import net.yp.server.service.UserService;
import net.yp.server.util.Constant;
import net.yp.server.util.Context;
import net.yp.server.util.EmsUtil;

public class UserMsgServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserService userService = (UserService)Context.getApplicationContext().getBean("userService");

	/**
	 * Constructor of the object.
	 */
	public UserMsgServlet() {
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
		String status = Constant.RESULT_SUCCESS;
		String result = "";
		String type = request.getParameter("type");
		
		if("query".equals(type))
		{
			String id = request.getParameter("groupId");
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("id", id);
			String page = request.getParameter("page");
			String pageSize = request.getParameter("pageSize");
			params.put("page", page==null?0:Integer.parseInt(page)*Integer.parseInt(pageSize));
			params.put("pageSize", pageSize==null?5:Integer.parseInt(pageSize));
			List<UserMsg> userMsgs = userService.queryUserMsgByGroup(params);
			long size = userService.queryUserMsgByGroupCount(params);
			request.setAttribute("size", size);
			request.setAttribute("userMsgs", userMsgs);
			request.getRequestDispatcher("/userMsg.jsp").forward(request, response);
		}
		else if("add".equals(type))
		{
			List<UserMsg> userMsgs = new ArrayList<UserMsg>();
			UserMsg userMsg = new UserMsg();
			String phoneNumber = request.getParameter("phoneNumber");
			String name = request.getParameter("name");
			userMsg.setName(name);
			userMsg.setPhoneNumber(phoneNumber);
			userMsgs.add(userMsg);
			result = userService.addUserMsgs(userMsgs);
		}
		else if("edit".equals(type))
		{
			UserMsg userMsg = new UserMsg();
			String id = request.getParameter("id");
			if(id!=null)
			{
				String phoneNumber = request.getParameter("phoneNumber");
				userMsg.setId(Integer.parseInt(id));
				userMsg.setPhoneNumber(phoneNumber);
				result = userService.editUserMsg(userMsg);
			}
		}
		else if("del".equals(type))
		{
			List<Integer> userMsgs = new ArrayList<Integer>();
			String id = request.getParameter("id");
			if(id!=null)
			{
				userMsgs.add(Integer.parseInt(id));
				result = userService.delUserMsg(userMsgs);
			}
		}
		PrintWriter out = response.getWriter();
		out.print(EmsUtil.getJsonResult(status, result));
		out.flush();
		out.close();
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
