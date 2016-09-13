/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class SpyList {

    private Map tree = new TreeMap();
    
    private static SpyList spyList = new SpyList();
    
    private SpyList() {
    }
    
    public boolean ifexists(Spy s){
        
        if(tree.containsKey(s.getName()))
            return true;
        
        else 
            return false;
        
    }
    public boolean ifexists(String s){
        
        if(tree.containsKey(s))
            return true;
        
        else 
            return false;
        
    }
   
    public static SpyList getInstance() {
        return spyList;
    }

    public void add(Spy s) {
        tree.put(s.getName(), s);
    }

//    public void update(Spy s) {
//        
//        tree.put(s.getName(), s);
//    }

    public Object delete(String s) {
        return tree.remove(s);
    }

    public Spy get(String userID) {
        return (Spy) tree.get(userID);
    }

    public Collection getList() {
        return tree.values();
    }
    
    

    public String toString() {
        StringBuffer representation = new StringBuffer();
        Collection c = getList();
        Iterator sl = c.iterator();
       
        while (sl.hasNext()) {
            Spy spy = (Spy) sl.next();
            representation.append("Name: " + spy.getName() + " Title: " + spy.getTitle()
                    + " Location: " + spy.getLocation());
        }
        return representation.toString();
    }

    public String toXML() {
        StringBuffer xml = new StringBuffer();
        xml.append("<spylist>\n");
        Collection c = getList();
        Iterator sl = c.iterator();
        while (sl.hasNext()) {
            Spy spy = (Spy) sl.next();
            xml.append(spy.toXML());
        }

        System.out.println("Spy list:" + xml.toString());
        return "Spy list:"+xml.toString();
    }
    
}
