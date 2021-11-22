package by.gsu.pms;

public enum Messages {
    STOP, GET_CLIENTS;

    public boolean isEqualMessage(String message){
        return name().toLowerCase().equals(message);
    }

    public String getMessageText(){
        return name().toLowerCase();
    }
}
