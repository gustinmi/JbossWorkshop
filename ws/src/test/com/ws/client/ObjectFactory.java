
package com.ws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ws.client package. 
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

    private final static QName _InitJobResponse_QNAME = new QName("http://housing.com/", "initJobResponse");
    private final static QName _InitJob_QNAME = new QName("http://housing.com/", "initJob");
    private final static QName _SayHello_QNAME = new QName("http://housing.com/", "sayHello");
    private final static QName _SayHelloResponse_QNAME = new QName("http://housing.com/", "sayHelloResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ws.client
     * 
     */
    public ObjectFactory() {
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
     * Create an instance of {@link InitJob }
     * 
     */
    public InitJob createInitJob() {
        return new InitJob();
    }

    /**
     * Create an instance of {@link InitJobResponse }
     * 
     */
    public InitJobResponse createInitJobResponse() {
        return new InitJobResponse();
    }

    /**
     * Create an instance of {@link WebResult }
     * 
     */
    public WebResult createWebResult() {
        return new WebResult();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InitJobResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://housing.com/", name = "initJobResponse")
    public JAXBElement<InitJobResponse> createInitJobResponse(InitJobResponse value) {
        return new JAXBElement<InitJobResponse>(_InitJobResponse_QNAME, InitJobResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InitJob }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://housing.com/", name = "initJob")
    public JAXBElement<InitJob> createInitJob(InitJob value) {
        return new JAXBElement<InitJob>(_InitJob_QNAME, InitJob.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://housing.com/", name = "sayHello")
    public JAXBElement<SayHello> createSayHello(SayHello value) {
        return new JAXBElement<SayHello>(_SayHello_QNAME, SayHello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://housing.com/", name = "sayHelloResponse")
    public JAXBElement<SayHelloResponse> createSayHelloResponse(SayHelloResponse value) {
        return new JAXBElement<SayHelloResponse>(_SayHelloResponse_QNAME, SayHelloResponse.class, null, value);
    }

}
