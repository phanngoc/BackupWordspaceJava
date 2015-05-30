package thmang;

import java.util.Scanner;

public class xulychuoi {
	public static String xuly(String ch){
		String r="";
		ch=ch+",";
		try{
			String[] a= new String[3];
			int count=0;
			do{
				int i=ch.indexOf(",");
				a[count++]=ch.substring(0, i);
				ch=ch.substring(i+1);
				
			} while (count<3);
			if (!(a[0].equals("Cong") || a[0].equals("Tru") ||
					a[0].equals("Nhan") || a[0].equals("Chia")) 
					)
				r="Error!";
			else{
				double x=Double.parseDouble(a[1]);
				double y=Double.parseDouble(a[2]);
				
				if (a[0].equals("Cong"))
					r=""+(x+y);
				else if (a[0].equals("Tru"))
					r=""+(x-y);
				else if (a[0].equals("Nhan"))
					r=""+(x*y);
				else if (a[0].equals("Chia"))
					if (y==0) r="Error";
					else 
						r=""+(x/y);
			}
			
		}catch(Exception e){
			r="Error!";
		}
		return r;
	}
	
	public static void main(String []args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Nhap a=");
		double a=sc.nextDouble();
		System.out.print("Nhap b=");
		double b=sc.nextDouble();
		System.out.print("Nhap toan tu:");
		String toantu=sc.next();
		
		String ketqua=xuly(toantu+","+a+","+b);
		System.out.print(ketqua);
	}
}


