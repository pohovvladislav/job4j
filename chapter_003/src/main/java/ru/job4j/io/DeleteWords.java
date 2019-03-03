package ru.job4j.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.Arrays;

/**
 * @author В-87
 */
public class DeleteWords {
    /**
     * The method removes words from the array that are part of the in stream and not part of the out stream.
     * @param in InputStream.
     * @param out OutputStream.
     * @param abuse Array.
     */
    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) {

        try (InputStream input = in;
             OutputStream output = out) {
            StringReader readerOut = new StringReader(output.toString());
            StringBuilder builderIn = new StringBuilder();
            StringBuilder builderOut = new StringBuilder();

            int var;
            while ((var = input.read()) != -1) {
                builderIn.append((char) var);
                if (var == 32) {

                    int outVar;
                    if (builderOut.length() == 0) {
                        while ((outVar = readerOut.read()) != -1) {
                            builderOut.append((char) outVar);
                            if (outVar == 32) {
                                break;
                            }
                        }
                    }
                    if (builderIn.toString().equals(builderOut.toString())) {
                        builderIn.setLength(0);
                        builderOut.setLength(0);
                    } else {
                        String word = builderIn.deleteCharAt(builderIn.length() - 1).toString();
                        for (int i = 0; i < abuse.length; i++) {
                            if (abuse[i].equals(word)) {
                                System.arraycopy(abuse, i + 1, abuse, i, abuse.length - 1 - i);
                                abuse = Arrays.copyOf(abuse, abuse.length - 1);
                                builderIn.setLength(0);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
