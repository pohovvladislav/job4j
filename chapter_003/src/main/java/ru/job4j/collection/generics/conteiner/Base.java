package ru.job4j.collection.generics.conteiner;

public abstract class Base {
    private final String id;

    protected Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}
