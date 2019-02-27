package ru.job4j.collection.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MyLinkedListTest {
    private MyLinkedList<String> list;

    @Before
    public void beforeTest() {
         list = new MyLinkedList<>();
        list.add("Volga");
        list.add("Lena");
        list.add("Yenisei");
        list.add("Angara");

    }

    @Test
    public void add() {
        list.add("test");
        assertThat(list.get(0), is("test"));
    }

    @Test
    public void iterator() {
        Iterator<String> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertTrue(iterator.hasNext());
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is("Angara"));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is("Yenisei"));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is("Lena"));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is("Volga"));
        assertFalse(iterator.hasNext());
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenListChangesAfterIteratorIsCreated() {
        Iterator<String> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is("Angara"));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is("Yenisei"));
        list.add("Ob");
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is("Lena"));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is("Volga"));
    }
}