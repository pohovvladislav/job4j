package ru.job4j.io;

import java.io.*;
import java.util.Arrays;

/**
 *
 */
public class DeleteWords {

    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) {

        try (InputStreamReader input = new InputStreamReader(in);
             OutputStreamWriter output = new OutputStreamWriter(out)) {

            StringBuilder builder = new StringBuilder();

            int var;
            while ((var =  input.read()) != -1) {

                System.out.println((char) var);


            }


            System.out.println(output.toString());


        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
