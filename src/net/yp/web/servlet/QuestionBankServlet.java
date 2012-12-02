package net.yp.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.yp.server.model.Answer;
import net.yp.server.model.Question;
import net.yp.server.model.QuestionAndAnswer;
import net.yp.server.service.QuestionBankService;
import net.yp.server.util.Context;

public class QuestionBankServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private QuestionBankService questionBankService = (QuestionBankService) Context
			.getApplicationContext().getBean("questionBankService");

	/**
	 * Constructor of the object.
	 */
	public QuestionBankServlet() {
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

		String msg = request.getParameter("msg");
		String type = request.getParameter("type");
		String questionId = request.getParameter("questionId");
		String answerId = request.getParameter("answerId");
		String result = "";
		if ("query".equals(type)) {
			String page = request.getParameter("page");
			String pageSize = request.getParameter("pageSize");
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("page", page==null?0:Integer.parseInt(page)*Integer.parseInt(pageSize));
			params.put("pageSize", pageSize==null?5:Integer.parseInt(pageSize));
			List<QuestionAndAnswer> questionAndAnswers = questionBankService
					.queryQuestionAndAnswer(params);
			long size = questionBankService.queryQuestionCount();
			request.setAttribute("questionAndAnswers", questionAndAnswers);
			request.setAttribute("size", size);
			request.getRequestDispatcher("/question.jsp").forward(request, response);
		} else if ("add".equals(type)) {
			JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(msg);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("answers", Answer.class);
			QuestionAndAnswer questionAndAnswer = (QuestionAndAnswer) jsonObject
					.toBean(jsonObject, QuestionAndAnswer.class, map);
			result = questionBankService
					.addQuestionAndAnswer(questionAndAnswer);
		} else if ("edit".equals(type)) {
			JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(msg);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("answers", Answer.class);
			QuestionAndAnswer questionAndAnswer = (QuestionAndAnswer) jsonObject
					.toBean(jsonObject, QuestionAndAnswer.class, map);
			result = questionBankService.editQuestionAndAnswer(questionAndAnswer);
		} else if ("delQuestion".equals(type)) {
			String[] ids = questionId.split(",");
			result = questionBankService.delQuestion(ids);
		} else if ("delAnswer".equals(type)) {
			String[] ids = answerId.split(",");
			result = questionBankService.delAnswer(ids);
		}
		PrintWriter out = response.getWriter();
		out.print(result);
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

	public static void main(String[] args) {
//		QuestionAndAnswer questionAndAnswer = new QuestionAndAnswer();
//		Question question = new Question();
//		Answer answer = new Answer();
//		List<Answer> answers = new ArrayList<Answer>();
//		question.setCreateTime(new Date());
//		question.setId("1");
//		question.setName("喜爱的音乐");
//		question.setType("2");
//		answer.setContext("啊啊也哟");
//		answer.setId("1");
//		answer.setQid("1");
//		answers.add(answer);
//		answer = new Answer();
//		answer.setContext("滴滴哒");
//		answer.setId("2");
//		answer.setQid("1");
//		answers.add(answer);
//		questionAndAnswer.setQuestion(question);
//		questionAndAnswer.setAnswers(answers);
//		JSONObject json = JSONObject.fromObject(questionAndAnswer);
//		System.out.println(json.toString());
//
//		JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(json);
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("answers", Answer.class);
//		QuestionAndAnswer questionAndAnswer2 = (QuestionAndAnswer) jsonObject
//				.toBean(jsonObject, QuestionAndAnswer.class, map);
//		
//		JSONArray json2 = JSONArray.fromObject(answers);
//		System.out.println(json2.toString());
//		JSONObject jsonObject2 = (JSONObject) JSONSerializer.toJSON(json2.toString());
//		List<Answer> aa = (List<Answer>)jsonObject2.toBean(jsonObject2,Answer.class);
		System.out.println("aaa".split(",")[0]);
	}

}
