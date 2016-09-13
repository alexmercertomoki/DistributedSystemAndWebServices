package client;

import java.net.*;
import java.util.Scanner;
import java.io.*;
/**
*
* @author Bilei
* 
*  THis the project 2 task1   client
*/
public class UDPClient {

    public static void main(String args[]) {
                // args give message contents and destination hostname
        DatagramSocket aSocket = null;
        
        try {
            aSocket = new DatagramSocket();
            System.out.println("please input the calculation you need split by ' ' ~~ ");
            Scanner sc =new Scanner(System.in); 
            String input= sc.nextLine();
            
            byte[] m = input.getBytes();
            //System.out.println(m.toString());
            InetAddress aHost = InetAddress.getByName("localhost");
            //an address used 
//            getAllByName(String host)
//            Given the name of a host, returns an array of its IP addresses, based on the configured name service on the system.
           
            int serverPort = 57920;
            DatagramPacket request
                    = new DatagramPacket(m, m.length, aHost, serverPort);
            //m is the bytes,length of m, host name, server port 
            
            aSocket.send(request);
            
            byte[] buffer = new byte[1000];
            
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            //
            aSocket.receive(reply);
            //  
            String[] a= input.split(" ");
            
            System.out.println("Reply: "+a[0]+a[2]+a[1] +" = "+ new String(reply.getData()).trim());
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (aSocket != null) {
                aSocket.close();
            }
        }
    }
}
