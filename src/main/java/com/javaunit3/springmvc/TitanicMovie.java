package com.javaunit3.springmvc;

import org.springframework.stereotype.Component;

@Component
public class TitanicMovie extends RatedMovie {
    public TitanicMovie(){
        super("Titanic", "PG-13", "Historical Fiction");
    }
}
