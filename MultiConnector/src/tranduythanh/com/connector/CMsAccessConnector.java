package tranduythanh.com.connector;

import java.sql.Connection;
import java.sql.DriverManager;

public class CMsAccessConnector extends CConnector 
{
	/**
	 * Hàm dùng để kết nối tới MS Access
	 * strDatabase: tên CSDL
	 * Trả về Connection
	 **/
	public Connection getConnect(String strServer,String strDatabase,String strUser,String strPwd)
	{
		try
		{
			String strConnect="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+strDatabase;
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			m_Connection= DriverManager.getConnection(strConnect);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return m_Connection;
	}
}
