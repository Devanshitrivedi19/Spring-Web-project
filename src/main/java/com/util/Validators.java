package com.util;

public class Validators {

    public static boolean isBlank(String data) {
        return data == null || data.trim().isEmpty();
    }

    public static boolean isAlpha(String data) {
        return data.matches("[a-zA-Z]+");
    }
}
