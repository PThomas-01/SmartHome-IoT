public class Device {

    private int deviceId;
    private String deviceName;
    private boolean status;

    public Device(int deviceId, String deviceName) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.status = false;
    }

    public void turnOn() {
        status = true;
        System.out.println(deviceName + " turned ON");
    }

    public void turnOff() {
        status = false;
        System.out.println(deviceName + " turned OFF");
    }

    public void displayStatus() {
        System.out.println(deviceName + " : " + (status ? "ON" : "OFF"));
    
    }
    
    public boolean getStatus() {
        return status;
}
}