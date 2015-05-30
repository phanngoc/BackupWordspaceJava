package bom.test1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Xu_Ly_Chuoi {
	
	static String st="",stam;
	char[] ch;
	public String Doc_Chuoi() throws IOException
	{
		InputStreamReader gt = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(gt);
		String s = br.readLine();
		return s;
	}

	public void Dao(){
		for(int i=stam.length()-1;i>=0;i--){
			System.out.print(stam.charAt(i));
		}
	}
	
	public void chuyen(){
		ch = st.toCharArray();
		System.out.println("chuoi sau khi chuyen: ");
		for(int i=0;i<ch.length;i++){
			if(ch[i]>='A' && ch[i] <= 'Z'){
				ch[i]+=32;
			}
			else{
				if(ch[i]>='a' && ch[i] <= 'z'){
					ch[i]-=32;
				}
			}
			System.out.print(ch[i]);
		}
		
	}
	public static void main(String[] args) {
		
		Xu_Ly_Chuoi dt = new Xu_Ly_Chuoi();
		System.out.print("\nNhap chuoi: ");
		try{
			st=dt.Doc_Chuoi();
		}catch(Exception e){
			System.out.println("Error "+e);
		}
		stam = st;
		dt.Dao();
		System.out.println("\nChuoi in hoa: "+ stam.toUpperCase());
		stam = st;
		System.out.println("Chuoi dang chu thuong: "+ stam.toLowerCase());
		dt.chuyen();
	}

}

