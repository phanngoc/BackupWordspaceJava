package tranduythanh.com.ui;

import java.sql.ResultSet;
import java.util.ArrayList;

import tranduythanh.com.connector.CSqlServerConnector;
import tranduythanh.com.model.Lophoc;
import tranduythanh.com.model.Sinhvien;

public class ConnectSqlServerUI extends AbstractConnectUI{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ConnectSqlServerUI(String title)
	{
		CSqlServerConnector con=new CSqlServerConnector();
		con.getConnect("vietnam", "dbexample", "sa", "hoilamgi");
		ResultSet rs=con.execQuery("select * from tblCustomer");
		try
		{
			while(rs.next())
			{
				System.out.println(rs.getString(2)+" - "+ rs.getString(4));
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
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
