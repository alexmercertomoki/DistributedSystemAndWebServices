package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Random;
/**
*
* @author Bilei
* 
*  THis the project 2 task 2   server
*/
public class UDPServerThatIgnoresYou {
	
	    public static void main(String args[]) {
	    	Random rand=new Random();
	        DatagramSocket aSocket = null;
	        try {
	        	
	            aSocket = new DatagramSocket(57920);
	            // create socket at agreed port
	            
	            byte[] buffer;
	            while (true) {
	            	buffer = new byte[1000];
	                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
	                
	                aSocket.receive(request);
	                
	                int i= rand.nextInt(10);
	                
	                String calc;
	                
	                
	                if(i<8){
	                	System.out.println("Got request " + new String(request.getData()).trim()+
	                			" but ignoring it.");
	                	continue;
	                }
	                
	                else{
	                	
	                	  calc= new String(request.getData(),"ISO-8859-1");
	                	  System.out.println("Got request" + new String(request.getData()).trim());
//	                	  System.out.println(calc);
	                	  String[] a= calc.split(" ");
	                	  a[2]=a[2].trim();
	                	  long result = 0;
	                	
	                	if(a[2].equals("^")){
	   	                   result=(long) Math.pow(Long.parseLong(a[0]),Long.parseLong(a[1]));
	   	                }
	   	                if(a[2].equals("+")){
//	   	                	System.out.println(Long.parseLong(a[0]));
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
	   	             System.out.println("I sent !!!!!");
	                }
	               
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
