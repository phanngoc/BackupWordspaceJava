package com.bom;

import javax.servlet.*;
import javax.servlet.http.*;

import org.hibernate.Session;

import com.common.HibernateUtil;
import com.common.Stock;

import java.io.*;

public class HelloWorldServlet extends HttpServlet {
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
    Session session = HibernateUtil.getSessionFactory().openSession();

    session.beginTransaction();
    Stock stock = new Stock();

    stock.setStockCode("4715");
    stock.setStockName("GENM");

    session.save(stock);
    session.getTransaction().commit();

  }
}
