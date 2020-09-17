package com.tyy.ss.search.util;


import org.apache.commons.lang.RandomStringUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

//网易加密
public class NeteaseEncryption {
    private final static String MODULUS = "00e0b509f6259df8642dbc35662901477df22677ec152b5ff68ace615bb7" +
            "b725152b3ab17a876aea8a5aa76d2e417629ec4ee341f56135fccf695280" +
            "104e0312ecbda92557c93870114af6c9d05c4f7f0c3685b7a46bee255932" +
            "575cce10b424d813cfe4875d3e82047b97ddef52741d546b8e289dc6935b" +
            "3ece0462db0a22b8e7";   //系数、模数

    private final static String NONCE = "0CoJUm6Qyw8W8jud"; //特定的
    private final static String PUBKEY = "010001";     //公用的key

    private static final String PARAMS = "params";
    private static final String ENCSECKEY = "encSecKey";

    //加密
    public static Map<String, String> encrypt(String text) {
        String secKey = RandomStringUtils.random(16, "0123456789abcde");
        String encText = aesEncrypt(aesEncrypt(text, NONCE), secKey);
        String encSecKey = rsaEncrypt(secKey, PUBKEY, MODULUS);

        Map<String, String> map = new HashMap<String, String>();
        map.put(PARAMS, encText);
        map.put(ENCSECKEY, encSecKey);
        return map;
    }

    //aes加密
    private static String aesEncrypt(String text, String key) {
        try {
            IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(text.getBytes());

            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            return "";
        }
    }

    //rsa加密
    private static String rsaEncrypt(String text, String pubKey, String modulus) {
        text = new StringBuilder(text).reverse().toString();
        BigInteger rs = new BigInteger(String.format("%x", new BigInteger(1, text.getBytes())), 16)
                .modPow(new BigInteger(pubKey, 16), new BigInteger(modulus, 16));
        String r = rs.toString(16);
        if (r.length() >= 256) {
            return r.substring(r.length() - 256, r.length());
        } else {
            while (r.length() < 256) {
                r = 0 + r;
            }
            return r;
        }
    }
}
