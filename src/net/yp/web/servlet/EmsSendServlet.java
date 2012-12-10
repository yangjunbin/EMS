package net.yp.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.yp.server.model.EmsSend;
import net.yp.server.service.EmsSendService;
import net.yp.server.util.Constant;
import net.yp.server.util.Context;

public class EmsSendServlet extends HttpServlet {

	private EmsSendService emsSendService = (EmsSendService)Context.getApplicationContext().getBean("emsSendService");
	/**
	 * Constructor of the object.
	 */
	public EmsSendServlet() {
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
		if("add".equals(type))
		{
			String sendText = request.getParameter("sendText");
			String phoneNumbers = request.getParameter("phoneNumbers");
			List<EmsSend> emsSends = new ArrayList<EmsSend>();
			String[] numbers = phoneNumbers.split(",");
			for (String number : numbers)
			{
				EmsSend emsSend = new EmsSend();
				emsSend.setSendText(sendText);
				emsSend.setPhoneNumber(number);
				emsSends.add(emsSend);
			}
			emsSendService.addEmsSend(emsSends);
		}
		else if("query".equals(type))
		{
			String page = request.getParameter("page");
			String pageSize = request.getParameter("pageSize");
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("page", page==null?0:Integer.parseInt(page)*Integer.parseInt(pageSize));
			params.put("pageSize", pageSize==null?5:Integer.parseInt(pageSize));
			List<EmsSend> emsSends = emsSendService.queryEmsSend(params);
			long size = emsSendService.queryEmsSendCount(params);
			request.setAttribute("size", size);
			request.setAttribute("emsSends", emsSends);
			request.getRequestDispatcher("/emsSend.jsp").forward(request, response);
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
