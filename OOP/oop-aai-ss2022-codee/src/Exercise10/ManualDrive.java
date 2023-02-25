public class ManualDrive extends Vehicle {
    int gaenge;
    boolean ruecktrittbremse;

    public ManualDrive(String hersteller, String modell, int gaenge, boolean ruecktrittbremse) {
        super(hersteller, modell);
        this.gaenge = gaenge;
        this.ruecktrittbremse = ruecktrittbremse;
    }
}
