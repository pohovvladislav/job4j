package ru.job4j.io;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArgsTest {
    @Test
    public void whenInputTheCommandForArchiveProjectThenRunMainMethod() {
       new Args("java -jar pack.jar -d c:\\project\\job4j\\ -e .java -o project.zip");
    }

}