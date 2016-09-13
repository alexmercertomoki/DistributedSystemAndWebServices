package client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
/**
*
* @author Bilei
* 
*  THis the project 2 task 3   client
*/

public class UDPClientWithDoubleArithmetic {

	public static void main(String args[]) {

		System.out.println("1.25 ----- 100.25 ");

		int in = 100;
		double result = 0;
    
    	for(int i=1;i<=in;i++){
    		double j= i + 0.25;
    		result=sumaddtion(result,j);
    		if(i<in){
	    		System.out.print(j+"+");
	    		
    		}
    		else{
    			System.out.print(j+"=");
    			System.out.println(result);
    		}
    		
    	}
		

	}

	static double sumaddtion(double x, double y) {

		
		DatagramSocket aSocket = null;
		double result;
		try {

			aSocket = new DatagramSocket();
			int serverPort = 57920;
			InetAddress aHost = InetAddress.getByName("localhost");
			//get double to bytes 
			long xx = Double.doubleToLongBits(x);
			long yy= Double.doubleToLongBits(y);
			byte[] xxx= longToBytes(xx);
			byte[] yyy= longToBytes(yy);

			char c ='+';
			//after long process of debugging I got to know that each  double is 8 bytes and 
			//char is 1 byte  then :
			byte[] m= new byte[17];
			//get ready to send
			for(int i=0;i<8;i++){
				m[i]=xxx[i];
				
			}
			
			for(int i=8;i<16;i++){
				m[i]=yyy[i-8];
			}
			
			m[16]=(byte)c;
			
			byte[] buffer = new byte[1000];
			
			//sending info
			DatagramPacket request = new DatagramPacket(m, m.length, aHost,
					serverPort);
			aSocket.send(request);

			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
			
			aSocket.receive(reply);
			//receiving
			byte[] dataResult=reply.getData();
			byte[] rel=new byte[8];
			for(int i=0;i<8;i++){
				rel[i]=dataResult[i];
			}
			
            result=Double.longBitsToDouble(byteArrayToLong(rel));
            
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
		return -1;
	}

	public static byte[] longToBytes(long x) {
		ByteBuffer buffer = ByteBuffer.allocate(Long.SIZE/8);
		buffer.putLong(x);
		return buffer.array();

	}

	public static long byteArrayToLong(byte bytes[]) {
		ByteBuffer buffer = ByteBuffer.allocate(Long.SIZE/8);
		buffer.put(bytes);
		buffer.flip();
		return buffer.getLong();
	}

}
