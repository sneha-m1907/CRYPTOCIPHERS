public class AugustCipher {

    // Encrypts text by shifting each letter by 1
    public static String encrypt(String text) {
        StringBuilder result = new StringBuilder();

        for (char ch : text.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                result.append((char) ((ch - 'A' + 1) % 26 + 'A'));
            } else if (Character.isLowerCase(ch)) {
                result.append((char) ((ch - 'a' + 1) % 26 + 'a'));
            } else {
                result.append(ch); // leave non-alphabet characters unchanged
            }
        }

        return result.toString();
    }

    // Decrypts text by shifting each letter back by 1
    public static String decrypt(String text) {
        StringBuilder result = new StringBuilder();

        for (char ch : text.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                result.append((char) ((ch - 'A' - 1 + 26) % 26 + 'A'));
            } else if (Character.isLowerCase(ch)) {
                result.append((char) ((ch - 'a' - 1 + 26) % 26 + 'a'));
            } else {
                result.append(ch); // leave non-alphabet characters unchanged
            }
        }

        return result.toString();
    }

    // Example usage
    public static void main(String[] args) {
        String original = "Hello World!";
        String encrypted = encrypt(original);
        String decrypted = decrypt(encrypted);

        System.out.println("Original : " + original);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}
