package stub;


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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestJcombobox extends JFrame{
  Container container = getContentPane();
    public TestJcombobox(String title)
    {
    	super(title);
    	Label label = new Label("Hello");
    	container.add(label);
    	addButton();
    }
    public static void main(String arg[])
    {
    	  TestJcombobox test = new TestJcombobox("Day la title");
    	  test.setSize(400, 400);
    	  test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	  test.setLocationRelativeTo(null);
    	  test.setVisible(true);
    }
    public void addButton()
    {
    	JPanel panel = new JPanel();
    	panel.setLayout(new FlowLayout());
    	String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };

    	//Create the combo box, select item at index 4.
    	//Indices start at 0, so 4 specifies the pig.
    	JComboBox petList = new JComboBox(petStrings);
    	petList.setSelectedIndex(4);
    	petList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JComboBox cb = (JComboBox)e.getSource();
				String petName = (String)cb.getSelectedItem();
				System.out.println("petName:"+petName);
			}
		});
    	panel.add(petList);
    	
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
