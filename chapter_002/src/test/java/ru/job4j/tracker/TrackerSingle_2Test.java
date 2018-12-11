package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 */
public class TrackerSingle_2Test {
    @Test
    public void whenFindByIdThenReturnItem() {
        TrackerSingle_2 trackerSingle_2 = TrackerSingle_2.getInstance();
        Item item = new Item("test", "Description", 123L);
        trackerSingle_2.add(item);
        trackerSingle_2.findById(item.getId());
        assertThat(trackerSingle_2.findAll()[0], is(item));
    }
}
