package tranduythanh.com.ui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class MainUI extends AbstractUI{
	
	private static final long serialVersionUID = 1L;
	JButton btnMsAcces,btnSqlServer,btnMysql,btnShutdown;
	public MainUI(String title)
	{
		super(title);
	}
	public void addControl()
	{
		JPanel pnButton=new JPanel();
		TitledBorder bor1=new TitledBorder(BorderFactory.createEtchedBorder(Color.RED, Color.BLUE), "Chọn loại kết nối");
		pnButton.setBorder(bor1);
		
		JPanel pnAccess=new JPanel();
		pnAccess.setLayout(new BoxLayout(pnAccess, BoxLayout.Y_AXIS));
		ImageIcon icon=new ImageIcon("images/ms-access.png");
		btnMsAcces=new JButton();
		btnMsAcces.setIcon(icon);
		pnAccess.add(btnMsAcces);
		JLabel lblAccess=new JLabel("Ms Access");
		pnAccess.add(lblAccess);
		pnButton.add(pnAccess);
		
		JPanel pnSqlServer=new JPanel();
		pnSqlServer.setLayout(new BoxLayout(pnSqlServer, BoxLayout.Y_AXIS));
		icon=new ImageIcon("images/sqlserver.png");
		btnSqlServer=new JButton();
		btnSqlServer.setIcon(icon);
		pnSqlServer.add(btnSqlServer);
		JLabel lblSqlServer=new JLabel("Sql Server");
		pnSqlServer.add(lblSqlServer);
		pnButton.add(pnSqlServer);
		
		JPanel pnMysql=new JPanel();
		pnMysql.setLayout(new BoxLayout(pnMysql, BoxLayout.Y_AXIS));
		icon=new ImageIcon("images/mysql.png");
		btnMysql=new JButton();
		btnMysql.setIcon(icon);
		pnMysql.add(btnMysql);
		JLabel lblMysql=new JLabel("My Sql");
		pnMysql.add(lblMysql);
		pnButton.add(pnMysql);

		Container con=getContentPane();
		con.setLayout(new BorderLayout());
		con.add(pnButton,BorderLayout.CENTER);
		btnShutdown=new JButton();
		icon=new ImageIcon("images/shutdown.png");
		btnShutdown.setIcon(icon);
		JPanel pnShutdown=new JPanel();
		pnShutdown.setBackground(Color.PINK);
		pnShutdown.add(btnShutdown);
		TitledBorder bor2=new TitledBorder(BorderFactory.createEtchedBorder(Color.RED, Color.BLUE), "Thoát khỏi chương trình");
		bor2.setTitleColor(Color.BLUE);
		bor2.setTitleJustification(TitledBorder.RIGHT);
		pnShutdown.setBorder(bor2);
		con.add(pnShutdown,BorderLayout.SOUTH);
		
		btnMsAcces.setToolTipText("Click vào đây để kết nối tới CSDL MS Access!");
		btnSqlServer.setToolTipText("Click vào đây để kết nối tới CSDL SQL Server!");
		btnMysql.setToolTipText("Click vào đây để kết nối tới CSDL My SQL!");
		btnShutdown.setToolTipText("Click vào đây để thoát chương trình!");
		
	}
	
	@Override
	public void doActionControl(Object o) {
		if(o.equals(btnMsAcces))
		{
			JOptionPane.showMessageDialog(null, "MS Access");
			ConnectMsAccessUI msAccessUI=new ConnectMsAccessUI("MS Access Demo");
			msAccessUI.doShow();
		}
		else if(o.equals(btnMysql))
		{
			JOptionPane.showMessageDialog(null, "MySQL");
			ConnectMySqlUI mysqlUI=new ConnectMySqlUI("MySQl Demo");
			mysqlUI.doShow();
		}
		else if(o.equals(btnSqlServer))
		{
			JOptionPane.showMessageDialog(null, "MS SqlServer");
			ConnectSqlServerUI ui=new ConnectSqlServerUI("SQL server");
			ui.doShow();
		}
		else if(o.equals(btnShutdown))
		{
			int ret=JOptionPane.showConfirmDialog(this, "Muốnt thoát hả?","Thoát",JOptionPane.YES_NO_OPTION);
			if(ret==JOptionPane.YES_OPTION)
			{
				System.exit(0);
			}
		}
	}
	public static void main(String[] args) {
		MainUI ui=new MainUI("Demo Kết nối nhiều CSDL");
		ui.doShow();
	}
	@Override
	public void doOwnerWindowFeature() {
		// TODO Auto-generated method stub
		setSize(400, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}

}
