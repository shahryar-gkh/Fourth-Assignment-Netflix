package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static NetflixService actions = new NetflixService();
    static boolean deleteAccount = false;
    public static void main(String[] args) {
        actions.createAccount("manager", "GoodP@ssword1234");

        //Adding some tv shows
        ArrayList<String> strangerThingsCast = new ArrayList<>();
        strangerThingsCast.add("Millie Bobby Brown");
        strangerThingsCast.add("Finn Wolfhard");
        strangerThingsCast.add("David Harbour");
        strangerThingsCast.add("Winona Ryder");
        actions.addTVShow("Stranger Things", "Science Fiction", 2016, 4, 34, 92, strangerThingsCast);
        ArrayList<String> wednesdayCast = new ArrayList<>();
        wednesdayCast.add("Jenna Ortega");
        wednesdayCast.add("Emma Myers");
        wednesdayCast.add("Christina Ricci");
        actions.addTVShow("Wednesday", "Horror", 2022, 1, 8, 71, wednesdayCast);
        ArrayList<String> moneyHeistCast = new ArrayList<>();
        moneyHeistCast.add("Alvaro Morte");
        moneyHeistCast.add("Ursula Corbero");
        moneyHeistCast.add("Pedro  Alonso");
        moneyHeistCast.add("Itziar Ituno");
        actions.addTVShow("Money Heist", "Crime", 2017, 5, 41, 94, moneyHeistCast);
        ArrayList<String> darkCast = new ArrayList<>();
        darkCast.add("Louis Hoffman");
        darkCast.add("Lisa Vicari");
        darkCast.add("Andreas Pietschmann");
        darkCast.add("Gina Stiebtiz");
        actions.addTVShow("Dark", "Thriller", 2017, 3, 26, 95, darkCast);
        ArrayList<String> blackMirrorCast = new ArrayList<>();
        blackMirrorCast.add("Bryce Dallas Howard");
        blackMirrorCast.add("Anthony Mackie");
        blackMirrorCast.add("Jon Hamm");
        blackMirrorCast.add("Hayley Atwell");
        blackMirrorCast.add("Michaela Coel");
        actions.addTVShow("Black  Mirror", "Science Fiction", 2011, 5, 22, 84, blackMirrorCast);
        ArrayList<String> youCast = new ArrayList<>();
        youCast.add("Penn Badgley");
        youCast.add("Victoria Pedretti");
        youCast.add("Tati Gabrielle");
        actions.addTVShow("You", "Thriller", 2018, 4, 40, 92, youCast);
        ArrayList<String> bigMouthCast = new ArrayList<>();
        bigMouthCast.add("Nick Kroll");
        bigMouthCast.add("John Mulaney");
        bigMouthCast.add("Jessi Klein");
        bigMouthCast.add("Maya Rudolph");
        actions.addTVShow("Big Mouth", "Comedy", 2017, 6, 61, 99, bigMouthCast);

        //Adding some movies
        ArrayList<String> redNoticeCast = new ArrayList<>();
        redNoticeCast.add("Dwayne Johnson");
        redNoticeCast.add("Ryan Reynolds");
        redNoticeCast.add("Gal Gadot");
        actions.addMovie("Red Notice", "Action", 2021, 1, 1, 36, redNoticeCast, 118);
        ArrayList<String> birdBoxCast = new ArrayList<>();
        birdBoxCast.add("Sandra Bullock");
        birdBoxCast.add("Sarah Paulson");
        birdBoxCast.add("Trevante Rhodes");
        birdBoxCast.add("John Malkovich");
        actions.addMovie("Bird Box", "Thriller", 2018, 1, 1, 64, birdBoxCast, 124);
        ArrayList<String> dontLookUpCast = new ArrayList<>();
        dontLookUpCast.add("Leonardo DiCaprio");
        dontLookUpCast.add("Jennifer Lawrence");
        dontLookUpCast.add("Meryl Streep");
        dontLookUpCast.add("Cate Blanchett");
        dontLookUpCast.add("Timothee Chalamet");
        actions.addMovie("Don't Look Up", "Comedy", 2021, 1, 1, 56, dontLookUpCast, 145);
        ArrayList<String> glassOnionCast = new ArrayList<>();
        glassOnionCast.add("Daniel Craig");
        glassOnionCast.add("Hugh Grant");
        glassOnionCast.add("Madelyn Cline");
        glassOnionCast.add("Kate Hudson");
        actions.addMovie("Glass Onion", "Mystery", 2022, 1, 1, 92, glassOnionCast, 139);
        ArrayList<String> theIrishmanCast = new ArrayList<>();
        theIrishmanCast.add("Robert De Niro");
        theIrishmanCast.add("Al Pacino");
        theIrishmanCast.add("Joe Pesci");
        actions.addMovie("The Irishman", "Drama", 2019, 1, 1, 95, theIrishmanCast, 209);

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
            System.out.println("\nWelcome to your Netflix account.\n1. TV Shows\n2. Movies\n3. View your Netflix profile\n(Enter 0 to log out)");
            showOrMovie = input.nextInt();
            if (showOrMovie == 1) {
                tvShowsMenu();
            }
            else if (showOrMovie == 2) {
                moviesMenu();
            }
            else if (showOrMovie == 3) {
                viewProfile();
            }
        }
        while (showOrMovie != 0 && !deleteAccount);
        if (deleteAccount) {
            actions.deleteAccount(actions.getCurrentUser().getUsername());
        }
        actions.logout();
    }

    public static void tvShowsMenu() {
        Scanner input = new Scanner(System.in);
        int userChoice;
        do {
            System.out.println("\n1. See a list of all available shows\n2. Search among all shows on Netflix\n3. Search among your previously watched shows\n4. View your favorite shows\n5. View your watch history in TV shows\n(Enter 0 to go back)");
            userChoice = input.nextInt();
            switch (userChoice) {
                case 1:
                    listOfShows();
                    break;
                case 2:
                    searchInAllShows();
                    break;
                case 3:
                    searchInWatchedShows();
                    break;
                case 4:
                    listOfFavoriteShows();
                    break;
                case 5:
                    listOfWatchedShows();
                    break;
            }
        } while (userChoice != 0);
    }

    public static void listOfShows() {
        Scanner input = new Scanner(System.in);
        int searchOrNot;
        do {
            actions.printListOfAllShows();
            System.out.println("\nWould you like to watch one of these shows?\n1. Yes. I would like to do a search.\n2. No. take me to the previous page");
            searchOrNot = Integer.parseInt(input.nextLine());
            if (searchOrNot == 1) {
                searchInAllShows();
            }
        } while (searchOrNot == 1);
    }

    public static void searchInAllShows() {
        Scanner input = new Scanner(System.in);
        int searchBy;
        do {
            System.out.println("\nSearch among all of the shows on Netflix by:\n1. Title\n2. Genre\n3. Year\n(Enter 0 if you want to return to the menu)");
            searchBy = Integer.parseInt(input.nextLine());
            if (searchBy == 1) {
                System.out.println("\nEnter the name of the show you want to watch (Enter \"e\" if you want to return to the menu):");
                String name;
                while(true) {
                    name = input.nextLine();
                    if (name.equalsIgnoreCase("e")) {
                        return;
                    }
                    else if (actions.searchByTitle(name).size() == 0) {
                        System.out.println("\nThis show doesn't exist. Make sure you're typing in the full title of the show or at least a part of it.\n(Enter \"e\" if you want to return to the menu):");
                    }
                    else {
                        break;
                    }
                }
                actions.printListOfShowsInArraylist(actions.searchByTitle(name));
                if (actions.searchByTitle(name).size() > 1) {
                    do {
                        System.out.println("\nPlease be more specific with the title of the show. Enter the full name (Or enter \"e\" if you want to go back to the menu):");
                        name = input.nextLine();
                        if (name.equalsIgnoreCase("e")) {
                            return;
                        }
                    } while (actions.searchByTitle(name).size() > 1 || !actions.doesShowExistWithExactName(name));
                    actions.printListOfShowsInArraylist(actions.searchByTitle(name));
                }
                System.out.println("\nIs this the show you want to watch?\n1. Yes\n2. No");
                int watchOrNot = Integer.parseInt(input.nextLine());
                if (watchOrNot == 1) {
                    TVShow currentShow = actions.searchByTitle(name).get(0);
                    actions.getCurrentUser().watchShow(currentShow);
                    System.out.println("You have just watched \"" + currentShow.getTitle() + "\".\nWould you like to add it to your favorites?\n1. Yes\n2. No");
                    int faveOrNot = Integer.parseInt(input.nextLine());
                    if (faveOrNot == 1) {
                        actions.getCurrentUser().addToFavoriteShows(currentShow);
                        System.out.println("You added \"" + currentShow.getTitle() + "\" to your favorite shows.");
                    }
                }
            }
            else if (searchBy == 2) {
                System.out.println("\nEnter the name of the genre you're interested in (Enter \"e\" if you want to return to the menu):");
                String genre;
                TVShow currentShow;
                while(true) {
                    genre = input.nextLine();
                    if (genre.equalsIgnoreCase("e")) {
                        return;
                    }
                    else if (actions.searchByGenre(genre).size() == 0) {
                        System.out.println("\nThis genre doesn't exist. Make sure you're typing in the full name of the genre or at least a part of it (Enter \"e\" if you want to return to the menu):");
                    }
                    else {
                        break;
                    }
                }
                actions.printListOfShowsInArraylist(actions.searchByGenre(genre));
                if (actions.searchByGenre(genre).size() > 1) {
                    System.out.println("\nThere are multiple shows with this genre. To be more specific, enter the full title of the show you want to watch among the ones above (Or enter \"e\" if you want to go back to the menu):");
                    String title = input.nextLine();
                    if (title.equalsIgnoreCase("e")) {
                        return;
                    }
                    while (actions.searchByTitle(title).size() > 1 || !actions.doesShowExistWithExactName(title)) {
                        System.out.println("\nPlease be more specific with the title of the show. Enter the full name (Or enter \"e\" if you want to go back to the menu):");
                        title = input.nextLine();
                        if (title.equalsIgnoreCase("e")) {
                            return;
                        }
                    }
                    actions.printListOfShowsInArraylist(actions.searchByTitle(title));
                    currentShow = actions.searchByTitle(title).get(0);
                }
                else {
                    currentShow = actions.searchByGenre(genre).get(0);
                }
                System.out.println("\nIs this the show you want to watch?\n1. Yes\n2. No");
                int watchOrNot = Integer.parseInt(input.nextLine());
                if (watchOrNot == 1) {
                    actions.getCurrentUser().watchShow(currentShow);
                    System.out.println("You have just watched \"" + currentShow.getTitle() + "\".\nWould you like to add it to your favorites?\n1. Yes\n2. No");
                    int faveOrNot = Integer.parseInt(input.nextLine());
                    if (faveOrNot == 1) {
                        actions.getCurrentUser().addToFavoriteShows(currentShow);
                        System.out.println("You added \"" + currentShow.getTitle() + "\" to your favorite shows.");
                    }
                }
            }
            else if (searchBy == 3) {
                System.out.println("\nEnter the year you're interested in (Enter 0 if you want to return to the menu):");
                int year;
                TVShow currentShow;
                while(true) {
                    year = Integer.parseInt(input.nextLine());
                    if (year == 0) {
                        return;
                    }
                    else if (actions.searchByReleaseYear(year).size() == 0) {
                        System.out.println("\nThere are no shows from that year. Try another year (Enter 0 if you want to return to the menu):");
                    }
                    else {
                        break;
                    }
                }
                actions.printListOfShowsInArraylist(actions.searchByReleaseYear(year));
                if (actions.searchByReleaseYear(year).size() > 1) {
                    System.out.println("\nThere are multiple shows made in that year. To be more specific, enter the full title of the show you want to watch among the ones above (Or enter \"e\" if you want to go back to the menu):");
                    String title = input.nextLine();
                    if (title.equalsIgnoreCase("e")) {
                        return;
                    }
                    while (actions.searchByTitle(title).size() > 1 || !actions.doesShowExistWithExactName(title)) {
                        System.out.println("\nPlease be more specific with the title of the show. Enter the full name (Or enter \"e\" if you want to go back to the menu):");
                        title = input.nextLine();
                        if (title.equalsIgnoreCase("e")) {
                            return;
                        }
                    }
                    actions.printListOfShowsInArraylist(actions.searchByTitle(title));
                    currentShow = actions.searchByTitle(title).get(0);
                }
                else {
                    currentShow = actions.searchByReleaseYear(year).get(0);
                }
                System.out.println("\nIs this the show you want to watch?\n1. Yes\n2. No");
                int watchOrNot = Integer.parseInt(input.nextLine());
                if (watchOrNot == 1) {
                    actions.getCurrentUser().watchShow(currentShow);
                    System.out.println("You have just watched \"" + currentShow.getTitle() + "\".\nWould you like to add it to your favorites?\n1. Yes\n2. No");
                    int faveOrNot = Integer.parseInt(input.nextLine());
                    if (faveOrNot == 1) {
                        actions.getCurrentUser().addToFavoriteShows(currentShow);
                        System.out.println("You added \"" + currentShow.getTitle() + "\" to your favorite shows.");
                    }
                }
            }
        } while (searchBy != 0);
    }

    public static void searchInWatchedShows() {
        actions.printListOfShowsInArraylist(actions.getCurrentUser().getFavoriteShows());
        Scanner input = new Scanner(System.in);
        int searchBy;
        do {
            System.out.println("\nSearch among your previously watched shows by:\n1. Title\n2. Genre\n3. Year\n(Enter 0 if you want to return to the menu)");
            searchBy = Integer.parseInt(input.nextLine());
            if (searchBy == 1) {
                System.out.println("\nEnter the name of the show you want to watch (Enter \"e\" if you want to return to the menu):");
                String name;
                while(true) {
                    name = input.nextLine();
                    if (name.equalsIgnoreCase("e")) {
                        return;
                    }
                    else if (actions.getCurrentUser().searchByTitle(name).size() == 0) {
                        System.out.println("\nThis show isn't in your previously watched TV shows. Make sure you're typing in the full title of the show or at least a part of it.\n(Enter \"e\" if you want to return to the menu):");
                    }
                    else {
                        break;
                    }
                }
                actions.printListOfShowsInArraylist(actions.getCurrentUser().searchByTitle(name));
                if (actions.getCurrentUser().searchByTitle(name).size() > 1) {
                    do {
                        System.out.println("\nPlease be more specific with the title of the show. Enter the full name (Or enter \"e\" if you want to go back to the menu):");
                        name = input.nextLine();
                        if (name.equalsIgnoreCase("e")) {
                            return;
                        }
                    } while (actions.getCurrentUser().searchByTitle(name).size() > 1 || !actions.doesShowExistWithExactName(name));
                    actions.printListOfShowsInArraylist(actions.getCurrentUser().searchByTitle(name));
                }
                System.out.println("\nIs this the show you want to watch?\n1. Yes\n2. No");
                int watchOrNot = Integer.parseInt(input.nextLine());
                if (watchOrNot == 1) {
                    TVShow currentShow = actions.getCurrentUser().searchByTitle(name).get(0);
                    System.out.println("You have just watched \"" + currentShow.getTitle() + "\".");
                }
            }
            else if (searchBy == 2) {
                System.out.println("\nEnter the name of the genre you're interested in (Enter \"e\" if you want to return to the menu):");
                String genre;
                TVShow currentShow;
                while(true) {
                    genre = input.nextLine();
                    if (genre.equalsIgnoreCase("e")) {
                        return;
                    }
                    else if (actions.getCurrentUser().searchByGenre(genre).size() == 0) {
                        System.out.println("\nThis genre doesn't exist in your previously watched movies. Make sure you're typing in the full name of the genre or at least a part of it (Enter \"e\" if you want to return to the menu):");
                    }
                    else {
                        break;
                    }
                }
                actions.printListOfShowsInArraylist(actions.getCurrentUser().searchByGenre(genre));
                if (actions.getCurrentUser().searchByGenre(genre).size() > 1) {
                    System.out.println("\nThere are multiple shows with this genre in your watch history. To be more specific, enter the full title of the show you want to watch among the ones above (Or enter \"e\" if you want to go back to the menu):");
                    String title = input.nextLine();
                    if (title.equalsIgnoreCase("e")) {
                        return;
                    }
                    while (actions.getCurrentUser().searchByTitle(title).size() > 1 || !actions.doesShowExistWithExactName(title)) {
                        System.out.println("\nPlease be more specific with the title of the show. Enter the full name (Or enter \"e\" if you want to go back to the menu):");
                        title = input.nextLine();
                        if (title.equalsIgnoreCase("e")) {
                            return;
                        }
                    }
                    actions.printListOfShowsInArraylist(actions.getCurrentUser().searchByTitle(title));
                    currentShow = actions.getCurrentUser().searchByTitle(title).get(0);
                }
                else {
                    currentShow = actions.getCurrentUser().searchByGenre(genre).get(0);
                }
                System.out.println("\nIs this the show you want to watch?\n1. Yes\n2. No");
                int watchOrNot = Integer.parseInt(input.nextLine());
                if (watchOrNot == 1) {
                    System.out.println("You have just watched \"" + currentShow.getTitle() + "\".");
                }
            }
            else if (searchBy == 3) {
                System.out.println("\nEnter the year you're interested in (Enter 0 if you want to return to the menu):");
                int year;
                TVShow currentShow;
                while(true) {
                    year = Integer.parseInt(input.nextLine());
                    if (year == 0) {
                        return;
                    }
                    else if (actions.getCurrentUser().searchByReleaseYear(year).size() == 0) {
                        System.out.println("\nThere are no shows from that year in your watch history. Try another year (Enter 0 if you want to return to the menu):");
                    }
                    else {
                        break;
                    }
                }
                actions.printListOfShowsInArraylist(actions.getCurrentUser().searchByReleaseYear(year));
                if (actions.getCurrentUser().searchByReleaseYear(year).size() > 1) {
                    System.out.println("\nThere are multiple shows made in that year that are in your watch history. To be more specific, enter the full title of the show you want to watch among the ones above (Or enter \"e\" if you want to go back to the menu):");
                    String title = input.nextLine();
                    if (title.equalsIgnoreCase("e")) {
                        return;
                    }
                    while (actions.getCurrentUser().searchByTitle(title).size() > 1 || !actions.doesShowExistWithExactName(title)) {
                        System.out.println("\nPlease be more specific with the title of the show. Enter the full name (Or enter \"e\" if you want to go back to the menu):");
                        title = input.nextLine();
                        if (title.equalsIgnoreCase("e")) {
                            return;
                        }
                    }
                    actions.printListOfShowsInArraylist(actions.getCurrentUser().searchByTitle(title));
                    currentShow = actions.getCurrentUser().searchByTitle(title).get(0);
                }
                else {
                    currentShow = actions.getCurrentUser().searchByReleaseYear(year).get(0);
                }
                System.out.println("\nIs this the show you want to watch?\n1. Yes\n2. No");
                int watchOrNot = Integer.parseInt(input.nextLine());
                if (watchOrNot == 1) {
                    System.out.println("You have just watched \"" + currentShow.getTitle() + "\".\n");
                }
            }
        } while (searchBy != 0);
    }

    public static void listOfFavoriteShows() {
        actions.printListOfShowsInArraylist(actions.getCurrentUser().getFavoriteShows());
    }

    public static void listOfWatchedShows() {
        Scanner input = new Scanner(System.in);
        int searchOrNot;
        do {
            actions.printListOfShowsInArraylist(actions.getCurrentUser().getPreviouslyWatchedShows());
            System.out.println("\nWould you like to watch one of these shows?\n1. Yes. I would like to do a search.\n2. No. take me to the previous page");
            searchOrNot = Integer.parseInt(input.nextLine());
            if (searchOrNot == 1) {
                searchInWatchedShows();
            }
        } while (searchOrNot == 1);
    }

    //Methods related to the movie menu
    public static void moviesMenu() {
        Scanner input = new Scanner(System.in);
        int userChoice;
        do {
            System.out.println("\n1. See a list of all available movies\n2. Search among all movies on Netflix\n3. Search among your previously watched movies\n4. View your favorite movies\n5. View your watch history in movies\n(Enter 0 to go back)");
            userChoice = input.nextInt();
            switch (userChoice) {
                case 1:
                    listOfMovies();
                    break;
                case 2:
                    searchInAllMovies();
                    break;
                case 3:
                    searchInWatchedMovies();
                    break;
                case 4:
                    listOfFavoriteMovies();
                    break;
                case 5:
                    listOfWatchedMovies();
                    break;
            }
        } while (userChoice != 0);
    }

    public static void listOfMovies() {
        Scanner input = new Scanner(System.in);
        int searchOrNot;
        do {
            actions.printListOfAllMovies();
            System.out.println("\nWould you like to watch one of these movies?\n1. Yes. I would like to do a search.\n2. No. take me to the previous page");
            searchOrNot = Integer.parseInt(input.nextLine());
            if (searchOrNot == 1) {
                searchInAllMovies();
            }
        } while (searchOrNot == 1);
    }

    public static void searchInAllMovies() {
        Scanner input = new Scanner(System.in);
        int searchBy;
        do {
            System.out.println("\nSearch among all of the movies on Netflix by:\n1. Title\n2. Genre\n3. Year\n(Enter 0 if you want to return to the menu)");
            searchBy = Integer.parseInt(input.nextLine());
            if (searchBy == 1) {
                System.out.println("\nEnter the name of the movie you want to watch (Enter \"e\" if you want to return to the menu):");
                String name;
                while(true) {
                    name = input.nextLine();
                    if (name.equalsIgnoreCase("e")) {
                        return;
                    }
                    else if (actions.searchByTitleInMovies(name).size() == 0) {
                        System.out.println("\nThis movie doesn't exist. Make sure you're typing in the full title of the movie or at least a part of it.\n(Enter \"e\" if you want to return to the menu):");
                    }
                    else {
                        break;
                    }
                }
                actions.printListOfMoviesInArraylist(actions.searchByTitleInMovies(name));
                if (actions.searchByTitleInMovies(name).size() > 1) {
                    do {
                        System.out.println("\nPlease be more specific with the title of the movie. Enter the full name (Or enter \"e\" if you want to go back to the menu):");
                        name = input.nextLine();
                        if (name.equalsIgnoreCase("e")) {
                            return;
                        }
                    } while (actions.searchByTitleInMovies(name).size() > 1 || !actions.doesMovieExistWithExactName(name));
                    actions.printListOfMoviesInArraylist(actions.searchByTitleInMovies(name));
                }
                System.out.println("\nIs this the movie you want to watch?\n1. Yes\n2. No");
                int watchOrNot = Integer.parseInt(input.nextLine());
                if (watchOrNot == 1) {
                    Movie currentMovie = actions.searchByTitleInMovies(name).get(0);
                    actions.getCurrentUser().watchMovie(currentMovie);
                    System.out.println("You have just watched \"" + currentMovie.getTitle() + "\".\nWould you like to add it to your favorites?\n1. Yes\n2. No");
                    int faveOrNot = Integer.parseInt(input.nextLine());
                    if (faveOrNot == 1) {
                        actions.getCurrentUser().addToFavoriteMovies(currentMovie);
                        System.out.println("You added \"" + currentMovie.getTitle() + "\" to your favorite movies.");
                    }
                }
            }
            else if (searchBy == 2) {
                System.out.println("\nEnter the name of the genre you're interested in (Enter \"e\" if you want to return to the menu):");
                String genre;
                Movie currentMovie;
                while(true) {
                    genre = input.nextLine();
                    if (genre.equalsIgnoreCase("e")) {
                        return;
                    }
                    else if (actions.searchByGenreInMovies(genre).size() == 0) {
                        System.out.println("\nThis genre doesn't exist. Make sure you're typing in the full name of the genre or at least a part of it (Enter \"e\" if you want to return to the menu):");
                    }
                    else {
                        break;
                    }
                }
                actions.printListOfMoviesInArraylist(actions.searchByGenreInMovies(genre));
                if (actions.searchByGenreInMovies(genre).size() > 1) {
                    System.out.println("\nThere are multiple movies with this genre. To be more specific, enter the full title of the movie you want to watch among the ones above (Or enter \"e\" if you want to go back to the menu):");
                    String title = input.nextLine();
                    if (title.equalsIgnoreCase("e")) {
                        return;
                    }
                    while (actions.searchByTitleInMovies(title).size() > 1 || !actions.doesMovieExistWithExactName(title)) {
                        System.out.println("\nPlease be more specific with the title of the movie. Enter the full name (Or enter \"e\" if you want to go back to the menu):");
                        title = input.nextLine();
                        if (title.equalsIgnoreCase("e")) {
                            return;
                        }
                    }
                    actions.printListOfMoviesInArraylist(actions.searchByTitleInMovies(title));
                    currentMovie = actions.searchByTitleInMovies(title).get(0);
                }
                else {
                    currentMovie = actions.searchByGenreInMovies(genre).get(0);
                }
                System.out.println("\nIs this the movie you want to watch?\n1. Yes\n2. No");
                int watchOrNot = Integer.parseInt(input.nextLine());
                if (watchOrNot == 1) {
                    actions.getCurrentUser().watchMovie(currentMovie);
                    System.out.println("You have just watched \"" + currentMovie.getTitle() + "\".\nWould you like to add it to your favorites?\n1. Yes\n2. No");
                    int faveOrNot = Integer.parseInt(input.nextLine());
                    if (faveOrNot == 1) {
                        actions.getCurrentUser().addToFavoriteMovies(currentMovie);
                        System.out.println("You added \"" + currentMovie.getTitle() + "\" to your favorite movies.");
                    }
                }
            }
            else if (searchBy == 3) {
                System.out.println("\nEnter the year you're interested in (Enter 0 if you want to return to the menu):");
                int year;
                Movie currentMovie;
                while(true) {
                    year = Integer.parseInt(input.nextLine());
                    if (year == 0) {
                        return;
                    }
                    else if (actions.searchByReleaseYearInMovies(year).size() == 0) {
                        System.out.println("\nThere are no movies from that year. Try another year (Enter 0 if you want to return to the menu):");
                    }
                    else {
                        break;
                    }
                }
                actions.printListOfMoviesInArraylist(actions.searchByReleaseYearInMovies(year));
                if (actions.searchByReleaseYearInMovies(year).size() > 1) {
                    System.out.println("\nThere are multiple movies made in that year. To be more specific, enter the full title of the movie you want to watch among the ones above (Or enter \"e\" if you want to go back to the menu):");
                    String title = input.nextLine();
                    if (title.equalsIgnoreCase("e")) {
                        return;
                    }
                    while (actions.searchByTitleInMovies(title).size() > 1 || !actions.doesMovieExistWithExactName(title)) {
                        System.out.println("\nPlease be more specific with the title of the movie. Enter the full name (Or enter \"e\" if you want to go back to the menu):");
                        title = input.nextLine();
                        if (title.equalsIgnoreCase("e")) {
                            return;
                        }
                    }
                    actions.printListOfMoviesInArraylist(actions.searchByTitleInMovies(title));
                    currentMovie = actions.searchByTitleInMovies(title).get(0);
                }
                else {
                    currentMovie = actions.searchByReleaseYearInMovies(year).get(0);
                }
                System.out.println("\nIs this the movie you want to watch?\n1. Yes\n2. No");
                int watchOrNot = Integer.parseInt(input.nextLine());
                if (watchOrNot == 1) {
                    actions.getCurrentUser().watchMovie(currentMovie);
                    System.out.println("You have just watched \"" + currentMovie.getTitle() + "\".\nWould you like to add it to your favorites?\n1. Yes\n2. No");
                    int faveOrNot = Integer.parseInt(input.nextLine());
                    if (faveOrNot == 1) {
                        actions.getCurrentUser().addToFavoriteMovies(currentMovie);
                        System.out.println("You added \"" + currentMovie.getTitle() + "\" to your favorite movies.");
                    }
                }
            }
        } while (searchBy != 0);
    }

    public static void searchInWatchedMovies() {
        actions.printListOfMoviesInArraylist(actions.getCurrentUser().getFavoriteMovies());
        Scanner input = new Scanner(System.in);
        int searchBy;
        do {
            System.out.println("\nSearch among your previously watched movies by:\n1. Title\n2. Genre\n3. Year\n(Enter 0 if you want to return to the menu)");
            searchBy = Integer.parseInt(input.nextLine());
            if (searchBy == 1) {
                System.out.println("\nEnter the name of the movie you want to watch (Enter \"e\" if you want to return to the menu):");
                String name;
                while(true) {
                    name = input.nextLine();
                    if (name.equalsIgnoreCase("e")) {
                        return;
                    }
                    else if (actions.getCurrentUser().searchByTitleInMovies(name).size() == 0) {
                        System.out.println("\nThis movie doesn't exist in your watch history. Make sure you're typing in the full title of the movie or at least a part of it.\n(Enter \"e\" if you want to return to the menu):");
                    }
                    else {
                        break;
                    }
                }
                actions.printListOfMoviesInArraylist(actions.getCurrentUser().searchByTitleInMovies(name));
                if (actions.getCurrentUser().searchByTitleInMovies(name).size() > 1) {
                    do {
                        System.out.println("\nPlease be more specific with the title of the movie. Enter the full name (Or enter \"e\" if you want to go back to the menu):");
                        name = input.nextLine();
                        if (name.equalsIgnoreCase("e")) {
                            return;
                        }
                    } while (actions.getCurrentUser().searchByTitleInMovies(name).size() > 1 || !actions.doesMovieExistWithExactName(name));
                    actions.printListOfMoviesInArraylist(actions.getCurrentUser().searchByTitleInMovies(name));
                }
                System.out.println("\nIs this the movie you want to watch?\n1. Yes\n2. No");
                int watchOrNot = Integer.parseInt(input.nextLine());
                if (watchOrNot == 1) {
                    Movie currentMovie = actions.getCurrentUser().searchByTitleInMovies(name).get(0);
                    System.out.println("You have just watched \"" + currentMovie.getTitle() + "\".");
                }
            }
            else if (searchBy == 2) {
                System.out.println("\nEnter the name of the genre you're interested in (Enter \"e\" if you want to return to the menu):");
                String genre;
                Movie currentMovie;
                while(true) {
                    genre = input.nextLine();
                    if (genre.equalsIgnoreCase("e")) {
                        return;
                    }
                    else if (actions.getCurrentUser().searchByGenreInMovies(genre).size() == 0) {
                        System.out.println("\nThis genre doesn't exist in your watch history. Make sure you're typing in the full name of the genre or at least a part of it (Enter \"e\" if you want to return to the menu):");
                    }
                    else {
                        break;
                    }
                }
                actions.printListOfMoviesInArraylist(actions.getCurrentUser().searchByGenreInMovies(genre));
                if (actions.getCurrentUser().searchByGenreInMovies(genre).size() > 1) {
                    System.out.println("\nThere are multiple movies with this genre in your watch history. To be more specific, enter the full title of the show you want to watch among the ones above (Or enter \"e\" if you want to go back to the menu):");
                    String title = input.nextLine();
                    if (title.equalsIgnoreCase("e")) {
                        return;
                    }
                    while (actions.getCurrentUser().searchByTitleInMovies(title).size() > 1 || !actions.doesShowExistWithExactName(title)) {
                        System.out.println("\nPlease be more specific with the title of the movie. Enter the full name (Or enter \"e\" if you want to go back to the menu):");
                        title = input.nextLine();
                        if (title.equalsIgnoreCase("e")) {
                            return;
                        }
                    }
                    actions.printListOfMoviesInArraylist(actions.getCurrentUser().searchByTitleInMovies(title));
                    currentMovie = actions.getCurrentUser().searchByTitleInMovies(title).get(0);
                }
                else {
                    currentMovie = actions.getCurrentUser().searchByGenreInMovies(genre).get(0);
                }
                System.out.println("\nIs this the movie you want to watch?\n1. Yes\n2. No");
                int watchOrNot = Integer.parseInt(input.nextLine());
                if (watchOrNot == 1) {
                    System.out.println("You have just watched \"" + currentMovie.getTitle() + "\".");
                }
            }
            else if (searchBy == 3) {
                System.out.println("\nEnter the year you're interested in (Enter 0 if you want to return to the menu):");
                int year;
                Movie currentMovie;
                while(true) {
                    year = Integer.parseInt(input.nextLine());
                    if (year == 0) {
                        return;
                    }
                    else if (actions.getCurrentUser().searchByReleaseYearInMovies(year).size() == 0) {
                        System.out.println("\nThere are no movies from that year in your watch history. Try another year (Enter 0 if you want to return to the menu):");
                    }
                    else {
                        break;
                    }
                }
                actions.printListOfMoviesInArraylist(actions.getCurrentUser().searchByReleaseYearInMovies(year));
                if (actions.getCurrentUser().searchByReleaseYearInMovies(year).size() > 1) {
                    System.out.println("\nThere are multiple movies made in that year that are in your watch history. To be more specific, enter the full title of the movie you want to watch among the ones above (Or enter \"e\" if you want to go back to the menu):");
                    String title = input.nextLine();
                    if (title.equalsIgnoreCase("e")) {
                        return;
                    }
                    while (actions.getCurrentUser().searchByTitleInMovies(title).size() > 1 || !actions.doesMovieExistWithExactName(title)) {
                        System.out.println("\nPlease be more specific with the title of the movie. Enter the full name (Or enter \"e\" if you want to go back to the menu):");
                        title = input.nextLine();
                        if (title.equalsIgnoreCase("e")) {
                            return;
                        }
                    }
                    actions.printListOfMoviesInArraylist(actions.getCurrentUser().searchByTitleInMovies(title));
                    currentMovie = actions.getCurrentUser().searchByTitleInMovies(title).get(0);
                }
                else {
                    currentMovie = actions.getCurrentUser().searchByReleaseYearInMovies(year).get(0);
                }
                System.out.println("\nIs this the movie you want to watch?\n1. Yes\n2. No");
                int watchOrNot = Integer.parseInt(input.nextLine());
                if (watchOrNot == 1) {
                    System.out.println("You have just watched \"" + currentMovie.getTitle() + "\".\n");
                }
            }
        } while (searchBy != 0);
    }

    public static void listOfFavoriteMovies() {
        actions.printListOfMoviesInArraylist(actions.getCurrentUser().getFavoriteMovies());
    }

    public static void listOfWatchedMovies() {
        Scanner input = new Scanner(System.in);
        int searchOrNot;
        do {
            actions.printListOfMoviesInArraylist(actions.getCurrentUser().getPreviouslyWatchedMovies());
            System.out.println("\nWould you like to watch one of these movies?\n1. Yes. I would like to do a search.\n2. No. take me to the previous page");
            searchOrNot = Integer.parseInt(input.nextLine());
            if (searchOrNot == 1) {
                searchInWatchedMovies();
            }
        } while (searchOrNot == 1);
    }

    public static void viewProfile() {
        System.out.println("\nUser: " + actions.getCurrentUser().getUsername());
        System.out.print("Password: ");
        for (int i = 0; i < actions.getCurrentUser().getPassword().length(); i++) {
            System.out.print("*");
        }
        System.out.println("\n\nYour favorite shows:");
        actions.printListOfShowsInArraylist(actions.getCurrentUser().getFavoriteShows());
        System.out.println("\nYour favorite movies:");
        actions.printListOfMoviesInArraylist(actions.getCurrentUser().getFavoriteMovies());
        System.out.println("\n1. Go back to the menu\n2. Change your password\n3. Delete your account");
        Scanner input = new Scanner(System.in);
        int choice = Integer.parseInt(input.nextLine());
        if (choice == 2) {
            System.out.println("Please verify your password:");
            String passwordVerify = input.nextLine();
            while (!passwordVerify.equals(actions.getCurrentUser().getPassword())) {
                System.out.println("This password doesn't belong to your account. Try again (or enter \"e\" to return):");
                passwordVerify = input.nextLine();
                if (passwordVerify.equals("e")) {
                    return;
                }
            }
            System.out.println("What would you like your new password to be?");
            String newPassword = input.nextLine();
            actions.changePassword(actions.getCurrentUser().getUsername(), newPassword);
            System.out.println("Your password has been changed successfully.");
        }
        else if (choice == 3) {
            String isThatYou;
            do {
                System.out.println("Please enter your password to verify it's you deleting your account (Enter \"e\" to go back to the menu):");
                isThatYou = input.nextLine();
                if (isThatYou.equals(actions.getCurrentUser().getPassword())) {
                    System.out.println("All of your data and history will be removed and can't be restored after you delete your account. Are you sure about this?\n1. I've changed my mind\n2. I want to delete my account");
                    int deleteOrNot = Integer.parseInt(input.nextLine());
                    if (deleteOrNot == 2) {
                        deleteAccount = true;
                        return;
                    }
                }
                else {
                    System.out.println("Invalid password.");
                }
            } while (!isThatYou.equals("e"));
        }
    }

    //Manager menu
    public static void managerMenu() {
        Scanner input = new Scanner(System.in);
        int managerChoice;
        do {
            System.out.println("\nWelcome to your Netflix account as a content manager.\n1. Add content\n2. Remove content\n(Enter 0 to log out)");
            managerChoice = Integer.parseInt(input.nextLine());
            if (managerChoice == 1) {
                int adding;
                do {
                    System.out.println("\nWhat are you adding?\n1. TV show\n2. Movie\n(Enter 0 to return)");
                    adding = Integer.parseInt(input.nextLine());
                    if (adding == 1) {
                        addShow();
                    }
                    else if (adding == 2) {
                        addMovie();
                    }
                } while (adding != 0);
            }
            else if (managerChoice == 2) {
                int removing;
                do {
                    System.out.println("\nWhat are you removing?\n1. TV show\n2. Movie\n(Enter 0 to return)");
                    removing = Integer.parseInt(input.nextLine());
                    if (removing == 1) {
                        removeShow();
                    }
                    else if (removing == 2) {
                        removeMovie();
                    }
                } while (removing != 0);
            }
        } while (managerChoice != 0);
    }

    public static void addShow() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter the title of the show:");
        String title = input.nextLine();
        System.out.println("Enter the genre:");
        String genre = input.nextLine();
        System.out.println("Enter the year it was released:");
        int year = Integer.parseInt(input.nextLine());
        System.out.println("Enter the number of the seasons:");
        int numberOfSeasons = Integer.parseInt(input.nextLine());
        System.out.println("Enter the number of the episodes:");
        int numberOfEpisodes = Integer.parseInt(input.nextLine());
        System.out.println("Enter the rating on Rotten Tomatoes:");
        int ratingOutOfOneHundred = Integer.parseInt(input.nextLine());
        ArrayList<String> cast = new ArrayList<>();
        String castMember;
        do {
            System.out.println("Add cast (Enter \"e\" to return):");
            castMember = input.nextLine();
            cast.add(castMember);
        } while (!castMember.equalsIgnoreCase("e"));
        actions.addTVShow(title, genre, year, numberOfSeasons, numberOfEpisodes, ratingOutOfOneHundred, cast);
        System.out.println("\"" +  title + "\" was added to Netflix successfully.");
    }

    public static void addMovie() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter the title of the movie:");
        String title = input.nextLine();
        System.out.println("Enter the genre:");
        String genre = input.nextLine();
        System.out.println("Enter the year it was released:");
        int year = Integer.parseInt(input.nextLine());
        System.out.println("Enter the rating on Rotten Tomatoes:");
        int ratingOutOfOneHundred = Integer.parseInt(input.nextLine());
        System.out.println("Enter the length of the movie in minutes:");
        int lengthInMinutes = Integer.parseInt(input.nextLine());
        ArrayList<String> cast = new ArrayList<>();
        String castMember;
        do {
            System.out.println("Add cast (Enter \"e\" to return):");
            castMember = input.nextLine();
            if (!castMember.equalsIgnoreCase("e")) {
                cast.add(castMember);
            }
        } while (!castMember.equalsIgnoreCase("e"));
        actions.addMovie(title, genre, year, 1, 1, ratingOutOfOneHundred, cast, lengthInMinutes);
        System.out.println("\"" +  title + "\" was added to Netflix successfully.");
    }

    public static void removeShow() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the title of the show you want to remove:");
        String title = input.nextLine();
        while (!actions.doesShowExistWithExactName(title)) {
            System.out.println("This show doesn't exist. Make sure you're entering the full name (Enter \"e\" to return):");
            title = input.nextLine();
            if (title.equalsIgnoreCase("e")) {
                return;
            }
        }
        actions.printListOfShowsInArraylist(actions.searchByTitle(title));
        System.out.println("Are you sure you want to remove this show?\n1. Yes\n2. No");
        int removeOrNot = Integer.parseInt(input.nextLine());
        if (removeOrNot == 1) {
            actions.removeTVShow(title);
            System.out.println("\"" + title + "\" was removed successfully.");
        }
    }

    public static void removeMovie() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the title of the movie you want to remove:");
        String title = input.nextLine();
        while (!actions.doesMovieExistWithExactName(title)) {
            System.out.println("This movie doesn't exist. Make sure you're entering the full name (Enter \"e\" to return):");
            title = input.nextLine();
            if (title.equalsIgnoreCase("e")) {
                return;
            }
        }
        actions.printListOfMoviesInArraylist(actions.searchByTitleInMovies(title));
        System.out.println("Are you sure you want to remove this show?\n1. Yes\n2. No");
        int removeOrNot = Integer.parseInt(input.nextLine());
        if (removeOrNot == 1) {
            actions.removeMovie(title);
            System.out.println("\"" + title + "\" was removed successfully.");
        }
    }
}