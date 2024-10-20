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
        while (digitsCounter < minimumDigits || uppercaseLettersCounter < minimumUppercaseLetters || lowercaseLettersCounter < minimumLowercaseLetters || specialCharactersCounter < minimumSpecialCharacters) {
            for (int i : passwordChars) {
                if (i >= 48 && i <= 57) {
                    digitsCounter++;
                } else if (i >= 65 && i <= 90) {
                    uppercaseLettersCounter++;
                } else if (i >= 97 && i <= 122) {
                    lowercaseLettersCounter++;
                } else {
                    specialCharactersCounter++;
                }
            }

            if (digitsCounter < minimumDigits) {
                randomIndex = random.nextInt(passwordLength);
                randomNumber = 0;
                while (randomNumber < 48) {
                    randomNumber = random.nextInt(58);
                }

                passwordChars[randomIndex] = randomNumber;
                digitsCounter++;
            }
        }

        return null;
    }
}
