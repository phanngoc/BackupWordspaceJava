package tranduythanh.com.model;

import java.sql.Date;

public class Sinhvien {
	private String masinhvien;
	private String malop;
	private String hoten;
	private Date namsinh;
	private String diachi;
	/**
	 * @return the masinhvien
	 */
	public String getMasinhvien() {
		return masinhvien;
	}
	/**
	 * @param masinhvien the masinhvien to set
	 */
	public void setMasinhvien(String masinhvien) {
		this.masinhvien = masinhvien;
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
	 * @return the hoten
	 */
	public String getHoten() {
		return hoten;
	}
	/**
	 * @param hoten the hoten to set
	 */
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	/**
	 * @return the namsinh
	 */
	public Date getNamsinh() {
		return namsinh;
	}
	/**
	 * @param namsinh the namsinh to set
	 */
	public void setNamsinh(Date namsinh) {
		this.namsinh = namsinh;
	}
	/**
	 * @return the diachi
	 */
	public String getDiachi() {
		return diachi;
	}
	/**
	 * @param diachi the diachi to set
	 */
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public Sinhvien(String masinhvien, String malop, String hoten,
			Date namsinh, String diachi) {
		super();
		this.masinhvien = masinhvien;
		this.malop = malop;
		this.hoten = hoten;
		this.namsinh = namsinh;
		this.diachi = diachi;
	}
	public Sinhvien() {
		super();
	}
	public Sinhvien(String masinhvien, String hoten, Date namsinh, String diachi) {
		super();
		this.masinhvien = masinhvien;
		this.hoten = hoten;
		this.namsinh = namsinh;
		this.diachi = diachi;
	}
	
}
