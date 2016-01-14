import java.net.*;
import java.io.*;
import java.util.Scanner;
public class GreetingClient
{
   public static void main(String [] args)
   {
      Scanner s=new Scanner(System.in);

      String serverName = s.nextLine();
      int port = s.nextInt();
      try
      {
         System.out.println("Connecting to " + serverName
                             + " on port " + port);
         Socket client = new Socket(serverName, port);
         System.out.println("connected to "
                      + client.getRemoteSocketAddress());
         OutputStream outto = client.getOutputStream();
         DataOutputStream out =
                       new DataOutputStream(outto);

         out.writeUTF("Hello from "
                      + client.getLocalSocketAddress());
           InputStream infrom = client.getInputStream(); 
         DataInputStream in =
                        new DataInputStream(infrom);
 String r=in.readUTF();
         System.out.println("IncomingData" + r);

      
               


          PrintWriter outputStream=new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/hp laptop/Desktop/jtc/dropbox/efgh.txt")));
        

           outputStream.println(r);

          outputStream.close();
         client.close();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}