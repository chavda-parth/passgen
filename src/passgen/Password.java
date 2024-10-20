package passgen;

public class Password {
    private String accountName;
    private String credential;
    private int minimumPasswordLength;
    private int minimumDigitsRequired;
    private int minimumUppercaseLettersRequired;
    private int minimumLowerCaseLettersRequired;
    private int minimumSpecialCharactersRequired;
    private String passwordString;

    Password(String accountName, String credential, int minimumPasswordLength, int minimumDigitsRequired, int minimumUppercaseLettersRequired, int minimumLowerCaseLettersRequired, int minimumSpecialCharactersRequired) {
        this.accountName = accountName;
        this.credential = credential;
        this.minimumPasswordLength = minimumPasswordLength;
        this.minimumDigitsRequired = minimumDigitsRequired;
        this.minimumUppercaseLettersRequired = minimumUppercaseLettersRequired;
        this.minimumLowerCaseLettersRequired = minimumLowerCaseLettersRequired;
        this.minimumSpecialCharactersRequired = minimumSpecialCharactersRequired;
        this.passwordString = "";
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
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

    public String getPasswordString() {
        return passwordString;
    }

    public void setPasswordString(String passwordString) {
        this.passwordString = passwordString;
    }

    @Override
    public String toString() {
        return accountName + ", " + credential + ", " + minimumPasswordLength + ", " + minimumDigitsRequired + ", " + minimumUppercaseLettersRequired + ", " + minimumLowerCaseLettersRequired + ", " + minimumSpecialCharactersRequired;
    }
}
