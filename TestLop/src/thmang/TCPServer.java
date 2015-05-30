package thmang;
import java.io.*;
import java.net.*;
public class TCPServer {
	public static void main(String [] args) throws IOException
	{
		ServerSocket server=new ServerSocket(2500);
		while (true){
			Socket socket=server.accept();
			(new ThreadXuly(socket)).start();

		}
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
			
			String ketqua=xulychuoi.xuly(chuoi);
			
			DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
			dout.writeUTF(ketqua);
			socket.close();
		}catch(IOException e){}
	}
}

