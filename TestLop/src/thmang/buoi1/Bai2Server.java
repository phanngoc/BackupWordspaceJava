package thmang.buoi1;
import java.io.*;
import java.net.*;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Bai2Server {
	public static void main(String [] args) throws IOException
	{
		ServerSocket server=new ServerSocket(2500);
		while (true){
			Socket socket=server.accept();
			(new ThreadXuly1(socket)).start();

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
	public ThreadXuly1(Socket s){
		this.socket=s;
	}
	public void run(){
		try{
			DataInputStream din = new DataInputStream(socket.getInputStream());
			String chuoi = din.readUTF();
			String ketqua_final = Bai2Server.evalExpression(chuoi);
			DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
			dout.writeUTF(ketqua_final);
			socket.close();
		}catch(IOException e){}
	}
}

