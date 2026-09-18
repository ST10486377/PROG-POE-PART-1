package za.ac.cput;

/**
 * Handles registration and login functionality for Part 1 of the Chat App POE.
 */
public class Login {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String cellPhoneNumber;

    private boolean registered;
    private boolean lastLoginSuccessful;

    public Login() {
    }

    public Login(String firstName, String lastName, String username,
                 String password, String cellPhoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
    }

    /**
     * Checks that the username contains an underscore and is no more than
     * five characters long.
     *
     * @return true when the username is correctly formatted.
     */
    public boolean checkUserName() {
        return username != null
                && username.contains("_")
                && username.length() <= 5;
    }

    /**
     * Checks the password complexity requirements:
     * at least 8 characters, an uppercase letter, a number and a special
     * character.
     *
     * @return true when the password satisfies all requirements.
     */
    public boolean checkPasswordComplexity() {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUppercase = password.matches(".*[A-Z].*");
        boolean hasNumber = password.matches(".*[0-9].*");
        boolean hasSpecialCharacter = password.matches(".*[^A-Za-z0-9].*");

        return hasUppercase && hasNumber && hasSpecialCharacter;
    }

    /**
     * Validates a South African mobile number in international format.
     *
     * Regex reference:
     * Baeldung, "A Guide to Regular Expressions in Java",
     * https://www.baeldung.com/regular-expressions-java
     *
     * The expression used here requires +27 followed by 9 digits and
     * restricts the first local mobile digit to 6, 7 or 8.
     *
     * @return true when the number is correctly formatted.
     */
    public boolean checkCellPhoneNumber() {
        if (cellPhoneNumber == null) {
            return false;
        }

        String southAfricanMobileRegex = "^\\+27[6-8][0-9]{8}$";
        return cellPhoneNumber.matches(southAfricanMobileRegex);
    }

    /**
     * Registers the user only when all required details are valid.
     *
     * @return the required POE registration message.
     */
    public String registerUser() {
        if (!checkUserName()) {
            registered = false;
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity()) {
            registered = false;
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber()) {
            registered = false;
            return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        }

        registered = true;
        return "User successfully registered.";
    }

    /**
     * Verifies the supplied login credentials against the registered details.
     *
     * @param enteredUsername username entered during login
     * @param enteredPassword password entered during login
     * @return true when both credentials match
     */
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        lastLoginSuccessful = registered
                && username != null
                && password != null
                && username.equals(enteredUsername)
                && password.equals(enteredPassword);

        return lastLoginSuccessful;
    }

    /**
     * Required POE method name. Uses the credentials supplied to this object
     * as the login attempt.
     *
     * @return true when the stored credentials represent a successful login
     */
    public boolean loginUser() {
        return loginUser(username, password);
    }

    /**
     * Returns the required authentication message.
     *
     * @return welcome message after successful login, otherwise failure message
     */
    public String returnLoginStatus() {
        if (lastLoginSuccessful) {
            return "Welcome " + firstName + " " + lastName + " it is great to see you again.";
        }

        return "Username or password incorrect, please try again.";
    }

    public void setLoginDetails(String enteredUsername, String enteredPassword) {
        this.username = enteredUsername;
        this.password = enteredPassword;
    }

    public boolean isRegistered() {
        return registered;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }
}
