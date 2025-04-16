
import java.util.*;

public class MyszkowskiCipher {
    public static String encrypt(String text, String key) {
        text = text.replaceAll("\s+", "").toUpperCase();
        int cols = key.length();
        int rows = (int) Math.ceil((double) text.length() / cols);
        char[][] grid = new char[rows][cols];
        int index = 0;

        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                grid[r][c] = index < text.length() ? text.charAt(index++) : 'X';

        Map<Character, List<Integer>> keyMap = new TreeMap<>();
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            keyMap.putIfAbsent(ch, new ArrayList<>());
            keyMap.get(ch).add(i);
        }

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, List<Integer>> entry : keyMap.entrySet())
            for (int col : entry.getValue())
                for (int row = 0; row < rows; row++)
                    result.append(grid[row][col]);

        return result.toString();
    }
}
