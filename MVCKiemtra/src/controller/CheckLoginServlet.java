package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;

import model.bean.Account;
import model.bean.Language;
import model.bean.Vacxin;
import model.bo.CheckLoginBO;


/**
 * Servlet implementation class CheckLoginServlet
 */
public class CheckLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CheckLoginBO checkLoginBO = new CheckLoginBO();
		String mavacxin = request.getParameter("mavacxin");
		Vacxin vacxin = checkLoginBO.getVacxinByMa(mavacxin);
		request.setAttribute("vacxin", vacxin);
		RequestDispatcher rd = request.getRequestDispatcher("showupdate.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		String mavacxin = request.getParameter("mavacxin");
		String tenvacxin = request.getParameter("tenvacxin");
		String soluongmui = request.getParameter("soluongmui");
		String mota = request.getParameter("mota");
		String giavacxin = request.getParameter("giavacxin");
		String tenhangsanxuat = request.getParameter("tenhangsanxuat");
		Vacxin vacxin = new Vacxin();
		vacxin.setMavacxin(mavacxin);
		vacxin.setTenvacxin(tenvacxin);
		vacxin.setSoluongmui(Integer.parseInt(soluongmui));
		vacxin.setMota(mota);
		vacxin.setGiavacxin(Integer.parseInt(giavacxin));
		vacxin.setTenhangsanxuat(tenhangsanxuat);
		
		CheckLoginBO checkLoginBO = new CheckLoginBO();
		checkLoginBO.insertVacxin(vacxin);
		
		request.setAttribute("vacxin", vacxin);
		RequestDispatcher rd = request.getRequestDispatcher("showupdate.jsp");
		rd.forward(request, response);
				
	}

}
