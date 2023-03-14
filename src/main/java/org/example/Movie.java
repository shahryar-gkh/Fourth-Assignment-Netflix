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
    @Override
    public String toString() {
        return super.toString();
    }

    public Movie()
    {
        super();
    }
}
