package opgave_4;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Vare> set = new HashSet<>();
        FoedeVare f1 = new FoedeVare(10, "Banan");
        ElVare e1 = new ElVare(3000, "Bærbar");
        Spiritus s1 = new Spiritus(75, "Vodka");
        SpiritusAdapter s1Adapter = new SpiritusAdapter(s1);

        set.add(f1);
        set.add(e1);
        set.add(s1Adapter);

        for (Vare v : set) {
            System.out.println("#--- " + v.getNavn() + " ---#");
            System.out.println("# Pris: " + v.getPris() + " DKK");
            System.out.println("# Moms: " + v.beregnMoms() + " DKK");
            System.out.println();
        }
    }
}
