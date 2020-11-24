package com.example.navigator.util;

import org.springframework.util.StringUtils;

public class NameUtil {

    public static String namingTrimAndConventions(String name) throws Exception {
        if (null == name) {
            return null;
        }
        String trimName = name.trim();
        if (StringUtils.isEmpty(trimName)) {
            throw new Exception();
        }
        //this.namingConventions(trimName);
        if (!universalNamingConvention(name)) {
            throw new Exception();
        }
        return trimName;
    }

    public static boolean universalNamingConvention(String name) {
        return !name.matches("^.*[/|\\\\\\\\:|\\\\*|\\\\?|\\\"|<|>].*$");
    }
}
