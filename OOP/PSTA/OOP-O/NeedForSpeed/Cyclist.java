package NeedForSpeed;

public class Cyclist extends ManualDrive {

    public Cyclist(String name, Handicap handicap, double vmax, double vavg, double acceleration, double operatingCosts,
            double endurance, double level, double effort) {
        super(name, handicap, vmax, vavg, acceleration, operatingCosts, endurance, level, effort);
    }

    public String celebration() {
        return "Yeah I be beat the machines!!!";
    }

    public String disappointment() {
        return "It is impossible to compete with machines.";
    }

    public void setHandicap(Handicap handicap) {
        this.handicap = handicap;
        this.vavg = vavg * handicap.getvLimitation();
        this.acceleration = acceleration * handicap.getAccelerationLimitation();
        this.endurance = endurance * handicap.getEndurance();
        this.level = endurance * handicap.getEndurance();
    }

    public String toString() {
        return this.getClass().getName() + classToString();
    }

    public String getEmoji(){
        return "\ud83d\udeb2";
    }
}
