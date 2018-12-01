//Author: Zhi Qiao(qiaoqiaojiushiwo@gmail.com)
package udp;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class FileClient2 implements Runnable{
public FileClient2() {
		
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
		Socket sr=new Socket("localhost",port);
		FileClient sender = new FileClient();
		sender.send(sr,path);
		sr.close();
	}
	
	
	public static void main(String[] args) throws Exception{
		Socket sr=new Socket("localhost",4333);
		FileClient2 sender = new FileClient2();
		sender.send(sr,"");
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
