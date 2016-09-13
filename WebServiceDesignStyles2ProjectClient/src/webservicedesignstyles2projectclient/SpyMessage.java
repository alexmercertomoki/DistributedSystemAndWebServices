/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservicedesignstyles2projectclient;



import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

/**
 * 
 * @author Bilei Huang 
 * This is the spy message class which is used for transmitting spy information 
 * 
 */
public class SpyMessage {

    private String sxml;
    private Document doc;
    // formming the message in  xml form and document form 
    SpyMessage(String xml) {
        sxml = xml;
        doc=this.getDocument(sxml);
    }
     //  getting the spy message from the client side 
    SpyMessage(Spy s, String op) {
        StringBuilder sb = new StringBuilder();
        sb.append("<spyMessage>"
                + "<operation>" + op + "</operation>");
        sb.append(s.toXML());
        sb.append("</spyMessage>");
        sxml = sb.toString();
        doc=this.getDocument(sxml);
    }
     // getting the document 
    private Document getDocument(String sxml) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
       
        Document spyDoc = null;
        try {
            builder = factory.newDocumentBuilder();
            spyDoc = builder.parse(new InputSource(new StringReader(sxml)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return spyDoc;
    }
    
    // getting document 
    public Document getDoc(){
        return this.doc;
    }
    //  getting xml 
    public String getSxml(){
        return this.sxml;
    }
    // get the message to xml 
    public String toXML(){
        return this.sxml;
    }
    
}
