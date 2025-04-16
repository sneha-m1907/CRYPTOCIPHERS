
public class BeaufortCipher {
    public static String encrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        text = text.toUpperCase().replaceAll("[^A-Z]", "");
        key = key.toUpperCase().replaceAll("[^A-Z]", "");

        for (int i = 0; i < text.length(); i++) {
            char t = text.charAt(i);
            char k = key.charAt(i % key.length());
            char c = (char) ((k - t + 26) % 26 + 'A');
            result.append(c);
        }

        return result.toString();
    }

    public static String decrypt(String text, String key) {
        return encrypt(text, key); // Beaufort is reciprocal
    }
}
