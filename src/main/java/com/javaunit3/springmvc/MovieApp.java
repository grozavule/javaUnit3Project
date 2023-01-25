package com.javaunit3.springmvc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MovieApp {
    public static void main(String[] args){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        BestMovieService bestMovieService = context.getBean("bestMovieService", BestMovieService.class);
        Movie bestMovie = bestMovieService.getBestMovie();

        System.out.println("Best Movie: " + bestMovie.getTitle());
        System.out.println("Best Movie Rating: " + bestMovie.getMaturityRating());
        System.out.println("Best Movie Genre: " + bestMovie.getGenre());
    }
}
