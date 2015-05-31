package model.bean;

public class LietkeTien {
	private String makhachhang;
	private String tenkhachhang;
	private String diachikhachhang;
	private int tongtien;
	public LietkeTien(String makhachhang,String tenkhachhang,String diachikhachhang,int tongtien)
	{
		this.makhachhang = makhachhang;
		this.tenkhachhang = tenkhachhang;
		this.diachikhachhang = diachikhachhang;
		this.tongtien = tongtien;
	}
	
	public String getMakhachhang() {
		return makhachhang;
	}
	public void setMakhachhang(String makhachhang) {
		this.makhachhang = makhachhang;
	}
	public String getTenkhachhang() {
		return tenkhachhang;
	}
	public void setTenkhachhang(String tenkhachhang) {
		this.tenkhachhang = tenkhachhang;
	}
	public String getDiachikhachhang() {
		return diachikhachhang;
	}
	public void setDiachikhachhang(String diachikhachhang) {
		this.diachikhachhang = diachikhachhang;
	}
	public int getTongtien() {
		return tongtien;
	}
	public void setTongtien(int tongtien) {
		this.tongtien = tongtien;
	}
	
}
