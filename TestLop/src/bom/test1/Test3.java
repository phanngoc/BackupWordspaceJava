package bom.test1;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test3 extends JFrame implements ActionListener{

private static final long serialVersionUID = 1L;
JPanel pnFlow;
public Test3(String title)

{

setTitle(title);

pnFlow=new JPanel();

pnFlow.setLayout(new FlowLayout());


JButton btn1=new JButton("Green");

JButton btn2=new JButton("Blue");

JButton btn3=new JButton("Red");

JButton btn4=new JButton("Exit");

btn1.addActionListener(this);
btn2.addActionListener(this);
btn3.addActionListener(this);
btn4.addActionListener(this);

pnFlow.add(btn1);
pnFlow.add(btn2);
pnFlow.add(btn3);
pnFlow.add(btn4);


Container con=getContentPane();
con.add(pnFlow);

}

public static void main(String[] args)

{

	Test3 myUI=new Test3("Demo");
	myUI.setSize(600, 400);
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
	case "Green":
		pnFlow.setBackground(Color.GREEN);
		break;
	case "Blue":
		pnFlow.setBackground(Color.BLUE);
		break;
	case "Red":
		pnFlow.setBackground(Color.RED);
		break;	
	case "Exit":
		System.exit(0);
		break;	
	default:
		break;
	}
}

}