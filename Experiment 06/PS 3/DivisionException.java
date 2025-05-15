package ExceptionHandlingDemo;

public class DivisionException extends Exception {
    public DivisionException(String message) {
        System.out.println("DivisionException: " + message);
    }
}
