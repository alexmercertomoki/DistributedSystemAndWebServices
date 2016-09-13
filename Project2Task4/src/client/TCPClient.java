package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;


/**
*
* @author Bilei
* 
*  This is the client side of the spy uses this ...Using md5 Hash function to 
*  get the password and username hashed
* 
* 
*/

/**
 * 
 * Main method to get info
 */
public class TCPClient {
	public static void main(String args[]) throws NoSuchAlgorithmException {

		//get info 
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your information !! ");
		System.out.println("Please enter your key first:");
		String key = sc.nextLine();
		System.out.println("Please enter your Username :");
		String username = sc.nextLine();
		System.out.println("Please enter your Password :");
		String password = sc.nextLine();
		System.out.println("Please enter your Location :");
		String location = sc.nextLine();

		Socket s = null;

		try {
			//set port local host 
			int serverPort = 7896;
			s = new Socket("localhost", serverPort);
                        
			DataInputStream in = new DataInputStream(s.getInputStream());
			DataOutputStream out = new DataOutputStream(s.getOutputStream());

			StringBuilder sb = new StringBuilder();
			// using md5 encoding hash function
                        BASE64Encoder en = new BASE64Encoder();
                        MessageDigest m = MessageDigest.getInstance("md5"); 
                        byte[] bname = m.digest(username.getBytes());
                        username=en.encode(bname);
                        byte[] bpass = m.digest(password.getBytes());
                        password=en.encode(bpass);
                        
			sb.append("Hello");
			sb.append(" ");
			sb.append(username);
			sb.append(" ");
			sb.append(password);
			sb.append(" ");
			sb.append(location);

			String output = sb.toString();

			byte[] outbytes = output.getBytes();
			//encrpt and go, catch exception like length problem in the encryption
			try {
				TCPSpyUsingTEAandPasswords tea = new TCPSpyUsingTEAandPasswords(key.getBytes());
				byte[] cry = tea.encrypt(outbytes);
				out.write(cry);
				out.flush();
			} catch (Exception e) {
				System.out.println("Key length error");
				System.exit(0);
			}
			
			//get a buffer start reading from server  
			byte[] buffer = new byte[800];
			int len = in.read(buffer);
			byte[] ininfo = new byte[len];
			for (int i = 0; i < len; i++) {
				ininfo[i] = buffer[i];
			}
			String just = new String(ininfo);
			
//			System.out.println(just);
			// deal with wrong info 
			if (just.equals("wrongkey")) {
				System.out.println("The key is not correct!");
			}
			if (just.equals("upwrong")) {
				System.out.println("Password and username are not correct !");
			}
			if (just.equals("suc")) {
				System.out.println("Succesfully written in !");
			}

			// System.out.println("Received: " + data);
		} catch (UnknownHostException e) {
			System.out.println("Socket:" + e.getMessage());
		} catch (EOFException e) {
			System.out.println("EOF:" + e.getMessage());
		} catch (IOException e) {
			System.out.println("readline:" + e.getMessage());
		} finally {
			if (s != null)
				try {
					s.close();
				} catch (IOException e) {
					System.out.println("close:" + e.getMessage());
				}
		}
	}
}