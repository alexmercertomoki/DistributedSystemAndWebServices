
package cmu.andrew.bhuang;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cmu.andrew.bhuang package. 
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

    private final static QName _GetList_QNAME = new QName("http://bhuang.andrew.cmu/", "getList");
    private final static QName _GetListResponse_QNAME = new QName("http://bhuang.andrew.cmu/", "getListResponse");
    private final static QName _UpdateSpy_QNAME = new QName("http://bhuang.andrew.cmu/", "updateSpy");
    private final static QName _AddSpyResponse_QNAME = new QName("http://bhuang.andrew.cmu/", "addSpyResponse");
    private final static QName _GetListAsXML_QNAME = new QName("http://bhuang.andrew.cmu/", "getListAsXML");
    private final static QName _AddSpy_QNAME = new QName("http://bhuang.andrew.cmu/", "addSpy");
    private final static QName _GetSpy_QNAME = new QName("http://bhuang.andrew.cmu/", "getSpy");
    private final static QName _DeleteSpy_QNAME = new QName("http://bhuang.andrew.cmu/", "deleteSpy");
    private final static QName _DeleteSpyResponse_QNAME = new QName("http://bhuang.andrew.cmu/", "deleteSpyResponse");
    private final static QName _UpdateSpyResponse_QNAME = new QName("http://bhuang.andrew.cmu/", "updateSpyResponse");
    private final static QName _GetListAsXMLResponse_QNAME = new QName("http://bhuang.andrew.cmu/", "getListAsXMLResponse");
    private final static QName _GetSpyResponse_QNAME = new QName("http://bhuang.andrew.cmu/", "getSpyResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cmu.andrew.bhuang
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddSpyResponse }
     * 
     */
    public AddSpyResponse createAddSpyResponse() {
        return new AddSpyResponse();
    }

    /**
     * Create an instance of {@link GetListAsXML }
     * 
     */
    public GetListAsXML createGetListAsXML() {
        return new GetListAsXML();
    }

    /**
     * Create an instance of {@link UpdateSpy }
     * 
     */
    public UpdateSpy createUpdateSpy() {
        return new UpdateSpy();
    }

    /**
     * Create an instance of {@link GetList }
     * 
     */
    public GetList createGetList() {
        return new GetList();
    }

    /**
     * Create an instance of {@link GetListResponse }
     * 
     */
    public GetListResponse createGetListResponse() {
        return new GetListResponse();
    }

    /**
     * Create an instance of {@link GetListAsXMLResponse }
     * 
     */
    public GetListAsXMLResponse createGetListAsXMLResponse() {
        return new GetListAsXMLResponse();
    }

    /**
     * Create an instance of {@link GetSpyResponse }
     * 
     */
    public GetSpyResponse createGetSpyResponse() {
        return new GetSpyResponse();
    }

    /**
     * Create an instance of {@link DeleteSpyResponse }
     * 
     */
    public DeleteSpyResponse createDeleteSpyResponse() {
        return new DeleteSpyResponse();
    }

    /**
     * Create an instance of {@link UpdateSpyResponse }
     * 
     */
    public UpdateSpyResponse createUpdateSpyResponse() {
        return new UpdateSpyResponse();
    }

    /**
     * Create an instance of {@link AddSpy }
     * 
     */
    public AddSpy createAddSpy() {
        return new AddSpy();
    }

    /**
     * Create an instance of {@link GetSpy }
     * 
     */
    public GetSpy createGetSpy() {
        return new GetSpy();
    }

    /**
     * Create an instance of {@link DeleteSpy }
     * 
     */
    public DeleteSpy createDeleteSpy() {
        return new DeleteSpy();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bhuang.andrew.cmu/", name = "getList")
    public JAXBElement<GetList> createGetList(GetList value) {
        return new JAXBElement<GetList>(_GetList_QNAME, GetList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bhuang.andrew.cmu/", name = "getListResponse")
    public JAXBElement<GetListResponse> createGetListResponse(GetListResponse value) {
        return new JAXBElement<GetListResponse>(_GetListResponse_QNAME, GetListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateSpy }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bhuang.andrew.cmu/", name = "updateSpy")
    public JAXBElement<UpdateSpy> createUpdateSpy(UpdateSpy value) {
        return new JAXBElement<UpdateSpy>(_UpdateSpy_QNAME, UpdateSpy.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddSpyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bhuang.andrew.cmu/", name = "addSpyResponse")
    public JAXBElement<AddSpyResponse> createAddSpyResponse(AddSpyResponse value) {
        return new JAXBElement<AddSpyResponse>(_AddSpyResponse_QNAME, AddSpyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListAsXML }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bhuang.andrew.cmu/", name = "getListAsXML")
    public JAXBElement<GetListAsXML> createGetListAsXML(GetListAsXML value) {
        return new JAXBElement<GetListAsXML>(_GetListAsXML_QNAME, GetListAsXML.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddSpy }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bhuang.andrew.cmu/", name = "addSpy")
    public JAXBElement<AddSpy> createAddSpy(AddSpy value) {
        return new JAXBElement<AddSpy>(_AddSpy_QNAME, AddSpy.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSpy }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bhuang.andrew.cmu/", name = "getSpy")
    public JAXBElement<GetSpy> createGetSpy(GetSpy value) {
        return new JAXBElement<GetSpy>(_GetSpy_QNAME, GetSpy.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteSpy }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bhuang.andrew.cmu/", name = "deleteSpy")
    public JAXBElement<DeleteSpy> createDeleteSpy(DeleteSpy value) {
        return new JAXBElement<DeleteSpy>(_DeleteSpy_QNAME, DeleteSpy.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteSpyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bhuang.andrew.cmu/", name = "deleteSpyResponse")
    public JAXBElement<DeleteSpyResponse> createDeleteSpyResponse(DeleteSpyResponse value) {
        return new JAXBElement<DeleteSpyResponse>(_DeleteSpyResponse_QNAME, DeleteSpyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateSpyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bhuang.andrew.cmu/", name = "updateSpyResponse")
    public JAXBElement<UpdateSpyResponse> createUpdateSpyResponse(UpdateSpyResponse value) {
        return new JAXBElement<UpdateSpyResponse>(_UpdateSpyResponse_QNAME, UpdateSpyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListAsXMLResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bhuang.andrew.cmu/", name = "getListAsXMLResponse")
    public JAXBElement<GetListAsXMLResponse> createGetListAsXMLResponse(GetListAsXMLResponse value) {
        return new JAXBElement<GetListAsXMLResponse>(_GetListAsXMLResponse_QNAME, GetListAsXMLResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSpyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bhuang.andrew.cmu/", name = "getSpyResponse")
    public JAXBElement<GetSpyResponse> createGetSpyResponse(GetSpyResponse value) {
        return new JAXBElement<GetSpyResponse>(_GetSpyResponse_QNAME, GetSpyResponse.class, null, value);
    }

}
