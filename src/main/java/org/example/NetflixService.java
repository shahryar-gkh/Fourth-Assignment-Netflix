package org.example;

import java.util.ArrayList;

class NetflixService {
    User currentUser = new User();
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<TVShow> tvShows = new ArrayList<>();
    private ArrayList<Movie> movies = new ArrayList<>();

    public void addToTVShowCast(String title, ArrayList<String> castMembers) {
        for (TVShow show : tvShows) {
            if (show.getTitle().equals(title)) {
                show.setCast(castMembers);
            }
        }
    }

    public void addToMovieCast(String title, ArrayList<String> castMembers) {
        for (Movie movie : movies) {
            if (movie.getTitle().equals(title)) {
                movie.setCast(castMembers);
            }
        }
    }
    public void addTVShow(String title, String genre, int releaseYear, int numberOfSeasons, int numberOfEpisodes, int ratingOutOfOneHundred){
        TVShow newShow = new TVShow(title, genre, releaseYear, numberOfSeasons, numberOfEpisodes, ratingOutOfOneHundred);
        tvShows.add(newShow);
    }

    public void addMovie(String title, String genre, int releaseYear, int numberOfSeasons, int numberOfEpisodes, int ratingOutOfOneHundred, int lengthInMinutes){
        Movie newMovie = new Movie(title, genre, releaseYear, numberOfSeasons, numberOfEpisodes, ratingOutOfOneHundred, lengthInMinutes);
        movies.add(newMovie);
    }

    public void giveListOfShows() {
        for (TVShow show : tvShows) {
            System.out.println("\n" + show);
            for (String castMember : show.getCast()) {
                System.out.print(castMember + ", ");
            }
            System.out.print("...\n");
        }
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

    public void logout() {

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
}