package by.gsu.pms.sax;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        ValutesHandler handler = new ValutesHandler();

        parser.parse(new InputSource(new URL("http://www.cbr.ru/scripts/XML_daily.asp").openStream()), handler);
        System.out.println(handler.getValutes());
    }
}
