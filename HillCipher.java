
public class HillCipher {
    public static String encrypt(String text, int[][] keyMatrix) {
        text = text.replaceAll("[^A-Za-z]", "").toUpperCase();
        if (text.length() % 2 != 0) text += "X";

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i += 2) {
            int[] vector = {
                text.charAt(i) - 'A',
                text.charAt(i + 1) - 'A'
            };

            int c1 = (keyMatrix[0][0] * vector[0] + keyMatrix[0][1] * vector[1]) % 26;
            int c2 = (keyMatrix[1][0] * vector[0] + keyMatrix[1][1] * vector[1]) % 26;

            result.append((char) (c1 + 'A')).append((char) (c2 + 'A'));
        }
        return result.toString();
    }

    public static String decrypt(String text, int[][] keyMatrix) {
        int det = keyMatrix[0][0] * keyMatrix[1][1] - keyMatrix[0][1] * keyMatrix[1][0];
        det = ((det % 26) + 26) % 26;
        int invDet = -1;
        for (int i = 1; i < 26; i++) {
            if ((det * i) % 26 == 1) {
                invDet = i;
                break;
            }
        }

        int[][] invMatrix = {
            { keyMatrix[1][1] * invDet % 26, -keyMatrix[0][1] * invDet % 26 },
            { -keyMatrix[1][0] * invDet % 26, keyMatrix[0][0] * invDet % 26 }
        };

        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                invMatrix[i][j] = (invMatrix[i][j] + 26) % 26;

        return encrypt(text, invMatrix);
    }
}
