package com.example.navigator.util;

import java.util.UUID;

public class UUIDUtil {
    public static String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
