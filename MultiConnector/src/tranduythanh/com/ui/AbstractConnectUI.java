package tranduythanh.com.ui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import tranduythanh.com.connector.CConnector;
import tranduythanh.com.model.Lophoc;
import tranduythanh.com.model.Sinhvien;


public abstract class  AbstractConnectUI extends AbstractUI{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static JList lstData;
	protected JTable tblData;
	protected DefaultTableModel dtmData;
	protected JButton btnXoaLop,btnThemLop,btnSuaLop,btnThemSinhvien,btnLuuSinhvien,btnXoaSinhvien;
	protected JTextField txtMasinhvien,txtTenSinhvien,txtNgaysinh,txtThangsinh,txtNamsinh;
	protected JTextArea txtDiachi;
	protected static JComboBox cboDanhsachlop;
	protected static ArrayList<Lophoc> listLophoc;
	protected static ArrayList<Sinhvien> listSinhvien;
	protected static Lophoc lophocSelected;
	protected static Sinhvien sinhvienSelected;
	protected CConnector m_connector;
	public AbstractConnectUI(String title)
	{
		super(title);
	}
	public AbstractConnectUI()
	{
		super("Default ...");
	}
	@Override
	public void addControl() {
		// TODO Auto-generated method stub
		JPanel pnBorder=new JPanel();
		pnBorder.setLayout(new BorderLayout());
		JPanel pnNorth=new JPanel();
		JLabel lblTitle=new JLabel("Quản lý Sinh Viên - Lớp Học");
		Font ftTitle=new Font("arial", Font.BOLD, 32);
		lblTitle.setFont(ftTitle);
		lblTitle.setForeground(Color.BLUE);
		pnNorth.add(lblTitle);
		pnBorder.add(pnNorth,BorderLayout.NORTH);
		
		JPanel pnListLop=new JPanel();
		JPanel pnListSinhvien=new JPanel();
		JSplitPane slitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnListLop, pnListSinhvien);
		pnBorder.add(slitPane,BorderLayout.CENTER);
		pnListLop.setLayout(new BorderLayout());
		lstData=new JList();
		TitledBorder cateborder=new TitledBorder(BorderFactory.createLineBorder(Color.RED), "Danh sách lớp học");
		pnListLop.setBorder(cateborder);
		pnListLop.setPreferredSize(new Dimension(300, 0));
		pnListLop.add(lstData,BorderLayout.CENTER);
		JPanel pnListLopSouth=new JPanel();
		btnThemLop =new JButton("Thêm lớp");
		pnListLopSouth.add(btnThemLop);
		btnSuaLop =new JButton("Sửa lớp");
		pnListLopSouth.add(btnSuaLop);
		btnXoaLop =new JButton("Xóa lớp");
		pnListLopSouth.add(btnXoaLop);
		pnListLop.add(pnListLopSouth,BorderLayout.SOUTH);
		
		pnListSinhvien.setLayout(new BorderLayout());
		JPanel pnSinhvienTitle=new JPanel();
		JLabel lblSinhvienTitle=new JLabel("Thông tin chi tiết");
		pnSinhvienTitle.add(lblSinhvienTitle);
		pnListSinhvien.add(pnSinhvienTitle,BorderLayout.NORTH);
		JPanel pnSinhvienTable=new JPanel();
		pnSinhvienTable.setLayout(new BorderLayout());
		pnListSinhvien.add(pnSinhvienTable,BorderLayout.CENTER);
		dtmData =new DefaultTableModel();
		dtmData.addColumn("Mã Sinh Viên");
		dtmData.addColumn("Tên Sinh Viên");
		dtmData.addColumn("Ngày Sinh");
		dtmData.addColumn("Lớp");
		dtmData.addColumn("Địa chỉ");
		tblData=new JTable(dtmData);
		JScrollPane sctblsinhvien=new JScrollPane(tblData);
		pnSinhvienTable.add(sctblsinhvien,BorderLayout.CENTER);
		JPanel pnSinhvienDetail=new JPanel();
		pnListSinhvien.add(pnSinhvienDetail,BorderLayout.SOUTH);
		pnSinhvienDetail.setLayout(new BoxLayout(pnSinhvienDetail, BoxLayout.Y_AXIS ));
		
		JPanel pnLopList=new JPanel();
		JLabel lblLopId=new JLabel("Lớp học :");
		cboDanhsachlop=new JComboBox();
		pnLopList.add(lblLopId);
		pnLopList.add(cboDanhsachlop);
		pnSinhvienDetail.add(pnLopList);
		
		JPanel pnSinhvienId=new JPanel();
		JLabel lblSinhvienId=new JLabel("Mã sinh viên:");
		txtMasinhvien=new JTextField(20);
		pnSinhvienId.add(lblSinhvienId);
		pnSinhvienId.add(txtMasinhvien);
		pnSinhvienDetail.add(pnSinhvienId);
		
		JPanel pnSinhvienName=new JPanel();
		JLabel lblSinhvienName=new JLabel("Tên sinh viên:");
		txtTenSinhvien=new JTextField(20);
		pnSinhvienName.add(lblSinhvienName);
		pnSinhvienName.add(txtTenSinhvien);
		pnSinhvienDetail.add(pnSinhvienName);
		
