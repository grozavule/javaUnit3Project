package com.javaunit3.springmvc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMvcApplication {
    public static void main(String[] args){
        SpringApplication.run(SpringMvcApplication.class, args);

//        SessionFactory factory = new Configuration()
//                .configure("resources/hibernate.cfg.xml")
//                .addAnnotatedClass(RatedMovie.class)
//                .buildSessionFactory();
//
//        Session session = factory.getCurrentSession();
//
//        try {
//            RatedMovie movie = new BatmanMovie();
//            MovieEntity movieEntity = new MovieEntity(movie);
//            session.beginTransaction();
//            session.save(movieEntity);
//            session.getTransaction().commit();
//
//            System.out.println("Movie, " + movie.getTitle() + ", saved to database");
//        } finally {
//            factory.close();
//        }
    }
}
