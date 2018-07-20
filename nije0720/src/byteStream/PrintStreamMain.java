package byteStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamMain {

	public static void main(String[] args) {
		PrintStream ps = null;
		try {
			ps = new PrintStream(new FileOutputStream
					("C:\\Users\\503-11\\Desktop\\test\\insect.txt", true));
			ps.println("what the fun");
			ps.println("your mother pumkin suit");
			ps.flush();

	    }
		catch(Exception e) {
			System.out.println("file write exception: " + e.getMessage());
		}
		finally {
			if(ps != null);
			ps.close();
		}
		
	}
}
