//Author: Zhi Qiao(qiaoqiaojiushiwo@gmail.com)
 

import java.io.*;
import java.net.*;

public class ReplaceTone implements Runnable {
	
	public ReplaceTone() {
		
	}
	public void deleteold(){
		File f = new File("/home/pi/Desktop/drumbodybody/invisibledrum/tone/tone.wav");
		f.delete();
	}
	public void receive(ServerSocket s,String name) throws Exception {
		Socket sr= s.accept();
		byte b[]= new byte[100000];
		InputStream is=sr.getInputStream();
		FileOutputStream fr= new FileOutputStream(name);
		is.read(b,0,b.length);
		fr.write(b,0,b.length);
		fr.close();
	}
	public void applyreceive(int port,String name) throws Exception {
		ServerSocket s = new ServerSocket(port);
		ReplaceTone receiver = new ReplaceTone();
		receiver.receive(s,name);
		s.close();
	}
	
	public static void main(String[] args) throws Exception{
		UDPReceiver udpreceiver = new UDPReceiver();
		boolean begin = true;
		
		while (begin == true){
		udpreceiver.applyreceive(1241);
		String flag = udpreceiver.getMessage();
		if(flag.equals("2")){
		
			ServerSocket s = new ServerSocket(1240);
			ReplaceTone receiver = new ReplaceTone();
			receiver.deleteold();
			receiver.receive(s,"/home/pi/Desktop/drumbodybody/invisibledrum/tone/tone.wav");
			s.close();
		}
	}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		ReplaceTone receiver = new ReplaceTone();
		try {
			receiver.applyreceive(1240,"C:\\Users\\zhiqiao\\Desktop\\file\\tone.wav");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
	
