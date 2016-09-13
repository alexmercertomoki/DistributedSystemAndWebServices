/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmu.edu.bhuang;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

import org.w3c.dom.*;

/**
 *
 * @author Bilei Huang
 * 
 * This is  the webservice for controlling  the spylist on the server side 
 */


@WebService(serviceName = "WebServiceDesignStyles2ProjectServer")
public class WebServiceDesignStyles2ProjectServer {
    
    static SpyList sl=new SpyList();
    /**
     * Web service operation
     */
    @WebMethod(operationName = "doSpyOperation")
    public String doSpyOperation(@WebParam(name = "spyString") String spyString) {
        //TODO write your implementation code here:
        SpyMessage sm=new SpyMessage(spyString);
        Document  spydoc = sm.getDoc();
        spydoc.getDocumentElement().normalize();
        
        NodeList nl = spydoc.getElementsByTagName("operation");
        Node n = nl.item(0);
        String op = n.getTextContent();
        
       // get all the elements from a spy  
        String name = spydoc.getElementsByTagName("name").item(0).getTextContent();
      
        //here is spyTitle not title   
        String title = spydoc.getElementsByTagName("spyTitle").item(0).getTextContent();
      // System.out.println("asflallallalalalalal"+title);
        String location = spydoc.getElementsByTagName("location").item(0).getTextContent();
       
        String password = spydoc.getElementsByTagName("password").item(0).getTextContent();
        
        String info="";
        // do the operation accordingly 
        if(op.equals("addSpy")){
           info=sl.addSpy(name,title,location,password);
        }
        else if(op.equals("updateSpy")){
           info=sl.updateSpy(name, title, location, password);
        }
        else if(op.equals("getSpy")){
          info=sl.getSpy(name);
        }
        else if(op.equals("deleteSpy")){
          info=sl.deleteSpy(name);
        }
        else if(op.equals("getList")){
          info=sl.getList();
        }
        else if(op.equals("getListAsXML")){
          info=sl.getListAsXML();
        }
       
        return info;
        
    }

    
}
