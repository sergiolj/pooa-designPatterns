package designPatterns.observer.model;

import java.time.Year;

public abstract class Magazine {
   String name;
   Year year;
   int edition;

    public Magazine(String name, Year year, int edition) {
        this.name = name;
        this.year = year;
        this.edition = edition;
    }

    public String getName() {
        return name;
    }

    public Year getYear() {
        return year;
    }

    public int getEdition() {
        return edition;
    }

    public boolean isValid() {
        return !this.name.isBlank() && this.year.isAfter(Year.of(2025))  && this.edition > 1;
    }

    @Override
    public String toString() {
        return "Magazine " + name + ", year " + year + ", " + edition + " ed.";
    }
}
