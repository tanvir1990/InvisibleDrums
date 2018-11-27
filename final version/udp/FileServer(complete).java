//Author: Zhi Qiao(qiaoqiaojiushiwo@gmail.com)
package udptest;


import java.io.*;
import java.net.*;

public class FileServer implements Runnable {
	
	public FileServer() {
		
	}
	public void receive(ServerSocket s) throws Exception {
		Socket sr= s.accept();
		byte b[]= new byte[40000];
		InputStream is=sr.getInputStream();
		FileOutputStream fr= new FileOutputStream("M:\\900001 clap.wav");
		is.read(b,0,b.length);
		fr.write(b,0,b.length);
		fr.close();
	}
	public void applyreceive() throws Exception {
		ServerSocket s = new ServerSocket(4332);
		FileServer receiver = new FileServer();
		receiver.receive(s);
		s.close();
	}
	
	public static void main(String[] args) throws Exception{
		ServerSocket s = new ServerSocket(4333);
		FileServer receiver = new FileServer();
		receiver.receive(s);
		s.close();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		FileServer receiver = new FileServer();
		try {
			receiver.applyreceive();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
	