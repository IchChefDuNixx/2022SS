package NeedForSpeed;

public class Truck extends MotorizedDrive {

    public Truck(String name, Handicap handicap, double vmax, double vavg, double acceleration, double operatingCosts,
            double tank, double mileage, double gasPrice) {
        super(name, handicap, vmax, vavg, acceleration, operatingCosts, tank, mileage, gasPrice);
    }

    public String celebration() {
        return "Trucks are the best vehicles!!!";
    }

    public String disappointment() {
        return "Trucks will do way better next time!!!";
    }

    public String toString() {
      return this.getClass().getName() + classToString();
    }

    public String getEmoji(){
        return "\ud83d\ude9b";
    }
}
