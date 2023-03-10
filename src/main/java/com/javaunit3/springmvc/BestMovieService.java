package com.javaunit3.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BestMovieService {
    //@Autowired
    private RatedMovie movie;

    public BestMovieService(){

    }
    @Autowired
    public BestMovieService(@Qualifier("titanicMovie") RatedMovie movie){
        this.movie = movie;
    }

    public Movie getBestMovie(){
        return this.movie;
    }

//    @Autowired
//    public void setBestMovie(Movie movie){
//        this.movie = movie;
//    }
}
