
public class RouteCipher {
    public static String encrypt(String text, int rows, int cols) {
        char[][] grid = new char[rows][cols];
        int idx = 0;
        text = text.replaceAll("\s+", "").toUpperCase();
        while (text.length() < rows * cols) text += "X";

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                grid[i][j] = text.charAt(idx++);

        StringBuilder result = new StringBuilder();
        for (int col = 0; col < cols; col++)
            for (int row = 0; row < rows; row++)
                result.append(grid[row][col]);

        return result.toString();
    }

    public static String decrypt(String cipher, int rows, int cols) {
        char[][] grid = new char[rows][cols];
        int idx = 0;

        for (int col = 0; col < cols; col++)
            for (int row = 0; row < rows; row++)
                grid[row][col] = cipher.charAt(idx++);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result.append(grid[i][j]);

        return result.toString();
    }
}
