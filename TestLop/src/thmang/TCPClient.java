package thmang;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPClient {
	public static void main(String [] args) throws IOException
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Nhap a=");
		double a=sc.nextDouble();
		System.out.print("Nhap b=");
		double b=sc.nextDouble();
		System.out.print("Nhap toan tu:");
		String toantu=sc.next();
		
		Socket socket=new Socket("Localhost",2500);
		DataInputStream din = new DataInputStream(socket.getInputStream());
		DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
		
		dout.writeUTF(toantu+","+a+","+b);
		String ketqua=din.readUTF();
		System.out.print(ketqua);
		
	}

}
