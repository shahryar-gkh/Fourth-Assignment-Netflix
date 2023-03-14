package org.example;

import java.util.ArrayList;

class TVShow {
    protected static String title;
    protected static String genre;
    protected static int releaseYear;
    protected static int numberOfSeasons;
    protected static int numberOfEpisodes;
    protected static int ratingOutOfOneHundred;
    protected static ArrayList<String> cast;

    public TVShow (String title, String genre, int releaseYear, int numberOfSeasons, int numberOfEpisodes, int ratingOutOfOneHundred) {
        TVShow.title = title;
        TVShow.genre = genre;
        TVShow.releaseYear = releaseYear;
        TVShow.numberOfSeasons = numberOfSeasons;
        TVShow.numberOfEpisodes = numberOfEpisodes;
        TVShow.ratingOutOfOneHundred = ratingOutOfOneHundred;
    }
    //Getters
    public String getTitle() {
        return title;
    }
    public String getGenre() {
        return genre;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }
    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }
    public int getRatingOutOfOneHundred() {
        return ratingOutOfOneHundred;
    }
    public ArrayList<String> getCast() {
        return cast;
    }

    //Setters
    public void setTitle(String title) {
        TVShow.title = title;
    }
    public void setGenre(String genre) {
        TVShow.genre = genre;
    }
    public void setReleaseYear(int releaseYear) {
        TVShow.releaseYear = releaseYear;
    }
    public void setNumberOfSeasons(int numberOfSeasons) {
        TVShow.numberOfSeasons = numberOfSeasons;
    }
    public void setNumberOfEpisodes(int numberOfEpisodes) {
        TVShow.numberOfEpisodes = numberOfEpisodes;
    }
    public void setRatingOutOfOneHundred(int ratingOutOfOneHundred) {
        TVShow.ratingOutOfOneHundred = ratingOutOfOneHundred;
    }
    public void setCast(ArrayList<String> cast) {
        TVShow.cast = cast;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
