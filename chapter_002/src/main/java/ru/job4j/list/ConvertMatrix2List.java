package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author В-87.
 */
public class ConvertMatrix2List {
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
}
