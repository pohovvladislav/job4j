package ru.job4j.io;

import java.io.File;
import java.util.*;

/**
 * @author В-87
 */
class Search {
    /**
     * The method returns a list of all files with a specific extension.
     *
     * @param parent The  path to the directory from which you want to search.
     * @param exts   File extensions we want to get.
     * @return A list of all files with a specific extension.
     */
    List<File> files(String parent, List<String> exts) {
        List<File> list = new ArrayList<>();
        Queue<File> queue = new LinkedList<>();
        queue.add(new File(parent));
        while (!queue.isEmpty()) {
            distribute(exts, list, queue);
        }
        return list;
    }

    /**
     * The distribution of files by collection.
     *
     * @param exts  File extensions we want to get.
     * @param list  list.
     * @param queue queue.
     */
    private void distribute(List<String> exts, List<File> list, Queue<File> queue) {
        File file = queue.poll();
        if (file != null) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    queue.addAll(Arrays.asList(files));
                }
            } else {
                for (String str : exts) {
                    if (str.equals(this.extension(file))) {
                        list.add(file);
                    }
                }
            }
        }
    }

    /**
     * The method determines the file extension.
     *
     * @param file File.
     * @return File extension.
     */
    String extension(File file) {
        String fileName = file.getName();
        int pos = fileName.lastIndexOf(".");
        if (pos > 0) {
            fileName = fileName.substring(pos);
        }
        return fileName;
    }
}