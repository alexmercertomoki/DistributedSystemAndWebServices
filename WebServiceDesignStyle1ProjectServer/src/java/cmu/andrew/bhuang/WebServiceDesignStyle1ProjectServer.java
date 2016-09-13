/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmu.andrew.bhuang;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 * @author Bilei Huang 
 * This is a the client side which sends a request  
 */



@WebService(serviceName = "WebServiceDesignStyle1ProjectServer")
public class WebServiceDesignStyle1ProjectServer {
    HashMap<String,Spy> spyList =new HashMap<String,Spy>();
    
    /**
     * Web service operation
     */
    
    //  This is a method for adding spy 
     /**
     * 
     * @param  name  the name you need to add 
     * @return  String
     *  
     * This is a method for adding spy
     * 
     */
    @WebMethod(operationName = "addSpy")
    public String addSpy(@WebParam(name = "name") String name,
            @WebParam(name = "title") String title, 
            @WebParam(name = "location") String location, 
            @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        String key = name;
       // If the spy exists in the list give info that the spy exists
        if(spyList.containsKey(key)){
            return "addSpy: The Spy exists,No update is made !";
        }
        // if not exists add
        else{
            Spy s=new Spy();
            s.setName(name);
            s.setTitle(title);
            s.setLocation(location);
            s.setPassword(password);
            spyList.put(key, s);
            return "Spy:\nname:"+name+"  title:"+title+"  location:"+location+"  password:"+password;
        }
         
    }

     /**
     * 
     * @param  name  the name you need to update 
     * @return  String
     * This is a method for updating spy  
     * 
     */
    @WebMethod(operationName = "updateSpy")
    public String updateSpy(@WebParam(name = "name") String name, @WebParam(name = "title") String title, @WebParam(name = "location") String location, @WebParam(name = "password") String password) {
      
        
        String key = name;
        // if there is the spy in the spyList update it and return it ..
        if(spyList.containsKey(key)){
            Spy s=new Spy();
            s.setName(name);
            s.setTitle(title);
            s.setLocation(location);
            s.setPassword(password);
            spyList.put(key, s);
            return "Spy:\nname:"+name+"  title:"+title+"  location:"+location+"  password:"+password; 
        }
        // if no such spy exists we tell that 
        else 
        return "updateSpy: no such spy in the list, no update is made";
    }

    
     /**
     * 
     * @param  name  the name you need to get information 
     * @return  String
     * This is a method for getting the spy  information 
     * 
     */
    @WebMethod(operationName = "getSpy")
    public String getSpy(@WebParam(name = "name") String name) {
        //TODO write your implementation code here:
        // if the spy exists return it 
        if(spyList.containsKey(name)){
            Spy s =new Spy();
            s=spyList.get(name);
            String info=s.toXML();
            return info;
        }
        
        // if not exists return the spy not exists 
        else
        return "getSpy: no such spy exists";
    }

    
    /**
     * 
     * @param  name  the name you want to delete 
     * @return  String
     * This is a method for deleting spy  
     * 
     */
    @WebMethod(operationName = "deleteSpy")
    public String deleteSpy(@WebParam(name = "name") String name) {
        //TODO write your implementation code here:
        
        // if the spy exists in the spyList  we delete it 
        
        if(spyList.containsKey(name)){
            spyList.remove(name);
            return "Spy: "+name + " is deleted from the list";
        }
        
        //  if not exists in the list returns no such spy exists 
        else 
            return "no such spy named :" + name + "exists in the list";
    }

    
     /**
     * 
     * @return  String
     * getting a List of spy
     * 
     */
    @WebMethod(operationName = "getList")
    public String getList() {
        //TODO write your implementation code here:
        Iterator it = spyList.entrySet().iterator();
        StringBuilder sb =new StringBuilder();
        while(it.hasNext()){
            
            Map.Entry<String,Spy>  pair =(Map.Entry<String,Spy>)it.next();
          
            sb.append("Spy:\nname:"+pair.getValue().getName()+"  title:"+pair.getValue().getTitle()+
                    "  location:"+pair.getValue().getLocation()+"  password:"+pair.getValue().getPassword()+"\n");
            
        }
        String info = sb.toString();
        return  info;
    }
     /** 
     *  
     * @return  String
     * This is a method for getting a list of spy as XML  
     * 
     */
    @WebMethod(operationName = "getListAsXML")
    public String getListAsXML(){
        //TODO write your implementation code here:
        
        Iterator it = spyList.entrySet().iterator();
        StringBuilder sb =new StringBuilder();
        while(it.hasNext()){
            
            Map.Entry<String,Spy>  pair =(Map.Entry<String,Spy>)it.next();
            sb.append(pair.getValue().toXML()+"\n");
            
        }
        
        String info = sb.toString();
        return  info;
    }
    
    
    
    
}
