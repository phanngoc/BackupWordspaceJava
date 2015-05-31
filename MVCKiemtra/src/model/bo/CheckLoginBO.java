package model.bo;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Account;
import model.bean.Language;
import model.bean.Lietke;
import model.bean.LietkeTien;
import model.bean.Vacxin;
import model.dao.CheckLoginDAO;

public class CheckLoginBO {

	CheckLoginDAO checkLoginDAO = new CheckLoginDAO();
	
	public boolean isValidAccount(String userName, String password) {
		if ("".equals(userName) || "".equals(password)) {
			return false;
		} else {
			return checkLoginDAO.isValidAccount(userName, password);
		}
	}
	public void insertVacxin(Vacxin vacxin)
	{
		checkLoginDAO.insertVacxin(vacxin);
	}
	public void updateVacxin(Vacxin vacxin)
	{
		checkLoginDAO.updateVacxin(vacxin);
	}
	public Vacxin getVacxinByMa(String ma)
	{
		return checkLoginDAO.getVacxinByMa(ma);
	}
	public ArrayList<Lietke> getAllLietke(String makhachhang)
	{
		return checkLoginDAO.getAllLietKe(makhachhang);
	}
	public ArrayList<LietkeTien> getAllLietkeTien()
	{
		return checkLoginDAO.getAllLietkeTien();
	}
}
