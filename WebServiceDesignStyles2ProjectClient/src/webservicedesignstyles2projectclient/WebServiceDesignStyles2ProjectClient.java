/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservicedesignstyles2projectclient;

/**
 *
 * @author Bilei  Huang
 *  This is the   client side for testing  which connects to
 *  the web service to control the spylist 
 * 
 */
public class WebServiceDesignStyles2ProjectClient {

    public static void main(String[] args) {
        
        
        
        String result = "";
        System.out.println("Adding spy jamesb");
        Spy bond = new Spy("jamesb", "spy", "London", "james");
        SpyMessage sb = new SpyMessage(bond, "addSpy");
        result =doSpyOperation(sb.toXML());
        System.out.println(result);
        System.out.println("Adding spy seanb");
        Spy beggs = new Spy("seanb", "spy master", "Pittsburgh", "sean");
        SpyMessage ss = new SpyMessage(beggs, "addSpy");
        result = doSpyOperation(ss.toXML());
        System.out.println(result);
        System.out.println("Adding spy joem");
        Spy mertz = new Spy("joem", "spy", "Los Angeles", "joe");
        SpyMessage sj = new SpyMessage(mertz, "addSpy");
        result = doSpyOperation(sj.toXML());
        System.out.println(result);
        System.out.println("Adding spy mikem");
        Spy mccarthy = new Spy("mikem", "spy", "Cape May", "sesame");
        SpyMessage sm = new SpyMessage(mccarthy, "addSpy");
        result = doSpyOperation(sm.toXML());
        System.out.println(result);
        System.out.println("Displaying spy list");
        SpyMessage list = new SpyMessage(new Spy(), "getList");
       
        result = doSpyOperation(list.toXML());
        System.out.println(result);
        System.out.println("Displaying spy list as XML");
        SpyMessage listXML = new SpyMessage(new Spy(), "getListXML");
        result = doSpyOperation(listXML.toXML());
        System.out.println(result);
        System.out.println("Updating spy jamesb");
        Spy newJames = new Spy("jamesb", "Cool Spy", "New Jersey", "sesame");
        SpyMessage um = new SpyMessage(newJames, "deleteSpy");
        result = doSpyOperation(um.toXML());
        System.out.println(result);
        System.out.println("Displaying spy list");
        list = new SpyMessage(new Spy(), "getList");
        result = doSpyOperation(list.toXML());
        System.out.println(result);
        System.out.println("Deleting spy jamesb");
        Spy james = new Spy("jamesb");
        SpyMessage dm = new SpyMessage(james, "deleteSpy");
        result = doSpyOperation(dm.toXML());
        System.out.println(result);
        System.out.println("Displaying spy list");
        list = new SpyMessage(new Spy(), "getList");
        result = doSpyOperation(list.toXML());
        System.out.println(result);
      
        System.out.println("Displaying spy list as XML");
        listXML = new SpyMessage(new Spy(), "getListAsXML");
        result = doSpyOperation(listXML.toXML());
        System.out.println(result);
        System.out.println("Deleting spy Amos");
        Spy amos = new Spy("amos");
        SpyMessage am = new SpyMessage(amos, "deleteSpy");
        result = doSpyOperation(am.toXML());
        System.out.println(result);

    }

    /**
     * 
     * This is a method for doing the operation of operating spy 
     */
    private static String doSpyOperation(java.lang.String spyString) {
        cmu.edu.bhuang.WebServiceDesignStyles2ProjectServer_Service service = new cmu.edu.bhuang.WebServiceDesignStyles2ProjectServer_Service();
        cmu.edu.bhuang.WebServiceDesignStyles2ProjectServer port = service.getWebServiceDesignStyles2ProjectServerPort();
        return port.doSpyOperation(spyString);
    }

}
