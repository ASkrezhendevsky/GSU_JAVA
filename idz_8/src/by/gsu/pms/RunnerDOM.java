package by.gsu.pms;

import by.gsu.pms.bean.Valute;
import by.gsu.pms.util.Constants;
import by.gsu.pms.util.Tag;
import by.gsu.pms.util.XMLSource;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RunnerDOM {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(XMLSource.getInputSource());

        NodeList valutes = document.getDocumentElement().getChildNodes();

        List<Valute> valuteList = new ArrayList<>();

        for (int i = 0; i < valutes.getLength(); i++) {
            Node valuteNode = valutes.item(i);

            Valute valute = new Valute();

            NodeList childNodes = valuteNode.getChildNodes();

            valute.setId(valuteNode.getAttributes().getNamedItem(Constants.ID_ATTRIBUTE).getNodeValue());

            valute.setName(childNodes.item(Tag.NAME.getChildId()).getTextContent());
            valute.setNumCode(childNodes.item(Tag.NUMCODE.getChildId()).getTextContent());
            valute.setCharCode(childNodes.item(Tag.CHARCODE.getChildId()).getTextContent());
            valute.setValue(childNodes.item(Tag.VALUE.getChildId()).getTextContent());

            valuteList.add(valute);
        }

        System.out.println(valuteList);
    }
}
