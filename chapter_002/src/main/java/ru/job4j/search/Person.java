package ru.job4j.search;

/**
 * Класс описывает объект телефонного справочника.
 */
public class Person {
    private String name;
    private String surname;
    private String address;
    private String phone;

    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
