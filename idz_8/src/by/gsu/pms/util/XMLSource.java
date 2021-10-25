package by.gsu.pms.util;

import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class XMLSource {
    public static InputSource getInputSource(){
        return new InputSource(getInputStream());
    }

    public static InputStream getInputStream(){
        final String url = "http://www.cbr.ru/scripts/XML_daily.asp";
        try {
            return new URL(url).openStream();
        } catch (IOException e) {
            throw new IllegalStateException("no access to "+url);
        }
    }
}
