import java.util.Scanner;

public class HelloWorld {

    // TODO: Put your name here.
    private static final String YOUR_NAME = "";

    private static final String RESPONSE_TEMPLATE = "Hello %s, I am %s";
    private static final String NULL_TEMPLATE = "Hello, I am %s";

    public static String buildResponse(String name) {
        // TODO: Update this function to use String.format() to fill in the two response templates.
        if (name == null) {
            // TODO: Use String.format to put your name into the NULL_TEMPLATE and return the result
        } else {
            // TODO: Use String.format to put your name into the NULL_TEMPLATE and return the result;
        }
        return "Delete this entire line";
    }

    public static void main(String[] args) {
        System.out.print("What is your name? ");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.next();

        String response = buildResponse(userName);
        System.out.println(response);
    }
}
