

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;  
import javax.servlet.*;  

import java.io.*;  
@WebServlet("/demo")
public class DemoServlet extends HttpServlet{  
public void doGet(HttpServletRequest req,HttpServletResponse res)  
    throws ServletException,IOException  
    {  
    res.setContentType("text/html");//setting the content type  
    PrintWriter pw=res.getWriter();//get the stream to write the data  
    req.getRequestDispatcher("showform.jsp").include(req, res);    
    //writing html in the stream  
    pw.println("<html><body>");  
    pw.println("Welcome to servlet");  
    pw.println("</body></html>");  
      
    pw.close();//closing the stream  
}}  