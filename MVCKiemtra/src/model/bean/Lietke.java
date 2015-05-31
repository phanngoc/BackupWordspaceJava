package model.bean;

public class Lietke {
	private String makhachhang;
	private String tenkhachhang;
	private String tenbenh;
	private String mavacxin;
	private String tenvacxin;
	private int tongsomui;
	public Lietke(String makhachhang,String tenkhachhang,String tenbenh,String mavacxin,String tenvacxin,int tongsomui)
	{
		this.makhachhang = makhachhang;
		this.tenkhachhang = tenkhachhang;
		this.tenbenh = tenbenh;
		this.mavacxin = mavacxin;
		this.tenvacxin = tenvacxin;
		this.tongsomui = tongsomui;
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
	public String getTenbenh() {
		return tenbenh;
	}
	public void setTenbenh(String tenbenh) {
		this.tenbenh = tenbenh;
	}
	public String getMavacxin() {
		return mavacxin;
	}
	public void setMavacxin(String mavacxin) {
		this.mavacxin = mavacxin;
	}
	public String getTenvacxin() {
		return tenvacxin;
	}
	public void setTenvacxin(String tenvacxin) {
		this.tenvacxin = tenvacxin;
	}
	public int getTongsomui() {
		return tongsomui;
	}
	public void setTongsomui(int tongsomui) {
		this.tongsomui = tongsomui;
	}
}
