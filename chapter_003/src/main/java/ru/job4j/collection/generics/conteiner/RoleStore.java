package ru.job4j.collection.generics.conteiner;

import ru.job4j.collection.generics.SimpleArray;

/**
 * Class-storage of roles.
 */
public class RoleStore extends AbstractStore<Role> {

    public RoleStore(SimpleArray<Role> simpleArray) {
        super(simpleArray);
    }
}
