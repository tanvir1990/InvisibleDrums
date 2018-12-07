/*
 * UDPSender3 is used to send the Operation commands
 * SYSC 3010 M-7
 * @author Zhi Qiao
 * @author Zichen Wang
 * @since 2018-12-03
 */
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSender3 implements Runnable  {
	public UDPSender3(){
		// empty constructor
	}
	/* Sends the String into Stream
	 *
	 * @param command The String commeent to send
	 * @param i The port number thas going to be used
	 */
	public void send(String command,int i) throws Exception{
	      // Check the arguments 
	      DatagramSocket socket = null ;
	      // Convert the arguments first, to ensure that they are valid
	      InetAddress host = InetAddress.getByName( "10.0.0.71" ) ;
	      int port         =  i;
	      socket = new DatagramSocket() ;
	      String message = command;
	      byte [] data = message.getBytes() ;
	      DatagramPacket packet = new DatagramPacket( data, data.length, host, port ) ;
	      socket.send( packet ) ;
	      socket.close();
	      System.out.println( "command sent" );
   }
	/*
	 * This is the main method 
	 * Used for run the method itself
	 * @param args Unused
	 */
	public static void main(String[] args) throws Exception {
		UDPSender3 sender3 = new UDPSender3();
		sender3.send("wow",1240);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
