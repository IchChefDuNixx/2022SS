public class MotorizedVehicle extends Vehicle {
    int ps;
    int tankvolumen;

    public MotorizedVehicle(String hersteller, String modell, int ps, int tankvolumen) {
        super(hersteller, modell);
        this.ps = ps;
        this.tankvolumen = tankvolumen;
    }

}
