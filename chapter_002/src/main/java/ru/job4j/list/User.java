package ru.job4j.list;

/**
 * The class describes the user.
 */
public class User {
    private int id;
    private String name;
    private String city;

    public User(int id, String name, String city) {
        this.city = city;
        this.id = id;
        this.name = name;
    }

    public String getCity() {
        return this.city;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }
}