		JPanel pnNgaysinh=new JPanel();
		JLabel lblNgaysinh=new JLabel("Ngày Sinh: ");
		txtNgaysinh=new JTextField(3);
		txtThangsinh=new JTextField(3);
		txtNamsinh=new JTextField(4);
		pnNgaysinh.add(lblNgaysinh);
		JPanel pnNgaySinhChitiet=new JPanel();
		pnNgaySinhChitiet.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnNgaySinhChitiet.add(txtNgaysinh);
		pnNgaySinhChitiet.add(txtThangsinh);
		pnNgaySinhChitiet.add(txtNamsinh);
		JLabel lblNtnsFormat=new JLabel("(dd-mm-yyyy)");
		lblNtnsFormat.setFont(new Font("arial",Font.ITALIC,10));
		pnNgaySinhChitiet.add(lblNtnsFormat);
		pnNgaysinh.add(pnNgaySinhChitiet);
		pnSinhvienDetail.add(pnNgaysinh);
		
		JPanel pnSinhvienDescription=new JPanel();
		JLabel lblDescription=new JLabel("Địa chỉ:");
		txtDiachi=new JTextArea(4, 20);
		JScrollPane scare=new JScrollPane(txtDiachi);
		pnSinhvienDescription.add(lblDescription);
		pnSinhvienDescription.add(scare);
		pnSinhvienDetail.add(pnSinhvienDescription);
		
		JPanel pnButton=new JPanel();
		btnThemSinhvien=new JButton("Thêm SV");
		btnLuuSinhvien=new JButton("Lưu SV");
		btnXoaSinhvien=new JButton("Xóa SV");
		
		pnButton.add(btnThemSinhvien);
		pnButton.add(btnLuuSinhvien);
		pnButton.add(btnXoaSinhvien);
		pnSinhvienDetail.add(pnButton);
		cboDanhsachlop.setPreferredSize(txtMasinhvien.getPreferredSize());
		lblLopId.setPreferredSize(lblSinhvienName.getPreferredSize());
		lblDescription.setPreferredSize(lblSinhvienName.getPreferredSize());
		lblNgaysinh.setPreferredSize(lblSinhvienName.getPreferredSize());
		lblSinhvienId.setPreferredSize(lblSinhvienName.getPreferredSize());
		
		Container con=getContentPane();
		con.add(pnBorder);
		
		lstData.addListSelectionListener(new ProcessEvent());
		tblData.addMouseListener(new ProcessEvent());
	}

	@Override
	public void doActionControl(Object o) {
		// TODO Auto-generated method stub
		if(o.equals(lstData))
		{
			showLopAndSinhvien();
		}
		else if(o.equals(tblData))
		{
			showChitietSinhvien();
		}
	}
	private class ProcessEvent implements ListSelectionListener,MouseListener
	{

		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			// TODO Auto-generated method stub
			doActionControl(arg0.getSource());
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			doActionControl(e.getSource());	
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	@Override
	public void doOwnerWindowFeature() {
		// TODO Auto-generated method stub
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
	}
	public abstract ArrayList<Lophoc> getListLop();
	public abstract ArrayList<Sinhvien> getListSinhvienByIdLop(String malop);
	public void showLopAndSinhvien()
	{
		Lophoc lh=(Lophoc ) lstData.getSelectedValue();
		listSinhvien= getListSinhvienByIdLop(lh.getMalop());
		lh.setList(listSinhvien);
		lophocSelected=lh;
		showListSinhvienIntoTable();
	}
	public void showListSinhvienIntoTable()
	{
		dtmData.setRowCount(0);
		for(Sinhvien s: lophocSelected.getList())
		{
			Vector<String> vec=new Vector<String>();
			vec.add(s.getMasinhvien());
			vec.add(s.getHoten());
			vec.add(s.getNamsinh().getDate()+"/"+(s.getNamsinh().getMonth()+1)+"/"+(s.getNamsinh().getYear()+1900));
			vec.add(s.getMalop());
			vec.add(s.getDiachi());
			dtmData.addRow(vec);
		} 
	}
	public void showChitietSinhvien()
	{
		int row=tblData.getSelectedRow();
		sinhvienSelected =listSinhvien.get(row);
		txtMasinhvien.setText(sinhvienSelected.getMasinhvien());
		txtTenSinhvien.setText(sinhvienSelected.getHoten());
		txtDiachi.setText(sinhvienSelected.getDiachi());
		txtNgaysinh.setText(sinhvienSelected.getNamsinh().getDate()+"");
		txtThangsinh.setText((sinhvienSelected.getNamsinh().getMonth()+1)+"");
		txtNamsinh.setText((sinhvienSelected.getNamsinh().getYear()+1900)+"");
		cboDanhsachlop.setSelectedItem(lophocSelected);
	}
	public void updateLopList()
	{
		lstData.removeAll();
		ArrayList<Lophoc> listlop=getListLop();
		lstData.setListData(listlop.toArray());
		lstData.updateUI();
		cboDanhsachlop.removeAllItems();
		for(Lophoc lh : listlop)
		{
			cboDanhsachlop.addItem(lh);
		}
	}
	public void doComboboxSelected()
	{
		lophocSelected=(Lophoc) cboDanhsachlop.getSelectedItem();
	}
}
