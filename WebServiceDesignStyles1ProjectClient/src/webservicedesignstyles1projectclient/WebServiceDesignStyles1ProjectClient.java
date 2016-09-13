/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservicedesignstyles1projectclient;


/**
 *
 * @author Bilei Huang
 */
public class WebServiceDesignStyles1ProjectClient {

    /**
     * 
     * @param args the command line arguments
     * This is for testing the web service  
     * 
     */
    
    public static void main(String[] args) {
    
        addSpy("mikem", "spy", "Pittsburgh", "sesame");
        System.out.println(getList());
        System.out.println(getListAsXML());
        addSpy("mikem", "spy", "Pittsburgh", "sesame");
        addSpy("joem", "spy", "North Hills", "xyz");
        addSpy("seanb", "spy commander", "South Hills", "abcdefg");
        addSpy("jamesb", "spy", "Adelaide", "sydney");
        addSpy("adekunle", "spy", "Pittsburgh", "secret");
        System.out.println(getList());
        System.out.println(getListAsXML());
        updateSpy("mikem", "super spy", "Pittsburgh", "sesame");
        System.out.println(getListAsXML());
        String result = getSpy("jamesb");
        System.out.println(result);
        deleteSpy("jamesb");
        result = getSpy("jamesb");
        System.out.println(result);

    }

    private static String addSpy(java.lang.String name, java.lang.String title, java.lang.String location, java.lang.String password) {
        cmu.andrew.bhuang.WebServiceDesignStyle1ProjectServer_Service service = new cmu.andrew.bhuang.WebServiceDesignStyle1ProjectServer_Service();
        cmu.andrew.bhuang.WebServiceDesignStyle1ProjectServer port = service.getWebServiceDesignStyle1ProjectServerPort();
        return port.addSpy(name, title, location, password);
    }

    private static String deleteSpy(java.lang.String name) {
        cmu.andrew.bhuang.WebServiceDesignStyle1ProjectServer_Service service = new cmu.andrew.bhuang.WebServiceDesignStyle1ProjectServer_Service();
        cmu.andrew.bhuang.WebServiceDesignStyle1ProjectServer port = service.getWebServiceDesignStyle1ProjectServerPort();
        return port.deleteSpy(name);
    }

    private static String getList() {
        cmu.andrew.bhuang.WebServiceDesignStyle1ProjectServer_Service service = new cmu.andrew.bhuang.WebServiceDesignStyle1ProjectServer_Service();
        cmu.andrew.bhuang.WebServiceDesignStyle1ProjectServer port = service.getWebServiceDesignStyle1ProjectServerPort();
        return port.getList();
    }

    private static String getSpy(java.lang.String name) {
        cmu.andrew.bhuang.WebServiceDesignStyle1ProjectServer_Service service = new cmu.andrew.bhuang.WebServiceDesignStyle1ProjectServer_Service();
        cmu.andrew.bhuang.WebServiceDesignStyle1ProjectServer port = service.getWebServiceDesignStyle1ProjectServerPort();
        return port.getSpy(name);
    }

    private static String getListAsXML() {
        cmu.andrew.bhuang.WebServiceDesignStyle1ProjectServer_Service service = new cmu.andrew.bhuang.WebServiceDesignStyle1ProjectServer_Service();
        cmu.andrew.bhuang.WebServiceDesignStyle1ProjectServer port = service.getWebServiceDesignStyle1ProjectServerPort();
        return port.getListAsXML();
    }

    private static String updateSpy(java.lang.String name, java.lang.String title, java.lang.String location, java.lang.String password) {
        cmu.andrew.bhuang.WebServiceDesignStyle1ProjectServer_Service service = new cmu.andrew.bhuang.WebServiceDesignStyle1ProjectServer_Service();
        cmu.andrew.bhuang.WebServiceDesignStyle1ProjectServer port = service.getWebServiceDesignStyle1ProjectServerPort();
        return port.updateSpy(name, title, location, password);
    }

    

}
