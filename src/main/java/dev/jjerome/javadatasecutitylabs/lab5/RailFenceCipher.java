package dev.jjerome.javadatasecutitylabs.lab5;

public class RailFenceCipher {
    public static String encrypt(String text) {
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (i % 2 == 0) {
                odd.append(text.charAt(i));
            } else {
                even.append(text.charAt(i));
            }
        }
        return odd.append(even).toString();
    }

    public static String decrypt(String text) {
        int half = (text.length() + 1) / 2;
        String odd = text.substring(0, half);
        String even = text.substring(half);
        StringBuilder decrypted = new StringBuilder();

        for (int i = 0; i < even.length(); i++) {
            decrypted.append(odd.charAt(i)).append(even.charAt(i));
        }
        if (odd.length() > even.length()) {
            decrypted.append(odd.charAt(odd.length() - 1));
        }
        return decrypted.toString();
    }

    public static void main(String[] args) {
        String text = "криптографія";
        String encrypted = encrypt(text);
        String decrypted = decrypt(encrypted);

        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}
