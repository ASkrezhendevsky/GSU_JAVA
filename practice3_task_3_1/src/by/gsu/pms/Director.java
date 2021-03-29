package by.gsu.pms;

public class Director implements Employee, Person{
    private int roomNum;
    private String name;

    public Director(String name, int roomNum){
        this.name = name;
        this.roomNum = roomNum;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + ";" + roomNum;
    }
}
