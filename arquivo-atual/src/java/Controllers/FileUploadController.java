/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

/**
 *
 * @author ice
 */

@WebServlet(urlPatterns = "/teste")
public class FileUploadController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String filePath = "/ice/NetBeansProjects/DCC-Lab-Web-192/arquivo-atual/web/docs";
        //process only if its multipart content
        HttpSession session = request.getSession(true);
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List fileItens = null;
        if(ServletFileUpload.isMultipartContent(request)){
            try {
                fileItens = upload.parseRequest(new ServletRequestContext(request));
                Iterator iterator = fileItens.iterator();                
                 while (iterator.hasNext()) {               	 
                     FileItem item = (FileItem) iterator.next();                    
                     if (!item.isFormField()) {                   	 
                         String fileName = "local.pdf";
                         String root = getServletContext().getRealPath("/");                         
                         File path = new File(root + "/uploads");                      
                         if (!path.exists()) {                    	 
                             boolean status = path.mkdirs();
                         } 
                         File uploadedFile = new File(path + "/" + fileName);                         
                         System.out.println(uploadedFile.getAbsolutePath());                        
                         item.write(uploadedFile);
                         session.setAttribute("file", "existe");
                     }                    
                 }
                
                
                /*
                for(FileItem item : fileItens){
                    if(!item.isFormField()){
                        String name = new File(item.getName()).getName();
                        item.write( new File(filePath + File.separator + name));
                    }
                }
                */
               //File uploaded successfully
               request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }          
          
        }else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
        }
     
        request.getRequestDispatcher("/upload_de_arquivo.jsp").forward(request, response);
      
    }

}
