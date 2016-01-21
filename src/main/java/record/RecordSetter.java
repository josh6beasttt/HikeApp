package record;

import json.set.HikeJson;
import json.set.PersonJson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class RecordSetter extends Record {
    public static void setPerson(PersonJson personJson) throws SQLException {
        final String sqlString = "INSERT INTO person VALUES(CAST(? AS UUID), ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sqlString)) {

            preparedStatement.setString(1, UUID.randomUUID().toString());
            preparedStatement.setString(2, personJson.firstName);
            preparedStatement.setString(3, personJson.lastName);
            preparedStatement.setString(4, personJson.picture);

            preparedStatement.execute();
        }
    }

    public static void setHike(HikeJson hikeJson) throws SQLException {
        final String sqlString = "INSERT INTO hike VALUES(CAST(? AS UUID), ?, ?, ?, ?";

        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sqlString)) {

            preparedStatement.setString(1, UUID.randomUUID().toString());
            preparedStatement.setDouble(2, hikeJson.latitude);
            preparedStatement.setDouble(3, hikeJson.longitude);
            preparedStatement.setString(4, hikeJson.name);
            preparedStatement.setString(5, hikeJson.description);

            preparedStatement.execute();
        }
    }
}
