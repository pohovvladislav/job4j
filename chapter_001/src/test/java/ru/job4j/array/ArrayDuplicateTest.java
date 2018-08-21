package ru.job4j.array;
/**
 * @author Popov vladislav (mailto:navodbmd.2@mail.ru).
 */

import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;


public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] check = {"Солнце", "Луна", "Солнце", "Юпитер", "Сатурн", "Луна", "Плутон", "Уран"};
        String[] result = arrayDuplicate.remove(check);
        String[] expect = {"Солнце", "Луна", "Юпитер", "Сатурн", "Плутон", "Уран"};
        assertThat(result, arrayContainingInAnyOrder(expect));
    }
}
