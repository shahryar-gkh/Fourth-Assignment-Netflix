package org.example;

import java.util.ArrayList;

class Movie extends TVShow {

    private int lengthInMinutes;

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public void setLengthInMinutes(int lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    public Movie (String title, String genre, int releaseYear, int numberOfSeasons, int numberOfEpisodes, int ratingOutOfOneHundred, ArrayList<String> cast, int lengthInMinutes) {
        super(title, genre, releaseYear, numberOfSeasons, numberOfEpisodes, ratingOutOfOneHundred, cast);
        setLengthInMinutes(lengthInMinutes);
    }

    @Override
    public String toString() {
        return "\n" + title + "\n" + releaseYear + "   " + genre + "\n" + lengthInMinutes + " minutes\n" + ratingOutOfOneHundred + "% on Rotten Tomatoes";
    }
}
