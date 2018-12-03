//Author: Zhi Qiao(qiaoqiaojiushiwo@gmail.com)
 

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer2 implements Runnable  {
public FileServer2() {
		
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
		FileServer2 receiver = new FileServer2();
		receiver.applyreceive(1239,"C:\\Users\\zhiqiao\\Desktop\\file\\tone.wav");

	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
