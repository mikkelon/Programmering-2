package Opgave_4;

import java.util.Comparator;

public class Kunde implements Comparable<Kunde> {
    private String navn;
    private int nummer;
    private Comparator<Kunde> comparator;
    public Kunde(String navn, int nummer) {
        this.navn = navn;
        this.nummer = nummer;
        this.comparator = new NummerComparator();
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public Comparator<Kunde> getComparator() {
        return comparator;
    }

    public void setComparator(Comparator<Kunde> comparator) {
        this.comparator = comparator;
    }

    @Override
    public String toString() {
        return "#" + nummer + " " + navn;
    }

    @Override
    public int compareTo(Kunde o) {
        return comparator.compare(this, o);
    }
}
