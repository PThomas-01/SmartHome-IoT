public class IoTDataSource {

    private double temperature = 32.0;
    private double humidity = 60.0;
    private boolean motion = false;

    public SensorData getSensorData() {

        temperature = temperature + (Math.random() * 2 - 1);
        humidity = humidity + (Math.random() * 4 - 2);

        motion = Math.random() > 0.7;

        return new SensorData(
                temperature,
                humidity,
                motion
        );
    }
}