package doanmang;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import ltjava.Bai3;

public class XemClient extends JFrame{
	Container container = getContentPane();
	DefaultTableModel tablemodel = new DefaultTableModel();
	JTable table;
	String option= "maso";
	String option_khoithi = "1";
	String option_truong = "1";
	 public XemClient(String title)
	    {
	    	super(title);
	    	JPanel pnFlow=new JPanel();
	    	pnFlow.setLayout(new FlowLayout());
	    	JRadioButton radioname = new JRadioButton("Theo ten");
	    	radioname.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					option = "name";
				}
			});
	        JRadioButton radioma = new JRadioButton("Theo ma so",true);
	        radioma.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					option = "maso";
				}
			});
	        ButtonGroup group = new ButtonGroup();
	        group.add(radioma);
	        group.add(radioname);
	    	JButton buttonsearch = new JButton("Search");
	    	pnFlow.add(radioma);
	    	pnFlow.add(radioname);
	    	
	    	final JTextField  textsearch = new JTextField(22);
	    	pnFlow.add(textsearch);
	    	JLabel labelkhoithi = new JLabel("Khối thi");
	    	pnFlow.add(labelkhoithi);
	    	
	    	String[] khoithi = { "A", "B", "C", "D"};

	    	//Create the combo box, select item at index 4.
	    	//Indices start at 0, so 4 specifies the pig.
	    	final JComboBox comboxKhoiThi = new JComboBox(khoithi);
	    	comboxKhoiThi.setSelectedIndex(0);
	    	comboxKhoiThi.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					option_khoithi = (comboxKhoiThi.getSelectedIndex()+1)+"";
				/*	if(option_khoithi.equals("1"))
					{
						table.getColumnModel().getColumn(6).setHeaderValue("Toan");
						table.getColumnModel().getColumn(7).setHeaderValue("Li");
						table.getColumnModel().getColumn(8).setHeaderValue("Hoa");
						JTableHeader th = table.getTableHeader();
						th.repaint();
					}
					if(option_khoithi.equals("2"))
					{
						table.getColumnModel().getColumn(6).setHeaderValue("Toan");
						table.getColumnModel().getColumn(7).setHeaderValue("Sinh");
						table.getColumnModel().getColumn(8).setHeaderValue("Hoa");
						JTableHeader th = table.getTableHeader();
						th.repaint();
					}
				*/	
				}
			});
			
	    	pnFlow.add(comboxKhoiThi);
	    	
	    	JLabel labeltruong = new JLabel("Trường");
	    	pnFlow.add(labeltruong);
	    	
	    	String[] truongs = { "Dai hoc Bach Khoa", "Dai hoc Su Pham", "Dai hoc kinh te", "Dai hoc Duy Tan"};

	    	final JComboBox comboxTruongs = new JComboBox(truongs);
	    	comboxTruongs.setSelectedIndex(0);
	    	comboxTruongs.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					option_truong = (comboxTruongs.getSelectedIndex()+1)+"";
				}
			});
			
	    	pnFlow.add(comboxTruongs);
	    	
	    	
	    	buttonsearch.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					try {
						int rowCount = tablemodel.getRowCount();
						//Remove rows one by one from the end of the table
						for (int i = rowCount - 1; i >= 0; i--) {
							tablemodel.removeRow(i);
						}
						String chuoi = textsearch.getText();
						Socket socket = new Socket("Localhost",2500);
						DataInputStream din = new DataInputStream(socket.getInputStream());
						DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
						System.out.println("Chuoi do la:"+chuoi+"|"+option+"|"+option_khoithi+"|"+option_truong);
						dout.writeUTF(chuoi+"|"+option+"|"+option_khoithi+"|"+option_truong);
						while(true)
						{
							String ketqua = din.readUTF();
							System.out.println("KQ:"+ketqua);
							if(ketqua.equals("finish")) break;
							String[] data = ketqua.split("\\|");
					    	tablemodel.addRow(data);
						}
						
					} catch (SocketException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
	    	
	    	pnFlow.add(buttonsearch);
	    	JPanel panel = new JPanel(new GridLayout());
	    	panel.setPreferredSize(new Dimension(800,400));
	    	table = new JTable();
	    	String[] columns = {"MSSV","Fullname","Khoi thi","Birthday","Gender","Que quan","Diem mon 1","Diem mon 2","Diem mon 3"};
	    	tablemodel.setColumnIdentifiers(columns);
	    	table.setModel(tablemodel);
	    	
	    	panel.add(new JScrollPane(table));

	    	pnFlow.add(panel);
	    	container.add(pnFlow);
	    }
	  public static void main(String arg[])
	    {
	    	  XemClient test = new XemClient("XemClient");
	    	  test.setSize(850, 500);
	    	  test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	  test.setLocationRelativeTo(null);
	    	  test.setVisible(true);
	    }
}
