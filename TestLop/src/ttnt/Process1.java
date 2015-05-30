package ttnt;

import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop.Action;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import bom.test1.Test8;



public class Process1 extends JFrame implements ActionListener{
    ArrayList<Sinhvien> sinhviens = new ArrayList<Sinhvien>();
    ArrayList<Phongthi> phongthis = new ArrayList<Phongthi>();
    ArrayList<Ca> cas = new ArrayList<Ca>();
    ArrayList<Caphong> caphongs = new ArrayList<Caphong>();
    ArrayList<Lichthi> lichthis = new ArrayList<Lichthi>();
	private static final long serialVersionUID = 1L;
	JPanel pnFlow;
	Connection conn;

	Statement statement = null;
	
	
	JPanel pn2;
	JPanel bangca;
	JPanel bangsinhvien;
	JPanel bangphongthi;
	
	public Process1(String title)
	{
	 this.connect();
	 setTitle(title);
	 pnFlow = new JPanel();
	 pnFlow.setLayout(new GridLayout(2,1));
	 JPanel pn1 = new JPanel();
	 pn1.setLayout(new GridLayout(1,3));
	 
	 JPanel pn1con1 = new JPanel(); 
	 pn1con1.setLayout(new GridLayout(2,1));
	 JPanel pn1con1con1 = new JPanel();
	 pn1con1con1.setLayout(new GridLayout());
	 setSinhvien(pn1con1con1);
	 pn1con1.add(pn1con1con1);
	 bangsinhvien =  pn1con1con1;
			  
	 
	 JPanel pn1con1con2 = new JPanel();
	 pn1con1con2.setLayout(new GridLayout());
	 setNhapSinhvien(pn1con1con2);
	 pn1con1.add(pn1con1con2);
	 pn1.add(pn1con1);
	 
	 
	 
	 JPanel pn1con2 = new JPanel();
	 pn1con2.setLayout(new GridLayout(2,1));
	 JPanel pn1con2con1 = new JPanel();
	 pn1con2con1.setLayout(new GridLayout());	 
	 pn1con2.add(pn1con2con1);
	 setPhongthi(pn1con2con1);
	 bangphongthi = pn1con2con1;
	 JPanel pn1con2con2 = new JPanel();
	 pn1con2con2.setLayout(new GridLayout());
	 pn1con2.add(pn1con2con2);
	 setNhapPhongthi(pn1con2con2);
	 pn1.add(pn1con2);
	 
	 
	 
	 JPanel pn1con3 = new JPanel();
	 pn1con3.setLayout(new GridLayout(2,1));
	 JPanel pn1con3con1 = new JPanel();
	 pn1con3con1.setLayout(new GridLayout());
	 pn1con3.add(pn1con3con1);
	 setCa(pn1con3con1);
	 bangca = pn1con3con1;
	 
	 JPanel pn1con3con2 = new JPanel();
	 pn1con3con2.setLayout(new GridLayout());
	 setNhapCa(pn1con3con2);
	 pn1con3.add(pn1con3con2);
	 pn1.add(pn1con3);
	 pn1.setBackground(Color.RED);
	 pnFlow.add(pn1);
	 
	 pn2 = new JPanel();
	 pnFlow.add(pn2);
	 
	 setLichthi(pn2);
	 
	 pn2.setBackground(Color.GREEN);
	 Container con=getContentPane();
	 con.add(pnFlow);
	
	} 
    public void setNhapSinhvien(JPanel panel)
    {
    	panel.setLayout(new GridBagLayout());
    	GridBagConstraints c = new GridBagConstraints();
    	c.fill  = GridBagConstraints.HORIZONTAL;
    	c.gridx = 0;
    	c.gridy = 0;
    	c.gridwidth = 2;
    	JLabel title = new JLabel("Nhập thêm sinh viên");
    	panel.add(title,c);
    	c.gridwidth = 1;
    	c.gridx = 0;
    	c.gridy = 1;
    	JLabel labelten = new JLabel("Nhập tên:");
    	panel.add(labelten,c);
    	
    	c.gridx = 0;
    	c.gridy = 2;
    	JLabel labellop = new JLabel("Nhập lớp:");
    	panel.add(labellop,c);
    	
    	c.gridx = 0;
    	c.gridy = 3;
    	JLabel labelsbd = new JLabel("Nhập số báo danh:");
    	panel.add(labelsbd,c);
    	
    	c.gridx = 0;
    	c.gridy = 4;
    	JLabel labelngaysinh = new JLabel("Nhập ngày sinh:");
    	panel.add(labelngaysinh,c);
    	
    	c.gridy = 1;
    	c.gridx = 1;
    	final JTextField nhapten = new JTextField(22);
    	panel.add(nhapten,c);
    	
    	c.gridx = 1;
    	c.gridy = 2;
    	final JTextField nhaplop = new JTextField(22);
    	panel.add(nhaplop,c);
    	
    	c.gridx = 1;
    	c.gridy = 3;
    	final JTextField nhapsbd = new JTextField(22);
    	panel.add(nhapsbd,c);
    	
    	c.gridx = 1;
    	c.gridy = 4;
    	final JTextField nhapngaysinh = new JTextField(22);
    	panel.add(nhapngaysinh,c);
    	
    	c.gridx = 0;
    	c.gridy = 5;
    	c.gridwidth = 2;
    	JButton submit = new JButton("Submit");
    	submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			    DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
			    java.util.Date startDate;
			    String newDateString="";
			    try {
			        startDate = df.parse(nhapngaysinh.getText());
			        System.out.println(newDateString);
					java.text.SimpleDateFormat sdf = 
					     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				String currentTime = sdf.format(startDate);	
				String sql = "INSERT INTO sinhvien(name,class,sbd,birthday) " +
		                   "VALUES ('"+nhapten.getText()+"', '"+nhaplop.getText()+"',"+nhapsbd.getText()+",'"+currentTime+"')";
				System.out.println("Gia tri sql:"+sql);
				statement.executeUpdate(sql);
				setSinhvien(bangsinhvien);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    nhapten.setText("");
			    nhaplop.setText("");
			    nhapsbd.setText("");
			    nhapngaysinh.setText("");
			}
		});
    	panel.add(submit,c);
    	
    }
    public void setNhapPhongthi(JPanel panel)
    {
    	panel.setLayout(new GridBagLayout());
    	GridBagConstraints c = new GridBagConstraints();
    	c.fill  = GridBagConstraints.BOTH;
    	c.gridx = 0;
    	c.gridy = 0;
    	c.gridwidth = 2;
    	JLabel title = new JLabel("Nhập thêm phòng thi");
    	panel.add(title,c);
    	c.gridwidth = 1;
    	c.gridx = 0;
    	c.gridy = 1;
    	JLabel labelten = new JLabel("Nhập tên phòng:");
    	panel.add(labelten,c);
    	
    	c.gridx = 0;
    	c.gridy = 2;
    	JLabel labellop = new JLabel("Nhập tối đa:");
    	panel.add(labellop,c);
   
    	
    	c.gridy = 1;
    	c.gridx = 1;
    	final JTextField nhaptenphong = new JTextField(22);
    	panel.add(nhaptenphong,c);
    	
    	c.gridx = 1;
    	c.gridy = 2;
    	final JTextField nhaptoida = new JTextField(22);
    	panel.add(nhaptoida,c);
    
    	
    	c.gridx = 0;
    	c.gridy = 3;
    	c.gridwidth = 2;
    	JButton submit = new JButton("Submit");
    	submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
				String sql = "INSERT INTO phongthi(tenphong,toida) " +
		                   "VALUES ('"+nhaptenphong.getText()+"',"+nhaptoida.getText()+")";
				System.out.println("Gia tri sql:"+sql);
				statement.executeUpdate(sql);
				setPhongthi(bangphongthi);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
    	panel.add(submit,c);
    	
    }
    public void setNhapCa(final JPanel panel)
    {
    	panel.setLayout(new GridBagLayout());
    	GridBagConstraints c = new GridBagConstraints();
    	c.fill  = GridBagConstraints.BOTH;
    	c.gridx = 0;
    	c.gridy = 0;
    	c.gridwidth = 2;
    	JLabel title = new JLabel("Nhập thêm ca thi");
    	panel.add(title,c);
    	c.gridwidth = 1;
    	c.gridx = 0;
    	c.gridy = 1;
    	JLabel labelten = new JLabel("Nhập tiết đâu tiên:");
    	panel.add(labelten,c);
    	
    	c.gridx = 0;
    	c.gridy = 2;
    	JLabel labellop = new JLabel("Nhập tiết kết thúc:");
    	panel.add(labellop,c);
    	
    	c.gridx = 0;
    	c.gridy = 3;
    	JLabel labelngaysinh = new JLabel("Nhập ngày thi:");
    	panel.add(labelngaysinh,c);
    	
    	c.gridx = 1;
    	c.gridy = 1;
    	final JTextField nhaptietdautien = new JTextField(22);
    	panel.add(nhaptietdautien,c);
    	
    	c.gridx = 1;
    	c.gridy = 2;
    	final JTextField nhaptietketthuc = new JTextField(22);
    	panel.add(nhaptietketthuc,c);
    	
    	c.gridx = 1;
    	c.gridy = 3;
    	final JTextField nhapngaythi = new JTextField(22);
    	panel.add(nhapngaythi,c);
    	
    	c.gridx = 0;
    	c.gridy = 4;
    	c.gridwidth = 2;
    	JButton submit = new JButton("Submit");
    	submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			    DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
			    java.util.Date startDate;
			    String newDateString="";
			    try {
			        startDate = df.parse(nhapngaythi.getText());
			        System.out.println(newDateString);
					java.text.SimpleDateFormat sdf = 
					     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				String currentTime = sdf.format(startDate);	
				String sql = "INSERT INTO ca(tietdau,tietkethuc,ngay) " +
		                   "VALUES ("+nhaptietdautien.getText()+","+nhaptietketthuc.getText()+",'"+currentTime+"')";
				System.out.println("Gia tri sql:"+sql);
				statement.executeUpdate(sql);
				ResultSet rs = statement.executeQuery("select last_insert_id() as last_id from ca");
				//int lastid = Integer.parseInt(rs.getString("last_id"));
				int thoigiandau = Integer.parseInt(nhaptietdautien.getText());
				int thoigiancuoi = Integer.parseInt(nhaptietketthuc.getText());
				
				
			    java.sql.Date sqlDate = new java.sql.Date(startDate.getTime());
				System.out.println("id nhap ca:"+0);
				cas.add(new Ca(0,thoigiandau,thoigiancuoi,sqlDate));
				setCa(bangca);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
    	panel.add(submit,c);
    	
    }
    
    public void setSinhvien(JPanel panel)
	{
		this.getAllSinhvien();
		if(panel.getComponentCount()!=0)
		{
			panel.removeAll();
		};
		String[] columnNames = {"id", "Name","class","sobaodanh","ngaysinh","Xoa"};

        DefaultTableModel model = new DefaultTableModel(null, columnNames)
        {
            	 @Override
    			  public boolean isCellEditable(int row, int column)
            	    {
            		 return column == 4 || column == 1 || column == 2|| column == 3 || column==5 ? true : false;
            	    }
        };
        model.setRowCount(sinhviens.size()); // instead you can use your textfiled value here
        model.setColumnCount(6);
        JTable table = new JTable(model);
        javax.swing.Action delete = new AbstractAction() {
			
     			@Override
     			public void actionPerformed(ActionEvent e) {
     				// TODO Auto-generated method stub
     				JTable table = (JTable)e.getSource();
     			    int modelRow = Integer.valueOf( e.getActionCommand() );
     				System.out.println("Da bam xoa:"+modelRow);
     				String sql = "DELETE FROM sinhvien WHERE id="+((DefaultTableModel)table.getModel()).getValueAt(modelRow,0);
     				try {
     					statement.executeUpdate(sql);
     				} catch (SQLException e1) {
     					// TODO Auto-generated catch block
     					e1.printStackTrace();
     				}
     				((DefaultTableModel)table.getModel()).removeRow(modelRow);
     			}
     		};
              
        ButtonColumn buttonColumn = new ButtonColumn(table, delete, 5);
        
        
        
        
		JTableHeader header = table.getTableHeader();
		header.setBackground(Color.yellow);
		JScrollPane pane = new JScrollPane(table);
		panel.add(pane);			

				for(int i=0;i<sinhviens.size();i++)
				{
					Sinhvien svv = sinhviens.get(i);
					table.setValueAt(svv.id, i, 0);
					table.setValueAt(svv.ten, i, 1);
					table.setValueAt(svv.lop, i, 2);
					table.setValueAt(svv.sbd, i, 3);
					table.setValueAt(svv.ngaysinh, i, 4);
					table.setValueAt("Xoa", i, 5);
				}
		panel.validate();
		panel.repaint();			
		table.getModel().addTableModelListener(new TableModelListener() {

		      public void tableChanged(TableModelEvent e) {
		    	  if(e.getColumn()==-1) return ;
		         try
		         {
		           // create our java preparedstatement using a sql update query
		           PreparedStatement ps = conn.prepareStatement("UPDATE sinhvien SET name = ?, class = ?, sbd = ?,birthday = ? WHERE id = ?");
		        
		           // set the preparedstatement parameters
		           ps.setString(1,(String)((DefaultTableModel)e.getSource()).getValueAt(e.getFirstRow(), 1));
		           ps.setString(2,(String)(((DefaultTableModel)e.getSource()).getValueAt(e.getFirstRow(), 2)));
		           ps.setInt(3,convertInt(((DefaultTableModel)e.getSource()).getValueAt(e.getFirstRow(), 3)));
		
		           DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
				   java.util.Date startDate;
				   java.sql.Date sqlDate = null;
				   Object birthday = ((DefaultTableModel)e.getSource()).getValueAt(e.getFirstRow(), 4);
				   
				   if(birthday instanceof java.sql.Date)
				   {
					   sqlDate = (java.sql.Date)birthday;
				   }
				   else
				   {
					   startDate = df.parse((String)birthday);
					   sqlDate = new java.sql.Date(startDate.getTime());
				   }
				   
				   
		           ps.setDate(4,sqlDate);
		           ps.setInt(5,(int)((DefaultTableModel)e.getSource()).getValueAt(e.getFirstRow(), 0));
		           // call executeUpdate to execute our sql update statement
		           ps.executeUpdate();
		           ps.close();
		         }
		         catch (SQLException | ParseException se)
		         {
		           // log the exception
		        	 System.out.println("Day la phong thi:"+ se.getMessage());	
		         }
		      }
		});					
	
	}
	public void setPhongthi(JPanel panel)
	{
		this.getAllPhongthi();
		if(panel.getComponentCount()!=0)
		{
			panel.removeAll();
		};
		String[] columnNames = {"id", "Tên phòng thi","Số lượng tối đa","Xoa"};

        DefaultTableModel model = new DefaultTableModel(null, columnNames)
        {
        	 @Override
			  public boolean isCellEditable(int row, int column)
        	    {
        		 return column == 1 || column==2 || column ==3 ? true : false;
        	    }
        };
        model.setRowCount(phongthis.size()); 
        model.setColumnCount(4);
        JTable table = new JTable(model);
        javax.swing.Action delete = new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JTable table = (JTable)e.getSource();
			    int modelRow = Integer.valueOf( e.getActionCommand() );

				String sql = "DELETE FROM phongthi WHERE id="+((DefaultTableModel)table.getModel()).getValueAt(modelRow,0);
				try {
					statement.executeUpdate(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				((DefaultTableModel)table.getModel()).removeRow(modelRow);
			}
		};
         
        ButtonColumn buttonColumn = new ButtonColumn(table, delete, 3);
        
		JTableHeader header = table.getTableHeader();
		header.setBackground(Color.yellow);
		JScrollPane pane = new JScrollPane(table);

		panel.add(pane);			

		for(int i=0;i<phongthis.size();i++)
		{
			Phongthi pthi = phongthis.get(i);
			table.setValueAt(pthi.id, i, 0);
			table.setValueAt(pthi.tenphong, i, 1);
			table.setValueAt(pthi.toida, i, 2);
			table.setValueAt("Xoa", i, 3);
		}
		panel.validate();
		panel.repaint();	
		table.getModel().addTableModelListener(new TableModelListener() {
			  	
		      public void tableChanged(TableModelEvent e) {
		        if(e.getColumn()==-1) return ;
		         try
		         {
		           // create our java preparedstatement using a sql update query
		           PreparedStatement ps = conn.prepareStatement("UPDATE phongthi SET tenphong = ?, toida = ? WHERE id = ?");
		        
		           // set the preparedstatement parameters
		           ps.setString(1,(String)((DefaultTableModel)e.getSource()).getValueAt(e.getFirstRow(), 1));
		           ps.setInt(2,convertInt(((DefaultTableModel)e.getSource()).getValueAt(e.getFirstRow(), 2)));
		           ps.setInt(3,(int)((DefaultTableModel)e.getSource()).getValueAt(e.getFirstRow(), 0));
		        
		           // call executeUpdate to execute our sql update statement
		           ps.executeUpdate();
		           ps.close();
		         }
		         catch (SQLException se)
		         {
		           // log the exception
		        	 System.out.println("Day la phong thi:"+ se.getMessage());	
		         }
		      }
		});				
	}
	public int convertInt(Object e)
	{
		if(e instanceof Integer)
		{
			return (int)e;
		}
		if(e instanceof String)
		{
			return Integer.parseInt((String)e);
		}
		return 1;
	}
	public void setCa(JPanel panel)
	{
		this.getAllCa();
		if(panel.getComponentCount()!=0)
		{
			panel.removeAll();
		};
		String[] columnNames = {"id", "Tiết đầu tiên","Tiết kết thúc","Ngày thi","Xoa"};

        DefaultTableModel model = new DefaultTableModel(null, columnNames)
        {
       	     @Override
			 public boolean isCellEditable(int row, int column)
       	     {
       		  return column == 1 || column == 2 || column == 3 || column==4 ? true : false;
       	     }
        };
        model.setRowCount(cas.size()); 
        model.setColumnCount(5);
        JTable table = new JTable(model);
        javax.swing.Action delete = new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JTable table = (JTable)e.getSource();
			    int modelRow = Integer.valueOf( e.getActionCommand() );
				String sql = "DELETE FROM ca WHERE id="+((DefaultTableModel)table.getModel()).getValueAt(modelRow,0);
				try {
					statement.executeUpdate(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				((DefaultTableModel)table.getModel()).removeRow(modelRow);
			}
		};
         
        ButtonColumn buttonColumn = new ButtonColumn(table, delete, 4);
        
        
        
        
		JTableHeader header = table.getTableHeader();
		header.setBackground(Color.yellow);
		JScrollPane pane = new JScrollPane(table);
		panel.add(pane);			

		for(int i=0;i<cas.size();i++)
		{
			Ca ca = cas.get(i);
			table.setValueAt(ca.id, i, 0);
			table.setValueAt(ca.thoigiandau, i, 1);
			table.setValueAt(ca.thoigiancuoi, i, 2);
			table.setValueAt(ca.ngay, i, 3);
			table.setValueAt("Xoa", i, 4);
		}
		panel.validate();
		panel.repaint();	
		table.getModel().addTableModelListener(new TableModelListener() {

		      public void tableChanged(TableModelEvent e) {

		    	  if(e.getColumn()==4||e.getColumn()==-1) return;
		         try
		         {
		           // create our java preparedstatement using a sql update query
		           PreparedStatement ps = conn.prepareStatement("UPDATE ca SET tietdau = ?, tietkethuc = ?, ngay = ? WHERE id = ?");
		        
		           // set the preparedstatement parameters
		           ps.setInt(1,convertInt(((DefaultTableModel)e.getSource()).getValueAt(e.getFirstRow(), 1)));
		           ps.setInt(2,convertInt(((DefaultTableModel)e.getSource()).getValueAt(e.getFirstRow(), 2)));
		
		           DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
				   java.util.Date startDate;
				   java.sql.Date sqlDate = null;
				   Object ngaythi = ((DefaultTableModel)e.getSource()).getValueAt(e.getFirstRow(), 3);
				   
				   if(ngaythi instanceof java.sql.Date)
				   {
					   sqlDate = (java.sql.Date)ngaythi;
				   }
				   else
				   {
					   startDate = df.parse((String)ngaythi);
					   sqlDate = new java.sql.Date(startDate.getTime());
				   }
				   
				   
		           ps.setDate(3,sqlDate);
		           ps.setInt(4,(int)((DefaultTableModel)e.getSource()).getValueAt(e.getFirstRow(), 0));
		           // call executeUpdate to execute our sql update statement
		           ps.executeUpdate();
		           ps.close();
		         }
		         catch (SQLException | ParseException se)
		         {
		           // log the exception
		        	
		         }
		      }
		});			
	}
	
	public void sortPhongthi()
	{
		for(int i=0;i<phongthis.size();i++)
		{
			for(int j=i+1;j<phongthis.size()-1;j++)
			{
				if(phongthis.get(i).toida < phongthis.get(j).toida)
				{
					Phongthi temp = phongthis.get(i);
					phongthis.set(i, phongthis.get(j));
					phongthis.set(j, temp);
				}
			}
		}
		for(int i=0;i<phongthis.size();i++)
		{
			System.out.println("phong thi sort:"+phongthis.get(i).tenphong);
		}
	}
	
	public void createCaPhong()
	{
		caphongs.clear();
		int id = 0;
		for(int i=0;i<cas.size();i++)
		{
			for(int j=0;j<phongthis.size();j++)
			{
				Caphong caphong = new Caphong(id,cas.get(i),phongthis.get(j));
				caphongs.add(caphong);
				id++;
			}
		}
	}
	public void createLichThi()
	{
		lichthis.clear();
		int indexcaphong = 0;
		int count = 0;
		int idlichthi = 0;
		for(int i=0;i<sinhviens.size();i++)
		{
			
				System.out.println("Kiem tra:"+sinhviens.get(i).ten+"|"+caphongs.get(indexcaphong).phongthi.toida+"|"+caphongs.get(indexcaphong).phongthi.tenphong+"|"+count);
		
			//System.out.println("check:"+indexcaphong+caphongs.get(indexcaphong).ca.thoigiandau);
			if(caphongs.get(indexcaphong).phongthi.toida > count)
			{
				count++;
			}
			else
			{
				count = 1;
				indexcaphong++;
			}
			Lichthi lich = new Lichthi(idlichthi,sinhviens.get(i),caphongs.get(indexcaphong));
			idlichthi++;
			lichthis.add(lich);
			//System.out.println("Da xep:"+lich.sinhvien.ten+"|"+lich.caphong.ca.thoigiandau+"|"+lich.caphong.phongthi.tenphong);
		}
		
	}
	
	public void setLichthi(JPanel panel)
	{
		getAllSinhvien();
		getAllPhongthi();
		getAllCa();
		sortPhongthi();
		createCaPhong();
		createLichThi();
		if(panel.getComponentCount()!=0)
		{
			panel.removeAll();
		};
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));


    	JButton taolichthi = new JButton("Tạo lịch thi");
    	taolichthi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setLichthi(pn2);
			}
		});
    	panel.add(taolichthi);
		String[] columnNames = {"id", "Tên","Lớp","Số báo danh","Ngày sinh","Tên phòng thi","Tiết bắt đầu","Tiết kết thúc","Ngày"};

        DefaultTableModel model = new DefaultTableModel(null, columnNames);
        model.setRowCount(sinhviens.size()); // instead you can use your textfiled value here
        model.setColumnCount(9);
        JTable table = new JTable(model);
        
		JTableHeader header = table.getTableHeader();
		header.setBackground(Color.yellow);
		JScrollPane pane = new JScrollPane(table);
    	
		panel.add(pane);			

				for(int i=0;i<lichthis.size();i++)
				{
					Lichthi svv = lichthis.get(i);
					table.setValueAt(svv.id, i, 0);
					table.setValueAt(svv.sinhvien.ten, i, 1);
					table.setValueAt(svv.sinhvien.lop, i, 2);
					table.setValueAt(svv.sinhvien.sbd, i, 3);
					table.setValueAt(svv.sinhvien.ngaysinh, i, 4);	
					table.setValueAt(svv.caphong.phongthi.tenphong, i, 5);
					table.setValueAt(svv.caphong.ca.thoigiandau, i, 6);
					table.setValueAt(svv.caphong.ca.thoigiancuoi, i, 7);
					table.setValueAt(svv.caphong.ca.ngay, i, 8);
				}
				panel.validate();
				panel.repaint();		
    	
	}
	
	
	public void getAllSinhvien()
	{
		sinhviens.clear();
		ResultSet resultSet = null;
		try {
			resultSet = statement.executeQuery("select * from sinhvien");
			while (resultSet.next())
			{
				int id = resultSet.getInt("id");
				String name =  resultSet.getString("name");
				String cla =  resultSet.getString("class");
				int sbd =  resultSet.getInt("sbd");
				Date date =  resultSet.getDate("birthday");
				Sinhvien sv = new Sinhvien(id, name, cla, sbd, date);
				sinhviens.add(sv);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void getAllPhongthi()
	{
		phongthis.clear();
		ResultSet resultSet = null;
		try {
			resultSet = statement.executeQuery("select * from phongthi");
			while (resultSet.next())
			{
				int id = resultSet.getInt("id");
				String name =  resultSet.getString("tenphong");
				int toida =  resultSet.getInt("toida");
				Phongthi phongthi = new Phongthi(id,name,toida);
				phongthis.add(phongthi);
	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void getAllCa()
	{
		cas.clear();
		ResultSet resultSet = null;
		try {
			resultSet = statement.executeQuery("select * from ca");
			while (resultSet.next())
			{
				int id = resultSet.getInt("id");
				int thoigiandau =  resultSet.getInt("tietdau");
				int thoigiancuoi =  resultSet.getInt("tietkethuc");
				Date ngay =  resultSet.getDate("ngay");
				Ca ca = new Ca(id,thoigiandau,thoigiancuoi,ngay);
		
				cas.add(ca);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void connect()
	{
		 try {
				Class.forName("com.mysql.jdbc.Driver");
				String url ="jdbc:mysql://localhost:3306/ttnt";
				conn = DriverManager.getConnection(url, "root", "");
				System.out.println("connection Established");
				statement =  conn.createStatement();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  // initialise the driver
			  catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
  public static void main(String arg[])
  {
	    Process1 myUI=new Process1("Phần mềm phân phòng thi thời gian");
		myUI.setSize(1300, 600);
		myUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myUI.setLocationRelativeTo(null);
		myUI.setVisible(true);
  }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
