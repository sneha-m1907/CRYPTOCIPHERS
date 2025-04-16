
public class VigenereCipher {
    public static String encrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        key = key.toLowerCase();
        int keyIndex = 0;

        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                int shift = key.charAt(keyIndex % key.length()) - 'a';
                result.append((char) ((ch - base + shift) % 26 + base));
                keyIndex++;
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static String decrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        key = key.toLowerCase();
        int keyIndex = 0;

        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                int shift = key.charAt(keyIndex % key.length()) - 'a';
                result.append((char) ((ch - base - shift + 26) % 26 + base));
                keyIndex++;
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
