package ttnt;

import java.sql.Date;

public class Ca {
   public int id;
   public int thoigiandau;
   public int thoigiancuoi;
   public Date ngay;
   public Ca(int id,int thoigiandau,int thoigiancuoi,Date ngay)
   {
	   this.id = id;
	   this.thoigiandau = thoigiandau;
	   this.thoigiancuoi = thoigiancuoi;
	   this.ngay = ngay;
   }
}
