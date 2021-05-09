package com.dbmsproject.view;

import java.sql.Timestamp;

public class Movie {

    private int movieId;

    private String name;

    private Timestamp created;

    private Timestamp updated;

    private int genreId;

    private int countryId;

    private int languageId;

    public Movie(int movieId, String name, Timestamp created, Timestamp updated, int genreId, int countryId, int languageId) {
        this.movieId = movieId;
        this.name = name;
        this.created = created;
        this.updated = updated;
        this.genreId = genreId;
        this.countryId = countryId;
        this.languageId = languageId;
    }

    public Movie(String name, int genreId, int countryId, int languageId) {
        this.name = name;
        this.genreId = genreId;
        this.countryId = countryId;
        this.languageId = languageId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }
}
