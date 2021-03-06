package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
        assertThat(tracker.findAll().get(0), is(item));
    }
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    @Test
    public void whenDeletedItemThan() {
        Tracker tracker = new Tracker();
        Item removable = new Item("test", "testDescription", 123L);
        tracker.add(removable);
        Item following = new Item("test1", "testDescription1", 1234L);
        tracker.add(following);
        tracker.delete(removable.getId());
        assertThat(tracker.findById(following.getId()).getName(), is("test1"));
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
        List<Item> result = tracker.findByName("test1");
        List<Item> expect = Arrays.asList(first, third);
        assertThat(result, is(expect));
    }
    @Test
    public void whenFindByIdThenReturnItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test", "Description", 123L);
        tracker.add(item);
        tracker.findById(item.getId());
        assertThat(tracker.findAll().get(0), is(item));
    }
}