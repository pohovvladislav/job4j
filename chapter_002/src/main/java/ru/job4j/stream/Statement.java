package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author В-87
 */
public class Statement {

    /**
     * The method returns a list of students whose certificate score is greater than bound.
     * @param students List of student.
     * @param bound bound.
     * @return A list of students who have a grade point more bound.
     */
    public List<Student> levelOf(List<Student> students, int bound) {
        return students.stream().sorted(new Student()).flatMap(Stream::ofNullable)
                .takeWhile(student -> student.getScope() >  bound).collect(Collectors.toList());
    }
}
