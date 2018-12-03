//Author: Zhi Qiao(qiaoqiaojiushiwo@gmail.com)
 

import java.io.*;
import java.net.*;

public class FileServer implements Runnable {
	
	public FileServer() {
		
	}
	public void receive(ServerSocket s,String name) throws Exception {
		Socket sr= s.accept();
		byte b[]= new byte[40000];
		InputStream is=sr.getInputStream();
		FileOutputStream fr= new FileOutputStream(name);
		is.read(b,0,b.length);
		fr.write(b,0,b.length);
		fr.close();
	}
	public void applyreceive(int port,String name) throws Exception {
		ServerSocket s = new ServerSocket(port);
		FileServer receiver = new FileServer();
		receiver.receive(s,name);
		s.close();
	}
	
	public static void main(String[] args) throws Exception{
		ServerSocket s = new ServerSocket(1239);
		FileServer receiver = new FileServer();
		receiver.receive(s,"/home/pi/Desktop/receivingtone/");
		s.close();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		FileServer receiver = new FileServer();
		try {
			receiver.applyreceive(1234,"/home/pi/Desktop/receivingtone/tone.wav");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
	
