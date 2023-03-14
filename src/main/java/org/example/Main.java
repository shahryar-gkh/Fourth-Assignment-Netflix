package org.example;

import java.util.Scanner;

public class Main {
    static NetflixService actions = new NetflixService();
    public static void main(String[] args) {
        User manager = new User();
        actions.createAccount("manager", "GoodP@ssword1234");
        actions.addTVShow("Stranger Things", "Science Fiction", 2016, 4, 34, 92);
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
                if (actions.currentUser.getUsername().equals("manager")) {
                    managerMenu();
                }
                else {
                    mainMenu();
                }
            }
            else if (logInOrSignup == 2) {
                signup();
                mainMenu();
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

    public static void mainMenu() {
        Scanner input = new Scanner(System.in);
        int showOrMovie;
        do {
            System.out.println("\nWelcome to your Netflix account.\n1. TV Shows\n2. Movies\n(Enter any number to log out)");
            showOrMovie = input.nextInt();
            if (showOrMovie == 1) {
                tvShowsMenu();
            }
            else if (showOrMovie == 2) {
                moviesMenu();
            }
        }
        while (showOrMovie == 1 || showOrMovie == 2);
    }

    public static void tvShowsMenu() {
        System.out.println("");
    }

    public static void moviesMenu() {
        System.out.println("MOVIES!!!!!");
    }

    public static void managerMenu() {
        System.out.println("you're the only one seeing this.");
    }
}