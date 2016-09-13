
package edu.andrew.bhuang;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.andrew.bhuang package. 
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

    private final static QName _PurchaseResponse_QNAME = new QName("http://bhuang.andrew.edu/", "purchaseResponse");
    private final static QName _Purchase_QNAME = new QName("http://bhuang.andrew.edu/", "purchase");
    private final static QName _FooResponse_QNAME = new QName("http://bhuang.andrew.edu/", "fooResponse");
    private final static QName _Foo_QNAME = new QName("http://bhuang.andrew.edu/", "foo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.andrew.bhuang
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FooResponse }
     * 
     */
    public FooResponse createFooResponse() {
        return new FooResponse();
    }

    /**
     * Create an instance of {@link Foo }
     * 
     */
    public Foo createFoo() {
        return new Foo();
    }

    /**
     * Create an instance of {@link Purchase }
     * 
     */
    public Purchase createPurchase() {
        return new Purchase();
    }

    /**
     * Create an instance of {@link PurchaseResponse }
     * 
     */
    public PurchaseResponse createPurchaseResponse() {
        return new PurchaseResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PurchaseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bhuang.andrew.edu/", name = "purchaseResponse")
    public JAXBElement<PurchaseResponse> createPurchaseResponse(PurchaseResponse value) {
        return new JAXBElement<PurchaseResponse>(_PurchaseResponse_QNAME, PurchaseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Purchase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bhuang.andrew.edu/", name = "purchase")
    public JAXBElement<Purchase> createPurchase(Purchase value) {
        return new JAXBElement<Purchase>(_Purchase_QNAME, Purchase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FooResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bhuang.andrew.edu/", name = "fooResponse")
    public JAXBElement<FooResponse> createFooResponse(FooResponse value) {
        return new JAXBElement<FooResponse>(_FooResponse_QNAME, FooResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Foo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bhuang.andrew.edu/", name = "foo")
    public JAXBElement<Foo> createFoo(Foo value) {
        return new JAXBElement<Foo>(_Foo_QNAME, Foo.class, null, value);
    }

}
