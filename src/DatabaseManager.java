import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseManager {

    private Connection connection;

    public DatabaseManager(String url, String username, String password)
            throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection(
                url,
                username,
                password
        );

        System.out.println("Database connected!");
    }

    public void saveSensorData(
            double temperature,
            double humidity,
            boolean motion,
            boolean fanStatus,
            boolean lightStatus) throws Exception {

        String sql = "INSERT INTO sensor_data " +
                     "(temperature, humidity, motion, fan_status, light_status) " +
                     "VALUES (?, ?, ?, ?, ?)";

        PreparedStatement statement =
                connection.prepareStatement(sql);

        statement.setDouble(1, temperature);
        statement.setDouble(2, humidity);
        statement.setBoolean(3, motion);
        statement.setBoolean(4, fanStatus);
        statement.setBoolean(5, lightStatus);

        statement.executeUpdate();

        statement.close();

        System.out.println("Data saved to MySQL!");
    }

    public String getLatestSensorData() throws Exception {

        String sql = "SELECT * FROM sensor_data " +
                     "ORDER BY id DESC LIMIT 1";

        PreparedStatement statement =
                connection.prepareStatement(sql);

        ResultSet result = statement.executeQuery();

        if (result.next()) {

            double temperature =
                    result.getDouble("temperature");

            double humidity =
                    result.getDouble("humidity");

            boolean motion =
                    result.getBoolean("motion");

            boolean fan =
                    result.getBoolean("fan_status");

            boolean light =
                    result.getBoolean("light_status");

            result.close();
            statement.close();

            return "{"
                    + "\"temperature\":" + temperature + ","
                    + "\"humidity\":" + humidity + ","
                    + "\"motion\":" + motion + ","
                    + "\"fan\":" + fan + ","
                    + "\"light\":" + light
                    + "}";
        }

        result.close();
        statement.close();

        return "{\"message\":\"No sensor data available\"}";
    }

    public String getSensorHistory() throws Exception {

        String sql = "SELECT * FROM sensor_data " +
                     "ORDER BY id DESC LIMIT 5";

        PreparedStatement statement =
                connection.prepareStatement(sql);

        ResultSet result = statement.executeQuery();

        StringBuilder json = new StringBuilder();

        json.append("[");

        boolean first = true;

        while (result.next()) {

            if (!first) {
                json.append(",");
            }

            double temperature =
                    result.getDouble("temperature");

            double humidity =
                    result.getDouble("humidity");

            boolean motion =
                    result.getBoolean("motion");

            boolean fan =
                    result.getBoolean("fan_status");

            boolean light =
                    result.getBoolean("light_status");

            json.append("{")
                .append("\"temperature\":").append(temperature).append(",")
                .append("\"humidity\":").append(humidity).append(",")
                .append("\"motion\":").append(motion).append(",")
                .append("\"fan\":").append(fan).append(",")
                .append("\"light\":").append(light)
                .append("}");

            first = false;
        }

        json.append("]");

        result.close();
        statement.close();

        return json.toString();
    }
}