package ofofo_dairy.services;

import ofofo_dairy.data.models.Dairy;

public interface DairyService {

    String register(String username, String password);
    void loginUsername(String username);
    void loginPassword(String password);
    String loginSuccess(String username, String password);
    Dairy findById(String username);
    Dairy validatePassword(String password);
    int count();
    String getUsername();
    boolean isLocked();
    void lock();
    void unLock();
}
