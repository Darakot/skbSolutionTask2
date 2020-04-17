package dom.query;

import dom.DocumentXml;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для запросов
 * printValueNode - выводит в консоль значения атрибута "value" для каждого тега в теле ns1:header
 * countNodes - выводит в консоль количество элементов в body
 * getNodes - приватный метод для получение всех нод в узле
 * getValueNode - приватный метод для получения значения у ноды
 */
public class DomQuery implements DomQueruImpl {
    private DocumentXml documentXML;
    List<String> nodes = new ArrayList<>();

    public DomQuery(String nameFile) {
        documentXML = new DocumentXml(nameFile);
    }

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
                .getDocument()
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
                .getDocument();

        return doc
                .getElementsByTagName(node)
                .item(0)
                .getAttributes()
                .getNamedItem("value")
                .getNodeValue();
    }

}
