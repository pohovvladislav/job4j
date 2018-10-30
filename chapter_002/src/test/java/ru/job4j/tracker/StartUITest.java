package ru.job4j.tracker;
/**
 *
 */

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class StartUITest {
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker =  new Tracker();
        Input input = new StubInput(new String[] {"0", "test name", "desk", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desk", System.currentTimeMillis()));
        Input input = new StubInput(new String[] {"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }
    @Test
    public void whenDeleteThanEmptyList() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("name1", "desc", System.currentTimeMillis()));
        Item second = tracker.add(new Item("name2", "desc", System.currentTimeMillis()));
        Input input = new StubInput(new String[] {"3", first.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0], is(second));
    }
}
