/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardcredentialserviceclient;

import com.alodiga.card.credential.response.ChangeStatusCardResponse;
import com.alodiga.card.credential.response.StatusCardResponse;
import com.alodiga.card.utils.Constants;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import oracle.jrockit.jfr.tools.ConCatRepository;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author ltoro
 */
public class CardCredentialServiceClient {

    private static final int CONNECTION_TIMEOUT = 5000;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        CardCredentialServiceClient cardCredentialServiceClient = new CardCredentialServiceClient();

//        
//        try {
//            //Thread.sleep(1000);
//            
//            
//            ChangeStatusCardResponse response = cardCredentialServiceClient.changeStatusCard("usuarioWStest", "America/Caracas", "zzTQTPW8sjZ1rXOFtcBmIM7+exK1iSVr4sWp1Avyjh6HqBr1Jlr7pWktVpSQAxziAaLbCmZ3P0GuJgMSBFhrOf/KiQq1YEO2MLhXrhRBtEqgPvt/5TE2++K+Dr//OcjFCArBr+MmpadvpIh4qT4zhau87w5IsFDaZkpzVikB7uM=", "24");
//        } catch (Exception e) {
//          e.printStackTrace();
//        }
//        
//        
//        try {
//            //Thread.sleep(1000);
//            ChangeStatusCardResponse response = cardCredentialServiceClient.changeStatusCard("usuarioWStest", "America/Caracas", "zzTQTPW8sjZ1rXOFtcBmIM7+exK1iSVr4sWp1Avyjh6HqBr1Jlr7pWktVpSQAxziAaLbCmZ3P0GuJgMSBFhrOf/KiQq1YEO2MLhXrhRBtEqgPvt/5TE2++K+Dr//OcjFCArBr+MmpadvpIh4qT4zhau87w5IsFDaZkpzVikB7uM=", "24");
//        } catch (Exception e) {
//        e.printStackTrace();
//            
//        }
        //System.out.println(response.getCodigoRespuesta());
        //ChangeStatusCardResponse cardResponse = cardCredentialServiceClient.changeStatusCard("PilotoWS", "America/Caracas", "InQuo5Q1Gb2tafrmu2mCNCY8frWlBt87tN/iFRNYccrkGuhUmdLhl9gPbbffyY8JQENEt4mjbvCMG+86fEocKja7bOUXpwt9dbdT3kIT0H+aTP1C8E2VtdP6BIJSiw8HdF4U7tRboSuv5TU9g9UH6xotoV0aeWgxLHDnZXHXz5k=","01");
        //System.out.println(cardResponse.getCodigoRespuesta());
        StatusCardResponse statusCardResponse = cardCredentialServiceClient.StatusCard("PilotoWS", "America/Caracas", "InQuo5Q1Gb2tafrmu2mCNCY8frWlBt87tN/iFRNYccrkGuhUmdLhl9gPbbffyY8JQENEt4mjbvCMG+86fEocKja7bOUXpwt9dbdT3kIT0H+aTP1C8E2VtdP6BIJSiw8HdF4U7tRboSuv5TU9g9UH6xotoV0aeWgxLHDnZXHXz5k=");
        System.out.println(statusCardResponse.getCodigo());
        System.out.println(statusCardResponse.getDescripcionProducto());

    }

    public ChangeStatusCardResponse changeStatusCard(String user, String timeZone, String card, String status) throws MalformedURLException, IOException, Exception {
        String formattedSOAPResponse = "";
        try {
            ignoreSSL();
            String responseString = "";
            String outputString = "";
            String wsEndPoint = Constants.URL_PROD;
            URL url = new URL(wsEndPoint);
            URLConnection connection = url.openConnection();
            HttpURLConnection httpConn = (HttpURLConnection) connection;
            httpConn.setConnectTimeout(CONNECTION_TIMEOUT);
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            StringBuilder builder = new StringBuilder("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:syn=\"http://ws.apache.org/ns/synapse\">");
            builder.append("<soapenv:Header/>");
            builder.append("<soapenv:Body>");
            builder.append("<syn:CambiarEstadoRequest>");
            builder.append("<Autenticacion>");
            builder.append("<Usuario>" + Constants.USER_PROD + "</Usuario>");
            builder.append("<Password>" + Constants.PASSWORD_PROD + "</Password>");
            builder.append("</Autenticacion>");
            builder.append("<Originador>");
            builder.append("<Solicitante>" + Constants.USER_PROD + "</Solicitante>");
            builder.append("<ZonaHoraria>" + timeZone + "</ZonaHoraria>");
            builder.append("</Originador>");
            builder.append("<Tarjeta>" + card + "</Tarjeta>");
            builder.append("<NuevoEstado>" + status + "</NuevoEstado>");
            builder.append("</syn:CambiarEstadoRequest>");
            builder.append("</soapenv:Body>");
            builder.append("</soapenv:Envelope>");
            byte[] buffer = new byte[builder.toString().length()];
            buffer = builder.toString().getBytes();
            bout.write(buffer);
            byte[] b = bout.toByteArray();
            String SOAPAction = "CambiarEstado";
            httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
            httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
            httpConn.setRequestProperty("SOAPAction", SOAPAction);
            httpConn.setRequestMethod("POST");
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            OutputStream out = httpConn.getOutputStream();
            // Write the content of the request to the outputstream of the HTTP
            // Connection.
            out.write(b);
            out.close();
            // Ready with sending the request.
            // Read the response.
            InputStreamReader isr = new InputStreamReader(httpConn.getInputStream(), Charset.forName("UTF-8"));
            BufferedReader in = new BufferedReader(isr);
            // Write the SOAP message response to a String.
            while ((responseString = in.readLine()) != null) {
                outputString = outputString + responseString;
            }
            formattedSOAPResponse = formatXML(outputString);
            ChangeStatusCardResponse changeStatusCardResponse = new ChangeStatusCardResponse();
            // Esto se coloca debido a que credencial para algunos escenarios cambia la etiquet
            // puede ser; CodigoRespuesta o Codigo
            try {
                changeStatusCardResponse.setCodigoRespuesta(getTagValue("CodigoRespuesta", formattedSOAPResponse));
            } catch (IndexOutOfBoundsException e) {
                changeStatusCardResponse.setCodigoRespuesta(getTagValue("Codigo", formattedSOAPResponse));
            }

            changeStatusCardResponse.setDescripcion(getTagValue("Descripcion", formattedSOAPResponse));
            changeStatusCardResponse.setTicketWS(getTagValue("TicketWS", formattedSOAPResponse));
            changeStatusCardResponse.setInicio(getTagValue("Inicio", formattedSOAPResponse));
            changeStatusCardResponse.setFin(getTagValue("Fin", formattedSOAPResponse));
            changeStatusCardResponse.setTiempo(getTagValue("Tiempo", formattedSOAPResponse));
            return new ChangeStatusCardResponse(changeStatusCardResponse.getCodigoRespuesta(), changeStatusCardResponse.getDescripcion(), changeStatusCardResponse.getTicketWS(), changeStatusCardResponse.getInicio(), changeStatusCardResponse.getFin(), changeStatusCardResponse.getTiempo());
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
            throw new MalformedURLException();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new IOException();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception();
        }
    }

    public StatusCardResponse StatusCard(String user, String timeZone, String card) throws MalformedURLException, IOException, Exception {
        String formattedSOAPResponse = "";
        try {

            ignoreSSL();
            String responseString = "";
            String outputString = "";
            String wsEndPoint = Constants.URL_PROD;
            URL url = new URL(wsEndPoint);
            URLConnection connection = url.openConnection();
            HttpURLConnection httpConn = (HttpURLConnection) connection;
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            StringBuilder builder = new StringBuilder("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:syn=\"http://ws.apache.org/ns/synapse\">");
            builder.append("<soapenv:Header/>");
            builder.append("<soapenv:Body>");
            builder.append("<syn:ConsultarRequest>");
            builder.append("<Autenticacion>");
            builder.append("<Usuario>" + Constants.USER_PROD + "</Usuario>");
            builder.append("<Password>" + Constants.PASSWORD_PROD + "</Password>");
            builder.append("</Autenticacion>");
            builder.append("<Originador>");
            builder.append("<Solicitante>" + Constants.USER_PROD + "</Solicitante>");
            builder.append("<ZonaHoraria>" + timeZone + "</ZonaHoraria>");
            builder.append("</Originador>");
            builder.append("<Tarjeta>" + card + "</Tarjeta>");
            builder.append("</syn:ConsultarRequest>");
            builder.append("</soapenv:Body>");
            builder.append("</soapenv:Envelope>");
            byte[] buffer = new byte[builder.toString().length()];
            buffer = builder.toString().getBytes();
            bout.write(buffer);
            byte[] b = bout.toByteArray();
            String SOAPAction = "Consultar";
            httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
            httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
            httpConn.setRequestProperty("SOAPAction", SOAPAction);
            httpConn.setRequestMethod("POST");
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            OutputStream out = httpConn.getOutputStream();
            // Write the content of the request to the outputstream of the HTTP
            // Connection.
            out.write(b);
            out.close();
            // Ready with sending the request.
            // Read the response.
            InputStreamReader isr = new InputStreamReader(httpConn.getInputStream(), Charset.forName("UTF-8"));
            BufferedReader in = new BufferedReader(isr);
            // Write the SOAP message response to a String.

            while ((responseString = in.readLine()) != null) {
                outputString = outputString + responseString;
            }
            formattedSOAPResponse = formatXML(outputString);
            StatusCardResponse cardResponse = new StatusCardResponse();
            try {
                cardResponse.setCodigo(getTagValue("Codigo", getTagValue("Response", formattedSOAPResponse)));
                cardResponse.setDescripcion(getTagValue("Descripcion", formattedSOAPResponse));
                cardResponse.setTicketWS(getTagValue("TicketWS", formattedSOAPResponse));
                cardResponse.setInicio(getTagValue("Inicio", formattedSOAPResponse));
                cardResponse.setFin(getTagValue("Fin", formattedSOAPResponse));
                cardResponse.setTiempo(getTagValue("Tiempo", formattedSOAPResponse));
                cardResponse.setNumero(getTagValue("Numero", formattedSOAPResponse));
                cardResponse.setCuenta(getTagValue("Cuenta", formattedSOAPResponse));
                cardResponse.setCodigoEntidad(getTagValue("Codigo", getTagValue("Entidad", formattedSOAPResponse)));
                cardResponse.setDescripcionEntidad(getTagValue("Descripcion", formattedSOAPResponse));
                cardResponse.setSucursal(getTagValue("Sucursal", formattedSOAPResponse));
                cardResponse.setCodigoProducto(getTagValue("Codigo", getTagValue("Producto", formattedSOAPResponse)));
                cardResponse.setDescripcionProducto(getTagValue("Descripcion", formattedSOAPResponse));
                cardResponse.setCodigoEstado(getTagValue("Codigo", getTagValue("Estado", formattedSOAPResponse)));
                cardResponse.setDescripcionEstado(getTagValue("Descripcion", formattedSOAPResponse));
                cardResponse.setActual(getTagValue("Actual", formattedSOAPResponse));
                cardResponse.setAnterior(getTagValue("Anterior", formattedSOAPResponse));
                cardResponse.setDenominacion(getTagValue("Denominacion", formattedSOAPResponse));
                cardResponse.setTipo(getTagValue("Tipo", formattedSOAPResponse));
                cardResponse.setIden(getTagValue("Iden", formattedSOAPResponse));
                cardResponse.setTelefono(getTagValue("Telefono", formattedSOAPResponse));
                cardResponse.setDireccion(getTagValue("Direccion", formattedSOAPResponse));
                cardResponse.setCodigoPostal(getTagValue("CodigoPostal", formattedSOAPResponse));
                cardResponse.setLocalidad(getTagValue("Localidad", formattedSOAPResponse));
                cardResponse.setCodigoPais(getTagValue("Codigo", getTagValue("Pais", formattedSOAPResponse)));
                cardResponse.setDescripcionPais(getTagValue("Descripcion", formattedSOAPResponse));
                cardResponse.setMomentoUltimaActualizacion(getTagValue("MomentoUltimaActualizacion", formattedSOAPResponse));
                cardResponse.setMomentoUltimaOperacionAprobada(getTagValue("MomentoUltimaOperacionAprobada", formattedSOAPResponse));
                cardResponse.setMomentoUltimaOperacionDenegada(getTagValue("MomentoUltimaOperacionDenegada", formattedSOAPResponse));
                cardResponse.setMomentoUltimaBajaBoletin(getTagValue("MomentoUltimaBajaBoletin", formattedSOAPResponse));
                cardResponse.setContadorPinERR(getTagValue("ContadorPinERR", formattedSOAPResponse));

            } catch (ArrayIndexOutOfBoundsException e) {

                cardResponse.setCodigo(getTagValue("Codigo", getTagValue("Response", formattedSOAPResponse)));
                cardResponse.setDescripcion(getTagValue("Descripcion", formattedSOAPResponse));
                cardResponse.setTicketWS(getTagValue("TicketWS", formattedSOAPResponse));
                cardResponse.setInicio(getTagValue("Inicio", formattedSOAPResponse));
                cardResponse.setFin(getTagValue("Fin", formattedSOAPResponse));
                cardResponse.setTiempo(getTagValue("Tiempo", formattedSOAPResponse));
            }

            return new StatusCardResponse(cardResponse.getCodigo(), cardResponse.getDescripcion(), cardResponse.getTicketWS(), cardResponse.getInicio(), cardResponse.getFin(), cardResponse.getTiempo(), cardResponse.getNumero(), cardResponse.getCuenta(), cardResponse.getCodigoEntidad(), cardResponse.getDescripcionEntidad(), cardResponse.getSucursal(), cardResponse.getCodigoProducto(), cardResponse.getDescripcionProducto(), cardResponse.getCodigoEstado(), cardResponse.getDescripcionEstado(), cardResponse.getActual(), cardResponse.getAnterior(), cardResponse.getDenominacion(), cardResponse.getTipo(), cardResponse.getIden(), cardResponse.getTelefono(), cardResponse.getDireccion(), cardResponse.getCodigoPostal(), cardResponse.getLocalidad(), cardResponse.getCodigoPais(), cardResponse.getDescripcionPais(), cardResponse.getMomentoUltimaActualizacion(), cardResponse.getMomentoUltimaOperacionAprobada(), cardResponse.getMomentoUltimaOperacionDenegada(), cardResponse.getMomentoUltimaBajaBoletin(), cardResponse.getContadorPinERR());

        } catch (MalformedURLException ex) {
            ex.printStackTrace();
            throw new MalformedURLException();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new IOException();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception();
        }
    }

    public static String getTagValue(String tagName, String xml) {
        System.out.println("respuesta: " + tagName);
        return xml.split("<" + tagName + ">")[1].split("</" + tagName + ">")[0];
    }

    private static void ignoreSSL() {
        try {
            ////////////////////////////////////////////////////////////////
            //SE COLOCAR PARA IGNORAR SSL
            ///////////////////////////////////////////////////////////////
            XTrustProvider.install();
            final String TEST_URL = "https://10.70.10.71:8000/CASA_SRTMX_TarjetaService?wsdl";
            URL url = new URL(TEST_URL);
            HttpsURLConnection httpsCon = (HttpsURLConnection) url.openConnection();
            httpsCon.setConnectTimeout(5000);
            httpsCon.setHostnameVerifier(new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            httpsCon.connect();
            InputStream is = httpsCon.getInputStream();
            int nread = 0;
            byte[] buf = new byte[8192];
            while ((nread = is.read(buf)) != -1) {
                //System.out.write(buf, 0, nread);
            }
            ////////////////////////////////////////////////////////////////
            //SE COLOCAR PARA IGNORAR SSL
            ///////////////////////////////////////////////////////////////
        } catch (MalformedURLException ex) {
            ex.printStackTrace();

        } catch (IOException ex) {
            ex.printStackTrace();

        }
    }

    // format the XML in pretty String
    private static String formatXML(String unformattedXml) {
        try {
            Document document = parseXmlFile(unformattedXml);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            transformerFactory.setAttribute("indent-number", 3);
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            StreamResult xmlOutput = new StreamResult(new StringWriter());
            transformer.transform(source, xmlOutput);
            return xmlOutput.getWriter().toString();
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }
    // parse XML

    private static Document parseXmlFile(String in) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(in));
            return db.parse(is);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            throw new RuntimeException(e);
        }
    }

}
