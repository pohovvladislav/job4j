package ru.job4j.array;

/**
 *
 */
public class SumTwoArraySort {
    /**
     *
     * @param arraySortFirst
     * @param arraySortSecond
     * @return
     */
    public int[] sumArray(int[] arraySortFirst, int[] arraySortSecond) {
        int[] newArray = new int[arraySortFirst.length + arraySortSecond.length];
        for (int i = 0; i < arraySortFirst.length; i++) {
            if (arraySortFirst[i] < arraySortSecond[i]) {
                newArray[i * 2] = arraySortFirst[i];
                newArray[i * 2 + 1] = arraySortSecond[i];
            } else {
                newArray[i * 2] = arraySortSecond[i];
                newArray[i * 2 + 1] = arraySortFirst[i];
            }
        }
        return newArray;
    }
}