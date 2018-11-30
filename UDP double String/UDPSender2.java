package tcp;

import java.net.*;
import java.util.Scanner;

public class UDPSender2 implements Runnable  {
	public UDPSender2(){
		
	}
	
	public void send(String command,int i) throws Exception{
	      // Check the arguments

  
	      DatagramSocket socket = null ;
	      // Convert the arguments first, to ensure that they are valid
	      InetAddress host = InetAddress.getByName( "localhost" ) ;
	      int port         =  i;
	      socket = new DatagramSocket() ;
	      String message = command;
	      byte [] data = message.getBytes() ;
	      DatagramPacket packet = new DatagramPacket( data, data.length, host, port ) ;
	      socket.send( packet ) ;
	      socket.close();

   }
	public static void main(String[] args) throws Exception {
		UDPSender2 sender = new UDPSender2();
		Scanner in;
		in = new Scanner (System.in);
		String message = null;
		System.out.println("Enter operation id  ");
		message = in.nextLine();
		sender.send(message,1234);
		in.close();

	}
	@Override 
	public void run() {
		// TODO Auto-generated method stub
				
				String[] args = new String[0];
				try {
					UDPSender2.main(args);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}
}