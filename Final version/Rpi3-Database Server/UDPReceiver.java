//Author: Zhi Qiao(qiaoqiaojiushiwo@gmail.com)

/*
 * FileClient is the sender for TCP file transfer
 *
 * @author Zhi Qiao
 * @author Zichen Wang
 * @since 2018-12-03
 */

import java.net.*;

public class UDPReceiver implements Runnable  {

	private final static int PACKETSIZE = 100 ;
	String message = "";
	
	public UDPReceiver(){
		
	}
	/* Receive the binary array from stream and writes into String
	 *
	 * @param port The selected port number
	 */
	public void applyreceive(int port) throws Exception{ 
		// Convert the argument to ensure that is it valid
		DatagramSocket socket = new DatagramSocket( port ) ;
		System.out.println( "waiting for operation id " ) ;
		receive(socket);
		socket.close();
	}
	/* Receive the binary array from stream and writes into String
	 *
	 * @param s the socket use for receiving
	 */
	public void receive(DatagramSocket s) throws Exception{
		DatagramPacket packet = new DatagramPacket( new byte[PACKETSIZE], PACKETSIZE ) ;
		s.receive( packet ) ;
		message = new String(packet.getData()).trim();
		System.out.println("operation id: " + message ) ;
	}
	public static void main( String args[] ) throws Exception{
		UDPReceiver receiver = new UDPReceiver();
		receiver.applyreceive(1234);
	}
	public String getMessage() {
		return this.message;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		UDPReceiver receiver = new UDPReceiver();
		
		try {
			receiver.applyreceive(1236);
			message = receiver.getMessage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

