package ua.abond.oop.planet;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Planet extends GeographicalObject {
    private List<Ocean> oceans;
    private List<Island> islands;
    private List<Continent> continents;

    private Planet(String name, List<Ocean> oceans, List<Island> islands, List<Continent> continents) {
        super(name);
        Objects.requireNonNull(oceans);
        Objects.requireNonNull(islands);
        Objects.requireNonNull(continents);
        this.oceans = oceans;
        this.islands = islands;
        this.continents = continents;
    }

    public void printContinentCount() {
        System.out.print("Continent count: " + continents.size());
    }

    public List<Ocean> getOceans() {
        return Collections.unmodifiableList(oceans);
    }

    public List<Island> getIslands() {
        return Collections.unmodifiableList(islands);
    }

    public List<Continent> getContinents() {
        return Collections.unmodifiableList(continents);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String name;
        private List<Ocean> oceans;
        private List<Island> islands;
        private List<Continent> continents;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setOceans(List<Ocean> oceans) {
            this.oceans = oceans;
            return this;
        }

        public Builder setIslands(List<Island> islands) {
            this.islands = islands;
            return this;
        }

        public Builder setContinents(List<Continent> continents) {
            this.continents = continents;
            return this;
        }

        public Planet build() {
            return new Planet(name, oceans, islands, continents);
        }
    }
}
