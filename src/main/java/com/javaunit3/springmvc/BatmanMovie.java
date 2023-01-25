package com.javaunit3.springmvc;

import org.springframework.stereotype.Component;

@Component
public class BatmanMovie implements Movie {

    private String title;
    private String maturityRating;
    private String genre;
    public BatmanMovie(){
        this.title = "Batman: The Dark Knight";
        this.maturityRating = "PG-13";
        this.genre = "Action";
    }

    public BatmanMovie(BatmanMovie batmanMovie){
        this.title = batmanMovie.title;
        this.maturityRating = batmanMovie.maturityRating;
        this.genre = batmanMovie.genre;
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
