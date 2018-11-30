package tcp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiver2 implements Runnable  {

	private final static int PACKETSIZE = 100 ;
	public UDPReceiver2(){
		
	}
	public void applyreceive(int port) throws Exception{ 

		// Convert the argument to ensure that is it valid
		DatagramSocket socket = new DatagramSocket( port ) ;
		System.out.println( "Receiving on port " + port ) ;
		receive(socket);
		socket.close();
	}
	public String receive(DatagramSocket s) throws Exception{
		DatagramPacket packet = new DatagramPacket( new byte[PACKETSIZE], PACKETSIZE ) ;
		s.receive( packet ) ;
		return new String(packet.getData()).trim() ;
	}
	public static void main( String args[] ) throws Exception{
		UDPReceiver2 receiver = new UDPReceiver2();
		receiver.applyreceive(1234);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
			
				String[] args = new String[0];
				try {
					UDPReceiver2.main(args);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
}
