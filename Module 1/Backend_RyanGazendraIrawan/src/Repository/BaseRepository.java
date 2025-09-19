package Repository;

import java.util.*;

abstract class BaseRepository<T, ID> {
    public HashMap<ID, T>Map;
    protected ArrayList<T>List;

    public T findById(ID id) {

    }

    public void findAll() {

    }

    public abstract void save(T entity);
    public abstract ID getId(T entity;)

}