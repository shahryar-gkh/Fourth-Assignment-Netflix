package org.example;

import java.util.Scanner;

public class Main {
    static NetflixService actions = new NetflixService();
    public static void main(String[] args) {
        actions.createAccount("manager", "GoodP@ssword1234");

        //Adding some tv shows
        actions.addTVShow("Stranger Things", "Science Fiction", 2016, 4, 34, 92);
        actions.addToTVShowCast("Stranger Things", "Millie Bobby Brown");
//        actions.addToTVShowCast("Stranger Things", "Finn Wolfhard");
//        actions.addToTVShowCast("Stranger Things", "David Harbour");
//        actions.addToTVShowCast("Stranger Things", "Winona Ryder");
        actions.addTVShow("Wednesday", "Horror", 2022, 1, 8, 71);
//        actions.addToTVShowCast("Wednesday", "Jenna Ortega");
//        actions.addToTVShowCast("Wednesday", "Emma Myers");
//        actions.addToTVShowCast("Wednesday", "Christina Ricci");
        actions.addTVShow("Money Heist", "Crime", 2017, 5, 41, 94);
//        actions.addToTVShowCast("Money Heist", "Alvaro Morte");
//        actions.addToTVShowCast("Money Heist", "Ursula Corbero");
//        actions.addToTVShowCast("Money Heist", "Pedro  Alonso");
//        actions.addToTVShowCast("Money Heist", "Itziar Ituno");
        actions.addTVShow("Dark", "Thriller", 2017, 3, 26, 95);
//        actions.addToTVShowCast("Dark", "Louis Hoffman");
//        actions.addToTVShowCast("Dark", "Lisa Vicari");
//        actions.addToTVShowCast("Dark", "Andreas Pietschmann");
//        actions.addToTVShowCast("Dark", "Gina Stiebtiz");
        actions.addTVShow("Black  Mirror", "Science Fiction", 2011, 5, 22, 84);
//        actions.addToTVShowCast("Black Mirror", "Bryce Dallas Howard");
//        actions.addToTVShowCast("Black Mirror", "Anthony Mackie");
//        actions.addToTVShowCast("Black Mirror", "Jon Hamm");
//        actions.addToTVShowCast("Black Mirror", "Hayley Atwell");
//        actions.addToTVShowCast("Black Mirror", "Michaela Coel");
        actions.addTVShow("You", "Thriller", 2018, 4, 40, 92);
//        actions.addToTVShowCast("You", "Penn Badgley");
//        actions.addToTVShowCast("You", "Victoria Pedretti");
//        actions.addToTVShowCast("You", "Tati Gabrielle");
        actions.addTVShow("Big Mouth", "Comedy", 2017, 6, 61, 99);
//        actions.addToTVShowCast("Big Mouth", "Nick Kroll");
//        actions.addToTVShowCast("Big Mouth", "John Mulaney");
//        actions.addToTVShowCast("Big Mouth", "Jessi Klein");
//        actions.addToTVShowCast("Big Mouth", "Maya Rudolph");
//
//        //Adding some movies
//        actions.addMovie("Red Notice", "Action", 2021, 1, 1, 36, 118);
//        actions.addToMovieCast("Red Notice", "Dwayne Johnson");
//        actions.addToMovieCast("Red Notice", "Ryan Reynolds");
//        actions.addToMovieCast("Red Notice", "Gal Gadot");
//        actions.addMovie("Bird Box", "Thriller", 2018, 1, 1, 64, 124);
//        actions.addToMovieCast("Bird Box", "Sandra Bullock");
//        actions.addToMovieCast("Bird Box", "Sarah Paulson");
//        actions.addToMovieCast("Bird Box", "Trevante Rhodes");
//        actions.addToMovieCast("Bird Box", "John Malkovich");
//        actions.addMovie("Don't Look Up", "Comedy", 2021, 1, 1, 56, 145);
//        actions.addToMovieCast("Don't Look Up", "Leonardo DiCaprio");
//        actions.addToMovieCast("Don't Look Up", "Jennifer Lawrence");
//        actions.addToMovieCast("Don't Look Up", "Meryl Streep");
//        actions.addToMovieCast("Don't Look Up", "Cate Blanchett");
//        actions.addToMovieCast("Don't Look Up", "Timothee Chalamet");
//        actions.addMovie("Glass Onion", "Mystery", 2022, 1, 1, 92, 139);
//        actions.addToMovieCast("Glass Onion", "Daniel Craig");
//        actions.addToMovieCast("Glass Onion", "Hugh Grant");
//        actions.addToMovieCast("Glass Onion", "Madelyn Cline");
//        actions.addToMovieCast("Glass Onion", "Kate Hudson");
//        actions.addMovie("The Irishman", "Drama", 2019, 1, 1, 95, 209);
//        actions.addToMovieCast("The Irishman", "Robert De Niro");
//        actions.addToMovieCast("The Irishman", "Al Pacino");
//        actions.addToMovieCast("The Irishman", "Joe Pesci");

        runMenu();
    }

    public static void runMenu(){
        Scanner input = new Scanner(System.in);
        int logInOrSignup;
        do {
            System.out.println("\n\nWATCH TV SHOWS & MOVIES\nANYWHERE,\nANYTIME.\n\n1. Log In\n2. Sign Up\n(Enter 0 to close the program)");
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
        while (logInOrSignup != 0);
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
            System.out.println("\nWelcome to your Netflix account.\n1. TV Shows\n2. Movies\n(Enter 0 to log out)");
            showOrMovie = input.nextInt();
            if (showOrMovie == 1) {
                tvShowsMenu();
            }
            else if (showOrMovie == 2) {
                moviesMenu();
            }
        }
        while (showOrMovie != 0);
    }

    public static void tvShowsMenu() {
        Scanner input = new Scanner(System.in);
        int userChoice;
        do {
            System.out.println("\n1. See a list of all available shows\n2. Search among all shows on Netflix\n3. Search among your favorite shows\n4. View your  profile\n(Enter 0 to go back)");
            userChoice = input.nextInt();
            switch (userChoice) {
                case 1:
                    listOfShows();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        } while (userChoice != 0);
    }

    public static void listOfShows() {
        for (TVShow show : actions.tvShows) {
            System.out.println(show);
            for (String cast : show.getCast()) {
                System.out.print(cast + "   ");
            }
        }
    }

    public static void moviesMenu() {
        System.out.println("MOVIES!!!!!");
    }

    public static void managerMenu() {
        System.out.println("you're the only one seeing this.");
    }
}