package ru.job4j.collection.list;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleListTest {

    private SimpleList<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(2), is(1));
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }

    @Test
    public void whenDeleteSecondElementThanUseGetSizeResultTwo() {
        assertThat(list.delete(), is(3));
        assertThat(list.getSize(), is(2));
    }

}
