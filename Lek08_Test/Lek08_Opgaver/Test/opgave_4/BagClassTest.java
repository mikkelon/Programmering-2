package opgave_4;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class BagClassTest {
    private Bag bag = new BagClass();

    @Test
    void add() {
        assertEquals(0, bag.getCount("A"));
        bag.add("A");
        assertEquals(1, bag.getCount("A"));
        bag.add("A");
        assertEquals(2, bag.getCount("A"));
        bag.add("B");
        assertEquals(1, bag.getCount("B"));
    }

    @Test
    void remove() {
        bag.add("A");
        bag.add("A");
        bag.add("B");
        bag.remove("A");
        assertEquals(1, bag.getCount("A"));
        bag.remove("B");
        assertEquals(0, bag.getCount("B"));
        bag.remove("C");
        assertEquals(0, bag.getCount("C"));
    }

    @Test
    void getCount() {
        bag.add("A");
        bag.add("A");
        bag.add("B");
        assertEquals(2, bag.getCount("A"));
        assertEquals(1, bag.getCount("B"));
        assertEquals(0, bag.getCount("C"));
    }

    @Test
    void iterator() {
        bag.add("A");
        bag.add("A");
        bag.add("B");
        bag.add("C");
        bag.add("C");
        bag.add("C");
        LinkedList<String> list = new LinkedList<>();
        for (String s : bag) {
            list.add(s);
        }
        assertEquals(3, list.size());
        assertTrue(list.contains("A"));
        assertTrue(list.contains("B"));
        assertTrue(list.contains("C"));
    }
}