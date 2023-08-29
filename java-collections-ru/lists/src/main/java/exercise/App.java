package exercise;


import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String str, String word) {
        String[] strSplit = str.split("");
        List<String> strList = new ArrayList<>(Arrays.asList(strSplit));
        if (strList.isEmpty()) {
            return false;
        }
        for (var i = 0; i < word.length(); i++) {
            String symbol = String.valueOf(word.toLowerCase().charAt(i));
            if (!strList.contains(symbol)) {
                return false;
            }
            strList.remove(symbol);
        }
        return true;
    }
}
//END
