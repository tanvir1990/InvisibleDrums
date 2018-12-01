
//Author: Zhi Qiao(qiaoqiaojiushiwo@gmail.com)
package udp;
//this can 

public class receiving {

	public static void main(String[] args) throws Exception {
		UDPReceiver receiver = new UDPReceiver();
		UDPReceiver2 receiver2 = new UDPReceiver2();
		FileServer fileserver = new FileServer();
		//FileClient filesender2 = new FileClient();
		
		Thread t1 = new Thread(receiver);
		Thread t2 = new Thread(receiver2);
		
		t1.start();
		t1.join();
		String flag = receiver.getMessage();
		
		
		if(flag.equals("0")) {
			System.out.println("\naddTone selected");
			t2.start();
			t2.join();
			String filepath = receiver2.getMessage();
			System.out.println("add: " + filepath+" to database");
			
				if(!filepath.isEmpty()) {
					fileserver.applyreceive(1238, filepath);
					
				}
			
			
		}else if(flag.equals("1")) {
			System.out.println("deleteTone selected");
			t2.start();
			t2.join();
			String filepath = receiver2.getMessage();
			System.out.println("delete :" + filepath);
			
		}else if(flag.equals("2")) {
			System.out.println("setTone selected");
			t2.start();
			t2.join();
			String filepath = receiver2.getMessage();
			System.out.println("set:" + filepath+" as new tone");
			if(!filepath.isEmpty()) {
				fileserver.applyreceive(1238, filepath);
			}
//			String path= "C:\\Users\\zhiqiao\\Desktop\\Tone\\";
//			filepath = path+filepath;
//			for(int i=10000;i==0;i--) {}
//			if(!filepath.isEmpty()) {
//				filesender2.applysend(filepath, 1239);
//			}
		}
		
	}
	
}
