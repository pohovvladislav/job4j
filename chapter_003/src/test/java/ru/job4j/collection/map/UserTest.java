package ru.job4j.collection.map;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class UserTest {

    @Test
    public void whenCreateMapForSameKey() {
        User user = new User("Sasha", 1, new GregorianCalendar(1990, 1, 1));
        User user1 = new User("Sasha", 1, new GregorianCalendar(1990, 1, 1));
        Map<User, Object> map = new HashMap<>();

        map.put(user, "One");
        map.put(user1, "Two");
        System.out.println(map);
        System.out.println(user.hashCode());
        System.out.println(user1.hashCode());
    }

}