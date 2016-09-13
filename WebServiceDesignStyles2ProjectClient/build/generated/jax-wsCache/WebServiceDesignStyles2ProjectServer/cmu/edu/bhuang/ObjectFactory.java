
package cmu.edu.bhuang;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cmu.edu.bhuang package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DoSpyOperationResponse_QNAME = new QName("http://bhuang.edu.cmu/", "doSpyOperationResponse");
    private final static QName _DoSpyOperation_QNAME = new QName("http://bhuang.edu.cmu/", "doSpyOperation");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cmu.edu.bhuang
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DoSpyOperation }
     * 
     */
    public DoSpyOperation createDoSpyOperation() {
        return new DoSpyOperation();
    }

    /**
     * Create an instance of {@link DoSpyOperationResponse }
     * 
     */
    public DoSpyOperationResponse createDoSpyOperationResponse() {
        return new DoSpyOperationResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DoSpyOperationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bhuang.edu.cmu/", name = "doSpyOperationResponse")
    public JAXBElement<DoSpyOperationResponse> createDoSpyOperationResponse(DoSpyOperationResponse value) {
        return new JAXBElement<DoSpyOperationResponse>(_DoSpyOperationResponse_QNAME, DoSpyOperationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DoSpyOperation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bhuang.edu.cmu/", name = "doSpyOperation")
    public JAXBElement<DoSpyOperation> createDoSpyOperation(DoSpyOperation value) {
        return new JAXBElement<DoSpyOperation>(_DoSpyOperation_QNAME, DoSpyOperation.class, null, value);
    }

}
