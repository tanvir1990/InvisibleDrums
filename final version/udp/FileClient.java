package udptest;

import java.io.*;
import java.net.*;
public class FileClient implements Runnable{
	
	public FileClient() {
		
	}
	
	public void send(int datasize,String filepath,Socket sr) throws Exception {
		
		int size = (datasize+1)*1000;
		String fileinfo = filepath;
		FileInputStream fr= new FileInputStream(fileinfo);
		byte b[]=new byte[size];
		fr.read(b, 0, b.length);
		OutputStream os = sr.getOutputStream();
		os.write(b,0,b.length);
		fr.close();
	}
	
	public void applysend(int port, int datasize,String filepath) throws Exception {
		Socket sr=new Socket("localhost",port);
		FileClient sender = new FileClient();
		sender.send(datasize,filepath,sr);
		System.out.println("file is sent");
		sr.close();
	}
	
	
	public static void main(String[] args) throws Exception{
		Socket sr=new Socket("localhost",4334);
		FileClient sender = new FileClient();
		int port=4333;
		int datasize = 23;
		String filepath = "M:\\90000 clap.wav";
		sender.applysend(port, datasize, filepath);;
		System.out.println("file is sent");
		sr.close();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		FileClient sender = new FileClient();
		try {
			int port=4333;
			int datasize = 23;
			String filepath = "M:\\90000 clap.wav";
			sender.applysend(port, datasize, filepath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}		