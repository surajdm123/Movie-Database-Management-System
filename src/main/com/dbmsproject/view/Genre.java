package com.dbmsproject.view;

import java.sql.Timestamp;

public class Genre {

    private int genreId;

    private String genreName;

    private Timestamp created;

    private Timestamp updated;

    public Genre(int genreId, String genreName, Timestamp created, Timestamp updated) {
        this.genreId = genreId;
        this.genreName = genreName;
        this.created = created;
        this.updated = updated;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
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

    @Override
    public String toString() {
        return genreName;
    }
}
