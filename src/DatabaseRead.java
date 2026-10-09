import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseRead {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/smart_home";
        String username = "root";
        String password = "thomas@01102004";

        String sql = "SELECT * FROM sensor_data ORDER BY id DESC LIMIT 1";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection =
                    DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            ResultSet result =
                    statement.executeQuery(sql);

            while (result.next()) {

                System.out.println("Temperature: "
                        + result.getDouble("temperature"));

                System.out.println("Humidity: "
                        + result.getDouble("humidity"));

                System.out.println("Motion: "
                        + result.getBoolean("motion"));

                System.out.println("Fan: "
                        + result.getBoolean("fan_status"));

                System.out.println("Light: "
                        + result.getBoolean("light_status"));

                System.out.println("Recorded At: "
                        + result.getTimestamp("recorded_at"));

                    if (result.getDouble("temperature") > 35) {
                         System.out.println(" HIGH TEMPERATURE ALERT!");
}

                    if (result.getDouble("humidity") > 80) {
                        System.out.println(" HIGH HUMIDITY ALERT!");
}


                System.out.println("--------------------");
            }

            connection.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
