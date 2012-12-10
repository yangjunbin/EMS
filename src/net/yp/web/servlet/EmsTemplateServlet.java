package net.yp.web.servlet;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.yp.server.model.Commodity;
import net.yp.server.model.GeneralTemplate;
import net.yp.server.model.PublicityTemplate;
import net.yp.server.model.QaTemplate;
import net.yp.server.model.Question;
import net.yp.server.model.QuestionAndAnswer;
import net.yp.server.service.CommodityService;
import net.yp.server.service.EmsTemplateService;
import net.yp.server.service.impl.EmsTemplateServiceImpl;
import net.yp.server.util.Constant;
import net.yp.server.util.Context;
import net.yp.server.util.EmsUtil;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;


public class EmsTemplateServlet extends HttpServlet {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EmsTemplateService emsTemplateService = (EmsTemplateService)Context.getApplicationContext().getBean("emsTemplateService");
	
	private CommodityService commodityService = (CommodityService)Context.getApplicationContext().getBean("commodityService");

	private static  Logger logger=Logger.getLogger(EmsTemplateServiceImpl.class);

	/**
	 * Constructor of the object.
	 */
	public EmsTemplateServlet() {
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
		String emsMsgId = request.getParameter("emsMsgId");
        String result = "SUCCESS";
        String status = Constant.RESULT_SUCCESS;
		String type = request.getParameter("type");
        DiskFileItemFactory factory = new DiskFileItemFactory ();
        ServletFileUpload upload = new ServletFileUpload (factory);
        upload.setHeaderEncoding ("UTF-8");
		if ("addQa".equals(type)) {//新增问答模板
            try {
				List fileItems = upload.parseRequest (request);
				QaTemplate qaTemplate = new QaTemplate();
	            for (int i = 0; i < fileItems.size (); i++)
	            {
	                FileItem item = (FileItem) fileItems.get (i);
	                if (item.isFormField ())
	                {
	                    String name = item.getFieldName();
	                    String value = item.getString();
	                    if("conText".equals(name))
	                    {
	                    	qaTemplate.setConText(value);
	                    }
	                    else if("questionIds".equals(name))
	                    {
	                    	String[] ids = value.split(",");
	                    	 List<QuestionAndAnswer> questions = new ArrayList<QuestionAndAnswer>();
	                    	for(String id : ids)
	                    	{
	                    		QuestionAndAnswer questionAndAnswer = new QuestionAndAnswer();
	                    		Question question = new Question();
	                    		question.setId(Integer.parseInt(id));
	                    		questionAndAnswer.setQuestion(question);
	                    		questions.add(questionAndAnswer);
	                    	}
	                    	qaTemplate.setQuestions(questions);
	                    }
	                }
	                else
	                {
	                	 if(item.getSize()>100*1024)
	                     {
	                     	result="图片不能超过100KB";
	                     	status=Constant.RESULT_FAILED;
	                     	break;
	                     }
	         			BufferedImage image = ImageIO.read(item.getInputStream());
	         			String filePath = EmsUtil.getPropertiesForName("imagePath")+Constant.getUUID()+"jpg";
	        		    File outputFile = new File(filePath);
	        		    ImageIO.write(image,"jpg",outputFile);
	        		    qaTemplate.setPictureUrl(filePath);
	                }
	            }
	            result = emsTemplateService.addQaTemplate(qaTemplate);
			} catch (FileUploadException e) {
				status = "FAILED";
				result = e.getMessage();
				logger.info(result);
				e.printStackTrace();
			}
//
//			JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(msg);
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("questions", QuestionAndAnswer.class);
//			QaTemplate qaTemplate = (QaTemplate)JSONObject.toBean(jsonObject,QaTemplate.class,map);
//			InputStream is = new ByteArrayInputStream(qaTemplate.getPictureSource().getBytes());
//			BufferedImage image = ImageIO.read(is);
//			String filePath = EmsUtil.getPropertiesForName("imagePath")+qaTemplate.getPictureName();
//		    File outputFile = new File(filePath);
//			ImageIO.write(image, qaTmplate.getPictureType(), outputFile);//将文件写入磁盘
//			qaTemplate.setPictureUrl(filePath);
			
		}
		else if("addPublicity".equals(type))//新增宣传模板
		{
			try {
				List fileItems = upload.parseRequest (request);
				PublicityTemplate publicityTemplate = new PublicityTemplate();
				
	            for (int i = 0; i < fileItems.size (); i++)
	            {
	                FileItem item = (FileItem) fileItems.get (i);
	                if (item.isFormField ())
	                {
	                    String name = item.getFieldName();
	                    String value = item.getString();
	                    if("context".equals(name))
	                    {
	                    	publicityTemplate.setConText(value);
	                    }
	                    else if("commodityIds".equals(name))
	                    {
	                    	String[] ids = value.split(",");
	                    	List<Commodity> commoditys = new ArrayList<Commodity>();
	                    	for(String id : ids)
	                    	{
	                    		Commodity commodity = new Commodity();
	                    		commodity.setId(Integer.parseInt(id));
	                    		commoditys.add(commodity);
	                    	}
	                    	publicityTemplate.setCommoditys(commoditys);
	                    }
	                }
	                else
	                {
	                	 if(item.getSize()>100*1024)
	                     {
	                     	result="图片不能超过100KB";
	                     	status=Constant.RESULT_FAILED;
	                     	break;
	                     }
	         			BufferedImage image = ImageIO.read(item.getInputStream());
	         			String filePath = EmsUtil.getPropertiesForName("imagePath")+Constant.getUUID()+"jpg";
	        		    File outputFile = new File(filePath);
	        		    ImageIO.write(image,"jpg",outputFile);
	        		    publicityTemplate.setPictureUrl(filePath);
	                }
	                
	            }
	            result = emsTemplateService.addPublicityTemplate(publicityTemplate);
			} catch (FileUploadException e) {
				status = "FAILED";
				result = e.getMessage();
				logger.info(result);
				e.printStackTrace();
			}
		}
		else if("addGeneral".equals(type))//新增空模板
		{
			try {
				List fileItems = upload.parseRequest (request);
				GeneralTemplate generalTemplate = new GeneralTemplate();
				
	            for (int i = 0; i < fileItems.size (); i++)
	            {
	                FileItem item = (FileItem) fileItems.get (i);
	                if (item.isFormField ())
	                {
	                    String name = item.getFieldName();
	                    String value = item.getString();
	                    if("context".equals(name))
	                    {
	                    	generalTemplate.setConText(value);
	                    }
	                    else if("text".equals(name))
	                    {
	                    	generalTemplate.setText(value);
	                    }
	                }
	                else
	                {
	                	 if(item.getSize()>100*1024)
	                     {
	                     	result="图片不能超过100KB";
	                     	status=Constant.RESULT_FAILED;
	                     	break;
	                     }
	         			BufferedImage image = ImageIO.read(item.getInputStream());
	         			String filePath = EmsUtil.getPropertiesForName("imagePath")+Constant.getUUID()+"jpg";
	        		    File outputFile = new File(filePath);
	        		    ImageIO.write(image,"jpg",outputFile);
	        		    generalTemplate.setPictureUrl(filePath);
	                }
	                
	            }
	            result = emsTemplateService.addGeneralTemplate(generalTemplate);
			} catch (FileUploadException e) {
				status = "FAILED";
				result = e.getMessage();
				logger.info(result);
				e.printStackTrace();
			}
		}
		else if("addCommodity".equals(type))//新增商品
		{
			  try {
					List fileItems = upload.parseRequest (request);
					Commodity commodity = new Commodity();
		            for (int i = 0; i < fileItems.size (); i++)
		            {
		                FileItem item = (FileItem) fileItems.get (i);
		                if (item.isFormField ())
		                {
		                    String name = item.getFieldName();
		                    String value = item.getString();
		                    if("name".equals(name))
		                    {
		                    	commodity.setName(value);
		                    }
		                    else if("costPrice".equals(name))
		                    {
		                    	commodity.setCostPrice(value);
		                    }
		                    else if("currentPrice".equals(name))
		                    {
		                    	commodity.setCurrentPrice(value);
		                    }
		                    else if("context".equals(name))
		                    {
		                    	commodity.setContext(value);
		                    }
		                }
		                else
		                {
		                	 if(item.getSize()>100*1024)
		                     {
		                     	result="图片不能超过100KB";
		                     	status=Constant.RESULT_FAILED;
		                     	break;
		                     }
		         			BufferedImage image = ImageIO.read(item.getInputStream());
		         			String filePath = EmsUtil.getPropertiesForName("imagePath")+Constant.getUUID()+"jpg";
		        		    File outputFile = new File(filePath);
		        		    ImageIO.write(image,"jpg",outputFile);
		        		    commodity.setFilePath(filePath);
		                }
		            }
		            commodityService.addCommodity(commodity);
		            result = JSONObject.fromObject(commodity).toString();

				} catch (FileUploadException e) {
					status = "FAILED";
					result = e.getMessage();
					logger.info(result);
					e.printStackTrace();
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
