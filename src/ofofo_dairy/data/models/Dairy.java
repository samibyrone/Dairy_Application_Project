package ofofo_dairy.data.models;

import java.util.ArrayList;
import java.util.List;

public class Dairy {

    private String userName;
    private String password;
    private boolean isLocked;
    private List<Entry> entries = new ArrayList<>();

    public Dairy() {

    }

    public Dairy(String userName, String password) {
        this.userName = userName;
        this.password = password;
        entries = new ArrayList<>();
    }

    public Dairy(Dairy myDairy) {

    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setIsLocked(boolean b) {
    }
}
