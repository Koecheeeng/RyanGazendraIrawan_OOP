package Repository;

import java.util.*;

public abstract class BaseRepository<T, ID> {
    protected Map<ID, T> dataMap = new HashMap<>();
    protected List<T> allData = new ArrayList<>();

    public Optional<T> findById(ID id) {
        return Optional.ofNullable(dataMap.get(id));
    }

    public List<T> findAll() {
        return new ArrayList<>(allData);
    }

    public void save(T entity) {
        ID id = getId(entity);
        dataMap.put(id, entity);
        if (!allData.contains(entity)) {
            allData.add(entity);
        }
    }

    public void deleteById(ID id) {
        T entity = dataMap.remove(id);
        if (entity != null) {
            allData.remove(entity);
        }
    }

    protected abstract ID getId(T entity);
}
