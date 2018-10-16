package ru.job4j.tracker;

/**
 * Class formation filings.
 */
public class Item {
    public String name;
    public String description;
    private String Id;
    public String comments;
    public long created;


    public Item() {
    }
    public Item(String name, String description, long created) {
        this.name = name;
        this.description = description;
        this.created = created;
    }
    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }
    public String getId() {
        return this.Id;
    }
    public void setId(String Id) {
        this.Id = Id;
    }
    public String getComments() {
        return this.comments;
    }
    public long getCreated() {
        return this.created;
    }
}
