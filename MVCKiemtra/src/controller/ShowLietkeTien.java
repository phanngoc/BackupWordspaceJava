package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Lietke;
import model.bean.LietkeTien;
import model.bo.CheckLoginBO;

/**
 * Servlet implementation class ShowLietkeTien
 */
@WebServlet("/ShowLietkeTien")
public class ShowLietkeTien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowLietkeTien() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CheckLoginBO checkLoginBO = new CheckLoginBO();
		ArrayList<LietkeTien> lietkes = checkLoginBO.getAllLietkeTien();
		request.setAttribute("lietkes", lietkes);
		RequestDispatcher rd = request.getRequestDispatcher("showlietketien.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
