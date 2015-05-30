package thmang.buoi2;


import java.net.*;

import thmang.xulychuoi;

public class Bai1Server {
	public static void main(String [] args) throws Exception
	{
		DatagramSocket soc=new DatagramSocket(2500);
		byte[] receiveData = new byte[1024]; 
		byte[] sendData;
		while(true)
		{
			DatagramPacket pac=new DatagramPacket(receiveData, receiveData.length);
			soc.receive(pac);
			String chuoi=new String(pac.getData()).substring(0,pac.getLength());
			
			String ketqua=xulychuoi.xuly(chuoi);
			
			sendData=ketqua.getBytes();
			InetAddress IPAddress = pac.getAddress(); 
			int port = pac.getPort(); 
			DatagramPacket sendpac=new DatagramPacket(sendData,sendData.length,IPAddress,port);
			soc.send(sendpac);
		}
	}

}
