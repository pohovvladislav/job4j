package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 */
public class TrackerSingle_1Test {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        TrackerSingle_1 trackerSingle_1 = TrackerSingle_1.INSTANCE;
        Item item = new Item("test1", "testDescription", 123L);
        trackerSingle_1.add(item);
        assertThat(trackerSingle_1.findAll()[0], is(item));
    }
}
