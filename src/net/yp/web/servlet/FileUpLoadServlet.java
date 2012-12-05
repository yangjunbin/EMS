package net.yp.web.servlet;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.yp.server.model.UserMsg;
import net.yp.server.service.UserService;
import net.yp.server.util.Constant;
import net.yp.server.util.Context;
import net.yp.server.util.EmsUtil;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author Eric
 * 文件上传
 */
public class FileUpLoadServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserService userService = (UserService)Context.getApplicationContext().getBean("userService");
	private Logger logger = Logger.getLogger(FileUpLoadServlet.class.getClass());
    private String result = "";
    private String status = "";
    
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
        request.setCharacterEncoding ("UTF-8");
        response.setContentType ("text/html;charset=UTF-8");
        response.setCharacterEncoding ("UTF-8");
        result = "SUCCESS";
        status = Constant.RESULT_SUCCESS;
        DiskFileItemFactory factory = new DiskFileItemFactory ();
        ServletFileUpload upload = new ServletFileUpload (factory);
        upload.setHeaderEncoding ("UTF-8");
        
        try
        {
            List fileItems = upload.parseRequest (request);
            for (int i = 0; i < fileItems.size (); i++)
            {
                FileItem item = (FileItem) fileItems.get (i);
                if (item.isFormField ())
                {
                    String name = item.getFieldName();
                    String value = item.getString();
                }
                else
                {
                	 if(item.getSize()>1024*1024)
                     {
                     	result="文件不能超过1024KB";
                     	status=Constant.RESULT_FAILED;
                     	break;
                     }
                	save(item.getInputStream());
                }
            }
        }
        catch (FileUploadException e)
        {
            result = e.getCause ().getMessage ();
            e.printStackTrace ();
        }
        catch (Exception e)
        {
            result = e.getLocalizedMessage ();
            e.printStackTrace ();
        }
        response.getWriter ().print (EmsUtil.getJsonResult(status, result));
        response.getWriter ().flush ();
        response.getWriter ().close ();
	}

    private void save(InputStream inputStream) throws InvalidFormatException, IOException{
        Workbook workbook = WorkbookFactory.create (inputStream);

        try
        {
            List <UserMsg> userMsgs = parseMateDataType (workbook.getSheetAt (0));
            if(userMsgs!=null)
            {
            	result = userService.addUserMsgs(userMsgs);
            }
        }
        catch (Exception e)
        {
            result = e.getLocalizedMessage ();
        	status=Constant.RESULT_FAILED;
            logger.info ("联系人文件上传", e);
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	this.doPost(request, response);
    }
     
    private List <UserMsg> parseMateDataType (Sheet sheetAt)
    {
        if (sheetAt == null)
            return null;

        List <UserMsg> dims = new ArrayList <UserMsg> ();
        UserMsg dim = null;
        Cell cell = null;
        for (int k = 1; k <= sheetAt.getLastRowNum (); k++)
        {
            if (sheetAt.getRow (k) == null)
                continue;

            if (isEmptyRow (sheetAt.getRow (k)))
                continue;

            dim = new UserMsg ();
            
            int rowNum = sheetAt.getRow (k).getLastCellNum ();
            if(rowNum < 2){
                result = "Excel文件格式不正确,小于2个列,请下载模板";
            	status=Constant.RESULT_FAILED;
            	return null;
            }else{
                cell = sheetAt.getRow (k).getCell (0);
                if (cell != null)
                    cell.setCellType (Cell.CELL_TYPE_STRING);
                dim.setName ((cell == null) ? "" : cell.toString ().trim ());
    
                cell = sheetAt.getRow (k).getCell (1);
                if (cell != null)
                    cell.setCellType (Cell.CELL_TYPE_STRING);
                dim.setPhoneNumber ((cell == null) ? "" : cell.toString ().trim ());
                
                dim.setUuid(Constant.getUUID());
                
                dims.add (dim);
            }
        }

        return dims;
    }
    
    /**
     * 判断是否是空行.
     * 
     * @param row
     * @return true表示为空行
     */
    private static boolean isEmptyRow (Row row)
    {
        boolean empty = true;
        for (int i = 0; i < row.getLastCellNum (); i++)
        {
            if (!StringUtils.isBlank ((row.getCell (i) == null) ? null : row.getCell (i).toString ()))
                empty = false;
        }
        return empty;
    }
}

