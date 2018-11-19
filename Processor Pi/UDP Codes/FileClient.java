package filetcp;

import java.io.*;
import java.net.*;
public class FileClient {
	public static void main(String[] args) throws Exception{
		byte b[]= new byte[40000];
		Socket sr=new Socket("localhost",4333);
		InputStream is=sr.getInputStream();
		FileOutputStream fr= new FileOutputStream("M:\\receive\\900001 clap.wav");
		is.read(b,0,b.length);
		fr.write(b,0,b.length);
		
		Socket sr2=new Socket("localhost",4334);
		byte b2[] = new byte[300000];
		InputStream is2=sr2.getInputStream();
		FileOutputStream fr2= new FileOutputStream("M:\\receive\\Bass.wav");
		is2.read(b2,0,b2.length);
		fr2.write(b2,0,b2.length);
		
	}
	

}
