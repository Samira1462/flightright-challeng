package com.flightright.codechallenge.util;

public final class StringUtils {

    private StringUtils() {
    }

    public static boolean isBlank(String entry) {
        return entry == null || entry.isEmpty();
    }
}
