//Author: Zhi Qiao(qiaoqiaojiushiwo@gmail.com)



import java.util.Scanner;

public class sending {
	//identified where the user will read the file from
	static String databasefolder="C:\\Users\\zhiqiao\\Desktop\\voice\\";

	/*
	 * apply while loop to make the system work automatically
	 * the user needs to initiallize the system for the first load
	 * edit file saving folder for sending
	 * set the port for each UDP and TCP components
	 *
	 */
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

		
	}

}
