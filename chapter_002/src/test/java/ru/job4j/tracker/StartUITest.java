package ru.job4j.tracker;
/**
 *
 * @version $Id$
 * @since 0.1
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private Tracker tracker = new Tracker();
    private final Item first = tracker.add(new Item("test name", "desk", System.currentTimeMillis()));
    private final Item second = tracker.add(new Item("test name_1", "desk_1", System.currentTimeMillis()));

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };


    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        //Input input = new StubInput(new String[] {"0", "test name", "desk", "6"});
        new StartUI(new StubInput(new String[] {"0", "test name", "desk", "6"}), tracker, output).init();
        assertThat(this.output.toString(), is("test name"));
    }
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Input input = new StubInput(new String[] {"2", first.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findById(first.getId()).getName(), is("test replace"));
    }
    @Test
    public void whenDeleteThanEmptyList() {
        Input input = new StubInput(new String[] {"3", first.getId(), "6"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findAll()[0], is(second));
    }
    @Test
    public void whenFindAll() {
        //Input input = new StubInput(new String[] {"1", "6"});
        new StartUI(new StubInput(new String[] {"1", "6"}), tracker, output).init();
        assertThat(this.output.toString(), is(""));
    }

    @Test
    public void whenFindByName() {
        //Input input = new StubInput(new String[] {"5", "test name_1", "6"});
        new StartUI(new StubInput(new String[] {"5", "test name_1", "6"}), tracker, output).init();
        assertThat(this.output.toString(), is(tracker.findByName("test name_1")));
    }


    @Test
    public void whenFindById() {
        //Input input = new StubInput(new String[] {"4", second.getId(), "6"});
        new StartUI(new StubInput(new String[] {"4", second.getId(), "6"}), tracker, output).init();
        assertThat(this.output.toString(), is("test name_1"));
    }
}
