package org.example;

import java.util.ArrayList;

class NetflixService {
    User currentUser = new User();
    ArrayList<User> users = new ArrayList<>();
    ArrayList<TVShow> tvShows = new ArrayList<>();
    ArrayList<Movie> movies = new ArrayList<>();

    public void addTVShow(TVShow tvShow){
        tvShows.add(tvShow);
    }

    public void addMovie(Movie movie){
        movies.add(movie);
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

