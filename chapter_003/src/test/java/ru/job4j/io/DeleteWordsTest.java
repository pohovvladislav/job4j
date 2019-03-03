package ru.job4j.io;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class DeleteWordsTest {
    @Test
    public void when() throws IOException {
        DeleteWords deleteWords = new DeleteWords();
        String text = "hello ass have are you";
        String text1 = "hello have are you";
        String[] abuse = {"name", "test", "ass"};

        byte[] array = text.getBytes();
        byte[] a = text1.getBytes();
        InputStream stream = new ByteArrayInputStream(array);
        OutputStream outputStream = new ByteArrayOutputStream(a.length);
        outputStream.write(a);
        deleteWords.dropAbuses(stream, outputStream, abuse);


    }

}