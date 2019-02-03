package ru.job4j.generics.conteiner;

import ru.job4j.generics.SimpleArray;

/**
 * @author В-87
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> simpleArray;

    public AbstractStore(SimpleArray<T> simpleArray) {
        this.simpleArray = simpleArray;
    }

    @Override
    public void add(T model) {
        this.simpleArray.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        int count = 0;
        for (T t : this.simpleArray) {
            if (id.equals(t.getId())) {
                this.simpleArray.set(count, model);
                result = true;
                break;
            }
            count++;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        int count = 0;
        for (T t : this.simpleArray) {
            if (id.equals(t.getId())) {
                this.simpleArray.remove(count);
                result = true;
                break;
            }
            count++;
        }
        return result;
    }

    @Override
    public T findById(String id) {
        T value = null;
        int count = 0;
        for (T t : this.simpleArray) {
            if (id.equals(t.getId())) {
                value = this.simpleArray.get(count);
                break;
            }
            count++;
        }
        return value;
    }
}
