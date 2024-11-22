package ofofo_dairy.controllers;

import ofofo_dairy.data.models.Dairy;
import ofofo_dairy.services.DairyService;
import ofofo_dairy.services.DiaryServiceImpl;

public class DairyController {
    private final DairyService dairyService = new DiaryServiceImpl();

    public String registerUser(String userName, String password){
        return dairyService.register(userName, password);
    }

    public Dairy loginUser(String userName, String password) {
        return dairyService.login(userName, password);
    }

    public Dairy logOutUser(String userName) {
        dairyService.logOut(userName);
        return null;
    }
}
