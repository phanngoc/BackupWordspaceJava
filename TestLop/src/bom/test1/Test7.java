package bom.test1;

import java.sql.*;
import javax.sql.*;
public class Test7 {
public static void main(String args[]) throws ClassNotFoundException,SQLException {
		System.out.println("Ket noi CSDL");
		try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String url = "jdbc:odbc:sss";
		Connection conn = DriverManager.getConnection(url,"phann123","123456");
		Statement stmt = conn.createStatement();
		//String sql0 = "INSERT INTO KhachHang(Id,TenKH,DiaChi,Luong) VALUES('8','Nguyen C','HCM','900')";
		//stmt.executeUpdate(sql0);
		//Cap nhat du lieu
		String sql2="UPDATE Khachhang SET Luong=Luong+luong*0.2";
		int n=stmt.executeUpdate(sql2);
		if (n < 1) System.out.println("Khong co ban ghi nao duong cap nhat");
		else System.out.println("Co "+ n +" ban ghi duong cap nhat");
		String sql="SELECT Id,TenKH,DiaChi,Luong FROM KhachHang";
		ResultSet rs=stmt.executeQuery(sql);
			while (rs.next())
			{ 
				int id=rs.getInt("Id");
				double l=rs.getDouble("Luong");
				String s=rs.getString("TenKH");
				String d=rs.getString("DiaChi");
				System.out.println("ID=" +id +" " + s+ " " + d + " Luong=" + l) ;
			}
			} catch(SQLException e) {
				System.out.println("Loi thao tac CSDL"+e.getMessage());
			}
	}
}
