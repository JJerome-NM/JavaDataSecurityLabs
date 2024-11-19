package dev.jjerome.javadatasecutitylabs.lab5;

public class CaesarCipher {
    public static void bruteForce(String cipherText) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int shift = 0; shift < 26; shift++) {
            StringBuilder decrypted = new StringBuilder();
            for (char c : cipherText.toCharArray()) {
                if (alphabet.indexOf(c) != -1) {
                    int index = (alphabet.indexOf(c) - shift + 26) % 26;
                    decrypted.append(alphabet.charAt(index));
                } else {
                    decrypted.append(c);
                }
            }
            System.out.println("Shift " + shift + ": " + decrypted);
        }
    }

    public static void main(String[] args) {
        String cipherText = "vppanlwxlyopyncjae";
        bruteForce(cipherText);
    }
}
