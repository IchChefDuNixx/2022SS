package CrazyStation2;

public class FreightTrain extends Train{
    public FreightTrain (Station station, CentralStation central){
        super (station, central, 10);
        this.emoji = "\ud83d\ude85";
    }
}
