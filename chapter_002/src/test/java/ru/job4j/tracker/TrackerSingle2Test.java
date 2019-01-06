package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 */
public class TrackerSingle2Test {
    @Test
    public void whenFindByIdThenReturnItem() {
        TrackerSingle2 trackerSingle2 = TrackerSingle2.getInstance();
        Item item = new Item("test", "Description", 123L);
        trackerSingle2.add(item);
        trackerSingle2.findById(item.getId());
        assertThat(trackerSingle2.findAll().get(0), is(item));
    }
}
