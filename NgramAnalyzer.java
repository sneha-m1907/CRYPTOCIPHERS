
import java.util.*;

public class NgramAnalyzer {
    public static Map<String, Integer> getNgrams(String text, int n) {
        Map<String, Integer> freq = new HashMap<>();
        text = text.replaceAll("[^A-Za-z]", "").toUpperCase();

        for (int i = 0; i <= text.length() - n; i++) {
            String ngram = text.substring(i, i + n);
            freq.put(ngram, freq.getOrDefault(ngram, 0) + 1);
        }

        return freq;
    }

    public static void printNgramStats(String text, int n) {
        Map<String, Integer> freq = getNgrams(text, n);
        freq.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
