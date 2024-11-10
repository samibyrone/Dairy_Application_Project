package ofofo_dairy.services;

import ofofo_dairy.data.models.Dairy;
import ofofo_dairy.data.repositories.DairyRepository;
import ofofo_dairy.data.repositories.DairyRepositoryImpl;
import java.util.ArrayList;
import java.util.List;

public class DiaryServiceImpl implements DairyService {
    private final DairyRepository diaryRepository = new DairyRepositoryImpl();
    private final List<Dairy> diaries = new ArrayList<>();
    private boolean locked = false;
    private int count = 0;

    @Override
    public String register(String username, String password) {
        Dairy checkedUsername = diaryRepository.findById(username.toLowerCase());
        if (checkedUsername != null) {
            throw new IllegalArgumentException("Username is already taken");
        } else {
            Dairy diary = new Dairy();
            diary.setUserName(username.toLowerCase());
            diary.setPassword(password.toLowerCase());
            diaryRepository.save(diary);
            count++;
            return "Registration successful :)";
        }
    }

    @Override
    public void loginUsername(String username) {
        Dairy fetchedUsername = diaryRepository.findById(username.toLowerCase());
        if (fetchedUsername == null) {
            throw new IllegalArgumentException("Cannot find username");
        }
    }

    @Override
    public void loginPassword(String password) {
        Dairy fetchedPassword = diaryRepository.validatePassword(password.toLowerCase());
        if (fetchedPassword == null) {
            throw new IllegalArgumentException("Wrong password");
        }
    }

    @Override
    public String loginSuccess(String username, String password) {
        return "";
    }

    @Override
    public Dairy findById(String username) {
        Dairy checkedUsername = diaryRepository.findById(username.toLowerCase());
        if(checkedUsername != null) {
            return diaryRepository.findById(username.toLowerCase());
        }
        return null;
    }

    @Override
    public Dairy validatePassword(String password) {
        Dairy checkedUsername = diaryRepository.validatePassword(password.toLowerCase());
        if(checkedUsername != null) {
            return diaryRepository.validatePassword(password.toLowerCase());
        }
        return diaryRepository.validatePassword(password.toLowerCase());
    }

    @Override
    public void lock() {
        locked = true;
    }

    @Override
    public void unLock() {
        locked = false;
    }

    @Override
    public boolean isLocked() {
        return locked;
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public String getUsername() {
        return "";
    }
}