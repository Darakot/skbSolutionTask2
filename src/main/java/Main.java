import dom.DocumentXsl;
import dom.query.DomQueryImpl;

public class Main {
    public static void main(String[] args) {
        DomQueryImpl domQuery = new DomQueryImpl("inputDataXml.xml");

        domQuery.printValueNode();
        domQuery.countNodes();

        DocumentXsl.queryXsl("inputDataXslt.xsl","inputDataXml.xml");
    }
}
