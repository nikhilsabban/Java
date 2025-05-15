import java.util.Scanner;

class OddNumberException extends Exception {
    OddNumberException(String message) {
        System.out.println("OddNumberException: " + message);
    }
}

public class OddNumberChecker {
    
    static void checkEvenNumber(int number) throws OddNumberException {
        if (number % 2 != 0) {
            throw new OddNumberException("The number " + number + " is odd.");
        } else {
            System.out.println("The number " + number + " is even.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int input = scanner.nextInt();

        try {
            checkEvenNumber(input);
        } catch (OddNumberException e) {
            System.out.println("Exception handled in main.");
        }

        scanner.close();
    }
}
