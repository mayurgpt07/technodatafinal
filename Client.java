import java.net.*;
import java.io.*;
import java.util.Scanner;
public class Client
{
   public static void main(String [] args)
   {
   System.out.println("entyer about port servername and port:\n");
      Scanner s=new Scanner(System.in);

      String serverName = s.nextLine();
     System.out.println("enter port");
      int port = s.nextInt();
while(true)
{
      try
      {  
		  
         System.out.println("abc");
         System.out.println("Connecting to " + serverName
                             + " on port " + port);
         System.out.println("abc");

         Socket client = new Socket(serverName, port);
         System.out.println("connected to "
                      + client.getRemoteSocketAddress());
         OutputStream outto = client.getOutputStream();
         DataOutputStream out =
                       new DataOutputStream(outto);
					   System.out.println("write some dATA");
        Scanner s1=new Scanner(System.in);
		 String s2=s1.nextLine();
		
         out.writeUTF("Request is coming from "+s2);
                      
         InputStream infrom = client.getInputStream();
         DataInputStream in =
                        new DataInputStream(infrom);
         System.out.println("Server says " + in.readUTF());
	 		
	   client.close();
      }catch(IOException e)
      {
         System.out.println("error in client");
      }
	  
  }
   
   }
}