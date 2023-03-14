package org.example;

import java.util.Scanner;

public class Main {
    static NetflixService actions = new NetflixService();
    public static void main(String[] args) {
        User manager = new User();
        manager.setUsername("manager");
        manager.setPassword("GoodP@ssword1234");
        runMenu();
    }

    public static void runMenu(){
        Scanner input = new Scanner(System.in);
        int logInOrSignup;
        do {
            System.out.println("\n\nWATCH TV SHOWS & MOVIES\nANYWHERE,\nANYTIME.\n\n1. Log In\n2. Sign Up\n(Enter any number to close the program)");
            logInOrSignup = input.nextInt();
            if (logInOrSignup == 1) {
                login();
            }
            else if (logInOrSignup == 2) {
                signup();
            }
        }
        while (logInOrSignup == 1 || logInOrSignup == 2);
    }

    //Logging In
    public static void login(){
        Scanner input = new Scanner(System.in);
        System.out.println("\nUsername:");
        String username = input.next();
        System.out.println("Password:");
        String password = input.next();
        while (!actions.login(username, password)) {
            if (!actions.usernameTaken(username)) {
                System.out.println("No account under this username exists.");
            }
            else {
                System.out.println("Password is incorrect.");
            }
            System.out.println("1. I want to try again\n2. Take me back to the first page");
            int choice = input.nextInt();
            if (choice == 1) {
                System.out.println("\nUsername:");
                username = input.next();
                System.out.println("Password:");
                password = input.next();
            }
            else if (choice == 2) {
                return;
            }
        }
    }
    public static void signup(){
        Scanner input = new Scanner(System.in);
        System.out.println("\nWhat would you like your username to be?");
        String username = input.nextLine();
        if (actions.usernameTaken(username)) {
            do {
                System.out.println("\nThis username is already taken. Please choose another one:");
                username = input.nextLine();
            }
            while (actions.usernameTaken(username));
        }
        System.out.println("Choose a safe password:");
        String password = input.nextLine();
        actions.createAccount(username, password);
    }
}
