package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс реализует телефонный справочник на базе ArrayList.
 */
public class PhoneDictionary {
    List<Person> persons = new ArrayList<>();

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
        List<Person> result = new ArrayList<>();
        for (Person element : persons) {
            if (element.getName().contains(key) || element.getSurname().contains(key)
                    || element.getAddress().contains(key) || element.getPhone().contains(key)) {
                result.add(element);
            }
        }
        return result;
    }
}
