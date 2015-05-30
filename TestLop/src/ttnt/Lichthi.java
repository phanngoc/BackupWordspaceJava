package ttnt;

import java.sql.Date;

public class Lichthi {
   public int id;
   public Sinhvien sinhvien;
   public Caphong caphong;
   public Lichthi(int id,Sinhvien sinhvien,Caphong ca)
   {
	   this.id = id;
	   this.sinhvien = sinhvien;
	   this.caphong = ca;
   }
}
