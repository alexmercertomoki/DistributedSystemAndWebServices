
package cmu.andrew.bhuang;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WebServiceDesignStyle1ProjectServer", targetNamespace = "http://bhuang.andrew.cmu/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WebServiceDesignStyle1ProjectServer {


    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getSpy", targetNamespace = "http://bhuang.andrew.cmu/", className = "cmu.andrew.bhuang.GetSpy")
    @ResponseWrapper(localName = "getSpyResponse", targetNamespace = "http://bhuang.andrew.cmu/", className = "cmu.andrew.bhuang.GetSpyResponse")
    @Action(input = "http://bhuang.andrew.cmu/WebServiceDesignStyle1ProjectServer/getSpyRequest", output = "http://bhuang.andrew.cmu/WebServiceDesignStyle1ProjectServer/getSpyResponse")
    public String getSpy(
        @WebParam(name = "name", targetNamespace = "")
        String name);

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getList", targetNamespace = "http://bhuang.andrew.cmu/", className = "cmu.andrew.bhuang.GetList")
    @ResponseWrapper(localName = "getListResponse", targetNamespace = "http://bhuang.andrew.cmu/", className = "cmu.andrew.bhuang.GetListResponse")
    @Action(input = "http://bhuang.andrew.cmu/WebServiceDesignStyle1ProjectServer/getListRequest", output = "http://bhuang.andrew.cmu/WebServiceDesignStyle1ProjectServer/getListResponse")
    public String getList();

    /**
     * 
     * @param password
     * @param name
     * @param location
     * @param title
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addSpy", targetNamespace = "http://bhuang.andrew.cmu/", className = "cmu.andrew.bhuang.AddSpy")
    @ResponseWrapper(localName = "addSpyResponse", targetNamespace = "http://bhuang.andrew.cmu/", className = "cmu.andrew.bhuang.AddSpyResponse")
    @Action(input = "http://bhuang.andrew.cmu/WebServiceDesignStyle1ProjectServer/addSpyRequest", output = "http://bhuang.andrew.cmu/WebServiceDesignStyle1ProjectServer/addSpyResponse")
    public String addSpy(
        @WebParam(name = "name", targetNamespace = "")
        String name,
        @WebParam(name = "title", targetNamespace = "")
        String title,
        @WebParam(name = "location", targetNamespace = "")
        String location,
        @WebParam(name = "password", targetNamespace = "")
        String password);

    /**
     * 
     * @param password
     * @param name
     * @param location
     * @param title
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateSpy", targetNamespace = "http://bhuang.andrew.cmu/", className = "cmu.andrew.bhuang.UpdateSpy")
    @ResponseWrapper(localName = "updateSpyResponse", targetNamespace = "http://bhuang.andrew.cmu/", className = "cmu.andrew.bhuang.UpdateSpyResponse")
    @Action(input = "http://bhuang.andrew.cmu/WebServiceDesignStyle1ProjectServer/updateSpyRequest", output = "http://bhuang.andrew.cmu/WebServiceDesignStyle1ProjectServer/updateSpyResponse")
    public String updateSpy(
        @WebParam(name = "name", targetNamespace = "")
        String name,
        @WebParam(name = "title", targetNamespace = "")
        String title,
        @WebParam(name = "location", targetNamespace = "")
        String location,
        @WebParam(name = "password", targetNamespace = "")
        String password);

    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteSpy", targetNamespace = "http://bhuang.andrew.cmu/", className = "cmu.andrew.bhuang.DeleteSpy")
    @ResponseWrapper(localName = "deleteSpyResponse", targetNamespace = "http://bhuang.andrew.cmu/", className = "cmu.andrew.bhuang.DeleteSpyResponse")
    @Action(input = "http://bhuang.andrew.cmu/WebServiceDesignStyle1ProjectServer/deleteSpyRequest", output = "http://bhuang.andrew.cmu/WebServiceDesignStyle1ProjectServer/deleteSpyResponse")
    public String deleteSpy(
        @WebParam(name = "name", targetNamespace = "")
        String name);

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getListAsXML", targetNamespace = "http://bhuang.andrew.cmu/", className = "cmu.andrew.bhuang.GetListAsXML")
    @ResponseWrapper(localName = "getListAsXMLResponse", targetNamespace = "http://bhuang.andrew.cmu/", className = "cmu.andrew.bhuang.GetListAsXMLResponse")
    @Action(input = "http://bhuang.andrew.cmu/WebServiceDesignStyle1ProjectServer/getListAsXMLRequest", output = "http://bhuang.andrew.cmu/WebServiceDesignStyle1ProjectServer/getListAsXMLResponse")
    public String getListAsXML();

}