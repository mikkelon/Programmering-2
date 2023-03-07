package opgave_3;

public class AnvendPersonAdministrator {
    public static void main(String[] args) {
        PersonAdministrator pa = PersonAdministrator.getInstance();
        Person p1 = new Person("Jens", 19);
        pa.add(p1);
        pa = PersonAdministrator.getInstance();
        System.out.println(pa.getPersons());
    }
}
