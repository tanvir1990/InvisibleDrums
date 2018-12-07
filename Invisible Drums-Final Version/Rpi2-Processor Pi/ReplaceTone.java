//Author: Zhi Qiao(qiaoqiaojiushiwo@gmail.com)
 

import java.io.*;
import java.net.*;

public class ReplaceTone implements Runnable {
	
	public ReplaceTone() {
		
	}
	//use .io library to read the file and delete it
	public void deleteold(){
		//read file
		File f = new File("/home/pi/Desktop/drumbodybody/invisibledrum/tone/tone.wav");
		f.delete();//delete read file
	}
	//receive the new tone file through TCP
	public void receive(ServerSocket s,String name) throws Exception {
		Socket sr= s.accept();//read accepted file
		byte b[]= new byte[100000];//load it into a byte array
		InputStream is=sr.getInputStream();
		FileOutputStream fr= new FileOutputStream(name);
		//use .io method read and write file and put it to the location
		is.read(b,0,b.length);
		fr.write(b,0,b.length);
		fr.close();
	}

	//open the socket for file transmittion
	public void applyreceive(int port,String name) throws Exception {
		ServerSocket s = new ServerSocket(port);
		ReplaceTone receiver = new ReplaceTone();
		receiver.receive(s,name);
		s.close();
	}

	// create the loop to make this operation automatic
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
	
