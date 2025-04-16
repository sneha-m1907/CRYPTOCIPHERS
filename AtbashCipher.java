public class AtbashCipher {
    public static String encrypt(String text) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                result.append((char) ('Z' - (ch - 'A')));
            } else if (Character.isLowerCase(ch)) {
                result.append((char) ('z' - (ch - 'a')));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
