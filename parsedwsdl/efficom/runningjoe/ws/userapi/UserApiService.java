
package efficom.runningjoe.ws.userapi;

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
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "UserApiService", targetNamespace = "http://efficom/runningjoe/ws/UserApi/", wsdlLocation = "http://grimfor.alwaysdata.net/RunningJoeServer/web/ws/UserApi?wsdl")
public class UserApiService
    extends Service
{

    private final static URL USERAPISERVICE_WSDL_LOCATION;
    private final static WebServiceException USERAPISERVICE_EXCEPTION;
    private final static QName USERAPISERVICE_QNAME = new QName("http://efficom/runningjoe/ws/UserApi/", "UserApiService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://grimfor.alwaysdata.net/RunningJoeServer/web/ws/UserApi?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        USERAPISERVICE_WSDL_LOCATION = url;
        USERAPISERVICE_EXCEPTION = e;
    }

    public UserApiService() {
        super(__getWsdlLocation(), USERAPISERVICE_QNAME);
    }

    public UserApiService(WebServiceFeature... features) {
        super(__getWsdlLocation(), USERAPISERVICE_QNAME, features);
    }

    public UserApiService(URL wsdlLocation) {
        super(wsdlLocation, USERAPISERVICE_QNAME);
    }

    public UserApiService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, USERAPISERVICE_QNAME, features);
    }

    public UserApiService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UserApiService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns UserApiPortType
     */
    @WebEndpoint(name = "UserApiPort")
    public UserApiPortType getUserApiPort() {
        return super.getPort(new QName("http://efficom/runningjoe/ws/UserApi/", "UserApiPort"), UserApiPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns UserApiPortType
     */
    @WebEndpoint(name = "UserApiPort")
    public UserApiPortType getUserApiPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://efficom/runningjoe/ws/UserApi/", "UserApiPort"), UserApiPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (USERAPISERVICE_EXCEPTION!= null) {
            throw USERAPISERVICE_EXCEPTION;
        }
        return USERAPISERVICE_WSDL_LOCATION;
    }

}
