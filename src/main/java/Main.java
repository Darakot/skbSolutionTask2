import dom.DocumentXsl;
import dom.query.DomQuery;

public class Main {
    public static void main(String[] args) {
        DomQuery domQuery = new DomQuery("inputDataXml.xml");

        domQuery.printValueNode();
        domQuery.countNodes();

        DocumentXsl.queryXsl("inputDataXslt.xsl","inputDataXml.xml");
    }
}
