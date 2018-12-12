package ru.job4j.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author В-87.
 */
public class ConvertList {
    /**
     * The method converts from ArrayList to Array.
     * @param list ArrayList.
     * @param rows Rows of array.
     * @return Array.
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

    /**
     * The method converts array to ArrayList.
     * @param array Array.
     * @return List.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] rows : array) {
            for (int cells : rows) {
                list.add(cells);
            }
        }
        return list;
    }

    /**
     * The method converts List of array to List of Integer.
     * @param list List of array.
     * @return List of Integer.
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        Iterator<int[]> it = list.iterator();
        while (it.hasNext()) {
            for (int value : it.next()) {
                result.add(value);
            }
        }
        return result;
    }
}
