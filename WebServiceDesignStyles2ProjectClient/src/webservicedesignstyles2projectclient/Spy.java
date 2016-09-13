/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservicedesignstyles2projectclient;


/**
 *
 * @author BILEI   
 *  This is the spy class
 */
class Spy {
// instance data for spies private String name; private String title; private String location; private String password;

    private String name;
    private String title;
    private String location;
    private String password;

    Spy(String name) {
        
        this.name= name;
        this.title = "";
        this.location = "";
        this.password = "";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

public void setLocation(String location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

  
    public Spy() {
        this.name = "";
        this.title = "";
        this.location = "";
        this.password = "";
    }
    
    public Spy(String name,String title,String location,String password) {
        this.name = name;
        this.title = title;
        this.location = location;
        this.password =password;
    }

    public String toXML() {
        StringBuffer xml = new StringBuffer();
        xml.append("<spy>");
        xml.append("<name>" + name + "</name>");
        xml.append("<spyTitle>" + title + "</spyTitle>");
        xml.append("<location>" + location + "</location>");
        xml.append("<password>" + password + "</password>");
        xml.append("</spy>");
        return xml.toString();
    }
    
}
