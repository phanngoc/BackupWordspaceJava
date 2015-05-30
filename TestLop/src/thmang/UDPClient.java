package thmang;

import java.net.*;
import java.util.Scanner;

public class UDPClient {
	public static void main(String [] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Nhap a=");
		double a=sc.nextDouble();
		System.out.print("Nhap b=");
		double b=sc.nextDouble();
		System.out.print("Nhap toan tu:");
		String toantu=sc.next();
		String chuoi=toantu+","+a+","+b;
		
		byte[] receiveData = new byte[1024]; 
		byte[] sendData=chuoi.getBytes();
		DatagramSocket soc = new DatagramSocket();
		InetAddress IP=InetAddress.getByName("localhost");
		int port=2500;
		DatagramPacket sendPac= new DatagramPacket(sendData,sendData.length,IP,port);
		soc.send(sendPac);
		DatagramPacket pac= new DatagramPacket(receiveData,receiveData.length);
		soc.receive(pac);
		String ketqua=new String(pac.getData()).substring(0,pac.getLength());
		System.out.println(ketqua);
	}
}
