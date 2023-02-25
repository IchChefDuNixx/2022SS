package CrazyStation2;

public abstract class Car {
    private int priority;
    private int carID;
    private Station start;
    private Station target;
    public String emoji;

    public Car (int carID, Station start, Station target, int priority){
        this.carID = carID;
        this.start = start;
        this.target = target;
        this.priority = priority;
    }

    public Car (){};

    public String toString (){
        return "CarID: " + carID + "\tStart: " + start.getName() +
                "\tTarget: " + target.getName() + "\tPriority: " + priority;
    }

    public int getPriority (){ return priority; }

    public int getCarID (){ return carID; }

    public Station getStart () { return start; }

    public Station getTarget () { return target; }

    public int compareTo (Car c){
        if (c.getPriority() < priority) {
            return -1;
        } else if (c.getPriority() > priority){
            return 1;
        } else {
            if (c.getCarID()==carID){
                return 0;
            } else if (c.getCarID()<carID){
                return -1;
            } else {
                return 1;
            }
        }

    }


}
