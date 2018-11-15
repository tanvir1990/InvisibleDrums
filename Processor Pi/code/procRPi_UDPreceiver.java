import java.io.*;
import java.net.*;

public class procRPi_UDPreceiver {
	public void receive() throws IOException, InterruptedException {
		DatagramSocket serverSocket = new DatagramSocket(4000);
		int packetsize=1024;
		FileOutputStream fos = null;
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		try {
			fos = new FileOutputStream("zz.wav");
			
			double nosofpackets=Math.ceil(((int) (new File("F:\\nirmal\\1.wav")).length())/packetsize);
			byte[] mybytearray = new byte[packetsize];
			DatagramPacket receivePacket = new DatagramPacket(mybytearray,mybytearray.length);

			System.out.println(nosofpackets+" "+mybytearray+" "+ packetsize);

			for(double i=0;i<nosofpackets+1;i++){

				serverSocket.receive(receivePacket); 
				byte audioData[] = receivePacket.getData();
				System.out.println("Packet:"+(i+1));
				bos.write(audioData, 0,audioData.length);
			}
		}finally {
			if(fos!=null)
				fos.close();
			if(bos !=null)
				bos.close();
			if(serverSocket !=null)
				serverSocket.close();
		}
	}
}

