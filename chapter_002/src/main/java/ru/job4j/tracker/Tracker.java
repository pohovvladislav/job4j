package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;
/**
 * The Tracker class contains methods for processing applications.
 */
public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * The method adds a request.
     * @param item new application.
     * @return item.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
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
        for (int index = 0; index != this.position; index++) {
            if (items[index].getId().equals(id)) {
                this.items[index] = item;
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
        for (int index = 0; index != this.position; index++) {
            if (this.items[index].getId().equals(id)) {
                System.arraycopy(this.items, index + 1, this.items, index, this.items.length - index - 1);
                this.position--;
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
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    /**
     * Method for creating a list of requisitions with the same name.
     * @param key Name of application.
     * @return Array of applications with the same name.
     */
    public Item[]  findByName(String key) {
        int count = 0;
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            if (this.items[index].getName().equals(key)) {
                result[count] = this.items[index];
                count++;
            }
        }
        return Arrays.copyOf(result, count);
    }

    /**
     * The method to find the application ID.
     * @param id Id application.
     * @return Application.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}
