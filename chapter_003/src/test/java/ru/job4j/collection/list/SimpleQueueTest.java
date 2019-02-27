package ru.job4j.collection.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleQueueTest {
    private SimpleQueue<Integer> queue;

    @Before
    public void beforeTest() {
        queue = new SimpleQueue<>();
    }

    @Test
    public void pushOrPoll() {
        queue.push(1);
        assertThat(queue.poll(), is(1));
        queue.push(2);
        queue.push(3);
        queue.push(4);
        assertThat(queue.poll(), is(2));
        assertThat(queue.poll(), is(3));
        queue.push(5);
        queue.push(6);
        assertThat(queue.poll(), is(4));
        assertThat(queue.poll(), is(5));
        assertThat(queue.poll(), is(6));
    }
}