package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Account;
import model.bean.Language;
import model.bean.Lietke;
import model.bean.LietkeTien;
import model.bean.Vacxin;

public class CheckLoginDAO extends BaseDAO {
	private Connection connection;
	BaseDAO base = new BaseDAO();
	public boolean isValidAccount(String userName, String password) {
		// 4 buoc de xu ly DB: Load driver, tao connection, cc thong tin
		// tao doi tuong statement, thuc thi truy van (executeQuery)
		connection = base.getConnection();
		String url = "jdbc:mysql://127.0.0.1:3306/thmang"; // trong đó
															// ://127.0.0.1:3306/test
															// là tên và đường
															// dẫn tới CSDL.
		// String Url = "jdbc:odbc:" + dataBaseName; dùng cái này nếu là
		// SQLServer
		try {
			Statement statement = connection.createStatement();

			String sql = "select username,password from user where username='"
					+ userName + "' and password='" + password + "'";

			// Thực thi câu lệnh SQL trả về đối tượng ResultSet.
			ResultSet rs = statement.executeQuery(sql);

			// Duyệt trên kết quả trả về.
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp.
				System.out.print("da vao");
				return true;
			}
			base.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public void insertVacxin(Vacxin vacxin)
	{
		connection = base.getConnection();
		// create a Statement from the connection
		Statement statement;
		try {
			statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO vacxin " + "VALUES ('"+vacxin.getMavacxin()+"', "
					+ "'"+vacxin.getTenvacxin()+"', "+vacxin.getSoluongmui()+",'"+
					vacxin.getMota()+"',"+vacxin.getGiavacxin()+",'"+vacxin.getTenhangsanxuat()+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		base.closeConnection();
	}
	public void updateVacxin(Vacxin vacxin)
	{
		connection = base.getConnection();
		// create a Statement from the connection
		System.out.print("Co vao day");
		Statement statement;
		try {
			statement = connection.createStatement();
			statement.executeUpdate("UPDATE vacxin " +
	                   "SET TenVacxin='"+vacxin.getTenvacxin()+"',"
	                   		+ "SoLuongMui = "+vacxin.getSoluongmui()+",MoTa = '"+vacxin.getMota()+"' ,GiaVacxin = "+vacxin.getGiavacxin()+",TenHangSX='"+
	                   		vacxin.getTenhangsanxuat()+"' WHERE MaVacxin = '"+vacxin.getMavacxin()+"'");
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// insert the data
		base.closeConnection();
	}
	
	public Vacxin getVacxinByMa(String mavacxin)
	{
		connection = base.getConnection();
		try {
			Statement statement = connection.createStatement();

			String sql = "select * from vacxin where MaVacxin='"+mavacxin+"';";

			// Thực thi câu lệnh SQL trả về đối tượng ResultSet.
			ResultSet rs = statement.executeQuery(sql);

			// Duyệt trên kết quả trả về.
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp.
			   Vacxin vacxin = new Vacxin();
			   vacxin.setMavacxin(rs.getString("MaVacxin"));
			   vacxin.setTenvacxin(rs.getString("TenVacxin"));
			   vacxin.setSoluongmui(rs.getInt("SoLuongMui"));
			   vacxin.setMota(rs.getString("MoTa"));
			   vacxin.setGiavacxin(rs.getInt("GiaVacxin"));
			   vacxin.setTenhangsanxuat(rs.getString("TenHangSX"));
			   return vacxin;
			}
			base.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<Lietke> getAllLietKe(String makhachhang)
	{
		connection = base.getConnection();
		ArrayList<Lietke> lietkes = new ArrayList<Lietke>();
		try {
			String tenkhachhang = "";
			
			Statement statement = connection.createStatement();
			String sql = "select * from khachhang where MaKH='"+makhachhang+"';";
			ResultSet rs = statement.executeQuery(sql);


			while (rs.next()) {
				tenkhachhang = rs.getString("HoTenKH");
			}
			
			Statement statement1 = connection.createStatement();
			String sql1 = "select * from lichsutiemphong where MaKH='"+makhachhang+"';";
			ResultSet rs1 = statement1.executeQuery(sql1);


			while (rs1.next()) {
				String mavacxin = rs1.getString("MaVacxin");
				Statement statement2 = connection.createStatement();
				String sql2 = "select * from vacxin where MaVacxin='"+mavacxin+"';";
				ResultSet rs2 = statement2.executeQuery(sql2);
				while(rs2.next())
				{
					String tenvacxin = rs2.getString("TenVacxin");
					int tongsomui = rs2.getInt("SoLuongMui");
					Statement statement3 = connection.createStatement();
					String sql3 = "select * from phongbenh where MaVacxin='"+mavacxin+"';";
					ResultSet rs3 = statement3.executeQuery(sql3);
					while(rs3.next())
					{
						String mabenh = rs3.getString("MaBenh");
						Statement statement4 = connection.createStatement();
						String sql4 = "select * from benh where MaBenh='"+mabenh+"';";
						ResultSet rs4 = statement4.executeQuery(sql4);
						while(rs4.next())
						{
							String tenbenh = rs4.getString("TenBenh");
							Lietke lietke = new Lietke(makhachhang,tenkhachhang,tenbenh,mavacxin,tenvacxin,tongsomui);
							lietkes.add(lietke);
						}
					}
				}
			}
			
			base.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lietkes;
	}
	public ArrayList<LietkeTien> getAllLietkeTien()
	{
		connection = base.getConnection();
		ArrayList<LietkeTien> lietketiens = new ArrayList<LietkeTien>();
		try {
			
			Statement statement = connection.createStatement();
			String sql = "select * from khachhang;";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String makhachhang = rs.getString("MaKH");
				String tenkhachhang = rs.getString("HoTenKH");
				String diachikhachhang = rs.getString("DiaChiKH");
				Statement statement1 = connection.createStatement();
				String sql1 = "select * from lichsutiemphong where MaKH='"+makhachhang+"';";
				ResultSet rs1 = statement1.executeQuery(sql1);
				
				int tongtien = 0;
				while (rs1.next()) {
				  String mavacxin = rs1.getString("MaVacxin");
				  Statement statement2 = connection.createStatement();
					String sql2 = "select * from vacxin where MaVacxin='"+mavacxin+"';";
					ResultSet rs2 = statement2.executeQuery(sql2);
					
					while (rs2.next()) {
					  int giavacxin = rs2.getInt("GiaVacxin");
					  tongtien += giavacxin;
					}
				}
				LietkeTien lietketien = new LietkeTien(makhachhang, tenkhachhang, diachikhachhang, tongtien);
				lietketiens.add(lietketien);
			}
			
			
			base.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<LietkeTien> lietkemoi = new ArrayList<LietkeTien>();
		for (int i=0;i<lietketiens.size();i++)
		{
			LietkeTien lietketien = lietketiens.get(i);
			int check = 0;
			for (int k=0;k<lietkemoi.size();k++)
			{
				if(lietkemoi.get(k).getMakhachhang().equals(lietketien.getMakhachhang()))
				{
					int tongtem = lietketiens.get(i).getTongtien()+lietkemoi.get(k).getTongtien();
					lietkemoi.get(k).setTongtien(tongtem);
					check = 1;
				}
			}
			if(check == 0)
			{
				lietkemoi.add(lietketien);
			}
		}
		for (int i = 0 ;i < lietkemoi.size()-1;i++)
		{
			for(int j=i+1;j<lietkemoi.size();j++)
			{
				if(lietkemoi.get(i).getTongtien()>lietkemoi.get(j).getTongtien())
				{
					LietkeTien temp = lietkemoi.get(i);
					lietkemoi.set(i,lietkemoi.get(j));
					lietkemoi.set(j, temp);
				}
			}
		}
		
		return lietkemoi;
	}
	
}
