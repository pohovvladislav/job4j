package ru.job4j.tracker;
/**
 *
 * @version $Id$
 * @since 0.1
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

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
    @Test
    public void whenFindAll() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc", System.currentTimeMillis()));
        Input input = new StubInput(new String[] {"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("name"));
    }
    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc", System.currentTimeMillis()));
        Input input = new StubInput(new String[] {"5", "name", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("name"));
    }
    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc", System.currentTimeMillis()));
        Input input = new StubInput(new String[] {"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("name"));
    }
}
