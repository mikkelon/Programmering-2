package opgave_2;

import java.time.LocalDate;

public class Main {
    /**
     * Returnerer størrelsen af bøden beregnet i henhold til skemaet
     * ovenfor
     * krav: beregnetDato og faktiskDato indeholder lovlige datoer og
     * beregnetDato < faktiskDato
     * (beregnetDato er forventet afleveringsdato og
     * faktiskDato er den dag bogen blev afleveret; voksen er
     * sand, hvis det er en voksen og falsk ellers)
     **/
    public static int beregnBøde(LocalDate beregnetDato, LocalDate faktiskDato, boolean voksen) {
        int daysBetween = (int) (faktiskDato.toEpochDay() - beregnetDato.toEpochDay());

        if (daysBetween == 0) return 0;
        else if (daysBetween < 8) return voksen ? 20 : 10;
        else if (daysBetween < 15) return voksen ? 60 : 30;
        else return voksen ? 90 : 45;
    }
}
