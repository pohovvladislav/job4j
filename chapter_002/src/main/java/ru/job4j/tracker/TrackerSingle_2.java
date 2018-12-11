package ru.job4j.tracker;

/**
 *
 */
public class TrackerSingle_2 {
    private static TrackerSingle_2 instance;
    private Tracker tracker = new Tracker();

    private TrackerSingle_2() {
    }

    public static TrackerSingle_2 getInstance() {
        if (instance == null) {
            instance = new TrackerSingle_2();
        }
        return instance;
    }

    public Item findById(String id) {
        return this.tracker.findById(id);
    }

    public Item add(Item item) {
        return this.tracker.add(item);
    }

    public Item[] findAll() {
        return this.tracker.findAll();
    }
}
