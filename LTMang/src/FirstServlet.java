import java.io.IOException;  
import java.io.PrintWriter;  
  

import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
@WebServlet("/first")
public class FirstServlet extends HttpServlet {  
	public void doGet(HttpServletRequest req,HttpServletResponse res) 
        throws ServletException, IOException {  
  
	res.setContentType("text/html");  
    PrintWriter out = res.getWriter();  
          
    //String n=request.getParameter("username");  
    //String p=request.getParameter("userpass");  
      
    out.print("First server");
          
    out.close();  
    } 
}