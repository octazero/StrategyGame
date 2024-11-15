/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypckg;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amr
 */
public class Network extends Thread {
            private ServerSocket server;
            private OutputStream OS ;
            private Socket socket;
            private PrintWriter pw;
            private Random rand ;
            private int code; 
           public Network()
           {
               try
               {
                   rand = new Random();
                   server =new ServerSocket(8000);
                   socket=new Socket();
               }
               catch(Exception e){
                   System.out.println(e.toString());
               }
           }
           public void run() 
           {	
                try
                {
                    code = rand.nextInt(1000);
                    socket = server.accept();
                    System.out.println("HELLO");
                    openStreams();
                    pw.println("Your Activation code is : " + code);
                    closeStreams();
                }
                catch(IOException e){}               
           }
           public void openStreams()
           {
                try 
                {
                    OS = socket.getOutputStream();
                    pw = new PrintWriter(OS,true);
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
                }
           }
           public void closeStreams()
           {
               pw.close();
                try 
                {
                    socket.close();
                    //server.close();
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
                }
           }
           public int getCode()
           {
               return code;
           }
}
