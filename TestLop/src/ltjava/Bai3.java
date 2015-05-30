package ltjava;


import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Bai3 extends JFrame implements ActionListener{
  // bang 0 la giam dan	
  int flag_in_de = 0;	
  Container container = getContentPane();
  JButton hienthi;
  TextField nhapn;
  JTextArea showresult;
    public Bai3(String title)
    {
    	super(title);
    	Label label = new Label("Hello");
    	container.add(label);
    	addButton();
    }
    public static void main(String arg[])
    {
    	  Bai3 test = new Bai3("Bài1");
    	  test.setSize(400, 300);
    	  test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	  test.setLocationRelativeTo(null);
    	  test.setVisible(true);
    }
    public void addButton()
    {
    	JPanel panel = new JPanel();
    	panel.setLayout(new FlowLayout());
    	
    	JPanel panel1 = new JPanel();
    	Label labelnhapson = new Label("Nhập số n:");
    	panel1.add(labelnhapson);
    	nhapn = new TextField(22);
    	panel1.add(nhapn);
    	panel.add(panel1);
    	
    	JPanel panel2 = new JPanel();
    	panel2.setLayout(new GridLayout(1,3));
    	Label labelsapxep = new Label("Sắp xếp theo chiều:");
    	panel2.add(labelsapxep);
    	
    	CheckboxGroup group = new CheckboxGroup();
    	final Checkbox check1 = new Checkbox("Tăng dần", group, false);
    	final Checkbox check2 = new Checkbox("Giảm dần", group, false);
    	ItemListener listener = new ItemListener() {
    		@Override
    		public void itemStateChanged(ItemEvent e) {
    			// TODO Auto-generated method stub
    			Checkbox check = (Checkbox)e.getSource();
    	        if(check1==check)
    	        {
    	        	flag_in_de = 1;
    	        }
    	        else
    	        {
    	        	flag_in_de = 0;
    	        }
    		}
    	};
    	check1.addItemListener(listener);
    	check2.addItemListener(listener);
    	panel2.add(check1);
    	panel2.add(check2);
    	panel.add(panel2);
    	
    	JPanel panel3 = new JPanel();
    	panel3.setLayout(new GridLayout(1,3));
    	panel3.add(new JLabel());
    	hienthi = new JButton("Hiển thị");
    	hienthi.addActionListener(this);
    	
    	panel3.add(hienthi);
    	panel3.add(new JLabel());
    	panel.add(panel3);
    	
    	JPanel panel4 = new JPanel();
    	panel4.setLayout(new GridBagLayout());
    	GridBagConstraints c = new GridBagConstraints();
    	c.gridx = 0;
    	c.gridy = 0;
    	Label labelketqua = new Label("Kết quả:");
    	labelketqua.setPreferredSize(new Dimension(110, 25));
    	showresult = new JTextArea(5,18);
    	panel4.add(labelketqua,c);
    	c.gridx = 1;
    	c.gridy = 0;
    	c.gridwidth = 2;
    	panel4.add(showresult,c);
    	panel.add(panel4);
    	
    	JPanel panel5 = new JPanel();
    	panel5.setLayout(new GridLayout(1,3));
    	panel5.add(new JLabel());
    	JButton xoa = new JButton("Xóa");
    	xoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				nhapn.setText("");
				showresult.setText("");
			}
		});
    	panel5.add(xoa);
    	panel5.add(new JLabel());
    	panel.add(panel5);
    
    	container.add(panel);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==hienthi)
		{
			int n = Integer.parseInt(nhapn.getText());
			if(flag_in_de==1)
			{
				if(n%2==0)
				{
					String showres = "";
					for(int i=1;i<n;i++)
					{
						if(i%2==1)
						showres+=" "+i;
					}
					showresult.setText(showres);
				}
				else{
					String showres = "";
					for(int i=1;i<=n;i++)
					{
						if(i%2==1)
						showres+=" "+i;
					}
					showresult.setText(showres);
				}
			}
			else
			{
				if(n%2==0)
				{
					String showres = "";
					for(int i=n;i>=0;i--)
					{
						if(i%2==0)
						showres+=" "+i;
					}
					showresult.setText(showres);
				}
				else{
					String showres = "";
					for(int i=n;i>=0;i--)
					{
						if(i%2==0)
						showres+=" "+i;
					}
					showresult.setText(showres);
				}
			}
		}
		
		
	}
  
}
