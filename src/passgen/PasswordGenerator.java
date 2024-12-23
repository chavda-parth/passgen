package passgen;
import java.util.InputMismatchException;
import java.util.Scanner;

/** 
* Initializes the password generation process including user interaction.
*/
public class PasswordGenerator {
    Account acc;
    String accountName, email;
    int minimumPasswordLength = 0, minimumDigits = 0, minimumUppercaseLetters = 0, minimumLowercaseLetters = 0, minimumSpecialCharacters = 0;
    
    /**
    * Collects user input to define account information and password constraints.
    */
    private void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("WELCOME TO GLITCH'S PASSWORD GENERATOR");
        System.out.println("LETS GET YOU A NEW PASSWORD");
        
        System.out.print("Enter Account Name: ");
        accountName = scanner.nextLine();
        
        System.out.print("Enter Email: ");
        email = scanner.nextLine();
        
        minimumPasswordLength = validateInput(scanner, "Enter Minimum Length of Password: ");
        
        while (true) {
            minimumDigits = validateInput(scanner, "Enter Minimum Number of Digits Required: ");
            minimumUppercaseLetters = validateInput(scanner, "Enter Minimum Number of Uppercase Letters Required: ");
            minimumLowercaseLetters = validateInput(scanner, "Enter Minimum Number of Lowercase Letters Required: ");
            minimumSpecialCharacters = validateInput(scanner, "Enter Minimum Number of Special Characters Required: ");

            if ((minimumDigits + minimumLowercaseLetters + minimumUppercaseLetters + minimumSpecialCharacters) <= minimumPasswordLength) {
                System.out.println("The sum of character constraints exceeds password length limit. Please enter valid values.");
                break;
            }
        }
        
        scanner.close();
    }

    /**
     * Validates user input and provides feedback.
     */
    private int validateInput(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.println(message);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }
    
    /**
    * Creates Account, generates password and prints account information inlcuding generated password.
    */
    public void generate() {
        getUserInput();
        
        acc = new Account(accountName, email, minimumPasswordLength, minimumDigits, minimumUppercaseLetters, minimumLowercaseLetters, minimumSpecialCharacters);
        
        acc.generatePassword();
        
        System.out.println(acc.toString());
    } 
}
