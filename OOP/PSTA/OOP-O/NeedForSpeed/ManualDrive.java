package NeedForSpeed;

public abstract class ManualDrive extends Vehicle {
  final double restTime = 3600;

  public ManualDrive(String name, Handicap handicap, double vmax, double vavg, double acceleration,
      double operatingCosts, double endurance, double level, double effort) {
    super(name, handicap, vmax, vavg, acceleration, operatingCosts, endurance, level, effort / 100000);
    this.endurance = endurance * handicap.getEndurance();
    this.restTime2 = 3600;

  }

  public int refuelNumber(double distance) {
      // cant use the vaiable effort, must convert from effortMilage to effort
    return (int) (level / (effortMileage*100000)) + 1;
  }

  public double costs() {

      this.costs = distance * operatingCosts;
      return Math.round(costs*100.0)/100.0;
  }

  public void reset() {
      this.time = 0;
      this.distance = 0;
      this.costs = 0;
      if (handicap.getEndurance() == 0) {
          rest();
      } else {
          this.level = endurance * handicap.getEndurance();
      }
  }

  public String classToString() {
    return helperToString() + costs() + " €\n\n";
  }

    public double getRestTime(){
        return restTime;
    }


}
