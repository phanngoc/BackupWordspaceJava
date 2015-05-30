package tranduythanh.com.model;

import java.util.ArrayList;

public class Lophoc {
	private String malop;
	private String tenlop;
	private int siso;
	private ArrayList<Sinhvien> list=new ArrayList<Sinhvien>();
	
	/**
	 * @return the list
	 */
	public ArrayList<Sinhvien> getList() {
		return list;
	}
	public boolean addSinhvien(Sinhvien sv)
	{
		return list.add(sv);
	}
	public Sinhvien findSinhvienById(String masinhvien)
	{
		for(Sinhvien s: list)
		{
			if(s.getMasinhvien().equalsIgnoreCase(masinhvien))
				return s;
		}
		return null;
	}
	public void removeSinhvien(String masinhvien)
	{
		Sinhvien sv=findSinhvienById(masinhvien);
		list.remove(sv);
	}
	/**
	 * @param list the list to set
	 */
	public void setList(ArrayList<Sinhvien> list) {
		this.list = list;
	}
	public Lophoc(String malop, String tenlop, int siso) {
		super();
		this.malop = malop;
		this.tenlop = tenlop;
		this.siso = siso;
	}
	public Lophoc() {
		super();
	}
	/**
	 * @return the malop
	 */
	public String getMalop() {
		return malop;
	}
	/**
	 * @param malop the malop to set
	 */
	public void setMalop(String malop) {
		this.malop = malop;
	}
	/**
	 * @return the tenlop
	 */
	public String getTenlop() {
		return tenlop;
	}
	/**
	 * @param tenlop the tenlop to set
	 */
	public void setTenlop(String tenlop) {
		this.tenlop = tenlop;
	}
	/**
	 * @return the siso
	 */
	public int getSiso() {
		return siso;
	}
	/**
	 * @param siso the siso to set
	 */
	public void setSiso(int siso) {
		this.siso = siso;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.tenlop +" ("+this.siso+")";
	}
}
