package org.nex.util;

public final class KeyWordUtil {

    private static final String[] KEY_WORDS = new String[] {};

    private KeyWordUtil() { }

    public static boolean isKeyword(String word) {
        if (null == word) {
            return false;
        }

        for (String keyWord : KEY_WORDS) {
            if (keyWord.equals(word)) {
                return true;
            }
        }

        return false;
    }
}
