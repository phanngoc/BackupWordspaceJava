package tranduythanh.com.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

import tranduythanh.com.connector.CMsAccessConnector;
import tranduythanh.com.model.Lophoc;
import tranduythanh.com.model.Sinhvien;

public class ConnectMsAccessUI extends AbstractConnectUI
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConnectMsAccessUI(String title)
	{
		super(title);
		m_connector=new CMsAccessConnector();
		
	}

	@Override
	public void addControl() {
		// TODO Auto-generated method stub
		super.addControl();
		updateLopList();
	}

	@Override
	public void doActionControl(Object o) {
		// TODO Auto-generated method stub
		super.doActionControl(o);
		tblData.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				int row=tblData.rowAtPoint(e.getPoint());
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	@Override
	public void doOwnerWindowFeature() {
		super.doOwnerWindowFeature();
	}

	@Override
	public ArrayList<Lophoc> getListLop() {
		// TODO Auto-generated method stub
		ArrayList<Lophoc>listLop=new ArrayList<Lophoc>();
		m_connector.getConnect("", "database\\quanlysinhvien.accdb", "", "");
		ResultSet rs= m_connector.execQuery("select * from lophoc");
		try
		{
			while(rs.next())
			{
				Lophoc lh=new Lophoc(rs.getString(1), rs.getString(2), rs.getInt(3));
				listLop.add(lh);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return listLop;
	}

	@Override
	public ArrayList<Sinhvien> getListSinhvienByIdLop(String malop) {
		// TODO Auto-generated method stub
		ArrayList<Sinhvien>listSv=new ArrayList<Sinhvien>();
		m_connector.getConnect("", "database\\quanlysinhvien.accdb", "", "");
		ResultSet rs= m_connector.execQuery("select * from sinhvien where malop='"+malop+"'");
		try
		{
			while(rs.next())
			{
				Sinhvien sv=new Sinhvien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5));
				listSv.add(sv);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return listSv;
	}
	
}
