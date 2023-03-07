package opgave_4;

import java.util.HashMap;

public interface Bag extends Iterable<String>{
    void add(String s);

    void remove(String s);

    int getCount(String s);
}
