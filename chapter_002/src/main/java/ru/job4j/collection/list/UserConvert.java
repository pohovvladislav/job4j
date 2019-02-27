package ru.job4j.collection.list;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author В-87.
 */
public class UserConvert {

    /**
     * The method converts List to Map.
     * @param list ArrayList<User>.
     * @return Map<User>.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> map = new HashMap<>();
        list.forEach(element -> map.put(element.getId(), element));
        return map;
    }

    /**
     * The method sorts users by age.
     * @param list List of Users.
     * @return TreeSet Users.
     */
    public TreeSet<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }

    /**
     * The method sorts users by name length.
     * @param list List of Users.
     * @return Sort List.
     */
    public List<User> sortNameLength(List<User> list) {
        List<User> nameLength = new ArrayList<>(list);
        nameLength.sort(Comparator.comparingInt(o -> o.getName().length()));
        return nameLength;
    }

    /**
     * The method sorts users by all fields.
     * @param list List of Users.
     * @return Sort List.
     */
    public List<User> sortByAllFields(List<User> list) {
        List<User> allFields = new ArrayList<>(list);
        allFields.sort(Comparator.comparing(User::getName).thenComparing(User::getAge));
        return allFields;
    }
}
