public class TwoWheel extends MotorizedVehicle {
    Scheibenbremse vorderbremse;
    Trommelbremse hinterbremse;

    public TwoWheel(String hersteller, String modell, int ps, int tankvolumen, Scheibenbremse vorderbremse,
            Trommelbremse hinterbremse) {
        super(hersteller, modell, ps, tankvolumen);
        this.vorderbremse = vorderbremse;
        this.hinterbremse = hinterbremse;
    }
}
