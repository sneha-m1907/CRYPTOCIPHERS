
public class RailFenceCipher {
    public static String encrypt(String text, int rails) {
        StringBuilder[] rail = new StringBuilder[rails];
        for (int i = 0; i < rails; i++) rail[i] = new StringBuilder();

        int dir = 1, row = 0;
        for (char ch : text.toCharArray()) {
            rail[row].append(ch);
            if (row == 0) dir = 1;
            else if (row == rails - 1) dir = -1;
            row += dir;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rail) result.append(sb);
        return result.toString();
    }

    public static String decrypt(String text, int rails) {
        char[] result = new char[text.length()];
        boolean[][] marker = new boolean[rails][text.length()];
        int dir = 1, row = 0;

        for (int i = 0; i < text.length(); i++) {
            marker[row][i] = true;
            if (row == 0) dir = 1;
            else if (row == rails - 1) dir = -1;
            row += dir;
        }

        int index = 0;
        for (int r = 0; r < rails; r++)
            for (int c = 0; c < text.length(); c++)
                if (marker[r][c]) result[c] = text.charAt(index++);

        StringBuilder plain = new StringBuilder();
        dir = 1;
        row = 0;
        for (int i = 0; i < text.length(); i++) {
            plain.append(result[i]);
            if (row == 0) dir = 1;
            else if (row == rails - 1) dir = -1;
            row += dir;
        }

        return plain.toString();
    }
}
