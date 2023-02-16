package ex1student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Ex1 {

	public static void main(String[] args) {
		List<Person> list = List.of(
				new Person("Bent", 25), new Person("Susan", 34),
				new Person("Mikael", 60), new Person("Klaus", 44),
				new Person("Birgitte", 17), new Person("Liselotte", 9));
		List<Person> persons = new ArrayList<Person>(list);
		System.out.println(persons);
		System.out.println();



//		Den første person der hedder Klaus
//		System.out.println(findFirst(persons, p -> p.getName().equals("Klaus")));
//		Den første person der har et navn med længden 4
//		System.out.println(findFirst(persons, p -> p.getName().length() ==4 ));

//		Indsæt kode herunder der kalder metoderne findFirst og findAll som beskrevet i opgave 1

		// a) Finder den første person i listen af personer med alderen 44.
		System.out.print("a) ");
		System.out.println(findFirst(list, p -> p.getAge() == 44));

		// b) Finder den første person i listen af personer med et navn der starter med 'S'.
		System.out.print("b) ");
		System.out.println(findFirst(list, p -> p.getName().charAt(0) == 'S'));

		// c) Finder den første person i listen af personer med et navn der indeholder mere end et ’i’.
		System.out.print("c) ");
//		System.out.println(findFirst(list, p -> {
//			String name = p.getName().toLowerCase();
//			int count = 0;
//			for (int i = 0; i < name.length(); i++) {
//				if (name.charAt(i) == 'i') count++;
//				if (count > 1) return true;
//			}
//			return false;
//		}));
		System.out.println(findFirst(list, p  -> p.getName().indexOf('i') != p.getName().lastIndexOf('i')));

		// d) Finder den første person i listen af personer med en alder der er lig længden af navnet.
		System.out.print("d) ");
		System.out.println(findFirst(list, p -> p.getAge() == p.getName().length()));

		// f) Find alle personer der har et navn der indeholder bogstavet 'i'.
		System.out.print("f) ");
		System.out.println(findAll(list, p -> p.getName().contains("i")));

		// g) Find alle personer der har et navn der starter med 'S'.
		System.out.print("g) ");
		System.out.println(findAll(list, p -> p.getName().charAt(0) == 'S'));

		// h) Find alle personer der har et navn der med længde 5.
		System.out.print("h) ");
		System.out.println(findAll(list, p -> p.getName().length() == 5));

		// i) Find alle personer der har et navn der med længde mindst 6 og alder under 40.
		System.out.print("i) ");
		System.out.println(findAll(list, p -> p.getName().length() >= 6 || p.getName().length() < 40));
	}

	/**
	 * Returns from the list the first person
	 * that satisfies the predicate.
	 * Returns null, if no person satisfies the predicate.
	 */
	public static Person findFirst(List<Person> list, Predicate<Person> filter) {
		for (Person p : list) {
			if (filter.test(p))
				return p;
		}
		return null;
	}

	// e) Programmer en findAll()methode. Metodens signatur og implementation skal passe
	// til et kald svarende til
	public static ArrayList<Person> findAll(List<Person> people, Predicate<Person> filter) {
		ArrayList<Person> list = new ArrayList<>();
		for (Person p : people) {
			if (filter.test(p)) list.add(p);
		}
		return list;
	}
}
