package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс реализует телефонный справочник на базе ArrayList.
 */
public class PhoneDictionary {
   private List<Person> persons = new ArrayList<>();

    /**
     * Метод создания объекта.
     * @param person Объект.
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Метод поиска объекта по ключу.
     * @param key строка входящая в описание объекта.
     * @return Объекты поиска.
     */
    public List<Person> find(String key) {
        return persons.stream().filter(person -> person.getName().contains(key)
                || person.getSurname().contains(key) || person.getAddress().contains(key)
                || person.getPhone().contains(key)).collect(Collectors.toList()
        );
    }
}
