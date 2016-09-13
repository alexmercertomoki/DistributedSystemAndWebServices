
package edu.andrew.bhuang;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CoolWebService", targetNamespace = "http://bhuang.andrew.edu/", wsdlLocation = "http://localhost:8080/Coolwebservice/CoolWebService?WSDL")
public class CoolWebService_Service
    extends Service
{

    private final static URL COOLWEBSERVICE_WSDL_LOCATION;
    private final static WebServiceException COOLWEBSERVICE_EXCEPTION;
    private final static QName COOLWEBSERVICE_QNAME = new QName("http://bhuang.andrew.edu/", "CoolWebService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/Coolwebservice/CoolWebService?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        COOLWEBSERVICE_WSDL_LOCATION = url;
        COOLWEBSERVICE_EXCEPTION = e;
    }

    public CoolWebService_Service() {
        super(__getWsdlLocation(), COOLWEBSERVICE_QNAME);
    }

    public CoolWebService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), COOLWEBSERVICE_QNAME, features);
    }

    public CoolWebService_Service(URL wsdlLocation) {
        super(wsdlLocation, COOLWEBSERVICE_QNAME);
    }

    public CoolWebService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, COOLWEBSERVICE_QNAME, features);
    }

    public CoolWebService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CoolWebService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CoolWebService
     */
    @WebEndpoint(name = "CoolWebServicePort")
    public CoolWebService getCoolWebServicePort() {
        return super.getPort(new QName("http://bhuang.andrew.edu/", "CoolWebServicePort"), CoolWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CoolWebService
     */
    @WebEndpoint(name = "CoolWebServicePort")
    public CoolWebService getCoolWebServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://bhuang.andrew.edu/", "CoolWebServicePort"), CoolWebService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (COOLWEBSERVICE_EXCEPTION!= null) {
            throw COOLWEBSERVICE_EXCEPTION;
        }
        return COOLWEBSERVICE_WSDL_LOCATION;
    }

}