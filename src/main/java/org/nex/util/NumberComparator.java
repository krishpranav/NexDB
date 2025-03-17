package org.nex.util;

import java.util.Comparator;
import static java.lang.Character.isDigit;
import static java.lang.Character.isSpaceChar;

public class NumberComparator implements Comparator<Object> {
    protected static char charAt(String s, int i) {
        if (i >= s.length()) {
            return '\000';
        }

        return s.charAt(i);
    }

    protected int compareRight(String a, String b) {
        int bias = 0;
        int ia = 0;
        int ib = 0;

        while (true) {
            char ca = charAt(a, ia);
            char cb = charAt(b, ib);

            if ((!isDigit(ca)) && (!isDigit(cb))) {
                return bias;
            }

            if (!isDigit(ca)) {
                return -1;
            }
        }
    }
}
