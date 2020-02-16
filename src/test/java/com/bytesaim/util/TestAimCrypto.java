package com.bytesaim.util;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * @author Adewale Azeez <azeezadewale98@gmail.com>
 */
public class TestAimCrypto {

    @Test
    public void Test1() {
        for (int i = 0; i < 10; i++) {
            System.out.println(AimCrypto.GenerateSaltString(20));
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(AimCrypto.GenerateSaltString(40));
        }
    }

    @Test
    public void Test2() throws NoSuchAlgorithmException {
        ArrayList<String> testStrings = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            testStrings.add(AimCrypto.GenerateRandomChars(10));
        }
        for (String testString : testStrings) {
            System.out.println(AimCrypto.ConvertToMD5S(testString));
        }
    }

    @Test
    public void Test3() {
        for (int i = 0; i < 20; i++) {
            System.out.println(AimCrypto.GenerateRandomChars(i));
        }
    }

    @Test
    public void Test4() {
        for (int i = 0; i < 20; i++) {
            System.out.println(AimCrypto.GenerateRandomChars("avc7565hjwgehwgth", i));
        }
    }

}
