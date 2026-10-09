import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Dashboard {

    public void display(
            double temperature,
            double humidity,
            boolean motion,
            boolean fanStatus,
            boolean lightStatus) {

        System.out.println();
        System.out.println("================================");
        System.out.println("       SMART HOME DASHBOARD      ");
        DateTimeFormatter formatter =
        DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Last Updated: " +
        LocalDateTime.now().format(formatter));
        System.out.println("================================");


        System.out.printf("Temperature : %.2f °C%n", temperature);
        System.out.printf("Humidity    : %.2f %% %n", humidity);
        System.out.println("Motion      : " +
                (motion ? "DETECTED" : "NOT DETECTED"));

        System.out.println("--------------------------------");

        System.out.println("Fan         : " +
                (fanStatus ? "ON" : "OFF"));

        System.out.println("Light       : " +
                (lightStatus ? "ON" : "OFF"));

        System.out.println("================================");
        System.out.println();

    boolean alert = false;

if (temperature > 30) {
    System.out.println("⚠ HIGH TEMPERATURE ALERT!");
    alert = true;
}

if (humidity > 80) {
    System.out.println("⚠ HIGH HUMIDITY ALERT!");
    alert = true;
}

if (alert) {
    System.out.println("SYSTEM STATUS: ALERT");
} else {
    System.out.println("SYSTEM STATUS: NORMAL");
}
    }
}