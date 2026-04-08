package com.example.soap_api_practice.utils;

import jakarta.xml.bind.*;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.StringReader;
import java.io.StringWriter;

@Component
public class XMLUtils {

    public static <T> T convertXmlToDto(String xml, Class<T> clazz){
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();

//            String soapResponseBody = extractSoapBody(xml);
//            System.out.println(soapResponseBody);
            System.out.println(xml);

            return (T) unmarshaller.unmarshal(new StringReader(xml));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }

    public static String convertDtoToXml(Object obj) {
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);

            return writer.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*public static String extractSoapBody(String soapXml) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true); // VERY IMPORTANT

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new ByteArrayInputStream(soapXml.getBytes()));

            NodeList bodyList = document.getElementsByTagNameNS("*", "Body");
            Node body = bodyList.item(0);

            // Get first child inside Body (your actual response)
            Node responseNode = body.getFirstChild();

            // Convert Node → String
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(responseNode), new StreamResult(writer));

            return writer.toString();

        } catch (Exception e) {
            throw new RuntimeException("Error extracting SOAP body", e);
        }
    }*/
}
