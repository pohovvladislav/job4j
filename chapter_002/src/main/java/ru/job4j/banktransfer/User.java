package ru.job4j.banktransfer;

import java.util.Objects;

/**
 * The class describes the Bank's customer.
 */
public class User {
    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getPassport() {
        return this.passport;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return this.passport == user.passport && Objects.equals(this.name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.passport);
    }
}
