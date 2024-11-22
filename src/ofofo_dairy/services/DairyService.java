package ofofo_dairy.services;

import ofofo_dairy.data.models.Dairy;
import ofofo_dairy.data.models.Entry;

public interface DairyService {

    String register(String username, String password);
    Dairy login(String username, String password);
    Dairy findDairyById(String dairyId);
    void logOut(String dairyId);
    String deleteDairy(String dairyId, String password);
    long countDairy();
    Entry createEntry(String dairyId, Entry entry);
    long countEntries(String dairyId);
    boolean isloggedIn();
    boolean isRegistered(String dairyId);
    Dairy changePassword(String userName, String password, String newPassword);
    Dairy changeUserName(String userName, String password, String newUserName);
}
