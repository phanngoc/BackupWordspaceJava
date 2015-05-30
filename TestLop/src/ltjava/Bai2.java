package ltjava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class Bai2 {

 Connection conn;
 public static void main(String[] args)
 {
	Bai2 bai2 = new Bai2();
	bai2.connect();
	//bai2.process();
	bai2.update();
	bai2.like("A");
 }
 public void connect()
 {
			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				String url = "jdbc:odbc:HOCVIEN";
				conn=DriverManager.getConnection(url,"root","root");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(""+e.getMessage());
			}
 }
 public void process()
 {
	FileInputStream fstream;
	try {
		 fstream = new FileInputStream("D:\\study\\wordspace\\TestLop\\src\\ltjava\\input.txt");
	
		 BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		 String strLine;
		 int dong = 0;
		 while ((strLine = br.readLine()) != null)   {
		   dong++;
		   String maso = strLine.substring(0,10);
		   String hoten = strLine.substring(10,60).trim();
		   String ngaythang = strLine.substring(60,70);
		   String gioitinh = strLine.substring(70,73);
		   String diemso = strLine.substring(73,77);
		   System.out.println (ngaythang+"|"+gioitinh+"|"+diemso);
		   Calendar cal = Calendar.getInstance();  
		   java.text.SimpleDateFormat sdf = 
				     new java.text.SimpleDateFormat("dd/MM/yyyy");

		   java.util.Date currentTime = null;
			try {
				currentTime = sdf.parse(ngaythang);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				write("Dong "+dong+": Sai dinh danh ngay sinh");
				continue;
			}	
		    /*String sql = "INSERT INTO HOCVIEN(MaHocVien,TenHocVien,GioiTinh,DiemThi) " +
                   "VALUES ('"+maso+"', '"+hoten+"','"+gioitinh+"',"+diemso+")";
			System.out.println("Gia tri sql:"+sql);
			stmt.executeUpdate(sql);
			*/
			String query = "INSERT INTO HOCVIEN(MaHocVien,TenHocVien,NgaySinh,GioiTinh,DiemThi) " +
			                   "VALUES (?,?,?,?,?)";
			PreparedStatement ps  = conn.prepareStatement(query);
			//java.sql.Date ee = new java.sql.Date(currentTime.getTime());
			ps.setString(1,maso);
			ps.setString(2,hoten);
			ps.setTimestamp(3,new java.sql.Timestamp(currentTime.getTime()));
			ps.setString(4,gioitinh);
			ps.setFloat(5,Float.parseFloat(diemso));
			ps.executeUpdate();
			
		 }
		 fstream.close();
		 br.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
 public void like(String stringlike)
 {
	 String query = "SELECT * FROM HOCVIEN WHERE TenHocVien LIKE '%"+stringlike+"%'";
	 PreparedStatement ps = null;
	try {
		ps = conn.prepareStatement(query);
		System.out.println("ps"+stringlike);
		
		
		ResultSet rs = ps.executeQuery();
	    if (rs==null) return;
	      while(rs.next()){
	         //Retrieve by column name
	         
	         String first = rs.getString("TenHocVien");
	         String last = rs.getString("GioiTinh");

	         //Display values
	         System.out.print(", First: " + first);
	         System.out.println(", Last: " + last);
	      }

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("e"+e.getMessage());
	}
	 //java.sql.Date ee = new java.sql.Date(currentTime.getTime());
		
 }
 public void update()
 {
	
	String query = "UPDATE HOCVIEN SET TenHocVien = ? WHERE MaHocVien = ?";
	PreparedStatement preparedStmt;
	try {
		preparedStmt = conn.prepareStatement(query);
		preparedStmt.setString(1, "Khong duoc nhe");
		preparedStmt.setString(2, "HV11223342");
		preparedStmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
 }
 public void write(String content)
 {
	 try {
			File file = new File("D:\\study\\wordspace\\TestLop\\src\\ltjava\\error.txt");
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content+"\n");
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
 }
}
