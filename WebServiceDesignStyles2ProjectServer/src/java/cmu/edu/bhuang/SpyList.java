/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmu.edu.bhuang;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;


public class SpyList {
      HashMap<String,Spy> spyList= new HashMap<String,Spy>();
      public String addSpy(String name,String title,String location,String password){
          
        String key = name;
       
        if(spyList.containsKey(key)){
            return "addSpy: The Spy exists,No update is made !";
        }
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

   public String updateSpy(String name,String title,String location,String password){
        String key = name;
      
        if(spyList.containsKey(key)){
            Spy s=new Spy();
            s.setName(name);
            s.setTitle(title);
            s.setLocation(location);
            s.setPassword(password);
            spyList.put(key, s);
            return "Spy:\nname:"+name+"  title:"+title+"  location:"+location+"  password:"+password; 
        }
        else 
        return "updateSpy: no such spy in the list, no update is made";
   
   }
   
   
   public String getSpy(String name){
     if(spyList.containsKey(name)){
            Spy s =new Spy();
            s=spyList.get(name);
            String info=s.toXML();
            return info;
        }
        else
        return "getSpy: no such spy exists";
   }
   
   
    public String getList(){
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
    
     public String deleteSpy(String name){
        if(spyList.containsKey(name)){
            spyList.remove(name);
            return "Spy: "+name + "is deleted from the list";
        }
        else 
            return "no such spy named :" + name + "exists in the list";
     }
     
     
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
