package com.liang.springioc.beanprocessor;

import java.util.Base64;

public class Base64Example {

    public static void main(String[] args) {
        // 原始字符串
        String originalString = "liang";

        // 使用 Base64 编码
        String encodedString = encodeToBase64(originalString);
        System.out.println("Encoded String: " + encodedString);

        // 使用 Base64 解码
        String decodedString = decodeFromBase64(encodedString);
        System.out.println("Decoded String: " + decodedString);
    }

    /**
     * 将字符串进行 Base64 编码
     */
    public static String encodeToBase64(String input) {
        return Base64.getEncoder().encodeToString(input.getBytes());
    }

    /**
     * 将 Base64 编码的字符串进行解码
     */
    public static String decodeFromBase64(String input) {
        byte[] decodedBytes = Base64.getDecoder().decode(input);
        return new String(decodedBytes);
    }
}
