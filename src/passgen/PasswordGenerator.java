package passgen;

import java.util.Scanner;

public class PasswordGenerator {
    Scanner scanner = new Scanner(System.in);
    Password password;

    public void generate() {
        System.out.println("WELCOME TO GLITCH'S PASSWORD GENERATOR");
        System.out.println("LETS GET YOU A NEW PASSWORD");

        password = new Password("Google", "chavdaparth480@gmail.com", 8, 1, 1, 1, 1);

        System.out.println(password.toString());
    }
}
