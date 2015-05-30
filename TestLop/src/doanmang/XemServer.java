package doanmang;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;




public class XemServer {
	public static void main(String [] args) throws IOException
	{
		
		ServerSocket server=new ServerSocket(2500);
		while (true){
			Socket socket=server.accept();
			(new ThreadXuly(socket)).start();
		}
		
	}
}
class ThreadXuly extends Thread{
	Socket socket;
	public ThreadXuly(Socket s){
		this.socket=s;
	}
	public void run(){
		{
			
			try {
			String ketqua_final = "";
			DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
			DataInputStream din = new DataInputStream(socket.getInputStream());
			String chuoi = din.readUTF();
			String[] chuoiquery = chuoi.split("\\|");
			
			Connection c = null;
		   
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite://E:/study/java/wordspace/TestLop/src/doanmang/Sinhvien.sqlite");
		      if(c != null)
		      {
		    	  System.out.println("Opened database successfully");
		    	  /*
			      Statement stmt = c.createStatement();
			      String sql = "INSERT INTO sinhvien (MSSV,fullname,khoithi,birthday,gender) " +
			                   "VALUES (2, 'Paul', 1, 'California', 1 );"; 
			      stmt.executeUpdate(sql);
			      */
		    	  Statement stmt = c.createStatement();
		          ResultSet rs = null;
		          System.out.print("chuoi query 1:"+chuoiquery[0]);
		          if(chuoiquery[1].equals("maso"))
				  {
					rs = stmt.executeQuery( "SELECT * FROM sinhvien WHERE MSSV LIKE '%"+chuoiquery[0]+"%' AND khoithi='"+chuoiquery[2]+"' AND truong="+chuoiquery[3]+";" );
					
				  }
		          else if(chuoiquery[1].equals("name"))
		          {
		        	  String query = "SELECT * FROM sinhvien WHERE fullname LIKE '%"+chuoiquery[0]+"%' AND khoithi='"+chuoiquery[2]+"' AND truong="+chuoiquery[3]+";";
		        	  System.out.println("Cau truy van la: "+query);
		        	  rs = stmt.executeQuery(query);	
		          }
		     
		          while ( rs.next() ) {
		        	 System.out.println("Lap ket qua server");
		             int id = rs.getInt("MSSV");
		             
		             String fullname = rs.getString("fullname");
		             int khoithi  = rs.getInt("khoithi");
		             String birthday = rs.getString("birthday");
		             int gender = rs.getInt("gender");
		             String quequan = rs.getString("quequan");
		             ketqua_final = ""+id+"|"+fullname+"|"+khoithi+"|"+birthday+"|"+gender+"|"+quequan+"|";
		             Statement stmt1 = c.createStatement();
		             ResultSet rs_diemso = stmt1.executeQuery( "SELECT * FROM diemso WHERE id_hocsinh = "+id );
		             while(rs_diemso.next())
		             {
		            	ketqua_final += rs_diemso.getFloat("diem")+"|"; 
		             }
		             ketqua_final = ketqua_final.substring(0, ketqua_final.length()-1);
		             dout.writeUTF(ketqua_final);
		          }
		          dout.writeUTF("finish");
		      }
		      else
		      {
		    	 System.out.print("chua duoc roi");  
		      }
		      
		    
			
			
			socket.close();
			} catch ( Exception e ) {
			      System.err.println( e.getClass().getName() + ":ne  " + e.getMessage() );
			      System.exit(0);
			}
	     }
	}
}
