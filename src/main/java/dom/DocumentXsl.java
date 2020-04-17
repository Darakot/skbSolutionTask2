package dom;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Класс для исполнения запроса xsl файлы
 */

public class DocumentXsl {

    public static void queryXsl(String xsl,String xml){
        ClassLoader classLoader = DocumentXsl.class.getClassLoader();
        TransformerFactory factory = TransformerFactory.newInstance();
        StreamSource xslStream = new StreamSource(classLoader.getResource(xsl).getFile());

        StreamSource in = new StreamSource(classLoader.getResource(xml).getFile());
        StreamResult out = new StreamResult(System.out);

        Transformer transformer = null;

        try {

            transformer = factory.newTransformer(xslStream);
            transformer.transform(in,out);

        } catch (
                TransformerException e) {
            e.printStackTrace();
        }
    }
}
