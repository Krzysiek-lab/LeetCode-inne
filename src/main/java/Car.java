public class Car {

    private int maxSpeed;
    private int acceleration;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    @Override
    public String toString() {
        return "speed: "+getMaxSpeed()+"  "+ "acceleration: "+getAcceleration();
    }
}

