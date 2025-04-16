
public class AffineCipher {
    static int a_inv(int a, int m) {
        a = a % m;
        for (int x = 1; x < m; x++)
            if ((a * x) % m == 1)
                return x;
        return -1;
    }

    public static String encrypt(String text, int a, int b) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                result.append((char) ((a * (ch - base) + b) % 26 + base));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static String decrypt(String text, int a, int b) {
        int a_inv = a_inv(a, 26);
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                int decrypted = (a_inv * ((ch - base - b + 26)) % 26);
                result.append((char) (decrypted + base));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
