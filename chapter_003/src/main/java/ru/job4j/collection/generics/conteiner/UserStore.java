package ru.job4j.collection.generics.conteiner;

import ru.job4j.collection.generics.SimpleArray;

/**
 * Class-storage of users.
 */

public class UserStore extends AbstractStore<User>  {

    public UserStore(SimpleArray<User> simpleArray) {
        super(simpleArray);
    }
}
