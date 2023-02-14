package model;

import java.util.Arrays;

public class Nedboer {
    private int[] nedboerPrUge = { 20, 10, 12, 12, 13, 14, 15, 10, 8, 7, 13,
        15, 10, 9, 6, 8, 12, 22, 14, 16, 16, 18, 23, 12, 0, 2, 0, 0, 78, 0,
        0, 0, 34, 12, 34, 23, 23, 12, 44, 23, 12, 34, 22, 22, 22, 22, 18,
        19, 21, 32, 24, 13 };
    
    /**
     * Returnerer ugenummeret for den uge i året, hvor man skal starte ferien,
     * hvis man ønsker den minimale nedbørsmængde i de tre uger
     *
     * @return
     */
    
    public int bedsteTreFerieUger() {
        int mindstNedboer = nedboerPrUge[0] + nedboerPrUge[1] + nedboerPrUge[2];
        int ugenummer = 0;

        for (int i = 3; i < nedboerPrUge.length - 2; i++) {
            int nedboer = nedboerPrUge[i] + nedboerPrUge[i + 1] + nedboerPrUge[i + 2];
            if (nedboer < mindstNedboer) {
                ugenummer = i + 1;
                mindstNedboer = nedboer;
            }
        }

        return ugenummer;
    }
    
    /**
     * Returnerer ugenummeret for den uge i året, hvor man skal starte ferien,
     * hvis man ønsker den minimale nedbørsmængde i det "antal" uger, der er
     * angivet i parameteren
     *
     * @return
     */

    // Tidskompleksitet kan forbedres...
    public int bedsteFerieUgerStart(int antal) {
        int[] mindstNedboer = new int[antal];
        System.arraycopy(nedboerPrUge, 0, mindstNedboer, 0, antal);
        int ugenummer = 0;

        for (int i = 3; i < nedboerPrUge.length - (antal - 1); i++) {
            int[] temp = new int[antal];
            System.arraycopy(nedboerPrUge, i, temp, 0, temp.length);
            int nedboer = Arrays.stream(temp).sum();

            if (nedboer < Arrays.stream(mindstNedboer).sum()) {
                ugenummer = i + 1;
                mindstNedboer = temp.clone();
            }
        }

        return ugenummer;
    }
    
    /**
     * Returnerer ugenummeret på den første uge hvor nedbøren har været præcis
     * den samme flest uger i træk
     *
     * @return
     */
    public int ensNedboer() {
        int highestCount = 0;
        int ugenr = 0;
        int lastIndex = nedboerPrUge.length - 1;
        int count;

        int i = 0;
        while (i < lastIndex - highestCount) {
            count = 0;
            while (nedboerPrUge[i] == nedboerPrUge[i + count + 1]) {
                count++;
            }
            if (highestCount < count) {
                highestCount = count;
                ugenr = i + 1; // +1 for at finde ugenr i stedet for index
            }
            if (count <= 1) i++;
            else i += count - 1;
        }
        return ugenr;
    }

    public  int ensNedboer2() {
        int[] arr = nedboerPrUge;
        int maxLength = 0;
        int maxIndex = 0;
        int currentLength = 0;
        int currentIndex = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                currentLength++;
                if (currentLength == 1) {
                    currentIndex = i;
                }
            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    maxIndex = currentIndex;
                }
                currentLength = 0;
            }
        }

        return maxIndex + 1; // +1 for at finde ugenr i stedet for index
    }

}
