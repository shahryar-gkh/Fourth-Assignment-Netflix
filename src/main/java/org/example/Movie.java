package org.example;

import java.util.ArrayList;

class Movie extends TVShow {

    private static int lengthInMinutes;

    public static int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public void setLengthInMinutes(int lengthInMinutes) {
        Movie.lengthInMinutes = lengthInMinutes;
    }

    public Movie (String title, String genre, int releaseYear, int numberOfSeasons, int numberOfEpisodes, int ratingOutOfOneHundred, int lengthInMinutes) {
        super(title, genre, releaseYear, numberOfSeasons, numberOfEpisodes, ratingOutOfOneHundred);
        setLengthInMinutes(lengthInMinutes);
    }

    @Override
    public String toString() {
        return title + "\n" + releaseYear + "   " + genre + "\n" + lengthInMinutes + " minutes" + ratingOutOfOneHundred + "% on Rotten Tomatoes\n\n";
    }
}
