package com.javaunit3.springmvc;

import javax.persistence.*;

@Entity
@Table(name="movies")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="movie_id")
    private Integer id;
    @Column(name="title")
    private String title;
    @Column(name="maturity_rating")
    private String maturityRating;
    @Column(name="genre")
    private String genre;

//    public MovieEntity(RatedMovie movie){
//        this.title = movie.getTitle();
//        this.maturityRating = movie.getMaturityRating();
//        this.genre = movie.getGenre();
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMaturityRating() {
        return maturityRating;
    }

    public void setMaturityRating(String maturityRating) {
        this.maturityRating = maturityRating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
