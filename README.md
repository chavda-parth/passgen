
# Title

**PassGen: The Password Generator**

## Description 

A Java-based password generator built as a hobby project. The aim is to build a strong, customizable password for user accounts. The program takes user inputs to save account information for reference and sets password constraints such as minimum password length and specific character requirements (digits, uppercase, lowercase, special characters) through which a suitable password is generated. It ensures that the generated password meets the security criteria.

(The project is still in prototype phase and is not a ready product nor is it meant to be.)

## Table of Contents

[Features](#features)

[Getting Started](#gettting-started)

[Usage](#usage)

[Project Structure](#project-structure)

[Future Enhancements](#future-enhancements)

[Contact](#contact)
## Features

- Generates secure password based on user-defined criteria such as:
    - Minimum length
    - Minimum number of digits
    - Minimum number of uppercase letters
    - Minimum number of lowercase letters
    - Minimum number of special characters
- Validates and ensures that password meets constraints.
- Clean and modular design based on Object Oriented Programming Principles
- Console-based Interface (Temporary)


## Getting Started

### Prerequisites
- Java 8 or above installed.
- Basic knowledge of running Java applications.

### Installation
1. Clone the repository:
```bash
git clone https://github.com/chavda-parth/passgen.git
```
2. Navigate to project directory:
```bash
cd passgen
```
3. Compile source files:
```bash
javac -d bin src/**/*.java
```
4. Run the application
```bash
java -cp bin Main
```


## Usage
1. Follow the instructions and prompts on the terminal:
  - Enter account name and email.
  - Enter password constraints.
**Example Input**
```
Enter Account Name: Facebook
Enter Email: user@example.com
Enter Minimum Length of Password: 12
Enter Minimum Number of Digits Required: 2
Enter Minimum Number of Uppercase Letters Required: 2
Enter Minimum Number of Lowercase Letters Required: 2
Enter Minimum Number of Special Characters Required: 2
```

2. Program will generate a password and display it along with account information.
**Example Output**
```
Account Information:
Account Name: Facebook
Email: user@example.com
Password: J@4y3Gx^sKf!
```


## Project Structure

```bash
src/
├── Main.java                  # Entry point of the application
└── passgen/
    ├── PasswordGenerator.java # Handles user input and initializes password generation
    ├── PasswordStrengthVerifier.java # Validates and adjusts the password
    ├── Account.java           # Stores account information and generated password
    ├── Constants.java         # Contains shared constants (ASCII ranges, etc.)
```
## Future Enhancements

- Handle exceptions and perform testing.
- Add a GUI for better user interaction.
- Store passwords and user information securely.
- Cross-platform availability.
- Generate password based on known formats and requirements of popular platforms and services.
- Reminders to change passwords.
- Integration with system to auto-suggest password generation when app is open.
- Access to clipboard.
## Contact

For questions or suggestions, feel free to reach out:
- Name: Parth Chavda
- Email: chavdaparth480@gmail.com
- Alternate Email: chavdaparth6511@gmail.com
- LinkedIn: https://www.linkedin.com/in/chavda-parth/
