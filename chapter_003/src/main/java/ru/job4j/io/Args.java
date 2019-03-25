package ru.job4j.io;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Project archiving.
 */
public class Args {
    private ZipOutputStream zout;
    private File dir;
    private String expansion;

    /**
     * Constructor.
     *
     * @param args command line.
     */
    public Args(String args) {
        main(convertStringToArray(args));
    }

    /**
     * Convert a string into an array.
     *
     * @param str line.
     * @return array of string.
     */
    private String[] convertStringToArray(String str) {
        return str.split(" ");
    }

    /**
     * Initializing class fields, starting the archiver.
     *
     * @param args array of string.
     */
    public void main(String[] args) {
        int count = 0;
        if (args[3].equals("-d") && 5 <= args.length) {
            dir = new File(args[4]);
            count++;
        }
        if (args[5].equals("-e") && !args[6].equals("-o") && args.length >= 8) {
            expansion = args[6];
            count++;
        }
        if (args[7].equals("-o") && args.length >= 9) {
            if (extension(new File(args[8])).equals(".zip")) {
                createOutputStream(args[8]);
                count++;
            }
        }
        if (count == 3) {
            directory();
        }
    }

    /**
     * Creating output streams.
     *
     * @param s arg.
     */
    private void createOutputStream(String s) {
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (fout != null) {
            zout = new ZipOutputStream(fout);
            directory();
        }
    }

    /**
     * Unpacks the specified directory and sends the files for writing.
     */
    private void directory() {
        if (dir.isDirectory()) {
            File[] directory = dir.listFiles();
            for (File file : directory) {
                if (file.isDirectory()) {
                    directory();
                }
                try {
                    zout.putNextEntry(new ZipEntry(file.getPath()));
                    output(exclude(file, expansion));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Exclude files with the specified extension.
     *
     * @param file      file.
     * @param expansion expansion.
     * @return the file has an extension other than the specified.
     */
    private File exclude(File file, String expansion) {
        File result = null;
        if (!extension(file).equals(expansion)) {
            result = file;
        }
        return result;
    }

    /**
     * @param file file.
     * @throws FileNotFoundException exception.
     */
    private void output(File file) throws FileNotFoundException {
        if (file != null) {
            FileInputStream fis = new FileInputStream(file);
            try {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = fis.read(buffer)) != -1) {
                    zout.write(buffer, 0, length);
                    zout.closeEntry();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * The definition of the file extension.
     *
     * @param file file.
     * @return expansion.
     */
    private String extension(File file) {
        String expan = file.getName();
        int pos = expan.lastIndexOf(".");
        if (pos > 0) {
            expan = expan.substring(pos);
        }
        return expan;
    }
}
