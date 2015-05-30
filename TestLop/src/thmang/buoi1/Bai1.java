package thmang.buoi1;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Bai1 {
	public static void main(String [] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap chuoi:");
		String toantu=sc.nextLine();
		
		Socket socket=new Socket("Localhost",2500);
		DataInputStream din = new DataInputStream(socket.getInputStream());
		DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
		
		dout.writeUTF(toantu);
		String ketqua=din.readUTF();
		System.out.print(ketqua);
		
	}

}
