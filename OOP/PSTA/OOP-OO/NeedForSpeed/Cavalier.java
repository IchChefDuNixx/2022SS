package NeedForSpeed;

public class Cavalier extends ManualDrive {

    public Cavalier(String name, Handicap handicap, double vmax, double vavg, double acceleration,
            double operatingCosts, double endurance, double level, double effort) {
        super(name, handicap, vmax, vavg, acceleration, operatingCosts, endurance, level, effort);
    }

    public String celebration() {
        return "My horse is the best one in the world!!!";
    }

    public String disappointment() {
        return "We had no chance.";
    }

    public void setHandicap(Handicap handicap) {
        this.handicap = handicap;
        this.vavg = vavg * handicap.getvLimitation();
        this.acceleration = acceleration * handicap.getAccelerationLimitation();
        this.endurance = endurance * handicap.getTankLimitation();
        this.level = endurance * handicap.getTankLimitation();
    }

    public String toString() {
        return this.getClass().getName() + classToString();
    }

    public String getEmoji(){
        return "\ud83c\udfc7";
    }
}
