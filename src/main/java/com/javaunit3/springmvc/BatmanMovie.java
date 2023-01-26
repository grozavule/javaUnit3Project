package com.javaunit3.springmvc;

import org.springframework.stereotype.Component;

@Component
public class BatmanMovie extends RatedMovie {
    public BatmanMovie(){
        super("Batman: The Dark Knight", "PG-13", "Action");
    }

    public BatmanMovie(BatmanMovie batmanMovie){
        super(batmanMovie.title, batmanMovie.maturityRating, batmanMovie.genre);
    }
}
