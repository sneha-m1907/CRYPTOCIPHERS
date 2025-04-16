
public class RunningKeyCipher {
    public static String encrypt(String plaintext, String runningKey) {
        StringBuilder result = new StringBuilder();
        plaintext = plaintext.toUpperCase().replaceAll("[^A-Z]", "");
        runningKey = runningKey.toUpperCase().replaceAll("[^A-Z]", "");

        for (int i = 0; i < plaintext.length(); i++) {
            char p = plaintext.charAt(i);
            char k = runningKey.charAt(i);
            result.append((char) ((p - 'A' + k - 'A') % 26 + 'A'));
        }
        return result.toString();
    }

    public static String decrypt(String ciphertext, String runningKey) {
        StringBuilder result = new StringBuilder();
        ciphertext = ciphertext.toUpperCase().replaceAll("[^A-Z]", "");
        runningKey = runningKey.toUpperCase().replaceAll("[^A-Z]", "");

        for (int i = 0; i < ciphertext.length(); i++) {
            char c = ciphertext.charAt(i);
            char k = runningKey.charAt(i);
            result.append((char) ((c - k + 26) % 26 + 'A'));
        }
        return result.toString();
    }
}
