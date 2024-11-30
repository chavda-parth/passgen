package passgen;
import java.util.Scanner;

/** 
 * Initializes the password generation process including user interaction.
*/
public class PasswordGenerator {
    Account acc;
    String accountName, email;
    int minimumPasswordLength, minimumDigits, minimumUppercaseLetters, minimumLowercaseLetters, minimumSpecialCharacters;
    
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
        
        scanner.close();
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
