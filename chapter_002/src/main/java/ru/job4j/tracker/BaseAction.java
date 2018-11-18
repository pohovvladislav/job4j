package ru.job4j.tracker;

/**
 * Класс частично реализует интерфейс UserAction.
 * Служит для замены методов key() и info() в классе MenuTracker.
 */
abstract class BaseAction implements UserAction {
    private final int key;
    private final String name;

    protected BaseAction(final int key, final String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return String.format("%s : %s", this.key, this.name);
    }
}
