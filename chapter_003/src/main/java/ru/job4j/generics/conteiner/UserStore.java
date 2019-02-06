package ru.job4j.generics.conteiner;

import ru.job4j.generics.SimpleArray;

/**
 * Class-storage of users.
 */

public class UserStore extends AbstractStore<User>  {

    public UserStore(SimpleArray<User> simpleArray) {
        super(simpleArray);
    }
}
