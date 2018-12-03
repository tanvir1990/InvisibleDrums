
//Author: Zhi Qiao(qiaoqiaojiushiwo@gmail.com)
 

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSender3 implements Runnable  {
	public UDPSender3(){
		
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
		UDPSender3 sender3 = new UDPSender3();
		sender3.send("wow",1240);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
