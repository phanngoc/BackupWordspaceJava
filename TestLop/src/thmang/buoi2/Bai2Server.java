package thmang.buoi2;
import java.io.*;
import java.net.*;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import thmang.xulychuoi;

public class Bai2Server {
	public static void main(String [] args) throws IOException
	{

		while (true){
		
			(new ThreadXuly1()).start();

		}
	}
	public static String evalExpression(String s)
	{
		ScriptEngineManager manager = new ScriptEngineManager();
		Object result = "";
		try {
			result = manager.getEngineByName("js").eval(s);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
	    
	    return result.toString();
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
}

class ThreadXuly1 extends Thread{
	Socket socket;
	public ThreadXuly1(){

	}
	public void run(){
		try{
			
			DatagramSocket soc=new DatagramSocket(2500);
			byte[] receiveData = new byte[1024]; 
			byte[] sendData;
			while(true)
			{
				DatagramPacket pac=new DatagramPacket(receiveData, receiveData.length);
				soc.receive(pac);
				String chuoi=new String(pac.getData()).substring(0,pac.getLength());
				
				String ketqua = Bai2Server.evalExpression(chuoi);
				
				sendData=ketqua.getBytes();
				InetAddress IPAddress = pac.getAddress(); 
				int port = pac.getPort(); 
				DatagramPacket sendpac=new DatagramPacket(sendData,sendData.length,IPAddress,port);
				soc.send(sendpac);
			}
		
		}catch(IOException e){}
	}
}

