package ru.job4j.stream;

import java.util.Comparator;

/**
 * @author В-87
 */
public class Student implements Comparator<Student> {
    private String name;
    private int scope;

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }
    public Student() {

    }

    public String getName() {
        return name;
    }

    public int getScope() {
        return scope;
    }


    @Override
    public int compare(Student o1, Student o2) {
        return o2.scope - o1.scope;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", scope=" + scope + '}';
    }
}
