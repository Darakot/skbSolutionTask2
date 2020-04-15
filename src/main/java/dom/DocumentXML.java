package dom;

import lombok.NoArgsConstructor;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

@NoArgsConstructor
public class DocumentXML {

    public Document getDocument(String nameDoc){
        ClassLoader classLoader = DocumentXML.class.getClassLoader();
        File file = new File(classLoader.getResource(nameDoc).getFile());

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;

        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        Document document = null;

        try {
            assert builder != null;
            document = builder.parse(file);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        return document;
    }
}
