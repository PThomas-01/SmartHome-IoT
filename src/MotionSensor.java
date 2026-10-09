public class MotionSensor 
{
      private boolean motionDetected;

    public MotionSensor(boolean motionDetected) 
    {
        this.motionDetected = motionDetected;
    }

    public boolean isMotionDetected() 
    {
        return motionDetected;
    }

    public void displayMotion()
     {
        System.out.println("Motion: " + (motionDetected ? "DETECTED" : "NOT DETECTED"));
    }
}
