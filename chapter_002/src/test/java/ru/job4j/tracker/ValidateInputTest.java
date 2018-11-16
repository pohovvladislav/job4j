package ru.job4j.tracker;
/**
 *@version $Id$
 *@since 0.1
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class ValidateInputTest {

    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(new StubInput(new String[] {"invalid", "2"}));
        input.ask("Enter", new ArrayList<>(Collections.singleton(2)));
        assertThat(this.mem.toString(), is(String.format("Пожалуйста, введите номер пункта из списка.%n")));
    }
    @Test
    public void whenNumberOutList() {
        ArrayList<Integer> range = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            range.add(i);
        }
        ValidateInput input = new ValidateInput(new StubInput(new String[] {"12", "1"}));
        input.ask("Enter", range);
        assertThat(this.mem.toString(), is(String.format("Пожалуйста, выберите пункт меню!%n")));
    }
}