package ru.job4j.comparator;

import java.util.Comparator;

/**
 * @author В-87.
 */
public class ListCompare implements Comparator<String> {
    /**
     * The method of implementing a comparator for strings.
     * @param o1 The array of characters.
     * @param o2 The array of characters.
     * @return Comparison result.
     */
    @Override
    public int compare(String o1, String o2) {
        int cmpO1 = 0, cmpO2 = 0;
        int length = o1.length() < o2.length() ? o1.length() : o2.length();
        for (int i = 0; i != length; i++) {
            int cmp = Integer.compare(o1.charAt(i), o2.charAt(i));
            if (cmp == 1) {
                cmpO1++;
            } else if (cmp == -1) {
                cmpO2++;
            }
        }
        return cmpO1 > cmpO2 ? 1 : cmpO2 == cmpO1 && o1.length() == o2.length() ? 0 : -1;
    }
}
