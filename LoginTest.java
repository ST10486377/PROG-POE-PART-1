package za.ac.cput;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 tests for the Chat App Part 1 requirements.
 */
public class LoginTest {

    // ---------------------------------------------------------
    // assertEquals tests
    // ---------------------------------------------------------

    @Test
    void testUsernameCorrectlyFormattedMessage() {
        Login login = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976"
        );

        assertEquals(
                true,
                login.checkUserName(),
                "The username should be correctly formatted."
        );
    }

    @Test
    void testUsernameIncorrectlyFormattedMessage() {
        Login login = new Login(
                "Kyle",
                "Smith",
                "kyle!!!!!!!",
                "Ch&&sec@ke99!",
                "+27838968976"
        );

        assertEquals(
                "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.",
                login.registerUser()
        );
    }

    @Test
    void testPasswordMeetsComplexityRequirements() {
        Login login = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976"
        );

        assertEquals(true, login.checkPasswordComplexity());
    }

    @Test
    void testPasswordDoesNotMeetComplexityRequirements() {
        Login login = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "password",
                "+27838968976"
        );

        assertEquals(
                "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.",
                login.registerUser()
        );
    }

    @Test
    void testCellNumberCorrectlyFormatted() {
        Login login = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976"
        );

        assertEquals(true, login.checkCellPhoneNumber());
    }

    @Test
    void testCellNumberIncorrectlyFormatted() {
        Login login = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "08966553"
        );

        assertEquals(
                "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.",
                login.registerUser()
        );
    }

    // ---------------------------------------------------------
    // assertTrue / assertFalse tests
    // ---------------------------------------------------------

    @Test
    void testLoginSuccessful() {
        Login login = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976"
        );

        login.registerUser();

        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    void testLoginFailed() {
        Login login = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976"
        );

        login.registerUser();

        assertFalse(login.loginUser("wrong_1", "wrongPassword1!"));
    }

    @Test
    void testUsernameCorrectlyFormatted() {
        Login login = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976"
        );

        assertTrue(login.checkUserName());
    }

    @Test
    void testUsernameIncorrectlyFormatted() {
        Login login = new Login(
                "Kyle",
                "Smith",
                "kyle!!!!!!!",
                "Ch&&sec@ke99!",
                "+27838968976"
        );

        assertFalse(login.checkUserName());
    }

    @Test
    void testPasswordMeetsComplexityRequirementsBoolean() {
        Login login = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976"
        );

        assertTrue(login.checkPasswordComplexity());
    }

    @Test
    void testPasswordDoesNotMeetComplexityRequirementsBoolean() {
        Login login = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "password",
                "+27838968976"
        );

        assertFalse(login.checkPasswordComplexity());
    }

    @Test
    void testCellPhoneNumberCorrectlyFormattedBoolean() {
        Login login = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976"
        );

        assertTrue(login.checkCellPhoneNumber());
    }

    @Test
    void testCellPhoneNumberIncorrectlyFormattedBoolean() {
        Login login = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "08966553"
        );

        assertFalse(login.checkCellPhoneNumber());
    }

    @Test
    void testSuccessfulLoginStatusMessage() {
        Login login = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976"
        );

        login.registerUser();
        login.loginUser("kyl_1", "Ch&&sec@ke99!");

        assertEquals(
                "Welcome Kyle Smith it is great to see you again.",
                login.returnLoginStatus()
        );
    }

    @Test
    void testFailedLoginStatusMessage() {
        Login login = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976"
        );

        login.registerUser();
        login.loginUser("wrong_1", "wrongPassword1!");

        assertEquals(
                "Username or password incorrect, please try again.",
                login.returnLoginStatus()
        );
    }
}
