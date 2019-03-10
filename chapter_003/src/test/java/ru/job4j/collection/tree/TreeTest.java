package ru.job4j.collection.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TreeTest {
    private Tree<Integer> tree;

    @Before
    public void beforeTest() {
        tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
    }

    @Test
    public void when6ElFindLastThen6() {
        assertThat(tree.findBy(6).isPresent(), is(true));
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        assertThat(tree.findBy(7).isPresent(), is(false));
    }

    @Test
    public void whenRunIterator() {
        Iterator<Integer> iterator = tree.iterator();
        assertTrue(iterator.hasNext());
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(1));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(2));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(3));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(4));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(5));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(6));
        assertFalse(iterator.hasNext());
    }

    @Test
    public void whenTreeIsNotBinary() {
        assertFalse(tree.isBinary());
    }

    @Test
    public void whenTreeIsBinary() {
        Tree<Integer> tree1 = new Tree<>(8);
        tree1.add(8, 9);
        tree1.add(8, 10);
        tree1.add(9, 11);
        tree1.add(10, 12);
        assertTrue(tree1.isBinary());
    }
}

