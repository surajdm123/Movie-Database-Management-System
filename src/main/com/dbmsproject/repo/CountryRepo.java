package com.dbmsproject.repo;

import com.dbmsproject.view.Country;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class CountryRepo {

    /***
     * @param connection
     * @return Map of Country objects
     * @throws Exception
     */
    public Map<Integer, Country> loadAllCountriesFromDatabase(final Connection connection) throws Exception {
        final Map<Integer, Country> countryMap = new HashMap();
        Statement statement = connection.createStatement();
        final String sqlQuery = "SELECT * FROM country;";
        final ResultSet resultSet = statement.executeQuery(sqlQuery);
        while (resultSet.next()) {
            final String name = resultSet.getString("country_name");
            final int countryId = resultSet.getInt("country_id");
            final Timestamp created = resultSet.getTimestamp("created");
            final Timestamp updated = resultSet.getTimestamp("updated");
            final Country country = new Country(countryId, name, created, updated);
            countryMap.put(countryId, country);
        }

        return countryMap;
    }

}
