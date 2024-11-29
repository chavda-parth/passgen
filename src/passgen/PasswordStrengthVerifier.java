package passgen;

import java.util.Random;

public class PasswordStrengthVerifier {
    private int passwordLength;
    private int digitsCounter = 0;
    private int uppercaseLettersCounter = 0;
    private int lowercaseLettersCounter = 0;
    private int specialCharactersCounter = 0;
    private Random random = new Random();
    private int randomIndex;
    private int randomNumber;

    PasswordStrengthVerifier(int passwordLength) {
        this.passwordLength = passwordLength;
    }

    int[] verifyStrength(int[] passwordChars, int minimumDigits, int minimumUppercaseLetters, int minimumLowercaseLetters, int minimumSpecialCharacters) {
        while (this.digitsCounter < minimumDigits || this.uppercaseLettersCounter < minimumUppercaseLetters || this.lowercaseLettersCounter < minimumLowercaseLetters || this.specialCharactersCounter < minimumSpecialCharacters) {
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

            if (this.digitsCounter < minimumDigits) {
                this.randomIndex = random.nextInt(passwordLength);
                this.randomNumber = 0;
                while (this.randomNumber < 48) {
                    this.randomNumber = random.nextInt(58);
                }

                passwordChars[this.randomIndex] = randomNumber;
                this.digitsCounter++;
            }

            if (this.uppercaseLettersCounter < minimumUppercaseLetters) {
                this.randomIndex = random.nextInt(passwordLength);
                this.randomNumber = 0;
                
                while (this.randomNumber < 65) {
                    this.randomNumber = random.nextInt(91);
                }

                passwordChars[this.randomIndex] = randomNumber;
                this.uppercaseLettersCounter++;
            }
        }

        return null;
    }
}
