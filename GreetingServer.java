import java.util.Scanner;
import java.net.*;
import java.io.*;

public class GreetingServer extends Thread
{
   private ServerSocket serverSocket;
   
   public GreetingServer(int port) throws IOException
   {
      serverSocket = new ServerSocket(port);
      serverSocket.setSoTimeout(10000000);
   }

   public void run()
   {
      while(true)
      {
         try
         {
            System.out.println("Waiting for client on port " +
            serverSocket.getLocalPort() + "...");
            Socket server = serverSocket.accept();
            System.out.println("Just connected to "
                  + server.getRemoteSocketAddress());
            DataInputStream in =
                  new DataInputStream(server.getInputStream());
            System.out.println(in.readUTF());
             BufferedReader i=new BufferedReader(new FileReader("C:/Users/hp laptop/Desktop/jtc/dropbox/abcd.txt"));
               String r = i.readLine();
               System.out.println(r);
            DataOutputStream out =
                 new DataOutputStream(server.getOutputStream());
            out.writeUTF(r);
              i.close();
           server.close();
         }catch(SocketTimeoutException s)
         {
            System.out.println("Socket timed out!");
            break;
         }catch(IOException e)
         {
            e.printStackTrace();
            break;
         }
      }
   }
   public static void main(String [] args)
   {
     Scanner in=new Scanner(System.in);
                 
      int port = in.nextInt();
      try
      {
         Thread t = new GreetingServer(port);
         t.start();
      }
catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}