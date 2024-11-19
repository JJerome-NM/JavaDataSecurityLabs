package dev.jjerome.javadatasecutitylabs.lab5;

public class VigenereCipher {
    public static String cleanText(String text, String alphabet) {
        return text.chars()
                .filter(c -> alphabet.indexOf(c) != -1)
                .mapToObj(c -> String.valueOf((char) c))
                .reduce("", String::concat);
    }

    public static String encrypt(String text, String key, String alphabet) {
        StringBuilder encrypted = new StringBuilder();
        key = key.repeat((text.length() / key.length()) + 1).substring(0, text.length());

        for (int i = 0; i < text.length(); i++) {
            int textIndex = alphabet.indexOf(text.charAt(i));
            int keyIndex = alphabet.indexOf(key.charAt(i));
            encrypted.append(alphabet.charAt((textIndex + keyIndex) % alphabet.length()));
        }
        return encrypted.toString();
    }

    public static String decrypt(String text, String key, String alphabet) {
        StringBuilder decrypted = new StringBuilder();
        key = key.repeat((text.length() / key.length()) + 1).substring(0, text.length());

        for (int i = 0; i < text.length(); i++) {
            int textIndex = alphabet.indexOf(text.charAt(i));
            int keyIndex = alphabet.indexOf(key.charAt(i));
            decrypted.append(alphabet.charAt((textIndex - keyIndex + alphabet.length()) % alphabet.length()));
        }
        return decrypted.toString();
    }

    public static void main(String[] args) {
        String alphabet = "абвгґдеєжзийклмнопрстуфхцчшщьюя";
        String text = "криптографічніметодизахистуінформації".toLowerCase();
        String key = "Халабарчук".toLowerCase();

        text = cleanText(text, alphabet);
        key = cleanText(key, alphabet);

        String encrypted = encrypt(text, key, alphabet);
        String decrypted = decrypt(encrypted, key, alphabet);

        System.out.println("Cleaned Text: " + text);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}
