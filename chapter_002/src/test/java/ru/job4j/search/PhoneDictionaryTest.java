package ru.job4j.search;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тест программы : Телефонный справочник.
 */
public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Ivan", "Petrov", "44-33-22", "Vihyholevo")
        );
        List<Person> persons = phones.find("22");
        assertThat(persons.iterator().next().getSurname(), is("Petrov"));
    }
}
