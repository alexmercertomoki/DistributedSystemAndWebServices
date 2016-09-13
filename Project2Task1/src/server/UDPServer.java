package server;

import java.net.*;
import java.util.ArrayList;
import java.io.*;
/**
*
* @author Bilei
* 
*  THis the project 2 task1 server
*/
public class UDPServer {

    public static void main(String args[]) {
        DatagramSocket aSocket = null;
        try {
            aSocket = new DatagramSocket(57920);
            // create socket at agreed port
            byte[] buffer;
            while (true) {
            	buffer = new byte[1000];
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(request);
                String calc= new String(request.getData(),"ISO-8859-1").trim();
//              String calc=data.toString();
                System.out.println(calc);
                System.out.println("received request");
                //      ArrayList al=new ArrayList();
                String[] a= calc.split(" ");
                a[2] = a[2].trim();
                long result = 0;
                
                if(a[2].equals("^")){
                   result=(long) Math.pow(Long.parseLong(a[0]),Long.parseLong(a[1]));
                }
                if(a[2].equals("+")){
//                	System.out.println(Long.parseLong(a[0]));
                	result=Long.parseLong(a[0])+Long.parseLong(a[1]);
                }
                
                if(a[2].equals("-")){
                	result=Long.parseLong(a[0])-Long.parseLong(a[1]);
                }
                if(a[2].equals("*")){
                	result=Long.parseLong(a[0])*Long.parseLong(a[1]);
                }
                if(a[2].equals("/")){
                	result=Long.parseLong(a[0])/Long.parseLong(a[1]);
                }
               
                String replytoclient=""+ result;
                System.out.println(replytoclient);
                byte[] m= replytoclient.getBytes();
                DatagramPacket reply = new DatagramPacket(m, m.length,
                        request.getAddress(), request.getPort());
                
                aSocket.send(reply);
              
            }
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
