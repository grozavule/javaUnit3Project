package com.javaunit3.springmvc;

import org.springframework.stereotype.Component;

@Component
public class TitanicMovie implements Movie {
    private String title;
    private String maturityRating;
    private String genre;

    public TitanicMovie(){
        this.title = "Titanic";
        this.maturityRating = "PG-13";
        this.genre = "Craptastic Chick Flick";
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
