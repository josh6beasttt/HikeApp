package record;

import json.get.HikeJson;
import json.get.PersonJson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecordGetter extends Record {
    public static String getPerson(String userId) throws SQLException {
        final String sqlString = "SELECT first_name, last_name, picture FROM person " +
                "WHERE person_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sqlString)) {
            preparedStatement.setString(1, userId);

            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                PersonJson personJson = new PersonJson();

                personJson.setFirstName(result.getString(1));
                personJson.setLastName(result.getString(2));
                personJson.setPicture(result.getString(3));

                return personJson.toJson();
            }
            return null;
        }
    }

    public static String getHike(String hikeId) throws SQLException {
        final String sqlString = "SELECT latitude, longitude, hike.name, description FROM hike " +
                "WHERE hike_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sqlString)) {
            preparedStatement.setString(1, hikeId);

            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                HikeJson hikeJson = new HikeJson();

                hikeJson.setLatitude(result.getDouble(1));
                hikeJson.setLongitude(result.getDouble(2));
                hikeJson.setName(result.getString(3));
                hikeJson.setDescription(result.getString(4));

                return hikeJson.toJson();
            }
        }
        return null;
    }
}
