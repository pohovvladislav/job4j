package ru.job4j.search;

import java.util.LinkedList;

/**
 *
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     *
     * @param task
     */
    public void put(Task task) {
        int count = 0;
        tasks.add(count, task);
        count++;
        for (int j = 1; j < tasks.size(); j++) {
            for (int i = 0; i < tasks.size() - j; i++) {
                Task rst = tasks.get(i);
                if (tasks.get(i + 1).getPriority() < tasks.get(i).getPriority()) {
                    tasks.set(i, tasks.get(i + 1));
                    tasks.set(i + 1, rst);
                }
            }
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}