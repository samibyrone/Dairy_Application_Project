import ofofo_dairy.controllers.DairyController;
import ofofo_dairy.controllers.DiaryController;
import ofofo_dairy.services.EntryService;
import ofofo_dairy.services.EntryServiceImpl;

import java.util.Scanner;
public class Main {
    private static DiaryController diaryController;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        goToMainMenu();
    }

    private static void goToMainMenu(){
        String menu = """
                Welcome to Your Diary App
                1 => Register
                2 => Login
                3 => Logout
                4 => Exit from Application
                """;
        print(menu);

        char choice = scanner.next().charAt(0);

        switch (choice) {
            case '1': register();
            case '2': login();
            case '3': createEntry();
            case '4': logout();
            case '5': exit();
        }
    }

    private static void register(){
        diaryController = new DiaryController();
        System.out.println("Enter ya name: ");
        String name = input(new Scanner(System.in).nextLine());
        System.out.println("Enter ya password: ");
        String password = input(new Scanner(System.in).nextLine());
        diaryController.registerUser(name, password);
    }

    private static void login(){
        diaryController = new DiaryController();
        System.out.println("Enter ya username: ");
        String username = scanner.nextLine();
        System.out.println("Enter ya password: ");
        String password = input(new Scanner(System.in).nextLine());
        diaryController.loginUser(username, password);
    }

    private static void logout(){
        diaryController = new DiaryController();
        System.out.println("Enter ya username: ");
        String username = input(new Scanner(System.in).nextLine());
        diaryController.logOutUser(username);
    }

    private static void createEntry(){
        diaryController = new DiaryController();
        System.out.println("Enter ya name: ");
        String name = input(new Scanner(System.in).nextLine());
        System.out.println("Enter ya password: ");
        String password = input(new Scanner(System.in).nextLine());
        diaryController.registerUser(name, password);
        diaryController.loginUser(name, password);

    }

    private static void exit(){
        System.exit(0);
    }

    private static String input(String prompt){
        System.out.println(prompt);
        return new Scanner(System.in).nextLine();
    }

    private static void print(String prompt){
        System.out.println(prompt);
    }


}