package by.gsu.pms.util;

import by.gsu.pms.bean.Valute;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class ValutesHandler extends DefaultHandler {
    private List<Valute> valutes = new ArrayList<>();

    private Tag currentTag;


    public List<Valute> getValutes() {
        return valutes;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentTag = Tag.valueOf(qName.toUpperCase());
        if (Tag.VALUTE == currentTag) {
            valutes.add(new Valute());
            getCurrentValute().setId(attributes.getValue(Constants.ID_ATTRIBUTE));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (Tag.NUMCODE == currentTag) {
            getCurrentValute().setNumCode(new String(ch, start, length));
        } else if (Tag.CHARCODE == currentTag) {
            getCurrentValute().setCharCode(new String(ch, start, length));
        } else if (Tag.NAME == currentTag) {
            getCurrentValute().setName(new String(ch, start, length));
        } else if (Tag.VALUE == currentTag) {
            getCurrentValute().setValue(new String(ch, start, length));
        }
    }

    private Valute getCurrentValute() {
        return valutes.get(valutes.size() - 1);
    }
}
