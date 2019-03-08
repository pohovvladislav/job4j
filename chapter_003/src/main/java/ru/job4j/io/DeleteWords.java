package ru.job4j.io;


import java.io.*;


/**
 * @author В-87
 */
public class DeleteWords {
    /**
     * The method filters the incoming stream using an array.
     * @param in    InputStream.
     * @param out   OutputStream.
     * @param abuse Array.
     */
    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) {

        try (InputStream input = in;
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out))) {
            StringBuilder builder = new StringBuilder();

            int var;
            boolean flag = true;
            while (flag) {
                var = input.read();
                builder.append((char) var);
                if (var == 32 || var == -1 && builder.length() != 0) {
                    if (var == -1) {
                        flag = false;
                    }
                    String word = builder.deleteCharAt(builder.length() - 1).toString();
                    builder.setLength(0);

                    boolean mark = false;
                    for (String string : abuse) {
                        if (word.equals(string)) {
                            mark = true;
                            break;
                        }
                    }
                    if (!mark) {
                        writer.write(word + " ");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

