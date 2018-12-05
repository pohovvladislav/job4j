package ru.job4j.list;

import java.util.List;

/**
 * @author В-87.
 */
public class ConvertList2Array {
    /**
     * The method converts from ArrayList to Array.
     * @param list ArrayList.
     * @param rows rows of array.
     * @return array.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil((double) list.size() / rows);
        int[][] array = new int[rows][cells];
        int i = 0, j = 0;
        for (Integer value : list) {
            array[i][j] = value;
            j++;
            if (j == cells) {
                j = 0;
                i++;
            }
        }
        return array;
    }
}
