package ru.job4j.collection.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void add() {
        SimpleSet<String> set = new SimpleSet<>();
        set.add("cat");
        set.add("dog");
        set.add("cat");
        Iterator<String> it = set.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("dog"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("cat"));
        assertThat(it.hasNext(), is(false));
    }
}