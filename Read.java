import java.io.*;

public class Read
 {
   public static void main(String s[])
   {
   BufferedReader in = null;
    try
      {
        System.out.println("the data from file");
          in=new BufferedReader(new FileReader("C:/Users/hp laptop/Desktop/jtc/dropbox/abcd.txt"));
            String r = in.readLine();
            System.out.println(": "+r);
           in.close();
      }catch(IOException e){
             System.out.println("the datais not there");
             }
      
    }
} 