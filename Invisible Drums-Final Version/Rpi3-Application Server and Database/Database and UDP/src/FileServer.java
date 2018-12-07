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
	 * Write the Bytes to the empty file
	 * 
	 * @param name The name for the created empty file, same as receiving file 
	 * @param port The selected port number
	 */
	public void receive(String name,int port) throws Exception {
		ServerSocket s = new ServerSocket(port);
		Socket sr= s.accept(); // accept Socket and waiting for connection
		byte b[]= new byte[40000];
		InputStream is=sr.getInputStream();
		FileOutputStream fr= new FileOutputStream(name);
		is.read(b,0,b.length);
		fr.write(b,0,b.length);
		fr.close();
	}
	

	/*
	 * This is the main method 
	 * Used for run the method itself
	 * @param args Unused
	 */
	public static void main(String[] args) throws Exception{
		FileServer receiver = new FileServer();
		receiver.receive("/home/pi/Desktop/receivingtone/", 1239);
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
			receiver.receive("/home/pi/Desktop/receivingtone/tone.wav", 1234);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
	
