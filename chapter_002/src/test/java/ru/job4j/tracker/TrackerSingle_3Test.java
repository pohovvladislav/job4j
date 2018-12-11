package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 */
public class TrackerSingle_3Test {
    @Test
    public void whenDeletedItemThan() {
        TrackerSingle_3 tracker = TrackerSingle_3.getInstance();
        Item removable = new Item("test", "testDescription", 123L);
        tracker.add(removable);
        Item following = new Item("test1", "testDescription1", 1234L);
        tracker.add(following);
        tracker.delete(removable.getId());
        assertThat(tracker.findById(following.getId()).getName(), is("test1"));
    }
}
