package com.bom;

import javax.servlet.*;
import javax.servlet.http.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.common.Employee;
import com.common.HibernateUtil;
import com.common.Stock;

import java.io.*;

public class HelloWorldServlet extends HttpServlet {
	private static SessionFactory factory; 
  public void service(HttpServletRequest req, 
                      HttpServletResponse res)
       throws IOException
  {
    // Must set the content type first
    res.setContentType("text/html");
    // Now obtain a PrintWriter to insert HTML into
    PrintWriter out = res.getWriter();

    out.println("<html><head><title>" +
                "Hello World!</title></head>");
    out.println("<body><h1>Hello World!</h1></body></html>");
    
    System.out.println("Maven + Hibernate + MySQL");
    /*Session session = HibernateUtil.getSessionFactory().openSession();

    session.beginTransaction();
    Stock stock = new Stock();

    stock.setStockCode("47151");
    stock.setStockName("GENM1");  

    session.save(stock);
    session.getTransaction().commit();
    */
    try{
        factory = new AnnotationConfiguration().
                  configure().
                  //addPackage("com.xyz") //add package if used.
                  addAnnotatedClass(Employee.class).
                  buildSessionFactory();
     }catch (Throwable ex) { 
        System.err.println("Failed to create sessionFactory object." + ex);
        throw new ExceptionInInitializerError(ex); 
     }
     ManageEmployee ME = new ManageEmployee();
  }
}
