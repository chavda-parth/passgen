package passgen;
import java.util.Scanner;

public class PasswordGenerator {
    Account acc;
    String accountName, email;
    int minimumPasswordLength, minimumDigits, minimumUppercaseLetters, minimumLowercaseLetters, minimumSpecialCharacters;

    public void generate() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("WELCOME TO GLITCH'S PASSWORD GENERATOR");
        System.out.println("LETS GET YOU A NEW PASSWORD");

        System.out.print("Enter Account Name: ");
        accountName = scanner.nextLine();

        System.out.print("Enter Email: ");
        email = scanner.nextLine();

        System.out.print("Enter Minimum Length of Password: ");
        minimumPasswordLength = scanner.nextInt();

        System.out.print("Enter Minimum Number of Digits Required: ");
        minimumDigits = scanner.nextInt();

        System.out.print("Enter Minimum Number of Uppercase Letters Required: ");
        minimumUppercaseLetters = scanner.nextInt();

        System.out.print("Enter Minimum Number of Lowercase Letters Required: ");
        minimumLowercaseLetters = scanner.nextInt();

        System.out.print("Enter Minimum Number of Special Characters Required: ");
        minimumSpecialCharacters = scanner.nextInt();

        acc = new Account(accountName, email, minimumPasswordLength, minimumDigits, minimumUppercaseLetters, minimumLowercaseLetters, minimumSpecialCharacters);

        System.out.println(acc.toString());

        String password = "";
        int[] codes = acc.createPassword();

        for (int code : codes) {
            password = password + ((char) code);
        }

        System.out.println("Password: " + password);

        scanner.close();
    }
}
