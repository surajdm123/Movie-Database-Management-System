package com.dbmsproject.repo;

import com.dbmsproject.view.Movie;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class MovieRepo {

    /***
     * @param connection
     * @return Map of Movie objects
     * @throws Exception
     */
    public Map<Integer, Movie> loadAllMoviesFromDatabase(final Connection connection) throws SQLException {
        final Map<Integer, Movie> movieMap = new HashMap();
        Statement statement = connection.createStatement();
        final String sqlQuery = "SELECT * FROM movie;";
        final ResultSet resultSet = statement.executeQuery(sqlQuery);
        while (resultSet.next()) {
            final int movieId = resultSet.getInt("movie_id");
            final String name = resultSet.getString("title");
            final int genreId = resultSet.getInt("genre_id");
            final int countryId = resultSet.getInt("country_id");
            final int languageId = resultSet.getInt("language_id");
            final Timestamp created = resultSet.getTimestamp("created");
            final Timestamp updated = resultSet.getTimestamp("updated");
            final Movie movie = new Movie(movieId, name, created, updated, genreId, countryId, languageId);
            movieMap.put(movieId, movie);
        }

        return movieMap;
    }

    public void addMovieToDatabase(final Connection connection, final Movie movie) throws SQLException {
        String sqlQuery = " INSERT INTO movie (title, genre_id, country_id, language_id)"
                + " values (?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(sqlQuery);
        statement.setString(1, movie.getName());
        statement.setInt(2, movie.getGenreId());
        statement.setInt(3, movie.getCountryId());
        statement.setInt(4, movie.getLanguageId());

        statement.execute();
    }

    public void deleteMovieFromDatabase(final Connection connection, final int movieId) throws SQLException {
        String sqlQuery = "DELETE FROM movie WHERE movie_id = ?";

        PreparedStatement statement = connection.prepareStatement(sqlQuery);
        statement.setInt(1, movieId);

        statement.execute();
    }

}
