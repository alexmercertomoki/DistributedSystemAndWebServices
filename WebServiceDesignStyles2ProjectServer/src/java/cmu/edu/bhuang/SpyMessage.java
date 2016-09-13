/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmu.edu.bhuang;



import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

/**
 *
 * @author Bilei Huang
 */
public class SpyMessage {

    private String sxml;
    private Document doc;

    SpyMessage(String xml) {
        sxml = xml;
        doc=this.getDocument(sxml);
    }

    SpyMessage(Spy s, String op) {
        StringBuilder sb = new StringBuilder();
        sb.append("<spyMessage>"
                + "<operation>" + op + "</operation>");
        sb.append(s.toXML());
        sb.append("</spyMessage>");
        sxml = sb.toString();
        doc=this.getDocument(sxml);
    }

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
    
    public Document getDoc(){
        return this.doc;
    }
    public String getSxml(){
        return this.sxml;
    }
}
