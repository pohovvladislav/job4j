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

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    Tracker tracker = new Tracker();
    private final Item first = tracker.add(new Item("test name", "desk", System.currentTimeMillis()));
    private final Item second = tracker.add(new Item("test name_1", "desk_1", System.currentTimeMillis()));
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final String menu =
              "0 : Создание новой заявки." + System.lineSeparator()
            + "1 : Список созданных заявок." + System.lineSeparator()
            + "2 : Изменить заявку." + System.lineSeparator()
            + "3 : Удаление заявки." + System.lineSeparator()
            + "4 : Найти заявку по ID." + System.lineSeparator()
            + "5 : Найти заявку по имени." + System.lineSeparator()
            + "6 : Выход." + System.lineSeparator();

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
        Input input = new StubInput(new String[] {"0", "test name", "desk", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Input input = new StubInput(new String[] {"2", first.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(first.getId()).getName(), is("test replace"));
    }
    @Test
    public void whenDeleteThanEmptyList() {
        Input input = new StubInput(new String[] {"3", first.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0], is(second));
    }
    @Test
    public void whenFindAll() {
        Input input = new StubInput(new String[] {"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(this.out.toString(), is(
                menu
                        + "---------- Список заявок : ---------- " + System.lineSeparator()
                        + "Имя            Описание            Дата создания" + System.lineSeparator()
                        + "------------------------------------------------------" + System.lineSeparator()
                        + "test name      desk                " + this.first.getCreated()  + System.lineSeparator()
                        + "test name_     desk_1              " + this.second.getCreated() + System.lineSeparator()
                        + "------------------------------------------------------" + System.lineSeparator()
                        + menu
                )
        );
    }

    @Test
    public void whenFindByName() {
        Input input = new StubInput(new String[] {"5", "test name_1", "6"});
        new StartUI(input, tracker).init();
        assertThat(this.out.toString(), is(
                menu
                        + "---------- Список заявок : ---------- " + System.lineSeparator()
                        + "Имя            Описание            Дата создания" + System.lineSeparator()
                        + "------------------------------------------------------" + System.lineSeparator()
                        + "test name_     desk_1              " + this.second.getCreated() + System.lineSeparator()
                        + "------------------------------------------------------" + System.lineSeparator()
                        + menu
                )
        );
    }
    @Test
    public void whenFindById() {
        Input input = new StubInput(new String[] {"4", second.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[1].getName(), is("test name_1"));
    }
}
