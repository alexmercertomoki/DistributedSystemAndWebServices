package reliableclient;

import java.net.*;
import java.util.Scanner;
import java.io.*;

/**
*
* @author Bilei
* 
*  THis the project 2 task 2   client
*/
public class UDPClientWithReliability {

	public static void main(String args[]) {
		System.out.println("please input the calculation you need from 1-n sum: ");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int in = Integer.parseInt(input);
		int result = 1;
    	System.out.print(result+"+");
    	for(int i=2;i<=in;i++){
    		result=sumaddtion(result,i);
    		if(i<in){
	    		System.out.print(i+"+");
	    		
    		}
    		else{
    			System.out.print(i+"=");
    			System.out.println(result);
    		}
    		
    	}

	}

	static int sumaddtion(int x, int y) {
		// args give message contents and destination hostname
		DatagramSocket aSocket = null;
		int result;
		try {

			aSocket = new DatagramSocket();
			int serverPort = 57920;
			InetAddress aHost = InetAddress.getByName("localhost");
			StringBuilder sb = new StringBuilder();
			sb.append(x + " ");
			sb.append(y + " ");
			sb.append("+");
			String s = sb.toString();
			byte[] m = s.getBytes();
			byte[] buffer = new byte[1000];

			DatagramPacket request = new DatagramPacket(m, m.length, aHost,
					serverPort);
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
			while (true) {
				try {
					aSocket.send(request);
					aSocket.setSoTimeout(2000);
					aSocket.receive(reply);
//					System.out.println("Got it !");
					break;
				} catch (Exception e) {
					//System.out.println("he ingore you~ trying  ");
					continue;
				}
			}

			String ss = new String(reply.getData());
			result = Integer.parseInt(ss.trim());

			return result;

		} catch (SocketException e) {
			System.out.println("Socket: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO: " + e.getMessage());
		} finally {
			if (aSocket != null) {
				aSocket.close();
			}
		}
		return y;
	}
}
