package opgave_4;

public class FoedeVare extends Vare {
    public FoedeVare(int pris, String navn) {
        super(pris, navn);
    }

    @Override
    public double beregnMoms() {
        double moms = this.getPris() * 0.05;
        if (moms < 3) moms = 3;
        return moms;
    }
}
