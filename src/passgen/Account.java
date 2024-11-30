package passgen;

import java.util.Random;

/**
* Represents a user account for which a secure password is generated.
*/
public class Account {
    private String accountName; // Name of the account
    private String email; // Email linked to the account
    private int minimumPasswordLength;
    private int minimumDigitsRequired;
    private int minimumUppercaseLettersRequired;
    private int minimumLowerCaseLettersRequired;
    private int minimumSpecialCharactersRequired;
    private StringBuilder passwordString;
    private PasswordStrengthVerifier verifier;
    
    Account(String accountName, String email, int minimumPasswordLength, int minimumDigitsRequired, int minimumUppercaseLettersRequired, int minimumLowerCaseLettersRequired, int minimumSpecialCharactersRequired) {
        this.accountName = accountName;
        this.email = email;
        this.minimumPasswordLength = minimumPasswordLength;
        this.minimumDigitsRequired = minimumDigitsRequired;
        this.minimumUppercaseLettersRequired = minimumUppercaseLettersRequired;
        this.minimumLowerCaseLettersRequired = minimumLowerCaseLettersRequired;
        this.minimumSpecialCharactersRequired = minimumSpecialCharactersRequired;
        this.passwordString = new StringBuilder(minimumPasswordLength);
        this.verifier = new PasswordStrengthVerifier(minimumPasswordLength);
    }
    
    public String getAccountName() {
        return accountName;
    }
    
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getMinimumPasswordLength() {
        return minimumPasswordLength;
    }
    
    public void setMinimumPasswordLength(int minimumPasswordLength) {
        this.minimumPasswordLength = minimumPasswordLength;
    }
    
    public int getMinimumDigitsRequired() {
        return minimumDigitsRequired;
    }
    
    public void setMinimumDigitsRequired(int minimumDigitsRequired) {
        this.minimumDigitsRequired = minimumDigitsRequired;
    }
    
    public int getMinimumUppercaseLettersRequired() {
        return minimumUppercaseLettersRequired;
    }
    public void setMinimumUppercaseLettersRequired(int minimumUppercaseLettersRequired) {
        this.minimumUppercaseLettersRequired = minimumUppercaseLettersRequired;
    }
    
    public int getMinimumLowerCaseLettersRequired() {
        return minimumLowerCaseLettersRequired;
    }
    
    public void setMinimumLowerCaseLettersRequired(int minimumLowerCaseLettersRequired) {
        this.minimumLowerCaseLettersRequired = minimumLowerCaseLettersRequired;
    }
    
    public int getMinimumSpecialCharactersRequired() {
        return minimumSpecialCharactersRequired;
    }
    
    public void setMinimumSpecialCharactersRequired(int minimumSpecialCharactersRequired) {
        this.minimumSpecialCharactersRequired = minimumSpecialCharactersRequired;
    }
    
    public StringBuilder getPasswordString() {
        return passwordString;
    }
    
    public void setPasswordString(StringBuilder passwordString) {
        this.passwordString = passwordString;
    }
    
    @Override
    public String toString() {
        return "Account Information:\nAcount Name: " + accountName + "\nEmail: " + email + "\nPassword: " + passwordString;
    }
    
    /**
    * Generates a secure password based on user-defined constraints.
    */
    void generatePassword() {
        int[] passwordChars = new int[this.minimumPasswordLength];
        Random random = new Random();
        int currentChar;
        
        for (int i = 0; i < this.minimumPasswordLength; i++) {
            currentChar = 0;
            
            while (currentChar < Constants.ASCII_CHARS_START ) {
                currentChar = random.nextInt(Constants.ASCII_CHARS_END);
            }
            
            passwordChars[i] = currentChar;
        }
        
        passwordChars = this.verifier.verifyStrength(passwordChars, minimumDigitsRequired, minimumUppercaseLettersRequired, minimumLowerCaseLettersRequired, minimumSpecialCharactersRequired);
        
        for (int charCode : passwordChars) {
            passwordString.append((char) charCode);
        }
    }
}
