package ofofo_dairy.services;

import ofofo_dairy.data.models.Dairy;
import ofofo_dairy.data.models.Entry;
import ofofo_dairy.data.repositories.DairyRepository;
import ofofo_dairy.data.repositories.DairyRepositoryImpl;


public class DiaryServiceImpl implements DairyService {
    private final DairyRepository diaryRepository;
    private final EntryService entryService;
    private long count = 0;
    private boolean isLoggedIn = false;


    public DiaryServiceImpl(DairyRepository dairyRepository, EntryService entryService) {
        this.diaryRepository = dairyRepository;
        this.entryService = entryService;
    }

    public DairyServiceImpl(){
        this.diaryRepository = new DairyRepositoryImpl();
        this.entryService = new EntryServiceImpl();
    }

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

    private boolean validateUserName(String userName) {
        return diaryRepository.findById(userName.toLowerCase()) != null;
    }

    @Override
    public Dairy login(String userName, String password) {
        if(validateUserName(userName)){
            Dairy dairy = getDairy(userName);
            if(dairy.getPassword().equals(password)){
                dairy.setIsLocked(false);
                isLoggedIn = true;
                return dairy;
            }
        }
        isLoggedIn = false;
        throw new IllegalArgumentException("Username or password is incorrect");
    }

    @Override
    public Dairy findDairyById(String dairyId) {
        if(isLoggedIn){
            return diaryRepository.findById(dairyId);
        }
        return null;
    }

    @Override
    public void logOut(String dairyId) {
        Dairy dairy = getDairy(dairyId);
        if(validateUserName(dairyId)){
            dairy.setIsLocked(true);
            isLoggedIn = false;
        }
    }

    @Override
    public String deleteDairy(String dairyId, String password) {
        Dairy dairy = getDairy(dairyId);
        if(getDairy(dairyId).getPassword().equals(password)){
            diaryRepository.delete(dairy);
            count--;
            isLoggedIn = false;
            return "Delete successful :)";
        }
        throw new IllegalArgumentException("Username or password is incorrect");
    }

    private Dairy getDairy(String dairyId) {
        return diaryRepository.findById(dairyId.toLowerCase());
    }

    @Override
    public long countDairy() {
        return count;
    }

    @Override
    public Entry createEntry(String dairyId, Entry entry) {
        if(!isLoggedIn || !validateUserName(dairyId)) {
            throw new IllegalArgumentException("Username or password is incorrect");
        }
        return entryService.createEntry(dairyId, entry);
    }

    @Override
    public long countEntries(String dairyId) {
            if(!isLoggedIn){
                throw new IllegalStateException("Your dairy is not logged in");
            } return entryService.countNumberOfEntries(dairyId);
        }

    @Override
    public boolean isloggedIn() {
        return false;
    }

    @Override
    public boolean isRegistered(String dairyId) {
        return validateUserName(dairyId);
    }

    @Override
    public Dairy changePassword(String userName, String password, String newPassword) {
        Dairy dairy = getDairy(userName);
        if (dairy.getPassword().equals(password)) {
            dairy.setPassword(newPassword);
            diaryRepository.save(dairy);
            logOut(dairy.getUserName());
            return dairy;
        }
        throw new IllegalArgumentException("Wrong password");
    }

    @Override
    public Dairy changeUserName(String userName, String password, String newUserName){

    }
//
//    @Override
//    public void loginUsername(String userName) {
//        Dairy fetchedUsername = diaryRepository.findById(userName.toLowerCase());
//        if (fetchedUsername == null) {
//            throw new IllegalArgumentException("Cannot find username");
//        }
//    }
//
//    @Override
//    public void loginPassword(String password) {
//        Dairy fetchedPassword = diaryRepository.validatePassword(password.toLowerCase());
//        if (fetchedPassword == null) {
//            throw new IllegalArgumentException("Wrong password");
//        }
//    }
//
//    @Override
//    public String loginSuccess(String userName, String password) {
//        return "";
//    }
//
//    @Override
//    public Dairy findById(String userName) {
//        Dairy checkedUsername = diaryRepository.findById(userName.toLowerCase());
//        if(checkedUsername != null) {
//            return diaryRepository.findById(username.toLowerCase());
//        }
//        return null;
//    }

}