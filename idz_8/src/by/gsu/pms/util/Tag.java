package by.gsu.pms.util;

public enum Tag {
    VALCURS("ValCurs", 0),
    VALUTE("Valute", 0),
    NUMCODE("NumCode", 0),
    CHARCODE("CharCode", 1),
    NOMINAL("Nominal", 2),
    NAME("Name", 3),
    VALUE("Value", 4);

    private String name;
    private int childId;

    Tag(String name, int childId){
        this.name = name;
        this.childId = childId;
    }

    public String getName() {
        return name;
    }

    public int getChildId() {
        return childId;
    }
}
