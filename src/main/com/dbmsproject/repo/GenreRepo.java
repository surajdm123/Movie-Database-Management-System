package com.dbmsproject.repo;

import com.dbmsproject.view.Genre;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class GenreRepo {

    /***
     * @param connection
     * @return Map of Genre objects
     * @throws Exception
     */
    public Map<Integer, Genre> loadAllGenresFromDatabase(final Connection connection) throws Exception {
        final Map<Integer, Genre> genreMap = new HashMap();
        Statement statement = connection.createStatement();
        final String sqlQuery = "SELECT * FROM genre;";
        final ResultSet resultSet = statement.executeQuery(sqlQuery);
        while (resultSet.next()) {
            final String name = resultSet.getString("genre_name");
            final int genreId = resultSet.getInt("genre_id");
            final Timestamp created = resultSet.getTimestamp("created");
            final Timestamp updated = resultSet.getTimestamp("updated");
            final Genre genre = new Genre(genreId, name, created, updated);
            genreMap.put(genreId, genre);
        }

        return genreMap;
    }

}
