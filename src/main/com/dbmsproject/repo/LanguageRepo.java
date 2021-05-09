package com.dbmsproject.repo;

import com.dbmsproject.view.Language;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class LanguageRepo {

    /***
     * @param connection
     * @return Map of Language objects
     * @throws Exception
     */
    public Map<Integer, Language> loadAllLanguagesFromDatabase(final Connection connection) throws SQLException {
        final Map<Integer, Language> languageMap = new HashMap();
        Statement statement = connection.createStatement();
        final String sqlQuery = "SELECT * FROM language;";
        final ResultSet resultSet = statement.executeQuery(sqlQuery);
        while (resultSet.next()) {
            final String name = resultSet.getString("language_name");
            final int languageId = resultSet.getInt("language_id");
            final Timestamp created = resultSet.getTimestamp("created");
            final Timestamp updated = resultSet.getTimestamp("updated");
            final Language language = new Language(languageId, name, created, updated);
            languageMap.put(languageId, language);
        }

        return languageMap;
    }

}
