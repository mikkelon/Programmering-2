package opgave_2;

import static opgave_2.Main.beregnBøde;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class MainTest {
    private LocalDate beregnetDato;
    @BeforeEach
    void setUp() {
        beregnetDato = LocalDate.of(2023, 2, 10);
    }

    @Test
    void beregnBødeTC1() {
        LocalDate faktiskDato = LocalDate.of(2023, 2, 10);
        boolean voksen = false;
        assertEquals(0, beregnBøde(beregnetDato, faktiskDato, voksen));
    }

    @Test
    void beregnBødeTC2() {
        LocalDate faktiskDato = LocalDate.of(2023, 2, 11);
        boolean voksen = false;
        assertEquals(10, beregnBøde(beregnetDato, faktiskDato, voksen));
    }

    @Test
    void beregnBødeTC3() {
        LocalDate faktiskDato = LocalDate.of(2023, 2, 17);
        boolean voksen = false;
        assertEquals(10, beregnBøde(beregnetDato, faktiskDato, voksen));
    }

    @Test
    void beregnBødeTC4() {
        LocalDate faktiskDato = LocalDate.of(2023, 2, 18);
        boolean voksen = false;
        assertEquals(30, beregnBøde(beregnetDato, faktiskDato, voksen));
    }

    @Test
    void beregnBødeTC5() {
        LocalDate faktiskDato = LocalDate.of(2023, 2, 24);
        boolean voksen = false;
        assertEquals(30, beregnBøde(beregnetDato, faktiskDato, voksen));
    }

    @Test
    void beregnBødeTC6() {
        LocalDate faktiskDato = LocalDate.of(2023, 2, 25);
        boolean voksen = false;
        assertEquals(45, beregnBøde(beregnetDato, faktiskDato, voksen));
    }

    @Test
    void beregnBødeTC7() {
        LocalDate faktiskDato = LocalDate.of(2023, 2, 11);
        boolean voksen = true;
        assertEquals(20, beregnBøde(beregnetDato, faktiskDato, voksen));
    }

    @Test
    void beregnBødeTC8() {
        LocalDate faktiskDato = LocalDate.of(2023, 2, 17);
        boolean voksen = true;
        assertEquals(20, beregnBøde(beregnetDato, faktiskDato, voksen));
    }

    @Test
    void beregnBødeTC9() {
        LocalDate faktiskDato = LocalDate.of(2023, 2, 18);
        boolean voksen = true;
        assertEquals(60, beregnBøde(beregnetDato, faktiskDato, voksen));
    }

    @Test
    void beregnBødeTC10() {
        LocalDate faktiskDato = LocalDate.of(2023, 2, 24);
        boolean voksen = true;
        assertEquals(60, beregnBøde(beregnetDato, faktiskDato, voksen));
    }

    @Test
    void beregnBødeTC11() {
        LocalDate faktiskDato = LocalDate.of(2023, 2, 25);
        boolean voksen = true;
        assertEquals(90, beregnBøde(beregnetDato, faktiskDato, voksen));
    }
}