
package it.fperfetti.asos.botteghino.stub;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.fperfetti.asos.botteghino.stub package. 
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

    private final static QName _GetEventsResponse_QNAME = new QName("http://fornitore-paasfab.rhcloud.com/jboss-as-helloworld-ws/FornitoreService", "getEventsResponse");
    private final static QName _GetEvent_QNAME = new QName("http://fornitore-paasfab.rhcloud.com/jboss-as-helloworld-ws/FornitoreService", "getEvent");
    private final static QName _GetEvents_QNAME = new QName("http://fornitore-paasfab.rhcloud.com/jboss-as-helloworld-ws/FornitoreService", "getEvents");
    private final static QName _GetEventsByCategoryResponse_QNAME = new QName("http://fornitore-paasfab.rhcloud.com/jboss-as-helloworld-ws/FornitoreService", "getEventsByCategoryResponse");
    private final static QName _GetCategories_QNAME = new QName("http://fornitore-paasfab.rhcloud.com/jboss-as-helloworld-ws/FornitoreService", "getCategories");
    private final static QName _GetEventResponse_QNAME = new QName("http://fornitore-paasfab.rhcloud.com/jboss-as-helloworld-ws/FornitoreService", "getEventResponse");
    private final static QName _GetEventsByCategory_QNAME = new QName("http://fornitore-paasfab.rhcloud.com/jboss-as-helloworld-ws/FornitoreService", "getEventsByCategory");
    private final static QName _GetCategoriesResponse_QNAME = new QName("http://fornitore-paasfab.rhcloud.com/jboss-as-helloworld-ws/FornitoreService", "getCategoriesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.fperfetti.asos.botteghino.stub
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetEventsByCategoryResponse }
     * 
     */
    public GetEventsByCategoryResponse createGetEventsByCategoryResponse() {
        return new GetEventsByCategoryResponse();
    }

    /**
     * Create an instance of {@link GetEvents }
     * 
     */
    public GetEvents createGetEvents() {
        return new GetEvents();
    }

    /**
     * Create an instance of {@link GetEventsByCategory }
     * 
     */
    public GetEventsByCategory createGetEventsByCategory() {
        return new GetEventsByCategory();
    }

    /**
     * Create an instance of {@link GetEventResponse }
     * 
     */
    public GetEventResponse createGetEventResponse() {
        return new GetEventResponse();
    }

    /**
     * Create an instance of {@link GetCategories }
     * 
     */
    public GetCategories createGetCategories() {
        return new GetCategories();
    }

    /**
     * Create an instance of {@link GetCategoriesResponse }
     * 
     */
    public GetCategoriesResponse createGetCategoriesResponse() {
        return new GetCategoriesResponse();
    }

    /**
     * Create an instance of {@link GetEventsResponse }
     * 
     */
    public GetEventsResponse createGetEventsResponse() {
        return new GetEventsResponse();
    }

    /**
     * Create an instance of {@link GetEvent }
     * 
     */
    public GetEvent createGetEvent() {
        return new GetEvent();
    }

    /**
     * Create an instance of {@link Category }
     * 
     */
    public Category createCategory() {
        return new Category();
    }

    /**
     * Create an instance of {@link ArrayList }
     * 
     */
    public ArrayList createArrayList() {
        return new ArrayList();
    }

    /**
     * Create an instance of {@link Event }
     * 
     */
    public Event createEvent() {
        return new Event();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEventsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fornitore-paasfab.rhcloud.com/jboss-as-helloworld-ws/FornitoreService", name = "getEventsResponse")
    public JAXBElement<GetEventsResponse> createGetEventsResponse(GetEventsResponse value) {
        return new JAXBElement<GetEventsResponse>(_GetEventsResponse_QNAME, GetEventsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEvent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fornitore-paasfab.rhcloud.com/jboss-as-helloworld-ws/FornitoreService", name = "getEvent")
    public JAXBElement<GetEvent> createGetEvent(GetEvent value) {
        return new JAXBElement<GetEvent>(_GetEvent_QNAME, GetEvent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEvents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fornitore-paasfab.rhcloud.com/jboss-as-helloworld-ws/FornitoreService", name = "getEvents")
    public JAXBElement<GetEvents> createGetEvents(GetEvents value) {
        return new JAXBElement<GetEvents>(_GetEvents_QNAME, GetEvents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEventsByCategoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fornitore-paasfab.rhcloud.com/jboss-as-helloworld-ws/FornitoreService", name = "getEventsByCategoryResponse")
    public JAXBElement<GetEventsByCategoryResponse> createGetEventsByCategoryResponse(GetEventsByCategoryResponse value) {
        return new JAXBElement<GetEventsByCategoryResponse>(_GetEventsByCategoryResponse_QNAME, GetEventsByCategoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCategories }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fornitore-paasfab.rhcloud.com/jboss-as-helloworld-ws/FornitoreService", name = "getCategories")
    public JAXBElement<GetCategories> createGetCategories(GetCategories value) {
        return new JAXBElement<GetCategories>(_GetCategories_QNAME, GetCategories.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEventResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fornitore-paasfab.rhcloud.com/jboss-as-helloworld-ws/FornitoreService", name = "getEventResponse")
    public JAXBElement<GetEventResponse> createGetEventResponse(GetEventResponse value) {
        return new JAXBElement<GetEventResponse>(_GetEventResponse_QNAME, GetEventResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEventsByCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fornitore-paasfab.rhcloud.com/jboss-as-helloworld-ws/FornitoreService", name = "getEventsByCategory")
    public JAXBElement<GetEventsByCategory> createGetEventsByCategory(GetEventsByCategory value) {
        return new JAXBElement<GetEventsByCategory>(_GetEventsByCategory_QNAME, GetEventsByCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCategoriesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fornitore-paasfab.rhcloud.com/jboss-as-helloworld-ws/FornitoreService", name = "getCategoriesResponse")
    public JAXBElement<GetCategoriesResponse> createGetCategoriesResponse(GetCategoriesResponse value) {
        return new JAXBElement<GetCategoriesResponse>(_GetCategoriesResponse_QNAME, GetCategoriesResponse.class, null, value);
    }

}
