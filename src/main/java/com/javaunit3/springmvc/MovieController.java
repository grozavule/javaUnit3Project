package com.javaunit3.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MovieController {
    @Autowired
    private BestMovieService bestMovieService;
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
    public String voteForBestMovieForm(){
        return "vote-for-best-movie";
    }

    @RequestMapping("/vote-for-best-movie")
    public String voteForBestMovie(HttpServletRequest request, Model model){
        String movieVote = request.getParameter("movie-vote");
        System.out.println(movieVote);
        model.addAttribute("movieVote", movieVote);
        return "vote-for-best-movie";
    }

    @RequestMapping("/add-movie-form")
    public String addMovieForm(){
        return "add-movie";
    }
}
