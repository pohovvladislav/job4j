package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class MyArrayListTest {

    private MyArrayList<Integer> arrayList;

    @Before
    public void beforeTest() {
        arrayList = new MyArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
    }
    @Test
    public void add() {
        arrayList.add(3);
        Object result = arrayList.get(2);
        assertThat(result, is(3));
    }

    @Test
    public void iterator() {
        arrayList.add(3);
        Iterator<Integer> iterator = arrayList.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenListChangesAfterIteratorIsCreated() {
        arrayList.add(3);
        Iterator<Integer> iterator = arrayList.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        arrayList.add(4);
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
    }
}