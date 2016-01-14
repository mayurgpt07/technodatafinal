import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client1
{
   public void clientRun(String serverName, int port,Client1 c1)
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

         out.writeUTF("Request is coming from ");
                      
         InputStream infrom = client.getInputStream();
         DataInputStream in =
                        new DataInputStream(infrom);
         System.out.println("Server says " + in.readUTF());
	 		Scanner s1=new Scanner(System.in);
			String s2=s1.nextLine();
			 if(s2=="y")
			 {  
				 c1.clientRun(serverName,port,c1);
			 }
			 else
			 { 
 	          client.close();
			 }
      }catch(IOException e)
      {
         System.out.println("error in client");
      }
	  
}

   public static void main(String [] args)
   {
	    Client1 c=new Client1();
   System.out.println("enter about port servername and port:\n");
      Scanner s=new Scanner(System.in);

      String serverName = s.nextLine();
      int port = s.nextInt();
	   c.clientRun(serverName,port,new Client1());
	     
   
   }
}