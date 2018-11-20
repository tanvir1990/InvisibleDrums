package udptest;


import java.io.*;
import java.net.*;

public class FileServer implements Runnable {
	
	public FileServer() {
		
	}
	public void receive(int datasize, String filepath,ServerSocket s) throws Exception {
		int size = (datasize+1)*1000;
		Socket sr= s.accept();
		byte b[]= new byte[size];
		InputStream is=sr.getInputStream();
		FileOutputStream fr= new FileOutputStream(filepath);
		is.read(b,0,b.length);
		fr.write(b,0,b.length);
		fr.close();
	}
	public void applyreceive(int port,int datasize,String filepath) throws Exception {
		ServerSocket s = new ServerSocket(port);
		FileServer receiver = new FileServer();
		System.out.println("wating to receive");
		receiver.receive(datasize,filepath,s);
		System.out.println("file is received");
		s.close();
	}
	
	public static void main(String[] args) throws Exception{
		FileServer receiver = new FileServer();
		System.out.println("wating to receive");
		int port =4333;
		int size = 22;
		String fileinfo="M:\\receive\\900001 clap.wav";
		receiver.applyreceive(port, size, fileinfo);;
		System.out.println("file is received");
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		FileServer receiver = new FileServer();
		try {
			int port =4333;
			int size = 22;
			String fileinfo="M:\\receive\\900001 clap.wav";
			receiver.applyreceive(port, size, fileinfo);;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
	