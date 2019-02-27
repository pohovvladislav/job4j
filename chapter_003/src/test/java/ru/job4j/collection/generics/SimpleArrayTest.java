package ru.job4j.collection.generics;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test
    public void whenAddElementToArray() {
        SimpleArray<Boolean> simpleArray = new SimpleArray<>(new Boolean[5]);
        simpleArray.add(true);
        assertThat(simpleArray.get(0), is(true));
    }

    @Test
    public void whenSetElementToArray() {
        SimpleArray<String> simpleArray = new SimpleArray<>(new String[10]);
        simpleArray.add("hi");
        simpleArray.set(0, "hello");
        assertThat(simpleArray.get(0), is("hello"));
    }

    @Test
    public void whenRemoveElement() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(new Integer[10]);
        simpleArray.add(3);
        simpleArray.add(7);
        simpleArray.add(6);
        simpleArray.remove(0);
        assertThat(simpleArray.get(1), is(6));
    }

    @Test
    public void whenIteratorRun() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(new Integer[5]);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(1);
        Iterator<Integer> iterator = simpleArray.iterator();
        assertTrue(iterator.hasNext());
        assertTrue(iterator.hasNext());
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(2));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(3));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(1));
        assertFalse(iterator.hasNext());
    }
}