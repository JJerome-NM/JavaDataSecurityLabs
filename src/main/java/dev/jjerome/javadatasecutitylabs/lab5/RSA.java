package dev.jjerome.javadatasecutitylabs.lab5;

import java.math.BigInteger;
import java.util.Random;

public class RSA {
    public static BigInteger generatePrime(int bitLength) {
        return BigInteger.probablePrime(bitLength, new Random());
    }

    public static BigInteger gcd(BigInteger a, BigInteger b) {
        return b.equals(BigInteger.ZERO) ? a : gcd(b, a.mod(b));
    }

    public static void main(String[] args) {
        BigInteger p = generatePrime(8);
        BigInteger q = generatePrime(8);
        BigInteger n = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        BigInteger e = BigInteger.valueOf(3);
        while (!gcd(e, phi).equals(BigInteger.ONE)) {
            e = e.add(BigInteger.TWO);
        }

        BigInteger d = e.modInverse(phi);

        BigInteger message = BigInteger.valueOf(100);
        BigInteger encrypted = message.modPow(e, n);
        BigInteger decrypted = encrypted.modPow(d, n);

        System.out.println("Primes: p = " + p + ", q = " + q);
        System.out.println("Public Key: (e = " + e + ", n = " + n + ")");
        System.out.println("Private Key: (d = " + d + ", n = " + n + ")");
        System.out.println("Original Message: " + message);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}
