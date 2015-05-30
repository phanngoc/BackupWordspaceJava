package tranduythanh.com.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CSqlServerConnector extends CConnector
{
	/**
	 * Hàm dùng để kết nối tới SQL Server 
	 * strDatabase: tên CSDL
	 * Trả về Connection
	 **/
	public Connection getConnect(String strServer,String strDatabase,String strUser,String strPwd)
	{
		try {  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionUrl = "jdbc:sqlserver://"+strServer+";" +
					"databaseName="+strDatabase+";user="+strUser+";password="+strPwd+";";
			System.out.println("Successful");
			m_Connection= DriverManager.getConnection(connectionUrl);
			System.out.println("Successful");
		} catch (SQLException e) {
			System.out.println("SQL Exception: "+ e.toString());
		} catch (ClassNotFoundException cE) {
			System.out.println("Class Not Found Exception: "+ cE.toString());
		}
		return m_Connection;
	}
}
