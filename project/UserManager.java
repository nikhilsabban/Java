import java.io.*;  // Import all IO classes

public class UserManager {
    private User[] users;  // Array to store all users
    private int userCount;  // Count of registered users
    private User currentUser;  // The current logged-in user
    private BufferedReader reader;

    // Constructor
    public UserManager() {
        this.users = new User[10];  // Initial size of array to store users (can be expanded later)
        this.userCount = 0;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    // Method to get user input from console
    public String getInput(String prompt) {  // Changed to public so it can be accessed in Main class
        System.out.print(prompt);
        try {
            return reader.readLine();
        } catch (IOException e) {
            return "";
        }
    }

    // Method for sign-up
    public void signUp() {
        String email = getEmailFromUser();
        String password = getPasswordFromUser();

        currentUser = new User(email, password);
        users[userCount] = currentUser;  // Add the user to the users array
        userCount++;  // Increment the user count
        System.out.println("Sign Up Successful.");
    }

    // Method for login
    public boolean login() {
        if (userCount == 0) {
            System.out.println("No users available. Please sign up first.");
            return false;
        }

        String email = getInput("Enter email: ");
        String password = getInput("Enter password: ");

        for (int i = 0; i < userCount; i++) {
            if (users[i].getEmail().equals(email) && users[i].getPassword().equals(password)) {
                currentUser = users[i];
                System.out.println("Login Successful.");
                return true;
            }
        }
        System.out.println("Invalid credentials. Try again.");
        return false;
    }

    // Method to view the current password
    public void viewPassword() {
        if (currentUser == null) {
            System.out.println("No user is logged in.");
        } else {
            System.out.println("Current saved password: " + currentUser.getPassword());
        }
    }

    // Method to update the current password
    public void updatePassword() {
        if (currentUser != null) {
            String newPassword = getPasswordFromUser();
            currentUser.setPassword(newPassword);
            System.out.println("Password updated successfully.");
        } else {
            System.out.println("No user is logged in.");
        }
    }

    // Method to log out
    public void logout() {
        System.out.println("Logged out successfully.");
        currentUser = null;
    }

    // Method to display all registered users
    public void showAllUsers() {
        if (userCount == 0) {
            System.out.println("No users found.");
        } else {
            System.out.println("\nAll Registered Users:");
            for (int i = 0; i < userCount; i++) {
                System.out.println("Email: " + users[i].getEmail());
            }
        }
    }

    // Method to validate email (basic format check)
    private String getEmailFromUser() {
        while (true) {
            String email = getInput("Enter email: ");
            if (isValidEmail(email)) {
                return email;
            } else {
                System.out.println("Invalid email format. Please try again.");
            }
        }
    }

    // Method to validate password strength (must have at least one letter and one number)
    private String getPasswordFromUser() {
        while (true) {
            String password = getInput("Enter password: ");
            if (isValidPassword(password)) {
                return password;
            } else {
                System.out.println("Password must contain at least one letter and one number. Please try again.");
            }
        }
    }

    // Simple email format validation (checks for presence of '@' symbol and a dot '.')
    private boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    // Simple password validation (checks if password contains both letters and digits)
    private boolean isValidPassword(String password) {
        boolean hasLetter = false;
        boolean hasDigit = false;

        for (int i = 0; i < password.length(); i++) {
            if (Character.isLetter(password.charAt(i))) {
                hasLetter = true;
            }
            if (Character.isDigit(password.charAt(i))) {
                hasDigit = true;
            }
        }
        return hasLetter && hasDigit;
    }
}
