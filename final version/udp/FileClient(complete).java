//Author: Zhi Qiao(qiaoqiaojiushiwo@gmail.com)
package udptest;

import java.io.*;
import java.net.*;
public class FileClient implements Runnable{
	
	public FileClient() {
		
	}
	
	public void send(Socket sr) throws Exception {
		FileInputStream fr= new FileInputStream("M:\\90000 clap.wav");
		byte b[]=new byte[40000];
		fr.read(b, 0, b.length);
		OutputStream os = sr.getOutputStream();
		os.write(b,0,b.length);
		fr.close();
	}
	
	public void applysend() throws Exception {
		Socket sr=new Socket("localhost",4332);
		FileClient sender = new FileClient();
		sender.send(sr);
		sr.close();
	}
	
	
	public static void main(String[] args) throws Exception{
		Socket sr=new Socket("localhost",4333);
		FileClient sender = new FileClient();
		sender.send(sr);
		sr.close();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		FileClient sender = new FileClient();
		try {
			sender.applysend();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}		