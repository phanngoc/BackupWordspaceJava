package stub;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataIODemo {
 public static void main(String[] args)
 {
	 DataOutputStream out;
	try {
		out = new DataOutputStream(new FileOutputStream("D:\\test.txt"));
		out.writeInt(16);
		out.writeLong((long)12.3);
		out.writeUTF("Đây là string");
		
		DataInputStream in = new DataInputStream(new FileInputStream("D:\\test.txt"));
		System.out.println("Gia tri int la:"+in.readInt());
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	int n = docso();
	System.out.println("So nhap vao la:"+n);
 }
 public static int docso()
 {
	InputStreamReader luongvao = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(luongvao);
	String s = "";
	try {
		s = br.readLine();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return Integer.parseInt(s);
 }
}
