package ru.job4j.tracker;

/**
 *
 */
public class TrackerSingle_4 {
    private Tracker tracker = new Tracker();
    private TrackerSingle_4() {
    }

    public static TrackerSingle_4 getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerSingle_4 INSTANCE = new TrackerSingle_4();
    }

    public Item add(Item item) {
        return this.tracker.add(item);
    }

    public Item[] findByName(String key) {
        return this.tracker.findByName(key);
    }
}
