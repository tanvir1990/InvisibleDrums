package filetcp;

import java.io.*;
import java.net.*;
public class FileClient {
	public static void main(String[] args) throws Exception{
		
		FileInputStream fr= new FileInputStream("M:\\90000 clap.wav");
		byte b[]=new byte[40000];
		fr.read(b, 0, b.length);
		Socket sr=new Socket("localhost",4333);
		OutputStream os = sr.getOutputStream();
		os.write(b,0,b.length);
		
		
		
		
		
		
//		
//		byte b[]= new byte[40000];
//		Socket sr=new Socket("localhost",4333);
//		InputStream is=sr.getInputStream();
//		FileOutputStream fr= new FileOutputStream("M:\\receive\\900001 clap.wav");
//		is.read(b,0,b.length);
//		fr.write(b,0,b.length);
//		

		
	}
	

}
