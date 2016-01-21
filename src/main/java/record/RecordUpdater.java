package record;

import json.update.HikeJson;
import json.update.PersonJson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RecordUpdater extends Record {
    public static void updatePerson(PersonJson personJson) throws SQLException {
        final String sqlString = "UPDATE person SET first_name = ? WHERE user_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sqlString)) {

        }
    }

    public static void updateHike(HikeJson json) {
        final String sqlString = "UPDATE hike SET latitude = ? WHERE hike_id = ?";
    }
}