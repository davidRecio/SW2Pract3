
package serviciosweb;

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
 * JAX-WS RI 2.2.10-b140803.1500
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "servicioWebRecetario", targetNamespace = "http://serviciosWeb/", wsdlLocation = "http://localhost:8080/Practica2SOAPClass/servicioWebRecetario?wsdl")
public class ServicioWebRecetario_Service
    extends Service
{

    private final static URL SERVICIOWEBRECETARIO_WSDL_LOCATION;
    private final static WebServiceException SERVICIOWEBRECETARIO_EXCEPTION;
    private final static QName SERVICIOWEBRECETARIO_QNAME = new QName("http://serviciosWeb/", "servicioWebRecetario");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/Practica2SOAPClass/servicioWebRecetario?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SERVICIOWEBRECETARIO_WSDL_LOCATION = url;
        SERVICIOWEBRECETARIO_EXCEPTION = e;
    }

    public ServicioWebRecetario_Service() {
        super(__getWsdlLocation(), SERVICIOWEBRECETARIO_QNAME);
    }

    public ServicioWebRecetario_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), SERVICIOWEBRECETARIO_QNAME, features);
    }

    public ServicioWebRecetario_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICIOWEBRECETARIO_QNAME);
    }

    public ServicioWebRecetario_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SERVICIOWEBRECETARIO_QNAME, features);
    }

    public ServicioWebRecetario_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServicioWebRecetario_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ServicioWebRecetario
     */
    @WebEndpoint(name = "servicioWebRecetarioPort")
    public ServicioWebRecetario getServicioWebRecetarioPort() {
        return super.getPort(new QName("http://serviciosWeb/", "servicioWebRecetarioPort"), ServicioWebRecetario.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServicioWebRecetario
     */
    @WebEndpoint(name = "servicioWebRecetarioPort")
    public ServicioWebRecetario getServicioWebRecetarioPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://serviciosWeb/", "servicioWebRecetarioPort"), ServicioWebRecetario.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SERVICIOWEBRECETARIO_EXCEPTION!= null) {
            throw SERVICIOWEBRECETARIO_EXCEPTION;
        }
        return SERVICIOWEBRECETARIO_WSDL_LOCATION;
    }

}
