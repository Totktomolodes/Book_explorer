package com.example.myapplication.user_managment;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TextToHash {

    public static String textToHash(String text) {
        try {
            // Создаем объект MessageDigest с использованием алгоритма SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Преобразуем текст в массив байт
            byte[] hashBytes = digest.digest(text.getBytes());

            // Преобразуем массив байт в строку HEX формата
            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String textFromHash(String text){
        return null; //TODO
    }


}
