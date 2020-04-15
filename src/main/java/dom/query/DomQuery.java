package dom.query;

import dom.DocumentXML;
import lombok.NoArgsConstructor;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class DomQuery implements DomQueruImpl {
    private DocumentXML documentXML = new DocumentXML();
    List<String> nodes = new ArrayList<>();
    private String nameFile = "inputDataXml.xml";

    @Override
    public void printValueNode() {
        getNodes(nodes,"ns1:header","ns1:h");

        nodes.forEach(node -> System.out.println(getValueNode(node)));
    }

    @Override
    public void countNodes() {
        getNodes(nodes,"body","f");
        System.out.println(nodes.size());
    }

    private void getNodes(List<String> variables, String parentNode, String childNode) {
        if (!variables.isEmpty()) variables.clear();


        NodeList nodes = documentXML
                .getDocument(nameFile)
                .getElementsByTagName(parentNode)
                .item(0)
                .getChildNodes();

        for (int i = 0; i < nodes.getLength(); i++) {
            String nodeName = nodes.item(i).getNodeName();
            if (nodeName.contains(childNode)) variables.add(nodeName);
        }
    }

    private String getValueNode(String node) {
        Document doc = documentXML
                .getDocument(nameFile);

        return doc
                .getElementsByTagName(node)
                .item(0)
                .getAttributes()
                .getNamedItem("value")
                .getNodeValue();
    }

}
