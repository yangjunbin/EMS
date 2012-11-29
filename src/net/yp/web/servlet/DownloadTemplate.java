package net.yp.web.servlet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadTemplate extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DownloadTemplate() {
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

        request.setCharacterEncoding ("UTF-8");
        response.setContentType ("text/html;charset=UTF-8");
        response.setCharacterEncoding ("UTF-8");
        String filename = request.getParameter("filename");  
        String filepath = request.getRealPath("/template");  
        File file = new File( filepath+"/"+filename );  
        FileInputStream fis = new FileInputStream(file);  
        response.addHeader("Content-Disposition","attachment; filename=" + filename );  
        ServletOutputStream out = response.getOutputStream();  
        response.setBufferSize(32768);  
        int bufSize = response.getBufferSize();  
        byte[] buffer = new byte[bufSize];  
        BufferedInputStream bis = new BufferedInputStream(fis,bufSize);  
  
        int bytes;  
        while ((bytes = bis.read(buffer, 0, bufSize)) >= 0)  
            out.write(buffer, 0, bytes);  
        bis.close();  
        fis.close();  
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
