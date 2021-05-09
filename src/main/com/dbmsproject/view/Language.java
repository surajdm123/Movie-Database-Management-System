package com.dbmsproject.view;

import java.sql.Timestamp;

public class Language {

    private int languageId;

    private String languageName;

    private Timestamp created;

    private Timestamp updated;

    public Language(int languageId, String languageName, Timestamp created, Timestamp updated) {
        this.languageId = languageId;
        this.languageName = languageName;
        this.created = created;
        this.updated = updated;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
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
        return languageName;
    }
}
