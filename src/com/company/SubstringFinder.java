package com.company;

public class SubstringFinder {

    public static boolean pos(String search, String where) {
        final int SAME_SEQUENCE_LENGTH = 4;

        if (search.length() > where.length()) {
            return false;
        }
        for (int i = 0; i < where.length() - search.length() + 1; i++) {
            if (where.charAt(i) == search.charAt(0)) {
                boolean found = true;
                int count = 0;
                for (int j = i + 1; j < i + search.length(); j++) {
                    if (where.charAt(j) != search.charAt(j - i) && (count < SAME_SEQUENCE_LENGTH)) {
                        found = false;
                        break;
                    }
                    count++;
                }
                if (found) {
                    return true;
                }
            }
        }
        return false;
    }
}