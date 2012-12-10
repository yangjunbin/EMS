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
import net.yp.server.service.EmsMsgService;
import net.yp.server.util.Constant;
import net.yp.server.util.Context;
import net.yp.server.util.EmsUtil;

public class EmsMsgServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EmsMsgService emsMsgService = (EmsMsgService)Context.getApplicationContext().getBean("emsMsgService");

	/**
	 * Constructor of the object.
	 */
	public EmsMsgServlet() {
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
		
		String result = "";
		String type = request.getParameter("type");
		String id = request.getParameter("id");
		String tid = request.getParameter("tid");
		String uid = request.getSession().getAttribute("uid").toString();
		String msg = request.getParameter("msg");
		String name = request.getParameter("name");
		String tempType = request.getParameter("tempType");
		if("query".equals(type))
		{
			String page = request.getParameter("page");
			String pageSize = request.getParameter("pageSize");
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("page", page==null?0:Integer.parseInt(page)*Integer.parseInt(pageSize));
			params.put("pageSize", pageSize==null?5:Integer.parseInt(pageSize));
			List<EmsMsg> emsMsgs = emsMsgService.queryEmsMsg(params);
			long size = emsMsgService.queryEmsMsgCount(params);
			request.setAttribute("size", size);
			request.setAttribute("emsMsgs", emsMsgs);
			request.getRequestDispatcher("/emsMsg.jsp").forward(request, response);
		}
		else if("add".equals(type))
		{
			EmsMsg emsMsg = new EmsMsg();
			emsMsg.setUid(Integer.parseInt(uid));
			emsMsg.setMsg(msg);
			emsMsg.setName(name);
			emsMsg.setStatus("1");
			result = emsMsgService.addEmsMsg(emsMsg);
			long emsMsgId = emsMsgService.queryEmsMsglastSeqId();
			request.setAttribute("emsMsgId", emsMsgId);
			String url = "";
			if(Constant.QUESTION_STATUS.equals(tempType))//问答
			{
				url = "nms/qa.jsp";
			}
			else if(Constant.COMMODITY_STATUS.equals(tempType))//宣传
			{
				url = "nms/publicity.jsp";
			}
			else if(Constant.GENERAL_STATUS.equals(tempType))//一般
			{
				url = "nms/normal.jsp";
			}
			request.getRequestDispatcher(url).forward(request, response);
		}
		else if("edit".equals(type))
		{
			EmsMsg emsMsg = new EmsMsg();
			emsMsg.setId(Integer.parseInt(id));
			emsMsg.setTid(Integer.parseInt(tid));
			emsMsg.setUid(Integer.parseInt(uid));
			emsMsg.setMsg(msg);
			result = emsMsgService.editEmsMsg(emsMsg);
		}
		else if("del".equals(type))
		{
			result = emsMsgService.delEmsMsg(Integer.parseInt(id));
		}
		else if("editStatus".equals(type))
		{
			String status = request.getParameter("status");
			EmsMsg emsMsg = new EmsMsg();
			emsMsg.setId(Integer.parseInt(id));
			emsMsg.setStatus(status);
			result = emsMsgService.editEmsMsgStatus(emsMsg);
		}
		PrintWriter out = response.getWriter();
		out.print(result);
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
