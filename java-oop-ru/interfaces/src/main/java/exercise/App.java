package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> homes, Integer n) {
//        if (homes.isEmpty()) {
//            return new ArrayList<>();
//        }
//        Collections.sort(homes, new Comparator<Home>() {
//            @Override
//            public int compare(Home o1, Home o2) {
//                return (int) (o1.getArea() - o2.getArea());
//            }
//        });
//        List<String> result = new ArrayList<>();
//        for (var i = 0; i < n; i++) {
//            result.add(homes.get(i).toString());
//        }
//        return result;
        return homes.stream()
                .sorted(Home::compareTo)
                .limit(n)
                .map(home -> home.toString())
                .collect(Collectors.toList());
    }
}
// END
