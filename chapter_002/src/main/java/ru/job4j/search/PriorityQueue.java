package ru.job4j.search;

import java.util.LinkedList;

/**
 * The class implements a list of tasks.
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * The method adds the task to the right position.
     * @param task task.
     */
    public void put(Task task) {
        for (int i = 0; i <= tasks.size(); i++) {
            if (tasks.isEmpty() || task.getPriority() < tasks.get(i).getPriority()) {
                tasks.add(i, task);
                break;
            }
            if (task.getPriority() > tasks.getLast().getPriority()) {
                tasks.add(tasks.size(), task);
                break;
            }
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}