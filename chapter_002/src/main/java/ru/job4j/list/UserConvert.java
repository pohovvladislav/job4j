package ru.job4j.list;

import java.util.*;

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
        for (User user : list) {
            map.put(user.getId(), user);
        }
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
        nameLength.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return Integer.compare(o1.getName().length(), o2.getName().length());
                    }
                }
        );
        return nameLength;
    }

    /**
     * The method sorts users by all fields.
     * @param list List of Users.
     * @return Sort List.
     */
    public List<User> sortByAllFields(List<User> list) {
        List<User> allFields = new ArrayList<>(list);
        allFields.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        int rsl = o1.getName().compareTo(o2.getName());
                        return rsl != 0 ? rsl : Integer.compare(o1.getAge(), o2.getAge());
                    }
                }
        );
        return allFields;
    }
}
