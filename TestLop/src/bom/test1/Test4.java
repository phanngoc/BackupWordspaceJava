package bom.test1;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test4 extends JFrame implements ActionListener{

private static final long serialVersionUID = 1L;
JPanel pnFlow;
TextField field;
public Test4(String title)
{
setTitle(title);

pnFlow=new JPanel();

GridBagLayout layout = new GridBagLayout();

pnFlow.setLayout(layout);  
CheckboxGroup group = new CheckboxGroup();
Checkbox check1 = new Checkbox("Male", group, false);
Checkbox check2 = new Checkbox("Female", group, false);
ItemListener listener = new ItemListener() {
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		Checkbox check = (Checkbox)e.getSource();
        field.setText(check.getLabel());
	}
};
check1.addItemListener(listener);
check2.addItemListener(listener);


GridBagConstraints gbc = new GridBagConstraints();

gbc.fill = GridBagConstraints.BOTH;
gbc.gridx = 0;
gbc.gridy = 0;
pnFlow.add(check1,gbc);

gbc.gridx = 1;
gbc.gridy = 0;
pnFlow.add(check2,gbc); 

gbc.fill = GridBagConstraints.BOTH;
List li = new List(3);
li.add("MSDOC");
li.add("WINDOW");
li.add("LINUX");

gbc.fill = GridBagConstraints.BOTH; 
gbc.gridx = 0;
gbc.gridy = 1;
gbc.gridwidth = 2;
pnFlow.add(li,gbc); 

ItemListener listener1 = new ItemListener() {
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		List check = (List)e.getSource();
        field.setText(check.getSelectedItem());
	}
};
li.addItemListener(listener1);

String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };

//Create the combo box, select item at index 4.
//Indices start at 0, so 4 specifies the pig.
JComboBox petList = new JComboBox(petStrings);
gbc.fill = GridBagConstraints.BOTH;  
gbc.gridx = 0;
gbc.gridy = 2;
gbc.gridwidth = 2;
petList.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		  JComboBox cb = (JComboBox)e.getSource();
	      String petName = (String)cb.getSelectedItem();
		  System.out.println(petName);
	      field.setText(""+petName);
	}
});
pnFlow.add(petList,gbc);


field = new TextField("The item is display here.");
gbc.fill = GridBagConstraints.BOTH;   
gbc.gridx = 0;
gbc.gridy = 3;
gbc.gridwidth = 1;
pnFlow.add(field,gbc);

JButton btn1=new JButton("Exit");
btn1.addActionListener(this);
gbc.fill = GridBagConstraints.BOTH; 
gbc.gridx = 1;
gbc.gridy = 3;
gbc.gridwidth = 1;
pnFlow.add(btn1,gbc);


Container con=getContentPane();
con.add(pnFlow);

}

public static void main(String[] args)
{

	Test4 myUI=new Test4("Minh hoa kieu su kien Itemevent");
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