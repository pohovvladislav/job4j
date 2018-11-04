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
                "Меню.\r\n"
                        + "0. Создание новой заявки.\r\n"
                        + "1. Список созданных заявок.\r\n"
                        + "2. Изменить заявку.\r\n"
                        + "3. Удаление заявки.\r\n"
                        + "4. Найти заявку по ID.\r\n"
                        + "5. Найти заявку по имени.\r\n"
                        + "6. Выход.\r\n"
                        + "---------- Список заявок : ---------- \r\n"
                        + "Имя            Описание            Дата создания\r\n"
                        + "------------------------------------------------------\r\n"
                        + "test name      desk                " + this.first.getCreated() + "\r\n"
                        + "test name_     desk_1              " + this.second.getCreated() + "\r\n"
                        + "------------------------------------------------------\r\n"
                        + "Меню.\r\n"
                        + "0. Создание новой заявки.\r\n"
                        + "1. Список созданных заявок.\r\n"
                        + "2. Изменить заявку.\r\n"
                        + "3. Удаление заявки.\r\n"
                        + "4. Найти заявку по ID.\r\n"
                        + "5. Найти заявку по имени.\r\n"
                        + "6. Выход.\r\n"
                )
        );
    }

    @Test
    public void whenFindByName() {
        Input input = new StubInput(new String[] {"5", "test name_1", "6"});
        new StartUI(input, tracker).init();
        assertThat(this.out.toString(), is(
                "Меню.\r\n"
                        + "0. Создание новой заявки.\r\n"
                        + "1. Список созданных заявок.\r\n"
                        + "2. Изменить заявку.\r\n"
                        + "3. Удаление заявки.\r\n"
                        + "4. Найти заявку по ID.\r\n"
                        + "5. Найти заявку по имени.\r\n"
                        + "6. Выход.\r\n"
                        + "---------- Список заявок : ---------- \r\n"
                        + "Имя            Описание            Дата создания\r\n"
                        + "------------------------------------------------------\r\n"
                        + "test name_     desk_1              " + this.second.getCreated() + "\r\n"
                        + "------------------------------------------------------\r\n"
                        + "Меню.\r\n"
                        + "0. Создание новой заявки.\r\n"
                        + "1. Список созданных заявок.\r\n"
                        + "2. Изменить заявку.\r\n"
                        + "3. Удаление заявки.\r\n"
                        + "4. Найти заявку по ID.\r\n"
                        + "5. Найти заявку по имени.\r\n"
                        + "6. Выход.\r\n"
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
