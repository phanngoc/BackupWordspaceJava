package tranduythanh.com.connector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class CConnector
{
	protected Connection m_Connection=null;
	/**Hàm này dùng để kết nối tới các hệ cơ sở dữ liệu
	 * Tùy vào từng Hệ CSDL mà chúng ta coding khác nhau ở các lớp kế thừa từ nó
	 */
	public abstract Connection getConnect(String strServer,String strDatabase,String strUser,String strPwd);
	/** Hàm này dùng để truy vấn dữ liệu,
	 * Connection con: đối tượng connnection
	 * String strSql: câu truy vấn
	 * Trả về ResultSet
	 */
	public ResultSet execQuery(Connection con,String strSql)
	{
		ResultSet rs=null;
		try
		{
			Statement st=con.createStatement();
			rs =st.executeQuery(strSql);
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return rs;
	}
	/** Hàm này dùng để truy vấn dữ liệu,
	 * String strSql: câu truy vấn
	 * Trả về ResultSet
	 */
	public ResultSet execQuery(String strSql)
	{
		ResultSet rs=null;
		try
		{
			Statement st=m_Connection.createStatement();
			rs =st.executeQuery(strSql);
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return rs;
	}
	/** Hàm này dùng cập nhật dữ liệu,
	 * Connection con: đối tượng connnection
	 * String strSql: câu truy vấn
	 * Nếu cập nhật thành công thì kết quả >0
	 */
	public int execNoneQuery(Connection con,String strSql)
	{
		int rec=0;
		try
		{
			Statement st=con.createStatement();
			rec=st.executeUpdate(strSql);
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return rec;
	}
	/** Hàm này dùng cập nhật dữ liệu,
	 * String strSql: câu truy vấn
	 * Nếu cập nhật thành công thì kết quả >0
	 */
	public int execNoneQuery(String strSql)
	{
		int rec=0;
		try
		{
			Statement st=m_Connection.createStatement();
			rec=st.executeUpdate(strSql);
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return rec;
	}
	/** Hàm này dùng đóng kết nối,
	 * Connection con: đối tượng connnection
	 */
	public void close(Connection con)
	{
		try
		{
			if(con!=null)
				con.close();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	/** Hàm này dùng đóng kết nối,
	 */
	public void close()
	{
		try
		{
			if(m_Connection!=null)
				m_Connection.close();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}
}
