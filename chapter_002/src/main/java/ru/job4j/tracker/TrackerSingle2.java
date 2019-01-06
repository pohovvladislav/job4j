package ru.job4j.tracker;

import java.util.List;

/**
 *
 */
public class TrackerSingle2 {
    private static TrackerSingle2 instance;
    private Tracker tracker = new Tracker();

    private TrackerSingle2() {
    }

    public static TrackerSingle2 getInstance() {
        if (instance == null) {
            instance = new TrackerSingle2();
        }
        return instance;
    }

    public Item findById(String id) {
        return this.tracker.findById(id);
    }

    public Item add(Item item) {
        return this.tracker.add(item);
    }

    public List<Item> findAll() {
        return this.tracker.findAll();
    }
}
