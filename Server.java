import java.util.Scanner;
import java.net.*;
import java.io.*;

public class Server extends Thread
{
   private ServerSocket sSocket;
   
   public Server(int port) throws IOException
   {
      sSocket = new ServerSocket(port);
      sSocket.setSoTimeout(100000000);
   }
   
   public void run()
   {  
  

      while(true)
      {
         try
         {
            System.out.println("Waiting for client on port " +
            sSocket.getLocalPort() + "...");
            Socket server = sSocket.accept();
            System.out.println(" connected to "
                  + server.getRemoteSocketAddress());
            DataInputStream in =
                  new DataInputStream(server.getInputStream());
            System.out.println(in.readUTF());
            DataOutputStream out =
                 new DataOutputStream(server.getOutputStream());
				 Scanner s2=new Scanner(System.in);
				String s4=s2.nextLine();
				
			  
            out.writeUTF("Thank you for connecting to "
              + server.getLocalSocketAddress() + "\nGoodbye!"+s4);
			  
         }catch(SocketTimeoutException s)
         {
            System.out.println("Socket timed out!");
            break;
         }catch(IOException e)
         {
            System.out.println("error has occured");
            break;
         }
      }
}
   public static void main(String [] args)
   {
    System.out.println("Enter Port Number for The Server\n");
     Scanner in=new Scanner(System.in);
                 
      int port = in.nextInt();
      try
      {
         Thread t = new Server(port);
         t.start();
      }
catch(IOException e)
      {
         System.out.println("error");
      }
   }
}