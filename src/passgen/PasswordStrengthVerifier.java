package passgen;

import java.util.Random;

public class PasswordStrengthVerifier {
    private int passwordLength;
    private int digitsCounter;
    private int uppercaseLettersCounter;
    private int lowercaseLettersCounter;
    private int specialCharactersCounter;
    private Random random = new Random();
    private int randomIndex;
    private int randomNumber;

    PasswordStrengthVerifier(int passwordLength) {
        this.passwordLength = passwordLength;
    }

    int[] verifyStrength(int[] passwordChars, int minimumDigits, int minimumUppercaseLetters, int minimumLowercaseLetters, int minimumSpecialCharacters) {
        this.setCounters(passwordChars);

        while (this.digitsCounter < minimumDigits || this.uppercaseLettersCounter < minimumUppercaseLetters || this.lowercaseLettersCounter < minimumLowercaseLetters || this.specialCharactersCounter < minimumSpecialCharacters) {
            if (this.digitsCounter < minimumDigits) {
                this.randomIndex = random.nextInt(passwordLength);
                this.randomNumber = 0;
                
                while (this.randomNumber < 48) {
                    this.randomNumber = random.nextInt(58);
                }

                if (!(passwordChars[this.randomIndex] >= 48 && passwordChars[this.randomIndex] <= 57)) {
                    passwordChars[this.randomIndex] = randomNumber;
                    this.setCounters(passwordChars);
                }
            }

            if (this.uppercaseLettersCounter < minimumUppercaseLetters) {
                this.randomIndex = random.nextInt(passwordLength);
                this.randomNumber = 0;
                
                while (this.randomNumber < 65) {
                    this.randomNumber = random.nextInt(91);
                }

                if (!(passwordChars[this.randomIndex] >= 65 && passwordChars[this.randomIndex] <= 90)) {
                    passwordChars[this.randomIndex] = randomNumber;
                    this.setCounters(passwordChars);
                }
            }

            if (this.lowercaseLettersCounter < minimumLowercaseLetters) {
                this.randomIndex = random.nextInt(passwordLength);
                this.randomNumber = 0;
                
                while (this.randomNumber < 97) {
                    this.randomNumber = random.nextInt(123);
                }

                if (!(passwordChars[this.randomIndex] >= 97 && passwordChars[this.randomIndex] <= 122)) {
                    passwordChars[this.randomIndex] = randomNumber;
                    this.setCounters(passwordChars);
                }
            }
        }

        return passwordChars;
    }

    void setCounters(int[] passwordChars) {
        this.digitsCounter = 0;
        this.uppercaseLettersCounter = 0;
        this.lowercaseLettersCounter = 0;
        this.specialCharactersCounter = 0;

        for (int i : passwordChars) {
            if (i >= 48 && i <= 57) {
                this.digitsCounter++;
            } else if (i >= 65 && i <= 90) {
                this.uppercaseLettersCounter++;
            } else if (i >= 97 && i <= 122) {
                this.lowercaseLettersCounter++;
            } else {
                this.specialCharactersCounter++;
            }
        }
    }
}
