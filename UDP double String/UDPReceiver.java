package tcp;

import java.net.*;

public class UDPReceiver implements Runnable  {

	private final static int PACKETSIZE = 100 ;
	public UDPReceiver(){
		
	}
	public void applyreceive(int port) throws Exception{ 

		// Convert the argument to ensure that is it valid
		DatagramSocket socket = new DatagramSocket( port ) ;
		System.out.println( "Receiving on port " + port ) ;
		receive(socket);
		socket.close();
	}
	public void receive(DatagramSocket s) throws Exception{
		DatagramPacket packet = new DatagramPacket( new byte[PACKETSIZE], PACKETSIZE ) ;
		s.receive( packet ) ;
		System.out.println( "File Path: " + new String(packet.getData()).trim() ) ;
	}  
	public static void main( String args[] ) throws Exception{
		UDPReceiver receiver = new UDPReceiver();
		receiver.applyreceive(1235);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
			
				String[] args = new String[0];
				try {
					UDPReceiver.main(args);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
}

