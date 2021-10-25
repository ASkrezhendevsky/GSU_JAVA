package by.gsu.pms;

import by.gsu.pms.bean.Valute;
import by.gsu.pms.util.Constants;
import by.gsu.pms.util.Tag;
import by.gsu.pms.util.XMLSource;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class RunnerStAX {
    public static void main(String[] args) {
        List<Valute> valuteList = parseXMLfile(XMLSource.getInputStream());

        System.out.println(valuteList);
    }

    private static List<Valute> parseXMLfile(InputStream xmlSource) {
        List<Valute> studentsList = new ArrayList<>();
        Valute valute = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

        try {
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(xmlSource);
            while (reader.hasNext()) {
                XMLEvent xmlEvent = reader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();

                    if (startElement.getName().getLocalPart().equals(Tag.VALUTE.getName())) {
                        valute = new Valute();
                        Attribute idAttr = startElement.getAttributeByName(new QName(Constants.ID_ATTRIBUTE));
                        if (idAttr != null) {
                            valute.setId(idAttr.getValue());
                        }
                    } else if (startElement.getName().getLocalPart().equals(Tag.NUMCODE.getName())) {
                        xmlEvent = reader.nextEvent();
                        valute.setNumCode(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equals(Tag.CHARCODE.getName())) {
                        xmlEvent = reader.nextEvent();
                        valute.setCharCode(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals(Tag.NAME.getName())) {
                        xmlEvent = reader.nextEvent();
                        valute.setName(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals(Tag.VALUE.getName())) {
                        xmlEvent = reader.nextEvent();
                        valute.setValue(xmlEvent.asCharacters().getData());
                    }
                }
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals(Tag.VALUTE.getName())) {
                        studentsList.add(valute);
                    }
                }
            }

        } catch (XMLStreamException exc) {
            exc.printStackTrace();
        }
        return studentsList;
    }
}
