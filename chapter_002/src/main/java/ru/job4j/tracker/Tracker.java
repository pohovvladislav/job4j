package ru.job4j.tracker;
import java.lang.reflect.Array;
import java.util.*;
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
     * @param Id ID of the old request.
     * @param item new application.
     */
    public void replace(String Id, Item item) {
        for (int index = 0; index != this.position; index++) {
            if (items[index].getId().equals(Id)) {
                this.items[index] = item;
                item.setId(Id);
                break;
            }
        }
    }

    /**
     * Request deletion method.
     * @param Id application Id.
     */
    public void delete(String Id) {
        for (int index = 0; index != this.position; index++) {
            if (this.items[index].getId().equals(Id)) {
                this.items[index] = null;
                }
                if (this.items[index] == null) {
                  this.items[index] = items[index + 1];
                System.arraycopy(this.items, 0, items, 0, 100);
            }
        }
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
    public Item[] findByName(String key) {
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
     * @param Id Id application.
     * @return Application.
     */
    public Item findById(String Id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(Id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}
