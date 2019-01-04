package ru.job4j.tracker;
/**
 *
 * @version $Id$
 * @since 0.1
 */

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private Tracker tracker = new Tracker();
    private final Item first = this.tracker.add(new Item("test name", "desk", System.currentTimeMillis()));
    private final Item second = this.tracker.add(new Item("test name_1", "desk_1", System.currentTimeMillis()));
    private final String menu =
            "0 : Создание новой заявки." + System.lineSeparator()
                    + "1 : Список созданных заявок." + System.lineSeparator()
                    + "2 : Изменить заявку." + System.lineSeparator()
                    + "3 : Удаление заявки." + System.lineSeparator()
                    + "4 : Найти заявку по ID." + System.lineSeparator()
                    + "5 : Найти заявку по имени." + System.lineSeparator()
                    + "6 : Выход." + System.lineSeparator();
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }

        @Override
        public String toString() {
            return out.toString();
        }
    };


    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        System.setOut(new PrintStream(out));
        new StartUI(new StubInput(new String[] {"0", "test name", "desk", "6"}), this.tracker, this.output).init();
        assertThat(this.output.toString(), is(this.menu + "Новая заявка с ID "
                + this.tracker.findAll()[2].getId() + System.lineSeparator() + this.menu));
    }
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        System.setOut(new PrintStream(out));
        new StartUI(new StubInput(new String[] {"2", this.first.getId(), "test replace", "заменили заявку", "6"}),
                this.tracker, this.output).init();
        assertThat(this.output.toString(), is(this.menu + "Заявка успешно изменена." + System.lineSeparator() + this.menu));
    }
    @Test
    public void whenDeleteThanEmptyList() {
        System.setOut(new PrintStream(out));
        new StartUI(new StubInput(new String[] {"3", this.first.getId(), "6"}), this.tracker, this.output).init();
        assertThat(this.output.toString(), is(this.menu + "Заявка успешно удалена." + System.lineSeparator() + this.menu));
    }
    @Test
    public void whenFindAll() {
        System.setOut(new PrintStream(out));
        new StartUI(new StubInput(new String[] {"1", "6"}), this.tracker, this.output).init();
        assertThat(this.output.toString(), is(this.menu + "Name: test name| Desc: desk| Id: " + this.first.getId()
                + System.lineSeparator() + "Name: test name_1| Desc: desk_1| Id: " + this.second.getId()
                + System.lineSeparator() + this.menu));
    }

    @Test
    public void whenFindByName() {
        System.setOut(new PrintStream(out));
        new StartUI(new StubInput(new String[] {"5", "test name_1", "6"}), this.tracker, this.output).init();
        assertThat(this.output.toString(), is(this.menu + "Name: test name_1| Desc: desk_1| Id: "
        + this.second.getId() + System.lineSeparator() + this.menu));
    }


    @Test
    public void whenFindById() {
        System.setOut(new PrintStream(out));
        new StartUI(new StubInput(new String[] {"4", this.second.getId(), "6"}), this.tracker, this.output).init();
        assertThat(this.output.toString(), is(this.menu + "Name: test name_1| Desc: desk_1| Id: "
                + this.second.getId() + System.lineSeparator() + this.menu));
    }
}
