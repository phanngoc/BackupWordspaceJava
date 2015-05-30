package ttnt;

import java.sql.Date;

public class Sinhvien {
   public int id;
   public String ten;
   public String lop;
   public int sbd;
   public Date ngaysinh;
   public Sinhvien(int id,String ten,String lop,int sbd,Date ngaysinh)
   {
	   this.id = id;
	   this.ten = ten;
	   this.lop = lop;
	   this.sbd = sbd;
	   this.ngaysinh = ngaysinh;
   }
}
