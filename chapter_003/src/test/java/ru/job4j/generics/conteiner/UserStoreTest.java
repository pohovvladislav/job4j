package ru.job4j.generics.conteiner;

import org.junit.Test;
import ru.job4j.generics.SimpleArray;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

public class UserStoreTest {
    private UserStore userStore = new UserStore(new SimpleArray<>(new User[5]));
    private User user = new User("test");

    @Test
    public void whenAddUser() {
        userStore.add(user);
        assertThat(userStore.findById("test"), is(user));
    }
    @Test
    public void whenReplaceUser() {
        userStore.add(user);
        boolean replace = userStore.replace("test", new User("test_1"));
        assertTrue(replace);
    }
    @Test
    public void whenDeleteUser() {
        userStore.add(user);
        boolean delete = userStore.delete("test");
        assertTrue(delete);
    }
}