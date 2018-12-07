//Author: Zhi Qiao(qiaoqiaojiushiwo@gmail.com)

/*
 * FileClient is the sender for TCP file transfer
 *
 * @author Zhi Qiao
 * @author Zichen Wang
 * @since 2018-12-03
 */

import java.net.*;

public class UDPSender implements Runnable  {
	public UDPSender(){
		
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
	public static void main(String[] args) throws Exception {
		UDPSender sender = new UDPSender();
		sender.send("wow",1234);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
