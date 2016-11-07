package ua.abond.oop.city;

import java.util.List;
import java.util.Objects;

public class City {
    private final String name;
    private final Details details;

    public City(String name, Details details) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(details);

        this.name = name;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public Details getDetails() {
        return details;
    }

    public static class Details {
        private List<String> streets;
        private List<String> squares;
        private List<String> avenues;

        public List<String> getStreets() {
            return streets;
        }

        public void setStreets(List<String> streets) {
            this.streets = streets;
        }

        public List<String> getSquares() {
            return squares;
        }

        public void setSquares(List<String> squares) {
            this.squares = squares;
        }

        public List<String> getAvenues() {
            return avenues;
        }

        public void setAvenues(List<String> avenues) {
            this.avenues = avenues;
        }
    }
}
