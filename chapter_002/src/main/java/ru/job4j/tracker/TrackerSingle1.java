package ru.job4j.tracker;

/**
 *
 */
public enum TrackerSingle1 {
    INSTANCE;
    private Tracker tracker = new Tracker();

    public Item add(Item item) {
        return this.tracker.add(item);
    }

    public Item[] findAll() {
        return this.tracker.findAll();
    }
}
