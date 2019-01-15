package ru.job4j.task;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Тестовое задание: "Отсортировать департаменты".
 */
public class Department {


    public static class Comparator1 implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            int comp = 0;
            int length = o1.length() < o2.length() ? o1.length() : o2.length();
            for (int index = 0; index != length; index++) {
                if (Character.isDigit(o1.toCharArray()[index]) && Character.isDigit(o2.toCharArray()[index])) {
                    comp = o1.toCharArray()[index] - o2.toCharArray()[index];
                    if (comp != 0) {
                        break;
                    }
                }
            }
            if (comp == 0) {
                comp = o1.length() - o2.length();
            }
            return comp;
        }
    }
    public static class Comparator2 implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            int comp = 0;
            int length = o1.length() < o2.length() ? o1.length() : o2.length();
            for (int index = 0; index != length; index++) {
                if (Character.isDigit(o1.toCharArray()[index]) && Character.isDigit(o2.toCharArray()[index])) {
                    comp = o2.toCharArray()[index] - o1.toCharArray()[index];
                    if (comp != 0) {
                        break;
                    }
                }
            }
            if (comp == 0) {
                comp = o1.length() - o2.length();
            }
            return comp;
        }
    }
    /**
     * The method sorts an array of strings.
     * @param department An array of string.
     * @return Sorted array.
     */
    public String[] departmentSort(String[] department, Comparator<String> comparator) {
        Set<String> catalog = new TreeSet<>(comparator);
        for (String unit : department) {
            var temp = unit.split("/");
            String result = "";
            for (String value : temp) {
                result += value;
                catalog.add(result);
            }
        }
        return catalog.toArray(String[]::new);
    }
}
