package ru.job4j.io;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author В-87
 */
public class Search {
    /**
     * The method returns a list of all files with a specific extension.
     *
     * @param parent The  path to the directory from which you want to search.
     * @param exts   File extensions we want to get.
     * @return A list of all files with a specific extension.
     */
    public List<File> files(String parent, List<String> exts) {
        List<File> list = new ArrayList<>();
        Queue<File> queue = new LinkedList<>();
        queue.add(new File(parent));
        while (!queue.isEmpty()) {
            File poll = queue.poll();
            if (poll.isDirectory()) {
                queue.addAll(Arrays.stream(poll.listFiles()).collect(Collectors.toList()));
            } else {
                for (String str : exts) {
                    if (str.equals(this.extension(poll))) {
                        list.add(poll);
                    }
                }
            }
        }
        return list;
    }

    /**
     * The method determines the file extension.
     *
     * @param file File.
     * @return File extension.
     */
    public String extension(File file) {
        String fileName = file.getName();
        int pos = fileName.lastIndexOf(".");
        if (pos > 0) {
            fileName = fileName.substring(pos);
        }
        return fileName;
    }
}