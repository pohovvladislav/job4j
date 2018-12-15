package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.core.Is.is;
/**
 * The test of  program UserConvert.
 */
public class UserConvertTest {
    UserConvert convert = new UserConvert();
    ArrayList<User> list = new ArrayList<>();
    @Test
    public void whenUsersOfArrayListThenUsersOfHashMap() {
        list.add(new User(1, "Ivan", 30,"Kuibyshev"));
        HashMap<Integer, User> result = convert.process(list);
        assertTrue(result.containsKey(1));
    }
    @Test
    public void whenUsersOfArrayListThenTreeSetUsersSortOfAge() {
        list.addAll(Arrays.asList(
                new User(1, "Ivan", 30,"Kuibyshev"),
                new User(4, "Valera", 32,"Leningrad"),
                new User(7, "Egor", 27,"Vladivostok")));
        TreeSet<User> result = convert.sort(list);
        assertThat(result.first().getName(), is("Egor"));
    }
}
