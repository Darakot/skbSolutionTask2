package dom;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Класс создает документ для парсинга
 * getDocument - возвращает документ с которым будем работать
 */

@AllArgsConstructor
@Log4j
public class DocumentXml {
    private String fileName = "";

    public Document getDocument(){
        ClassLoader classLoader = DocumentXml.class.getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;

        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            log.error(e.getMessage());
        }

        Document document = null;

        try {
            assert builder != null;
            document = builder.parse(file);
        } catch (SAXException | IOException e) {
            log.error(e.getMessage());
        }

        return document;
    }
}
