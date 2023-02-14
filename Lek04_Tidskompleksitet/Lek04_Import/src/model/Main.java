package model;

public class Main {
    public static void main(String[] args) {
        Nedboer nedboer = new Nedboer();
        System.out.println(nedboer.bedsteTreFerieUger());
        System.out.println(nedboer.bedsteFerieUgerStart(3));
        System.out.println(nedboer.bedsteFerieUgerStart(4));
        System.out.println(nedboer.ensNedboer());
        System.out.println(nedboer.ensNedboer2());
    }
}
