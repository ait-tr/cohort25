package repositories;

import java.util.Optional;

// Create, Read, Update, Delete
public interface CrudRepository<T> {
    void save(T model);
    T findById(String id);
}
