package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Vacxin;
import model.bo.CheckLoginBO;

/**
 * Servlet implementation class CheckUpdateServlet
 */
@WebServlet("/CheckUpdateServlet")
public class CheckUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		checkLoginBO.updateVacxin(vacxin);
		
		response.sendRedirect("CheckLoginServlet?mavacxin="+mavacxin);
	}

}
