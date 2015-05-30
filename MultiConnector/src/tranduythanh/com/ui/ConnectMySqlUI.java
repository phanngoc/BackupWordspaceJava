package tranduythanh.com.ui;

import java.sql.ResultSet;
import java.util.ArrayList;

import tranduythanh.com.connector.CMySqlConnector;
import tranduythanh.com.model.Lophoc;
import tranduythanh.com.model.Sinhvien;

public class ConnectMySqlUI extends AbstractConnectUI{

	private static final long serialVersionUID = 1L;
	public ConnectMySqlUI(String title)
	{
		super(title);
		CMySqlConnector con=new CMySqlConnector();
		con.getConnect("localhost", "moodle", "root", "hoilamgi");
		ResultSet rs= con.execQuery("select * from mdl_user");
		try
		{
			while(rs.next())
			{
				System.out.println(rs.getInt(1) +" - "+rs.getString(8));
			}
		}
		catch(Exception ex)
		{

		}
	}
	@Override
	public void addControl() {
		// TODO Auto-generated method stub
		super.addControl();
	}

	@Override
	public void doActionControl(Object o) {
		// TODO Auto-generated method stub

	}
	@Override
	public void doOwnerWindowFeature() {
		// TODO Auto-generated method stub
		super.doOwnerWindowFeature();
	}
	@Override
	public ArrayList<Lophoc> getListLop() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Sinhvien> getListSinhvienByIdLop(String malop) {
		// TODO Auto-generated method stub
		return null;
	}

}
