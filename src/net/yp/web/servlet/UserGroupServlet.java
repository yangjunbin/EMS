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

import net.yp.server.model.UserGroup;
import net.yp.server.model.UserGroupRel;
import net.yp.server.service.UserService;
import net.yp.server.util.Constant;
import net.yp.server.util.Context;
import net.yp.server.util.EmsUtil;

public class UserGroupServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserService userService = (UserService) Context
			.getApplicationContext().getBean("userService");

	/**
	 * Constructor of the object.
	 */
	public UserGroupServlet() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String type = request.getParameter("type");
		String userId = request.getParameter("userId");
		String name = request.getParameter("name");
		String result = "";
		if ("query".equals(type)) {
			String page = request.getParameter("page");
			String pageSize = request.getParameter("pageSize");
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("page", page==null?0:Integer.parseInt(page)*Integer.parseInt(pageSize));
			params.put("pageSize", pageSize==null?5:Integer.parseInt(pageSize));
			List<UserGroup> userGroups = userService.queryUserGroup(params);
			long size = userService.queryUserGroupCount(params);
			request.setAttribute("size", size);
			request.setAttribute("userGroups", userGroups);
			request.getRequestDispatcher("/userGroup.jsp").forward(request,
					response);
		} else if ("add".equals(type)) {
			UserGroup userGroup = new UserGroup();
			userGroup.setUuid(Constant.getUUID());
			userGroup.setName(name);
			List<UserGroup> userGroups = new ArrayList<UserGroup>();
			userGroups.add(userGroup);
			result = userService.addUserGroup(userGroups);
		} else if ("edit".equals(type)) {
			UserGroup userGroup = new UserGroup();
			userGroup.setId(userId);
			userGroup.setName(name);
			result = userService.editUserGroup(userGroup);
		} else if ("del".equals(type)) {
			UserGroup userGroup = new UserGroup();
			userGroup.setId(userId);
			userGroup.setName(name);
			List<String> ids = new ArrayList<String>();
			ids.add(userId);
			result = userService.delUserGroup(ids);
		}
		PrintWriter out = response.getWriter();
		out.print(EmsUtil.getJsonResult(Constant.RESULT_SUCCESS, result));
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
