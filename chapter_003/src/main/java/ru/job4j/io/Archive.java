package ru.job4j.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Project archiving.
 */
public class Archive {

    /** Command array. */
    private final String[] args;

    /** Excluded file extension. */
    private String expansion;

    /** Source file. */
    private File source;

    /** Name of the archive folder. */
    private String archiveDir;

    /** List of archived files. */
    private final ArrayList<File> files = new ArrayList<>();

    /**
     * Creating archive.
     *
     * @param instruction instruction.
     */
    private Archive(String instruction) {
        args = convert(instruction);
    }

    /**
     * Converting string instruction to array.
     *
     * @param instruction instruction.
     * @return array.
     */
    private String[] convert(String instruction) {
        return instruction.split(" ");
    }

    /**
     * Parsing an array into commands.
     *
     * @param args array.
     * @return was the method successful.
     */
    private boolean parse(String[] args) {
        int count = 0;
        if (args[3].equals("-d")) {
            source = new File(args[4]);
            count++;
        }
        if (args[5].equals("-e")) {
            expansion = extension(new File(args[6]));
            count++;
        }
        if (args[7].equals("-o")) {
            archiveDir = args[8];
            count++;
        }
        return count == 3;
    }

    /**
     * Creating a list of archived files.
     *
     * @param source source file.
     * @return list files.
     */
    private ArrayList<File> directory(File source) {
        File[] listFiles = source.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    directory(file);
                    continue;
                }
                if (!exclude(file, expansion)) {
                    files.add(file);
                }
            }
        }
        return files;
    }

    /**
     * The definition files are excluded from backup.
     *
     * @param file      file.
     * @param expansion excluded file extension.
     * @return result.
     */
    private boolean exclude(File file, String expansion) {
        return extension(file).equals(expansion);
    }

    /**
     * Writing files to archive.
     *
     * @param files list files.
     */
    private void output(ArrayList<File> files) {
        try (ZipOutputStream stream = new ZipOutputStream(new FileOutputStream(archiveDir))) {
            for (File file : files) {
                try (FileInputStream fis = new FileInputStream(file)) {
                    stream.putNextEntry(new ZipEntry(file.getPath()));
                    stream.write(fis.readAllBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The definition of the file extension.
     *
     * @param file file.
     * @return expansion.
     */
    private String extension(File file) {
        String expansion = file.getName();
        int pos = expansion.lastIndexOf(".");
        if (pos > 0) {
            expansion = expansion.substring(pos);
        }
        return expansion;
    }

    public static void main(String[] args) {
        Archive archive = new Archive("java -jar pack.jar -d c:\\projects\\job4j\\ -e *.java -o projects.zip");
        if (archive.parse(archive.args)) {
            ArrayList<File> directory = archive.directory(archive.source);
            archive.output(directory);
        }
    }
}
