import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
 * UDPReceiver 2 is used to receive the file name
 * SYSC 3010 M-7
 * @author Zhi Qiao
 * @author Zichen Wang
 * @since 2018-12-03
 */
public class UDPReceiver2 implements Runnable  {

	private final static int PACKETSIZE = 100 ;
	String message = "";
	String databasefolder="/home/pi/Desktop/receivingtone/";
	public UDPReceiver2(){
		// empty constructor
	}
	/*
	 * Receive the binary array from stream and writes into String
	 * 
	 * @param port The port number used during transfer
	 */
	public void applyreceive(int port) throws Exception{ 
		// Convert the argument to ensure that is it valid
		DatagramSocket socket = new DatagramSocket( port ) ;
		System.out.println( "waiting for file name...") ;
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
		System.out.println( "file path: " + message) ;
	}
	/*
	 * This method is used to get the message
	 * 
	 * @return this.message The message received by the receiver 
	 */
	public String getMessage() {
		return this.message;
	}
	/*
	 * This is the main method 
	 * Used for run the method itself
	 * @param args Unused
	 */
	public static void main( String args[] ) throws Exception{
		UDPReceiver2 receiver = new UDPReceiver2();
		receiver.applyreceive(1234);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		UDPReceiver2 receiver2 = new UDPReceiver2();
		
		try {
			receiver2.applyreceive(1237);
			message = receiver2.getMessage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
