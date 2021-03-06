package net.yp.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.yp.server.model.UserGroupRel;
import net.yp.server.service.UserService;
import net.yp.server.util.Constant;
import net.yp.server.util.Context;
import net.yp.server.util.EmsUtil;

public class UserGroupRelServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService = (UserService)Context.getApplicationContext().getBean("userService");

	
	/**
	 * Constructor of the object.
	 */
	public UserGroupRelServlet() {
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
		String groupId = request.getParameter("groupId");
		String userId = request.getParameter("userId");
		String result = "";
		if("add".equals(type))
		{
			String[] userIds = userId.split(",");
			List<UserGroupRel>userGroupRels = new ArrayList<UserGroupRel>();
			int count = userIds.length;
			for(int i=0;i<count;i++)
			{
				UserGroupRel userGroupRel = new UserGroupRel();
				userGroupRel.setMsgId(Integer.parseInt(userIds[i]));
				userGroupRel.setGroupId(Integer.parseInt(groupId));
			}
			result = userService.addUserGroupRel(userGroupRels);
		}
		else if("del".equals(type))
		{
			String[] userIds = userId.split(",");
			List<UserGroupRel>userGroupRels = new ArrayList<UserGroupRel>();
			int count = userIds.length;
			for(int i=0;i<count;i++)
			{
				UserGroupRel userGroupRel = new UserGroupRel();
				userGroupRel.setMsgId(Integer.parseInt(userIds[i]));
				userGroupRel.setGroupId(Integer.parseInt(groupId));
			}
			result = userService.delUserGroupRel(userGroupRels);
		}
        PrintWriter out = response.getWriter();
        out.print(EmsUtil.getJsonResult(Constant.RESULT_SUCCESS, result));  
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
