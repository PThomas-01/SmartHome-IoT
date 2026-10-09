import java.io.File;
import java.net.InetSocketAddress;
import java.nio.file.Files;

import com.sun.net.httpserver.HttpServer;

public class SimpleApiServer {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/smart_home";
        String username = "root";
        String password = "YOUR_PASSWORD";

        DatabaseManager database =
                new DatabaseManager(url, username, password);

        HttpServer server =
                HttpServer.create(
                        new InetSocketAddress(8080), 0
                );

        // Latest sensor reading
        server.createContext("/api/sensors/latest", exchange -> {

            try {

                String response =
                        database.getLatestSensorData();

                exchange.getResponseHeaders().set(
                        "Content-Type",
                        "application/json"
                );

                exchange.sendResponseHeaders(
                        200,
                        response.getBytes().length
                );

                exchange.getResponseBody().write(
                        response.getBytes()
                );

                exchange.getResponseBody().close();

            } catch (Exception e) {

                String response =
                        "{\"error\":\"Unable to read sensor data\"}";

                exchange.sendResponseHeaders(
                        500,
                        response.getBytes().length
                );

                exchange.getResponseBody().write(
                        response.getBytes()
                );

                exchange.getResponseBody().close();
            }
        });

        // Sensor history
        server.createContext("/api/sensors/history", exchange -> {

            try {

                String response =
                        database.getSensorHistory();

                exchange.getResponseHeaders().set(
                        "Content-Type",
                        "application/json"
                );

                exchange.sendResponseHeaders(
                        200,
                        response.getBytes().length
                );

                exchange.getResponseBody().write(
                        response.getBytes()
                );

                exchange.getResponseBody().close();

            } catch (Exception e) {

                String response =
                        "{\"error\":\"Unable to read sensor history\"}";

                exchange.sendResponseHeaders(
                        500,
                        response.getBytes().length
                );

                exchange.getResponseBody().write(
                        response.getBytes()
                );

                exchange.getResponseBody().close();
            }
        });

        // Web dashboard
        server.createContext("/", exchange -> {

            File file =
                    new File("dashboard/index.html");

            byte[] response =
                    Files.readAllBytes(file.toPath());

            exchange.getResponseHeaders().set(
                    "Content-Type",
                    "text/html"
            );

            exchange.sendResponseHeaders(
                    200,
                    response.length
            );

            exchange.getResponseBody().write(
                    response
            );

            exchange.getResponseBody().close();
        });

        server.start();

        System.out.println(
                "Smart Home API running on http://localhost:8080"
        );
    }
}