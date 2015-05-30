package tranduythanh.com.ui;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class AbstractUI extends JFrame {

	private static final long serialVersionUID = 1L;
	public AbstractUI(String title)
	{
		super(title);
	}
	public AbstractUI()
	{
		super("Default ...");
	}
	public void doShow()
	{
		addControl();
		addEventForAllControl();
		doOwnerWindowFeature();
		setVisible(true);
	}
	private void processJpanel(JPanel pn)
	{
		for(Component cp : pn.getComponents())
		{
			if(cp instanceof JButton)
			{
				((JButton) cp).addActionListener(new ProcessEvent());
			}
			else if(cp instanceof JPanel)
			{
				processJpanel((JPanel)cp);
			}
		}
	}
	public void addEventForAllControl()
	{
		Container con=getContentPane();
		for(Component cp: con.getComponents())
		{
			if(cp instanceof JPanel)
			{
				processJpanel((JPanel)cp);
			}
		}
	}
	public abstract void addControl();
	public abstract void doActionControl(Object o);
	public abstract void doOwnerWindowFeature();
	private class ProcessEvent implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			doActionControl(arg0.getSource());
		}
	}
}
