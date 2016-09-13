package server;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.ByteBuffer;
/**
*
* @author Bilei
* 
*  THis the project 2 task 3   server
*/

public class UDPServerWithDoubleArithmetic {
	
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
	                byte[] data=request.getData();
	                byte[] x=new byte[8];
	                byte[] y=new byte[8];
	                byte c;
	                
	                for(int i=0;i<8;i++){
	                	x[i]=data[i];
	                }
	                
	                for(int i=0;i<8;i++){
	                	y[i]=data[i+8];
	                }
	                
	                c=data[16];
	                
	                long xx = byteArrayToLong(x);
	                double xxx= Double.longBitsToDouble(xx);
	                System.out.println(xxx);
	                
	                long yy= byteArrayToLong(y);
	                double yyy=Double.longBitsToDouble(yy);
	                System.out.println(yyy);
//	                String operator= new String(c);
	                char operator= (char)(c);  // can be converted 
	                System.out.println(operator);
	                
	                double result = 0;
	                
	                
	                if(operator=='+'){  // ' ' is char
	                	result=xxx+yyy;
	                }	                
	                if(operator=='-'){  // ' ' is char
	                	result=xxx-yyy;
	                }	                
	                if(operator=='*'){  // ' ' is char
	                	result=xxx*yyy;
	                }	                
	                if(operator=='/'){  // ' ' is char
	                	result=xxx/yyy;
	                }	                
	                
	                
	                System.out.println("helololo result :" +result);
	                byte[] m =  longToBytes(Double.doubleToLongBits(result));
	                System.out.println("yyyyy"+m.length);
	                
	                
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
