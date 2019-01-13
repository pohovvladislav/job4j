package ru.job4j.list;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.core.Is.is;
/**
 * The test of  program UserConvert.
 */

public class UserConvertTest {
    UserConvert convert = new UserConvert();
    List<User> list = List.of(
            new User(1, "Nikolai", 30, "Kuibyshev"),
            new User(4, "Valera", 32, "Leningrad"),
            new User(7, "Egor", 27, "Vladivostok"),
            new User(11, "Nikolai", 29, "Minsk")
    );
    @Test
    public void whenUsersOfArrayListThenUsersOfHashMap() {
        HashMap<Integer, User> result = convert.process(list);
        assertTrue(result.containsKey(1));
    }
    @Test
    public void whenUsersOfArrayListThenTreeSetUsersSortOfAge() {
        TreeSet<User> result = convert.sort(list);
        assertThat(result.first().getName(), is("Egor"));
    }
    @Test
    public void whenAddUsersByArrayListThanSortByNameLength() {
        List<User> result = convert.sortNameLength(list);
        assertThat(result.get(0).getName(), is("Egor"));
    }
    @Test
    public void whenAddUsersByArrayListThanSortByAllFields() {
        List<User> result = convert.sortByAllFields(list);
        assertThat(result.get(2).getName() + result.get(2).getAge(), is("Nikolai" + 30));
    }
}
