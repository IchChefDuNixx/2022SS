package CrazyStation;

public class CentralStation{

    private Car[] storage;
    private Train[] trains;
    private String name;

    public CentralStation(String name){
        this.name = name;
        storage = new Car[1];
        trains = new Train[1];
    }

    public CentralStation(String name, Train train){
        this.name = name;
        storage = new Car[1];
        trains = new Train[]{train};
    }

    public CentralStation(String name, Train[] trains){
        this.name = name;
        storage = new Car[1];
        this.trains = trains;
    }


    public void addTrain (Train c) {
        if (trains[0] == null) {
            trains[0] = c;
        } else {
            Train[] newArray = new Train[trains.length + 1];
            System.arraycopy(trains, 0, newArray, 0, trains.length);
            newArray[trains.length] = c;
            trains = newArray;
        }
    }

    public void addTrains (Train... c){
        if (c != null){
            for (Train train : c) addTrain(train);
        }
    }

    public void addCar (Car c){
        if (storage[0] == null){
            storage [0] = c;
        } else {
            Car[] newArray = new Car[storage.length+1];
            System.arraycopy(storage, 0, newArray, 0, storage.length);
            newArray [storage.length] = c;
            storage = newArray;
        }
    }

    public Car removeCar (){
        if (storage.length == 0){
            return null;
        }
        Car car = storage[storage.length-1];
        Car[] newArray = new Car[storage.length-1];
        System.arraycopy(storage, 0, newArray, 0, storage.length - 1);
        storage = newArray;
        return car;
    }

    public void loadTrains (){
        Car c = removeCar();
        while (c != null){
            for (Train t: trains) {
                while (c != null) {
                    if (t.addCar(c)) {
                        c = removeCar();
                    } else {
                        break;
                    }
                }
            }
            c = removeCar();
        }
        storage = new Car[1];
    }

    public void unloadTrains () {

        for (Train t: trains){
            Car c = t.removeCar();
            while (c!=null){
                addCar(c);
                c = t.removeCar();
            }
        }
    }

    public String toString () {
        StringBuilder s;
        s = new StringBuilder(name + ":\n");
        for (Car c: storage){
            s.append(c.toString()).append("\n");
        }
        return s.toString();
    }

    public Car[] getStorage (){return storage; }

    public void setStorage (Car[] sorted){
        storage = sorted;
    }

    public Train[] getTrains ()  { return trains; }

    public String getName() { return name; }

    public void distributeCars (){
        Car[] notDistributable = new Car[1];
        while (storage.length != 0){
            Car c = removeCar();
            for (Train t: getTrains()){
                if (t.getStation().getName().equals(c.getTarget().getName())){
                    if (t.addCar(c)){
                        break;
                    } else {
                            if (notDistributable[0] == null) {
                                notDistributable[0] = c;
                            } else {
                                Car[] newArray = new Car[notDistributable.length + 1];
                                System.arraycopy(notDistributable, 0, newArray, 0, notDistributable.length);
                                newArray[notDistributable.length] = c;
                                notDistributable = newArray;
                            }
                    }
                }
            }
        }
        storage = new Car[1];
    }
}
