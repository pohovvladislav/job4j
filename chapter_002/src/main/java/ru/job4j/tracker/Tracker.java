package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * The Tracker class contains methods for processing applications.
 */
public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private static final Random RN = new Random();

    /**
     * The method adds a request.
     * @param item new application.
     * @return item.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * The method generates Id.
     * @return Id.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Method of replacing an existing application.
     * @param id ID of the old request.
     * @param item new application.
     */
    public void replace(String id, Item item) {
        for (int index = 0; index != this.items.size(); index++) {
            if (this.items.get(index).getId().equals(id)) {
                this.items.set(index, item);
                item.setId(id);
                break;
            }
        }
    }

    /**
     * Request deletion method.
     * @param id application Id.
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index != this.items.size(); index++) {
            if (this.items.get(index).getId().equals(id)) {
                this.items.remove(index);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * A method of obtaining a list of all applications.
     * @return An array of applications.
     */
    public List<Item> findAll() {
        return this.items.stream().collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    /**
     * Method for creating a list of requisitions with the same name.
     * @param key Name of application.
     * @return Array of applications with the same name.
     */
    public List<Item> findByName(String key) {
        return  this.items.stream().filter(item -> item.getName().equals(key)).collect(Collectors.toList());
    }

    /**
     * The method to find the application ID.
     * @param id Id application.
     * @return Application.
     */
    public Item findById(String id) {
        Item result = null;
        Optional<Item> optionalItem = this.items.stream().filter(item -> item.getId().equals(id)).findFirst();
        if (optionalItem.isPresent()) {
            result = optionalItem.get();
        }
        return result;
    }
}
