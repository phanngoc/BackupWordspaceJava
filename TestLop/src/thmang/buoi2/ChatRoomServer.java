package thmang.buoi2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;


public class ChatRoomServer {

	public Vector<ThreadedHandler1> cls=new Vector<ThreadedHandler1>();
	
	public ChatRoomServer(){
		System.out.println("Vao duoc khoi tao");
		
	try {
		    DatagramSocket soc = new DatagramSocket(2500);
				while(true)
				{
					byte[] receiveData = new byte[1024]; 
					InetAddress IP = InetAddress.getByName("localhost");
					int port=2500;
					DatagramPacket pac=new DatagramPacket(receiveData,receiveData.length,IP,port);
					soc.receive(pac);
					String ch = new String(pac.getData()).substring(0,pac.getLength());
					if(ch.equals(""))
					{
						continue;
					}
					new ThreadedHandler1(this,soc).start();
			}
			
			
		}catch (IOException e) {
		  System.err.println(e);
		}
	}
	
	public static void main(String[] args) {
		new ChatRoomServer();
	}
	public class ThreadedHandler1 extends Thread{
		ChatRoomServer crsv;
		public DatagramSocket socthread;
		public String name;
		public ThreadedHandler1(ChatRoomServer crsv, DatagramSocket i)
		{
			this.crsv=crsv;
			this.socthread = i;
		}
		public void writeBelow(String res)
		{
			byte[] sendData = res.getBytes();
			InetAddress IP;
			System.out.println("viet res:");
			try {
				IP = InetAddress.getByName("localhost");
				int port=2500;
				DatagramPacket sendpac=new DatagramPacket(sendData,sendData.length,IP,port);
				socthread.send(sendpac);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public void run(){
			
			try{
				byte[] receiveData = new byte[1024]; 
				InetAddress IP = InetAddress.getByName("localhost");
				int port=2500;
				while(true)
				{
					DatagramPacket pac=new DatagramPacket(receiveData,receiveData.length,IP,port);
					this.socthread.receive(pac);
					String ch = new String(pac.getData()).substring(0,pac.getLength());
					if(ch.equals(""))
					{
						continue;
					}
					String cmd=ch.substring(0, ch.indexOf(","));
					String msg=ch.substring(ch.indexOf(",")+1);
				
					System.out.println("Hello "+msg+"|"+cmd+"|"+this.crsv.cls.size());
					this.name=msg;
					this.crsv.cls.add(this);
					
						for (int i=0;i<this.crsv.cls.size();i++){
							System.out.println("for:"+this.crsv.cls.get(i).name);
						}
						if (cmd.equals("Msg")) {
							for (int i=0;i<this.crsv.cls.size();i++){
								ThreadedHandler1 temp=this.crsv.cls.get(i);
								if (temp!=this){
									temp.writeBelow("Msg,"+this.name+">>"+msg);
								}
							}
						}
						else{
							this.crsv.cls.remove(this);
						}

				}
									
				
			}catch(IOException e){crsv.cls.remove(this);}
			
		}
	}
}
