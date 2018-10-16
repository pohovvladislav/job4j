package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test methods of the class Tracker.
 */
public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    @Test
    public void whenDeletedItemThan() {
        Tracker tracker = new Tracker();
        Item removable = new Item("test", "Description", 123L);
        tracker.add(removable);
        Item following = new Item("test1", "Description1", 1234L);
        tracker.add(following);
        tracker.delete(removable.getId());
        assertThat(tracker.findAll()[0], is(following));
    }
    @Test
    public void whenFindAllThenReturnItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test", "Description", 123L);
        tracker.add(item);
        tracker.findAll();
        assertThat(tracker.findById(item.getId()).getName(), is("test"));
    }
    @Test
    public void whenFindByNameThanArrayItem() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "Description", 123L);
        tracker.add(first);
        Item second = new Item("test2", "Description2", 1234L);
        tracker.add(second);
        Item third = new Item("test1", "Description3", 12345L);
        tracker.add(third);
        Item[] result = tracker.findByName("test1");
        Item[] expect = new Item[] {first, third};
        assertThat(result, is(expect));
    }
    @Test
    public void whenFindByIdThenReturnItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test", "Description", 123L);
        tracker.add(item);
        tracker.findById(item.getId());
        assertThat(tracker.findAll()[0], is(item));
    }
}