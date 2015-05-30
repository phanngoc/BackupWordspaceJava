package thmang.buoi2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Bai2Client {
	public static void main(String [] args) throws IOException
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Nhap chuoi:");
		String toantu=sc.nextLine();
		byte[] receiveData = new byte[1024]; 
		DatagramSocket soc = new DatagramSocket();
		InetAddress IP=InetAddress.getByName("localhost");
		int port=2500;
		DatagramPacket sendPac= new DatagramPacket(toantu.getBytes(),toantu.length(),IP,port);
		soc.send(sendPac);
		DatagramPacket pac= new DatagramPacket(receiveData,receiveData.length);
		soc.receive(pac);
		String ketqua=new String(pac.getData()).substring(0,pac.getLength());
		System.out.println(ketqua);
		
	}

}
