package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// BEGIN
class App {
    public static Map getWordCount(String sentence) {
        Map<String, Integer> hm = new HashMap<>();
        String[] sentenceArr = sentence.split(" ");
        Integer count;
        if (sentence.isEmpty()) {
            return hm;
        }
        for (String word: sentenceArr) {
            if (hm.containsKey(word)) {
                count = hm.get(word) + 1;
            } else {
                count = 1;
            }
            hm.put(word, count);
            System.out.println(word + " " + count);
        }
        return hm;
    }

    public static String toString(Map hm) {
        String result = "";
        if (hm.isEmpty()) {
            return "{}";
        }
        result = result + "{";
        for (Object w: hm.keySet()) {
            result = result + "\n  " + w + ": " + hm.get(w);
        }

        result = result + "\n}";
        return result;
    }
}
//END
