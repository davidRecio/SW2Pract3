
package serviciosweb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the serviciosweb package. 
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

    private final static QName _RmvRecetaResponse_QNAME = new QName("http://serviciosWeb/", "rmvRecetaResponse");
    private final static QName _ValidarXSDResponse_QNAME = new QName("http://serviciosWeb/", "validarXSDResponse");
    private final static QName _Receta_QNAME = new QName("http://serviciosWeb/", "Receta");
    private final static QName _StartResponse_QNAME = new QName("http://serviciosWeb/", "startResponse");
    private final static QName _CrearRecetario_QNAME = new QName("http://serviciosWeb/", "crearRecetario");
    private final static QName _ExportarRecetario_QNAME = new QName("http://serviciosWeb/", "exportarRecetario");
    private final static QName _ExportarReceta_QNAME = new QName("http://serviciosWeb/", "exportarReceta");
    private final static QName _Recetario_QNAME = new QName("http://serviciosWeb/", "Recetario");
    private final static QName _AddRecetaResponse_QNAME = new QName("http://serviciosWeb/", "addRecetaResponse");
    private final static QName _RmvReceta_QNAME = new QName("http://serviciosWeb/", "rmvReceta");
    private final static QName _ObtenerRecetario_QNAME = new QName("http://serviciosWeb/", "obtenerRecetario");
    private final static QName _ImportarRecetaResponse_QNAME = new QName("http://serviciosWeb/", "importarRecetaResponse");
    private final static QName _ExportarRecetaResponse_QNAME = new QName("http://serviciosWeb/", "exportarRecetaResponse");
    private final static QName _ImportarRecetarioResponse_QNAME = new QName("http://serviciosWeb/", "importarRecetarioResponse");
    private final static QName _CrearRecetarioResponse_QNAME = new QName("http://serviciosWeb/", "crearRecetarioResponse");
    private final static QName _Start_QNAME = new QName("http://serviciosWeb/", "start");
    private final static QName _IOException_QNAME = new QName("http://serviciosWeb/", "IOException");
    private final static QName _ImportarReceta_QNAME = new QName("http://serviciosWeb/", "importarReceta");
    private final static QName _ObtenerRecetarioResponse_QNAME = new QName("http://serviciosWeb/", "obtenerRecetarioResponse");
    private final static QName _ObtenerReceta_QNAME = new QName("http://serviciosWeb/", "obtenerReceta");
    private final static QName _ObtenerRecetaResponse_QNAME = new QName("http://serviciosWeb/", "obtenerRecetaResponse");
    private final static QName _AddReceta_QNAME = new QName("http://serviciosWeb/", "addReceta");
    private final static QName _ImportarRecetario_QNAME = new QName("http://serviciosWeb/", "importarRecetario");
    private final static QName _ValidarXSD_QNAME = new QName("http://serviciosWeb/", "validarXSD");
    private final static QName _ExportarRecetarioResponse_QNAME = new QName("http://serviciosWeb/", "exportarRecetarioResponse");
    private final static QName _ImportarRecetarioBytes_QNAME = new QName("", "bytes");
    private final static QName _ExportarRecetarioResponseReturn_QNAME = new QName("", "return");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: serviciosweb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Receta }
     * 
     */
    public Receta createReceta() {
        return new Receta();
    }

    /**
     * Create an instance of {@link Recetario }
     * 
     */
    public Recetario createRecetario() {
        return new Recetario();
    }

    /**
     * Create an instance of {@link ExportarReceta }
     * 
     */
    public ExportarReceta createExportarReceta() {
        return new ExportarReceta();
    }

    /**
     * Create an instance of {@link ExportarRecetario }
     * 
     */
    public ExportarRecetario createExportarRecetario() {
        return new ExportarRecetario();
    }

    /**
     * Create an instance of {@link StartResponse }
     * 
     */
    public StartResponse createStartResponse() {
        return new StartResponse();
    }

    /**
     * Create an instance of {@link CrearRecetario }
     * 
     */
    public CrearRecetario createCrearRecetario() {
        return new CrearRecetario();
    }

    /**
     * Create an instance of {@link RmvRecetaResponse }
     * 
     */
    public RmvRecetaResponse createRmvRecetaResponse() {
        return new RmvRecetaResponse();
    }

    /**
     * Create an instance of {@link ValidarXSDResponse }
     * 
     */
    public ValidarXSDResponse createValidarXSDResponse() {
        return new ValidarXSDResponse();
    }

    /**
     * Create an instance of {@link ExportarRecetaResponse }
     * 
     */
    public ExportarRecetaResponse createExportarRecetaResponse() {
        return new ExportarRecetaResponse();
    }

    /**
     * Create an instance of {@link ImportarRecetarioResponse }
     * 
     */
    public ImportarRecetarioResponse createImportarRecetarioResponse() {
        return new ImportarRecetarioResponse();
    }

    /**
     * Create an instance of {@link CrearRecetarioResponse }
     * 
     */
    public CrearRecetarioResponse createCrearRecetarioResponse() {
        return new CrearRecetarioResponse();
    }

    /**
     * Create an instance of {@link ObtenerRecetario }
     * 
     */
    public ObtenerRecetario createObtenerRecetario() {
        return new ObtenerRecetario();
    }

    /**
     * Create an instance of {@link AddRecetaResponse }
     * 
     */
    public AddRecetaResponse createAddRecetaResponse() {
        return new AddRecetaResponse();
    }

    /**
     * Create an instance of {@link RmvReceta }
     * 
     */
    public RmvReceta createRmvReceta() {
        return new RmvReceta();
    }

    /**
     * Create an instance of {@link ImportarRecetaResponse }
     * 
     */
    public ImportarRecetaResponse createImportarRecetaResponse() {
        return new ImportarRecetaResponse();
    }

    /**
     * Create an instance of {@link ObtenerReceta }
     * 
     */
    public ObtenerReceta createObtenerReceta() {
        return new ObtenerReceta();
    }

    /**
     * Create an instance of {@link ObtenerRecetaResponse }
     * 
     */
    public ObtenerRecetaResponse createObtenerRecetaResponse() {
        return new ObtenerRecetaResponse();
    }

    /**
     * Create an instance of {@link ImportarReceta }
     * 
     */
    public ImportarReceta createImportarReceta() {
        return new ImportarReceta();
    }

    /**
     * Create an instance of {@link ObtenerRecetarioResponse }
     * 
     */
    public ObtenerRecetarioResponse createObtenerRecetarioResponse() {
        return new ObtenerRecetarioResponse();
    }

    /**
     * Create an instance of {@link Start }
     * 
     */
    public Start createStart() {
        return new Start();
    }

    /**
     * Create an instance of {@link IOException }
     * 
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link ExportarRecetarioResponse }
     * 
     */
    public ExportarRecetarioResponse createExportarRecetarioResponse() {
        return new ExportarRecetarioResponse();
    }

    /**
     * Create an instance of {@link ImportarRecetario }
     * 
     */
    public ImportarRecetario createImportarRecetario() {
        return new ImportarRecetario();
    }

    /**
     * Create an instance of {@link ValidarXSD }
     * 
     */
    public ValidarXSD createValidarXSD() {
        return new ValidarXSD();
    }

    /**
     * Create an instance of {@link AddReceta }
     * 
     */
    public AddReceta createAddReceta() {
        return new AddReceta();
    }

    /**
     * Create an instance of {@link Receta.Ingrediente }
     * 
     */
    public Receta.Ingrediente createRecetaIngrediente() {
        return new Receta.Ingrediente();
    }

    /**
     * Create an instance of {@link Recetario.Recetas }
     * 
     */
    public Recetario.Recetas createRecetarioRecetas() {
        return new Recetario.Recetas();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RmvRecetaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosWeb/", name = "rmvRecetaResponse")
    public JAXBElement<RmvRecetaResponse> createRmvRecetaResponse(RmvRecetaResponse value) {
        return new JAXBElement<RmvRecetaResponse>(_RmvRecetaResponse_QNAME, RmvRecetaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidarXSDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosWeb/", name = "validarXSDResponse")
    public JAXBElement<ValidarXSDResponse> createValidarXSDResponse(ValidarXSDResponse value) {
        return new JAXBElement<ValidarXSDResponse>(_ValidarXSDResponse_QNAME, ValidarXSDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Receta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosWeb/", name = "Receta")
    public JAXBElement<Receta> createReceta(Receta value) {
        return new JAXBElement<Receta>(_Receta_QNAME, Receta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosWeb/", name = "startResponse")
    public JAXBElement<StartResponse> createStartResponse(StartResponse value) {
        return new JAXBElement<StartResponse>(_StartResponse_QNAME, StartResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrearRecetario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosWeb/", name = "crearRecetario")
    public JAXBElement<CrearRecetario> createCrearRecetario(CrearRecetario value) {
        return new JAXBElement<CrearRecetario>(_CrearRecetario_QNAME, CrearRecetario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExportarRecetario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosWeb/", name = "exportarRecetario")
    public JAXBElement<ExportarRecetario> createExportarRecetario(ExportarRecetario value) {
        return new JAXBElement<ExportarRecetario>(_ExportarRecetario_QNAME, ExportarRecetario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExportarReceta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosWeb/", name = "exportarReceta")
    public JAXBElement<ExportarReceta> createExportarReceta(ExportarReceta value) {
        return new JAXBElement<ExportarReceta>(_ExportarReceta_QNAME, ExportarReceta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Recetario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosWeb/", name = "Recetario")
    public JAXBElement<Recetario> createRecetario(Recetario value) {
        return new JAXBElement<Recetario>(_Recetario_QNAME, Recetario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddRecetaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosWeb/", name = "addRecetaResponse")
    public JAXBElement<AddRecetaResponse> createAddRecetaResponse(AddRecetaResponse value) {
        return new JAXBElement<AddRecetaResponse>(_AddRecetaResponse_QNAME, AddRecetaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RmvReceta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosWeb/", name = "rmvReceta")
    public JAXBElement<RmvReceta> createRmvReceta(RmvReceta value) {
        return new JAXBElement<RmvReceta>(_RmvReceta_QNAME, RmvReceta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerRecetario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosWeb/", name = "obtenerRecetario")
    public JAXBElement<ObtenerRecetario> createObtenerRecetario(ObtenerRecetario value) {
        return new JAXBElement<ObtenerRecetario>(_ObtenerRecetario_QNAME, ObtenerRecetario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImportarRecetaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosWeb/", name = "importarRecetaResponse")
    public JAXBElement<ImportarRecetaResponse> createImportarRecetaResponse(ImportarRecetaResponse value) {
        return new JAXBElement<ImportarRecetaResponse>(_ImportarRecetaResponse_QNAME, ImportarRecetaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExportarRecetaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosWeb/", name = "exportarRecetaResponse")
    public JAXBElement<ExportarRecetaResponse> createExportarRecetaResponse(ExportarRecetaResponse value) {
        return new JAXBElement<ExportarRecetaResponse>(_ExportarRecetaResponse_QNAME, ExportarRecetaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImportarRecetarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosWeb/", name = "importarRecetarioResponse")
    public JAXBElement<ImportarRecetarioResponse> createImportarRecetarioResponse(ImportarRecetarioResponse value) {
        return new JAXBElement<ImportarRecetarioResponse>(_ImportarRecetarioResponse_QNAME, ImportarRecetarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrearRecetarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosWeb/", name = "crearRecetarioResponse")
    public JAXBElement<CrearRecetarioResponse> createCrearRecetarioResponse(CrearRecetarioResponse value) {
        return new JAXBElement<CrearRecetarioResponse>(_CrearRecetarioResponse_QNAME, CrearRecetarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Start }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosWeb/", name = "start")
    public JAXBElement<Start> createStart(Start value) {
        return new JAXBElement<Start>(_Start_QNAME, Start.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IOException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosWeb/", name = "IOException")
    public JAXBElement<IOException> createIOException(IOException value) {
        return new JAXBElement<IOException>(_IOException_QNAME, IOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImportarReceta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosWeb/", name = "importarReceta")
    public JAXBElement<ImportarReceta> createImportarReceta(ImportarReceta value) {
        return new JAXBElement<ImportarReceta>(_ImportarReceta_QNAME, ImportarReceta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerRecetarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosWeb/", name = "obtenerRecetarioResponse")
    public JAXBElement<ObtenerRecetarioResponse> createObtenerRecetarioResponse(ObtenerRecetarioResponse value) {
        return new JAXBElement<ObtenerRecetarioResponse>(_ObtenerRecetarioResponse_QNAME, ObtenerRecetarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerReceta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosWeb/", name = "obtenerReceta")
    public JAXBElement<ObtenerReceta> createObtenerReceta(ObtenerReceta value) {
        return new JAXBElement<ObtenerReceta>(_ObtenerReceta_QNAME, ObtenerReceta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerRecetaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosWeb/", name = "obtenerRecetaResponse")
    public JAXBElement<ObtenerRecetaResponse> createObtenerRecetaResponse(ObtenerRecetaResponse value) {
        return new JAXBElement<ObtenerRecetaResponse>(_ObtenerRecetaResponse_QNAME, ObtenerRecetaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddReceta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosWeb/", name = "addReceta")
    public JAXBElement<AddReceta> createAddReceta(AddReceta value) {
        return new JAXBElement<AddReceta>(_AddReceta_QNAME, AddReceta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImportarRecetario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosWeb/", name = "importarRecetario")
    public JAXBElement<ImportarRecetario> createImportarRecetario(ImportarRecetario value) {
        return new JAXBElement<ImportarRecetario>(_ImportarRecetario_QNAME, ImportarRecetario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidarXSD }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosWeb/", name = "validarXSD")
    public JAXBElement<ValidarXSD> createValidarXSD(ValidarXSD value) {
        return new JAXBElement<ValidarXSD>(_ValidarXSD_QNAME, ValidarXSD.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExportarRecetarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosWeb/", name = "exportarRecetarioResponse")
    public JAXBElement<ExportarRecetarioResponse> createExportarRecetarioResponse(ExportarRecetarioResponse value) {
        return new JAXBElement<ExportarRecetarioResponse>(_ExportarRecetarioResponse_QNAME, ExportarRecetarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "bytes", scope = ImportarRecetario.class)
    public JAXBElement<byte[]> createImportarRecetarioBytes(byte[] value) {
        return new JAXBElement<byte[]>(_ImportarRecetarioBytes_QNAME, byte[].class, ImportarRecetario.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "return", scope = ExportarRecetarioResponse.class)
    public JAXBElement<byte[]> createExportarRecetarioResponseReturn(byte[] value) {
        return new JAXBElement<byte[]>(_ExportarRecetarioResponseReturn_QNAME, byte[].class, ExportarRecetarioResponse.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "bytes", scope = ImportarReceta.class)
    public JAXBElement<byte[]> createImportarRecetaBytes(byte[] value) {
        return new JAXBElement<byte[]>(_ImportarRecetarioBytes_QNAME, byte[].class, ImportarReceta.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "bytes", scope = ValidarXSD.class)
    public JAXBElement<byte[]> createValidarXSDBytes(byte[] value) {
        return new JAXBElement<byte[]>(_ImportarRecetarioBytes_QNAME, byte[].class, ValidarXSD.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "return", scope = ExportarRecetaResponse.class)
    public JAXBElement<byte[]> createExportarRecetaResponseReturn(byte[] value) {
        return new JAXBElement<byte[]>(_ExportarRecetarioResponseReturn_QNAME, byte[].class, ExportarRecetaResponse.class, ((byte[]) value));
    }

}
