package org.example;

import java.util.ArrayList;

class NetflixService {
    User currentUser = new User();
    ArrayList<User> users = new ArrayList<>();
    ArrayList<TVShow> tvShows = new ArrayList<>();
    ArrayList<Movie> movies = new ArrayList<>();

    public void setCast(String title, ArrayList<String> cast) {
        for (TVShow show : tvShows) {
            if (show.getTitle().equals(title)) {
                show.setCast(cast);
            }
        }
    }

    public void addTVShow(String title, String genre, int releaseYear, int numberOfSeasons, int numberOfEpisodes, int ratingOutOfOneHundred){
        TVShow newShow = new TVShow(title, genre, releaseYear, numberOfSeasons, numberOfEpisodes, ratingOutOfOneHundred);
        tvShows.add(newShow);
    }

    public void addMovie(String title, String genre, int releaseYear, int numberOfSeasons, int numberOfEpisodes, int ratingOutOfOneHundred, ArrayList<String> cast, int lengthInMinutes){
        Movie newMovie = new Movie(title, genre, releaseYear, numberOfSeasons, numberOfEpisodes, ratingOutOfOneHundred, lengthInMinutes);
        movies.add(newMovie);
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

