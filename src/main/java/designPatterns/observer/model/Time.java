package designPatterns.observer.model;

import java.time.Year;

public class Time extends Magazine{

    public Time(Year year, int edition) {
        super("Time", year, edition);
    }
}
