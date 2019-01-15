package ru.job4j.task;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DepartmentTest {
    @Test
    public void whenSortFirstInUp() {
        Department department = new Department();
        String[] units = new String[]{"K1\\SK1", "K2\\SK1", "K1", "K1\\SK1\\SSK1", "K1\\SK2", "K1\\SK1\\SSK2",
                "K2", "K2\\SK1\\SSK2", "K2\\SK1\\SSK1"};
        String[] result = department.departmentSort(units, new Department.Comparator1());
        String[] expect = {
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK2",
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        };
        assertThat(result, is(expect));
    }
    @Test
    public void whenSortLastInUp() {
        Department department = new Department();
        String[] units = new String[]{"K1\\SK1", "K2\\SK1", "K1", "K1\\SK1\\SSK1", "K1\\SK2", "K1\\SK1\\SSK2",
                "K2", "K2\\SK1\\SSK2", "K2\\SK1\\SSK1"};
        String[] result = department.departmentSort(units, new Department.Comparator2());
        String[] expect = {
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1"
        };
        assertThat(result, is(expect));
    }
}