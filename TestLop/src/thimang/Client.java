package thimang;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
	public static void main(String [] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap chuoi:");
		String vacxin=sc.nextLine();
		
		Socket socket=new Socket("Localhost",2500);
		DataInputStream din = new DataInputStream(socket.getInputStream());
		DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
		
		dout.writeUTF(vacxin);
		String ketqua=din.readUTF();
		System.out.print(ketqua);
		
	}

}
