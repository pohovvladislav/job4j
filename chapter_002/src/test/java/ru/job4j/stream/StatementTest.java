package ru.job4j.stream;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author В-87
 */
public class StatementTest {
    @Test
    public void whenThereIsListOfStudentsThenListOfStudentsWithCertainBound() {
        Statement statement = new Statement();
        List<Student> students = List.of(
                new Student("Юля", 4),
                new Student("Даша", 3),
                new Student("Вася", 5),
                new Student("", 0)
        );
        List<Student> expect = Arrays.asList(students.get(2), students.get(0));
        assertThat(statement.levelOf(students, 3), is(expect));
    }
}