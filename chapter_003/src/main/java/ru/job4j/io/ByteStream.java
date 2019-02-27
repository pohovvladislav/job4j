package ru.job4j.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author В-87
 */
public class ByteStream {

    /**
     * The method checks whether the byte stream contains an even number.
     *
     * @param in Input stream.
     * @return Result.
     * @throws IOException
     */
    public boolean isNumber(InputStream in) throws IOException {
        boolean result = false;
        try (InputStream stream = in) {
            int n;
            while ((n = stream.read()) != -1) {
                if (n == 0 || n % 2 == 0) {
                    result = true;
                }
            }
        }
        return result;
    }
}