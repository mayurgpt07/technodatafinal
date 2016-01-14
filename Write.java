import java.io.*;
import java.util.Scanner;
 
public class Write {
	public static void main(String[] args) {
   PrintWriter outputStream=null;

		try {
                        Scanner s=new Scanner(System.in);

			String content = s.nextLine();
 
		   
                   outputStream = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/hp laptop/Desktop/jtc/dropbox/abcd.txt")));
 
		                             
                outputStream.println(content);
                         outputStream.close();
			System.out.println("Done");
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}