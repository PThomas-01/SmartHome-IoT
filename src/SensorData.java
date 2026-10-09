public class SensorData {

    private double temperature;
    private double humidity;
    private boolean motion;

    public SensorData(double temperature, double humidity, boolean motion) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.motion = motion;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public boolean isMotionDetected() {
        return motion;
    }
}