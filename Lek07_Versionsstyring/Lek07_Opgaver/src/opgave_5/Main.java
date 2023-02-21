package opgave_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        File file = new File("Lek07_Versionsstyring/Lek07_Opgaver/src/opgave_5/Gjøngehøvdingen.txt");

        // #--- OPGAVE 5.A ---#

        // Indsæt alle ord i et set
        Set<String> set = new TreeSet<>(); // TreeSet gør at ordene kommer i alfabetisk rækkefølge.
//        readFileSet(file, set); // Metoden printer også alle ordene og udskriver antallet af ord.

        // #--- OPGAVE 5.B ---#

        // Indsæt alle ord i et map
        Map<String, Integer> map = new TreeMap<>();
        readFileToMap(file, map);

        // Udskriver alle ord og hvor mange gange de forekommer.
        // Hvis mappet er et TreeMap kommer de ud i alfabetisk rækkefølge.
//        for (String s : map.keySet()) {
//            System.out.println(s + " " + map.get(s));
//        }

        // #--- OPGAVE 5.C ---#

        // # Metode 1 #
//        // Laver en LinkedList med alle entries i mappet
//        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
//
//        // Sorter listen efter værdierne i mappet
//        // Her anvendes Map.Entry.comparingByValue() som er en statisk metode i Map.Entry, der returnerer en Comparator.
//        list.sort(Map.Entry.comparingByValue());
//
//        // Laver en iterator til listen og placerer den på slutningen af listen.
//        ListIterator<Map.Entry<String, Integer>> iterator = list.listIterator(list.size());
//
//        // Itererer igennem listen baglæns og udskriver alle ord og antal forekomster.
//        while (iterator.hasPrevious()) {
//            Map.Entry<String, Integer> entry = iterator.previous();
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }

        // # Metode 2 # ( fungerer ikk :-( )
        // Laver et nyt TreeMap, der tager en Comparator
        Map<String, Integer> valueMap = new TreeMap<>((e1, e2) -> {
            // Sammenligner values i stedet for keys
            return map.get(e1) - map.get(e2);
        });

        readFileToMap(file, valueMap);

        for (String s : valueMap.keySet()) {
            System.out.println(s + " " + valueMap.get(s));
        }


    }

    public static void readFileToSet(File file, Set<String> set) {
        try (Scanner scanner = new Scanner(file)) {
            int count = 0;
            while (scanner.hasNext()) {
                set.add(scanner.next());
                count++;
            }
            for (String s : set) {
                System.out.println(s);
            }
            System.out.println("Antal ord: " + count);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readFileToMap(File file, Map<String, Integer> map) {
        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNext()) {
                String word = scanner.next();
                // Fjern særlige symboler fra ordet
                word = word.replaceAll("[^a-zA-ZæøåÆØÅ]", "");

                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());;
        }
    }
}
