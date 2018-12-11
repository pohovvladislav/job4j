package ru.job4j.tracker;

/**
 *
 */
public class TrackerSingle_3 {
    private static final TrackerSingle_3 INSTANCE = new TrackerSingle_3();
    private Tracker tracker = new Tracker();

    private TrackerSingle_3() {
    }

    public static TrackerSingle_3 getInstance() {
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
