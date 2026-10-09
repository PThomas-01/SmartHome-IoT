public class Main {

    public static void main(String[] args) {

        Device light = new Device(101, "Living Room Light");
        Device fan = new Device(102, "Living Room Fan");
        Dashboard dashboard = new Dashboard();
        String url = "jdbc:mysql://localhost:3306/smart_home";
        String username = "root";
        String password = "YOUR_PASSWORD";

        try {

            DatabaseManager database =
                    new DatabaseManager(url, username, password);

            while (true) {

                IoTDataSource dataSource = new IoTDataSource();

                SensorData data = dataSource.getSensorData();

                double temperature = data.getTemperature();
                double humidity = data.getHumidity();
                boolean motion = data.isMotionDetected();

                Sensor temperatureSensor =
            new Sensor(temperature, humidity);

                MotionSensor motionSensor =
                        new MotionSensor(motion);

                temperatureSensor.displayTemperature();
                motionSensor.displayMotion();

                // Fan automation
                if (temperatureSensor.getTemperature() > 30 ||
                    temperatureSensor.getHumidity() > 70) {

                    fan.turnOn();

                } else {

                    fan.turnOff();
                }

                // Light automation
                if (motionSensor.isMotionDetected()) {

                    light.turnOn();

                } else {

                    light.turnOff();
                }

                fan.displayStatus();
                light.displayStatus();
                boolean fanStatus = fan.getStatus();
                boolean lightStatus = light.getStatus();
                
                dashboard.display(
                    temperature,
                    humidity,
                    motion,
                    fanStatus,
                    lightStatus
                );
                database.saveSensorData(
                        temperature,
                        humidity,
                        motion,
                        fanStatus,
                        lightStatus
                );

                System.out.println("...........");

                Thread.sleep(4000);
            }

       } catch (Exception e) {
        System.out.println();
        System.out.println("ERROR: Unable to connect to MySQL.");
        System.out.println("Please make sure the MySQL server is running.");
}
        }
    }
