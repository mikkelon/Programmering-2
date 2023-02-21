package opgave_4;

import java.util.HashMap;

public interface Bag extends Iterable<String>{
    public void add(String s);

    public void remove(String s);

    public int getCount(String s);
}
