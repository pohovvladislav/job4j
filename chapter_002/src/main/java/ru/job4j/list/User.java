package ru.job4j.list;

import java.util.Objects;

/**
 * The class describes the user.
 */
public class User implements Comparable<User>  {
    private int id;
    private String name;
    private String city;
    private int age;

    public User(int id, String name, int age, String city) {
        this.city = city;
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return this.age;
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

    @Override
    public int compareTo(User o) {
        return Integer.compare(this.age, o.age);
    }
}
