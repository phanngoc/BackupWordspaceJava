package thimang;
import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Server {
	
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
	private static Connection connection = null;

	public void getConnection() {
		if (connection != null)
			return ;
		try {
			Class.forName("com.mysql.jdbc.Driver"); 

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		String url = "jdbc:mysql://127.0.0.1:3306/thimang"; 
		
		try {
			
			connection = DriverManager.getConnection(url, "root", "");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection = null;
	}
	
	Socket socket;
	public ThreadXuly(Socket s){
		this.socket=s;
	}
	public void run(){
		getConnection();
		int tong = 0;
		try{
			DataInputStream din = new DataInputStream(socket.getInputStream());
			String chuoi = din.readUTF();
			System.out.println("Ten vacxin nhan tu client la:"+chuoi);
			try {
				Statement statement = connection.createStatement();

				String sql = "select * from vacxin where TenVacxin='"+chuoi+"';";

				// Thực thi câu lệnh SQL trả về đối tượng ResultSet.
				ResultSet rs = statement.executeQuery(sql);
				
				// Duyệt trên kết quả trả về.
				while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp.
					tong += rs.getInt("SoLuongMui");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
			if(tong==0)
			{
				dout.writeUTF("Khong co loai vac xin nay");
			}
			else
			{
				dout.writeUTF("Tong so mui cua loai vac xin nay la:"+tong);
			}
			
			socket.close();
		}catch(IOException e){}
	}
}

