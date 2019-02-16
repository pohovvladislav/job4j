package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleStackTest {
    private SimpleStack<Integer> stack;

    @Before
    public void beforeTest() {
        stack = new SimpleStack<>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
    }


    @Test
    public void pushOrPop() {
        stack.push(1);
        assertThat(stack.pop(), is(1));
        assertThat(stack.pop(), is(2));
        assertThat(stack.pop(), is(3));
        assertThat(stack.pop(), is(4));
        assertThat(stack.isEmpty(), is(false));
        assertThat(stack.pop(), is(5));
        assertThat(stack.isEmpty(), is(true));
    }

}