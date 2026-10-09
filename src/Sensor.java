public class Sensor {
     private double temperature;
     private double humidity;

    public Sensor(double temperature, double humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public double getTemperature() {
        return temperature;
    }
    public double getHumidity() {
        return humidity;
    }

    public void displayTemperature() {
        System.out.printf("Temperature: %.2f°C%n", temperature);
        System.out.printf("Humidity: %.2f%%%n", humidity);
    }

    public void displayHumidity() {
        System.out.println("Humidity: " + humidity + "%");
      
    }
}
