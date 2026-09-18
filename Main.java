package za.ac.cput;

import java.util.Scanner;

/**
 * Console entry point for Chat App Part 1.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("          CHAT APP - PART 1");
        System.out.println("        Registration and Login");
        System.out.println("==========================================");

        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter a username: ");
        String username = scanner.nextLine();

        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        System.out.print("Enter your South African cell phone number: ");
        String cellPhoneNumber = scanner.nextLine();

        Login user = new Login(
                firstName,
                lastName,
                username,
                password,
                cellPhoneNumber
        );

        System.out.println("\n--- Registration ---");
        System.out.println(user.registerUser());

        if (user.isRegistered()) {
            System.out.println("\n--- Login ---");

            System.out.print("Enter username: ");
            String loginUsername = scanner.nextLine();

            System.out.print("Enter password: ");
            String loginPassword = scanner.nextLine();

            user.loginUser(loginUsername, loginPassword);
            System.out.println(user.returnLoginStatus());
        }

        scanner.close();
    }
}
