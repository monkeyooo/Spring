package com.chuck.spring.api.utils;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.ArrayUtils;

import javax.crypto.*;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Arrays;

public class EncodeUtil {
    private static final String aesPassword = "rmc20200525";

    public static String convertPassword(String passwordFromUser) {
        String convertPw = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(passwordFromUser.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = messageDigest.digest();

            StringBuilder stringBuilder = new StringBuilder();
            Byte[] encodeBytes = ArrayUtils.toObject(bytes);
            Arrays.asList(encodeBytes).forEach(aByte -> stringBuilder.append(String.format("%02x",aByte)));

            convertPw = stringBuilder.toString();
            return convertPw;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encoderByAES(String password){
        String encodeString = null;

        try {
            Cipher cipher = Cipher.getInstance("AES");

            cipher.init(Cipher.ENCRYPT_MODE,genKey(aesPassword));

            byte[] bytes = cipher.doFinal(password.getBytes(StandardCharsets.UTF_8));

            Byte[] encodeBytes = ArrayUtils.toObject(bytes);
            StringBuilder stringBuilder = new StringBuilder();

            Arrays.asList(encodeBytes).forEach(aByte -> stringBuilder.append(String.format("%02x",aByte)));

            encodeString = stringBuilder.toString();

        } catch (NoSuchAlgorithmException | IllegalBlockSizeException | NoSuchPaddingException | InvalidKeyException | BadPaddingException e) {
            e.printStackTrace();
        }

        return encodeString;
    }

    public String decoderByAES(String encodePassword){
        String decodeString = null;

        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE,genKey(aesPassword));

            byte[] encodebytes = Hex.decodeHex(encodePassword);

            byte[] bytes = cipher.doFinal(encodebytes);

            decodeString = new String(bytes);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException | DecoderException e) {
            e.printStackTrace();
        }

        return decodeString;
    }

    private static Key genKey(String aesPassword){

        Key key = null;

        try {
            KeyGenerator generator = KeyGenerator.getInstance("AES");

            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(aesPassword.getBytes(StandardCharsets.UTF_8));

            generator.init(secureRandom);

            key = generator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return key;
    }

}
