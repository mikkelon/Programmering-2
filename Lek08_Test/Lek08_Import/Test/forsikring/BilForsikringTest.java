package forsikring;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import  org.junit.jupiter.api.Test;

class BilForsikringTest {
    private BilForsikring bf;
    @BeforeEach
    void setUp() {
        bf = new BilForsikring();
        bf.setGrundpaemie(10000);
    }

    @Test
    void getGrundPraemie() {
        BilForsikring bf = new BilForsikring();
        bf.setGrundpaemie(10);
        assertEquals(bf.getGrundPraemie(), 10);
    }

    @Test
    void setGrundpaemie() {
        BilForsikring bf = new BilForsikring();
        bf.setGrundpaemie(10);
        assertEquals(bf.getGrundPraemie(), 10);
    }

    @Test
    void beregnPraemieTC1() {
        int alder = 20;
        boolean isKvinde = true;
        int skadefrieAar = 1;
        assertEquals(11875, bf.beregnPraemie(alder, isKvinde, skadefrieAar));
    }

    @Test
    void beregnPraemieTC2() {
        int alder = 30;
        boolean isKvinde = false;
        int skadefrieAar = 0;
        assertEquals(10000, bf.beregnPraemie(alder, isKvinde, skadefrieAar));
    }

    @Test
    void beregnPraemieTC3() {
        int alder = 40;
        boolean isKvinde = true;
        int skadefrieAar = 3;
        assertEquals(8075, bf.beregnPraemie(alder, isKvinde, skadefrieAar));
    }

    @Test
    void beregnPraemieTC4() {
        int alder = 50;
        boolean isKvinde = false;
        int skadefrieAar = 7;
        assertEquals(7500, bf.beregnPraemie(alder, isKvinde, skadefrieAar));
    }

    @Test
    void beregnPraemieTC5() {
        int alder = 45;
        boolean isKvinde = true;
        int skadefrieAar = 10;
        assertEquals(6175, bf.beregnPraemie(alder, isKvinde, skadefrieAar));
    }

    @Test
    void beregnPraemieTC6() {
        int alder = 17;
        boolean isKvinde = false;
        int skadefrieAar = 0;

        Exception thrown = assertThrows(RuntimeException.class, () -> {
            bf.beregnPraemie(alder, isKvinde, skadefrieAar);
        });

        assertEquals("Du er for ung til at tegne en forsikring", thrown.getMessage());
    }

    @Test
    void beregnPraemieTC7() {
        int alder = 18;
        boolean isKvinde = true;
        int skadefrieAar = 3;

        Exception thrown = assertThrows(RuntimeException.class, () -> {
            bf.beregnPraemie(alder, isKvinde, skadefrieAar);
        });

        assertEquals("Du kan ikke have kaert skadefri saelaenge", thrown.getMessage());
    }
}