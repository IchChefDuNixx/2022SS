public class FourWheel extends MotorizedVehicle {
    int hubraum;
    int zulGesamtGewicht;

    public FourWheel(String hersteller, String modell, int ps, int tankvolumen, int hubraum, int zulGesamtGewicht) {
        super(hersteller, modell, ps, tankvolumen);
        this.hubraum = hubraum;
        this.zulGesamtGewicht = zulGesamtGewicht;
    }
}
