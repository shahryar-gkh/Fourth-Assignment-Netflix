package org.example;

import java.util.ArrayList;

class TVShow {
    private String title;
    private String genre;
    private int releaseYear;
    private int numberOfSeasons;
    private int numberOfEpisodes;
    private int ratingOutOfOneHundred;
    private ArrayList<String> cast = new ArrayList<>();

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
        this.title = title;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
    public void setNumberOfSeasons(int numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }
    public void setNumberOfEpisodes(int numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }
    public void setRatingOutOfOneHundred(int ratingOutOfOneHundred) {
        this.ratingOutOfOneHundred = ratingOutOfOneHundred;
    }
    public void setCast(ArrayList<String> cast) {
        this.cast = cast;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
