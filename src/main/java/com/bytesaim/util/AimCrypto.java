package com.bytesaim.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * @author Adewale Azeez <azeezadewale98@gmail.com>
 */
public class AimCrypto {

    public static String ConvertToMD5S(String txt) throws NoSuchAlgorithmException {
        byte[] bytesOfMessage = txt.getBytes(StandardCharsets.UTF_8);
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] thedigest = md.digest(bytesOfMessage);
        BigInteger bigInt = new BigInteger(1,thedigest);
        StringBuilder hashtext = new StringBuilder(bigInt.toString(16));
        while(hashtext.length() < 32 ){
            hashtext.insert(0, "0");
        }
        return hashtext.toString();
    }

    public static String GenerateSaltString(int size) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < size) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();
    }

    public static String GenerateRandomChars(String saltChars, int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(saltChars.charAt(random.nextInt(saltChars
                    .length())));
        }
        return sb.toString();
    }

    public static String GenerateRandomChars(int length) {
        return GenerateRandomChars("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890", length);
    }
}
