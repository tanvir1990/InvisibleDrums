package filetcp;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.nio.file.*;

public class Test {
	public static void main(String args[]) {
		
		File f = new File("M:\\receive\\Bass.wav");
		if (f.exists() && !f.isDirectory()) {
			
			
			System.out.println("File is stored");
		}
		else {
			System.out.println( "nothing");
		}
		
	
	}
}
