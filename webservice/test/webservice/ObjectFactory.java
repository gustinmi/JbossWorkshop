
package webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservice package. 
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

    private final static QName _SayHello_QNAME = new QName("http://webservices.samples.jboss.org/", "sayHello");
    private final static QName _SayHelloResponse_QNAME = new QName("http://webservices.samples.jboss.org/", "sayHelloResponse");
    private final static QName _SayHelloParams_QNAME = new QName("http://webservices.samples.jboss.org/", "sayHelloParams");
    private final static QName _SayHelloParamsResponse_QNAME = new QName("http://webservices.samples.jboss.org/", "sayHelloParamsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SayHelloParamsResponse }
     * 
     */
    public SayHelloParamsResponse createSayHelloParamsResponse() {
        return new SayHelloParamsResponse();
    }

    /**
     * Create an instance of {@link SayHelloResponse }
     * 
     */
    public SayHelloResponse createSayHelloResponse() {
        return new SayHelloResponse();
    }

    /**
     * Create an instance of {@link SayHello }
     * 
     */
    public SayHello createSayHello() {
        return new SayHello();
    }

    /**
     * Create an instance of {@link SayHelloParams }
     * 
     */
    public SayHelloParams createSayHelloParams() {
        return new SayHelloParams();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.samples.jboss.org/", name = "sayHello")
    public JAXBElement<SayHello> createSayHello(SayHello value) {
        return new JAXBElement<SayHello>(_SayHello_QNAME, SayHello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.samples.jboss.org/", name = "sayHelloResponse")
    public JAXBElement<SayHelloResponse> createSayHelloResponse(SayHelloResponse value) {
        return new JAXBElement<SayHelloResponse>(_SayHelloResponse_QNAME, SayHelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHelloParams }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.samples.jboss.org/", name = "sayHelloParams")
    public JAXBElement<SayHelloParams> createSayHelloParams(SayHelloParams value) {
        return new JAXBElement<SayHelloParams>(_SayHelloParams_QNAME, SayHelloParams.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHelloParamsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.samples.jboss.org/", name = "sayHelloParamsResponse")
    public JAXBElement<SayHelloParamsResponse> createSayHelloParamsResponse(SayHelloParamsResponse value) {
        return new JAXBElement<SayHelloParamsResponse>(_SayHelloParamsResponse_QNAME, SayHelloParamsResponse.class, null, value);
    }

}
