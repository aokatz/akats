package ru.job4j.generic;

/**
 * Abstract Store class
 *
 * @param <T> - type of store extends Base class
 * @author AKats
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> store = new SimpleArray<>();

    @Override
    public void add(T model) {
        this.store.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean res = false;
        int index = 0;
        for (T i : store
                ) {
            if (i.getId().equals(id)) {
                res = true;
                break;
            }
            ++index;
        }
        if (res) {
            store.set(index, model);
        }
        return res;
    }

    @Override
    public boolean delete(String id) {
        boolean res = false;
        int index = 0;
        for (T i : store
                ) {
            if (i.getId().equals(id)) {
                store.delete(index);
                res = true;
            }
            ++index;
        }
        return res;
    }

    @Override
    public T findById(String id) {
        T res = null;
        for (T i : store
                ) {
            if (i.getId().equals(id)) {
                res = i;
            }
        }
        return res;
    }
}
