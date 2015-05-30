package bom.test1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
import javax.swing.table.DefaultTableModel;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.spi.CharsetProvider;
public class Test8 extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JPanel pnFlow;
	TextField userText;
	Connection conn;
	JTable table;
	String query;
	String textsearch;
	
	public Test8(String title)
	{
	 setTitle(title);
	 pnFlow = new JPanel();
	
	 //pnFlow.setLayout(new BoxLayout(pnFlow,BoxLayout.Y_AXIS));
	 pnFlow.setLayout(new FlowLayout());
	
	/* GridBagConstraints c = new GridBagConstraints();
	 c.gridx = 0;
	 c.gridy = 0; 
	 c.gridwidth = 1;
	 */
	 userText = new TextField(22);
	 Button button1 = new Button("Tìm");
	 button1.addActionListener(new ActionListener() {
		 
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			textsearch = userText.getText();
			setResult();
		}
	 });
	 Button button2 = new Button("Xóa");

	 JPanel pn1 = new JPanel();
	 //pn1.setLayout(new BoxLayout(pn1,BoxLayout.X_AXIS));
	 pn1.setLayout(new FlowLayout());
	 pn1.add(userText);
	 pn1.add(button1);
	 pn1.add(button2);
	
	// pn1.setBackground(Color.RED);
	 pnFlow.add(pn1);
	 
	 ButtonGroup group = new ButtonGroup();
	 
	 JRadioButton radioid = new JRadioButton("Id");
	 radioid.addItemListener(new ItemListener() {
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if (e.getStateChange() == ItemEvent.SELECTED) {
		       query = "Id";
		    }
		    else if (e.getStateChange() == ItemEvent.DESELECTED) {
		        // Your deselected code here.
		    }
		}
	});
	 JRadioButton radioten = new JRadioButton("Tên");
	 radioten.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {
			       query = "TenKH";
			    }
			    else if (e.getStateChange() == ItemEvent.DESELECTED) {
			        // Your deselected code here.
			    }
			}
		});
	 JRadioButton radiodiachi = new JRadioButton("Địa chỉ");
	 radiodiachi.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {
			       query = "DiaChi";
			    }
			    else if (e.getStateChange() == ItemEvent.DESELECTED) {
			        // Your deselected code here.
			    }
			}
		});
	 JRadioButton radioluong = new JRadioButton("Lương");
	 radiodiachi.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {
			       query = "Luong";
			    }
			    else if (e.getStateChange() == ItemEvent.DESELECTED) {
			        // Your deselected code here.
			    }
			}
	  });
	 JPanel pn2 = new JPanel();
	 pn2.setLayout(new FlowLayout());
	 
	 group.add(radioid);
	 group.add(radioten);
	 group.add(radiodiachi);
	 group.add(radioluong);
	 
	 pn2.add(radioid);
	 pn2.add(radioten);
	 pn2.add(radiodiachi);
	 pn2.add(radioluong);
	 //pn2.setMinimumSize(new Dimension(580, 1));
	 //pn2.setBackground(Color.BLUE);
	 pnFlow.add(pn2);
	 
	 
	 JPanel pn3 = new JPanel();
	 pn3.setLayout(new FlowLayout());
	 table = new JTable();
	 JScrollPane pane = new JScrollPane(table);
	 pn3.add(pane);
	 pn3.setBackground(Color.BLUE);

	 pnFlow.add(pn3);
	
	 Container con=getContentPane();
	 con.add(pnFlow);

	}
	public static void main(String[] args)
	{
		Test8 myUI=new Test8("Tạo bảng");
		myUI.setSize(500, 400);
		myUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myUI.setLocationRelativeTo(null);
		myUI.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void connect()
	{
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String url = "jdbc:odbc:sss";
			conn = DriverManager.getConnection(url,"phann123","123456");			
		}catch(Exception e)
		{
			
		}
	}
	public void setResult()
	{
		this.connect();
		String sql = "SELECT Id,TenKH,DiaChi,Luong FROM KhachHang WHERE "+query+" LIKE "+"'%"+textsearch+"%'";
		Statement stmt;
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
				    ResultSet.CONCUR_READ_ONLY);
		
		ResultSet rs=stmt.executeQuery(sql);
		int rowCount=0;
		
		
		rs.last();
		rowCount = rs.getRow();
		rs.beforeFirst();

		table.setFont(new Font("Times New Roman", Font.BOLD, 12));
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		String[] columnNames = {"ID", "Tên","Địa chỉ","Lương"};
		dtm.setColumnIdentifiers(columnNames);
		dtm.setRowCount(rowCount); // instead you can use your textfiled value here
		System.out.print(rs.getRow());
		dtm.setColumnCount(4);
		table.setModel(dtm);
		int i=0;
		//rs.first();
				while (rs.next())
				{
					int id=rs.getInt("Id");
					String s= new String(rs.getString("TenKH").getBytes(StandardCharsets.UTF_8),"UTF-8");
					String d=rs.getString("DiaChi");
					double l=rs.getDouble("Luong");
					
					
					System.out.println("ID=" +id +" " + s+ " " + d + " Luong=" + l) ;

					table.setValueAt(id, i, 0);
					table.setValueAt(s, i, 1);
					table.setValueAt(d, i, 2);
					table.setValueAt(l, i, 3);
					i++;
				}
		
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	class KhachHang
	{
		public int id;
		public double luong;
		public String tenkh;
		public String diachi;
		public KhachHang(int id,double luong,String tenkh,String Diachi)
		{
			this.id = id;
			this.luong = luong;
			this.tenkh = tenkh;
			this.diachi = Diachi;
		}
	}
	
}
