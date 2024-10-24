package ofofo_diary.data.models;

import java.util.ArrayList;
import java.util.List;

public class Dairy {

    private String username;
    private String password;
    private boolean isLocked;

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    private List<Entry> entries = new ArrayList<Entry>();
}
