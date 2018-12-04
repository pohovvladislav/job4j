package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * The class realises the conversion from ArrayList to Array.
 */
public class ConvertList2Array {
    /**
     * The method converts from ArrayList to Array.
     * @param list ArrayList.
     * @param rows rows of array.
     * @return array.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil((double)list.size() / rows);
        int[][] array = new int[rows][cells];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cells; j++) {
                for (int u = count; u < list.size(); u++) {
                    array[i][j] = list.get(u);
                    break;
                }
                count++;
            }
        }
        return array;
    }
}
