package server;

import java.net.*;
import java.nio.ByteBuffer;
import java.util.Scanner;
import java.io.*;


/**
*
* @author Bilei
* 
*  THis is the server  side  for commander 
*/

public class TCPServer {
	
	public static final String pubkey="thisissecretsodon’ttellanyone";
	public static void main(String args[]) {
		try {
			
			int serverPort = 7896; // the server port
			ServerSocket listenSocket = new ServerSocket(serverPort);
			while (true) {
				//starting thread 
				Socket clientSocket = listenSocket.accept();
				Connection c = new Connection(clientSocket);
				
			}
		} catch (IOException e) {
			System.out.println("Listen socket:" + e.getMessage());
		}
	}
}

class Connection extends Thread {
	//get info 
	DataInputStream in;
	DataOutputStream out;
	Socket clientSocket;

	public Connection(Socket aClientSocket) {
		
		try {
			//start the thread 
			clientSocket = aClientSocket;
			in = new DataInputStream(clientSocket.getInputStream());
			out = new DataOutputStream(clientSocket.getOutputStream());
			this.start();
			
			
		} catch (IOException e) {
			System.out.println("Connection:" + e.getMessage());
		}
		
	}

	public void run() {
		
		try { // an echo server
			
		//key from the server 
			TCPSpyCommanderUsingTEAandPasswords tea=new TCPSpyCommanderUsingTEAandPasswords(TCPServer.pubkey.getBytes());
		//getting info from client
			byte[] buffer = new byte[800];
			int len = in.read(buffer);
			byte[] buf=new byte[len];
			for(int i=0;i<len;i++){
				buf[i]=buffer[i];
			}
			
			//decrypt the info
			byte[] userinfoBytes = tea.decrypt(buf);
			String userinfo=new String(userinfoBytes);
			String sub=userinfo.substring(0,5); //0-4 will be in sub
			System.out.println(sub);
			// if  key is right the sub will be hello
			if(sub.equals("Hello")){
				
				String[] strUser = userinfo.split(" ");
				String justify = strUser[0];
				String username= strUser[1];
				String password = strUser[2];
				String location = strUser[3];
				//can be converted to hashmap  
				//
				if(username.equals("EDOMQjaTaYvd9Oa8Ip6iJQ==")&&password.equals("tMw0TSWi7+VArb8meOIwTA==")){
					writetoKml("jamesb",location);
				}
				else if(username.equals("1F+MprEsnB/c9qvu6XEWqQ==")&&password.equals("j/MkifkvM0FmlL6P3C1MIg==")){
					writetoKml("joem",location);
				}
				else if(username.equals("+hFo/YA5XV2gae+5RjT8GQ==")&&password.equals("GBJue9P4Sz8+TfCU3vW33g==")){
					writetoKml("mikem",location);
				}
				
				else{
					//System.out.println("asdfadsfds");
					//if wrong will get wrong info to the client
					out.write("upwrong".getBytes());
					out.flush();
				}
				
			}
			
			else{
				//wrong key
				out.write("wrongkey".getBytes());
				out.flush();
				clientSocket.close();
			}
			
			
			
		} catch (EOFException e) {
			System.out.println("EOF:" + e.getMessage());
		} catch (IOException e) {
			System.out.println("readline:" + e.getMessage());
		} finally {
			try {
				clientSocket.close();
			} catch (IOException e) {/* close failed */
			}
		}
	}
	
	void writetoKml(String username, String location) throws IOException{
	    
		String fileName ="SecretAgents.kml";
	    Scanner file = null;
	    
	        try {
	        	file = new Scanner(new File(fileName));
	        }
	        catch (FileNotFoundException f) {
	        	System.out.println("We can not find your file");
                        // if not file here create
                        BufferedWriter bw = new BufferedWriter(new FileWriter("SecretAgents.kml")); 
                        String s ="<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
"<kml xmlns=\"http://earth.google.com/kml/2.2\">\n" +
"<Document>\n" +
"<Style id=\"style1\">\n" +
"<IconStyle>\n" +
"<Icon>\n" +
"<href>http://maps.gstatic.com/intl/en_ALL/mapfiles/ms/micons/blue- dot.png</href>\n" +
"</Icon>\n" +
"</IconStyle>\n" +
"</Style><Placemark>\n" +
"<name>jamesb</name>\n" +
"<description>Spy</description>\n" +
"<styleUrl>#style1</styleUrl>\n" +
"<Point> <coordinates>-79.940450,40.437394,0.00000</coordinates> </Point>\n" +
"</Placemark>\n" +
"<Placemark>\n" +
"<name>joem</name>\n" +
"<description>Spy</description>\n" +
"<styleUrl>#style1</styleUrl>\n" +
"<Point> <coordinates>-79.945389,40.444216,0.00000</coordinates> </Point>\n" +
"</Placemark>\n" +
"<Placemark>\n" +
"<name>mikem</name>\n" +
"<description>Spy</description>\n" +
"<styleUrl>#style1</styleUrl>\n" +
"<Point> <coordinates>-79.956264,40.441068,0.00000</coordinates> </Point>\n" +
"</Placemark> </Document> </kml>\n" +
"";
                        bw.write(s);
//                        System.out.println("succesful !!");
//    	out.write("suc".getBytes());
//		out.flush();
            file = new Scanner(new File(fileName));
                        
	        	
	        }
	        
	        StringBuilder sb=new StringBuilder();
	        
	        while(file.hasNextLine() == true) {
	        	 String s=file.nextLine();
	        	 sb.append(s+"\n");
	        	 if(s.contains(username)){
	        		while(true){
	        			
	        			s=file.nextLine();
	        			if(s.contains("coordinates")){
	        				s="<Point> <coordinates>"+location+"</coordinates> </Point>";
	        				sb.append(s+"\n");
	        				break;
	        			}
	        			sb.append(s+"\n");
	        		}
	        	 }
	        	
	        }
	    String kmlinfo =sb.toString();  
	
        BufferedWriter bw = new BufferedWriter(new FileWriter("SecretAgents.kml"));  
          
        bw.write(kmlinfo);  
        bw.close();
        System.out.println("succesful !! you can now go to main directory to find the .kml");
    	out.write("suc".getBytes());
		out.flush();
        
	}
	
	
}