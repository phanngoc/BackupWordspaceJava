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
import java.awt.Label;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
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
public class Test10 extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JPanel pnFlow;
	TextField userText;
	Connection conn;
	JTable table;
	String query;
	String textsearch;
	
	public Test10(String title)
	{
	 setTitle(title);
	 pnFlow = new JPanel();
	
	 //pnFlow.setLayout(new BoxLayout(pnFlow,BoxLayout.Y_AXIS));
	 pnFlow.setLayout(new GridLayout(3,1));
	 JPanel pn1 = new JPanel();
	 pn1.setLayout(new FlowLayout());
	 JLabel titlelabel = new JLabel();
	 titlelabel.setText("Các số nguyên tố bé hơn hoặc bằng n");
	 pn1.add(titlelabel);
	 pnFlow.add(pn1);
	 
	 
	 JPanel pn2 = new JPanel();
	 pn2.setLayout(new GridLayout(2,2));
	 Label nhapn = new Label();
	 nhapn.setText("Nhập n:");
	 pn2.add(nhapn);
	 TextField editnhap = new TextField();
	 pn2.add(editnhap);
	 Label kqlabel = new Label();
	 kqlabel.setText("Kết quả:");
	 pn2.add(kqlabel);
	 TextField editkq = new TextField();
	 pn2.add(editkq);
	 
	 pnFlow.add(pn2);
	 
	 JPanel pn3 = new JPanel();
	 pn3.setLayout(new FlowLayout());
	 Button tim = new Button("Tim");
	 tim.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	 });
	 Button reset = new Button("Reset");
	 reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
	 });
	 Button exit = new Button("Exit");
	 exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
	 });
	 pn3.add(tim);
	 pn3.add(reset);
	 pn3.add(exit);
	 pnFlow.add(pn3);
	 Container con= getContentPane();
	 con.add(pnFlow);
  
	}
	public static void main(String[] args)
	{
		Test10 myUI=new Test10("Tạo bảng");
		myUI.setSize(600, 400);
		myUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myUI.setLocationRelativeTo(null);
		myUI.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
