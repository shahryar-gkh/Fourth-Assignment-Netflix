package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static NetflixService actions = new NetflixService();
    public static void main(String[] args) {
        actions.createAccount("manager", "GoodP@ssword1234");

        //Adding some tv shows
        ArrayList<String> strangerThingsCast = new ArrayList<>();
        strangerThingsCast.add("Millie Bobby Brown");
        strangerThingsCast.add("Finn Wolfhard");
        strangerThingsCast.add("David Harbour");
        strangerThingsCast.add("Winona Ryder");
        actions.addTVShow("Stranger Things", "Science Fiction", 2016, 4, 34, 92, strangerThingsCast);
        //actions.addToTVShowCast("Stranger Things", strangerThingsCast);
        ArrayList<String> wednesdayCast = new ArrayList<>();
        wednesdayCast.add("Jenna Ortega");
        wednesdayCast.add("Emma Myers");
        wednesdayCast.add("Christina Ricci");
        actions.addTVShow("Wednesday", "Horror", 2022, 1, 8, 71, wednesdayCast);
        //actions.addToTVShowCast("Wednesday", wednesdayCast);
        ArrayList<String> moneyHeistCast = new ArrayList<>();
        moneyHeistCast.add("Alvaro Morte");
        moneyHeistCast.add("Ursula Corbero");
        moneyHeistCast.add("Pedro  Alonso");
        moneyHeistCast.add("Itziar Ituno");
        actions.addTVShow("Money Heist", "Crime", 2017, 5, 41, 94, moneyHeistCast);
        //actions.addToTVShowCast("Money Heist", moneyHeistCast);
        ArrayList<String> darkCast = new ArrayList<>();
        darkCast.add("Louis Hoffman");
        darkCast.add("Lisa Vicari");
        darkCast.add("Andreas Pietschmann");
        darkCast.add("Gina Stiebtiz");
        actions.addTVShow("Dark", "Thriller", 2017, 3, 26, 95, darkCast);
        //actions.addToTVShowCast("Dark", darkCast);
        ArrayList<String> blackMirrorCast = new ArrayList<>();
        blackMirrorCast.add("Bryce Dallas Howard");
        blackMirrorCast.add("Anthony Mackie");
        blackMirrorCast.add("Jon Hamm");
        blackMirrorCast.add("Hayley Atwell");
        blackMirrorCast.add("Michaela Coel");
        actions.addTVShow("Black  Mirror", "Science Fiction", 2011, 5, 22, 84, blackMirrorCast);
        //actions.addToTVShowCast("Black Mirror", blackMirrorCast);
        ArrayList<String> youCast = new ArrayList<>();
        youCast.add("Penn Badgley");
        youCast.add("Victoria Pedretti");
        youCast.add("Tati Gabrielle");
        actions.addTVShow("You", "Thriller", 2018, 4, 40, 92, youCast);
        //actions.addToTVShowCast("You", youCast);
        ArrayList<String> bigMouthCast = new ArrayList<>();
        bigMouthCast.add("Nick Kroll");
        bigMouthCast.add("John Mulaney");
        bigMouthCast.add("Jessi Klein");
        bigMouthCast.add("Maya Rudolph");
        actions.addTVShow("Big Mouth", "Comedy", 2017, 6, 61, 99, bigMouthCast);
        //actions.addToTVShowCast("Big Mouth", bigMouthCast);

//        //Adding some movies
//        actions.addMovie("Red Notice", "Action", 2021, 1, 1, 36, 118);
//        ArrayList<String> redNoticeCast = new ArrayList<>();
//        redNoticeCast.add("Dwayne Johnson");
//        redNoticeCast.add("Ryan Reynolds");
//        redNoticeCast.add("Gal Gadot");
//        actions.addToMovieCast("Red Notice", redNoticeCast);
//        actions.addMovie("Bird Box", "Thriller", 2018, 1, 1, 64, 124);
//        ArrayList<String> birdBoxCast = new ArrayList<>();
//        birdBoxCast.add("Sandra Bullock");
//        birdBoxCast.add("Sarah Paulson");
//        birdBoxCast.add("Trevante Rhodes");
//        birdBoxCast.add("John Malkovich");
//        actions.addToMovieCast("Bird Box", birdBoxCast);
//        actions.addMovie("Don't Look Up", "Comedy", 2021, 1, 1, 56, 145);
//        ArrayList<String> dontLookUpCast = new ArrayList<>();
//        dontLookUpCast.add("Leonardo DiCaprio");
//        dontLookUpCast.add("Jennifer Lawrence");
//        dontLookUpCast.add("Meryl Streep");
//        dontLookUpCast.add("Cate Blanchett");
//        dontLookUpCast.add("Timothee Chalamet");
//        actions.addToMovieCast("Don't Look Up", dontLookUpCast);
//        actions.addMovie("Glass Onion", "Mystery", 2022, 1, 1, 92, 139);
//        ArrayList<String> glassOnionCast = new ArrayList<>();
//        glassOnionCast.add("Daniel Craig");
//        glassOnionCast.add("Hugh Grant");
//        glassOnionCast.add("Madelyn Cline");
//        glassOnionCast.add("Kate Hudson");
//        actions.addToMovieCast("Glass Onion", glassOnionCast);
//        actions.addMovie("The Irishman", "Drama", 2019, 1, 1, 95, 209);
//        ArrayList<String> theIrishmanCast = new ArrayList<>();
//        theIrishmanCast.add("Robert De Niro");
//        theIrishmanCast.add("Al Pacino");
//        theIrishmanCast.add("Joe Pesci");
//        actions.addToMovieCast("The Irishman", theIrishmanCast);

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
                if (actions.getCurrentUser().getUsername().equals("manager")) {
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
        actions.setCurrentUser(username, password);
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
        actions.setCurrentUser(username,password);
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
            System.out.println("\n1. See a list of all available shows\n2. Search among all shows on Netflix\n3. Search among your favorite shows\n4. View your watch history in TV shows\n5. View your  profile\n(Enter 0 to go back)");
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
        actions.giveListOfShows();
        System.out.println("\nEnter the name of the show you want to watch (Enter \"e\" if you want to return to the menu):");
        Scanner input = new Scanner(System.in);
        String name;
        while(true) {
            name = input.nextLine();
            if (name.equals("e")) {
                return;
            }
            else if (!actions.doesShowExist(name)) {
                System.out.println("\nThis show doesn't exist. Make sure you're typing in the full title of the show or at least a part of it.\n(Enter \"e\" if you want to return to the menu):");
            }
            else {
                break;
            }
        }
        System.out.println(actions.searchByTitle(name));
        if (actions.searchByTitle(name).size() != 1) {
            do {
                System.out.println("Please be more specific with the title of the show. Enter the full name (Or enter \"e\" if you want to go back to the menu):");
                name = input.nextLine();
                if (name.equalsIgnoreCase("e")) {
                    return;
                }
            } while (actions.searchByTitle(name).size() != 1 && !actions.doesShowExistWithExactName(name));
        }
        System.out.println("Is this the show you want to watch?\n1. Yes\n2. No");
        int watchOrNot = input.nextInt();
        if (watchOrNot == 1) {
            TVShow currentShow = actions.searchByTitle(name).get(0);
            actions.getCurrentUser().watchShow(currentShow);
            System.out.println("You have just watched " + name + ".\nWould you like to add it to your favorites?\n1. Yes\n2. No");
            int faveOrNot = input.nextInt();
            if (faveOrNot == 1) {
                actions.getCurrentUser().addToFavorites(currentShow);
            }
        }
    }

    public static void moviesMenu() {
        Scanner input = new Scanner(System.in);
        int userChoice;
        do {
            System.out.println("\n1. See a list of all available movies\n2. View your watch history in movies\n3. View your  profile\n(Enter 0 to go back)");
            userChoice = input.nextInt();
            switch (userChoice) {
                case 1:
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

    public static void managerMenu() {
        System.out.println("you're the only one seeing this.");
    }
}