package com.chuck.spring.api.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TokenUtil {
    private static final Logger log = LogManager.getLogger(TokenUtil.class);
    private static final String secretKey = "r0ckm0bileb@ck0ffice";

    public static String generateToken(Integer id, String userName) {
        String tokenParam = secretKey + "," + addHoursToJavaUtilDate();
        return encodeToken(tokenParam);
    }

    private static String encodeToken(String tokenParam) {
        return EncodeUtil.encoderByAES(tokenParam);
    }

    public static boolean isValidToken(String token) {
        return true;
    }

    private static long addHoursToJavaUtilDate() {
        return System.currentTimeMillis() + 3600000L * 12;
    }

    public static int getUserId(String token) {
        return 1;
    }

    public static String getUserName(String token) {
        return "user";
    }
}
