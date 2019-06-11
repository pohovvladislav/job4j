package ru.job4j.io;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.Assert.*;

public class ByteStreamTest {
    @Test
    public void when() throws IOException {
        ByteStream byteStream = new ByteStream();
        byte[] arr = {1, 3, 5, 7, 12};
        ByteArrayInputStream inputStream = new ByteArrayInputStream(arr);
        assertTrue(byteStream.isNumber(inputStream));
    }
}