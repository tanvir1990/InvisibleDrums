import java.io.*;
import java.net.*;

/*
 * FileServer is the Receiver for TCP file transfer
 * 
 * @author Zichen Wang
 * @author Zhi Qiao
 * @since 2018-12-03
 */

public class FileServer implements Runnable {
	
	public FileServer() {
		// Empty construtor
	}
	
	/* Receive the binary array from stream and writes into an empty file
	 * 
	 * @param s The ServerSocket used for transfer
	 * @param name The name for the created empty file, same as receiving file 
	 */
	public void receive(ServerSocket s,String name) throws Exception {
		Socket sr= s.accept(); // accept Socket and waiting for connection
		byte b[]= new byte[40000];
		InputStream is=sr.getInputStream();
		FileOutputStream fr= new FileOutputStream(name);
		is.read(b,0,b.length);
		fr.write(b,0,b.length);
		fr.close();
	}
	
	/* This method creates the ServerSocket objecct and calls receive
	 * Can be combined with method receive
	 * 
	 * @param port The selected port number
	 * @param name The name for the created empty file, same as receiving file
	 */
	public void applyreceive(int port,String name) throws Exception {
		ServerSocket s = new ServerSocket(port);
		FileServer receiver = new FileServer();
		receiver.receive(s,name);
		s.close();
	}
	/*
	 * This is the main method 
	 * Used for run the method itself
	 * @param args Unused
	 */
	public static void main(String[] args) throws Exception{
		ServerSocket s = new ServerSocket(1239);
		FileServer receiver = new FileServer();
		receiver.receive(s,"/home/pi/Desktop/receivingtone/");
		s.close();
	}
	
	
	/*
	 * This method is used for implmented threads
	 */
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
	
