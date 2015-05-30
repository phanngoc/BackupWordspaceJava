package bom.test1;
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

public class Test5 extends JFrame implements ActionListener{

private static final long serialVersionUID = 1L;
JPanel pnFlow;
Label nghiem;
TextField nhapa;
TextField nhapb;
TextField nhapc;
float a,b,c,x1,x2;
public Test5(String title)
{
setTitle(title);

pnFlow=new JPanel();
FlowLayout layout = new FlowLayout();
layout.setAlignment(FlowLayout.CENTER);
pnFlow.setLayout(layout);

Label labela = new Label("Nhập a:");
pnFlow.add(labela);
nhapa = new TextField(10);
pnFlow.add(nhapa);
Label labelb = new Label("Nhập b:");
pnFlow.add(labelb);
nhapb = new TextField(10);
pnFlow.add(nhapb);
Label labelc = new Label("Nhập c:");
pnFlow.add(labelc);
nhapc = new TextField(10);
pnFlow.add(nhapc);

nghiem = new Label("------------------------------------------------------------");
pnFlow.add(nghiem);


JButton btn1=new JButton("Show");
btn1.addActionListener(this);
pnFlow.add(btn1);



Container con=getContentPane();
con.add(pnFlow);

}

public static void main(String[] args)
{

	Test5 myUI=new Test5("Giải phương trình bậc hai.");
	myUI.setSize(500, 400);
	myUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	myUI.setLocationRelativeTo(null);
	myUI.setVisible(true);

}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	System.out.println("event+"+e.getActionCommand());
	String label = e.getActionCommand();
	switch (label) {
	case "Show":
		a = Float.parseFloat(nhapa.getText());
		b = Float.parseFloat(nhapb.getText());
		c = Float.parseFloat(nhapc.getText());
		float delta = b*b-4*a*c;
		if(a==0)
		{
			nghiem.setText("Phương trình vô nghiệm");
			
		}
		if(delta < 0) nghiem.setText("Phương trình vô nghiệm");
		else if(delta==0)
		{
			x1 = x2 = -b/(2*a);
			nghiem.setText("Phương trình có nghiệm kép:x1=x2="+x1);
		}
		else if(delta>0)
		{
			x1 = (float) ((-b-Math.sqrt(delta))/(2*a));
			x2 = (float) ((-b+Math.sqrt(delta))/(2*a));
			nghiem.setText("Phương trình có nghiệm x1="+x1+" ,x2= "+x2);
		}
		break;

	default:
		break;
	}
}

}
