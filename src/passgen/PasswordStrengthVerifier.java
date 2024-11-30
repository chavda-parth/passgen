package passgen;

import java.util.Random;


/**
 * Ensures password adheres to constraints and verifies strength.
 */
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

    /**
     * Verifies password strength. 
     */
    int[] verifyStrength(int[] passwordChars, int minimumDigits, int minimumUppercaseLetters, int minimumLowercaseLetters, int minimumSpecialCharacters) {
        setCounters(passwordChars);

        while (digitsCounter < minimumDigits || uppercaseLettersCounter < minimumUppercaseLetters || lowercaseLettersCounter < minimumLowercaseLetters || specialCharactersCounter < minimumSpecialCharacters) {
            if (digitsCounter < minimumDigits) {
                updatePassword(passwordChars, Constants.ASCII_DIGIT_START, Constants.ASCII_DIGIT_END);
            }

            if (uppercaseLettersCounter < minimumUppercaseLetters) {
                updatePassword(passwordChars, Constants.ASCII_UPPERCASE_START, Constants.ASCII_UPPERCASE_END);
            }

            if (lowercaseLettersCounter < minimumLowercaseLetters) {
                updatePassword(passwordChars, Constants.ASCII_LOWERCASE_START, Constants.ASCII_LOWERCASE_END);
            }

            if (specialCharactersCounter < minimumSpecialCharacters) {
                updatePassword(passwordChars, Constants.ASCII_CHARS_START, Constants.ASCII_DIGIT_START - 1);
            }
        }

        return passwordChars;
    }

    /**
     * Sets constraint counters for password.
     */
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

    /**
     * Updates password to meet strength and constraint requirements.
     */
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
