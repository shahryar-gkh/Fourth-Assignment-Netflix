package org.example;

import java.util.ArrayList;

class NetflixService {
    private User currentUser = new User();
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<TVShow> tvShows = new ArrayList<>();
    private ArrayList<Movie> movies = new ArrayList<>();

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String username, String password) {
        currentUser.setUsername(username);
        currentUser.setPassword(password);
    }

    public void addTVShow(String title, String genre, int releaseYear, int numberOfSeasons, int numberOfEpisodes, int ratingOutOfOneHundred, ArrayList<String> cast){
        TVShow newShow = new TVShow(title, genre, releaseYear, numberOfSeasons, numberOfEpisodes, ratingOutOfOneHundred, cast);
        tvShows.add(newShow);
    }

    public void removeTVShow(String title) {
        for (TVShow show : tvShows) {
            if (show.getTitle().equals(title)) {
                tvShows.remove(show);
            }
        }
    }

    public void addMovie(String title, String genre, int releaseYear, int numberOfSeasons, int numberOfEpisodes, int ratingOutOfOneHundred, ArrayList<String> cast, int lengthInMinutes){
        Movie newMovie = new Movie(title, genre, releaseYear, numberOfSeasons, numberOfEpisodes, ratingOutOfOneHundred, cast, lengthInMinutes);
        movies.add(newMovie);
    }

    public void removeMovie(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equals(title)) {
                movies.remove(movie);
            }
        }
    }

    public void printListOfAllShows() {
        for (TVShow show : tvShows) {
            System.out.println("\n" + show);
            for (String castMember : show.getCast()) {
                System.out.print(castMember + ", ");
            }
            System.out.print("...\n");
        }
    }

    public void printListOfShowsInArraylist(ArrayList<TVShow> listOfShows) {
        for (TVShow show : listOfShows) {
            System.out.println("\n" + show);
            for (String castMember : show.getCast()) {
                System.out.print(castMember + ", ");
            }
            System.out.print("...\n");
        }
    }

    public void printListOfMoviesInArraylist(ArrayList<Movie> listOfMovies) {
        for (Movie movie : listOfMovies) {
            System.out.println("\n" + movie);
            for (String castMember : movie.getCast()) {
                System.out.print(castMember + ", ");
            }
            System.out.print("...\n");
        }
    }

    public void printListOfAllMovies() {
        for (Movie movie : movies) {
            System.out.println("\n" + movie);
            for (String castMember : movie.getCast()) {
                System.out.print(castMember + ", ");
            }
            System.out.print("...\n");
        }
    }

    public boolean doesShowExistWithExactName(String showTitle) {
        for (TVShow show : tvShows) {
            if (show.getTitle().equalsIgnoreCase(showTitle)) {
                return true;
            }
        }
        return false;
    }

    public boolean doesMovieExistWithExactName(String movieTitle) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(movieTitle)) {
                return true;
            }
        }
        return false;
    }

    public void createAccount(String username, String password) {
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        users.add(newUser);
    }

    public boolean usernameTaken(String username){
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                currentUser.setUsername(username);
                currentUser.setPassword(password);
                return true;
            }
        }
        return false;
    }

    public void changePassword(String username, String newPassword) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                user.setPassword(newPassword);
                currentUser = user;
            }
        }
    }

    public void logout() {
        currentUser = null;
    }

    public void deleteAccount(String username) {
        for (User user : users) {
            if (username.equals(user.getUsername())) {
                users.remove(user);
            }
        }
    }

    public ArrayList<TVShow> searchByTitle(String title) {
        ArrayList<TVShow> searchResult = new ArrayList<>();
        for (TVShow show : tvShows) {
            if (show.getTitle().toLowerCase().contains(title.toLowerCase())) {
                searchResult.add(show);
            }
        }
        return searchResult;
    }

    public ArrayList<TVShow> searchByGenre(String genre) {
        ArrayList<TVShow> searchResult = new ArrayList<>();
        for (TVShow show : tvShows) {
            if (show.getGenre().toLowerCase().contains(genre.toLowerCase())) {
                searchResult.add(show);
            }
        }
        return searchResult;
    }

    public ArrayList<TVShow> searchByReleaseYear(int year) {
        ArrayList<TVShow> searchResult = new ArrayList<>();
        for (TVShow show : tvShows) {
            if (show.getReleaseYear() == year) {
                searchResult.add(show);
            }
        }
        return searchResult;
    }

    public ArrayList<Movie> searchByTitleInMovies(String title) {
        ArrayList<Movie> searchResult = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase().contains(title.toLowerCase())) {
                searchResult.add(movie);
            }
        }
        return searchResult;
    }

    public ArrayList<Movie> searchByGenreInMovies(String genre) {
        ArrayList<Movie> searchResult = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getGenre().toLowerCase().contains(genre.toLowerCase())) {
                searchResult.add(movie);
            }
        }
        return searchResult;
    }

    public ArrayList<Movie> searchByReleaseYearInMovies(int year) {
        ArrayList<Movie> searchResult = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getReleaseYear() == year) {
                searchResult.add(movie);
            }
        }
        return searchResult;
    }
}