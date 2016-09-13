
package bumperservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the bumperservice package. 
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

    private final static QName _GetResponse_QNAME = new QName("http://bumperservice/", "getResponse");
    private final static QName _HelloResponse_QNAME = new QName("http://bumperservice/", "helloResponse");
    private final static QName _Get_QNAME = new QName("http://bumperservice/", "get");
    private final static QName _Bump_QNAME = new QName("http://bumperservice/", "bump");
    private final static QName _BumpResponse_QNAME = new QName("http://bumperservice/", "bumpResponse");
    private final static QName _Hello_QNAME = new QName("http://bumperservice/", "hello");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: bumperservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetResponse }
     * 
     */
    public GetResponse createGetResponse() {
        return new GetResponse();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link Get }
     * 
     */
    public Get createGet() {
        return new Get();
    }

    /**
     * Create an instance of {@link Bump }
     * 
     */
    public Bump createBump() {
        return new Bump();
    }

    /**
     * Create an instance of {@link BumpResponse }
     * 
     */
    public BumpResponse createBumpResponse() {
        return new BumpResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bumperservice/", name = "getResponse")
    public JAXBElement<GetResponse> createGetResponse(GetResponse value) {
        return new JAXBElement<GetResponse>(_GetResponse_QNAME, GetResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bumperservice/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Get }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bumperservice/", name = "get")
    public JAXBElement<Get> createGet(Get value) {
        return new JAXBElement<Get>(_Get_QNAME, Get.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Bump }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bumperservice/", name = "bump")
    public JAXBElement<Bump> createBump(Bump value) {
        return new JAXBElement<Bump>(_Bump_QNAME, Bump.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BumpResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bumperservice/", name = "bumpResponse")
    public JAXBElement<BumpResponse> createBumpResponse(BumpResponse value) {
        return new JAXBElement<BumpResponse>(_BumpResponse_QNAME, BumpResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bumperservice/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

}
