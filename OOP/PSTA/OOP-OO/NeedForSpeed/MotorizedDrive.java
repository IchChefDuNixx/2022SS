package NeedForSpeed;

import java.math.BigDecimal;

public abstract class MotorizedDrive extends Vehicle {
  final double gasPrice;
  double restTime = 600;

  public MotorizedDrive(String name, Handicap handicap, double vmax, double vavg, double acceleration,
      double operatingCosts, double tank, double mileage, double gasPrice) {
    super(name, handicap, vmax, vavg, acceleration, operatingCosts, tank * handicap.getTankLimitation(), tank * handicap.getTankLimitation(), mileage / 100000);
    this.tank = tank * handicap.getTankLimitation();
    this.gasPrice = gasPrice;
      this.restTime2 = 600;
  }

  public int refuelNumber(double distance) {
      //milage does not exist you have to use the variable effortmilage
    return (int) (level / (effortMileage*100000)) + 1;
  }

    public void refuel() {
        this.level = tank;
    }


    public double costs(double gasPrice) {
      this.costs = distance * (effortMileage*100000) * gasPrice + distance * operatingCosts;
      return Math.round(costs*100.0)/100.0;
  }

  /* has lower accuracy because of the type change but might be an alternative for the long races,
     rounding the value will probably not work since BigDecimal uses the value representation that is stored in memory.
     using BigInteger might be an alternative
  */
  public BigDecimal bigCosts(double gasPrice) {
      this.costs = distance * (effortMileage*100000) * gasPrice + distance * operatingCosts;
      /* this part didn't work as intended
      BigDecimal bigCosts = BigDecimal.valueOf(distance);
      bigCosts = bigCosts.multiply(BigDecimal.valueOf(effortMileage));
      bigCosts = bigCosts.multiply(BigDecimal.valueOf(100000));
      bigCosts = bigCosts.multiply(BigDecimal.valueOf(gasPrice));
      bigCosts = bigCosts.multiply(BigDecimal.valueOf(distance));
      bigCosts = bigCosts.multiply(BigDecimal.valueOf(operatingCosts));
      */
      return BigDecimal.valueOf(costs);
  }


  public void reset() {
      this.time = 0;
      this.distance = 0;
      this.costs = 0;
      if (handicap.getTankLimitation() == 0) {
          rest();
          // use rest instead of refuel
          //refuel();
      } else {
          this.level = tank * handicap.getTankLimitation();
      }
  }

  public void setHandicap(Handicap handicap) {
      this.handicap = handicap;
      this.vavg = vavg * handicap.getvLimitation();
      this.acceleration = acceleration * handicap.getAccelerationLimitation();
      this.tank = tank * handicap.getTankLimitation();
      this.level = tank * handicap.getTankLimitation();
  }

  public String classToString() {
    return helperToString() + costs(gasPrice) + " €\n\n";
  }

  public double getRestTime(){
      return restTime;
  }

}
