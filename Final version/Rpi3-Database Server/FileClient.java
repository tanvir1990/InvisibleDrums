//Author: Zhi Qiao(qiaoqiaojiushiwo@gmail.com)
 

import java.io.*;
import java.net.*;
public class FileClient implements Runnable{
	
	public FileClient() {
		
	}
	
	public void send(Socket sr,String path) throws Exception {
		FileInputStream fr= new FileInputStream(path);
		byte b[]=new byte[40000];
		fr.read(b, 0, b.length);
		OutputStream os = sr.getOutputStream();
		os.write(b,0,b.length);
		fr.close();
	}
	
	public void applysend(String path,int port) throws Exception {
		Socket sr=new Socket("10.0.0.71",port);
		FileClient sender = new FileClient();
		sender.send(sr,path);
		sr.close();
	}
	
	
	public static void main(String[] args) throws Exception{
		Socket sr=new Socket("10.0.0.71",19123);
		FileClient sender = new FileClient();
		sender.send(sr,"/home/pi/Desktop/Sound Packs/clap.wav");
		sr.close();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		FileClient sender = new FileClient();
		try {
			sender.applysend("",1234);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}		
