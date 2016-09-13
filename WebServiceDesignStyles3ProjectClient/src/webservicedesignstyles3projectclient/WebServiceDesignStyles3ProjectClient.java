
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservicedesignstyles3projectclient;

import static com.sun.org.apache.xerces.internal.impl.io.UTF8Reader.DEFAULT_BUFFER_SIZE;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.CharBuffer;

/**
 *
 * @author Bilei Huang 
 * 
 * The  Client  which is used for testing 
 * 
 * 
 */
public class WebServiceDesignStyles3ProjectClient {

    public static void main(String[] args) throws MalformedURLException, IOException {

        System.out.println("Begin main");
        Spy spy1 = new Spy("mikem", "spy", "Pittsburgh", "sesame");
        Spy spy2 = new Spy("joem", "spy", "Philadelphia", "obama");
        Spy spy3 = new Spy("seanb", "spy commander", "Adelaide", "pirates");
        
        Spy spy4 = new Spy("jamesb", "007", "Boston", "queen");
        System.out.println(doPut(spy1));
        System.out.println(doPut(spy2));
        System.out.println(doPut(spy3));
        System.out.println(doPut(spy4));
        System.out.println(doDelete("joem")); // 200 
        spy1.setPassword("Doris"); 
        System.out.println(doPost(spy1)); // 200
        System.out.println(doGetListAsXML()); // display xml 
        System.out.println(doGetListAsText()); // display text
        System.out.println(doGetSpyAsXML("mikem")); // display xml 
        System.out.println(doGetSpyAsText("joem")); // 404
        System.out.println(doGetSpyAsXML("mikem")); // display xml 
        System.out.println(doPut(spy2)); // 200 
        System.out.println(doGetSpyAsText("joem")); // display text 
        System.out.println("End main");
    }
     /**
    
     * @param  s  the spy which is used for add
     * @throws ProtocolException, MalformedURLException, IOException
     * 
     * Process  adding information 
     * 
     * */
    public static String doPut(Spy s) throws ProtocolException, MalformedURLException, IOException {

        URL url = new URL("http://localhost:8080/WebServiceDesignStyles3ProjectServer/SpyListCollection");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("PUT");
        con.setRequestProperty("Accept", "text/xml");
        con.setDoOutput(true);

        OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
        writer.write(s.toXML());
        writer.close();

        InputStreamReader isr = new InputStreamReader(con.getInputStream());
        BufferedReader br = new BufferedReader(isr);
        String str = new String();
        str = br.readLine();

        return str;

    }

      /**
    
     * @param  s  String the spy which is used for add
     * @throws ProtocolException, MalformedURLException, IOException
     * 
     * Process retrieving information
     * 
     * */
    public static String doGetSpyAsText(String s) throws ProtocolException, MalformedURLException, IOException {

        URL url = new URL("http://localhost:8080/WebServiceDesignStyles3ProjectServer/SpyListCollection/" + s);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "text/plain");

        InputStreamReader isr = new InputStreamReader(con.getInputStream());
        BufferedReader br = new BufferedReader(isr);
        String str = new String();
        str = br.readLine();
        isr.close();
        return str;

    }
    public static String doGetSpyAsXML(String s) throws ProtocolException, MalformedURLException, IOException {

        URL url = new URL("http://localhost:8080/WebServiceDesignStyles3ProjectServer/SpyListCollection/" + s);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "text/xml");

        InputStreamReader isr = new InputStreamReader(con.getInputStream());
        BufferedReader br = new BufferedReader(isr);
        String str = new String();
        str = br.readLine();
        isr.close();
        return str;

    }

    /**
    
     * @throws ProtocolException, MalformedURLException, IOException
     * 
     * Process  retrieving information as xml
     * 
     * */
    public static String doGetListAsXML() throws ProtocolException, MalformedURLException, IOException {

        URL url = new URL("http://localhost:8080/WebServiceDesignStyles3ProjectServer/SpyListCollection");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "text/xml");
        con.setDoOutput(true);

        InputStreamReader isr = new InputStreamReader(con.getInputStream());
        BufferedReader br = new BufferedReader(isr);

//       while(br.readLine()!=null){
//           
//       }
        
        StringBuilder sb = new StringBuilder();
        CharBuffer buf = CharBuffer.allocate(DEFAULT_BUFFER_SIZE);
        while (br.read(buf) >= 0) {
            sb.append(buf.flip());
            buf.clear();
        }
        return sb.toString();
    }
    
    /**
    
     * @throws ProtocolException, MalformedURLException, IOException
     * 
     * Process  getting spy list info as text
     * 
     * */
    public static String doGetListAsText() throws ProtocolException, MalformedURLException, IOException {

        URL url = new URL("http://localhost:8080/WebServiceDesignStyles3ProjectServer/SpyListCollection");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "text/plain");
        con.setDoOutput(true);

        InputStreamReader isr = new InputStreamReader(con.getInputStream());
        BufferedReader br = new BufferedReader(isr);

//       while(br.readLine()!=null){
//           
//       }
        StringBuilder sb = new StringBuilder();
        CharBuffer buf = CharBuffer.allocate(DEFAULT_BUFFER_SIZE);
        while (br.read(buf) >= 0) {
            sb.append(buf.flip());
            buf.clear();
        }
        return sb.toString();
    }
    /**
    
     * @param  s  the spy which is used for add
     * @throws ProtocolException, MalformedURLException, IOException
     * 
     * Process updating information
     * 
     * */
    public static String doPost(Spy s) throws ProtocolException, MalformedURLException, IOException {

        URL url = new URL("http://localhost:8080/WebServiceDesignStyles3ProjectServer/SpyListCollection");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("Accept", "text/xml");
        con.setDoOutput(true);

        OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
        writer.write(s.toXML());
        writer.close();

        InputStreamReader isr = new InputStreamReader(con.getInputStream());
        BufferedReader br = new BufferedReader(isr);
        String str = new String();
        str = br.readLine();

        return str;

    }
    
     /**
     * @param  s  the spy which is used for add
     * @throws ProtocolException, MalformedURLException, IOException
     * 
     * Process deleting information
     * 
     * */

    public static String doDelete(String s) throws ProtocolException, MalformedURLException, IOException {

        URL url = new URL("http://localhost:8080/WebServiceDesignStyles3ProjectServer/SpyListCollection/" + s);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("DELETE");
        con.setRequestProperty("Accept", "text/xml");

        InputStreamReader isr = new InputStreamReader(con.getInputStream());
        BufferedReader br = new BufferedReader(isr);
        String str = new String();
        str = br.readLine();
        isr.close();
        return str;

    }

}
