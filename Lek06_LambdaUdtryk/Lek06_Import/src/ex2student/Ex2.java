package ex2student;

import java.util.ArrayList;
import java.util.List;

public class Ex2 {

	public static void main(String[] args) {
		List<Runner> runners = new ArrayList<>();
		runners.addAll(List.of(
				new Runner("Ib", 30),
				new Runner("Per", 50),
				new Runner("Ole", 27),
				new Runner("Ulla", 40),
				new Runner("Jens", 35),
				new Runner("Hans", 28)));
		System.out.println(runners);
		System.out.println();

		// a) Udskriv en linje for hver løber med name og lapTime ved at bruge List.forEach()
		// metoden med en Consumer lambda.
		System.out.println("a)");
		runners.forEach(runner -> System.out.println(runner.getName() + ": " + runner.getLapTime() + "s"));
		System.out.println();

		// b) Som a), men udskriv kun løberne med lapTime < 30.
		System.out.println("b)");
		runners.forEach(runner -> opgaveB(runner));
		System.out.println();

		// c) Sorter løberne stigende efter lapTime ved at bruge List.sort() metoden med en
		// Comparator lambda. Udskriv løberne.
		System.out.println("c)");
		runners.sort((r1, r2) -> r1.getLapTime() - r2.getLapTime());
		runners.forEach(runner -> System.out.println(runner.getName() + ": " + runner.getLapTime() + "s"));
		System.out.println();

	}

	private static void opgaveB(Runner runner) {
		if (runner.getLapTime() < 30) {
			System.out.println(runner.getName() + ": " + runner.getLapTime() + "s");
		}
	}

}