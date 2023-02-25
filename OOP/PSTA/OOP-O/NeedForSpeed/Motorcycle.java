package NeedForSpeed;

public class Motorcycle extends MotorizedDrive {

    public Motorcycle(String name, Handicap handicap, double vmax, double vavg, double acceleration,
            double operatingCosts, double tank, double mileage, double gasPrice) {
        super(name, handicap, vmax, vavg, acceleration, operatingCosts, tank, mileage, gasPrice);
    }

    public String celebration() {
        return "Motorcycles are the best vehicles!!!";
    }

    public String disappointment() {
        return "Motorcycles will do way better next time!!!";
    }

    public String toString() {
      return this.getClass().getName() + classToString();
    }

    public String getEmoji(){
        return "\ud83c\udfcd";
    }
}
