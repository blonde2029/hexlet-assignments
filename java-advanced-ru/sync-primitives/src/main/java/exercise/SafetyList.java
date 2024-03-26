package exercise;

import java.util.ArrayList;
import java.util.List;

class SafetyList {
    // BEGIN
    private List<Integer> list = new ArrayList<>();
    public synchronized   void add(Integer number) {
        list.add(number);
    }

    public  Integer get(Integer number) {
        return list.get(number);
    }

    public  Integer getSize() {
        return list.size();
    }
    // END
}
