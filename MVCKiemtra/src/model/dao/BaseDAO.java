package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDAO {
	private static Connection connection = null;
 
	public Connection getConnection() {
		if (connection != null)
			return connection;
		try {
			Class.forName("com.mysql.jdbc.Driver"); // Nạp driver cho việc kết
													// nối
			// Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); dùng cái này nếu
			// là sqlserver của microsoft

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		String url = "jdbc:mysql://127.0.0.1:3306/thimang"; // trong đó
															// ://127.0.0.1:3306/test
															// là tên và đường
															// dẫn tới CSDL.
		// String Url = "jdbc:odbc:" + dataBaseName; dùng cái này nếu là
		// SQLServer
		try {
			// Kết nối tới CSDL theo đường dẫn url, tài khoản đăng nhập là root,
			// pass là khoaninh, nếu CSDL của bạn khi tạo không có pass thi bỏ
			// qua nó, chỉ cần viết getConnection(url)
			connection = DriverManager.getConnection(url, "root", "");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
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

}
