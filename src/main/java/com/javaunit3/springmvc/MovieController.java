package com.javaunit3.springmvc;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@Controller
public class MovieController {
    @Autowired
    private BestMovieService bestMovieService;
    @Autowired
    private SessionFactory sessionFactory;
    @RequestMapping("/")
    public String getIndexPage(){
        return "index";
    }

    @RequestMapping("/add-movie-form")
    public String addMovieForm(){
        return "add-movie";
    }

    @RequestMapping("/add-movie")
    public String addMovie(@RequestParam("title") String movieTitle,
                           @RequestParam("maturity-rating") String maturityRating,
                           @RequestParam("genre") String genre,
                           Model model){
        //save the new movie
        Session addSession = sessionFactory.getCurrentSession();
        addSession.beginTransaction();
        MovieEntity movie = new MovieEntity(movieTitle, maturityRating, genre);
        addSession.save(movie);
        addSession.getTransaction().commit();

        //get all the movies
        Session retrieveSession = sessionFactory.getCurrentSession();
        retrieveSession.beginTransaction();
        List<MovieEntity> movieEntityList = retrieveSession.createQuery("from MovieEntity").list();
        model.addAttribute("movieList", movieEntityList);
        retrieveSession.getTransaction().commit();

        return "movie-list";
    }
    @RequestMapping("/best-movie")
    public String getBestMovie(Model model){
//        System.out.println(this.bestMovieService.getBestMovie().getTitle());
//        model.addAttribute("bestMovie", this.bestMovieService.getBestMovie().getTitle());

        //List<MovieEntity> movieList = this.getAllMovies();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<MovieEntity> movieEntityList = session.createQuery("from MovieEntity").list();

        movieEntityList.sort(Comparator.comparingInt(movieEntity -> movieEntity.getAllVotes().size()));
        MovieEntity mostPopularMovie = movieEntityList.get(movieEntityList.size() - 1);
        List<String> voterNames = new ArrayList<>();

        for(VoteEntity vote: mostPopularMovie.getAllVotes()){
            voterNames.add(vote.getVoterName());
        }
        String voterNamesList = String.join(",", voterNames);

        model.addAttribute("mostPopularMovie", mostPopularMovie.getTitle());
        model.addAttribute("movieVoters", voterNamesList);
        session.getTransaction().commit();

        return "best-movie";
    }

    @RequestMapping("/vote-for-best-movie-form")
    public String voteForBestMovieForm(Model model){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<MovieEntity> movieEntityList = session.createQuery("from MovieEntity").list();
        model.addAttribute("movieList", movieEntityList);

        session.getTransaction().commit();

        return "vote-for-best-movie";
    }

    @RequestMapping("/movie-list")
    public String showMovieList(Model model){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        List<MovieEntity> movieEntityList = session.createQuery("from MovieEntity").list();
        model.addAttribute("movieList", movieEntityList);

        session.getTransaction().commit();
        return "movie-list";
    }

    /*@RequestMapping("/vote-for-best-movie")
    public String voteForBestMovie(@RequestParam("movie-vote") String movieVote, Model model){
        System.out.println(movieVote);
        model.addAttribute("movieVote", movieVote);
        return "vote-for-best-movie";
    }*/
    @RequestMapping("/vote-for-best-movie")
    public String voteForBestMovie(HttpServletRequest request, Model model){
        String movieId = request.getParameter("movie-vote");
        String voterName = request.getParameter("voter-name");

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        MovieEntity movie = (MovieEntity) session.get(MovieEntity.class, Integer.parseInt(movieId));
        VoteEntity vote = new VoteEntity();
        vote.setVoterName(voterName);
        movie.addVote(vote);
        session.update(movie);
        session.getTransaction().commit();

        return "vote-for-best-movie";
    }

    private List<MovieEntity> getAllMovies(){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<MovieEntity> movieEntityList = session.createQuery("from MovieEntity").list();
        session.getTransaction().commit();

        return movieEntityList;
    }
}
