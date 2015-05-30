package tranduythanh.com.connector;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class CMySqlConnector  extends CConnector
{
	/**
	 * Hàm dùng để kết nối tới MySQL
	 * strDatabase: tên CSDL
	 * Trả về Connection
	 **/
	public Connection getConnect(String strServer,String strDatabase,String strUser,String strPwd)
	{
		String strConnect="jdbc:mysql://"+strServer+"/"+strDatabase;
		Properties pro=new Properties();
		pro.put("user", strUser);
		pro.put("password", strPwd);
		try
		{
			com.mysql.jdbc.Driver driver=new Driver();
			m_Connection=driver.connect(strConnect, pro);
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return m_Connection;
	}
	
}
