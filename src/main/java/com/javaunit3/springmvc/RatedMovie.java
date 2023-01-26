package com.javaunit3.springmvc;

public abstract class RatedMovie implements Movie {
    protected String title;
    protected String maturityRating;
    protected String genre;
    public RatedMovie(String title, String maturityRating, String genre){
        this.title = title;
        this.genre = genre;
        switch(maturityRating.toUpperCase()){
            case "G":
            case "PG":
            case "PG-13":
            case "R":
            case "NC-17":
                this.maturityRating = maturityRating.toUpperCase();
                break;
        }
    }
    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getMaturityRating() {
        return this.maturityRating;
    }

    @Override
    public String getGenre() {
        return this.genre;
    }
}
