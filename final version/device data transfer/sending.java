//Author: Zhi Qiao(qiaoqiaojiushiwo@gmail.com)
package udp;

import java.util.Scanner;

public class sending {
	static String databasefolder="C:\\Users\\zhiqiao\\Desktop\\voice\\";
	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		UDPSender sender = new UDPSender();
		UDPSender2 sender2 = new UDPSender2();
		FileClient filesender = new FileClient();
		
		Scanner in;
	    in = new Scanner (System.in);
	    System.out.println("please enter operation code:");
	    String command1 = in.nextLine();
		sender.send(command1,1236);
		System.out.println("please enter file path:");
	    String command2 = in.nextLine();
	    String filename = command2;
		sender2.send(command2,1237);
		System.out.println("file sending");
		
		for(int i=10000;i==0;i--) {}
		
		String filepath =(databasefolder +filename);
		filesender.applysend(filepath,1238);
		
	}

}
