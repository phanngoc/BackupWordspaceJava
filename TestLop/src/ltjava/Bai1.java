package ltjava;


import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bai1 extends JFrame{
  Container container = getContentPane();
    public Bai1(String title)
    {
    	super(title);
    	Label label = new Label("Hello");
    	container.add(label);
    	addButton();
    }
    public static void main(String arg[])
    {
    	  Bai1 test = new Bai1("Day la title");
    	  test.setSize(400, 400);
    	  test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	  test.setLocationRelativeTo(null);
    	  test.setVisible(true);
    }
    public void addButton()
    {
    	JPanel panel = new JPanel();
    	panel.setLayout(new FlowLayout());
    	
    	JPanel panel1 = new JPanel();
    	Label canha = new Label("Độ dài cạnh a:");
    	panel1.add(canha);
    	final TextField texta = new TextField(22);
    	panel1.add(texta);
    	panel.add(panel1);
    	JPanel panel2 = new JPanel();
    	Label canhb = new Label("Độ dài cạnh b:");
    	panel2.add(canhb);
    	final TextField textb = new TextField(22);
    	panel2.add(textb);
    	panel.add(panel2);
    	
    	JPanel panel3 = new JPanel();
    	Label canhc = new Label("Độ dài cạnh b:");
    	panel3.add(canhc);
    	final TextField textc = new TextField(22);
    	panel3.add(textc);
    	panel.add(panel3);
    	
    	JPanel panel4 = new JPanel();
    	Label blank = new Label("");
    	blank.setPreferredSize(new Dimension(110, 25));
    	Button tinhdientich = new Button("Tính diện tích");
    	tinhdientich.setPreferredSize(new Dimension(180, 25));
    	panel4.add(blank);
    	panel4.add(tinhdientich);
    	panel.add(panel4);
    	
    	JPanel panel5 = new JPanel();
    	Label blank1 = new Label("");
    	blank1.setPreferredSize(new Dimension(110, 25));
    	Button tinhchuvi = new Button("Tính chu vi");
    	tinhchuvi.setPreferredSize(new Dimension(180, 25));
    	panel5.add(blank1);
    	panel5.add(tinhchuvi);
    	panel.add(panel5);
    	
    	JPanel panel6 = new JPanel();
    	Label kq = new Label("Kết quả:");
    	panel6.add(kq);
    	final TextField kqtext = new TextField(22);
    	panel6.add(kqtext);
    	panel.add(panel6);
    	
    	
    	tinhdientich.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				float a = Float.parseFloat(texta.getText());
				float b = Float.parseFloat(textb.getText());
				float c = Float.parseFloat(textc.getText());
				float p = (a+b+c)/2;
				float s = (float)Math.sqrt(p*(p-a)*(p-b)*(p-c));
				if(kiemtra(a,b,c))
				{
					kqtext.setText(s+"");
				}
				else
				{
					kqtext.setText("Day khong phai tam giac");
				}
				
			}
		});
    	
    	tinhchuvi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				float a = Float.parseFloat(texta.getText());
				float b = Float.parseFloat(textb.getText());
				float c = Float.parseFloat(textc.getText());
				float p = a+b+c;
				if(kiemtra(a,b,c))
				{
					kqtext.setText(p+"");
				}
				else
				{
					kqtext.setText("Day khong phai tam giac");
				}
			}
		});
    	container.add(panel);
    }
    public boolean kiemtra(float a,float b,float c)
    {
      if((a+b)>c&&(b+c)>a&&(c+a)>b)
      {
    	  return true;
      }
      else
      {
    	  return false;
      }
    }
}
