
import java.io.*;
import java.net.*;

/*
 * FileClient is the sender for TCP file transfer
 * 
 * @author Zichen Wang
 * @author Zhi Qiao
 * @since 2018-12-03
 */
public class FileClient implements Runnable{
	
	
	public FileClient() {
	// Empty constructor
	}
	
	/* Sends the selected file into Stream
	 *  
	 * @param sr The Socket object used during transfer
	 * @param path The path to store the file 
	 */
	public void send(Socket sr,String path) throws Exception {
		FileInputStream fr= new FileInputStream(path);
		byte b[]=new byte[40000];
		fr.read(b, 0, b.length);
		OutputStream os = sr.getOutputStream();
		os.write(b,0,b.length);
		fr.close();
	}
	
	/*
	 * Open the socket and call method send
	 * 
	 * @param port The port number thas going to be used
	 * 
	 */
	public void applysend(String path,int port) throws Exception {
		Socket sr=new Socket("10.0.0.71",port);
		FileClient sender = new FileClient();
		sender.send(sr,path);
		sr.close();
	}
	
	/*
	 * This is the man method that checks if this class runs without error.
	 * 
	 * @param args Unused
	 */
	
	public static void main(String[] args) throws Exception{
		Socket sr=new Socket("10.0.0.71",19123);
		FileClient sender = new FileClient();
		sender.send(sr,"/home/pi/Desktop/Sound Packs/clap.wav");
		sr.close();
		
	}
	
	/*
	 * This method is used for implemented threads
	 */

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
