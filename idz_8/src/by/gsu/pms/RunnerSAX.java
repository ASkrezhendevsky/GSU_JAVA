package by.gsu.pms;

import by.gsu.pms.util.ValutesHandler;
import by.gsu.pms.util.XMLSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class RunnerSAX {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        ValutesHandler handler = new ValutesHandler();

        parser.parse(XMLSource.getInputSource(), handler);
        System.out.println(handler.getValutes());
    }
}
