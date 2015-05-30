package thmang.buoi1;
import java.io.*;
import java.net.*;
public class Bai1Server {
	public static void main(String [] args) throws IOException
	{
		ServerSocket server=new ServerSocket(2500);
		while (true){
			Socket socket=server.accept();
			(new ThreadXuly(socket)).start();
		}
	}
	public static String convertToLower(String s)
	{
		return s.toLowerCase();
	}
	public static String convertToUpcase(String s)
	{
		return s.toUpperCase();
	}
	public static int countNumberWord(String s)
	{
		 String[] strs = s.split(" ");
	     return strs.length;  
	     
	}
	public static int wordcount(String s)
    {
		int c = 0;
        char ch[]= new char[s.length()]; 
        for(int i=0;i<s.length();i++)
        {
            ch[i]= s.charAt(i);
            if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)) )
            c++;
        }
        return c;
    }
}

class ThreadXuly extends Thread{
	Socket socket;
	public ThreadXuly(Socket s){
		this.socket=s;
	}
	public void run(){
		try{
			DataInputStream din = new DataInputStream(socket.getInputStream());
			String chuoi = din.readUTF();
			
			String ketqua_inthuong = "Chuyen sang dang in hoa:"+Bai1Server.convertToUpcase(chuoi)+"|";
			String ketqua_inhoa = "Chuyen sang danh in thuong:"+Bai1Server.convertToLower(chuoi)+"|";
			String so_tu = "So tu :"+Bai1Server.wordcount(chuoi);
			String ketqua_final = ketqua_inthuong+ketqua_inhoa+so_tu;
			DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
			dout.writeUTF(ketqua_final);
			socket.close();
		}catch(IOException e){}
	}
}

