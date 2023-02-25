package NeedForSpeed;


public abstract class Vehicle {
    String name;
    Handicap handicap;
    double vavg;
    final double vmax;
    double acceleration;
    final double operatingCosts;
    double energyCap;
    double endurance = energyCap;
    double tank = energyCap;
    double time;
    double distance;
    double level;
    double effortMileage;

    double costs = 0; // no

    double restTime2;

    public Vehicle(String name, Handicap handicap, double vmax, double vavg, double acceleration, double operatingCosts, double energyCap,
            double level, double effortMileage) {
        this.name = name;
        this.handicap = handicap;
        if (vavg > 200) {
            this.vavg = 200;
        } else {
            this.vavg = vavg * handicap.getvLimitation();
        }
        this.vmax = vmax;
        if (acceleration > 28) {
            this.acceleration = 28;
        } else {
            this.acceleration = acceleration * handicap.getAccelerationLimitation();
        }
        this.operatingCosts = operatingCosts / 1000;
        this.time = 0;
        this.distance = handicap.getLead();
        this.effortMileage = effortMileage;
    }

    public double accelerationDistance() {
        double time = vavg / acceleration;
        return time * time * 0.5 * acceleration;
    }

    public double accelerationTime() {
        return vavg / acceleration;
    }

    public double accelerationVmaxDistance() {
        double time = vmax / acceleration;
        return time * time * 0.5 * acceleration;
    }

    public double accelerationVmaxTime() {
        return vmax / acceleration;
    }

    public double rangeTime(double time) { // Weg der bei voller Fahrt auf die restliche Strecke zustande kommt
        return vavg * time;
    }

    public double range() {
      return level / effortMileage;
    }

    public double driveDistance(double distance, double restTime) {
        double range = range();
        while (distance > 0) {
            if (distance > range) {
                this.distance += range;
                this.time += range / vavg;
                distance -= range;
                rest();
                this.time += restTime;
            } else {
                this.distance += distance;
                this.time += distance / vavg;
                break;
            }
            time += accelerationTime();
            distance -= accelerationDistance();
            this.distance += accelerationDistance();
        }
        this.time -= handicap.getStartDelay();
        return time;
    }

    public double driveTime(double time, double restTime) {
        double rangetime = 0;
        double range = 0;
        while (time != 0) {
            rangetime = rangeTime(time);
            range = range();
            if (rangetime > range) {
                this.distance += range;
                this.time += range / vavg;
                rest();
                this.time += restTime;
            } else {
                this.time += time;
                this.distance += time * vavg;
                break;
            }
            this.distance += accelerationDistance();
            this.time += accelerationTime();
            time -= accelerationTime();
        }
        this.distance += handicap.getLead();
        return distance;
    }

    public double distance(double time, double restTime) {
        double rangetime = 0;
        double range = 0;
        while (time != 0) {
            this.distance += accelerationDistance();
            this.time += accelerationTime();
            time -= accelerationTime();
            rangetime = rangeTime(time);
            range = range();
            if (rangetime > range) {
                this.distance += range;
                this.time += range / vavg;
                rest();
                this.time += restTime;
            } else {
                this.time += time;
                this.distance += time * vavg;
                break;
            }
        }
        this.distance += handicap.getLead();
        return distance;
    }

    public double time(double distance, double restTime) {
        double range = range();
        while (distance > 0) {
            time += accelerationTime();
            distance -= accelerationDistance();
            this.distance += accelerationDistance();
            if (distance > range) {
                this.distance += range;
                this.time += range / vavg;
                distance -= range;
                rest();
                this.time += restTime;
            } else {
                this.distance += distance;
                this.time += distance / vavg;
                break;
            }
        }
        this.time -= handicap.getStartDelay();
//        return Math.round(this.time * 100.0)/100.0;
        return this.time;
    }

    public double dragDistance(double time) { // DragRace time if realisic else 0
        if (accelerationVmaxTime() < time) {
            return 0;
        } else {
            this.time = time;
            double distance = 0.5 * acceleration * time * time;
            this.distance += distance;
            return distance;
        }
    }

    public double dragTime(double distance) { // DragRace distance if realisic else 0
        if (accelerationVmaxDistance() < distance) {
            return 0;
        } else {
            this.distance = distance;
            this.time = Math.sqrt((2 * distance) / acceleration) - handicap.getStartDelay();
            return time;
        }
    }

    public void rest() {
        this.level = energyCap;
    }

    public double getTime() {
        return time - handicap.getStartDelay();
    }

    public double getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public double getRestTime2(){
        return restTime2;
    }


    abstract String celebration();

    abstract String disappointment();

    public String helperToString() {
        int hours = 0;
        int minutes = 0;
        double sec = 0;
        String time;
        if (getTime() > 3600) {
            sec = getTime() % 3600;
            hours = (int) (getTime() / 3600);
            minutes = (int) (sec / 60);
            sec = sec % 60;
            time = hours + " h " + minutes + " min " + Math.round(sec*100.0)/100.0 + " s ";
            /*time = hours + " h " + minutes + " min " + sec+ " s ";*/
        } else {
            minutes = (int) (getTime() / 60);
            sec = getTime() % 60;
            time = minutes + " min " + Math.round(sec*100.0)/100.0 + " s ";
            /*time = minutes + " min " + sec + " s ";*/
        }
        String distance;
        if (getDistance() > 1000) {
            distance = getDistance() / 1000 + " km ";
        } else {
            distance = getDistance() + " m ";
        }

        return "name: " + name + "\nTime: " + time + "\tDistance: " + distance + "\tCosts: ";
    }

    abstract String getEmoji();

}
