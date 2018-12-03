//Author: Zhi Qiao(qiaoqiaojiushiwo@gmail.com)
 

import java.net.*;

public class UDPSender implements Runnable  {
	public UDPSender(){
		
	}
	
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
