package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 */
public class TrackerSingle1Test {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        TrackerSingle1 trackerSingle1 = TrackerSingle1.INSTANCE;
        Item item = new Item("test1", "testDescription", 123L);
        trackerSingle1.add(item);
        assertThat(trackerSingle1.findAll()[0], is(item));
    }
}
