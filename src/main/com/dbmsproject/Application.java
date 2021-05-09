package com.dbmsproject;

import com.dbmsproject.repo.CountryRepo;
import com.dbmsproject.repo.GenreRepo;
import com.dbmsproject.repo.LanguageRepo;
import com.dbmsproject.repo.MovieRepo;
import com.dbmsproject.service.MySqlHelperService;
import com.dbmsproject.service.impl.MySqlHelperServiceImpl;
import com.dbmsproject.view.Country;
import com.dbmsproject.view.Genre;
import com.dbmsproject.view.Language;
import com.dbmsproject.view.Movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Application {

    private static final int MAX_INPUT_ATTEMPTS = 4;

    static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static final MySqlHelperService mySqlHelperService = new MySqlHelperServiceImpl();
    private static final MovieRepo movieRepo = new MovieRepo();
    private static final GenreRepo genreRepo = new GenreRepo();
    private static final CountryRepo countryRepo = new CountryRepo();
    private static final LanguageRepo languageRepo = new LanguageRepo();


    static Map<Integer, Movie> movieMap = new HashMap();
    static Map<Integer, Genre> genreMap = new HashMap();
    static Map<Integer, Country> countryMap = new HashMap();
    static Map<Integer, Language> languageMap = new HashMap();


    public static void main(String args[]) {

        System.out.println("---- TV Show Database Management System ----");

        try (final Connection connection = mySqlHelperService.getConnection()) {

            movieMap = movieRepo.loadAllMoviesFromDatabase(connection);
            genreMap = genreRepo.loadAllGenresFromDatabase(connection);
            countryMap = countryRepo.loadAllCountriesFromDatabase(connection);
            languageMap = languageRepo.loadAllLanguagesFromDatabase(connection);

            while (true) {
                displayHome(connection);
            }

        } catch (SQLException e) {
            System.out.println("Error while executing SQL statement.\n" + e);
        } catch (IOException e) {
            System.out.println("Couldn't load resources to process your request.\n" + e);
        } catch (Exception e) {
            System.out.println("Exception while handling your request." + e);
        }


    }


    private static void displayHome(final Connection connection) throws SQLException, IOException {
        System.out.println("\nSelect an option:" +
                "\n1. Add new Movie" +
                "\n2. View Movies" +
                "\n3. Delete movie" +
                "\n4. Exit Application");
        System.out.println("\n\nPlease enter your input: \t");

        int choice = readNumber(1, 4);

        switch (choice) {
            // Adding a new Movie
            case 1:
                addNewMovie(connection);
                System.out.println("Movie added successfully.");
                break;

            // View all movies
            case 2:
                viewAllMovies();
                break;

            case 3:
                deleteMovie(connection);
                System.out.println("Movie deleted successfully.");
                break;

            // Exit the application
            default:
                System.out.println("Exiting...");
                System.exit(0);
                break;

        }
    }

    private static void addNewMovie(final Connection connection) throws IOException, SQLException {

        // Enter the movie name
        System.out.println("Movie Name: \t");
        String movieName = reader.readLine();

        // Enter genre details
        System.out.println("Genre: \n");
        for (Map.Entry<Integer, Genre> entrySet : genreMap.entrySet()) {
            System.out.println(entrySet.getKey() + " - " + entrySet.getValue().getGenreName());
        }

        System.out.println("Select a Genre: \t");
        int genreId = Integer.parseInt(reader.readLine());
        while (!genreMap.containsKey(genreId)) {
            System.out.println("Please enter a valid input: \t");
            genreId = Integer.parseInt(reader.readLine());
        }

        // Enter country details
        System.out.println("Select the production Country: \n");
        for (Map.Entry<Integer, Country> entrySet : countryMap.entrySet()) {
            System.out.println(entrySet.getKey() + " - " + entrySet.getValue().getCountryName());
        }

        int countryId = Integer.parseInt(reader.readLine());
        while (!countryMap.containsKey(countryId)) {
            System.out.println("Please enter a valid input: \t");
            countryId = Integer.parseInt(reader.readLine());
        }

        // Enter language details
        System.out.println("Select the Language: \n");
        for (Map.Entry<Integer, Language> entrySet : languageMap.entrySet()) {
            System.out.println(entrySet.getKey() + " - " + entrySet.getValue().getLanguageName());
        }

        int languageId = Integer.parseInt(reader.readLine());
        while (!countryMap.containsKey(languageId)) {
            System.out.println("Please enter a valid input: \t");
            languageId = Integer.parseInt(reader.readLine());
        }

        final Movie movie = new Movie(movieName, genreId, countryId, languageId);

        movieRepo.addMovieToDatabase(connection, movie);

        movieMap = movieRepo.loadAllMoviesFromDatabase(connection);
    }


    private static void deleteMovie(final Connection connection) throws IOException, SQLException {
        viewAllMovies();
        System.out.println("Enter the MovieId to delete: \t");

        int movieId = Integer.parseInt(reader.readLine());
        while (!movieMap.containsKey(movieId)) {
            System.out.println("Please enter a valid input: \t");
            movieId = Integer.parseInt(reader.readLine());
        }

        movieRepo.deleteMovieFromDatabase(connection, movieId);

        movieMap.remove(movieId);
    }


    private static void viewAllMovies() {

        if (movieMap.size() == 0) {
            System.out.println("No movies found");
            return;
        }

        System.out.println("Movies: \n");
        System.out.println("--------------------------");
        for (Map.Entry<Integer, Movie> entry : movieMap.entrySet()) {
            final int movieId = entry.getKey();
            final Movie movie = entry.getValue();
            final String movieName = movie.getName();
            final String genre = genreMap.get(movie.getGenreId()).getGenreName();
            final String language = languageMap.get(movie.getLanguageId()).getLanguageName();
            final String country = countryMap.get(movie.getCountryId()).getCountryName();

            System.out.println("Movie ID: " + movieId +
                    "\nTitle: " + movieName +
                    "\nGenre: " + genre +
                    "\nLanguage: " + language +
                    "\nCountry: " + country);
            System.out.println("--------------------------");

        }
    }

    private static int readNumber(int min, int max) {
        int choice = -1;
        int attempts = 0;
        while (true) {

            if (attempts >= MAX_INPUT_ATTEMPTS) {
                System.out.println("Number of attempts limit reached. \n Exiting Application...");
                break;
            }

            try {
                choice = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number: \t");
                choice = -1;
            } catch (IOException ioException) {
                System.out.println("Could not find resources to process your request." +
                        "\nExiting Applicaton...");
                System.exit(0);
            }
            if (choice != -1 && (choice < min || choice > max)) {
                System.out.println("Please enter a valid choice: \t");
            } else if (choice != -1) {
                break;
            }

            attempts++;
        }

        return choice;
    }

}
