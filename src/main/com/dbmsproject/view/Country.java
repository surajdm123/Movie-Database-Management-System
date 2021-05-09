package com.dbmsproject.view;

import java.sql.Timestamp;

public class Country {

    private int countryId;

    private String countryName;

    private Timestamp created;

    private Timestamp updated;

    public Country(int countryId, String countryName, Timestamp created, Timestamp updated) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.created = created;
        this.updated = updated;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
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
        return countryName;
    }
}
