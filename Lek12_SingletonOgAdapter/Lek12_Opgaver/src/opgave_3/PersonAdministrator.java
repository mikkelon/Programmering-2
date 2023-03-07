package opgave_3;

import java.util.HashSet;
import java.util.Set;

public class PersonAdministrator {
    private static PersonAdministrator instance;
    private Set<Person> set;

    private PersonAdministrator() {
        this.set = new HashSet<>();
    }

    public void add(Person person) {
        set.add(person);
    }

    public void remove(Person person) {
        set.remove(person);
    }

    public Set<Person> getPersons() {
        return new HashSet<>(set);
    }

    public static PersonAdministrator getInstance() {
        if (instance == null)
            instance = new PersonAdministrator();
        return instance;
    }
}
