package ru.job4j.io;

import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DeleteWordsTest {
    @Test
    public void test() throws IOException {
        DeleteWords deleteWords = new DeleteWords();
        String text = "hello ass have are you";
        String text1 = "hello have are you";
        String[] abuse = {"name", "test", "ass"};

        byte[] input = text.getBytes();
        byte[] output = text1.getBytes();

        InputStream stream = new ByteArrayInputStream(input);
        OutputStream outputStream = new ByteArrayOutputStream(output.length);
        outputStream.write(output);
        deleteWords.dropAbuses(stream, outputStream, abuse);
    }
}