package by.gsu.pms;

public class Director extends Person implements Employee{
    private int roomNum;

    public Director(String name, int roomNum){
        super(name);
        this.roomNum = roomNum;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + roomNum;
    }
}
