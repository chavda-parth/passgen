package passgen;
import java.util.Scanner;

public class PasswordGenerator {
    Scanner scanner = new Scanner(System.in);
    Account acc;

    public void generate() {
        System.out.println("WELCOME TO GLITCH'S PASSWORD GENERATOR");
        System.out.println("LETS GET YOU A NEW PASSWORD");

        acc = new Account("Google", "chavdaparth480@gmail.com", 8, 4, 1, 1, 1);

        System.out.println(acc.toString());

        String password = "";
        int[] codes = acc.createPassword();

        for (int code : codes) {
            password = password + ((char) code);
        }

        System.out.println("Password: " + password);
    }
}
