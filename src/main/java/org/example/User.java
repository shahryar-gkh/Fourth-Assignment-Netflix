package org.example;

import java.util.ArrayList;

class User {

    /*
     * The user should contain an ArrayList of favorite shows and watch history.
     * FUNCTION: the user should have a function to watch a show and add it to watch history.
     *  *** NOTE: All search functions in user are for searching in favorite shows ***
     */

    private String username;
    private String password;

    private ArrayList<TVShow> previouslyWatchedShows = new ArrayList<>();
    private ArrayList<Movie> previouslyWatchedMovies = new ArrayList<>();
    private ArrayList<TVShow> favoriteShows = new ArrayList<>();

    public ArrayList<TVShow> searchByTitle(String title) {
        ArrayList<TVShow> searchResult = new ArrayList<>();
        for (TVShow show : previouslyWatchedShows) {
            if (show.getTitle().toLowerCase().contains(title.toLowerCase())) {
                searchResult.add(show);
            }
        }
        return searchResult;
    }
    public ArrayList<TVShow> searchByGenre(String genre) {
        ArrayList<TVShow> searchResult = new ArrayList<>();
        for (TVShow show : previouslyWatchedShows) {
            if (show.getGenre().toLowerCase().contains(genre.toLowerCase())) {
                searchResult.add(show);
            }
        }
        return searchResult;
    }
    public ArrayList<TVShow> searchByReleaseYear(int year) {
        ArrayList<TVShow> searchResult = new ArrayList<>();
        for (TVShow show : previouslyWatchedShows) {
            if (show.getReleaseYear() == year) {
                searchResult.add(show);
            }
        }
        return searchResult;
    }
    public void watchMovie(Movie movie) {
        previouslyWatchedMovies.add(movie);
    }
    public void watchShow(TVShow show) {
        previouslyWatchedShows.add(show);
    }
    public void addToFavorites(TVShow show) {
        favoriteShows.add(show);
    }
    public void viewFavorites() {
        System.out.println(favoriteShows);
    }

    /* public ArrayList<TVShow> getRecommendations() {
        // Implement get recommendations logic here
        return null;
    } */

    //Getters
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    //Setters
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String toString(){
        return "User {" +
                "Username = '" + username + '\'' +
                ", Password = '" + password + '\'' +
                '}';
    }
}
