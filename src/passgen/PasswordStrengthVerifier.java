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
        setCounters(passwordChars);

        while (digitsCounter < minimumDigits || uppercaseLettersCounter < minimumUppercaseLetters || lowercaseLettersCounter < minimumLowercaseLetters || specialCharactersCounter < minimumSpecialCharacters) {
            if (digitsCounter < minimumDigits) {
                updatePassword(passwordChars, 48, 57);
            }

            if (uppercaseLettersCounter < minimumUppercaseLetters) {
                updatePassword(passwordChars, 65, 90);
            }

            if (lowercaseLettersCounter < minimumLowercaseLetters) {
                updatePassword(passwordChars, 97, 122);
            }

            if (specialCharactersCounter < minimumSpecialCharacters) {
                updatePassword(passwordChars, 33, 47);
            }
        }

        return passwordChars;
    }

    void setCounters(int[] passwordChars) {
        digitsCounter = 0;
        uppercaseLettersCounter = 0;
        lowercaseLettersCounter = 0;
        specialCharactersCounter = 0;

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
    }

    void updatePassword(int[] passwordChars, int lowerBound, int upperBound) {
        randomIndex = random.nextInt(this.passwordLength);
        randomNumber = 0;

        while (randomNumber < lowerBound) {
            randomNumber = random.nextInt(upperBound + 1);
        }

        if (!(passwordChars[randomIndex] >= lowerBound && passwordChars[randomIndex] <= upperBound)) {
            passwordChars[randomIndex] = randomNumber;
            setCounters(passwordChars);
        }
    }
}
