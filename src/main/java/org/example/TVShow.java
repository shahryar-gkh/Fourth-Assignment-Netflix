package org.example;

import java.util.ArrayList;

class TVShow {
    protected String title;
    protected String genre;
    protected int releaseYear;
    protected int numberOfSeasons;
    protected int numberOfEpisodes;
    protected int ratingOutOfOneHundred;
    protected ArrayList<String> cast;

    public TVShow () {

    }

    public TVShow (String title, String genre, int releaseYear, int numberOfSeasons, int numberOfEpisodes, int ratingOutOfOneHundred, ArrayList<String> cast) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.numberOfSeasons = numberOfSeasons;
        this.numberOfEpisodes = numberOfEpisodes;
        this.ratingOutOfOneHundred = ratingOutOfOneHundred;
        this.cast = cast;
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
    public void setCast(ArrayList<String> castMembers) {
        this.cast = castMembers;
    }

    @Override
    public String toString() {
        if (numberOfSeasons == 1) {
            return "\n" + title + "\n" + releaseYear + "   " + genre + "\n" + "1 season    " + numberOfEpisodes + " episodes\n" + ratingOutOfOneHundred + "% on Rotten Tomatoes";
        }
        return "\n" + title + "\n" + releaseYear + "   " + genre + "\n" + numberOfSeasons + " seasons   " + numberOfEpisodes + " episodes\n" + ratingOutOfOneHundred + "% on Rotten Tomatoes";
    }
}
