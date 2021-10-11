package by.gsu.pms.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ValutesHandler extends DefaultHandler {
    private enum Tag {
        VALCURS,
        VALUTE,
        NUMCODE,
        CHARCODE,
        NOMINAL,
        NAME,
        VALUE;
    }

    private List<Valute> valutes = new ArrayList<>();

    private Tag currentTag;


    public List<Valute> getValutes() {
        return valutes;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentTag = Tag.valueOf(qName.toUpperCase());
        if (Tag.VALUTE == currentTag) {
            valutes.add(new Valute());
            getCurrentValute().setId(attributes.getValue("ID"));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (Tag.NUMCODE == currentTag) {
            getCurrentValute().setNumCode(Integer.parseInt(new String(ch, start, length)));
        } else if (Tag.CHARCODE == currentTag) {
            getCurrentValute().setCharCode(new String(ch, start, length));
        } else if (Tag.NAME == currentTag) {
            getCurrentValute().setName(new String(ch, start, length));
        } else if (Tag.VALUE == currentTag) {
            NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
            double d = 0;
            try {
                d = format.parse(new String(ch, start, length)).doubleValue();
            } catch (ParseException e) {
                throw new SAXException(e);
            }
            getCurrentValute().setValue((int) Math.round(d * 1000));
        }
    }

    private Valute getCurrentValute() {
        return valutes.get(valutes.size() - 1);
    }
}
