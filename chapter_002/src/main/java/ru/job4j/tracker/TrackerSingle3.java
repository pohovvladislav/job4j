package ru.job4j.tracker;

/**
 *
 */
public class TrackerSingle3 {
    private static final TrackerSingle3 INSTANCE = new TrackerSingle3();
    private Tracker tracker = new Tracker();

    private TrackerSingle3() {
    }

    public static TrackerSingle3 getInstance() {
        return INSTANCE;
    }

    public boolean delete(String id) {
        return this.tracker.delete(id);
    }
    public Item add(Item item) {
        return this.tracker.add(item);
    }
    public Item findById(String id) {
        return this.tracker.findById(id);
    }
}
