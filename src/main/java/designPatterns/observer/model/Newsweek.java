package designPatterns.observer.model;

import java.time.Year;

public class Newsweek extends Magazine{

    public Newsweek(Year year, int edition) {
        super("Newsweek", year, edition);
    }
}
