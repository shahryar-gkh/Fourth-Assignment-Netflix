package org.example;

import java.util.ArrayList;

class User {
    private String username;
    private String password;

    private ArrayList<TVShow> previouslyWatchedShows = new ArrayList<>();
    private ArrayList<Movie> previouslyWatchedMovies = new ArrayList<>();
    private ArrayList<TVShow> favoriteShows = new ArrayList<>();
    private ArrayList<Movie> favoriteMovies = new ArrayList<>();

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

    public ArrayList<Movie> searchByTitleInMovies(String title) {
        ArrayList<Movie> searchResult = new ArrayList<>();
        for (Movie movie : previouslyWatchedMovies) {
            if (movie.getTitle().toLowerCase().contains(title.toLowerCase())) {
                searchResult.add(movie);
            }
        }
        return searchResult;
    }
    public ArrayList<Movie> searchByGenreInMovies(String genre) {
        ArrayList<Movie> searchResult = new ArrayList<>();
        for (Movie movie : previouslyWatchedMovies) {
            if (movie.getGenre().toLowerCase().contains(genre.toLowerCase())) {
                searchResult.add(movie);
            }
        }
        return searchResult;
    }
    public ArrayList<Movie> searchByReleaseYearInMovies(int year) {
        ArrayList<Movie> searchResult = new ArrayList<>();
        for (Movie movie : previouslyWatchedMovies) {
            if (movie.getReleaseYear() == year) {
                searchResult.add(movie);
            }
        }
        return searchResult;
    }

    public void watchShow(TVShow show) {
        previouslyWatchedShows.add(show);
    }
    public void addToFavoriteShows(TVShow show) {
        favoriteShows.add(show);
    }
    public ArrayList<TVShow> getFavoriteShows() {
        return favoriteShows;
    }

    public void watchMovie(Movie movie) {
        previouslyWatchedMovies.add(movie);
    }
    public void addToFavoriteMovies(Movie movie) {
        favoriteMovies.add(movie);
    }
    public ArrayList<Movie> getFavoriteMovies() {
        return favoriteMovies;
    }

    //Getters
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public ArrayList<TVShow> getPreviouslyWatchedShows() {
        return previouslyWatchedShows;
    }

    public ArrayList<Movie> getPreviouslyWatchedMovies() {
        return previouslyWatchedMovies;
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
