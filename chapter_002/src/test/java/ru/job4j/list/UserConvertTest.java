package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;

/**
 * The test of  program UserConvert.
 */
public class UserConvertTest {
    @Test
    public void when3UsersOfArrayListThenUsersOfHashMap() {
        UserConvert convert = new UserConvert();
        ArrayList<User> list = new ArrayList<>();
        list.add(new User(1, "Ivan", "Kuibyshev"));
        HashMap<Integer, User> result = convert.process(list);
        assertTrue(result.containsKey(1));
    }
}
