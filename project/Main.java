// Main.java
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        UserManager userManager = new UserManager();

        while (true) {
            System.out.println("Main Menu");
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. Show All Users");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(userManager.getInput(""));

            switch (choice) {
                case 1:
                    userManager.signUp();
                    break;
                case 2:
                    if (userManager.login()) {
                        userMenu(userManager);
                    }
                    break;
                case 3:
                    userManager.showAllUsers();
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }

    private static void userMenu(UserManager userManager) throws IOException {
        while (true) {
            System.out.println("\nUser Menu (after login)");
            System.out.println("2. View current Password");
            System.out.println("3. Update Password");
            System.out.println("6. Logout");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(userManager.getInput(""));

            switch (choice) {
                case 2:
                    userManager.viewPassword();
                    break;
                case 3:
                    userManager.updatePassword();
                    break;
                case 6:
                    userManager.logout();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }
}
