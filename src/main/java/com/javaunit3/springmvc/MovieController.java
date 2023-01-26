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

    @RequestMapping("/best-movie")
    public String getBestMovie(Model model){
        System.out.println(this.bestMovieService.getBestMovie().getTitle());
        model.addAttribute("bestMovie", this.bestMovieService.getBestMovie().getTitle());
        return "best-movie";
    }

    @RequestMapping("/vote-for-best-movie-form")
    public String voteForBestMovieForm(Model model){
        Session session = sessionFactory.getCurrentSession();

        //try {
            session.beginTransaction();
            Query query = session.createQuery("from MovieEntity");
            List<MovieEntity> movieList = query.list();
            //List<MovieEntity> movieEntityList = session.createQuery("from MovieEntity").list();
            model.addAttribute("movieList", movieList);
            session.getTransaction().commit();
            return "vote-for-best-movie";
        //} finally {
        //    session.close();
        //}
    }

    @RequestMapping("/vote-for-best-movie")
    public String voteForBestMovie(@RequestParam("movie-vote") String movieVote, Model model){
        System.out.println(movieVote);
        model.addAttribute("movieVote", movieVote);
        return "vote-for-best-movie";
    }

    @RequestMapping("/add-movie-form")
    public String addMovieForm(){
        return "add-movie";
    }
}
