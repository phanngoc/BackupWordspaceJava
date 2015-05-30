package bom.test1;

import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
public class Test9 extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JPanel pnFlow;
	TextField userText;
	Connection conn;
	JTable table;
	String query;
	String textsearch;
	
	public Test9(String title)
	{
		 setTitle(title);
		 pnFlow = new JPanel();
		 pnFlow.setLayout(new FlowLayout());
	}
	public static void main(String[] args) {
	  try{
	      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	       Connection con=DriverManager.getConnection("jdbc:odbc:sss");
	       Statement stmt = con.createStatement();
			String sql = "Select * from KhachHang";
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int numberOfColumns = rsmd.getColumnCount();
			for(int j=1; j<=numberOfColumns;j++) {
				System.out.println(rsmd.getColumnLabel(j));	}
			while(rs.next()) {
				for(int i=1; i<=numberOfColumns;i++){ 
				System.out.println(rs.getObject(i));	
				}
			}
				rs.close();
				stmt.close();
		      } catch(Exception e)
		      {
		    	  System.out.println("Error " + e); 
		      } 	
	 }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}  
}
