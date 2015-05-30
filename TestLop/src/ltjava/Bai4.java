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

public class Bai4 {

 Connection conn;
 public static void main(String[] args)
 {
	Bai4 bai4 = new Bai4();
	
	bai4.process();
	bai4.process1();
	//bai2.update();
	//bai2.like("A");
 }
 public void connect()
 {
			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				String url = "jdbc:odbc:NHANVIEN";
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
	this.connect();
	FileInputStream fstream;
	try {
		 fstream = new FileInputStream("D:\\study\\wordspace\\TestLop\\src\\ltjava\\data1.txt");
	
		 BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		 String strLine;
		 int dong = 0;
		 Statement stmt = conn.createStatement();
		 while ((strLine = br.readLine()) != null)   {
		   dong++;
		   String[] input = strLine.split(",");
		   String maso = input[0];
		   String hoten = input[1];
		   String ngaythang = input[2];
		   String diachiemail = input[3];
		   
		   System.out.println (maso+"|"+hoten+"|"+ngaythang);
		   
				
		    String sql = "INSERT INTO NHANVIEN(MaNhanVien,TenNhanVien,NgaySinh,DiachiEmail) " +
                   "VALUES ('"+maso+"', '"+hoten+"','"+ngaythang+"','"+diachiemail+"')";
			System.out.println("Gia tri sql:"+sql);
			stmt.executeUpdate(sql);
			
			/*String query = "INSERT INTO HOCVIEN(MaHocVien,TenHocVien,NgaySinh,GioiTinh,DiemThi) " +
			                   "VALUES (?,?,?,?,?)";
			PreparedStatement ps  = conn.prepareStatement(query);
			//java.sql.Date ee = new java.sql.Date(currentTime.getTime());
			ps.setString(1,maso);
			ps.setString(2,hoten);
			ps.setTimestamp(3,new java.sql.Timestamp(currentTime.getTime()));
			ps.setString(4,gioitinh);
			ps.setFloat(5,Float.parseFloat(diemso));
			ps.executeUpdate();
			*/
		 }
		 fstream.close();
		 br.close();
		 stmt.close();
		 conn.close();
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
 public void process1()
 {
	 this.connect();
	 FileInputStream fstream;
		try {
			 fstream = new FileInputStream("D:\\study\\wordspace\\TestLop\\src\\ltjava\\data2.txt");
		
			 BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			 String strLine;
			 int dong = 0;
			 Statement stmt = conn.createStatement();
			 while ((strLine = br.readLine()) != null)   {
			   dong++;
			   String[] input = strLine.split(",");
			   String maso = input[0];
			   String luong = input[1];
			   
			   
			   System.out.println (maso+"|"+luong);
			   
			  
				PreparedStatement preparedStmt;
				try {
					Statement statement = conn.createStatement();
					String getluong = "SELECT ThuNhap FROM NHANVIEN WHERE MaNhanVien='"+maso+"'";
					ResultSet resluong = statement.executeQuery(getluong);
					
					int flag = 0;
					int luonghientai = 0;
					int luongtruocdo = 0;
					String error = "";
					while (resluong.next())
					{
						 flag = 1;
						 luongtruocdo = resluong.getInt("ThuNhap");
					}
					if(flag==0) 
					{
						error = "Dong "+dong+":"+"Ma nhan vien khong ton tai";
						flag = 2;
					}
					else{
						flag = 0;
					}
					try{
						 luonghientai = Integer.parseInt(luong);	
					}
					catch(NumberFormatException e)
					{
						if(flag!=2)
						{
							if(error.equals(""))
							{
								error+= "Dong "+dong+":"+"Thu nhap khong phai la so\n";
							}
							
						}
						else
						{
							error+= ",Thu nhap khong phai la so\n";
						}
						flag = 3;
					}
					if(flag==2)
					{
						this.write(error+"\n");
					}
					else
					{
						this.write(error);
					}
					if(flag != 0) continue;
					
					statement.close();
					int luongmoi = luonghientai + luongtruocdo;
					String query = "UPDATE NHANVIEN SET ThuNhap = ? WHERE MaNhanVien = ?";
					preparedStmt = conn.prepareStatement(query);
					preparedStmt.setInt(1,luongmoi);
					preparedStmt.setString(2,maso);
					preparedStmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			    
				
				/*String query = "INSERT INTO HOCVIEN(MaHocVien,TenHocVien,NgaySinh,GioiTinh,DiemThi) " +
				                   "VALUES (?,?,?,?,?)";
				PreparedStatement ps  = conn.prepareStatement(query);
				//java.sql.Date ee = new java.sql.Date(currentTime.getTime());
				ps.setString(1,maso);
				ps.setString(2,hoten);
				ps.setTimestamp(3,new java.sql.Timestamp(currentTime.getTime()));
				ps.setString(4,gioitinh);
				ps.setFloat(5,Float.parseFloat(diemso));
				ps.executeUpdate();
				*/
			 }
			 fstream.close();
			 br.close();
			 stmt.close();
			 conn.close();
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
 
 public void write(String content)
 {
	 try {
			File file = new File("D:\\study\\wordspace\\TestLop\\src\\ltjava\\error2.txt");
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
 }
}
