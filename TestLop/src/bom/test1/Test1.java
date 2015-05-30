package bom.test1;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Test1 extends JFrame{
  Container container = getContentPane();
    public Test1(String title)
    {
    	super(title);
    	Label label = new Label("Hello");
    	container.add(label);
    	addButton();
    }
    public static void main(String arg[])
    {
    	  Test1 test = new Test1("Day la title");
    	  test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	  test.pack();
    	  test.setVisible(true);
    }
    public void addButton()
    {
    	JPanel panel = new JPanel();
    	panel.setLayout(new FlowLayout());
    	panel.setBackground(Color.PINK);
    	JButton button = new JButton("FlowLayout");
    	panel.add(button);
    	JButton button1 = new JButton("FlowLayout");
    	panel.add(button1);
    	JButton button2 = new JButton("FlowLayout");
    	panel.add(button2);
    	JButton button3 = new JButton("FlowLayout");
    	panel.add(button3);
    	
    	container.add(panel);
    }
    		
}
