package by.gsu.pms.bean;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Valute {
    private String id;
    private int numCode;
    private String charCode;
    private String name;
    private int value;

    public Valute() {
    }

    public Valute(int numCode, String charCode, String name, int value) {
        this.numCode = numCode;
        this.charCode = charCode;
        this.name = name;
        this.value = value;
    }

    public int getNumCode() {
        return numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void setNumCode(int numCode) {
        this.numCode = numCode;
    }
    public void setNumCode(String numCode) {
        setNumCode(Integer.parseInt(numCode));
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }
    public void setValue(String value) {
        NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
        double d = 0;
        try {
            d = format.parse(value).doubleValue();
        } catch (ParseException e) {
            throw new NumberFormatException();
        }
        setValue((int) Math.round(d * 1000));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + ";" + numCode + ";" + charCode + ";" + name + ";" + value;
    }
}
