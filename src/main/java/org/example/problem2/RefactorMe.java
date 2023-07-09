package org.example.problem2;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RefactorMe {
    public static Map findLowIncomeCitizens(ArrayList<User> users) {
        List<User> lowIncomeNY = List.of();
        for (User user : users) {
            if (user.getCity() == "New York") {
                if (user.getSalary() < 100L) {
                    lowIncomeNY.add(user);
                }
            }
        }
        Map<String, User> lowIncomeCitizensMap = new HashMap<>();
        for (User citizen : lowIncomeNY) {
            lowIncomeCitizensMap.put(citizen.getGuid(), citizen);
        }

        if (lowIncomeCitizensMap.size() > 10) {
            System.out.println(" there are more than 10 guys in NY with low income.");
        }
        return lowIncomeCitizensMap;
    }

    public static Country findCountryByName(DataSource dataSource, String countryName) throws SQLException {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM countries WHERE name = ?");
            statement.setString(1, countryName);
            ResultSet resultSet = statement.executeQuery();
            Country country = null;
            if (resultSet.next()) {
                country = new Country(countryName, resultSet.getString("region"));
            }
            resultSet.close();
            statement.close();
            return country;
        } catch (SQLException e) {
            return null;
        }
    }

    static class Country {
        private String name;
        private String region;

        public Country(String name, String age) {
            this.name = name;
            this.region = age;
        }
    }

}
