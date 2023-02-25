package NeedForSpeed;

public class Handicap {
    private double vLimitation; // in Percent
    private double accelerationLimitation; // in Percent
    private double tankLimitation; // in Percent
    private double endurance; // in Percent
    private int startDelay;
    private int lead;

    public Handicap (double vLimitation, double accelerationLimitation, double tankLimitation, double endurance, int startDelay, int lead){
        this.vLimitation = vLimitation;
        this.accelerationLimitation = accelerationLimitation;
        this.endurance = endurance;
        this.tankLimitation = tankLimitation;
        this.startDelay = startDelay;
        this.lead = lead;
    }

    public double getvLimitation() {
        return vLimitation;
    }

    public double getAccelerationLimitation() {
        return accelerationLimitation;
    }

    public double getTankLimitation() {
        return tankLimitation;
    }

    public double getEndurance() {
        return endurance;
    }

    public int getStartDelay() {
        return startDelay;
    }

    public int getLead() {
        return lead;
    }
}
